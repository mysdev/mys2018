//定义ViewModel对象
var TechnicianEditViewModel = function () {  
	var self=this;
	self.technicianId = ko.observable(''); 
	self.empId = ko.observable(''); 
	self.techNo = ko.observable(''); 
	self.techCard = ko.observable(''); 
	self.techName = ko.observable(''); 
	self.sex = ko.observable(''); 
	self.shiftId = ko.observable(''); 
	self.status = ko.observable(''); 
	self.shiftStatus = ko.observable(''); 
	self.createdBy = ko.observable(''); 
	self.createdDate = ko.observable(''); 
	self.updatedBy = ko.observable(''); 
	self.updatedDate = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	jQuery.ajax({
	        type: 'GET',
	        url: homeUrl+"/technician/"+opid,
	        cache: false,
	        async: false,
	        dataType: "json",
	        success: function (result) {
				self.technicianId(result.technicianId);
				self.empId(result.empId);
				self.techNo(result.techNo);
				self.techCard(result.techCard);
				self.techName(result.techName);
				self.sex(result.sex);
				self.shiftId(result.shiftId);
				self.status(result.status);
				self.shiftStatus(result.shiftStatus);
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
	            url: homeUrl+"/technician",  //新增接口
	            dataType: "json",
	            data: {
					technicianId:self.technicianId
	            },
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","/clock/TechnicianList.html");
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
	            url: homeUrl+"/technician/"+opid,  //修改接口
	            data: {
					technicianId:opid
	            },
	            success: function (json) {
	                alert(json.result);
	                $("#mainframe", parent.window.document).attr("src","/clock/TechnicianList.html");
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TechnicianEditViewModel());
});