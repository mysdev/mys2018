/*网格化通用js函数     版本 1.0.0*/

var Faith = {};
var Event = {};
Faith.centerPoint = {
	x: '109.58812',
	y: '27.95446'
};

Faith.currentUser = {};

// 获取项目根目录
Faith.pathName = window.document.location.pathname;
Faith.projectName = Faith.pathName.substring(0, Faith.pathName.substr(1).indexOf('/') + 1);
// Faith.projectName="";

Faith.toolbarAction = '/sys/permission/action'; // 加载工具条接口

Faith.addOptions = {
	title: '',
	addUrl: ''
};
Faith.updateOptions = {
	title: '',
	updateUrl: ''
};
Faith.deleteOptions = {
	gridId: '',
	deleteAction: '',
	tableKey: ''
};
Faith.viewOptions = {
	title: '',
	viewUrl: ''
};

// easyui datagrid全局变量
Faith.gridOptions = {
	dataType: 'json',
	method: 'post',
	rownumbers: true,
	singleSelect: true,
	width: "100%", // 宽度
	// height:'680px',
	striped: true, // 把行条纹化（奇偶行背景色不同）
	loadMsg: '正在加载数据......', // 从远程站点加载数据是，显示的提示消息
	pagination: true, // 数据网格底部显示分页工具栏
	pageList: [10, 50, 100], // 设置每页记录条数的列表
	pageSize: 10, // 初始化页面尺寸（默认分页大小）
	pageNumber: 1, // 初始化页面（默认显示第一页）
	beforePageText: '第', // 页数文本框前显示的汉字
	afterPageText: '页 共 {pages} 页',
	displayMsg: '第{from}到{to}条，共{total}条',
	sortName: 'createdDate',
	sortOrder: 'desc',
	pageNumber: 1,
	// fit : false,
	fitColumns: true,
	onBeforeLoad: function(param) {
		var sort = param.sort; // 保存下值
		delete param.sort;
		param.orderName = sort;
		var order = param.order;
		delete param.order;
		param.sortName = order;
		var rows = param.rows;
		delete param.rows;
		param.pageSize = rows;
		var page = param.page;
		delete param.page;
		param.pageNumber = page;
	}
};

// 跳转 添加页面
Faith.doAdd = function() {
	// location.href=Faith.addOptions.addurl;
	var listTitle = top.$('#maintab').tabs('getSelected').panel('options').title;
	var url = Faith.addOptions.addUrl;
	if(url.indexOf('?') > 0) {
		url = url + "&listTitle=" + encodeURI(listTitle);
	} else {
		url = url + "?listTitle=" + encodeURI(listTitle);
	}
	top.addTab(Faith.addOptions.title, url);
}

// 跳转 修改页面
Faith.doUpdate = function() {
	var listTitle = top.$('#maintab').tabs('getSelected').panel('options').title;
	var selected = $('#' + Faith.gridOptions.gridId).datagrid('getSelected');
	if(selected && selected != "") {
		var url = Faith.updateOptions.updateUrl;
		if(url.indexOf('?') > 0) {
			url = url + "&pkVal=" + selected[Faith.gridOptions.tableKey];
		} else {
			url = url + "?pkVal=" + selected[Faith.gridOptions.tableKey];
		}
		url = url + "&listTitle=" + encodeURI(listTitle);
		top.addTab(Faith.updateOptions.title, url);
	} else {
		$.messager.alert("提示", "请先选择一条数据");
	}
	// location.href = Faith.addOptions.updateUrl;

}

Faith.doSave = function(options) {
	$('#' + options.saveButtonId).click(function() {
		
		if(options.beforeSubmit){
			var bs=options.beforeSubmit;
			var rs=bs();
			if(!rs){
				return ;
			}
		}
		
		var $btn = $(this).button('loading');
		options.complete = function() {
			$btn.button('reset'); // 提交完成 重置按钮 刷新页面
		};
		options.success = function() {
			var cur_tab = top.$("#maintab").tabs('getSelected');
			var index = top.$("#maintab").tabs('getTabIndex', cur_tab);

			// 刷新列表
			var listTitle = decodeURI(Faith.getQueryStringByName("listTitle"));
			if(listTitle && listTitle != "" && top.$("#maintab").tabs('exists', listTitle)) {
				top.$("#maintab").tabs('select', listTitle);
				var prve_tab = top.$("#maintab").tabs('getSelected');
				var gridId = $('iframe', prve_tab)[0].contentWindow.Faith.gridOptions.gridId;
				$('iframe', prve_tab)[0].contentWindow.$('#' + gridId).datagrid('reload');
			}
			// 关闭当前tab
			top.$("#maintab").tabs('close', index);
		};
		Faith.submitForm(options);
		$btn.button('reset');
	});

	// 取消按钮
	if(options.cancelButtonId && options.cancelButtonId != "") {
		$('#' + options.cancelButtonId).click(function() {
			// 关闭 当前
			Faith.closeTab();
		});
	}
}

// 取消按钮点击事件
Faith.doCancel = function(options) {
	$('#' + options.cancelButtonId).click(function() {
		// 关闭 当前
		Faith.closeTab();
	});
}

// 列表查询
Faith.doSearch = function(btn, search) {
	// 查询按钮
	$('#' + btn).click(function() {
		var queryParams = Faith.getFormData(search);
		if($('#' + Faith.gridOptions.gridId).datagrid("options").url == "") {
			$('#' + Faith.gridOptions.gridId).datagrid({
				url: Faith.gridOptions.url,
				queryParams: queryParams
			});
		} else {
			$('#' + Faith.gridOptions.gridId).datagrid("load", queryParams);
		}
	});
}

// 执行删除方法
Faith.doDelete = function() {

	var row = $('#' + Faith.gridOptions.gridId).datagrid("getSelected");
	if(row) {
		var id = row[Faith.gridOptions.tableKey];
		var title = Faith.deleteOptions.title || "删除数据";
		$.messager.confirm('警告', '您确定要' + title + '吗?', function(r) {
			if(r) {
				// 加载数据
				$.ajax({
					type: "get",
					url: Faith.deleteOptions.deleteAction + id,
					data: {},
					dataType: 'json',
					success: function(rs) {
						if(rs.code == "1") {
							$.messager.alert('提示', title + '成功');
							$('#' + Faith.gridOptions.gridId).datagrid('reload');
						} else {
							$.messager.alert('提示', rs.message);
						}
					}
				});
			}
		});
	} else {
		$.messager.alert('操作错误', '请选择一条数据!', 'error');
	}
}

// 跳转 查看明细页面
Faith.doView = function() {
	var row = $('#' + Faith.gridOptions.gridId).datagrid("getSelected");
	if(row) {
		var id = row[Faith.gridOptions.tableKey];

		var url = Faith.viewOptions.viewUrl;
		if(url.indexOf('?') > 0) {
			url = url + "&pkVal=" + id;
		} else {
			url = url + "?pkVal=" + id;
		}
		top.addTab(Faith.viewOptions.title, url);

	} else {
		$.messager.alert('操作错误', '请选择一条数据!', 'error');
	}
}

// 关闭当前tab
Faith.closeTab = function() {
	var cur_tab = top.$("#maintab").tabs('getSelected');
	var index = top.$("#maintab").tabs('getTabIndex', cur_tab);
	// 关闭当前tab
	top.$("#maintab").tabs('close', index);
}

