//定义ViewModel对象
var AuthorizationEditViewModel = function () {  
	var self=this;
	self.authorizationId = ko.observable(''); 
	self.customerId = ko.observable(''); 
	self.types = ko.observable(''); 
	self.deviceId = ko.observable(''); 
	self.status = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/authorization/"+opid, "GET", null, function (data){
			self.authorizationId(data.authorizationId);
			self.customerId(data.customerId);
			self.types(data.types);
			self.deviceId(data.deviceId);
			self.status(data.status);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.customerId=self.customerId();
		submitPar.types=self.types();
		submitPar.deviceId=self.deviceId();
		submitPar.status=self.status();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/authorization", "POST", submitPar, function (data){
				ChangeUrl("./order/AuthorizationList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/authorization/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./order/AuthorizationList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new AuthorizationEditViewModel());
});