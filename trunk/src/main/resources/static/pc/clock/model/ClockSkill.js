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
    	MyAjax("GET",
    		homeUrl+"/clockskill/"+opid,
    		null,
    		function(result){
    			self.skillId(result.skillId);
				self.skillName(result.skillName);
				self.materialId(result.materialId);
				self.isClock(result.isClock);
				self.classs(result.classs);
				self.status(result.status);
    		}
		);
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
    		MyAjax("POST",
	    		homeUrl+"/clockskill",
	    		submitPar,
	    		function(result){
                	ChangeUrl("./clock/ClockSkillList.html");
	    		}
			);
		}
    	else{
    		var opid=getQueryString('id');
    		MyAjax("PUT",
	    		homeUrl+"/clockskill/"+opid,
	    		submitPar,
	    		function(result){
                	parent.dialog(result.message).showModal();
	    		}
			);
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ClockSkillEditViewModel());
});
