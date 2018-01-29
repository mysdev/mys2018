//定义ViewModel对象
var ClockRecordEditViewModel = function () {  
	var self=this;
	self.recordId = ko.observable(''); 
	self.orderId = ko.observable(''); 
	self.technicianId = ko.observable(''); 
	self.classId = ko.observable(''); 
	self.status = ko.observable(''); 
	self.beginTime = ko.observable(''); 
	self.endTime = ko.observable(''); 
	self.actureTime = ko.observable(''); 
	self.recordStatus = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	$.ajax({
	        type: 'GET',
	        url: homeUrl+"/clockrecord/"+opid,
	        cache: false,
	        async: false,
	        dataType: "json",
	        success: function (result) {
				self.recordId(result.recordId);
				self.orderId(result.orderId);
				self.technicianId(result.technicianId);
				self.classId(result.classId);
				self.status(result.status);
				self.beginTime(result.beginTime);
				self.endTime(result.endTime);
				self.actureTime(result.actureTime);
				self.recordStatus(result.recordStatus);
	        }
	    });
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.orderId=self.orderId();
		submitPar.technicianId=self.technicianId();
		submitPar.classId=self.classId();
		submitPar.status=self.status();
		submitPar.beginTime=self.beginTime();
		submitPar.endTime=self.endTime();
		submitPar.actureTime=self.actureTime();
		submitPar.recordStatus=self.recordStatus();
    	
    	if(opFalg=="Add"){
	        $.ajax({
	            type: "POST",
	            url: homeUrl+"/clockrecord",  //新增接口
	            dataType: "json",
	            contentType : "application/json", 
	            data: JSON.stringify(submitPar),
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","./clock/ClockRecordList.html");
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
	            url: homeUrl+"/clockrecord/"+opid,  //修改接口
	            contentType : "application/json", 
	            data: JSON.stringify(submitPar),
	            success: function (json) {
	                alert(json.result);
	                $("#mainframe", parent.window.document).attr("src","./clock/ClockRecordList.html");
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ClockRecordEditViewModel());
});
