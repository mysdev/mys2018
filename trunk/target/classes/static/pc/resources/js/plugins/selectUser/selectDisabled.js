var selectDisabled = {};
var selectdisablednum = 0;
var selectdisabledids = "";
var fieldIds = "";

selectDisabled.init = function(option) {
    var defaults = {
	"width" : 550,
	"height" : 450,
	"title" : '请选择服务对象',
    };
    var p = $.extend({}, defaults, option);
    fieldIds = p.fieldId;
    $('#' + p.id).after('<input type="hidden" id="' + p.fieldId + '" name="' + p.fieldId + '" />');
    $('#' + p.id).after('<div class="dialogs"><h5>已选择人员(<small id="count_disabled">0</small>)<a href=javascript:selectDisabled.clearUser() style="float:right">清除</a></h5> <div class="receive_div" style="padding:5px;">  <ul id="selectDisabled_list" class="list-unstyled"></ul>  </div> </div>');
    var str = '     <div class="wrap_header col-sm-10">';
    str += '        <div class="row col-sm-12" style="padding:8px;margin-bottom:0px">';
    str += '            <div class="col-md-12" style="padding:0px">';
    str += '		<select class="form_in searchfield  easyui-combotree" id="areaName" name="areaName" op="equal" style="width:100%;"></select>'; //组织机构树	orgName
    str += '            <input type="hidden" name="areaCode" id="areaCode" />'; //组织机构代码  orgId
    str += '            </div> ';
    /*
     * str += ' <div class="col-md-4">'; str += ' <select class="form_in
     * searchfield" id="roleid" name="roleid" op="equal"></select>'; str += '
     * </div>';
     */
    str += '       </div>';
    str += '       <div class="row col-sm-12" style="padding:8px;margin-bottom:0px">';
    /*
     * str += ' <div class="col-md-12" style="padding:0px">'; str += ' <input
     * class="form_in" id="partynum" value="" placeholder="请填写党员编号" />'; str += '
     * </div>';
     */
    str += '           <div class="col-md-12" style="padding-left:0!important;padding-right:0!important;">';
    str += '              <input class="form_in"  id="disabledName" value="" placeholder="请服务对象姓名" />'; //name
    str += '          </div>';
    /*
     * str += ' <div class="col-md-4">'; str += ' <input class="form_in"
     * id="cardid" value="" placeholder="请填写身份证号码" />'; str += ' </div>';
     */
    str += '  </div>';
    str += '  </div>';
    str += '  <div class="wrap_header col-sm-2" style="padding:10px 10px 10px 0">';
    str += '     <div class="wrap_header_hover" onclick=selectDisabled.searchParty()>';
    str += '         <img src="../../../resources/images/seach_icon.svg" class="img-responsive" style="height: 40px; display: inline-block; line-height: 85px; margin-top: 10px;" />';
    str += '         <div style="font-size:16px;color:#fff">搜索</div>';
    str += '      </div>';
    str += '  </div>';
    str += '  <div class="wrap_content_a">';
    str += '       <div class="wrap_content_b">';
    str += '          <h5>选择人员(可多选)<small class="right_float set_but" onclick="selectDisabled.selectAll()">全选</small></h5>'; //大方框
    str += '          <ul id="selectDisabled_wrap_list" class="list-unstyled"></ul>'; //selectuser_wrap_list
    str += '      </div>';
    str += '  </div>';
    str += '  <div class="wrap_content_a" style="text-align:center">';
    str += '      <button type="button" class="btn" style="width: 30%; background: #3598dc;color:#fff" id="selectDisabled_ok">确认</button>'; //确认按钮	selectDisabled_ok
    str += '  </div>';

    javascript:
    ;
    $('#' + p.id).click(function() {
	var dialog_wrap1 = $('<div></div>');
	$('body').append(dialog_wrap1);
	dialog_wrap1.dialog({
	    title : p.title,
	    width : p.width,
	    height : p.height,
	    closed : false,
	    cache : false,
	    content : str,
	    modal : true,
	    onClose : function() {
		$(this).dialog('destroy');
	    }
	})
	//	// 初始化支部树
	//	getTreeByEasyui();
	
	//初始化区域树
	areaTreeSelect.init({treeId:"areaName",hiddenId:"areaCode"});

	// 初始化角色
	// getRoleBy("roleid");

	// 触发选择确认事件
	$("#selectDisabled_ok").click(function() {
	    selectDisabled.selectData();
	    dialog_wrap1.dialog('destroy');// 销毁
	    $('#' + p.fieldId).val(selectdisabledids);
	});
    });
}

