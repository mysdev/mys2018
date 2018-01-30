//定义ViewModel对象
var RoleInfoEditViewModel = function () {  
	var self=this;
	self.roleId = ko.observable(''); 
	self.roleName = ko.observable(''); 
	self.roleTitle = ko.observable(''); 
	self.parentId = ko.observable(''); 
	self.roleType = ko.observable(''); 
	self.isGlobal = ko.observable(''); 
	self.enabled = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/roleinfo/"+opid, "GET", null, function (data){
			self.roleId(data.roleId);
			self.roleName(data.roleName);
			self.roleTitle(data.roleTitle);
			self.parentId(data.parentId);
			self.roleType(data.roleType);
			self.isGlobal(data.isGlobal);
			self.enabled(data.enabled);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.roleName=self.roleName();
		submitPar.roleTitle=self.roleTitle();
		submitPar.parentId=self.parentId();
		submitPar.roleType=self.roleType();
		submitPar.isGlobal=self.isGlobal();
		submitPar.enabled=self.enabled();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/roleinfo", "POST", submitPar, function (data){
				ChangeUrl("./system/RoleInfoList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/roleinfo/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./system/RoleInfoList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new RoleInfoEditViewModel());
});