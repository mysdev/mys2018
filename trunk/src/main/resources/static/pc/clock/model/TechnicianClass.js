//定义ViewModel对象
var TechnicianClassEditViewModel = function () {  
	var self=this;
	self.detailId = ko.observable(''); 
	self.classId = ko.observable(''); 
	self.technicianId = ko.observable(''); 
	self.clockCt = ko.observable(''); 
	self.isWork = ko.observable(''); 
	self.technicianLevel = ko.observable(''); 
	self.priority = ko.observable(''); 
	self.seqencing = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/technicianclass/"+opid, "GET", null, doQueryActionSuccess, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.classId=self.classId();
		submitPar.technicianId=self.technicianId();
		submitPar.clockCt=self.clockCt();
		submitPar.isWork=self.isWork();
		submitPar.technicianLevel=self.technicianLevel();
		submitPar.priority=self.priority();
		submitPar.seqencing=self.seqencing();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/technicianclass", "POST", null, doActionSuccess, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/technicianclass/"+opid, "PUT", null, doActionSuccess, true);
    	}
    };
};

function doQueryActionSuccess(data){
	self.detailId(data.detailId);
	self.classId(data.classId);
	self.technicianId(data.technicianId);
	self.clockCt(data.clockCt);
	self.isWork(data.isWork);
	self.technicianLevel(data.technicianLevel);
	self.priority(data.priority);
	self.seqencing(data.seqencing);
}

function doActionSuccess(data){
	ChangeUrl("./clock/TechnicianClassList.html");
}

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new TechnicianClassEditViewModel());
});