var Event = {};


//事件类型下拉树
Event.initComboboxEventType = function(id, options) {
	var custom = {
		url: Faith.projectName + "/event/wfEventtype/list?parentcode=0",
	method: 'post',
	required: true,
	isLeafOnly: true,
	multiple: false,
	checkbox: false,
	cascadeCheck: false,
	lines: true,
	loadFilter: function(rs) {
		var nodes = [];
		var rows = rs.data;
		$.each(rows, function(i, row) {
			var d = {
				id: row.code,
				text: row.name
			};
			if(row.code.length != 4) {
				d.state = 'closed';
			}
			nodes.push(d);
		});
		return nodes;
	},
	onSelect: function(node) {
		var isLeafOnly = $(this).tree('options').isLeafOnly;
		if(isLeafOnly) {
			var tree = $(this).tree;
			var isLeaf = tree('isLeaf', node.target);
			if(!isLeaf) {
				$('#' + id).combotree('clear');
			}
		}
	},
	panelHeight: 'auto',
	onBeforeExpand: function(node, param) {
		$(this).tree('options').url = Faith.projectName +
			'/event/wfEventtype/list?parentcode=' + node.id
	},
	width: '100%',
	height: 34
};
var op = $.extend({}, custom, options || {});
$('#' + id).combotree(op);
}


Event.doDelete = function(){
	
}

