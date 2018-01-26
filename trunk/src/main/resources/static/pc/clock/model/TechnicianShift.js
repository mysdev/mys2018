//定义ViewModel对象
var TechnicianShiftEditViewModel = function () {  
	var self=this;
	self.shiftId = ko.observable(''); 
	self.shiftName = ko.observable(''); 
	self.inTime = ko.observable(''); 
	self.outTime = ko.observable(''); 
	self.status = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	jQuery.ajax({
	        type: 'GET',
	        url: homeUrl+"/technicianshift/"+opid,
	        cache: false,
	        async: false,
	        dataType: "json",
	        success: function (result) {
				self.shiftId(result.shiftId);
				self.shiftName(result.shiftName);
				self.inTime(result.inTime);
				self.outTime(result.outTime);
				self.status(result.status);
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
	            url: homeUrl+"/technicianshift",  //新增接口
	            dataType: "json",
	            data: {
					shiftId:self.shiftId
	            },
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","/clock/TechnicianShiftList.html");
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
	            url: homeUrl+"/technicianshift/"+opid,  //修改接口
	            data: {
					shiftId:opid
	            },
	            success: function (json) {
	                alert(json.result);
	                $("#mainframe", parent.window.document).attr("src","/clock/TechnicianShiftList.html");
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TechnicianShiftEditViewModel());
});