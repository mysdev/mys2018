//定义ViewModel对象
var RoomEditViewModel = function () {  
	var self=this;
	self.roomId = ko.observable(''); 
	self.storeId = ko.observable(''); 
	self.types = ko.observable(''); 
	self.area = ko.observable(''); 
	self.roomNo = ko.observable(''); 
	self.roomName = ko.observable(''); 
	self.status = ko.observable(''); 
	self.roomStatus = ko.observable(''); 
	self.chair = ko.observable(''); 
	self.bed = ko.observable(''); 
	self.mark = ko.observable(''); 
	self.phone = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/room/"+opid, "GET", null, function (data){
			self.roomId(data.roomId);
			self.storeId(data.storeId);
			self.types(data.types);
			self.area(data.area);
			self.roomNo(data.roomNo);
			self.roomName(data.roomName);
			self.status(data.status);
			self.roomStatus(data.roomStatus);
			self.chair(data.chair);
			self.bed(data.bed);
			self.mark(data.mark);
			self.phone(data.phone);
		}, true);
	}

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.storeId=self.storeId();
		submitPar.types=self.types();
		submitPar.area=self.area();
		submitPar.roomNo=self.roomNo();
		submitPar.roomName=self.roomName();
		submitPar.status=self.status();
		submitPar.roomStatus=self.roomStatus();
		submitPar.chair=self.chair();
		submitPar.bed=self.bed();
		submitPar.mark=self.mark();
		submitPar.phone=self.phone();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/room", "POST", submitPar, function (data){
				ChangeUrl("./core/RoomList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/room/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./core/RoomList.html");
			}, true);
    	}
    };
};


$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new RoomEditViewModel());
});