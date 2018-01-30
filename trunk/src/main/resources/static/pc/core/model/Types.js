//定义ViewModel对象
var TypesEditViewModel = function () {  
	var self=this;
	self.typeId = ko.observable(''); 
	self.ass = ko.observable(''); 
	self.typeName = ko.observable(''); 
	self.lowConsumption = ko.observable(''); 
	self.status = ko.observable(''); 
	self.isCircle = ko.observable(''); 
	self.circleStep = ko.observable(''); 
	self.circleTime = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/types/"+opid, "GET", null, function (data){
			self.typeId(data.typeId);
			self.ass(data.ass);
			self.typeName(data.typeName);
			self.lowConsumption(data.lowConsumption);
			self.status(data.status);
			self.isCircle(data.isCircle);
			self.circleStep(data.circleStep);
			self.circleTime(data.circleTime);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.ass=self.ass();
		submitPar.typeName=self.typeName();
		submitPar.lowConsumption=self.lowConsumption();
		submitPar.status=self.status();
		submitPar.isCircle=self.isCircle();
		submitPar.circleStep=self.circleStep();
		submitPar.circleTime=self.circleTime();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/types", "POST", submitPar, function (data){
				ChangeUrl("./core/TypesList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/types/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/TypesList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TypesEditViewModel());
});