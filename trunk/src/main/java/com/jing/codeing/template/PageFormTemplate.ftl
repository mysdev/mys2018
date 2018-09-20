<form id="form_${lowerName}" class="fromstyle">
#foreach( $col in $!{columns} ) 
#if( ${col.isForm} == 1 )
#if( $!col.formType == 0 )
 	<input type="hidden" id="${col.columnName}" name="${col.columnName}" >
#end
#if( $!col.formType == 1 )
	<div class="form-group col-sm-6">
  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
  	 	<input type="text" class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" #if( $col.formValidate )data-options="${col.formValidate}"#end id="${col.columnName}" name="${col.columnName}"  placeholder="请输入${col.columnLabel}">
  	</div>
#end
#if( $!col.formType == 2 )
	<div class="form-group col-sm-6">
  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
  	 	<input type="radio" class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" name="${col.columnName}">
  	</div>
#end
#if( $!col.formType == 3 )
	<div class="form-group col-sm-6">
  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
  	 	<input type="checkbox" class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" name="${col.columnName}">
  	</div>
#end
#if( $!col.formType == 4 )
	<div class="form-group col-sm-6">
  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
  	 	<select class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" id="${col.columnName}" name="${col.columnName}"  placeholder="请选择${col.columnLabel}" #if( $col.formValidate )data-options="${col.formValidate}"#end ></select>
  	</div>
#end
#if( $!col.formType == 5 )
	<div class="form-group col-sm-6">
  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
  	 	<input type="" class="form-control from_wrap_input" id="${col.columnName}" name="${col.columnName}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
  	</div>
#end
#if( $!col.formType == 6 )
	<div class="form-group col-sm-12">
  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
  		<textArea class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" id="${col.columnName}" name="${col.columnName}"  placeholder="请选择${col.columnLabel}" #if( $col.formValidate )data-options="${col.formValidate}"#end></textArea>
  	</div>
#end
#if( $!col.formType == 7 )
	<div class="form-group col-sm-6">
  	 	<label for="tableName">${col.columnLabel}#if( $!col.nullable == 'N' )<span style="color:red">*</span>#end</label>
  	 	<input type="number" class="$!{col.formClass}#if( $col.formValidate ) easyui-validatebox#end" name="${col.columnName}">
  	</div>
#end
#end
#end  	
</form>