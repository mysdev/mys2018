<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="../../../resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../../../resources/css/public_style.css" />
<link rel="stylesheet" type="text/css" href="../../../resources/js/easyui/easyui_add.css" />
<script type="text/javascript" src="../../../resources/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../../resources/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../../resources/js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../../resources/js/easyui/validatebox.js"></script>
<script type="text/javascript" src="../../../resources/js/dictionary.js"></script>
<script type="text/javascript" src="../../../resources/js/Faith.js"></script>
<script>
	var pkVal = Faith.getQueryStringByName("pkVal");//  如果有值 就是修改  没有值就是添加

	var options = {
		formid : "form_${lowerName}",
		tableKey : "${primaryKey.filedName}",
		addAction : Faith.projectName + "/${model}/${lowerName}/add",
		updateAction : Faith.projectName + "/${model}/${lowerName}/update",
		viewAction : Faith.projectName + "/${model}/${lowerName}/index/" + pkVal,
		pkVal : pkVal,
		saveButtonId : 'btn_save',
		cancelButtonId : 'btn_cancel'
	};

	$(function() {
		//提交按钮点击
		Faith.doSave(options);
		//如果是修改  则填充数据
		if (pkVal != null && pkVal != "") {
			$.get(options.viewAction, {}, function(rs) {
				if (rs.code == 1) {
					Faith.setFormData(options.formid, rs.data);
				} else {
					$.messager.alert("提示", rs.message);
				}
			}, 'json');
		}
	});
</script>
</head>
<body>
	<form id="form_${lowerName}" class="fromstyle">
#foreach( $col in $!{columns} ) 
#if( ${col.isForm} == 1 )
#if( $!col.formType == 0 )
 		<input type="hidden" id="${col.filedName}" name="${col.filedName}" >
#end
#if( $!col.formType == 1 )
		<div class="form-group col-sm-6">
	  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
	  	 	<input type="text" class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" #if( $col.formValidate )data-options="${col.formValidate}"#end id="${col.filedName}" name="${col.filedName}"  placeholder="请输入${col.columnLabel}">
	  	</div>
#end
#if( $!col.formType == 2 )
		<div class="form-group col-sm-6">
	  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
	  	 	<input type="radio" class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" id="${col.filedName}" name="${col.filedName}">
	  	</div>
#end
#if( $!col.formType == 3 )
		<div class="form-group col-sm-6">
	  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
	  	 	<input type="checkbox" class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" id="${col.filedName}" name="${col.filedName}">
	  	</div>
#end
#if( $!col.formType == 4 )
		<div class="form-group col-sm-6">
	  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
	  	 	<select class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" id="${col.filedName}" name="${col.filedName}"  placeholder="请选择${col.columnLabel}" #if( $col.formValidate )data-options="${col.formValidate}"#end ></select>
	  	</div>
#end
#if( $!col.formType == 5 )
		<div class="form-group col-sm-6">
	  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
	  	 	<input type="text" class="form-control easyui-datebox"  id="${col.filedName}" name="${col.filedName}"  placeholder="请选择${col.columnLabel}" data-options="height:'34',width:'100%'">
	  	</div>
#end
#if( $!col.formType == 6 )
		<div class="form-group col-sm-12">
	  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
	  		<textArea class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" id="${col.filedName}" name="${col.filedName}"  placeholder="请选择${col.columnLabel}" #if( $col.formValidate )data-options="${col.formValidate}"#end></textArea>
	  	</div>
#end
#if( $!col.formType == 7 )
		<div class="form-group col-sm-6">
	  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
	  	 	<input type="number" class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" name="${col.filedName}" id="${col.filedName}">
	  	</div>
#end
#end
#end  
		<div class="form-group col-sm-12 padding-4">
			<div class="text-center">
				<button type="button" class="btn btn-primary btn_w" id="btn_cancel">取消</button>
				<button type="button" data-loading-text="正在提交" class="btn btn-danger  btn_w" id="btn_save">保存</button>
			</div>
		</div>	
	</form>
</body>