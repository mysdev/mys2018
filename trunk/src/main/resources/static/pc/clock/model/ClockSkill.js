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
    	$.ajax({
	        type: 'GET',
	        url: homeUrl+"/clockskill/"+opid,
	        cache: false,
	        async: false,
	        dataType: "json",
	        success: function (result) {
				self.skillId(result.skillId);
				self.skillName(result.skillName);
				self.materialId(result.materialId);
				self.isClock(result.isClock);
				self.classs(result.classs);
				self.status(result.status);
	        }
	    });
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
	        $.ajax({
	            type: "POST",
	            url: homeUrl+"/clockskill",  //新增接口
	            dataType: "json",
	            contentType : "application/json", 
	            data: JSON.stringify(submitPar),
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","./mys/pc/clock/ClockSkillList.html");
	                }
	                else{
	                	parent.dialog(result.message).showModal();
	                }	                
	            }
	        });
		}
    	else{
    		var opid=getQueryString('id');
    		$.ajax({
	            type: "PUT",
	            url: homeUrl+"/clockskill/"+opid,  //修改接口
	            contentType : "application/json", 
	            data: JSON.stringify(submitPar),
	            success: function (json) {
	                $("#mainframe", parent.window.document).attr("src","./clock/ClockSkillList.html");
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ClockSkillEditViewModel());
});
