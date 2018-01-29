var myPage;

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

//定义ViewModel对象
var TechnicianViewModel = function () {  
	var self=this;
    //添加动态监视数组对象
    self.technicianList = ko.observableArray([]);
    
    var myurl=homeUrl+"/technicians";
    if(getQueryString('page')!=null){
    	myurl+="?pageNo="+getQueryString('page');
    }
    	
    //初始化数据
    $.getJSON(myurl,function(result){
		var mappedTasks = $.map(result.data, function(item) { return new Node(item) });  
	    self.technicianList(mappedTasks);
	    myPage = result.page;
	    bindPage();
	    
	    $("table tbody td .tomodify").bind(function(){
	    	$("#mainframe", parent.window.document).attr("src",'./clock/Technician.html?action=Edit&id='+$(this).attr('data'));
	    });
	});
	
	//搜索
	self.search = function(obj) {
		$.getJSON(homeUrl+"/technicians?attendanceName="+$("txtKeywords").val(),function(result){
			var mappedTasks = $.map(result.data, function(item) { return new Node(item) });  
		    self.technicianList(mappedTasks);
		    myPage = result.page;
		    bindPage();
		});
    };
    
    //新增
    self.add = function(obj) {
    	$("#mainframe", parent.window.document).attr("src",'./clock/Technician.html?action=Add');
    };
    
    //修改
    self.modify=function(obj){
    	$("#mainframe", parent.window.document).attr("src",'./clock/Technician.html?action=Edit&id='+obj.technicianId());
    };
    
    //删除
    self.delete=function(obj){
    	parent.dialog({
            title: '提示',
            content: '确定要删除该记录！',
            okValue: '确定',
            ok: function () {
		    	var id = $(event.currentTarget).attr('data');
		    	$.ajax({
			        type: 'DELETE',
			        url: homeUrl+'/technician/'+id,
			        cache: false,
			        async: false,
			        dataType: "json",
			        success: function (result) {
			        	if(result.code==200){
				            location.reload();
			            }
		                else{
		                	parent.dialog(result.message).showModal();
		                }
			        }
			    });
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
	        		$.ajax({
				        type: 'DELETE',
				        url: homeUrl+'/technician/'+$(this).attr('data'),
				        cache: false,
				        async: false,
				        dataType: "json",
				        success: function (datas) {
				            
				        }
				    });
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
            if (type != 'init') {
            	$("#mainframe", parent.window.document).attr("src",'./clock/TechnicianList.html?page=' + num);
            }
        }
    });
}

