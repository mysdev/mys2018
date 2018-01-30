var myPage;
var viewMode;
var query = {};
query.pageNo=1;
query.pageSize = 20;
if(getQueryString('page')!=undefined){
	query.pageNo=getQueryString('page');
}

function Node(obj) {
	this.classId = ko.observable(obj.classId); 
	this.className = ko.observable(obj.className); 
	this.status = ko.observable(obj.status); 
	this.clockFlag = ko.observable(obj.clockFlag); 
	this.flag = ko.observable(obj.flag); 
	this.types = ko.observable(obj.types); 
	this.isPriority = ko.observable(obj.isPriority); 
	this.priorityAccumulate = ko.observable(obj.priorityAccumulate); 
	this.arriveWarn = ko.observable(obj.arriveWarn); 
	this.arriveRemind = ko.observable(obj.arriveRemind); 
	this.createdBy = ko.observable(obj.createdBy); 
	this.createdDate = ko.observable(obj.createdDate); 
	this.updatedBy = ko.observable(obj.updatedBy); 
	this.updatedDate = ko.observable(obj.updatedDate); 
}


//定义ViewModel对象
var SkillClassViewModel = function () {  
	self=this;
    //添加动态监视数组对象
    self.skillClassList = ko.observableArray([]);
    
    //重载数据
    self.reloadData = function(){
    	myAjax("/skillclasss", "GET", query, function (data){
			var mappedTasks = $.map(data.data, function(item) { return new Node(item) });  
			self.skillClassList(mappedTasks);
			myPage = data.page;
			bindPage();
			    
			$("table tbody td .tomodify").bind(function(){
				ChangeUrl('./clock/SkillClass.html?action=Edit&id='+$(this).attr('data'));
			});
		}, true);
    };
    
    	
    //初始化数据--如何调用self.reloadData
    self.reloadData();
	
	//搜索
	self.search = function(obj) {
		query.pageNo=1;
		query.pageSize = 20;
		qeury.keyWord = $("txtKeywords").val(); //查询参数格式
		myAjax("/skillclasss", "GET", query, doQueryActionSuccess, true);
    };
    
    //新增
    self.add = function(obj) {
    	ChangeUrl('./clock/SkillClass.html?action=Add');
    };
    
    //修改
    self.modify=function(obj){
    	ChangeUrl('./clock/SkillClass.html?action=Edit&id='+obj.classId());
    };
    
    //删除
    self.delete=function(obj){
    	parent.dialog({
            title: '提示',
            content: '确定要删除该记录！',
            okValue: '确定',
            ok: function () {
		    	var id = $(event.currentTarget).attr('data');
		    	myAjax("/skillclass/"+id, "DELETE", null, reloadDate, false);
			}
        }).showModal();
    }
    
    //批量删除
    self.deletes = function(obj) {
    	if ($(".checkall input:checked").size() < 1) {
        	parent.dialog({
	            title: '提示',
	            content: '对不起，请选中您要操作的记录！',
	            okValue: '确定',
	            ok: function () { }
	        }).showModal();
	        return false;
	    }
	    var msg = "删除记录后不可恢复，您确定吗？";
	    parent.dialog({
	        title: '提示',
	        content: msg,
	        okValue: '确定',
	        ok: function () {
	        	$(".checkall input:checked").each(function(i){
	        		myAjax("/skillclass/"+id, "DELETE", null, null, false);
	        	});
	        	location.reload();
	        },
	        cancelValue: '取消',
	        cancel: function () { }
	    }).showModal();
    };

};

$().ready(function(){
	viewMode = new SkillClassViewModel();
    ko.applyBindings(viewMode);
});

var bindPage =function(){
	//分页控件加载处理
    $.jqPaginator('#pagination', {
        totalPages: myPage.totalPages,
        visiblePages: myPage.limit,
        currentPage: myPage.page,
        onPageChange: function (num, type) {
        	if(query.pageNo!=num){
        		query.pageNo=num;
        		viewMode.reloadData();
        	}  
//            if (type != 'init') {
//            	ChangeUrl('./clock/SkillClassList.html?page=' + num);
//            }
        }
    });
}

