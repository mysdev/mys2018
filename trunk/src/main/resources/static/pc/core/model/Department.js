//定义ViewModel对象
var DepartmentEditViewModel = function () {  
	var self=this;
	self.dptId = ko.observable(''); 
	self.storeId = ko.observable(''); 
	self.treamId = ko.observable(''); 
	self.dptName = ko.observable(''); 
	self.dptNo = ko.observable(''); 
	self.status = ko.observable(''); 
	self.parentId = ko.observable(''); 
	self.dutyName = ko.observable(''); 
	self.dutyMobile = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/department/"+opid, "GET", null, function (data){
			self.dptId(data.dptId);
			self.storeId(data.storeId);
			self.treamId(data.treamId);
			self.dptName(data.dptName);
			self.dptNo(data.dptNo);
			self.status(data.status);
			self.parentId(data.parentId);
			self.dutyName(data.dutyName);
			self.dutyMobile(data.dutyMobile);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.storeId=self.storeId();
		submitPar.treamId=self.treamId();
		submitPar.dptName=self.dptName();
		submitPar.dptNo=self.dptNo();
		submitPar.status=self.status();
		submitPar.parentId=self.parentId();
		submitPar.dutyName=self.dutyName();
		submitPar.dutyMobile=self.dutyMobile();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/department", "POST", submitPar, function (data){
				ChangeUrl("./core/DepartmentList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/department/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/DepartmentList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new DepartmentEditViewModel());
});