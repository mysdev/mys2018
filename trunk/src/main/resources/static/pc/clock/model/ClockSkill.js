//定义ViewModel对象
var ClockSkillEditViewModel = function () {  
	var self=this;
	self.skillId = ko.observable(''); 
	self.skillName = ko.observable(''); 
	self.materialId = ko.observable(''); 
	self.isClock = ko.observable(''); 
	self.classs = ko.observable(''); 
	self.status = ko.observable(''); 
	self.createdBy = ko.observable(''); 
	self.createdDate = ko.observable(''); 
	self.updatedBy = ko.observable(''); 
	self.updatedDate = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	jQuery.ajax({
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
				self.createdBy(result.createdBy);
				self.createdDate(result.createdDate);
				self.updatedBy(result.updatedBy);
				self.updatedDate(result.updatedDate);
	        }
	    });
	}

	//【提交】按钮押下处理
    self.Commit = function () {    	
    	if(opFalg=="Add"){
    		var vStartTime=self.ondutyTime.toString();
    		var vEndTime=self.ondutyTime.toString();
	        jQuery.ajax({
	            type: "POST",
	            url: homeUrl+"/clockskill",  //新增接口
	            dataType: "json",
	            data: {
					skillId:self.skillId
	            },
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","/clock/ClockSkillList.html");
	                }
	                else{
	                	parent.dialog(result.message).showModal();
	                }	                
	            }
	        });
		}
    	else{
    		var opid=getQueryString('id');
    		jQuery.ajax({
	            type: "PUT",
	            url: homeUrl+"/clockskill/"+opid,  //修改接口
	            data: {
					skillId:opid
	            },
	            success: function (json) {
	                alert(json.result);
	                $("#mainframe", parent.window.document).attr("src","/clock/ClockSkillList.html");
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ClockSkillEditViewModel());
})