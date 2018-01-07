//页面初始化
$(function () {
    var vm = new ViewModel();
    ko.applyBindings(vm);
});

//定义ViewModel对象
var ViewModel = function () {
    var self = this;

    self.UserName = ko.observable();
    self.Sex = ko.observable('男');
    self.Job = ko.observable();
    self.Birthday = ko.observable();
    self.Statu = ko.observable('在职');
    //【提交】按钮押下处理
    self.Commit = function () {
        $.ajax({
            type: "post",
            url: "/Dept/Add",  //新增接口
            data: {
                UserName: self.UserName,
                Sex: self.Sex,
                Job:self.Job,
                Birthday:self.Birthday,
                Statu:self.Statu
            },
            success: function (json) {
                alert(json.result);
                window.location.href = "index.html";
            }
        })
    };

    //【返回】按钮押下处理
    self.back = function () {
        window.location.href = "index.html";
    };
}