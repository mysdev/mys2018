//定义ViewModel对象
var SkillClassEditViewModel = function () {  
	var self=this;
	self.classId = ko.observable(''); 
	self.className = ko.observable(''); 
	self.status = ko.observable(''); 
	self.clockFlag = ko.observable(''); 
	self.flag = ko.observable(''); 
	self.types = ko.observable(''); 
	self.isPriority = ko.observable(''); 
	self.priorityAccumulate = ko.observable(''); 
	self.arriveWarn = ko.observable(''); 
	self.arriveRemind = ko.observable(''); 

    var opFalg=getQueryString('action');
    
    if(opFalg!="Add"){
    	var opid=getQueryString('id');
    	$.ajax({
	        type: 'GET',
	        url: homeUrl+"/skillclass/"+opid,
	        cache: false,
	        async: false,
	        dataType: "json",
	        success: function (result) {
				self.classId(result.classId);
				self.className(result.className);
				self.status(result.status);
				self.clockFlag(result.clockFlag);
				self.flag(result.flag);
				self.types(result.types);
				self.isPriority(result.isPriority);
				self.priorityAccumulate(result.priorityAccumulate);
				self.arriveWarn(result.arriveWarn);
				self.arriveRemind(result.arriveRemind);
	        }
	    });
	}

	//【提交】按钮押下处理
    self.Commit = function () {    	
    	if(opFalg=="Add"){
	        $.ajax({
	            type: "POST",
	            url: homeUrl+"/skillclass",  //新增接口
	            dataType: "json",
	            data: {
								className:self.className(),
								status:self.status(),
								clockFlag:self.clockFlag(),
								flag:self.flag(),
								types:self.types(),
								isPriority:self.isPriority(),
								priorityAccumulate:self.priorityAccumulate(),
								arriveWarn:self.arriveWarn(),
								arriveRemind:self.arriveRemind(),
								classId:null
	            },
	            success: function (result) {
	                if(result.code==200){
	                	$("#mainframe", parent.window.document).attr("src","/clock/SkillClassList.html");
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
	            url: homeUrl+"/skillclass/"+opid,  //修改接口
	            data: {
					classId:opid
	            },
	            success: function (json) {
	                alert(json.result);
	                $("#mainframe", parent.window.document).attr("src","/clock/SkillClassList.html");
	            }
	        });
    	}
    };
};

$().ready(function(){
	$("#txtName").focus();
    ko.applyBindings(new SkillClassEditViewModel());
});
