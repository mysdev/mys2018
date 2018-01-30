//定义ViewModel对象
var AttendanceDetailEditViewModel = function () {  
	var self=this;
	self.attId = ko.observable(''); 
	self.attendanceId = ko.observable(''); 
	self.weekday = ko.observable(''); 
	self.attMonth = ko.observable(''); 
	self.attDate = ko.observable(''); 
	self.attendance = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/attendancedetail/"+opid, "GET", null, function (data){
			self.attId(data.attId);
			self.attendanceId(data.attendanceId);
			self.weekday(data.weekday);
			self.attMonth(data.attMonth);
			self.attDate(data.attDate);
			self.attendance(data.attendance);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.attendanceId=self.attendanceId();
		submitPar.weekday=self.weekday();
		submitPar.attMonth=self.attMonth();
		submitPar.attDate=self.attDate();
		submitPar.attendance=self.attendance();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/attendancedetail", "POST", submitPar, function (data){
				ChangeUrl("./attendance/AttendanceDetailList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/attendancedetail/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./attendance/AttendanceDetailList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new AttendanceDetailEditViewModel());
});