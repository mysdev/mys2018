//定义ViewModel对象
var StoreEditViewModel = function () {  
	var self=this;
	self.storeId = ko.observable(''); 
	self.storeName = ko.observable(''); 
	self.status = ko.observable(''); 
	self.address = ko.observable(''); 
	self.phone = ko.observable(''); 
	self.license = ko.observable(''); 
	self.sno = ko.observable(''); 
	self.logitude = ko.observable(''); 
	self.latitude = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/store/"+opid, "GET", null, function (data){
			self.storeId(data.storeId);
			self.storeName(data.storeName);
			self.status(data.status);
			self.address(data.address);
			self.phone(data.phone);
			self.license(data.license);
			self.sno(data.sno);
			self.logitude(data.logitude);
			self.latitude(data.latitude);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.storeName=self.storeName();
		submitPar.status=self.status();
		submitPar.address=self.address();
		submitPar.phone=self.phone();
		submitPar.license=self.license();
		submitPar.sno=self.sno();
		submitPar.logitude=self.logitude();
		submitPar.latitude=self.latitude();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/store", "POST", submitPar, function (data){
				ChangeUrl("./core/StoreList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/store/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/StoreList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new StoreEditViewModel());
});