var storeList=[];
var schemeList=[{
		"schemeId": "0",
		"schemeName": "休天数"
	},{
		"schemeId": "1",
		"schemeName": "考勤天数"
	},{
		"schemeId": "2",
		"schemeName": "自定义"
	}];

var attendanceViewModel;

//定义ViewModel对象
var AttendanceEditViewModel = function () {  
	var self=this;
	self.attendanceId = ko.observable(''); 
	//self.storeId = ko.observable(''); 
	self.selectStore=ko.observableArray(storeList);
    self.storeSelected = ko.observable('');
	self.attendanceName = ko.observable(''); 
	self.status = ko.observable(''); 
	//self.types = ko.observable(''); 
	self.selectScheme=ko.observableArray(schemeList);
    self.schemeSelected = ko.observable(schemeList[0].schemeName);
	self.attendance = ko.observable(''); 
	self.signTime = ko.observable("09:00"); 
	self.outTime = ko.observable("18:00");
	self.myDis = ko.observable(true);
	self.myNotDis = ko.observable(false);

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/attendance/"+opid, "GET", null, function (data){
			self.attendanceId(data.attendanceId);
			//self.storeId(data.storeId);
			self.attendanceName(data.attendanceName);
			self.status(data.status);
			self.types(data.types);
			self.attendance(data.attendance);
			self.signTime(data.signTime);
			self.outTime(data.outTime);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.storeId=self.storeId();
		submitPar.attendanceName=self.attendanceName();
		submitPar.status=self.status();
		submitPar.types=self.types();
		submitPar.attendance=self.attendance();
		submitPar.signTime=self.signTime();
		submitPar.outTime=self.outTime();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/attendance", "POST", submitPar, function (data){
				ChangeUrl("./attendance/AttendanceList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/attendance/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./attendance/AttendanceList.html");
			}, true);
    	}
    };
    
    self.schemeChage=function(p){
    	if(self.schemeSelected()==2)
		{
    		self.myDis(false);
    		self.myNotDis(true);
		}
    	else{
    		self.myDis(true);
    		self.myNotDis(false);
    	}
    };
};


$().ready(function(){
	
	$("#txtName").focus();
	attendanceViewModel=new AttendanceEditViewModel();
	ko.applyBindings(attendanceViewModel);
    
    //获取下拉列表数据
	myAjax("/stores", "GET", null, function (data){
		$.map(data.data, function(item) { storeList.push({storeId:item.storeId,storeName:item.storeName})});  
		attendanceViewModel.selectStore(storeList);
		attendanceViewModel.storeSelected(storeList[0].storeName);
		$(".rule-single-select").ruleSingleSelect();
	}, true);
	
	$(".rule-single-select").ruleSingleSelect();
});