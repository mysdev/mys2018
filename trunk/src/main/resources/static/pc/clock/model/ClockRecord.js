//定义ViewModel对象
var ClockRecordEditViewModel = function () {  
	var self=this;
	self.recordId = ko.observable(''); 
	self.orderId = ko.observable(''); 
	self.technicianId = ko.observable(''); 
	self.classId = ko.observable(''); 
	self.status = ko.observable(''); 
	self.beginTime = ko.observable(''); 
	self.endTime = ko.observable(''); 
	self.actureTime = ko.observable(''); 
	self.recordStatus = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/clockrecord/"+opid, "GET", null, function (data){
			self.recordId(data.recordId);
			self.orderId(data.orderId);
			self.technicianId(data.technicianId);
			self.classId(data.classId);
			self.status(data.status);
			self.beginTime(data.beginTime);
			self.endTime(data.endTime);
			self.actureTime(data.actureTime);
			self.recordStatus(data.recordStatus);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.orderId=self.orderId();
		submitPar.technicianId=self.technicianId();
		submitPar.classId=self.classId();
		submitPar.status=self.status();
		submitPar.beginTime=self.beginTime();
		submitPar.endTime=self.endTime();
		submitPar.actureTime=self.actureTime();
		submitPar.recordStatus=self.recordStatus();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/clockrecord", "POST", submitPar, function (data){
				ChangeUrl("./clock/ClockRecordList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/clockrecord/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./clock/ClockRecordList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ClockRecordEditViewModel());
});