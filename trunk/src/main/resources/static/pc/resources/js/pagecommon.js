/*version=2.0*/

var dialog;
var delete_options = {};
var editor;

// 加载列表
function initGrid(option) {
	var op = $.extend({}, grid_options, option);
	//
	$('#grid_' +tablename).datagrid(op);
}
 
//添加方法
function add(str1,str2) {
	var add_options = {
		api : projectName+modelPath+'/add',
		title : '添加' + dialogtitle,
		formpage : formpage,
		buttons : [ {
			text : '保存',
			handler : function() {
				submitForm(add_options,str1,str2);
			}
		} ]
	};
	add_options.callback=function(){
		if (dialog) {
			dialog.dialog('destroy');// 销毁
		} 
	 
		$('#grid_' + tablename).datagrid('load');
	}
	if(str1=='file'){
		add_options.uploadfive=function(){
			 UploadFile('uploadifive', 'file', 'add');
		}
	}
	if(str2=='editor'){	
		add_options.wangEditor=function(){
			 //加载富文本编辑器 
		    editor = new window.wangEditor('#content')  
            editor.create(); 
		}
	}
	
	openForm(add_options);
}


// 修改方法 
function edit(str1,str2) {
	var row = $('#grid_' + tablename).datagrid("getSelected");
	if (row) {
		var update_options = {
			api : projectName+modelPath+'/update',
			title : '修改' + dialogtitle,
			formpage : formpage
		};
		var key_val = row[window["tablekey"]];
		update_options[window["tablekey"]] = key_val;
		update_options.initData = function() {
			$.get(projectName+modelPath+'/index/' + key_val, {}, function(rs) {
				setFormData("form_" + tablename, rs.data);
				if(str1=='file'){
					var file='';
					var filelist=rs.data.fileList;
					if(filelist!=null && filelist.length>0){
						for(var i=0;i<filelist.length;i++){
							if(file==''){
								file=filelist[i].did;
							}else{
								file=file+","+filelist[i].did;
							}
						}
						$("#file").val(file);
					}
					UploadFile('uploadifive', 'file', 'update');
				}
				if(str2=='editor'){	
					//加载富文本编辑器 
					 editor= new window.wangEditor('#content')  
		             editor.create(); 
					 editor.txt.html(rs.data.content);
				}
				
			}, 'json');
		};
		update_options.buttons = [ {
			text : '保存',
			handler : function() {
				submitForm(update_options,str1,str2);
			}
		} ];
		update_options.callback=function(){
			if (dialog) {
				dialog.dialog('destroy');// 销毁
			}  
			$('#grid_' + tablename).datagrid('load');
		}
		

		openForm(update_options);
	} else {
		$.messager.alert('错误操作', '请选择一条数据!', 'error');
	}
}

//详情
function detail(){
	// 获取选择行数据
	var row = $('#grid_' + tablename).datagrid("getSelected");
	if(row){
		var detail_options={
			title:dialogtitle+'详情',
			formpage : detailpage
		};
		var key_val = row[window["tablekey"]];
		detail_options[window["tablekey"]] = key_val;
		detail_options.initData=function(){
			$.get(projectName+modelPath+'/index/' + key_val, {}, function(rs) {
				setTableData("detail_" + tablename, rs.data);
			}, 'json');
		}
		openForm(detail_options);
	}else {
		$.messager.alert('错误操作', '请选择一条数据!', 'error');
	}
}

// 删除方法
function deleteRow() {
	var row = $('#grid_' + tablename).datagrid("getSelected");
	if (row) {
		var id = row[tablekey];
		$.messager.confirm('警告', '您确定要删除此条数据吗?', function(r) {
			if (r) {
				// 加载数据
				$.ajax({
					type : "get",
					url : projectName+modelPath+'/delete/' + id,
					data : {},
					dataType : 'json',
					success : function(rs) {
						if (rs.code == "1") {
							$.messager.alert('操作成功', '删除成功');
							$('#grid_' + tablename).datagrid('load');
						}else{
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
 

// 打开表单窗口
function openForm(options) {
	var op = $.extend({}, {
		width : 800,
		height : 500,
		closed : false,
		cache : false,
		modal : true,
		onClose : function() {
            $(this).dialog('destroy');
        }
	}, options);
	dialog = $('<div></div>');
	$('body').append(dialog);
	dialog.load(options.formpage, function(content) {
		op.content = content;
		dialog.dialog(op);
		if (options.initData) {
			var c = options.initData;
			c();
		}
		
		if (options.uploadfive) {
			var d = options.uploadfive;
			d();
		}
		
		if (options.wangEditor) {
			var e = options.wangEditor;
			e();
		}
	});
}
 

// 提交表單方法 ;
function submitForm(options,str1,str2) {
	var form = $("#form_" + tablename);
	var validate = form.form('validate');
	if (!validate) {
		$.messager.alert("确认", '请正确填写表单！', "", function() {
			form.find(".validatebox-invalid:first").focus();
		});
		return false
	}
	
	
	
	var fromdata = getFormData("form_" + tablename);
	
	
	if(str2=='editor'){
		var content=editor.txt.html();
		var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		if (userAgent.indexOf("Chrome") > -1){
			if(content=="" | content.length ==11 | content.length <=7)
			{
				$.messager.alert("正文内容不能为空", "正文内容不能为空");	 
				return;
			}
		 }
		 if (userAgent.indexOf("Firefox") > -1){
			 if(content=="" | content.length <=11)
				{
				 $.messager.alert("正文内容不能为空", "正文内容不能为空");		 
					return;
				}
				
		 }
		 fromdata.content=content;
	}
	 
	if (options[window["tablekey"]] && options[window["tablekey"]] != "") {
		fromdata[window["tablekey"]] = options[window["tablekey"]];
	}
	$.ajax({
		type : "post",
		url : options.api,
		data : fromdata,
		dataType : 'json',
		success : function(rs) {
			if (rs.code == '1') {
				$.messager.alert('操作成功', '保存成功');
				if(options.callback)
				{
					var cb=options.callback;
					cb(rs.data);
				} 
			}else {
				$.messager.alert('操作失败', rs.message);
			}
		}
	});

}

 
// 搜索方法
function doSearch(searchId) {
	var searchData = getFormDataBySeach(searchId);
	$('#grid_' + tablename).datagrid('load', searchData);
}


//添加页面跳转
function addGoPage(url){
	TopGoPage(url);
}
//页面跳转查看询详
function detailGoPage(id,url){
	// 获取选择行数据
	var row = $('#grid_' + tablename).datagrid("getSelected");
	if(row){
		var detail_options={};
		var key_val = row[window["tablekey"]];
		detail_options[window["tablekey"]] = key_val;
		TopGoPagedetail(url,"myiframe",id);
	}else {
		$.messager.alert('错误操作', '请选择一条数据!', 'error');
	}
}
//修改跳转页面
function editGoPage(url,id){
	TopGoPagedetail(url,"myiframe",id)
}


