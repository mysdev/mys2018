var myPage;
var viewMode;
var query = {};
query.pageNo=1;
query.pageSize = 20;
if(getQueryString('page')!=undefined){
	query.pageNo=getQueryString('page');
}

function Node(obj) {
	this.memberId = ko.observable(obj.memberId); 
	this.memberName = ko.observable(obj.memberName); 
	this.pinyin = ko.observable(obj.pinyin); 
	this.status = ko.observable(obj.status); 
	this.rfm = ko.observable(obj.rfm); 
	this.levelId = ko.observable(obj.levelId); 
	this.memberCard = ko.observable(obj.memberCard); 
	this.memberPassword = ko.observable(obj.memberPassword); 
	this.integral = ko.observable(obj.integral); 
	this.balance = ko.observable(obj.balance); 
	this.mobile = ko.observable(obj.mobile); 
	this.mail = ko.observable(obj.mail); 
	this.birthday = ko.observable(obj.birthday); 
	this.storeId = ko.observable(obj.storeId); 
	this.totalFee = ko.observable(obj.totalFee); 
	this.sex = ko.observable(obj.sex); 
	this.address = ko.observable(obj.address); 
	this.cardType = ko.observable(obj.cardType); 
	this.cardNo = ko.observable(obj.cardNo); 
	this.createdBy = ko.observable(obj.createdBy); 
	this.createdDate = ko.observable(obj.createdDate); 
	this.updatedBy = ko.observable(obj.updatedBy); 
	this.updatedDate = ko.observable(obj.updatedDate); 
}


//定义ViewModel对象
var MemberViewModel = function () {  
	self=this;
    //添加动态监视数组对象
    self.memberList = ko.observableArray([]);
    
    //重载数据
    self.reloadData = function(){
    	myAjax("/members", "GET", query, function (data){
			var mappedTasks = $.map(data.data, function(item) { return new Node(item) });  
			self.memberList(mappedTasks);
			myPage = data.page;
			bindPage();
			    
			$("table tbody td .tomodify").bind(function(){
				ChangeUrl('./core/Member.html?action=Edit&id='+$(this).attr('data'));
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
		myAjax("/members", "GET", query, doQueryActionSuccess, true);
    };
    
    //新增
    self.add = function(obj) {
    	ChangeUrl('./core/Member.html?action=Add');
    };
    
    //修改
    self.modify=function(obj){
    	ChangeUrl('./core/Member.html?action=Edit&id='+obj.memberId());
    };
    
    //删除
    self.delete=function(obj){
    	parent.dialog({
            title: '提示',
            content: '确定要删除该记录！',
            okValue: '确定',
            ok: function () {
		    	var id = $(event.currentTarget).attr('data');
		    	myAjax("/member/"+id, "DELETE", null, reloadDate, false);
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
	        		myAjax("/member/"+id, "DELETE", null, null, false);
	        	});
	        	location.reload();
	        },
	        cancelValue: '取消',
	        cancel: function () { }
	    }).showModal();
    };

};

$().ready(function(){
	viewMode = new MemberViewModel();
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
//            	ChangeUrl('./core/MemberList.html?page=' + num);
//            }
        }
    });
}

