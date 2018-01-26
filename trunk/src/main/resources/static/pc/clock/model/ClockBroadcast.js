//定义ViewModel对象
var ClockBroadcastEditViewModel = function () {  
	var self=this;
	self.broadcastId = ko.observable(''); 
	self.stauts = ko.observable(''); 
	self.types = ko.observable(''); 
	self.content = ko.observable(''); 
	self.createdBy = ko.observable(''); 
	self.createdDate = ko.observable(''); 
	self.updatedBy = ko.observable(''); 
	self.updatedDate = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	jQuery.ajax({
	        type: 'GET',
	        url: homeUrl+"/clockbroadcast/"+opid,
	        cache: false,
	        async: false,
	        dataType: "json",
	        success: function (result) {
				self.broadcastId(result.broadcastId);
				self.stauts(result.stauts);
				self.types(result.types);
				self.content(result.content);
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
	            url: homeUrl+"/clockbroadcast",  //新增接口
	            dataType: "json",
	            data: {
					broadcastId:self.broadcastId
	            },
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","/clock/ClockBroadcastList.html");
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
	            url: homeUrl+"/clockbroadcast/"+opid,  //修改接口
	            data: {
					broadcastId:opid
	            },
	            success: function (json) {
	                alert(json.result);
	                $("#mainframe", parent.window.document).attr("src","/clock/ClockBroadcastList.html");
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ClockBroadcastEditViewModel());
});