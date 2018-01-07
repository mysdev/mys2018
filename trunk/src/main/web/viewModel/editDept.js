//页面初始化
$(function () {
    var vm = new ViewModel();
    ko.applyBindings(vm);
});

//定义ViewModel对象
var ViewModel = function () {
    var self = this;

    self.UserName = ko.observable(data[0].name);
    self.Sex = ko.observable(data[0].sex);
    self.Job = ko.observable(data[0].job);
    self.Birthday = ko.observable(data[0].birthday);
    self.Statu = ko.observable(data[0].statu);

    self.Commit = function () {
        $.ajax({
            type: "post",
            url: "/Dept/Edit",   //编辑接口
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
        });
    };

    self.back = function () {
        window.location.href = "index.html";
    };
};