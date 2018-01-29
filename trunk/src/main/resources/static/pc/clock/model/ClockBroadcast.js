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
	            url: homeUrl+"/clockbroadcast",  //新增接口
	            dataType: "json",
	            data: {
								stauts:self.stauts(),
								types:self.types(),
								content:self.content(),
								broadcastId:null
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
    		$.ajax({
	            type: "PUT",
	            url: homeUrl+"/clockbroadcast/"+opid,  //修改接口
	            data: {
								stauts:self.stauts(),
								types:self.types(),
								content:self.content(),
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
