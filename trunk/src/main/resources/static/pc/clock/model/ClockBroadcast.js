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
    	myAjax("/clockbroadcast/"+opid, "GET", null, function (data){
			self.broadcastId(data.broadcastId);
			self.stauts(data.stauts);
			self.types(data.types);
			self.content(data.content);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.stauts=self.stauts();
		submitPar.types=self.types();
		submitPar.content=self.content();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/clockbroadcast", "POST", submitPar, function (data){
				ChangeUrl("./clock/ClockBroadcastList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/clockbroadcast/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./clock/ClockBroadcastList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ClockBroadcastEditViewModel());
});