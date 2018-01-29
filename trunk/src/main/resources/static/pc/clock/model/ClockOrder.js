//定义ViewModel对象
var ClockOrderEditViewModel = function () {  
	var self=this;
	self.orderId = ko.observable(''); 
	self.authorizationId = ko.observable(''); 
	self.types = ko.observable(''); 
	self.objectId = ko.observable(''); 
	self.status = ko.observable(''); 
	self.materialId = ko.observable(''); 
	self.goodsId = ko.observable(''); 
	self.goodsTime = ko.observable(''); 
	self.technicianId = ko.observable(''); 
	self.customerNote = ko.observable(''); 
	self.note = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	$.ajax({
	        type: 'GET',
	        url: homeUrl+"/clockorder/"+opid,
	        cache: false,
	        async: false,
	        dataType: "json",
	        success: function (result) {
				self.orderId(result.orderId);
				self.authorizationId(result.authorizationId);
				self.types(result.types);
				self.objectId(result.objectId);
				self.status(result.status);
				self.materialId(result.materialId);
				self.goodsId(result.goodsId);
				self.goodsTime(result.goodsTime);
				self.technicianId(result.technicianId);
				self.customerNote(result.customerNote);
				self.note(result.note);
	        }
	    });
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.authorizationId=self.authorizationId();
		submitPar.types=self.types();
		submitPar.objectId=self.objectId();
		submitPar.status=self.status();
		submitPar.materialId=self.materialId();
		submitPar.goodsId=self.goodsId();
		submitPar.goodsTime=self.goodsTime();
		submitPar.technicianId=self.technicianId();
		submitPar.customerNote=self.customerNote();
		submitPar.note=self.note();
    	
    	if(opFalg=="Add"){
	        $.ajax({
	            type: "POST",
	            url: homeUrl+"/clockorder",  //新增接口
	            dataType: "json",
	            contentType : "application/json", 
	            data: JSON.stringify(submitPar),
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","/clock/ClockOrderList.html");
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
	            url: homeUrl+"/clockorder/"+opid,  //修改接口
	            contentType : "application/json", 
	            data: JSON.stringify(submitPar),
	            success: function (json) {
	                alert(json.result);
	                $("#mainframe", parent.window.document).attr("src","/clock/ClockOrderList.html");
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ClockOrderEditViewModel());
});
