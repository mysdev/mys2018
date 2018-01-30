var myPage;
var query = {};
query.pageNo=1;
query.pageSize = 20;
if(getQueryString('page')!=undefined){
	query.pageNo=getQueryString('page');
}

function Node(obj) {
	this.technicianId = ko.observable(obj.technicianId); 
	this.empId = ko.observable(obj.empId); 
	this.techNo = ko.observable(obj.techNo); 
	this.techCard = ko.observable(obj.techCard); 
	this.techName = ko.observable(obj.techName); 
	this.sex = ko.observable(obj.sex); 
	this.shiftId = ko.observable(obj.shiftId); 
	this.status = ko.observable(obj.status); 
	this.shiftStatus = ko.observable(obj.shiftStatus); 
	this.createdBy = ko.observable(obj.createdBy); 
	this.createdDate = ko.observable(obj.createdDate); 
	this.updatedBy = ko.observable(obj.updatedBy); 
	this.updatedDate = ko.observable(obj.updatedDate); 
}

function doQueryActionSuccess(data){
	var mappedTasks = $.map(data.data, function(item) { return new Node(item) });  
	self.technicianList(mappedTasks);
	myPage = data.page;
	bindPage();
	    
	$("table tbody td .tomodify").bind(function(){
		ChangeUrl('./clock/Technician.html?action=Edit&id='+$(this).attr('data'));
	});
}

function reloadDate(data){
	myAjax("/technicians", "GET", query, doQueryActionSuccess, true);
}

//定义ViewModel对象
var TechnicianViewModel = function () {  
	var self=this;
    //添加动态监视数组对象
    self.technicianList = ko.observableArray([]);
    	
    //初始化数据
    reloadDate(null);
	
	//搜索
	self.search = function(obj) {
		query.pageNo=1;
		query.pageSize = 20;
		qeury.keyWord = $("txtKeywords").val(); //查询参数格式
		myAjax("/technicians", "GET", query, doQueryActionSuccess, true);
    };
    
    //新增
    self.add = function(obj) {
    	ChangeUrl('./clock/Technician.html?action=Add');
    };
    
    //修改
    self.modify=function(obj){
    	ChangeUrl('./clock/Technician.html?action=Edit&id='+obj.technicianId());
    };
    
    //删除
    self.delete=function(obj){
    	parent.dialog({
            title: '提示',
            content: '确定要删除该记录！',
            okValue: '确定',
            ok: function () {
		    	var id = $(event.currentTarget).attr('data');
		    	myAjax("/technician/"+id, "DELETE", null, reloadDate, false);
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
	        		myAjax("/technician/"+id, "DELETE", null, null, false);
	        	});
	        	location.reload();
	        },
	        cancelValue: '取消',
	        cancel: function () { }
	    }).showModal();
    };

};

$().ready(function(){
    ko.applyBindings(new TechnicianViewModel());
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
//            	ChangeUrl('./clock/TechnicianList.html?page=' + num);
//            }
        }
    });
}

