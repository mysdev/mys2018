var typeData = [{
	"id": "1",
	"name": "类型1"
},{
	"id": "2",
	"name": "类型2"
}];

//定义ViewModel对象
var AttendanceEditViewModel = function () {  
	var self=this;
	
    self.attendanceName = ko.observable('');
    self.dayNum = ko.observable(0);
    self.typeList=ko.observableArray(typeData);
    self.typeSelected = ko.observable(typeData[0].name);
    self.status=ko.observable(1);
    self.ondutyTime = ko.observable("09:00");
    self.offworkTime = ko.observable("18:00");
    
    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	$.ajax({
	        type: 'GET',
	        url: "mys/attendance/"+opid,
	        cache: false,
	        async: false,
	        dataType: "json",
	        success: function (result) {
	            self.attendanceName(result.attendanceName);
				self.dayNum(result.attendance);
				self.typeSelected(result.types);
				self.status(result.status);
				self.ondutyTime(result.signTime);
				self.offworkTime(result.outTime);
	        }
	    });
	}

	//【提交】按钮押下处理
    self.Commit = function () {
    	
    	if(opFalg=="Add"){
    		var vStartTime=self.ondutyTime.toString();
    		var vEndTime=self.ondutyTime.toString();
	        $.ajax({
	            type: "POST",
	            url: homeUrl+"mys/attendance",  //新增接口
	            dataType: "json",
	            data: {
	            	attendanceId:0,
	                attendanceName: self.attendanceName,
	                status: self.status.toString(),
	                types:self.typeSelected,
	                storeId:'',
	                createdBy:'cmc',
	                outTime:{
	                	date:'2018-01-15',
	                	hours:vEndTime.split(':')[0],
	                	minutes:vEndTime.split(':')[1],
	                	month:0,
	                	nanos:0,
	                	seconds:0,
	                	time:0,
	                	year:0
	                },
	                signTime:{
	                	date:'2018-01-15',
	                	hours:vStartTime.split(':')[0],
	                	minutes:vStartTime.split(':')[1],
	                	month:0,
	                	nanos:0,
	                	seconds:0,
	                	time:0,
	                	year:0
	                }
	            },
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","list.html");
	                }
	                else{
	                	parent.dialog(result.message).showModal();
	                }	                
	            }
	        });
		}
    	else{
    		var opid=getQueryString('id');
    		$.ajax({
	            type: "PUT",
	            url: homeUrl+"mys/attendance/"+opid,  //修改接口
	            data: {
	            	attendanceId:opid,
	                attendanceName: self.attendanceName,
	                status: self.status.toString(),
	                types:self.typeSelected,
	                storeId:'',
	                createdBy:'cmc',
	                outTime:{
	                	date:'2018-01-15',
	                	hours:vEndTime.split(':')[0],
	                	minutes:vEndTime.split(':')[1],
	                	month:0,
	                	nanos:0,
	                	seconds:0,
	                	time:0,
	                	year:0
	                },
	                signTime:{
	                	date:'2018-01-15',
	                	hours:vStartTime.split(':')[0],
	                	minutes:vStartTime.split(':')[1],
	                	month:0,
	                	nanos:0,
	                	seconds:0,
	                	time:0,
	                	year:0
	                }
	            },
	            success: function (json) {
	                alert(json.result);
	                $("#mainframe", parent.window.document).attr("src","list.html");
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new AttendanceEditViewModel());
})