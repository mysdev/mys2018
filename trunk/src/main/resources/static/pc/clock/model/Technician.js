//定义ViewModel对象
var TechnicianEditViewModel = function () {  
	var self=this;
	self.technicianId = ko.observable(''); 
	self.empId = ko.observable(''); 
	self.techNo = ko.observable(''); 
	self.techCard = ko.observable(''); 
	self.techName = ko.observable(''); 
	self.sex = ko.observable(''); 
	self.shiftId = ko.observable(''); 
	self.status = ko.observable(''); 
	self.shiftStatus = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/technician/"+opid, "GET", null, function (data){
			self.technicianId(data.technicianId);
			self.empId(data.empId);
			self.techNo(data.techNo);
			self.techCard(data.techCard);
			self.techName(data.techName);
			self.sex(data.sex);
			self.shiftId(data.shiftId);
			self.status(data.status);
			self.shiftStatus(data.shiftStatus);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.empId=self.empId();
		submitPar.techNo=self.techNo();
		submitPar.techCard=self.techCard();
		submitPar.techName=self.techName();
		submitPar.sex=self.sex();
		submitPar.shiftId=self.shiftId();
		submitPar.status=self.status();
		submitPar.shiftStatus=self.shiftStatus();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/technician", "POST", submitPar, function (data){
				ChangeUrl("./clock/TechnicianList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/technician/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./clock/TechnicianList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TechnicianEditViewModel());
});