// 刷新列表
Faith.refreshGrid = function(options) {
	if(top.$("#maintab").tabs('exists', options.listTitle)) {
		top.$("#maintab").tabs('select', options.listTitle);
		var prve_tab = top.$("#maintab").tabs('getSelected');
		var gridId = $('iframe', prve_tab)[0].contentWindow.Faith.gridOptions.gridId;
		$('iframe', prve_tab)[0].contentWindow.$('#' + gridId).datagrid('reload');
	}
}

// 关闭当前tab 并刷新页面grid
Faith.closeTabAndRefresh = function(title) {
	var cur_tab = top.$("#maintab").tabs('getSelected');
	var index = top.$("#maintab").tabs('getTabIndex', cur_tab);
	// 刷新列表
	if(top.$("#maintab").tabs('exists', title)) {
		top.$("#maintab").tabs('select', title);
		var prve_tab = top.$("#maintab").tabs('getSelected');
		var gridId = $('iframe', prve_tab)[0].contentWindow.Faith.gridOptions.gridId;
		$('iframe', prve_tab)[0].contentWindow.$('#' + gridId).datagrid('reload');
	}
	// 关闭当前tab
	top.$("#maintab").tabs('close', index);
}

// 加载 数据列表
Faith.initGrid = function(options) {
	if(options.gridId == null || options.gridId == "") {
		$.messager.alert("提示", "请定义datagrid的Id:gridId");
		return;
	}
	if(options.tableKey == null || options.v == "") {
		$.messager.alert("提示", "请定义表格主键：tableKey");
		return;
	}

	var op = $.extend({}, Faith.gridOptions, options);
	if(options.delayLoad) {
		op.url = "";
	}
	Faith.gridOptions.gridId = options.gridId;
	Faith.gridOptions.tableKey = options.tableKey;
	if(options.isToolBar) {
		var toolbar = [];
		$.ajax({
			type: 'get',
			dataType: 'json',
			url: Faith.projectName + Faith.toolbarAction,
			data: {
				resId: Faith.gridOptions.resId,
				pageButtonKey: Faith.gridOptions.pageButtonKey
			},
			async: false,
			success: function(rs) {
				if(rs.code == 1) {
					$.each(rs.data, function(i, item) {
						toolbar.push({
							iconCls: item.resIcon,
							text: item.resName,
							handler: function() {
								eval(item.callback);
							}
						});
					});
				} else {
					$.messager.alert('操作失败', rs.message);
				}
			}
		});
		op.toolbar = toolbar
	}

	$('#' + op.gridId).datagrid(op);
}

// 加载 工具条
// wrapid:toolbar容器id
// resId:从url获取 菜单的id
// pageButtonKey:后台按钮配置的关键字
Faith.initToolBar = function(wrapid, resId, pageButtonKey) {
	var div_warp = $('<div class="toolbar"></div>');
	var div2_warp = $('<div  style="padding:5px;vertical-align: middle;"></div>');
	div_warp.append(div2_warp);
	$('#' + wrapid).append(div_warp);
	$.get(Faith.projectName + Faith.toolbarAction, {
		resId: resId,
		pageButtonKey: pageButtonKey
	}, function(rs) {
		if(rs.code == 1) {
			$.each(rs.data, function(i, item) {
				var bt = $('<a href="#" >' + item.resName + '</a>');
				div2_warp.append(bt);
				bt.linkbutton({
					plain: true,
					iconCls: item.resIcon,
					onClick: function() {
						eval(item.callback);
					}

				});
			});
		} else {
			$.messager.alert('操作失败', rs.message);
		}
	}, 'json');

}

// 删除datagrid 一行方法
// options必要参数:
// gridId:表格容器的id
// deleteAction:删除接口
// tableKey:数据表主键字段
Faith.deleteRow = function(options) {
	var row = $('#' + options.gridId).datagrid("getSelected");
	if(row) {
		var id = row[options.tableKey];
		$.messager.confirm('警告', '您确定要删除此条数据吗?', function(r) {
			if(r) {
				// 加载数据
				$.ajax({
					type: "get",
					url: Faith.projectName + options.deleteAction + id,
					data: {},
					dataType: 'json',
					success: function(rs) {
						if(rs.code == "1") {
							$.messager.alert('操作成功', '删除成功');
							$('#' + options.gridId).datagrid('load');
						} else {
							$.messager.alert('操作失败', rs.message);
						}
					}
				});
			}
		});
	} else {
		$.messager.alert('操作错误', '请选择一条数据!', 'error');
	}
}

// 初始化富文本框架
Faith.initEditor = function(fieldname, fieldid, height) {

	var $hidden = $('<input type="hidden" class="easyui-validatebox" editor-height="' + height + '" editor-id="' + fieldname + '" data-options="required:true" id="' + fieldid +
		'" name="' + fieldid + '"></input>');
	$('#' + fieldname).after($hidden);
	var editor = new window.wangEditor('#' + fieldname);
	if(height) {
		editor.customConfig.height = height;
	}
	editor.customConfig.onchange = function(html) {
		// 监控变化，同步更新到 textarea
		$hidden.val(html);
	}
	editor.create();
}

// options必要属性：
// formid:表单的id
// url:提交接口地址
Faith.submitForm = function(options) {
	// 表单验证
	var form = $("#" + options.formid);
	var valid=Faith.validForm(options.formid);
	/*
	 * var validate = form.form('validate'); if (!validate) {
	 * $.messager.alert("确认", '请正确填写表单！', "", function() {
	 * form.find(".validatebox-invalid:first").focus(); }); return false }
	 */

	if(!valid){
		var error=$('#error_panel').text(); 
		Faith.error('提交表单未填写完整：'+error); 
		if(options.complete) {
			var complete = options.complete;
			complete();
		}
		return ;
	}
	var action = options.addAction;
	var title = top.$('#maintab').tabs('getSelected').panel('options').title;
	// 获取表单所有项目值
	var fromdata = Faith.getFormData(options.formid);
	if(options.pkVal != null && options.pkVal != "") {
		fromdata[options.tableKey] = options.pkVal;
		action = options.updateAction; 
	}

	$.ajax({
		type: "post",
		url: action,
		data: fromdata,
		dataType: 'json',
		success: function(rs) {
			if(rs.code == '1') {
				title = title || '保存';
				$.messager.alert('提示', title + '成功', 'info', function() {
					if(options.success) {
						var success = options.success;
						success();
					}
				});

			} else {
				$.messager.alert('提示', rs.message, 'error', function() {
					if(options.error) {
						var error = options.error;
						error();
					}
				});
			}
			if(options.complete) {
				var complete = options.complete;
				complete();
			}
		}
	});
}

