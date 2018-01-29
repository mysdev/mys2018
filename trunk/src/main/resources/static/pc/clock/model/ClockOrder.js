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
	            url: homeUrl+"/clockorder",  //新增接口
	            dataType: "json",
	            data: {
								authorizationId:self.authorizationId(),
								types:self.types(),
								objectId:self.objectId(),
								status:self.status(),
								materialId:self.materialId(),
								goodsId:self.goodsId(),
								goodsTime:self.goodsTime(),
								technicianId:self.technicianId(),
								customerNote:self.customerNote(),
								note:self.note(),
								orderId:null
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
    		$.ajax({
	            type: "PUT",
	            url: homeUrl+"/clockorder/"+opid,  //修改接口
	            data: {
								authorizationId:self.authorizationId(),
								types:self.types(),
								objectId:self.objectId(),
								status:self.status(),
								materialId:self.materialId(),
								goodsId:self.goodsId(),
								goodsTime:self.goodsTime(),
								technicianId:self.technicianId(),
								customerNote:self.customerNote(),
								note:self.note(),
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
});
