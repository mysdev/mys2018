var myPage;
var viewMode;
var query = {};
query.pageNo=1;
query.pageSize = 20;
if(getQueryString('page')!=undefined){
	query.pageNo=getQueryString('page');
}

function Node(obj) {
	this.journalId = ko.observable(obj.journalId); 
	this.empId = ko.observable(obj.empId); 
	this.empName = ko.observable(obj.empName); 
	this.attendance = ko.observable(obj.attendance);
	this.attTime = ko.observable(obj.attTime);
	this.sysSign = ko.observable(obj.sysSign); 
	this.sysOut = ko.observable(obj.sysOut); 
	this.signTime = ko.observable(obj.signTime); 
	this.outTime = ko.observable(obj.outTime); 
	this.createdBy = ko.observable(obj.createdBy); 
	this.createdDate = ko.observable(obj.createdDate); 
	this.updatedBy = ko.observable(obj.updatedBy); 
	this.updatedDate = ko.observable(obj.updatedDate); 
}


//定义ViewModel对象
var EmployeeJournalViewModel = function () {  
	self=this;
    //添加动态监视数组对象
    self.employeeJournalList = ko.observableArray([]);
    
    //重载数据
    self.reloadData = function(){
    	myAjax("/attendance/employee/diarys", "GET", query, function (data){
			var mappedTasks = $.map(data.data, function(item) { return new Node(item) });  
			self.employeeJournalList(mappedTasks);
			myPage = data.page;
			bindPage();
		}, true);
    };
    
    	
    //初始化数据--如何调用self.reloadData
    self.reloadData();
	
	//搜索
	self.search = function(obj) {
		query.pageNo=1;
		query.pageSize = 20;
		qeury.keyWord = $("txtKeywords").val(); //查询参数格式
		myAjax("/employeejournals", "GET", query, doQueryActionSuccess, true);
    };
    
    //新增
    self.add = function(obj) {
    	ChangeUrl('./attendance/EmployeeJournal.html?action=Add');
    };
};

$().ready(function(){
	viewMode = new EmployeeJournalViewModel();
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
//            	ChangeUrl('./attendance/EmployeeJournalList.html?page=' + num);
//            }
        }
    });
}

