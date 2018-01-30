//定义ViewModel对象
var TypesBindEditViewModel = function () {  
	var self=this;
	self.bindId = ko.observable(''); 
	self.typeId = ko.observable(''); 
	self.objectId = ko.observable(''); 
	self.objectCt = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/typesbind/"+opid, "GET", null, function (data){
			self.bindId(data.bindId);
			self.typeId(data.typeId);
			self.objectId(data.objectId);
			self.objectCt(data.objectCt);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.typeId=self.typeId();
		submitPar.objectId=self.objectId();
		submitPar.objectCt=self.objectCt();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/typesbind", "POST", submitPar, function (data){
				ChangeUrl("./core/TypesBindList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/typesbind/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/TypesBindList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TypesBindEditViewModel());
});