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
    	$.ajax({
	        type: 'GET',
	        url: homeUrl+"/technicianskill/"+opid,
	        cache: false,
	        async: false,
	        dataType: "json",
	        success: function (result) {
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
	        $.ajax({
	            type: "POST",
	            url: homeUrl+"/technicianskill",  //新增接口
	            dataType: "json",
	            data: {
								skillId:self.skillId(),
								technicianId:self.technicianId(),
								skillLevel:self.skillLevel(),
								tsId:null
	            },
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","/clock/TechnicianSkillList.html");
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
	            url: homeUrl+"/technicianskill/"+opid,  //修改接口
	            data: {
								skillId:self.skillId(),
								technicianId:self.technicianId(),
								skillLevel:self.skillLevel(),
					tsId:opid
	            },
	            success: function (json) {
	                alert(json.result);
	                $("#mainframe", parent.window.document).attr("src","/clock/TechnicianSkillList.html");
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TechnicianSkillEditViewModel());
});
