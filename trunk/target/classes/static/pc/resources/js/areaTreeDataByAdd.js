var areaTreeSelect = {};

areaTreeSelect.init = function getTreeByEasyui(option) {
    var defaults = {
	"treeId" : "areaName", // 加载的html标签
	"hiddenId" : "areaCode", // 加载的隐藏域标签
	"valueField" : "id", // value
	"textField" : "name", // html
	"parentId" : "parentId"
    };
    var op = $.extend({}, defaults, option);
    $('#' + op.treeId).combotree({
	url : projectName + "/system/area/list/areaidson/1",
	method : 'get',
	required : true,
	loadFilter : function(rows) {
	    return convert(rows); //加载树的点击方法
	},
	panelHeight : 'auto',
	onBeforeSelect : function(node) { //在请求加载远程数据之前触发，返回false可以取消加载操作。
		if(node.id.length<15){
			$.messager.alert('错误操作', "请选择具体网格！！", 'error');
			return false;
		}else{
			$("#" + op.hiddenId).val(node.id);
		}
	    
	},
	onBeforeExpand : function(node, param) { //在节点展开之前触发，返回false可以取消展开操作。
	    $(this).tree('options').url = projectName + '/system/area/list/areaidson/' + node.areaId;
	},
    });

    // 加载执行的方法
    function convert(rows) {
	var nodes = [];
	for (var i = 0; i < rows.length; i++) {
	    var row = rows[i];
	    if (row.id.length < 15) {
		nodes.push({
		    areaId : row.obj.areaID,
		    id : row[op.valueField],
		    text : row[op.textField],
		    parentId : row[op.parentId],
		    "state" : "closed"
		});
	    } else {
		nodes.push({
		    areaId : row.obj.areaID,
		    id : row[op.valueField],
		    text : row[op.textField],
		    parentId : row[op.parentId],		});
	    }
	}
	return nodes;
    }
}
