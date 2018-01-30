//定义ViewModel对象
var DictionaryEditViewModel = function () {  
	var self=this;
	self.id = ko.observable(''); 
	self.code = ko.observable(''); 
	self.value = ko.observable(''); 
	self.groupCode = ko.observable(''); 
	self.parentCode = ko.observable(''); 
	self.sequence = ko.observable(''); 
	self.flag = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/dictionary/"+opid, "GET", null, function (data){
			self.id(data.id);
			self.code(data.code);
			self.value(data.value);
			self.groupCode(data.groupCode);
			self.parentCode(data.parentCode);
			self.sequence(data.sequence);
			self.flag(data.flag);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.code=self.code();
		submitPar.value=self.value();
		submitPar.groupCode=self.groupCode();
		submitPar.parentCode=self.parentCode();
		submitPar.sequence=self.sequence();
		submitPar.flag=self.flag();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/dictionary", "POST", submitPar, function (data){
				ChangeUrl("./system/DictionaryList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/dictionary/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./system/DictionaryList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new DictionaryEditViewModel());
});