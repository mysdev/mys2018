//定义ViewModel对象
var UserRoleEditViewModel = function () {  
	var self=this;
	self.userId = ko.observable(''); 
	self.roleId = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/userrole/"+opid, "GET", null, function (data){
			self.userId(data.userId);
			self.roleId(data.roleId);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.roleId=self.roleId();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/userrole", "POST", submitPar, function (data){
				ChangeUrl("./system/UserRoleList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/userrole/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./system/UserRoleList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new UserRoleEditViewModel());
});