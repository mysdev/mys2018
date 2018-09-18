/**
 * 初始化选择人员控件 使用方法:bindSelectUser({selector:控件id}) 必需引入的js: <link
 * href="../../resources/script/bootstrap/css/bootstrap.min.css" type="text/css" />
 * <script src="../../resources/script/jquery/jquery-1.11.0.min.js"
 * type="text/javascript"> </script> <script
 * src="../../resources/script/js/bootstrap.min.js" type="text/javascript">
 * </script> <script
 * src="../../resources/script/bootstraptagsinput/angular.min.js"
 * type="text/javascript"></script> <link
 * href="../../resources/script/bootstraptagsinput/bootstrap-tagsinput.css"
 * rel="stylesheet" type="text/css" /> <script
 * src="../../resources/script/bootstraptagsinput/bootstrap-tagsinput.min.js"
 * type="text/javascript"></script> <script
 * src="../../resources/script/bootstraptagsinput/bootstrap-tagsinput-angular.min.js"
 * type="text/javascript"></script> <link
 * href="../../resources/css/bootstrap-treeview.css" rel="stylesheet"> <script
 * src="../../resources/script/js/bootstrap-treeview.js"></script>
 */

var columns_user = [ {
    field : 'btSelectItem',
    title : '',
    align : 'center',
    checkbox : true
}, {
    field : 'id',
    title : '编号',
    visible : false
}, {
    field : 'username',
    title : '帐号',
    align : 'center'
}, {
    field : 'nickName',
    title : '姓名',
    align : 'center'
}, {
    field : 'deptCode',
    title : '单位code',
    align : 'center',
    visible : false

}, {
    field : 'deptName',
    title : '单位',
    align : 'center'
} ];

var d_op = {
    valueField : "id",
    textField : 'name',
    freeInput : false,
    title : '选择对象',
    placement : "bottom",
    width : '98%',
}

var op = {};

