//页面初始化
$(function(){
	
    var vm = new DeptViewModel();
    ko.applyBindings(vm);
});

//定义ViewModel对象
var DeptViewModel = function () {
    var self = this;
    
    //添加动态监视数组对象
    self.userName=ko.observable(userData.userName);
    self.avatar = ko.observable(userData.avatar);
    self.roleName=ko.observable(userData.roleName);
};
