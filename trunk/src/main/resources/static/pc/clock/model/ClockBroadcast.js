//定义ViewModel对象
var ClockBroadcastEditViewModel = function () {  
	var self=this;
	self.broadcastId = ko.observable(''); 
	self.stauts = ko.observable(''); 
	self.types = ko.observable(''); 
	self.content = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	$.ajax({
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
	        }
	    });
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.stauts=self.stauts();
		submitPar.types=self.types();
		submitPar.content=self.content();
    	
    	if(opFalg=="Add"){
	        $.ajax({
	            type: "POST",
	            url: homeUrl+"/clockbroadcast",  //新增接口
	            dataType: "json",
	            contentType : "application/json", 
	            data: JSON.stringify(submitPar),
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","./clock/ClockBroadcastList.html");
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
	            url: homeUrl+"/clockbroadcast/"+opid,  //修改接口
	            contentType : "application/json", 
	            data: JSON.stringify(submitPar),
	            success: function (json) {
	            	if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","./clock/ClockBroadcastList.html");
	                }
	                else{
	                	parent.dialog(result.message).showModal();
	                }
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ClockBroadcastEditViewModel());
});
