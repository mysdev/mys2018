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
    	myAjax("/technicianskill/"+opid, "GET", null, doQueryActionSuccess, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.skillId=self.skillId();
		submitPar.technicianId=self.technicianId();
		submitPar.skillLevel=self.skillLevel();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/technicianskill", "POST", null, doActionSuccess, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/technicianskill/"+opid, "PUT", null, doActionSuccess, true);
    	}
    };
};

function doQueryActionSuccess(data){
	self.tsId(data.tsId);
	self.skillId(data.skillId);
	self.technicianId(data.technicianId);
	self.skillLevel(data.skillLevel);
}

function doActionSuccess(data){
	ChangeUrl("./clock/TechnicianSkillList.html");
}

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TechnicianSkillEditViewModel());
});