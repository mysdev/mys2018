//定义ViewModel对象
var EmployeeAttendanceEditViewModel = function () {  
	var self=this;
	self.linkId = ko.observable(''); 
	self.empId = ko.observable(''); 
	self.attendanceId = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/employeeattendance/"+opid, "GET", null, function (data){
			self.linkId(data.linkId);
			self.empId(data.empId);
			self.attendanceId(data.attendanceId);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.empId=self.empId();
		submitPar.attendanceId=self.attendanceId();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/employeeattendance", "POST", submitPar, function (data){
				ChangeUrl("./attendance/EmployeeAttendanceList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/employeeattendance/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./attendance/EmployeeAttendanceList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new EmployeeAttendanceEditViewModel());
});
