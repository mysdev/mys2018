//定义ViewModel对象
var TradeEditViewModel = function () {  
	var self=this;
	self.tradeId = ko.observable(''); 
	self.serialNumber = ko.observable(''); 
	self.customerId = ko.observable(''); 
	self.customerCt = ko.observable(''); 
	self.authorizationId = ko.observable(''); 
	self.objectType = ko.observable(''); 
	self.objectId = ko.observable(''); 
	self.objectCt = ko.observable(''); 
	self.status = ko.observable(''); 
	self.note = ko.observable(''); 
	self.markedPrice = ko.observable(''); 
	self.discountPrice = ko.observable(''); 
	self.dealPrice = ko.observable(''); 
	self.couponId = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/trade/"+opid, "GET", null, function (data){
			self.tradeId(data.tradeId);
			self.serialNumber(data.serialNumber);
			self.customerId(data.customerId);
			self.customerCt(data.customerCt);
			self.authorizationId(data.authorizationId);
			self.objectType(data.objectType);
			self.objectId(data.objectId);
			self.objectCt(data.objectCt);
			self.status(data.status);
			self.note(data.note);
			self.markedPrice(data.markedPrice);
			self.discountPrice(data.discountPrice);
			self.dealPrice(data.dealPrice);
			self.couponId(data.couponId);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.serialNumber=self.serialNumber();
		submitPar.customerId=self.customerId();
		submitPar.customerCt=self.customerCt();
		submitPar.authorizationId=self.authorizationId();
		submitPar.objectType=self.objectType();
		submitPar.objectId=self.objectId();
		submitPar.objectCt=self.objectCt();
		submitPar.status=self.status();
		submitPar.note=self.note();
		submitPar.markedPrice=self.markedPrice();
		submitPar.discountPrice=self.discountPrice();
		submitPar.dealPrice=self.dealPrice();
		submitPar.couponId=self.couponId();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/trade", "POST", submitPar, function (data){
				ChangeUrl("./trade/TradeList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/trade/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./trade/TradeList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TradeEditViewModel());
});