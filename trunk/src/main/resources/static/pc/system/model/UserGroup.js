//定义ViewModel对象
var UserGroupEditViewModel = function () {  
	var self=this;
	self.teamId = ko.observable(''); 
	self.teamName = ko.observable(''); 
	self.parentTeam = ko.observable(''); 
	self.status = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/usergroup/"+opid, "GET", null, function (data){
			self.teamId(data.teamId);
			self.teamName(data.teamName);
			self.parentTeam(data.parentTeam);
			self.status(data.status);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.teamName=self.teamName();
		submitPar.parentTeam=self.parentTeam();
		submitPar.status=self.status();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/usergroup", "POST", submitPar, function (data){
				ChangeUrl("./system/UserGroupList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/usergroup/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./system/UserGroupList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new UserGroupEditViewModel());
});