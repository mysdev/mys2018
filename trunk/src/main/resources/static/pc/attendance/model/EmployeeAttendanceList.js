var bIsInit = false;
var attendanceList=[];
var myPage;
var viewMode;
var query = {};
query.pageNo=1;
query.pageSize = 20;
if(getQueryString('page')!=undefined){
	query.pageNo=getQueryString('page');
}

function Node(obj) {
	this.linkId = ko.observable(obj.linkId); 
	this.empId = ko.observable(obj.empId); 
	this.empName = ko.observable(obj.empName); 
	this.attendanceId = ko.observable(obj.attendanceId); 
	this.attendanceName = ko.observable(obj.attendanceName); 
	this.createdBy = ko.observable(obj.createdBy); 
	this.createdDate = ko.observable(obj.createdDate); 
	this.updatedBy = ko.observable(obj.updatedBy); 
	this.updatedDate = ko.observable(obj.updatedDate); 
}


//定义ViewModel对象
var EmployeeAttendanceViewModel = function () {  
	self=this;
	
	self.attendanceList=ko.observableArray(attendanceList);
    self.attendanceSelected = ko.observable('');
    
    //添加动态监视数组对象
    self.employeeAttendanceList = ko.observableArray([]);
    
    //重载数据
    self.reloadData = function(){
    	if(self.attendanceSelected()=="") return; 
    	
    	GetData();
    };
    
    	
    //初始化数据--如何调用self.reloadData
    self.reloadData();
	
	self.attendanceChage=function(p){
		if(bIsInit)
    		self.reloadData();
    };
    
	//搜索
	self.search = function(obj) {
		GetData();
    };
    
    //新增
    self.add = function(obj) {
    	ChangeUrl('./attendance/EmployeeAttendance.html?action=Add');
    };
    
    //修改
    self.modify=function(obj){
    	ChangeUrl('./attendance/EmployeeAttendance.html?action=Edit&id='+obj.linkId());
    };
    
    //删除
    self.delete=function(obj){
    	parent.dialog({
            title: '提示',
            content: '确定要删除该记录！',
            okValue: '确定',
            ok: function () {
		    	var id = $(event.currentTarget).attr('data');
		    	myAjax("/employeeattendance/"+id, "DELETE", null, reloadDate, false);
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
	        		myAjax("/employeeattendance/"+id, "DELETE", null, null, false);
	        	});
	        	location.reload();
	        },
	        cancelValue: '取消',
	        cancel: function () { }
	    }).showModal();
    };

};

$().ready(function(){
	viewMode = new EmployeeAttendanceViewModel();
    ko.applyBindings(viewMode);
    
    //获取下拉列表数据
	myAjax("/attendances", "GET", null, function (data){
		$.map(data.data, function(item) { attendanceList.push({id:item.attendanceId,name:item.attendanceName})});  
		viewMode.attendanceList(attendanceList);
		viewMode.attendanceSelected(attendanceList[0].name);
		$(".rule-single-select").ruleSingleSelect();
		
		bIsInit = true;
		viewMode.reloadData();
	}, true);
	
    //美化下拉框样式
	$(".rule-single-select").ruleSingleSelect();
	
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
//            	ChangeUrl('./attendance/EmployeeAttendanceList.html?page=' + num);
//            }
        }
    });
}

function GetData(){
	var searchKey = $("#txtKeywords").val().toString(); 
	var url = "/attendance/"+self.attendanceSelected()+"/employees";
	
	if(searchKey!="")
		query.namePYJob=searchKey;
	else
		query.namePYJob='';
		
	myAjax(url, "GET", query, function (data){
		var mappedTasks = $.map(data.data, function(item) { return new Node(item) });  
		self.employeeAttendanceList(mappedTasks);
		myPage = data.page;
		
		if(mappedTasks.length>0)
			bindPage();
		    
		$("table tbody td .tomodify").bind(function(){
			ChangeUrl('./attendance/EmployeeAttendance.html?action=Edit&id='+$(this).attr('data'));
		});
	}, true);
}
