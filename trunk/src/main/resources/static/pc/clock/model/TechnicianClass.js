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
	            url: homeUrl+"/technicianclass",  //新增接口
	            dataType: "json",
	            data: {
								classId:self.classId(),
								technicianId:self.technicianId(),
								clockCt:self.clockCt(),
								isWork:self.isWork(),
								technicianLevel:self.technicianLevel(),
								priority:self.priority(),
								seqencing:self.seqencing(),
								detailId:null
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
    		$.ajax({
	            type: "PUT",
	            url: homeUrl+"/technicianclass/"+opid,  //修改接口
	            data: {
								classId:self.classId(),
								technicianId:self.technicianId(),
								clockCt:self.clockCt(),
								isWork:self.isWork(),
								technicianLevel:self.technicianLevel(),
								priority:self.priority(),
								seqencing:self.seqencing(),
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
