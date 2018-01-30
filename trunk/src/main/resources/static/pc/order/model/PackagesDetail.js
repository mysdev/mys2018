//定义ViewModel对象
var PackagesDetailEditViewModel = function () {  
	var self=this;
	self.detailId = ko.observable(''); 
	self.packageId = ko.observable(''); 
	self.goodsId = ko.observable(''); 
	self.goodsCt = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/packagesdetail/"+opid, "GET", null, function (data){
			self.detailId(data.detailId);
			self.packageId(data.packageId);
			self.goodsId(data.goodsId);
			self.goodsCt(data.goodsCt);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.packageId=self.packageId();
		submitPar.goodsId=self.goodsId();
		submitPar.goodsCt=self.goodsCt();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/packagesdetail", "POST", submitPar, function (data){
				ChangeUrl("./order/PackagesDetailList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/packagesdetail/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./order/PackagesDetailList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new PackagesDetailEditViewModel());
});