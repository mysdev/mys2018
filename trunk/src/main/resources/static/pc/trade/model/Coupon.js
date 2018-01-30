//定义ViewModel对象
var CouponEditViewModel = function () {  
	var self=this;
	self.couponId = ko.observable(''); 
	self.couponName = ko.observable(''); 
	self.types = ko.observable(''); 
	self.totalCount = ko.observable(''); 
	self.allowance = ko.observable(''); 
	self.totalPrice = ko.observable(''); 
	self.fromTime = ko.observable(''); 
	self.toTime = ko.observable(''); 
	self.status = ko.observable(''); 
	self.isStack = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/coupon/"+opid, "GET", null, function (data){
			self.couponId(data.couponId);
			self.couponName(data.couponName);
			self.types(data.types);
			self.totalCount(data.totalCount);
			self.allowance(data.allowance);
			self.totalPrice(data.totalPrice);
			self.fromTime(data.fromTime);
			self.toTime(data.toTime);
			self.status(data.status);
			self.isStack(data.isStack);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.couponName=self.couponName();
		submitPar.types=self.types();
		submitPar.totalCount=self.totalCount();
		submitPar.allowance=self.allowance();
		submitPar.totalPrice=self.totalPrice();
		submitPar.fromTime=self.fromTime();
		submitPar.toTime=self.toTime();
		submitPar.status=self.status();
		submitPar.isStack=self.isStack();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/coupon", "POST", submitPar, function (data){
				ChangeUrl("./trade/CouponList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/coupon/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./trade/CouponList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new CouponEditViewModel());
});