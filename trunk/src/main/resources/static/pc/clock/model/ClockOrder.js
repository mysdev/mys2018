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
	self.createdBy = ko.observable(''); 
	self.createdDate = ko.observable(''); 
	self.updatedBy = ko.observable(''); 
	self.updatedDate = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	jQuery.ajax({
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
	            url: homeUrl+"/clockorder",  //新增接口
	            dataType: "json",
	            data: {
					orderId:self.orderId
	            },
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
    		jQuery.ajax({
	            type: "PUT",
	            url: homeUrl+"/clockorder/"+opid,  //修改接口
	            data: {
					orderId:opid
	            },
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
})