//定义ViewModel对象
var EmployeeAttendEditViewModel = function () {  
	var self=this;
	self.attId = ko.observable(''); 
	self.employeeId = ko.observable(''); 
	self.attTime = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/employeeattend/"+opid, "GET", null, function (data){
			self.attId(data.attId);
			self.employeeId(data.employeeId);
			self.attTime(data.attTime);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.employeeId=self.employeeId();
		submitPar.attTime=self.attTime();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/employeeattend", "POST", submitPar, function (data){
				ChangeUrl("./attendance/EmployeeAttendList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/employeeattend/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./attendance/EmployeeAttendList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new EmployeeAttendEditViewModel());
});