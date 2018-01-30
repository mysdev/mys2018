//定义ViewModel对象
var AttendanceEditViewModel = function () {  
	var self=this;
	self.attendanceId = ko.observable(''); 
	self.storeId = ko.observable(''); 
	self.attendanceName = ko.observable(''); 
	self.status = ko.observable(''); 
	self.types = ko.observable(''); 
	self.attendance = ko.observable(''); 
	self.signTime = ko.observable(''); 
	self.outTime = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/attendance/"+opid, "GET", null, function (data){
			self.attendanceId(data.attendanceId);
			self.storeId(data.storeId);
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
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new AttendanceEditViewModel());
});