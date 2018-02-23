var attendanceList=[];
var viewMode;

function Node(obj) {
	this.attId = ko.observable(obj.attId); 
	this.attDay=ko.observable(obj.attDay); 
	this.attDate = ko.observable(obj.attDate);
	this.attMonth = ko.observable(obj.attMonth);
	this.attendance = ko.observable(obj.attendance); 
	this.attendanceId = ko.observable(obj.attendanceId); 
	this.editable = ko.observable(obj.editable);
	this.weekday = ko.observable(obj.weekday); 
	this.timeId = ko.observable(obj.timeId);
	this.createdBy = ko.observable(obj.createdBy); 
	this.createdDate = ko.observable(obj.createdDate); 
	this.updatedBy = ko.observable(obj.updatedBy); 
	this.updatedDate = ko.observable(obj.updatedDate); 
}


//定义ViewModel对象
var AttendanceDetailViewModel = function () {  
	self=this;
	
	self.attendanceList=ko.observableArray(attendanceList);
    self.attendanceSelected = ko.observable('');
    
    //添加动态监视数组对象
    self.attendanceDetailList = ko.observableArray([]);
    
    //重载数据
    self.reloadData = function(){
    	if(self.attendanceSelected()=="") return; 
    	
    	GetData();
    };
    
    	
    //初始化数据--如何调用self.reloadData
    self.reloadData();
    
    self.attendanceChage=function(p){
    	self.reloadData();
    };
	
	//搜索
	self.search = function(obj) {
		GetData();
    };

    //修改
    self.modify=function(obj){
    	ChangeUrl('./attendance/AttendanceDetail.html?action=Edit&id='+obj.attId());
    };
};

$().ready(function(){
	viewMode = new AttendanceDetailViewModel();
    ko.applyBindings(viewMode);
    
    //获取下拉列表数据
	myAjax("/attendances", "GET", null, function (data){
		$.map(data.data, function(item) { attendanceList.push({id:item.attendanceId,name:item.attendanceName})});  
		viewMode.attendanceList(attendanceList);
		viewMode.attendanceSelected(attendanceList[0].name);
		$(".rule-single-select").ruleSingleSelect();
		
		viewMode.reloadData();
	}, true);
	
    //美化下拉框样式
	$(".rule-single-select").ruleSingleSelect();
});

function GetData(){
	var searchKey = $("#txtKeywords").val().toString();  
	var url = "/attendance/"+self.attendanceSelected()+"/details";
	if(searchKey!="" && searchKey.indexOf("-")>0)
		url=url+'?yearMonth='+searchKey;
	myAjax(url, "GET", null, function (data){
		var mappedTasks = $.map(data, function(item) { return new Node(item) });  
		self.attendanceDetailList(mappedTasks);
		    
		$("table tbody td .tomodify").bind(function(){
			ChangeUrl('./attendance/AttendanceDetail.html?action=Edit&id='+$(this).attr('data'));
		});
	}, true);
}
