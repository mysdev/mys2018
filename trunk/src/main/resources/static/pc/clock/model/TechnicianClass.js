//定义ViewModel对象
var TechnicianClassEditViewModel = function () {  
	var self=this;
	self.detailId = ko.observable(''); 
	self.classId = ko.observable(''); 
	self.technicianId = ko.observable(''); 
	self.clockCt = ko.observable(''); 
	self.isWork = ko.observable(''); 
	self.technicianLevel = ko.observable(''); 
	self.priority = ko.observable(''); 
	self.seqencing = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	$.ajax({
	        type: 'GET',
	        url: homeUrl+"/technicianclass/"+opid,
	        cache: false,
	        async: false,
	        dataType: "json",
	        success: function (result) {
				self.detailId(result.detailId);
				self.classId(result.classId);
				self.technicianId(result.technicianId);
				self.clockCt(result.clockCt);
				self.isWork(result.isWork);
				self.technicianLevel(result.technicianLevel);
				self.priority(result.priority);
				self.seqencing(result.seqencing);
	        }
	    });
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.classId=self.classId();
		submitPar.technicianId=self.technicianId();
		submitPar.clockCt=self.clockCt();
		submitPar.isWork=self.isWork();
		submitPar.technicianLevel=self.technicianLevel();
		submitPar.priority=self.priority();
		submitPar.seqencing=self.seqencing();
    	
    	if(opFalg=="Add"){
	        $.ajax({
	            type: "POST",
	            url: homeUrl+"/technicianclass",  //新增接口
	            dataType: "json",
	            contentType : "application/json", 
	            data: JSON.stringify(submitPar),
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","/clock/TechnicianClassList.html");
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
	            url: homeUrl+"/technicianclass/"+opid,  //修改接口
	            contentType : "application/json", 
	            data: JSON.stringify(submitPar),
	            success: function (json) {
	                alert(json.result);
	                $("#mainframe", parent.window.document).attr("src","/clock/TechnicianClassList.html");
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TechnicianClassEditViewModel());
});
