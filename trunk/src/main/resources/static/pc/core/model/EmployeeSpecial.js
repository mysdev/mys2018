//定义ViewModel对象
var EmployeeSpecialEditViewModel = function () {  
	var self=this;
	self.empId = ko.observable(''); 
	self.empPwd = ko.observable(''); 
	self.creditMount = ko.observable(''); 
	self.creditLeft = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/employeespecial/"+opid, "GET", null, function (data){
			self.empId(data.empId);
			self.empPwd(data.empPwd);
			self.creditMount(data.creditMount);
			self.creditLeft(data.creditLeft);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.empPwd=self.empPwd();
		submitPar.creditMount=self.creditMount();
		submitPar.creditLeft=self.creditLeft();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/employeespecial", "POST", submitPar, function (data){
				ChangeUrl("./core/EmployeeSpecialList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/employeespecial/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/EmployeeSpecialList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new EmployeeSpecialEditViewModel());
});