// 获取表单数据
Faith.getFormData = function(formid) {
	var formdata = {};
	$('#' + formid).find('input,select,textarea').each(function(i, item) {
		var name = $(item).attr('name');
		if(typeof(name) != "undefined" && name != null && name != "") {
			if($(item).attr('type') == "radio") {
				if(formdata[name] && formdata[name].length > 0) {
					// 已存在 什么都不做
				} else {
					formdata[name] = $('input:radio[name="' + name + '"]:checked', $('#' + formid)).val();
				}
			} else if($(item).attr('type') == "checkbox") {
				if($(item).is(':checked')) {
					var cv = $(item).val();
					var v = formdata[name];
					if(typeof(v) == "undefined" || v == null || v == "") {
						formdata[name] = cv;
					} else {
						formdata[name] = v + ',' + cv;
					}
				}
			} else if($(item).attr('type') == "file") {
				// 文件标签 什么都不做
			} else if($(item).attr('type') == "button") {
				// 按钮 什么都不做
			} else if($(item).attr('type') == "number") {
				formdata[name] = $(item).val();
			} else if($(item).attr('type') == "hidden") {
				if(formdata[name] && formdata[name] != "") {
					formdata[name] += ",";
					formdata[name] += $(item).val();
				} else {
					formdata[name] = $(item).val();
				}
			} else {
				formdata[name] = $(item).val();
			}
		}
	});
	return formdata;
}

// 填充表单方法
Faith.setFormData = function(formid, formdata) {
	$('#' + formid).find('input,select,textarea').each(function(i, item) {

		var id = $(item).attr('name');
		var value = formdata[id];
		var type = $(item).attr('type');

		if(type == "radio") {
			if(value) {
				$('input:radio[name="' + id + '"][value="' + value + '"]', $('#' + formid)).attr('checked', 'checked');
				if($('#' + id).length > 0) {
					$('#' + id).val(value);
				}
			}
		} else if(type == "checkbox") {
			if(value) {
				$.each(value.split(','), function(j, val) {
					if(val && val.length > 0) {
						$('input:checkbox[name="' + id + '"][value="' + val + '"]', $('#' + formid)).attr('checked', 'checked');
					}
				});
			}
		} else if(type == "file") {
			// 文件标签 什么都不做
		} else if(type == "button") {
			// 按钮 什么都不做
		} else if(type == "number") {
			$(item).val(value);
		} else if(type == "date") {
			var format = $(item).attr('format') || "yyyy-MM-dd";
			if(typeof(value) == "string" && value.indexOf('-') > 0) {
				$(item).val(value);
			} else if(typeof(value) == "number") {
				var text = Faith.getDateFormat(value, format);
				$(item).val(text);
			}
		} else if(type == "hidden") {

			if($(item).parent().is('span') && $(item).parent().hasClass('combo')) {
				// easyui combotree
				if($('#' + id).hasClass('combotree-f')) {
					if(formdata.area) {
						$('#' + id).combotree('setValue', {
							id: formdata.area.areaCode,
							text: formdata.area.areaName,
						});
					}
					if(formdata.marea) {
						$('#' + id).combotree('setValue', {
							id: formdata.marea.areaCode,
							text: formdata.marea.areaName,
						});
					}

				}
				// easyui combobox
				if($('#' + id).hasClass('combobox-f')) {
					$('#' + id).combobox('setValue', value);
				}

				// easyui datebox
				if($('#' + id).hasClass('datebox-f')) {
					$('#' + id).datebox('setValue', Faith.getDateFormat(value, 'yyyy-MM-dd'));
				}

				// easyui datetimebox
				if($('#' + id).hasClass('datetimebox-f')) {
					$('#' + id).datetimebox('setValue', Faith.getDateFormat(value, 'yyyy-MM-dd HH:mm:ss'));
				}

			} else {
				// 处理富文本编辑器
				if($(item).attr('editor-id') != null && $(item).attr('editor-id') != '') {
					debugger
					var editorid = $(item).attr('editor-id');
					var height = $(item).attr('editor-height');
					var editor = new window.wangEditor('#' + editorid);
					if(height) {
						editor.customConfig.height = height;
					}
					editor.customConfig.onchange = function(html) {
						$(item).val(html);
					}
					editor.create();
					editor.txt.html(value);
					$(item).val(value);
				} else {
					$(item).val(value);
					$(item).change();
				}
			}
		} else {
			$(item).val(value);
		}
		/*
		 * if ($(item).attr('attribute') == 'date') { var id =
		 * $(item).attr('id'); var format = $(item).attr('format'); var value =
		 * formdata[id]; var field_val = formdata[id]; var text =
		 * getLongDateAsString(value, format); if (typeof (field_val) ==
		 * "string" && field_val.indexOf('-') > 0) { $(item).val(field_val); }
		 * else if (typeof (field_val) == "number") { var text =
		 * getLongDateAsString(field_val, format); $(item).val(text); } }
		 */
	});
}

// 填充表格 setTableData
Faith.setTableData = function(tableid, formdata, imagetype) {
	var image = imagetype || "img";
	for(var key in formdata) {
		var obj = $('#' + key, $('#' + tableid));
		if(obj) {
			var type = obj.attr('type');
			if(type && type == image) {
				if(formdata[key] != null) {
					var files = formdata[key];
					var str = "";
					$.each(files.split(','), function(i, item) {
						if(item && item != "")
							$.ajax({
								type: "get",
								url: Faith.projectName + '/document/index/' + item,
								data: {},
								dataType: 'json',
								async: false,
								success: function(rs) {
									if(rs.code == '1'&& rs.data) {
										if(rs.data!=null){
											if(rs.data.suffix.indexOf('png') > 0 || rs.data.suffix.indexOf('jpg') > 0 || rs.data.suffix.indexOf('gif') > 0 ||
													rs.data.suffix.indexOf('bmp') > 0) {
													str += '<img src="' + Faith.projectName + '/document/show/' + item + '" class="gallery" style="cursor:pointer">';
												}
										}
									}
								}
							});
					});
					obj.html(str);
				}
			} else if(type && type == "file") {
				if(formdata[key] != null) {
					var files = formdata[key];
					var str = "";
					$.each(files.split(','), function(i, item) {
						if(item && item != "") {
							str += '<a class="btn btn-info" style="display:block;width: 40%" href="/document/' + item +
								'" download> <span class="glyphicon glyphicon-paperclip" ></span>下载附件</a>';
						}
					});
					obj.html(str);
				}
			} else if(type && type == "hidden") {
				obj.val(formdata[key]);
			} else if(type && type == "dictionary") {
				var group_code = obj.attr('code');
				obj.html(Faith.dictionaryToChinese(group_code, formdata[key]));
			} else if(type && type == "datetime") {
				obj.html(Faith.getDateFormat(formdata[key], "yyyy-MM-dd HH:mm"));
			} else if(type && type == "date") {
				obj.html(Faith.getDateFormat(formdata[key], "yyyy-MM-dd"));
			} else if(type && type == "area") {
				if(formdata.area && formdata.area != "") {
					obj.html(formdata.area.areaName);
				}
			} else {
				obj.html(formdata[key]);
			}
		}
	}
}

