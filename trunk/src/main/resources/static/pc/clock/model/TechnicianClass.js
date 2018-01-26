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
	self.createdBy = ko.observable(''); 
	self.createdDate = ko.observable(''); 
	self.updatedBy = ko.observable(''); 
	self.updatedDate = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	jQuery.ajax({
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
	            url: homeUrl+"/technicianclass",  //新增接口
	            dataType: "json",
	            data: {
					detailId:self.detailId
	            },
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
    		jQuery.ajax({
	            type: "PUT",
	            url: homeUrl+"/technicianclass/"+opid,  //修改接口
	            data: {
					detailId:opid
	            },
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