//定义ViewModel对象
var LogEditViewModel = function () {  
	var self=this;
	self.logId = ko.observable(''); 
	self.userId = ko.observable(''); 
	self.userIp = ko.observable(''); 
	self.oper = ko.observable(''); 
	self.operUa = ko.observable(''); 
	self.operType = ko.observable(''); 
	self.operStatus = ko.observable(''); 
	self.request = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/log/"+opid, "GET", null, function (data){
			self.logId(data.logId);
			self.userId(data.userId);
			self.userIp(data.userIp);
			self.oper(data.oper);
			self.operUa(data.operUa);
			self.operType(data.operType);
			self.operStatus(data.operStatus);
			self.request(data.request);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.userId=self.userId();
		submitPar.userIp=self.userIp();
		submitPar.oper=self.oper();
		submitPar.operUa=self.operUa();
		submitPar.operType=self.operType();
		submitPar.operStatus=self.operStatus();
		submitPar.request=self.request();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/log", "POST", submitPar, function (data){
				ChangeUrl("./system/LogList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/log/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./system/LogList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new LogEditViewModel());
});