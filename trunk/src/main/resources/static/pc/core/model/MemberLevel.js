//定义ViewModel对象
var MemberLevelEditViewModel = function () {  
	var self=this;
	self.levelId = ko.observable(''); 
	self.levelName = ko.observable(''); 
	self.levelRfm = ko.observable(''); 
	self.parentId = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/memberlevel/"+opid, "GET", null, function (data){
			self.levelId(data.levelId);
			self.levelName(data.levelName);
			self.levelRfm(data.levelRfm);
			self.parentId(data.parentId);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.levelName=self.levelName();
		submitPar.levelRfm=self.levelRfm();
		submitPar.parentId=self.parentId();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/memberlevel", "POST", submitPar, function (data){
				ChangeUrl("./core/MemberLevelList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/memberlevel/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/MemberLevelList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new MemberLevelEditViewModel());
});