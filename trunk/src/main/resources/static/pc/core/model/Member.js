//定义ViewModel对象
var MemberEditViewModel = function () {  
	var self=this;
	self.memberId = ko.observable(''); 
	self.memberName = ko.observable(''); 
	self.pinyin = ko.observable(''); 
	self.status = ko.observable(''); 
	self.rfm = ko.observable(''); 
	self.levelId = ko.observable(''); 
	self.memberCard = ko.observable(''); 
	self.memberPassword = ko.observable(''); 
	self.integral = ko.observable(''); 
	self.balance = ko.observable(''); 
	self.mobile = ko.observable(''); 
	self.mail = ko.observable(''); 
	self.birthday = ko.observable(''); 
	self.storeId = ko.observable(''); 
	self.totalFee = ko.observable(''); 
	self.sex = ko.observable(''); 
	self.address = ko.observable(''); 
	self.cardType = ko.observable(''); 
	self.cardNo = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/member/"+opid, "GET", null, function (data){
			self.memberId(data.memberId);
			self.memberName(data.memberName);
			self.pinyin(data.pinyin);
			self.status(data.status);
			self.rfm(data.rfm);
			self.levelId(data.levelId);
			self.memberCard(data.memberCard);
			self.memberPassword(data.memberPassword);
			self.integral(data.integral);
			self.balance(data.balance);
			self.mobile(data.mobile);
			self.mail(data.mail);
			self.birthday(data.birthday);
			self.storeId(data.storeId);
			self.totalFee(data.totalFee);
			self.sex(data.sex);
			self.address(data.address);
			self.cardType(data.cardType);
			self.cardNo(data.cardNo);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.memberName=self.memberName();
		submitPar.pinyin=self.pinyin();
		submitPar.status=self.status();
		submitPar.rfm=self.rfm();
		submitPar.levelId=self.levelId();
		submitPar.memberCard=self.memberCard();
		submitPar.memberPassword=self.memberPassword();
		submitPar.integral=self.integral();
		submitPar.balance=self.balance();
		submitPar.mobile=self.mobile();
		submitPar.mail=self.mail();
		submitPar.birthday=self.birthday();
		submitPar.storeId=self.storeId();
		submitPar.totalFee=self.totalFee();
		submitPar.sex=self.sex();
		submitPar.address=self.address();
		submitPar.cardType=self.cardType();
		submitPar.cardNo=self.cardNo();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/member", "POST", submitPar, function (data){
				ChangeUrl("./core/MemberList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/member/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/MemberList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new MemberEditViewModel());
});