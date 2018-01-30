//定义ViewModel对象
var ReservationTradeEditViewModel = function () {  
	var self=this;
	self.detailId = ko.observable(''); 
	self.authorizationId = ko.observable(''); 
	self.types = ko.observable(''); 
	self.objectId = ko.observable(''); 
	self.objectCt = ko.observable(''); 
	self.canCancel = ko.observable(''); 
	self.status = ko.observable(''); 
	self.note = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/reservationtrade/"+opid, "GET", null, function (data){
			self.detailId(data.detailId);
			self.authorizationId(data.authorizationId);
			self.types(data.types);
			self.objectId(data.objectId);
			self.objectCt(data.objectCt);
			self.canCancel(data.canCancel);
			self.status(data.status);
			self.note(data.note);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.authorizationId=self.authorizationId();
		submitPar.types=self.types();
		submitPar.objectId=self.objectId();
		submitPar.objectCt=self.objectCt();
		submitPar.canCancel=self.canCancel();
		submitPar.status=self.status();
		submitPar.note=self.note();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/reservationtrade", "POST", submitPar, function (data){
				ChangeUrl("./core/ReservationTradeList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/reservationtrade/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/ReservationTradeList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ReservationTradeEditViewModel());
});