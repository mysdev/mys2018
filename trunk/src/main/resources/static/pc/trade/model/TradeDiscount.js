//定义ViewModel对象
var TradeDiscountEditViewModel = function () {  
	var self=this;
	self.discountId = ko.observable(''); 
	self.serialNumber = ko.observable(''); 
	self.couponId = ko.observable(''); 
	self.volumeId = ko.observable(''); 
	self.discountPrice = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/tradediscount/"+opid, "GET", null, function (data){
			self.discountId(data.discountId);
			self.serialNumber(data.serialNumber);
			self.couponId(data.couponId);
			self.volumeId(data.volumeId);
			self.discountPrice(data.discountPrice);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.serialNumber=self.serialNumber();
		submitPar.couponId=self.couponId();
		submitPar.volumeId=self.volumeId();
		submitPar.discountPrice=self.discountPrice();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/tradediscount", "POST", submitPar, function (data){
				ChangeUrl("./trade/TradeDiscountList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/tradediscount/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./trade/TradeDiscountList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TradeDiscountEditViewModel());
});