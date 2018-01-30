//定义ViewModel对象
var GoodsUnitEditViewModel = function () {  
	var self=this;
	self.unitId = ko.observable(''); 
	self.unitName = ko.observable(''); 
	self.baseUnit = ko.observable(''); 
	self.baseCt = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/goodsunit/"+opid, "GET", null, function (data){
			self.unitId(data.unitId);
			self.unitName(data.unitName);
			self.baseUnit(data.baseUnit);
			self.baseCt(data.baseCt);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.unitName=self.unitName();
		submitPar.baseUnit=self.baseUnit();
		submitPar.baseCt=self.baseCt();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/goodsunit", "POST", submitPar, function (data){
				ChangeUrl("./order/GoodsUnitList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/goodsunit/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./order/GoodsUnitList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new GoodsUnitEditViewModel());
});