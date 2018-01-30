//定义ViewModel对象
var VolumeEditViewModel = function () {  
	var self=this;
	self.volumeId = ko.observable(''); 
	self.volumeCode = ko.observable(''); 
	self.couponId = ko.observable(''); 
	self.status = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/volume/"+opid, "GET", null, function (data){
			self.volumeId(data.volumeId);
			self.volumeCode(data.volumeCode);
			self.couponId(data.couponId);
			self.status(data.status);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.volumeCode=self.volumeCode();
		submitPar.couponId=self.couponId();
		submitPar.status=self.status();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/volume", "POST", submitPar, function (data){
				ChangeUrl("./trade/VolumeList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/volume/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./trade/VolumeList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new VolumeEditViewModel());
});