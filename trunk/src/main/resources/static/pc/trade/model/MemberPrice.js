//定义ViewModel对象
var MemberPriceEditViewModel = function () {  
	var self=this;
	self.priceId = ko.observable(''); 
	self.levelId = ko.observable(''); 
	self.objectType = ko.observable(''); 
	self.objectId = ko.observable(''); 
	self.price = ko.observable(''); 
	self.discount = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/memberprice/"+opid, "GET", null, function (data){
			self.priceId(data.priceId);
			self.levelId(data.levelId);
			self.objectType(data.objectType);
			self.objectId(data.objectId);
			self.price(data.price);
			self.discount(data.discount);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.levelId=self.levelId();
		submitPar.objectType=self.objectType();
		submitPar.objectId=self.objectId();
		submitPar.price=self.price();
		submitPar.discount=self.discount();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/memberprice", "POST", submitPar, function (data){
				ChangeUrl("./trade/MemberPriceList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/memberprice/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./trade/MemberPriceList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new MemberPriceEditViewModel());
});