function bindSelectUser(options) {
    op = $.extend({}, d_op, options);
    // 初始化用户选择控件
    $('#' + op.selector).tagsinput({
	itemValue : op.valueField,
	itemText : op.textField,
	freeInput : op.freeInput
    });

    // 点击弹出窗口
    var selector = $('#' + op.selector).prev().children('input');
    $(selector).on('click', function() {
	if ($('#selectUserDialog').length == 0) {
	    var str = '<div class="modal fade" id="selectUserDialog" tabindex="-1" role="dialog" aria-labelledby="selectUserLabel" aria-hidden="true">';
	    str += '		<div class="modal-dialog" style="width: 50%;height:500px">';
	    str += '			<div class="modal-content">';
	    str += '				<div class="modal-header">';
	    str += '					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>';
	    str += '					<h4 class="modal-title" id="myModalLabel">选择人员</h4>';
	    str += '				</div>';
	    str += '				<div class="modal-body" style="height: 350px;">';
	    str += '					<div id="search" class="search wrap_border">';
	    str += '						<div style="position: relative; display: inline-block;">';
	    str += '							<input type="hidden" id="selectuser_search_orgid" name="selectuser_search_orgid">';
	    str += '								<input id="selectuser_search_orgname" style="width: 250px;" class="search_wrap form-control searchfield" type="text" placeholder="请选择单位" />';
	    str += '									<input id="selectuser_search_nickname" class="search_wrap form-control searchfield" type="text" placeholder="请输入姓名" />';
	    str += '						<input type="button" class="btn btn-info but_search" value="搜索" id="selectuser_search_btn" />';
	    str += '					<div id="selectuser_search_orgid_tree_wrap" style="width: 250px; position: absolute; Z-index: 9999; top: 40px; left: 0; text-align: left;background:#fff; border: 1px solid #f0f0f0; height:300px; overflow: auto; display: none;">';
	    str += '				<div id="selectuser_search_orgid_tree"></div>';
	    str += '				</div>';
	    str += '				</div>';
	    str += '				</div> ';
	    str += '				<div class="form-group col-sm-12 col-xs-12">';
	    str += '						<table class="table table-hover" id="selectuser_table"></table>';
	    str += '					</div>';
	    str += '				</div> ';
	    str += '				<div class="modal-footer">';
	    str += '					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>';
	    str += '				<button type="button" class="btn btn-primary" id="selectuser_btn_ok">确定</button>';
	    str += '				</div>';
	    str += '			</div>';
	    str += '		</div>';
	    str += '	</div>';
	    $('body').append(str);

	    // 点击确定关闭模态框
	    $('#selectuser_btn_ok').click(function() {
		var selectContent = $('#selectuser_table').bootstrapTable('getSelections')[0];
		if (typeof (selectContent) == 'undefined') {
		    window.wxc.xcConfirm('请选择一列数据!', window.wxc.xcConfirm.typeEnum.error);
		    return false;
		} else { // 成功返回一条数据
		    // $("#" +
		    // val_field).val(selectContent.peopleId);
		    // $("#" +
		    // text_field).val(selectContent.xm);
		    $('#selectUserDialog').modal('hide');
		    $('#selectUserDialog').remove();
		}
	    });

	    // 点击区域input显示区域树
	    $("#selectuser_search_orgname").click(function(e) {
		if ($("#selectuser_search_orgid_tree_wrap").hasClass("show")) {
		    $("#selectuser_search_orgid_tree_wrap").hide().removeClass("show");
		} else {
		    $("#selectuser_search_orgid_tree_wrap").show().addClass("show");
		}
	    });

	    // 加载单位树信息
	    $.post('/org/list/tree', {
		queryType : 1
	    }, function(rs) {
		var nodes = GenerateNodes(rs);
		$('#selectuser_search_orgid_tree').treeview({
		    level : 2,
		    data : nodes,
		    tags : 'orgId',
		    onNodeSelected : function(event, node) {
			// getOrgUser(node.orgId)
			$('#selectuser_search_orgid').val(node.orgId);
			$('#selectuser_search_orgname').val(node.text);

		    }
		});
	    }, 'json');

	    // 搜索按钮点击事件
	    $('#selectuser_search_btn').click(function() {
		var query = {};
		var orgid = $('#selectuser_search_orgid').val();
		var nickname = $('#selectuser_search_nickname').val();
		if (orgid && orgid != '') {
		    query.deptCode = orgid;
		}
		if (nickname && nickname != '') {
		    query.nickName = nickname;
		}
		$('#selectuser_table').bootstrapTable('refresh', {
		    query : query
		});
	    });

	    // 显示表格

	    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['cn-zh']);
	    table = $('#selectuser_table').bootstrapTable({
		// singleSelect : true, // 单选按钮
		url : "/user/list",
		columns : columns_user,
		sortName : "sort",
		orderName : "asc",
		pagination : true,
		striped : true,
		sidePagination : 'server',
		pageNumber : 1,
		pageSize : 10,
		pageList : [ 10, 25, 50, 100 ],
		search : false,
		method : 'post',
		height : 450,
		clickToSelect : true,
		queryParamsType : null,
		dataField : 'resultList',
		totalField : 'recordCounts',
		contentType : 'application/x-www-form-urlencoded',
		onClickRow : function(row, obj) {
		    // 选择一个人
		    chooseuser(row.nickName, row.username, row.deptCode);
		    // pageRoom(row.floorId);
		    $(obj).css('background', '#5bc0de');
		    setTimeout(function() {
			$(obj).css('background', '#fff');
		    }, 1000);
		}
	    });

	}
	$('#selectUserDialog').modal('show');

    });

    /*
     * var selector = $('#' + op.selector).prev().attr('class'); $('.' +
     * selector) .popover( { title : op.title, placement : op.placement,
     * template : '<div style="max-width:95%;background:#fff;width:' + op.width +
     * ';" class="popover" role="tooltip"><div class="arrow"></div><h3 class="popover-title"></h3><div
     * class="popover-content"></div></div>', content : '<div
     * style="width:100%"><div class="col-sm-6"><div id="org_tree" ></div></div>
     * <div class="col-sm-6" > <ul class="list-group" id="user_list"></ul>
     * </div> </div>', html : true, });
     * 
     * $('.' + selector).on('show.bs.popover', function() { // 加载组织机构树
     * $.post('/org/list/tree', { queryType : 1 }, function(rs) { var nodes =
     * GenerateNodes(rs); $('#org_tree').treeview({ level : 2, data : nodes,
     * tags : 'orgId', onNodeSelected : function(event, node) {
     * getOrgUser(node.orgId) } }); }, 'json'); });
     */

}

// 点击用户列表 填充数据到input
function chooseuser(name, id, orgid) {
    var row = {};
    row[op.valueField] = id;
    row[op.textField] = name;
    row["orgid"] = orgid;
    $('#' + op.selector).tagsinput('add', row);
}

// 根据单位id获得用户
function getOrgUser(orgid) {
    $.post('/user/list', {
	"currentPage" : 1,
	"pageSize" : 100,
	"orderName" : "asc",
	"sortName" : "sort",
	"deptCode" : orgid
    }, function(rs) {
	$('#user_list').html('');
	if (rs.resultList && rs.resultList.length > 0) {
	    $.each(rs.resultList, function(i, item) {
		$('#user_list').append(' <li class="list-group-item"  onclick=chooseuser("' + item.nickName + '","' + item.username + '","' + orgid + '") >' + item.nickName + '</li>');
	    });
	}
    }, 'json');
}

// 递归生成树数据
function GenerateNodes(rs) {
    var nodes = [];
    $.each(rs, function(i, item) {
	var row = {};
	row.text = item.orgName;
	row.orgId = item.id;
	if (item.childOrganization && item.childOrganization.length > 0) {
	    row.nodes = GenerateNodes(item.childOrganization);
	}
	nodes.push(row);
    });
    return nodes;
}