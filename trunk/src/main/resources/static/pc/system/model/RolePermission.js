//定义ViewModel对象
var RolePermissionEditViewModel = function () {  
	var self=this;
	self.roleId = ko.observable(''); 
	self.resourceId = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/rolepermission/"+opid, "GET", null, function (data){
			self.roleId(data.roleId);
			self.resourceId(data.resourceId);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.resourceId=self.resourceId();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/rolepermission", "POST", submitPar, function (data){
				ChangeUrl("./system/RolePermissionList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/rolepermission/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./system/RolePermissionList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new RolePermissionEditViewModel());
});