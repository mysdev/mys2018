var myPage;
var query = {};
query.pageNo=1;
query.pageSize = 20;
if(getQueryString('page')!=undefined){
	query.pageNo=getQueryString('page');
}

function Node(obj) {
	this.recordId = ko.observable(obj.recordId); 
	this.orderId = ko.observable(obj.orderId); 
	this.technicianId = ko.observable(obj.technicianId); 
	this.classId = ko.observable(obj.classId); 
	this.status = ko.observable(obj.status); 
	this.beginTime = ko.observable(obj.beginTime); 
	this.endTime = ko.observable(obj.endTime); 
	this.actureTime = ko.observable(obj.actureTime); 
	this.recordStatus = ko.observable(obj.recordStatus); 
	this.createdBy = ko.observable(obj.createdBy); 
	this.createdDate = ko.observable(obj.createdDate); 
	this.updatedBy = ko.observable(obj.updatedBy); 
	this.updatedDate = ko.observable(obj.updatedDate); 
}

function doQueryActionSuccess(data){
	var mappedTasks = $.map(data.data, function(item) { return new Node(item) });  
	self.clockRecordList(mappedTasks);
	myPage = data.page;
	bindPage();
	    
	$("table tbody td .tomodify").bind(function(){
		ChangeUrl('./clock/ClockRecord.html?action=Edit&id='+$(this).attr('data'));
	});
}

function reloadDate(data){
	myAjax("/clockrecords", "GET", query, doQueryActionSuccess, true);
}

//定义ViewModel对象
var ClockRecordViewModel = function () {  
	var self=this;
    //添加动态监视数组对象
    self.clockRecordList = ko.observableArray([]);
    	
    //初始化数据
    reloadDate(null);
	
	//搜索
	self.search = function(obj) {
		query.pageNo=1;
		query.pageSize = 20;
		qeury.keyWord = $("txtKeywords").val(); //查询参数格式
		myAjax("/clockrecords", "GET", query, doQueryActionSuccess, true);
    };
    
    //新增
    self.add = function(obj) {
    	ChangeUrl('./clock/ClockRecord.html?action=Add');
    };
    
    //修改
    self.modify=function(obj){
    	ChangeUrl('./clock/ClockRecord.html?action=Edit&id='+obj.recordId());
    };
    
    //删除
    self.delete=function(obj){
    	parent.dialog({
            title: '提示',
            content: '确定要删除该记录！',
            okValue: '确定',
            ok: function () {
		    	var id = $(event.currentTarget).attr('data');
		    	myAjax("/clockrecord/"+id, "DELETE", null, reloadDate, false);
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
	        		myAjax("/clockrecord/"+id, "DELETE", null, null, false);
	        	});
	        	location.reload();
	        },
	        cancelValue: '取消',
	        cancel: function () { }
	    }).showModal();
    };

};

$().ready(function(){
    ko.applyBindings(new ClockRecordViewModel());
});

var bindPage =function(){
	//分页控件加载处理
    $.jqPaginator('#pagination', {
        totalPages: myPage.totalPages,
        visiblePages: myPage.limit,
        currentPage: myPage.page,
        onPageChange: function (num, type) {
        	query.pageNo=num;
        	reloadDate(null);
//            if (type != 'init') {
//            	ChangeUrl('./clock/ClockRecordList.html?page=' + num);
//            }
        }
    });
}

