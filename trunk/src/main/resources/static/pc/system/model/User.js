//定义ViewModel对象
var UserEditViewModel = function () {  
	var self=this;
	self.userId = ko.observable(''); 
	self.userName = ko.observable(''); 
	self.teamId = ko.observable(''); 
	self.nickName = ko.observable(''); 
	self.mobile = ko.observable(''); 
	self.email = ko.observable(''); 
	self.password = ko.observable(''); 
	self.repasswordDate = ko.observable(''); 
	self.status = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/user/"+opid, "GET", null, function (data){
			self.userId(data.userId);
			self.userName(data.userName);
			self.teamId(data.teamId);
			self.nickName(data.nickName);
			self.mobile(data.mobile);
			self.email(data.email);
			self.password(data.password);
			self.repasswordDate(data.repasswordDate);
			self.status(data.status);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.userName=self.userName();
		submitPar.teamId=self.teamId();
		submitPar.nickName=self.nickName();
		submitPar.mobile=self.mobile();
		submitPar.email=self.email();
		submitPar.password=self.password();
		submitPar.repasswordDate=self.repasswordDate();
		submitPar.status=self.status();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/user", "POST", submitPar, function (data){
				ChangeUrl("./system/UserList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/user/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./system/UserList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new UserEditViewModel());
});