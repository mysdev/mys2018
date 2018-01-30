//定义ViewModel对象
var GoodsExtEditViewModel = function () {  
	var self=this;
	self.goodsId = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/goodsext/"+opid, "GET", null, function (data){
			self.goodsId(data.goodsId);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/goodsext", "POST", submitPar, function (data){
				ChangeUrl("./order/GoodsExtList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/goodsext/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./order/GoodsExtList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new GoodsExtEditViewModel());
});