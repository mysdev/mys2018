//定义ViewModel对象
var DictionaryGroupEditViewModel = function () {  
	var self=this;
	self.groupId = ko.observable(''); 
	self.groupCode = ko.observable(''); 
	self.groupName = ko.observable(''); 
	self.remark = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/dictionarygroup/"+opid, "GET", null, function (data){
			self.groupId(data.groupId);
			self.groupCode(data.groupCode);
			self.groupName(data.groupName);
			self.remark(data.remark);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.groupCode=self.groupCode();
		submitPar.groupName=self.groupName();
		submitPar.remark=self.remark();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/dictionarygroup", "POST", submitPar, function (data){
				ChangeUrl("./system/DictionaryGroupList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/dictionarygroup/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./system/DictionaryGroupList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new DictionaryGroupEditViewModel());
});