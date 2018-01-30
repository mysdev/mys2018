//定义ViewModel对象
var ResourceInfoEditViewModel = function () {  
	var self=this;
	self.resourceId = ko.observable(''); 
	self.title = ko.observable(''); 
	self.type = ko.observable(''); 
	self.url = ko.observable(''); 
	self.method = ko.observable(''); 
	self.image = ko.observable(''); 
	self.parentId = ko.observable(''); 
	self.isDisplay = ko.observable(''); 
	self.sequence = ko.observable(''); 
	self.enabled = ko.observable(''); 
	self.note = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/resourceinfo/"+opid, "GET", null, function (data){
			self.resourceId(data.resourceId);
			self.title(data.title);
			self.type(data.type);
			self.url(data.url);
			self.method(data.method);
			self.image(data.image);
			self.parentId(data.parentId);
			self.isDisplay(data.isDisplay);
			self.sequence(data.sequence);
			self.enabled(data.enabled);
			self.note(data.note);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.title=self.title();
		submitPar.type=self.type();
		submitPar.url=self.url();
		submitPar.method=self.method();
		submitPar.image=self.image();
		submitPar.parentId=self.parentId();
		submitPar.isDisplay=self.isDisplay();
		submitPar.sequence=self.sequence();
		submitPar.enabled=self.enabled();
		submitPar.note=self.note();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/resourceinfo", "POST", submitPar, function (data){
				ChangeUrl("./system/ResourceInfoList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/resourceinfo/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./system/ResourceInfoList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new ResourceInfoEditViewModel());
});