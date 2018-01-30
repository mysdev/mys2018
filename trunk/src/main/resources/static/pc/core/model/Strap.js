//定义ViewModel对象
var StrapEditViewModel = function () {  
	var self=this;
	self.strapId = ko.observable(''); 
	self.storeId = ko.observable(''); 
	self.strapSerial = ko.observable(''); 
	self.strapNo = ko.observable(''); 
	self.types = ko.observable(''); 
	self.status = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/strap/"+opid, "GET", null, function (data){
			self.strapId(data.strapId);
			self.storeId(data.storeId);
			self.strapSerial(data.strapSerial);
			self.strapNo(data.strapNo);
			self.types(data.types);
			self.status(data.status);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.storeId=self.storeId();
		submitPar.strapSerial=self.strapSerial();
		submitPar.strapNo=self.strapNo();
		submitPar.types=self.types();
		submitPar.status=self.status();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/strap", "POST", submitPar, function (data){
				ChangeUrl("./core/StrapList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/strap/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/StrapList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new StrapEditViewModel());
});