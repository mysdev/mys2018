//定义ViewModel对象
var PackagesEditViewModel = function () {  
	var self=this;
	self.packageId = ko.observable(''); 
	self.storeId = ko.observable(''); 
	self.packageName = ko.observable(''); 
	self.pinyin = ko.observable(''); 
	self.price = ko.observable(''); 
	self.validDate = ko.observable(''); 
	self.status = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/packages/"+opid, "GET", null, function (data){
			self.packageId(data.packageId);
			self.storeId(data.storeId);
			self.packageName(data.packageName);
			self.pinyin(data.pinyin);
			self.price(data.price);
			self.validDate(data.validDate);
			self.status(data.status);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.storeId=self.storeId();
		submitPar.packageName=self.packageName();
		submitPar.pinyin=self.pinyin();
		submitPar.price=self.price();
		submitPar.validDate=self.validDate();
		submitPar.status=self.status();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/packages", "POST", submitPar, function (data){
				ChangeUrl("./order/PackagesList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/packages/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./order/PackagesList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new PackagesEditViewModel());
});