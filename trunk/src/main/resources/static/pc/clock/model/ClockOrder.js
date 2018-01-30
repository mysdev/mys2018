//定义ViewModel对象
var ClockOrderEditViewModel = function () {  
	var self=this;
	self.orderId = ko.observable(''); 
	self.authorizationId = ko.observable(''); 
	self.types = ko.observable(''); 
	self.objectId = ko.observable(''); 
	self.status = ko.observable(''); 
	self.materialId = ko.observable(''); 
	self.goodsId = ko.observable(''); 
	self.goodsTime = ko.observable(''); 
	self.technicianId = ko.observable(''); 
	self.customerNote = ko.observable(''); 
	self.note = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/clockorder/"+opid, "GET", null, function (data){
			self.orderId(data.orderId);
			self.authorizationId(data.authorizationId);
			self.types(data.types);
			self.objectId(data.objectId);
			self.status(data.status);
			self.materialId(data.materialId);
			self.goodsId(data.goodsId);
			self.goodsTime(data.goodsTime);
			self.technicianId(data.technicianId);
			self.customerNote(data.customerNote);
			self.note(data.note);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.authorizationId=self.authorizationId();
		submitPar.types=self.types();
		submitPar.objectId=self.objectId();
		submitPar.status=self.status();
		submitPar.materialId=self.materialId();
		submitPar.goodsId=self.goodsId();
		submitPar.goodsTime=self.goodsTime();
		submitPar.technicianId=self.technicianId();
		submitPar.customerNote=self.customerNote();
		submitPar.note=self.note();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/clockorder", "POST", submitPar, function (data){
				ChangeUrl("./clock/ClockOrderList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/clockorder/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./clock/ClockOrderList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ClockOrderEditViewModel());
});