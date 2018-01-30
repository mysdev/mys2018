//定义ViewModel对象
var ReservationEditViewModel = function () {  
	var self=this;
	self.reservationId = ko.observable(''); 
	self.roomId = ko.observable(''); 
	self.startTime = ko.observable(''); 
	self.endTime = ko.observable(''); 
	self.estimateTime = ko.observable(''); 
	self.reserveTime = ko.observable(''); 
	self.memberId = ko.observable(''); 
	self.estimatePerson = ko.observable(''); 
	self.estimateCall = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/reservation/"+opid, "GET", null, function (data){
			self.reservationId(data.reservationId);
			self.roomId(data.roomId);
			self.startTime(data.startTime);
			self.endTime(data.endTime);
			self.estimateTime(data.estimateTime);
			self.reserveTime(data.reserveTime);
			self.memberId(data.memberId);
			self.estimatePerson(data.estimatePerson);
			self.estimateCall(data.estimateCall);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.roomId=self.roomId();
		submitPar.startTime=self.startTime();
		submitPar.endTime=self.endTime();
		submitPar.estimateTime=self.estimateTime();
		submitPar.reserveTime=self.reserveTime();
		submitPar.memberId=self.memberId();
		submitPar.estimatePerson=self.estimatePerson();
		submitPar.estimateCall=self.estimateCall();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/reservation", "POST", submitPar, function (data){
				ChangeUrl("./core/ReservationList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/reservation/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/ReservationList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ReservationEditViewModel());
});