selectDisabled.searchParty =function() {
    var areaCode = $("#areaCode").val();
    /* var roleId=$("#roleId").val(); */
    /* var partyNum=$("#partyNum").val(); */
    var disabledName = $("#disabledName").val();
    /* var cardId=$("#cardId").val(); */
    $.post(projectName + "/disabled/dfbase/page", {
	dname : disabledName,
	/* roleId:roleId, */
	areaCode : areaCode,
    /* cardId:cardId */
    }, function(rs) {
	$("#selectDisabled_wrap_list").html("");
	if (rs.rows.length && rs.rows.length >= 0) {
	    $("#selectDisabled_wrap_list").append("");
	    var str = "";
	    $.each(rs.rows, function(i, item) {
		str += '<li class="col-sm-6">';
		str += '<input type="checkbox" id="disabledinfo' + item.did + '"  name="" value="' + item.did + '" />';
		/*
		 * var str1=""; $.each(item.role,function(j,v){
		 * if(v.roleId!='ROLE0'){ str+=' '+v.roleTitle+' '; } })
		 */
		str += '<label for="disabledinfo' + item.did + '">' + item.dname + '</label>';
		str += '</li>';
	    });
	    $("#selectDisabled_wrap_list").append(str);
	}
    }, 'json');
}

selectDisabled.selectAll = function() {
    $("#selectDisabled_wrap_list input[type='checkbox']").each(function(i, item) {
	$(item).attr("checked", "checked");
    });
}

// 选择数据后填充容器
selectDisabled.selectData = function() {
    var oldnum = "";
    $("#selectDisabled_wrap_list input[type='checkbox']:checked").each(function(i, item) {
	selectusers = selectdisabledids.split(',');
	if (selectusers.indexOf($(item).val())) {
	    var str = "";
	    str += '<li class="hover_li col-sm-6" id="u' + $(item).val() + '">';
	    str += $(this).parent().children().text();
	    str += '<span class="delete_sub" onclick=selectDisabled.deleteUser("u' + $(item).val() + '","' + $(item).val() + '")><img src="../../../resources/images/delete_icon.png"></span>';
	    str += '</li>';
	    $("#selectDisabled_list").append(str);
	    // 获取原来的数量
	    oldnum = $("#count_disabled").html();
	    selectdisablednum++;
	    if (selectdisabledids != "") {
		selectdisabledids += ",";
	    }
	    selectdisabledids += $(item).val();
	} else {
	    $.messager.alert('错误操作', '不能重复选择对象!', 'error');
	}
    });
    $("#count_disabled").html(parseInt(oldnum) + selectdisablednum);
}

selectDisabled.deleteUser = function(obj, id) {
    $('#' + obj).remove();
    selectdisablednum--;
    $("#count_disabled").html(selectdisablednum);
    var arr = selectdisabledids.split(',');
    arr.splice($.inArray(id, arr), 1);
    selectdisabledids = "";
    $.each(arr, function(i, item) {
	if (selectdisabledids != "") {
	    selectdisabledids += ",";
	}
	selectdisabledids += item;
    });
    $("#" + fieldIds).val(selectdisabledids);
}

selectDisabled.clearUser = function() {
    selectdisablednum = 0;
    selectdisabledids = "";
    $("#count_disabled").html(0);
    $("#selectDisabled_list").html('');
}
