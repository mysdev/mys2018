//定义ViewModel对象
var SettlementEditViewModel = function () {  
	var self=this;
	self.settlementId = ko.observable(''); 
	self.serialNumber = ko.observable(''); 
	self.settlementTime = ko.observable(''); 
	self.markedPrice = ko.observable(''); 
	self.discountPrice = ko.observable(''); 
	self.reductionPrice = ko.observable(''); 
	self.dealPrice = ko.observable(''); 
	self.exchangeId = ko.observable(''); 
	self.payPrice = ko.observable(''); 
	self.empId = ko.observable(''); 
	self.memberId = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/settlement/"+opid, "GET", null, function (data){
			self.settlementId(data.settlementId);
			self.serialNumber(data.serialNumber);
			self.settlementTime(data.settlementTime);
			self.markedPrice(data.markedPrice);
			self.discountPrice(data.discountPrice);
			self.reductionPrice(data.reductionPrice);
			self.dealPrice(data.dealPrice);
			self.exchangeId(data.exchangeId);
			self.payPrice(data.payPrice);
			self.empId(data.empId);
			self.memberId(data.memberId);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.serialNumber=self.serialNumber();
		submitPar.settlementTime=self.settlementTime();
		submitPar.markedPrice=self.markedPrice();
		submitPar.discountPrice=self.discountPrice();
		submitPar.reductionPrice=self.reductionPrice();
		submitPar.dealPrice=self.dealPrice();
		submitPar.exchangeId=self.exchangeId();
		submitPar.payPrice=self.payPrice();
		submitPar.empId=self.empId();
		submitPar.memberId=self.memberId();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/settlement", "POST", submitPar, function (data){
				ChangeUrl("./trade/SettlementList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/settlement/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./trade/SettlementList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new SettlementEditViewModel());
});