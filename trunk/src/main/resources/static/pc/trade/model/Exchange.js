//定义ViewModel对象
var ExchangeEditViewModel = function () {  
	var self=this;
	self.exchangeId = ko.observable(''); 
	self.exchangeName = ko.observable(''); 
	self.exchangeRate = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/exchange/"+opid, "GET", null, function (data){
			self.exchangeId(data.exchangeId);
			self.exchangeName(data.exchangeName);
			self.exchangeRate(data.exchangeRate);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.exchangeName=self.exchangeName();
		submitPar.exchangeRate=self.exchangeRate();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/exchange", "POST", submitPar, function (data){
				ChangeUrl("./trade/ExchangeList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/exchange/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./trade/ExchangeList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ExchangeEditViewModel());
});