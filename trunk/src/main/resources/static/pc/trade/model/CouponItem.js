//定义ViewModel对象
var CouponItemEditViewModel = function () {  
	var self=this;
	self.itemId = ko.observable(''); 
	self.couponId = ko.observable(''); 
	self.objectType = ko.observable(''); 
	self.objectId = ko.observable(''); 
	self.status = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/couponitem/"+opid, "GET", null, function (data){
			self.itemId(data.itemId);
			self.couponId(data.couponId);
			self.objectType(data.objectType);
			self.objectId(data.objectId);
			self.status(data.status);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.couponId=self.couponId();
		submitPar.objectType=self.objectType();
		submitPar.objectId=self.objectId();
		submitPar.status=self.status();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/couponitem", "POST", submitPar, function (data){
				ChangeUrl("./trade/CouponItemList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/couponitem/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./trade/CouponItemList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new CouponItemEditViewModel());
});