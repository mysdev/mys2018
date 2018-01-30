//定义ViewModel对象
var MemberPlusEditViewModel = function () {  
	var self=this;
	self.plusId = ko.observable(''); 
	self.plusName = ko.observable(''); 
	self.plusMoney = ko.observable(''); 
	self.giftMoney = ko.observable(''); 
	self.money = ko.observable(''); 
	self.status = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/memberplus/"+opid, "GET", null, function (data){
			self.plusId(data.plusId);
			self.plusName(data.plusName);
			self.plusMoney(data.plusMoney);
			self.giftMoney(data.giftMoney);
			self.money(data.money);
			self.status(data.status);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.plusName=self.plusName();
		submitPar.plusMoney=self.plusMoney();
		submitPar.giftMoney=self.giftMoney();
		submitPar.money=self.money();
		submitPar.status=self.status();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/memberplus", "POST", submitPar, function (data){
				ChangeUrl("./core/MemberPlusList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/memberplus/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/MemberPlusList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new MemberPlusEditViewModel());
});