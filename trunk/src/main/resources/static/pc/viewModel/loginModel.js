//页面初始化
$(function () {
    var vm = new ViewModel();
    ko.applyBindings(vm);
});

//定义ViewModel对象
var ViewModel = function () {
    var self = this;

    self.UserName = ko.observable();
    self.Password = ko.observable();
    
    //【提交】按钮押下处理
    self.Commit = function () {
//      $.ajax({
//          type: "post",
//          url: "/safety/login",  //登陆接口
//          data: {
//              UserName: self.UserName,
//              Password: self.Password
//          },
//          success: function (json) {
//          	window.document.href="index.html";
//          }
//      })
		window.location.href = "index.html";
   };
}