// 选择人员（全员人口） id:初始化容器id
Faith.initSelectPerson = function(id, options) {
	var ishz = "";
	if(options && options.ishz) {
		ishz = "?hz=1";
	}
	var height = 34;
	if(options && options.height) {
		height = options.height;
	}
	var editable = false;
	if(options && options.editable) {
		editable = options.editable;
	}
	$('#' + id).textbox({
		height: height,
		width: '100%',
		editable: editable,
		icons: [{
			iconCls: 'icon-search',
			handler: function(e) {
				var xm = $(e.data.target).textbox('getText');
				if(xm != "") {
					ishz += (ishz == "" ? "?" : "&");
					ishz += "xm=" + xm;
				}
				var dialog_options = {
					id: 'SelectPersonWrap',
					title: '选择人员',
					formpage: Faith.projectName + '/webpage/common/selectpeople.html' + ishz,
					buttons: [{
						text: '确定',
						handler: function() {
							var rows = document.getElementById('SelectPersonWrap').contentWindow.returnvalues();
							if(options.valueField) {
								$(e.data.target).textbox('setValue', rows.xm);
								$(e.data.target).textbox('setText', rows.xm);
								if(options && options.ishz) {
									$('#' + options.valueField).val(rows.sfzh);
								}else{
									$('#' + options.valueField).val(rows.peopleId);
								}
							} else {
								if(options && options.ishz) {
									$(e.data.target).textbox('setValue', rows.sfzh);
								}else{
									$(e.data.target).textbox('setValue', rows.peopleId);
								}
								$(e.data.target).textbox('setText', rows.xm);
							}

							if(options && options.callback) {
								var cb = options.callback;
								cb(rows);
							}
							// 关闭窗口
							$('#SelectPersonWrap').dialog('destroy');
						}
					}]
				};
				Faith.openForm(dialog_options);
			}
		}]
	});
}

// 选择房屋 id:初始化容器id
Faith.initSelectHouse = function(id, options) {

	var height = 34;
	if(options && options.height) {
		height = options.height;
	}
	var editable = false;
	if(options && options.editable) {
		editable = options.editable;
	}
	$('#' + id).textbox({
		height: height,
		width: '100%',
		editable: editable,
		icons: [{
			iconCls: 'icon-search',
			handler: function(e) {

				var dialog_options = {
					id: 'SelectHouseWrap',
					title: '选择房屋',
					width: '980px',
					formpage: Faith.projectName + '/webpage/common/selecthouse.html',
					buttons: [{
						text: '确定',
						handler: function() {
							var rows = document.getElementById('SelectHouseWrap').contentWindow.returnvalues();
							if(rows != null && rows != "" && rows.houseId && rows.houseId != "") {
								$(e.data.target).textbox('setValue', rows.houseId);
								$(e.data.target).textbox('setText', rows.address);

								if(options && options.callback) {
									var cb = options.callback;
									cb(rows);
								}
								// 关闭窗口
								$('#SelectHouseWrap').dialog('destroy');
							} else {
								$.messager.alert('提示', "请选择一个房间");
							}
						}
					}]
				};
				Faith.openForm(dialog_options);
			}
		}]
	});
}

// id:初始化容器id
Faith.initSelectUser = function(id, options) {
	var default_op = {
		width: '100%',
		valueField: 'userId',
		textField: 'nickName',
		buttonText: '点击选择',
		editable: false,
		onClickButton: function() {
			var options = {
				id: 'SelectUserWrap',
				title: '选择人员',
				formpage: Faith.projectName + '/webpage/common/selectuser.html',
				buttons: [{
					text: '确定',
					handler: function() {
						var rows = document.getElementById('SelectUserWrap').contentWindow.returnUserIds();
						$('#' + id).tagbox('loadData', rows);
						var vals = [];
						$.each(rows, function(i, item) {
							vals.push(item.userId);
						});
						$('#' + id).tagbox('setValues', vals);
						$('#SelectUserWrap').dialog('destroy');
					}
				}]
			};
			Faith.openForm(options);
		}
	}
	var op = $.extend({}, default_op, options);
	$('#' + id).tagbox(op);
}

/**
 * 获取QueryString的数组
 */
Faith.getQueryString = function() {
	var result = location.search.match(new RegExp("[\?\&][^\?\&]+=[^\?\&]+", "g"));
	if(result == null) {
		return "";
	}
	for(var i = 0; i < result.length; i++) {
		result[i] = result[i].substring(1);
	}
	return result;
}

/**
 * 根据QueryString参数名称获取值
 */
Faith.getQueryStringByName = function(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if(r != null)
		return(r[2]);
	return null;
}

/**
 * 根据QueryString参数索引获取值
 */
Faith.getQueryStringByIndex = function(index) {
	if(index == null) {
		return "";
	}
	var queryStringList = Faith.getQueryString();
	if(index >= queryStringList.length) {
		return "";
	}
	var result = queryStringList[index];
	var startIndex = result.indexOf("=") + 1;
	result = result.substring(startIndex);
	return result;
}

/**
 * 翻译 字典编码->中文 多个用逗号隔开
 * 
 * @param group
 * @param code
 * @returns
 */
Faith.dictionaryToChinese = function(group, code) {
	if(!code) {
		return "";
	}
	var array = [];
	for(var i = 0; i < dictionaryObj.length; i++) {
		if(dictionaryObj[i].code == group) {
			array = dictionaryObj[i].dictionarys;
		}
	}
	if(code.length > 0 && code.indexOf(",") > 0) {
		var res = '';
		var codes = code.split(",");
		for(var j = 0; j < array.length; j++) {
			for(var k = 0; k < codes.length; k++) {
				if(array[j].code == codes[k]) {
					res = res + array[j].value + "，";
				}
			}
		}
		if(res.length > 0) {
			res = res.substring(0, res.length - 1)
		}
		return res;
	} else {
		for(var j = 0; j < array.length; j++) {
			if(array[j].code == code) {
				return array[j].value;
			}
		}
	}
	return "未知";
}

Faith.getDateFormat = function(dt, format) {
	if(dt == null || dt == "" || dt == "null") {
		return "";
	}
	var bd = new Date(dt);
	var year = bd.getFullYear();
	var month = bd.getMonth() + 1;
	var date = bd.getDate();
	if(month < 10) {
		month = "0" + month;
	}
	if(date < 10) {
		date = "0" + date;
	}
	var h = bd.getHours();
	var m = bd.getMinutes();
	var s = bd.getSeconds();
	if(h < 10) {
		h = '0' + h;
	}
	if(m < 10) {
		m = '0' + m;
	}
	if(s < 10) {
		s = '0' + s;
	}

	if('yyyy-MM-dd' == format) {
		return year + "-" + month + "-" + date;
	} else if('yyyy-MM-dd hh:mm:ss' == format || 'yyyy-MM-dd HH:mm:ss' == format) {
		return year + "-" + month + "-" + date + " " + h + ":" + m + ":" + s;
	} else if('yyyy-MM-dd hh:mm' == format || 'yyyy-MM-dd HH:mm' == format) {
		return year + "-" + month + "-" + date + " " + h + ":" + m;
	} else if('yyyy-MM' == format) {
		return year + "-" + month;
	} else if('yyyyMMdd' == format) {
		return year + month + date;
	}
	// getDate() 查看Date对象并返回日期
	// getDay() 返回星期几
	// getHours() 返回小时数
	// getMinutes() 返回分钟数
	// getMonth() 返回月份值
	// getSeconds() 返回秒数
	// getTime() 返回完整的时间
	// getYear() 返回年份
	return bd.toLocaleString();
}

