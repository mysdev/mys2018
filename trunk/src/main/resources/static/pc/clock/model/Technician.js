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

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	$.ajax({
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
	        }
	    });
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.empId=self.empId();
		submitPar.techNo=self.techNo();
		submitPar.techCard=self.techCard();
		submitPar.techName=self.techName();
		submitPar.sex=self.sex();
		submitPar.shiftId=self.shiftId();
		submitPar.status=self.status();
		submitPar.shiftStatus=self.shiftStatus();
    	
    	if(opFalg=="Add"){
	        $.ajax({
	            type: "POST",
	            url: homeUrl+"/technician",  //新增接口
	            dataType: "json",
	            data: $.toJSON(submitPar),
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
    		$.ajax({
	            type: "PUT",
	            url: homeUrl+"/technician/"+opid,  //修改接口
	            data: $.toJSON(submitPar),
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
