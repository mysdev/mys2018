var myPage;

function Node(data) {
    this.attendance = ko.observable(data.attendance);  
    this.attendanceId = ko.observable(data.attendanceId);
    this.attendanceName = ko.observable(data.attendanceName); 
    this.createdBy = ko.observable(data.createdBy); 
    this.createdDate = ko.observable(data.createdDate); 
    this.outTime = ko.observable(data.outTime); 
    this.signTime = ko.observable(data.signTime); 
    this.status = ko.observable(data.status); 
    this.types = ko.observable(data.types); 
    this.updatedBy = ko.observable(data.updatedBy); 
    this.updatedDate = ko.observable(data.updatedDate); 
}  

//定义ViewModel对象
var AttendanceViewModel = function () {  
	var self=this;
    //添加动态监视数组对象
    self.deptlist = ko.observableArray([]);
    
    //初始化数据
    $.getJSON(homeUrl+"mys/attendances",function(result){
		var mappedTasks = $.map(result.data, function(item) { return new Node(item) });  
	    self.deptlist(mappedTasks);
	    myPage = result.page;
	    bindPage();
	    
	    $("table tbody td .tomodify").bind(function(){
	    	$("#mainframe", parent.window.document).attr("src",'attendance/add.html?action=Edit&id='+$(this).attr('data'));
	    });
	});
	
	//搜索
	self.search = function(obj) {
		$.getJSON(homeUrl+"mys/attendances?attendanceName="+$("txtKeywords").val(),function(result){
			var mappedTasks = $.map(result.data, function(item) { return new Node(item) });  
		    self.deptlist(mappedTasks);
		    myPage = result.page;
		    bindPage();
		});
    };
    
    //新增
    self.add = function(obj) {
    	$("#mainframe", parent.window.document).attr("src",'attendance/add.html?action=Add');
    };
    
    //修改
    self.modify=function(obj){
    	$("#mainframe", parent.window.document).attr("src",'attendance/add.html?action=Edit&id='+obj.attendanceId());
    };
    
    //删除
    self.delete=function(obj){
    	var id = obj.attendanceId();
    	$.ajax({
	        type: 'DELETE',
	        url: homeUrl+'mys/attendance/'+id,
	        cache: false,
	        async: false,
	        dataType: "json",
	        success: function (datas) {
	            parent.dialog(datas.message).showModal();
	        }
	    });
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
	        		$.ajax({
				        type: 'DELETE',
				        url: homeUrl+'mys/attendance/'+$(this).attr('data'),
				        cache: false,
				        async: false,
				        dataType: "json",
				        success: function (datas) {
				            
				        }
				    });
	        	});
	        	document.URL=location.href;
	        },
	        cancelValue: '取消',
	        cancel: function () { }
	    }).showModal();
    };

};

$().ready(function(){

    ko.applyBindings(new AttendanceViewModel());

});

var bindPage =function(){
	//分页控件加载处理
    $.jqPaginator('#pagination', {
        totalPages: myPage.totalPages,
        visiblePages: myPage.limit,
        currentPage: myPage.page,
        onPageChange: function (num, type) {
            if (type != 'init') {
            	$("#mainframe", parent.window.document).attr("src",'attendance/list.html?page=' + num);
            }
        }
    });
}

