//定义ViewModel对象
var GoodsMaterialEditViewModel = function () {  
	var self=this;
	self.materialId = ko.observable(''); 
	self.storeId = ko.observable(''); 
	self.materialName = ko.observable(''); 
	self.materialNo = ko.observable(''); 
	self.materialTypes = ko.observable(''); 
	self.materialCt = ko.observable(''); 
	self.pinyin = ko.observable(''); 
	self.cost = ko.observable(''); 
	self.costAll = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/goodsmaterial/"+opid, "GET", null, function (data){
			self.materialId(data.materialId);
			self.storeId(data.storeId);
			self.materialName(data.materialName);
			self.materialNo(data.materialNo);
			self.materialTypes(data.materialTypes);
			self.materialCt(data.materialCt);
			self.pinyin(data.pinyin);
			self.cost(data.cost);
			self.costAll(data.costAll);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.storeId=self.storeId();
		submitPar.materialName=self.materialName();
		submitPar.materialNo=self.materialNo();
		submitPar.materialTypes=self.materialTypes();
		submitPar.materialCt=self.materialCt();
		submitPar.pinyin=self.pinyin();
		submitPar.cost=self.cost();
		submitPar.costAll=self.costAll();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/goodsmaterial", "POST", submitPar, function (data){
				ChangeUrl("./order/GoodsMaterialList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/goodsmaterial/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./order/GoodsMaterialList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new GoodsMaterialEditViewModel());
});