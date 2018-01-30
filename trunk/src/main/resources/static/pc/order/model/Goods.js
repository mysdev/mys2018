//定义ViewModel对象
var GoodsEditViewModel = function () {  
	var self=this;
	self.goodsId = ko.observable(''); 
	self.storeId = ko.observable(''); 
	self.goodsName = ko.observable(''); 
	self.price = ko.observable(''); 
	self.unitId = ko.observable(''); 
	self.goodsTime = ko.observable(''); 
	self.classify = ko.observable(''); 
	self.materialId = ko.observable(''); 
	self.materialTypes = ko.observable(''); 
	self.materialCt = ko.observable(''); 
	self.status = ko.observable(''); 
	self.saleStatus = ko.observable(''); 
	self.note = ko.observable(''); 
	self.goodsImg = ko.observable(''); 
	self.isShow = ko.observable(''); 
	self.canCancel = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/goods/"+opid, "GET", null, function (data){
			self.goodsId(data.goodsId);
			self.storeId(data.storeId);
			self.goodsName(data.goodsName);
			self.price(data.price);
			self.unitId(data.unitId);
			self.goodsTime(data.goodsTime);
			self.classify(data.classify);
			self.materialId(data.materialId);
			self.materialTypes(data.materialTypes);
			self.materialCt(data.materialCt);
			self.status(data.status);
			self.saleStatus(data.saleStatus);
			self.note(data.note);
			self.goodsImg(data.goodsImg);
			self.isShow(data.isShow);
			self.canCancel(data.canCancel);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.storeId=self.storeId();
		submitPar.goodsName=self.goodsName();
		submitPar.price=self.price();
		submitPar.unitId=self.unitId();
		submitPar.goodsTime=self.goodsTime();
		submitPar.classify=self.classify();
		submitPar.materialId=self.materialId();
		submitPar.materialTypes=self.materialTypes();
		submitPar.materialCt=self.materialCt();
		submitPar.status=self.status();
		submitPar.saleStatus=self.saleStatus();
		submitPar.note=self.note();
		submitPar.goodsImg=self.goodsImg();
		submitPar.isShow=self.isShow();
		submitPar.canCancel=self.canCancel();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/goods", "POST", submitPar, function (data){
				ChangeUrl("./order/GoodsList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/goods/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./order/GoodsList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new GoodsEditViewModel());
});