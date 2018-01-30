//定义ViewModel对象
var ClockSkillEditViewModel = function () {  
	var self=this;
	self.skillId = ko.observable(''); 
	self.skillName = ko.observable(''); 
	self.materialId = ko.observable(''); 
	self.isClock = ko.observable(''); 
	self.classs = ko.observable(''); 
	self.status = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/clockskill/"+opid, "GET", null, function (data){
			self.skillId(data.skillId);
			self.skillName(data.skillName);
			self.materialId(data.materialId);
			self.isClock(data.isClock);
			self.classs(data.classs);
			self.status(data.status);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.skillName=self.skillName();
		submitPar.materialId=self.materialId();
		submitPar.isClock=self.isClock();
		submitPar.classs=self.classs();
		submitPar.status=self.status();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/clockskill", "POST", submitPar, function (data){
				ChangeUrl("./clock/ClockSkillList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/clockskill/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./clock/ClockSkillList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ClockSkillEditViewModel());
});