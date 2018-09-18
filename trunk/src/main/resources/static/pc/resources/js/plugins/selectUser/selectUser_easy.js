var selectUser = {};
var selectusernum = 0;
var selectuserids = "";
var fileId="";

selectUser.init = function(option) {
    var defaults = {
	"width" : 550,
	"height" : 450,
	"title" : '请选择发送对象',
    };
    var p = $.extend({}, defaults, option);
    fileId=p.fieldId;
    $('#' + p.id).after('<input type="hidden" id="' + p.fieldId + '" name="' + p.fieldId + '" />');
    $('#' + p.id).after('<div class="dialogs"><h5>已选择人员(<small id="count_p">0</small>)<a href=javascript:selectUser.clearUser() style="float:right">清除</a></h5> <div class="receive_div" style="padding:5px;">  <ul id="selectuser_list" class="list-unstyled"></ul>  </div> </div>');
    var str = '     <div class="wrap_header col-sm-10">';
    str += '        <div class="row col-sm-12" style="padding:8px;margin-bottom:0px">';
    str += '            <div class="col-md-12" style="padding:0px">';
    str += '					<select class="form_in searchfield  easyui-combotree" id="orgName" name="orgName" op="equal" style="width:100%;"></select>';
    str += '                    <input type="hidden" name="orgId" id="orgId" />';
    str += '            </div> ';
    /* str += '             <div class="col-md-4">';
     str += '                <select class="form_in searchfield" id="roleid" name="roleid" op="equal"></select>';
     str += '             </div>';*/
    str += '        </div>';
    str += '       <div class="row col-sm-12" style="padding:8px;margin-bottom:0px">';
    /*    str += '           <div class="col-md-12" style="padding:0px">';
     str += '               <input class="form_in" id="partynum" value="" placeholder="请填写党员编号" />';
     str += '          </div>';*/
    str += '           <div class="col-md-12" style="padding-left:0!important;padding-right:0!important;">';
    str += '              <input class="form_in"  id="name" value="" placeholder="请填写姓名" />';
    str += '          </div>';
    /*    str += '          <div class="col-md-4">';
     str += '              <input class="form_in" id="cardid"  value="" placeholder="请填写身份证号码" />';
     str += '          </div>';*/
    str += '       </div>';
    str += '  </div>';
    str += '  <div class="wrap_header col-sm-2" style="padding:10px 10px 10px 0">';
    str += '     <div class="wrap_header_hover" onclick=selectUser.searchParty()>';
    str += '         <img src="../../../resources/images/seach_icon.svg" class="img-responsive" style="height: 40px; display: inline-block; line-height: 85px; margin-top: 10px;" />';
    str += '         <div style="font-size:16px;color:#fff">搜索</div>';
    str += '      </div>';
    str += '  </div>';
    str += '  <div class="wrap_content_a">';
    str += '       <div class="wrap_content_b">';
    str += '          <h5>选择人员(可多选)<small class="right_float set_but" onclick="selectUser.selectAll()">全选</small></h5>';
    str += '          <ul id="selectuser_wrap_list" class="list-unstyled"></ul>';
    str += '      </div>';
    str += '  </div>';
    str += '  <div class="wrap_content_a" style="text-align:center">';
    str += '      <button type="button" class="btn" style="width: 30%; background: #3598dc;color:#fff" id="selectuser_ok">确认</button>';
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
	//初始化支部树
	getTreeByEasyui();
	//初始化角色
	//getRoleBy("roleid");

	//触发选择确认事件
	$("#selectuser_ok").click(function() {
	    selectUser.selectData();
	    dialog_wrap1.dialog('destroy');// 销毁
	    $('#' + p.fieldId).val(selectuserids);
	});

    });
}

selectUser.searchParty = function() {
    var orgId = $("#orgId").val();
    /*var roleId=$("#roleId").val();*/
    /*var partyNum=$("#partyNum").val();*/
    var name = $("#name").val();
    /*var cardId=$("#cardId").val();*/
    $.post(projectName + "/sys/user/userobjlist", {
	deptCode : orgId,
	/*roleId:roleId,*/
	nickName : name,
    /*cardId:cardId*/
    }, function(rs) {
	$("#selectuser_wrap_list").html("");
	if (rs.code == 1) {
	    $("#selectuser_wrap_list").append("");
//	    console.log(JSON.stringify(rs));
	    var str = "";
	    $.each(rs.data, function(i, item) {
		str += '<li class="col-sm-6">';
		str += '<input type="checkbox" id="partinfo' + item.userId + '"  name="" value="' + item.userId + '" />';
		/*var str1="";
		$.each(item.role,function(j,v){
			if(v.roleId!='ROLE0'){
				str+=' '+v.roleTitle+' ';
			}
		})*/
		str += '<label for="partinfo' + item.deptCode + '">' + item.deptName + '  ' + item.nickName + '</label>';
		str += '</li>';
	    });
	    $("#selectuser_wrap_list").append(str);
	}
    }, 'json')
}

selectUser.selectAll = function() {
    $("#selectuser_wrap_list input[type='checkbox']").each(function(i, item) {
	$(item).attr("checked", "checked");
    });
}

//选择数据后填充容器
selectUser.selectData = function() {
	var oldnum="";
    $("#selectuser_wrap_list input[type='checkbox']:checked").each(function(i, item) {
	selectusers = selectuserids.split(',');
	if (selectusers.indexOf($(item).val())) {
	    var str = "";
	    str += '<li class="hover_li col-sm-6" id="u' + $(item).val() + '">';
	    str += $(this).parent().children().text();
	    str += '<span class="delete_sub" onclick=selectUser.deleteUser("u' + $(item).val() + '","' + $(item).val() + '")><img src="../../../resources/images/delete_icon.png"></span>';
	    str += '</li>';
	    $("#selectuser_list").append(str);
	    //获取原来的数量
	    oldnum = $("#count_p").html();
	    selectusernum++;
	    if (selectuserids != "") {
		selectuserids += ",";
	    }
	    selectuserids += $(item).val();
	} else {
	    $.messager.alert('错误操作', '不能重复选择对象!', 'error');
	}
    });
    $("#count_p").html(parseInt(oldnum) + selectusernum);
}

selectUser.deleteUser = function(obj, id) {
    $('#' + obj).remove();
    selectusernum--;
    $("#count_p").html(selectusernum);
    var arr = selectuserids.split(',');
    arr.splice($.inArray(id, arr), 1);
    selectuserids = "";
    $.each(arr, function(i, item) {
	if (selectuserids != "") {
	    selectuserids += ",";
	}
	selectuserids += item;
    });
    $("#"+fileId).val(selectuserids);
}

selectUser.clearUser = function() {
    selectusernum = 0;
    selectuserids = "";
    $("#count_p").html(0);
    $("#selectuser_list").html('');
}
