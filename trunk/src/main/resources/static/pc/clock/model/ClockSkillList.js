var myPage;
var query = {};
query.pageNo=1;
query.pageSize = 20;
if(getQueryString('page')!=undefined){
	query.pageNo=getQueryString('page');
}

function Node(obj) {
	this.skillId = ko.observable(obj.skillId); 
	this.skillName = ko.observable(obj.skillName); 
	this.materialId = ko.observable(obj.materialId); 
	this.isClock = ko.observable(obj.isClock); 
	this.classs = ko.observable(obj.classs); 
	this.status = ko.observable(obj.status); 
	this.createdBy = ko.observable(obj.createdBy); 
	this.createdDate = ko.observable(obj.createdDate); 
	this.updatedBy = ko.observable(obj.updatedBy); 
	this.updatedDate = ko.observable(obj.updatedDate); 
}


//定义ViewModel对象
var ClockSkillViewModel = function () {  
	self=this;
    //添加动态监视数组对象
    self.clockSkillList = ko.observableArray([]);
    
    //重载数据
    self.reloadData = function(){
    	myAjax("/clockskills", "GET", query, function (data){
			var mappedTasks = $.map(data.data, function(item) { return new Node(item) });  
			self.clockSkillList(mappedTasks);
			myPage = data.page;
			bindPage();
			    
			$("table tbody td .tomodify").bind(function(){
				ChangeUrl('./clock/ClockSkill.html?action=Edit&id='+$(this).attr('data'));
			});
		}, true);
    };
    
    	
    //初始化数据--如何调用self.reloadData
    
	
	//搜索
	self.search = function(obj) {
		query.pageNo=1;
		query.pageSize = 20;
		qeury.keyWord = $("txtKeywords").val(); //查询参数格式
		myAjax("/clockskills", "GET", query, doQueryActionSuccess, true);
    };
    
    //新增
    self.add = function(obj) {
    	ChangeUrl('./clock/ClockSkill.html?action=Add');
    };
    
    //修改
    self.modify=function(obj){
    	ChangeUrl('./clock/ClockSkill.html?action=Edit&id='+obj.skillId());
    };
    
    //删除
    self.delete=function(obj){
    	parent.dialog({
            title: '提示',
            content: '确定要删除该记录！',
            okValue: '确定',
            ok: function () {
		    	var id = $(event.currentTarget).attr('data');
		    	myAjax("/clockskill/"+id, "DELETE", null, reloadDate, false);
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
	        		myAjax("/clockskill/"+id, "DELETE", null, null, false);
	        	});
	        	location.reload();
	        },
	        cancelValue: '取消',
	        cancel: function () { }
	    }).showModal();
    };

};

$().ready(function(){
    ko.applyBindings(new ClockSkillViewModel());
});

var bindPage =function(){
	//分页控件加载处理
    $.jqPaginator('#pagination', {
        totalPages: myPage.totalPages,
        visiblePages: myPage.limit,
        currentPage: myPage.page,
        onPageChange: function (num, type) {
        	query.pageNo=num;
        	//如何触发  self.reloadData
//            if (type != 'init') {
//            	ChangeUrl('./clock/ClockSkillList.html?page=' + num);
//            }
        }
    });
}

