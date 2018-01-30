//定义ViewModel对象
var MemberRecordEditViewModel = function () {  
	var self=this;
	self.recordId = ko.observable(''); 
	self.memberId = ko.observable(''); 
	self.plusId = ko.observable(''); 
	self.plusMoney = ko.observable(''); 
	self.giftMoney = ko.observable(''); 
	self.employeeId = ko.observable(''); 
	self.money = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/memberrecord/"+opid, "GET", null, function (data){
			self.recordId(data.recordId);
			self.memberId(data.memberId);
			self.plusId(data.plusId);
			self.plusMoney(data.plusMoney);
			self.giftMoney(data.giftMoney);
			self.employeeId(data.employeeId);
			self.money(data.money);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.memberId=self.memberId();
		submitPar.plusId=self.plusId();
		submitPar.plusMoney=self.plusMoney();
		submitPar.giftMoney=self.giftMoney();
		submitPar.employeeId=self.employeeId();
		submitPar.money=self.money();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/memberrecord", "POST", submitPar, function (data){
				ChangeUrl("./core/MemberRecordList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/memberrecord/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/MemberRecordList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new MemberRecordEditViewModel());
});