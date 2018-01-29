var myPage;

function Node(obj) {
	this.detailId = ko.observable(obj.detailId); 
	this.classId = ko.observable(obj.classId); 
	this.technicianId = ko.observable(obj.technicianId); 
	this.clockCt = ko.observable(obj.clockCt); 
	this.isWork = ko.observable(obj.isWork); 
	this.technicianLevel = ko.observable(obj.technicianLevel); 
	this.priority = ko.observable(obj.priority); 
	this.seqencing = ko.observable(obj.seqencing); 
	this.createdBy = ko.observable(obj.createdBy); 
	this.createdDate = ko.observable(obj.createdDate); 
	this.updatedBy = ko.observable(obj.updatedBy); 
	this.updatedDate = ko.observable(obj.updatedDate); 
}

//定义ViewModel对象
var TechnicianClassViewModel = function () {  
	var self=this;
    //添加动态监视数组对象
    self.technicianClassList = ko.observableArray([]);
    
    var myurl=homeUrl+"/technicianclasss";
    if(getQueryString('page')!=null){
    	myurl+="?pageNo="+getQueryString('page');
    }
    	
    //初始化数据
    $.getJSON(myurl,function(result){
		var mappedTasks = $.map(result.data, function(item) { return new Node(item) });  
	    self.technicianClassList(mappedTasks);
	    myPage = result.page;
	    bindPage();
	    
	    $("table tbody td .tomodify").bind(function(){
	    	$("#mainframe", parent.window.document).attr("src",'./clock/TechnicianClass.html?action=Edit&id='+$(this).attr('data'));
	    });
	});
	
	//搜索
	self.search = function(obj) {
		$.getJSON(homeUrl+"/technicianclasss?attendanceName="+$("txtKeywords").val(),function(result){
			var mappedTasks = $.map(result.data, function(item) { return new Node(item) });  
		    self.technicianClassList(mappedTasks);
		    myPage = result.page;
		    bindPage();
		});
    };
    
    //新增
    self.add = function(obj) {
    	$("#mainframe", parent.window.document).attr("src",'./clock/TechnicianClass.html?action=Add');
    };
    
    //修改
    self.modify=function(obj){
    	$("#mainframe", parent.window.document).attr("src",'./clock/TechnicianClass.html?action=Edit&id='+obj.detailId());
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
			        url: homeUrl+'/technicianclass/'+id,
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
				        url: homeUrl+'/technicianclass/'+$(this).attr('data'),
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

    ko.applyBindings(new TechnicianClassViewModel());

});

var bindPage =function(){
	//分页控件加载处理
    $.jqPaginator('#pagination', {
        totalPages: myPage.totalPages,
        visiblePages: myPage.limit,
        currentPage: myPage.page,
        onPageChange: function (num, type) {
            if (type != 'init') {
            	$("#mainframe", parent.window.document).attr("src",'./clock/TechnicianClassList.html?page=' + num);
            }
        }
    });
}

