//页面初始化
$(function(){
    var vm = new DeptViewModel();
    ko.applyBindings(vm);

    //分页控件加载处理
    $.jqPaginator('#personPagination', {
        totalPages: totalPage,
        visiblePages: 10,
        currentPage: currentPage,
        onPageChange: function (num, type) {
            if (type != 'init') {
                window.location.href = 'index.html?page=' + num;
            }
        }
    });
});

//定义ViewModel对象
var DeptViewModel = function () {
    var self = this;
    
    //添加动态监视数组对象
    self.deptlist = ko.observableArray(data);

    //编辑
    self.edit = function(obj) {
        window.location.href = 'editDept.html?id=' + obj.id;
    };

    //删除
    self.remove = function(obj) {
        $.ajax({
            type: "post",
            url: "/Dept/Del/" + obj.id,  //删除接口
            dataType: "json",
            success: function(json) {
                alert(json.result);
                self.persons.remove(obj);
            }
        })
    }
};
