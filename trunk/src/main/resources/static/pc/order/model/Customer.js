//定义ViewModel对象
var CustomerEditViewModel = function () {  
	var self=this;
	self.customerId = ko.observable(''); 
	self.customerName = ko.observable(''); 
	self.advance = ko.observable(''); 
	self.note = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/customer/"+opid, "GET", null, function (data){
			self.customerId(data.customerId);
			self.customerName(data.customerName);
			self.advance(data.advance);
			self.note(data.note);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.customerName=self.customerName();
		submitPar.advance=self.advance();
		submitPar.note=self.note();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/customer", "POST", submitPar, function (data){
				ChangeUrl("./order/CustomerList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/customer/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./order/CustomerList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new CustomerEditViewModel());
});