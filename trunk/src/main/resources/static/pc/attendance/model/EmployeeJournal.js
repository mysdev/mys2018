//定义ViewModel对象
var EmployeeJournalEditViewModel = function () {  
	var self=this;
	self.journalId = ko.observable(''); 
	self.empId = ko.observable(''); 
	self.attendanceDate = ko.observable(''); 
	self.signTime = ko.observable(''); 
	self.outTime = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/employeejournal/"+opid, "GET", null, function (data){
			self.journalId(data.journalId);
			self.empId(data.empId);
			self.attendanceDate(data.attendanceDate);
			self.signTime(data.signTime);
			self.outTime(data.outTime);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.empId=self.empId();
		submitPar.attendanceDate=self.attendanceDate();
		submitPar.signTime=self.signTime();
		submitPar.outTime=self.outTime();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/employeejournal", "POST", submitPar, function (data){
				ChangeUrl("./attendance/EmployeeJournalList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/employeejournal/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./attendance/EmployeeJournalList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new EmployeeJournalEditViewModel());
});