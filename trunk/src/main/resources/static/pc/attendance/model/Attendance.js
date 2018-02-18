var vTempId = 1;  //自定义班点块ID起始编号
var storeList=[];
var attendanceTime=[];
var attendanceViewModel;

//定义ViewModel对象
var AttendanceEditViewModel = function () {  
	var self=this;
	self.attendanceId = ko.observable(''); 
	self.selectStore=ko.observableArray(storeList);
    self.storeSelected = ko.observable('');
	self.attendanceName = ko.observable(''); 
	self.storeStatus = ko.observable(true); 
	self.attendanceTimeList = ko.observableArray(attendanceTime);

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	myAjax("/attendance/"+opid, "GET", null, function (data){
			self.attendanceId(data.attendanceId);
			self.attendanceName(data.attendanceName);
			self.storeStatus(data.status);
		}, true);
		//班点获取
		myAjax("/attendance/"+opid+"/times", "GET", null, function (data){
			vTempId=data.length+1;
			attendanceTime = data;
			self.attendanceTimeList(attendanceTime);
			AttendanceTimeEvent();
		}, true);
	}
    
    //新增班点
    self.AddTime=function(){
    	if(attendanceTime.length > 2) {
			jsprints("最多添加3个班点！");
			return;
		}
    	
    	var opid=0;
    	if(opFalg!="Add"){
    		var opid=getQueryString('id');
    	}

    	var node ={attendanceId:opid,id:vTempId,name:'',signTime: "08:30:00",outTime: "18:00:00"};
    	attendanceTime.push(node);
    	self.attendanceTimeList(attendanceTime);
    	
    	//选时间控件初始化
    	$("#sTime" + vTempId).flatpickr();
		$("#eTime" + vTempId).flatpickr();
    	vTempId++;
    	
    	AttendanceTimeEvent();
    }

	//【提交】按钮押下处理
    self.Commit = function () {    
    	var submitPar ={};
		submitPar.storeId=self.storeSelected();
		submitPar.attendanceName=self.attendanceName();
		submitPar.status=self.storeStatus();
		submitPar.types=2;
		GetAttendanceTimeInfo();
		submitPar.attTime=self.attendanceTimeList();
    	
    	if(opFalg=="Add"){
    		myAjaxJson("/attendance", "POST", submitPar, function (data){
				ChangeUrl("./attendance/AttendanceList.html");
			}, true);
		}else{
    		var opid=getQueryString('id');
    		myAjaxJson("/attendance/"+opid, "PUT", submitPar, function (data){
				ChangeUrl("./attendance/AttendanceList.html");
			}, true);
    	}
   };
};


$().ready(function(){
	
	$("#txtName").focus();
	attendanceViewModel=new AttendanceEditViewModel();
	ko.applyBindings(attendanceViewModel);

    //获取下拉列表数据
	myAjax("/stores", "GET", null, function (data){
		$.map(data.data, function(item) { storeList.push({storeId:item.storeId,storeName:item.storeName})});  
		attendanceViewModel.selectStore(storeList);
		attendanceViewModel.storeSelected(storeList[0].storeName);
		$(".rule-single-select").ruleSingleSelect();
	}, true);
	//美化下拉框样式
	$(".rule-single-select").ruleSingleSelect();
	$(".rule-single-checkbox").ruleSingleCheckbox();
	
	AttendanceTimeEvent();
	
	$(".timeList").show();
});

var AttendanceTimeEvent=function(){
	//班点块删除事件
	$(".timeList .tmodel img").bind("click", function() {
		if($(".timeList .tmodel img").length<2)
		{
			jsprints("至少保留一个考勤班点！");
			return;
		}
		$(this).parent().remove();
		for(var i = 0; i < attendanceTime.length; i++) {
			if(attendanceTime[i].id == $(this).attr('data'))
				attendanceTime.splice(i, 1);
		}
	});
}

var GetAttendanceTimeInfo = function(){
	//获取页面班点信息
	$.each(attendanceTime, function(i, item){
		this.name = $("#tTitle"+item.id).val();
		this.signTime=$("#sTime"+item.id).val();
		this.outTime=$("#eTime"+item.id).val();
		this.id=0;
	});
}
