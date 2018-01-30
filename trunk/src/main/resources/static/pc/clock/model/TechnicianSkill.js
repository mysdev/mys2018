//定义ViewModel对象
var TechnicianSkillEditViewModel = function () {  
	var self=this;
	self.tsId = ko.observable(''); 
	self.skillId = ko.observable(''); 
	self.technicianId = ko.observable(''); 
	self.skillLevel = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/technicianskill/"+opid, "GET", null, function (data){
			self.tsId(data.tsId);
			self.skillId(data.skillId);
			self.technicianId(data.technicianId);
			self.skillLevel(data.skillLevel);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.skillId=self.skillId();
		submitPar.technicianId=self.technicianId();
		submitPar.skillLevel=self.skillLevel();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/technicianskill", "POST", submitPar, function (data){
				ChangeUrl("./clock/TechnicianSkillList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/technicianskill/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./clock/TechnicianSkillList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TechnicianSkillEditViewModel());
});