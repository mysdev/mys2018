//定义ViewModel对象
var SkillClassEditViewModel = function () {  
	var self=this;
	self.classId = ko.observable(''); 
	self.className = ko.observable(''); 
	self.status = ko.observable(''); 
	self.clockFlag = ko.observable(''); 
	self.flag = ko.observable(''); 
	self.types = ko.observable(''); 
	self.isPriority = ko.observable(''); 
	self.priorityAccumulate = ko.observable(''); 
	self.arriveWarn = ko.observable(''); 
	self.arriveRemind = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/skillclass/"+opid, "GET", null, function (data){
			self.classId(data.classId);
			self.className(data.className);
			self.status(data.status);
			self.clockFlag(data.clockFlag);
			self.flag(data.flag);
			self.types(data.types);
			self.isPriority(data.isPriority);
			self.priorityAccumulate(data.priorityAccumulate);
			self.arriveWarn(data.arriveWarn);
			self.arriveRemind(data.arriveRemind);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.className=self.className();
		submitPar.status=self.status();
		submitPar.clockFlag=self.clockFlag();
		submitPar.flag=self.flag();
		submitPar.types=self.types();
		submitPar.isPriority=self.isPriority();
		submitPar.priorityAccumulate=self.priorityAccumulate();
		submitPar.arriveWarn=self.arriveWarn();
		submitPar.arriveRemind=self.arriveRemind();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/skillclass", "POST", submitPar, function (data){
				ChangeUrl("./clock/SkillClassList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/skillclass/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./clock/SkillClassList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new SkillClassEditViewModel());
});