//自定义参数下拉框
Faith.initComboboxSelf = function(id, data,defaultValue,height, required) {
	var h = height || 34;
	var required = required || false;
	var defaultValue  = defaultValue || 0;
	$('#' + id).combobox({
		data: data,
		required: required,
		valueField: 'code',
		textField: 'value',
		value: defaultValue,
		limitToList: true,
		width: '100%',
		height: h
	});
}


// 初始化下拉选择 绑定数据字典
Faith.initCombobox = function(id, groupcode, height, required) {
	var h = height || 34;
	var data = Faith.getDictionaryItem(groupcode);
	var required = required || false;
	// console.log(JSON.stringify(data));
	$('#' + id).combobox({
		data: data,
		required: required,
		valueField: 'code',
		textField: 'value',
		limitToList: true,
		width: '100%',
		height: h
	});
}

// 初始化下拉选择 根据接口获取后台数据
/*
 * options={ id:'', url:'', valueField:'', textField:'' }
 */
Faith.initComboboxUrl = function(options) {

	if(options.url && options.url != "") {
		var op = $.extend({}, {
			type: 'get',
			valueField: 'id',
			textField: 'text',
			required: false,
			width: '100%',
			height: 34
		}, options);
		$.ajax({
			type: op.type,
			dataType: 'json',
			url: Faith.projectName + op.url,
			success: function(rs) {
				if(rs.code == 1) {
					$('#' + op.id).combobox({
						data: rs.data,
						valueField: op.valueField,
						textField: op.textField,
						width: op.width,
						limitToList: true,
						height: op.height
					});

				} else {
					$.messager.alert(rs.message);
				}
			}
		});
	} else {
		$.messager.alert('下拉选择没有设置url')
	}
}

