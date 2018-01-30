//定义ViewModel对象
var EmployeeEditViewModel = function () {  
	var self=this;
	self.empId = ko.observable(''); 
	self.empName = ko.observable(''); 
	self.pinyin = ko.observable(''); 
	self.empNo = ko.observable(''); 
	self.userId = ko.observable(''); 
	self.storeId = ko.observable(''); 
	self.dptId = ko.observable(''); 
	self.entryDate = ko.observable(''); 
	self.quitDate = ko.observable(''); 
	self.status = ko.observable(''); 
	self.isManager = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/employee/"+opid, "GET", null, function (data){
			self.empId(data.empId);
			self.empName(data.empName);
			self.pinyin(data.pinyin);
			self.empNo(data.empNo);
			self.userId(data.userId);
			self.storeId(data.storeId);
			self.dptId(data.dptId);
			self.entryDate(data.entryDate);
			self.quitDate(data.quitDate);
			self.status(data.status);
			self.isManager(data.isManager);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.empName=self.empName();
		submitPar.pinyin=self.pinyin();
		submitPar.empNo=self.empNo();
		submitPar.userId=self.userId();
		submitPar.storeId=self.storeId();
		submitPar.dptId=self.dptId();
		submitPar.entryDate=self.entryDate();
		submitPar.quitDate=self.quitDate();
		submitPar.status=self.status();
		submitPar.isManager=self.isManager();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/employee", "POST", submitPar, function (data){
				ChangeUrl("./core/EmployeeList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/employee/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/EmployeeList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new EmployeeEditViewModel());
});