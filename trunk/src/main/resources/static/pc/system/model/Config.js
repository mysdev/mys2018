//定义ViewModel对象
var ConfigEditViewModel = function () {  
	var self=this;
	self.propertyId = ko.observable(''); 
	self.propertyCode = ko.observable(''); 
	self.propertyValue = ko.observable(''); 
	self.propertyNote = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/config/"+opid, "GET", null, function (data){
			self.propertyId(data.propertyId);
			self.propertyCode(data.propertyCode);
			self.propertyValue(data.propertyValue);
			self.propertyNote(data.propertyNote);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.propertyCode=self.propertyCode();
		submitPar.propertyValue=self.propertyValue();
		submitPar.propertyNote=self.propertyNote();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/config", "POST", submitPar, function (data){
				ChangeUrl("./system/ConfigList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/config/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./system/ConfigList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ConfigEditViewModel());
});