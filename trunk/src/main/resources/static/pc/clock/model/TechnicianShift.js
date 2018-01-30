//定义ViewModel对象
var TechnicianShiftEditViewModel = function () {  
	var self=this;
	self.shiftId = ko.observable(''); 
	self.shiftName = ko.observable(''); 
	self.inTime = ko.observable(''); 
	self.outTime = ko.observable(''); 
	self.status = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/technicianshift/"+opid, "GET", null, function (data){
			self.shiftId(data.shiftId);
			self.shiftName(data.shiftName);
			self.inTime(data.inTime);
			self.outTime(data.outTime);
			self.status(data.status);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.shiftName=self.shiftName();
		submitPar.inTime=self.inTime();
		submitPar.outTime=self.outTime();
		submitPar.status=self.status();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/technicianshift", "POST", submitPar, function (data){
				ChangeUrl("./clock/TechnicianShiftList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/technicianshift/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./clock/TechnicianShiftList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TechnicianShiftEditViewModel());
});