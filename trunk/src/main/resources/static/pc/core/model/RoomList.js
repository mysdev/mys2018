var myPage;
var viewMode;
var query = {};
query.pageNo=1;
query.pageSize = 20;
if(getQueryString('page')!=undefined){
	query.pageNo=getQueryString('page');
}

function Node(obj) {
	this.roomId = ko.observable(obj.roomId); 
	this.storeId = ko.observable(obj.storeId); 
	this.types = ko.observable(obj.types); 
	this.area = ko.observable(obj.area); 
	this.roomNo = ko.observable(obj.roomNo); 
	this.roomName = ko.observable(obj.roomName); 
	this.status = ko.observable(obj.status); 
	this.roomStatus = ko.observable(obj.roomStatus); 
	this.chair = ko.observable(obj.chair); 
	this.bed = ko.observable(obj.bed); 
	this.mark = ko.observable(obj.mark); 
	this.phone = ko.observable(obj.phone); 
	this.createdBy = ko.observable(obj.createdBy); 
	this.createdDate = ko.observable(obj.createdDate); 
	this.updatedBy = ko.observable(obj.updatedBy); 
	this.updatedDate = ko.observable(obj.updatedDate); 
}


//定义ViewModel对象
var RoomViewModel = function () {  
	self=this;
    //添加动态监视数组对象
    self.roomList = ko.observableArray([]);
    
    //重载数据
    self.reloadData = function(){
    	myAjax("/rooms", "GET", query, function (data){
			var mappedTasks = $.map(data.data, function(item) { return new Node(item) });  
			self.roomList(mappedTasks);
			myPage = data.page;
			bindPage();
			    
			$("table tbody td .tomodify").bind(function(){
				ChangeUrl('./core/Room.html?action=Edit&id='+$(this).attr('data'));
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
		myAjax("/rooms", "GET", query, doQueryActionSuccess, true);
    };
    
    //新增
    self.add = function(obj) {
    	ChangeUrl('./core/Room.html?action=Add');
    };
    
    //修改
    self.modify=function(obj){
    	ChangeUrl('./core/Room.html?action=Edit&id='+obj.roomId());
    };
    
    //删除
    self.delete=function(obj){
    	parent.dialog({
            title: '提示',
            content: '确定要删除该记录！',
            okValue: '确定',
            ok: function () {
		    	var id = $(event.currentTarget).attr('data');
		    	myAjax("/room/"+id, "DELETE", null, reloadDate, false);
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
	        		myAjax("/room/"+id, "DELETE", null, null, false);
	        	});
	        	location.reload();
	        },
	        cancelValue: '取消',
	        cancel: function () { }
	    }).showModal();
    };

};

$().ready(function(){
	viewMode = new RoomViewModel();
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
//            	ChangeUrl('./core/RoomList.html?page=' + num);
//            }
        }
    });
}

