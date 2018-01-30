//定义ViewModel对象
var DocumentInfoEditViewModel = function () {  
	var self=this;
	self.docId = ko.observable(''); 
	self.docName = ko.observable(''); 
	self.actualName = ko.observable(''); 
	self.suffixName = ko.observable(''); 
	self.fileSize = ko.observable(''); 
	self.status = ko.observable(''); 
	self.url = ko.observable(''); 
	self.note = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/documentinfo/"+opid, "GET", null, function (data){
			self.docId(data.docId);
			self.docName(data.docName);
			self.actualName(data.actualName);
			self.suffixName(data.suffixName);
			self.fileSize(data.fileSize);
			self.status(data.status);
			self.url(data.url);
			self.note(data.note);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.docName=self.docName();
		submitPar.actualName=self.actualName();
		submitPar.suffixName=self.suffixName();
		submitPar.fileSize=self.fileSize();
		submitPar.status=self.status();
		submitPar.url=self.url();
		submitPar.note=self.note();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/documentinfo", "POST", submitPar, function (data){
				ChangeUrl("./system/DocumentInfoList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/documentinfo/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./system/DocumentInfoList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new DocumentInfoEditViewModel());
});