// 初始化下拉选择区域 无数据权限
Faith.initSelectArea = function(id, options) {
	var custom = {
		url: Faith.projectName + "/system/area/list/areaidson/0",
		method: 'get',
		required: false,
		isLeafOnly: true,
		multiple: false,
		checkbox: false,
		cascadeCheck: false,
		isOther: false,
		lines: true,
		loadFilter: function(rows) {
			var isOther = $(this).tree('options').isOther;
			var nodes = [];
			$.each(rows, function(i, row) {
				var d = {
					id: row.id,
					text: row.name,
					areaid: row.obj.areaID,
					fullName: row.obj.fullName
				};
				if(row.obj.areaType != 6) {
					d.state = 'closed';
				}
				nodes.push(d);

				if(isOther && row.id.length == 6) {
					d = {
						id: -1,
						text: "外地",
						areaid: "0",
						fullname: ""
					};
					nodes.push(d);
				}
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

			var cb = $(this).tree('options').callBack;
			if(cb) {
				cb(node);
			}
		},
		panelHeight: 'auto',
		onBeforeExpand: function(node, param) {
			$(this).tree('options').url = Faith.projectName + '/system/area/list/areaidson/' + node.areaid
		},
		width: '100%',
		height: 34
	};
	var op = $.extend({}, custom, options || {});
	$('#' + id).combotree(op);
}
// 初始化下拉选择区域 有数据权限
Faith.initSelectAreaPermissions = function(id, options) {
	var custom = {
		url: Faith.projectName + "/system/area/tree/son",
		method: 'get',
		required: false,
		isLeafOnly: true,
		multiple: false,
		checkbox: false,
		cascadeCheck: false,
		isOther: false,
		lines: true,
		loadFilter: function(rows) {
			var isOther = $(this).tree('options').isOther;
			var nodes = [];
			$.each(rows, function(i, row) {
				var d = {
					id: row.id,
					text: row.name,
					areaid: row.obj.areaID,
					fullName: row.obj.fullName
				};
				if(row.obj.areaType != 6) {
					d.state = 'closed';
				}
				nodes.push(d);

				if(isOther && row.id.length == 6) {
					d = {
						id: -1,
						text: "外地",
						areaid: "0",
						fullname: ""
					};
					nodes.push(d);
				}
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

			var cb = $(this).tree('options').callBack;
			if(cb) {
				cb(node);
			}
		},
		panelHeight: 'auto',
		onBeforeExpand: function(node, param) {
			$(this).tree('options').url = Faith.projectName + '/system/area/list/areaidson/' + node.areaid
		},
		width: '100%',
		height: 34
	};
	var op = $.extend({}, custom, options || {});
	$('#' + id).combotree(op);
}

// 初始化下拉选择区域，根据区域类别参数显示乡镇、社区。网格各级
Faith.initSelectAreaByareaType = function(id, options, areaType) {
	if(areaType == null || areaType == '') {
		areaType = 6
	}
	var custom = {
		url: Faith.projectName + "/system/area/list/areaidson/0",
		method: 'get',
		required: true,
		isLeafOnly: true,
		multiple: false,
		checkbox: false,
		cascadeCheck: false,
		lines: true,
		loadFilter: function(rows) {
			var nodes = [];
			$.each(rows, function(i, row) {
				var d = {
					id: row.id,
					text: row.name,
					areaid: row.obj.areaID
				};
				if(row.obj.areaType != areaType) {
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
			$(this).tree('options').url = Faith.projectName + '/system/area/list/areaidson/' + node.areaid
		},
		width: '100%',
		height: 34
	};
	var op = $.extend({}, custom, options || {});
	$('#' + id).combotree(op);
}
// 初始化下拉选择部件类型
Faith.initSelectTypecode = function(id, options) {
	var custom = {
		url: Faith.projectName + "/base/urbanpart/bdUrbanpartstype/list?parentcode=0",
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
			$(this).tree('options').url = Faith.projectName + '/base/urbanpart/bdUrbanpartstype/list?parentcode=' + node.id
		},
		width: '100%',
		height: 34
	};
	var op = $.extend({}, custom, options || {});
	$('#' + id).combotree(op);
}
// 初始化下拉选择组织机构
Faith.initSelectDept = function(id, options) {
    	var pid = options.pid || "0";
	var custom = {
		url: Faith.projectName + "/sys/dept/tree?pid="+pid,
		method: 'get',
		required: true,
		isLeafOnly: true,
		multiple: false,
		checkbox: false,
		cascadeCheck: false,
		lines: true,
		loadFilter: function(rows) {
			var nodes = [];
			$.each(rows, function(i, row) {
				var d = {
					id: row.deptCode,
					text: row.deptName,
					state: 'closed'
				};
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
			$(this).tree('options').url = Faith.projectName + '/sys/dept/tree?pid=' + node.id
		},
		width: '100%',
		height: 34
	};
	var op = $.extend({}, custom, options || {});
	$('#' + id).combotree(op);
}

// 初始化下拉选择组织机构(按权限)
Faith.initSelectDeptPermission = function(id, options) {
	var custom = {
		url: Faith.projectName + "/sys/dept/treePemission",
		method: 'get',
		required: true,
		isLeafOnly: true,
		multiple: false,
		checkbox: false,
		cascadeCheck: false,
		lines: true,
		loadFilter: function(rows) {
			var nodes = [];
			$.each(rows, function(i, row) {
				var d = {
					id: row.deptCode,
					text: row.deptName,
					state: 'closed'
				};
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
			$(this).tree('options').url = Faith.projectName + '/sys/dept/tree?pid=' + node.id
		},
		width: '100%',
		height: 34
	};
	var op = $.extend({}, custom, options || {});
	$('#' + id).combotree(op);
}

//选择职能部门
Faith.initSelectDeptFunctional = function(id, options) {
	var custom = {
		url: Faith.projectName + "/sys/dept/tree?pid=8",
		method: 'get',
		required: true,
		isLeafOnly: true,
		multiple: false,
		checkbox: false,
		cascadeCheck: false,
		lines: true,
		loadFilter: function(rows) {
			var nodes = [];
			$.each(rows, function(i, row) {
				var d = {
					id: row.deptCode,
					text: row.deptName,
					state: 'closed'
				};
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
			$(this).tree('options').url = Faith.projectName + '/sys/dept/tree?pid=' + node.id
		},
		width: '100%',
		height: 34
	};
	var op = $.extend({}, custom, options || {});
	$('#' + id).combotree(op);
}

// 初始化下拉选择组织机构单选
Faith.initSelectDeptSingle = function(id, options) {
	var custom = {
		url: Faith.projectName + "/sys/dept/tree?pid=0",
		method: 'get',
		required: true,
		isLeafOnly: true,
		multiple: false,
		checkbox: true,
		cascadeCheck: false,
		lines: true,
		loadFilter: function(rows) {
			var nodes = [];
			$.each(rows, function(i, row) {
				var d = {
					id: row.deptCode,
					text: row.deptName,
					state: 'closed'
				};
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

			var cknodes = $(this).tree("getChecked");
			for(var i = 0; i < cknodes.length; i++) {
				if(cknodes[i].id != node.id) {
					$(this).tree("uncheck", cknodes[i].target);
				}
			}
			if(node.checked) {
				$(this).tree('uncheck', node.target);

			} else {
				$(this).tree('check', node.target);

			}
		},
		panelHeight: 'auto',
		onLoadSuccess: function(node, data) {
			// 取消checkbox的默认行为
			$(this).find('span.tree-checkbox').unbind().click(function() {
				return false;
			})
		},
		onBeforeExpand: function(node, param) {
			$(this).tree('options').url = Faith.projectName + '/sys/dept/tree?pid=' + node.id;

		},
		width: '100%',
		height: 34
	};
	var op = $.extend({}, custom, options || {});
	$('#' + id).combotree(op);
}

// 初始化下拉选择组织机构单选
Faith.initSelectDeptSingleSon = function(id, options) {
	var custom = {
		url: Faith.projectName + "/sys/dept/tree?pid=112",
		method: 'get',
		required: false,
		isLeafOnly: true,
		multiple: false,
		checkbox: false,
		cascadeCheck: false,
		lines: true,
		loadFilter: function(rows) {
			var nodes = [];
			$.each(rows, function(i, row) {
				var d = {
					id: row.deptCode,
					text: row.deptName
					// state : 'closed'
				};
				if(row.deptCode < 490) {
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

			var cknodes = $(this).tree("getChecked");
			for(var i = 0; i < cknodes.length; i++) {
				if(cknodes[i].id != node.id) {
					$(this).tree("uncheck", cknodes[i].target);
				}
			}
			if(node.checked) {
				$(this).tree('uncheck', node.target);

			} else {
				$(this).tree('check', node.target);

			}
		},
		panelHeight: 'auto',
		onLoadSuccess: function(node, data) {
			// 取消checkbox的默认行为
			$(this).find('span.tree-checkbox').unbind().click(function() {
				return false;
			})
		},
		onBeforeExpand: function(node, param) {
			$(this).tree('options').url = Faith.projectName + '/sys/dept/tree?pid=' + node.id;

		},
		width: '100%',
		height: 34
	};
	var op = $.extend({}, custom, options || {});
	$('#' + id).combotree(op);
}
// 根据字典分组code获取字典数组
Faith.getDictionaryItem = function(group) {
	var rs = [];
	for(var i = 0; i < dictionaryObj.length; i++) {
		if(dictionaryObj[i].code == group) {
			rs = dictionaryObj[i].dictionarys;
			break;
		}
	}
	return rs;
}

// options 必要参数
// wrapid:容器ID 默认uploader
// valuefield:隐藏域id,用来做表单提交的
// multi_selection:是否可以选取多个
// limitFilesCount:限制文件上传个数
// maxsize:文件大小
// filetypes:jpg,png
Faith.initUpload = function(options) {
	var wrapid = options.wrapid || "uploader";
	var multi_selection = options.multi_selection || true;
	var limitFilesCount = options.limitFilesCount || false;
	var maxsize = options.maxsize || "4mb";

	$('#' + wrapid)
		.append(
			'	<div class="uploader-message text-center"> <div class="content"></div> <button type="button" class="close">×</button> </div> <div class="uploader-files file-list file-list-grid"></div> <div> <hr class="divider"> <div class="uploader-status pull-right text-muted"></div> <button type="button" class="btn btn-link uploader-btn-browse"> <i class="icon icon-plus"></i> 选择文件 </button> </div>');

	var $valfield = $('<input type="hidden" id="' + options.valuefield + '" name="' + options.valuefield + '" />');
	$('#' + wrapid).append($valfield);

	$valfield.change(function() {
		var uploader = $('#' + wrapid).data('zui.uploader');
		var files = uploader.getFiles();
		if(files.length <= 0) {
			var dids = $valfield.val();
			var dids_arr = dids.split(',');
			$.each(dids_arr, function(i, did) {
				if(did && did != "") {
					$.get(Faith.projectName + '/document/index/' + did, {}, function(rs) {
						if(rs.code == 1) {
							var f = {
								id: rs.data.did,
								name: rs.data.actual + rs.data.suffix,
								type: '',
								ext: rs.data.suffix,
								previewImage: Faith.projectName + '/document/show/' + rs.data.did,
								size: rs.data.size,
								origSize: rs.data.size,
								loaded: rs.data.size,
								percent: 100,
								status: 5,
								lastModifiedDate: rs.data.upTime,
								static: true,
								remoteData: rs
							};
							if(rs.data.suffix.indexOf('png') > 0 || rs.data.suffix.indexOf('jpg') > 0 || rs.data.suffix.indexOf('gif') > 0 || rs.data.suffix.indexOf('bmp') > 0) {
								f.isImage = rs.data.suffix.replace('.', '');
							}
							uploader.showFile(f);
						} else {
							$.messager.alert('提示', '文件对象初始化失败：' + rs.message);
						}
					}, 'json');
				}
			});
		}
	});

	var default_op = {
		// 初始化选项
		url: Faith.projectName + '/document/uploadTemp',
		file_data_name: 'Filedata',
		lang: 'zh_cn',
		chunk_size:0,
		autoUpload: true,
		filters: {
			mime_types: [{
				title: '文件',
				extensions: options.filetypes || 'jpeg,jpg,gif,png,ico,txt,doc,docx,xls,xlsx,pdf,ppt,mp3,mp4'
			}],
			max_file_size: maxsize,
			prevent_duplicates: true
		},
		multi_selection: multi_selection,
		limitFilesCount: limitFilesCount,
		deleteActionOnDone: function(file, doRemoveFile) {
			console.log(JSON.stringify(file));
			var did = file.remoteData.data.did;
			$.get(Faith.projectName + '/document/delete/' + did, {}, function(rs) {
				if(rs.code == 1) {
					// 移除隐藏域中对应的值
					var dids = $valfield.val();
					var dids_arr = dids.split(',');
					var newdids = "";
					$.each(dids_arr, function(i, d) {
						if(d != did) {
							if(newdids != "") {
								newdids += ",";
							}
							newdids += d;
						}
					});
					$valfield.val(newdids);

					// doRemoveFile();
					var uploader = $('#' + wrapid).data('zui.uploader');
					uploader.removeFile(file);
				} else {
					$.messager.alert('操作失败', rs.message);
				}
			}, 'json')
		},
		responseHandler: function(reobj, file) {
			// console.log(JSON.stringify(reobj));
			var rs = JSON.parse(reobj.response);
			if(rs.code == 1) {
				console.log(rs.data.did);
				var dids = $valfield.val();
				if(dids != "") {
					dids += ",";
				}
				dids += rs.data.did;
				$valfield.val(dids);
			} else {
				return rs.message;
			}
		}

	};
	$('#' + wrapid).uploader(default_op);

}

// 无分页列表参数
Faith.gridNoPageOptions = {
	width: "100%", // 宽度
	striped: true, // 把行条纹化（奇偶行背景色不同）
	loadMsg: '正在加载用户的信息.......', // 从远程站点加载数据是，显示的提示消息
	pagination: false, // 数据网格底部显示分页工具栏
	fitColumns: true
}

// 无分页列表加载方法 url/parameter/gridId/columns/method
Faith.initGridNopage = function(options) {
	var op = $.extend({}, Faith.gridNoPageOptions, options);
	$('#' + op.gridId).datagrid(op);
	var data = "";
	$.ajax({
		url: Faith.projectName + op.ajaxurl,
		dataType: 'json',
		data: op.parameter,
		type: op.method,
		async: false,
		success: function(rs) {
			data = rs.data;
			if(rs.code == 1) {
				$('#' + op.gridId).datagrid("loadData", data);
			} else {
				// $.messager.alert("提示",rs.message);
			}
		}
	});
}

// 弹出窗口
Faith.openForm = function(options) {
	var op = $.extend({}, {
		width: 700,
		height: 500,
		closed: false,
		cache: false,
		modal: true,
		formpageId: "dialog_wrap",
		onClose: function() {
			$(this).dialog('destroy');
		}
	}, options);
	var dialog = $('<iframe src="' + op.formpage + '" id="' + op.formpageId + '" style="height:' + (op.height - 50) + 'px;margin-top:2px;width:100%;border:0;" ></iframe>');
	$('body').append(dialog);
	dialog.dialog(op);
}

// 弹出窗口
Faith.openDialog = function(options) {
	var op = $.extend({}, {
		width: 700,
		height: 500,
		closed: false,
		cache: false,
		modal: true,
		formpageId: "dialog_wrap",
		onClose: function() {
			$(this).dialog('destroy');
		}
	}, options);
	var dialog = $('<div id="' + op.formpageId + '">' + options.content + '</div>');
	$('body').append(dialog);
	dialog.dialog(op);
}

// 初始化input点击选择地图坐标 （天地图）
Faith.initSelectMapCenter = function(id) {
	$('#' + id).attr('readonly', 'readonly');
	$('#' + id).on('click', function() {
		var oldzb = $('#' + id).val();
		var options = {
			id: 'SelectMapCenterWrap',
			title: '点击地图标注位置',
			formpage: Faith.projectName + '/webpage/grid/map/tsetcenter.html?oldzb=' + oldzb,
			buttons: [{
				text: '确定',
				handler: function() {
					var zb = document.getElementById('SelectMapCenterWrap').contentWindow.returnPoint();
					$('#' + id).val(zb);
					$('#SelectMapCenterWrap').dialog('destroy');
				}
			}]
		};
		Faith.openForm(options);
	});

}

Faith.bindCheckBox = function(selectid, group_code) {
	var str = name || "";
	$('#' + selectid).html('');
	var list = dictionarySelectFild(group_code);
	$.each(list, function(i, item) {
		$('#' + selectid).append(
			'<span style="padding:3px 5px;"><label style="font-weight:normal;" for="' + selectid + '_' + item.code + '"><input id="' + selectid + '_' + item.code + '" name="' +
			selectid + '" value="' + item.code + '" type="checkbox"/>' + item.value + '</label></span>');
	});
}

// 初始化radiolist 关联数据字典
Faith.initRadioList = function(id, groupcode, required) {
	var $div = $('#' + id);
	$div.removeAttr('id');
	var $hidden = $('<input type="hidden" id="' + id + '" >');
	$div.append($hidden);
	var required = required || false;
	$hidden.validatebox({
		required: required
	});
	var arr = Faith.getDictionaryItem(groupcode);
	$.each(arr, function(i, item) {
		var $lb = $('<label class="radio-inline"></label>');
		var $radio = $('<input type="radio"  name="' + id + '" value="' + item.code + '">');
		$div.append($lb);
		$lb.append($radio);
		$lb.append(item.value);
		$radio.on('click', function() {
			$hidden.val($radio.val());
		});
	});
}

// 初始化radiolist 关联数据字典
Faith.initCheckList = function(id, groupcode, required) {
	var $div = $('#' + id);
	$div.removeAttr('id');
	var $hidden = $('<input type="hidden" id="' + id + '" >');
	$div.append($hidden);
	var required = required || false;
	$hidden.validatebox({
		required: required
	});
	var arr = Faith.getDictionaryItem(groupcode);
	$.each(arr, function(i, item) {
		var $lb = $('<label class="checkbox-inline"></label>');
		var $check = $('<input type="checkbox"  name="' + id + '" value="' + item.code + '">');
		$div.append($lb);
		$lb.append($check);
		$lb.append(item.value);
		$check.on('change', function() {
			var val = "";
			$('input:checkbox[name="' + id + '"]:checked').each(function(j, c) {
				if(val != "") {
					val += ",";
				}
				val += $(c).val();
			});
			$hidden.val(val);
		});
	});
}

/* 地图相关功能 */
Faith.map = {};
Faith.initMap = function(id) {
	Faith.map = new T.Map(id);
	var point = new T.LngLat(Faith.centerPoint.x, Faith.centerPoint.y);
	Faith.map.centerAndZoom(point, 16);

	// 创建对象
	var ctrl = new T.Control.MapType([{
		title: '卫星混合',
		icon: 'http://api.tianditu.gov.cn/v4.0/image/map/maptype/satellitepoi.png',
		layer: TMAP_HYBRID_MAP
	}, {
		title: '地图',
		icon: 'http://api.tianditu.gov.cn/v4.0/image/map/maptype/vector.png',
		layer: TMAP_NORMAL_MAP
	}]);
	// 添加控件
	Faith.map.addControl(ctrl);
}

Faith.addMarker = function(zb) {
		var point = new T.LngLat(zb.split(',')[0], zb.split(',')[1]);
		var marker1 = new T.Marker(point); // 创建标注
		Faith.map.addOverLay(marker1);
		Faith.map.centerAndZoom(point, 18);
	}

	/*
	 * ! smallPop 0.1.2 | https://github.com/silvio-r/spop Copyright (c) 2015
	 * SÃ­lvio Rosa @silvior_ MIT license
	 */
	! function() {
		"use strict";

		function t(t, o) {
			return "string" == typeof t ? (o || document).getElementById(t) : t || null
		}

		function o(t, o) {
			t.classList ? t.classList.remove(o) : t.className = t.className.replace(new RegExp("(^|\\b)" + o.split(" ").join("|") + "(\\b|$)", "gi"), " ")
		}

		function e(t, o) {
			for(var e in o) o.hasOwnProperty(e) && (t[e] = o[e]);
			return t
		}
		var s, i, p, n, r, c, l, h, a = 390,
			u = function(o, p) {
				if(this.defaults = {
						template: null,
						style: "info",
						autoclose: !1,
						position: "top-right",
						icon: !0,
						group: !1,
						onOpen: !1,
						onClose: !1
					}, i = e(this.defaults, spop.defaults), "string" == typeof o || "string" == typeof p) s = {
					template: o,
					style: p || i.style
				};
				else {
					if("object" != typeof o) return console.error("Invalid arguments."), !1;
					s = o
				}
				this.opt = e(i, s), t("spop--" + this.opt.group) && this.remove(t("spop--" + this.opt.group)), this.open()
			};
		u.prototype.create = function(o) {
			p = t(this.getPosition("spop--", this.opt.position)), n = this.opt.icon ? '<i class="spop-icon ' + this.getStyle("spop-icon--", this.opt.style) + '"></i>' : "", r = '<div class="spop-close" data-spop="close" aria-label="Close">&times;</div>' + n + '<div class="spop-body">' + o + "</div>", p || (this.popContainer = document.createElement("div"), this.popContainer.setAttribute("class", "spop-container " + this.getPosition("spop--", this.opt.position)), this.popContainer.setAttribute("id", this.getPosition("spop--", this.opt.position)), document.body.appendChild(this.popContainer), p = t(this.getPosition("spop--", this.opt.position))), this.pop = document.createElement("div"), this.pop.setAttribute("class", "spop spop--out spop--in " + this.getStyle("spop--", this.opt.style)), this.opt.group && "string" == typeof this.opt.group && this.pop.setAttribute("id", "spop--" + this.opt.group), this.pop.setAttribute("role", "alert"), this.pop.innerHTML = r, p.appendChild(this.pop)
		}, u.prototype.getStyle = function(t, o) {
			return c = {
				success: "success",
				error: "error",
				warning: "warning"
			}, t + (c[o] || "info")
		}, u.prototype.getPosition = function(t, o) {
			return l = {
				"top-left": "top-left",
				"top-center": "top-center",
				"top-right": "top-right",
				"bottom-left": "bottom-left",
				"bottom-center": "bottom-center",
				"bottom-right": "bottom-right"
			}, t + (l[o] || "top-right")
		}, u.prototype.open = function() {
			this.create(this.opt.template), this.opt.onOpen && this.opt.onOpen(), this.close()
		}, u.prototype.close = function() {
			this.opt.autoclose && "number" == typeof this.opt.autoclose && (this.autocloseTimer = setTimeout(this.remove.bind(this, this.pop), this.opt.autoclose)), this.pop.addEventListener("click", this.addListeners.bind(this), !1)
		}, u.prototype.addListeners = function(t) {
			h = t.target.getAttribute("data-spop"), "close" === h && (this.autocloseTimer && clearTimeout(this.autocloseTimer), this.remove(this.pop))
		}, u.prototype.remove = function(t) {
			this.opt.onClose && this.opt.onClose(), o(t, "spop--in"), setTimeout(function() {
				document.body.contains(t) && t.parentNode.removeChild(t)
			}, a)
		}, window.spop = function(t, o) {
			return t && window.addEventListener ? new u(t, o) : !1
		}, spop.defaults = {}
	}();

Faith.alert = function(msg, callback) {
	var options = {
		template: msg,
		style: 'info',
		autoclose: 2000,
		position: 'top-right',
		icon: true,
		onClose: function() {}
	};
	if(callback) {
		options.onClose = function() {
			callback();
		}
	}
	spop(options);
}

Faith.success = function(msg, callback) {
	var options = {
		template: msg,
		style: 'success',
		autoclose: 2000,
		position: 'top-right',
		icon: true,
		onClose: function() {}
	};
	if(callback) {
		options.onClose = function() {
			callback();
		}
	}
	spop(options);
}

Faith.error = function(msg, callback) {
	var options = {
		template: msg,
		style: 'error',
		autoclose: 2000,
		position: 'top-right',
		icon: true,
		onClose: function() {}
	};
	if(callback) {
		options.onClose = function() {
			callback();
		}
	}
	spop(options);
}

Faith.warning = function(msg, callback) {
	var options = {
		template: msg,
		style: 'warning',
		autoclose: 2000,
		position: 'top-right',
		icon: true,
		onClose: function() {}
	};
	if(callback) {
		options.onClose = function() {
			callback();
		}
	}
	spop(options);
}

// 自由刷新列表
Faith.refreshCustomGrid = function(listTitle, formTitle, gridId) {
	$.messager.alert('提示', formTitle + '成功', 'info', function() {
		var cur_tab = top.$("#maintab").tabs('getSelected');
		var index = top.$("#maintab").tabs('getTabIndex', cur_tab);

		// 刷新列表
		if(listTitle && listTitle != "" && top.$("#maintab").tabs('exists', listTitle)) {
			top.$("#maintab").tabs('select', listTitle);
			var prve_tab = top.$("#maintab").tabs('getSelected');
			$('iframe', prve_tab)[0].contentWindow.$('#' + gridId).datagrid('reload');
		}

		// 关闭当前tab
		top.$("#maintab").tabs('close', index);
	});

}

// 验证表单
Faith.validForm = function(formid) {

	var rules = {};
	var messages = {};
	$('[data-options="required:true"]', $("#" + formid)).each(function(i, item) {
		 
		rules[$(item).attr('id')] = {
			required: true
		};
		var label = $(item).parent().find("label:eq(0)");
		if(label){
			var text=label.text().replace('*','');
			messages[$(item).attr('id')] = {
					required: text+'必须填写；' 
				};
		} 
	}); // 
 
    var err_panel=$('#error_panel');
    if(err_panel.length<=0){
    	err_panel=$('<div id="error_panel" style="display:none;"></div>');
    	$('body').append(err_panel);
    }
    else{
    	err_panel.html('');
    }
    	var valid = $("#" + formid).validate({
		rules: rules,
		messages: messages, 
		errorPlacement:function(error,element) {  
	        error.appendTo(err_panel);
	   }
	}); 
	var rs=valid.form();
	//err_panel.hide(); 
	return rs; 
}

//附件导出异步加载
Faith.downLoadFile =function (options) {
    var config = $.extend(true, { method: 'post' }, options);
    console.log(config.data);
    var $iframe = $('<iframe id="down-file-iframe" />');
    var $form = $('<form target="down-file-iframe" method="' + config.method + '" />');
    $form.attr('action', config.url);
    for (var key in config.data) {
    	console.log(key+"="+config.data[key]);
        $form.append('<input type="hidden" name="' + key + '" value="' + config.data[key] + '" />');
    }
    $iframe.append($form);
    $(document.body).append($iframe);
    $form[0].submit();
    $iframe.remove();
}