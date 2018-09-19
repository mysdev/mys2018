var tbId="";
var cid="";
var editurl='/df/columns/index/';
var deleteurl='/df/columns/delete/';
var addurl='/df/columns/add';
var isedit=0;

var columns =[[
		{
		field: 'cid', 
		title: 'cid',
		align: 'center', 
		hidden: true,
		editor: 'text' 
		},
		{
		field: 'tid', 
		title: 'tid',
		align: 'center', 
		hidden: true,
		editor: 'text' 
		},
		{field: 'columnName',
		title: '字段名', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'columnLabel', 
		title: '显示名', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'columnComment', 
		title: '字段注释', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'columnType', 
		title: '字段类型', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'scale', 
		title: '规模', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'precision', 
		title: '精度', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'nullable', 
			title: '是否可以为空Y/N', 
			align: 'center', 
			editor: 'text' 
			},
		{field: 'filedType', 
			title: 'Java类型', 
			align: 'center', 
			editor: 'text' 
			},
		{field: 'length', 
		title: '字段长度', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'isSearch', 
		title: '是否查询条件', 
		align: 'center', 
		editor: 'text' ,
		formatter:function(value,row,index){
			if(row.isSearch!=null){
				if(row.isSearch=="1"){
					return "是";
				}else{
					return "否";
				}
			}
		}
		},
		{field: 'isList', 
		title: '是否列表显示', 
		align: 'center', 
		editor: 'text',
		formatter:function(value,row,index){
			if(row.isList!=null){
				if(row.isList=="1"){
					return "是";
				}else{
					return "否";
				}
			}
		}
		},
		{field: 'listSort', 
		title: '列表顺序', 
		align: 'center', 
		editor: 'text'
		},
		{field: 'listWidth', 
		title: '列表宽度', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'isForm', 
		title: '是否表单显示', 
		align: 'center', 
		editor: 'text',
		formatter:function(value,row,index){
			if(row.isForm!=null){
				if(row.isForm=="1"){
					return "是";
				}else{
					return "否";
				}
			}
		}
		},
		{field: 'formType', 
		title: '表单控件类型', 
		align: 'center', 
		editor: 'text',
		formatter:function(value,row,index){
			if(row.formType!=null){
				if(row.formType=="0"){
					return "hidden";
				}if(row.formType=="1"){
					return "text";
				}if(row.formType=="2"){
					return "radio";
				}if(row.formType=="3"){
					return "checkbox";
				}if(row.formType=="4"){
					return "select";
				}if(row.formType=="5"){
					return "date";
				}if(row.formType=="6"){
					return "textarea";
				}if(row.formType=="7"){
					return "number";
				}
			}
		}
		},
		{field: 'groupCode', 
		title: '数据字典', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'formValidate', 
		title: '表单校验', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'formClass', 
		title: '表单Class', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'fromWidth', 
		title: '控件宽度', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'spacing', 
		title: '间隔宽度', 
		align: 'center', 
		editor: 'text' 
		},
		{field: 'isNewLine', 
		title: '是否换行', 
		align: 'center', 
		editor: 'text',
		formatter:function(value,row,index){
			if(row.isNewLine!=null){
				if(row.isNewLine=="1"){
					return "是";
				}else{
					return "否";
				}
			}
		}
		}
		
      ]];

//获取列
   function getColumns(tableName){
	   tbId="dg";
	   $('#'+tbId).datagrid({   
		    dataType: 'json',  
		    rownumbers:false,
	        width: "100%", //宽度  
	        striped: true, //把行条纹化（奇偶行背景色不同）  
	        //idField: 'quesID', //标识字段  
	        loadMsg: '正在加载用户的信息.......', //从远程站点加载数据是，显示的提示消息  
	        pagination: false, //数据网格底部显示分页工具栏  
	        //singleSelect: false, //只允许选中一行  
	        //pageList: [10, 20, 30, 40, 50], //设置每页记录条数的列表  
	        //pageSize: 1, //初始化页面尺寸（默认分页大小）  
	        //pageNumber: 1, //初始化页面（默认显示第一页）  
	        //beforePageText: '第', //页数文本框前显示的汉字   
	        //afterPageText: '页 共 {pages} 页',  
	        //displayMsg: '第{from}到{to}条，共{total}条',  
	        columns: columns,
	        onLoadSuccess: function (data) {
	           //表格加载成功后执行的代码，如果不需要可以删除
	        },
	        onDblClickRow:function(rowIndex,rowData){
	        	getDetail(rowData.id);
	        }	
		});
	   
	 //加载列表数据
		getTableData();
   }
   
   //加载列表数据
   function getTableData(){
	   $.ajax({
			type:"post",
			url:projectName+"/columns/list",
			data:{tid:tid},
			dataType:'json',
			success:function(rs){
				if(rs.data.length==0){
					$.messager.alert('提示','此表暂时未设置列');
					$('#'+tbId).datagrid('loadData', rs.data);
				}else{
					$('#'+tbId).datagrid('loadData', rs.data);
				}	
			}
		});
   }
   
   
 //添加方法 
   function addFromDialog(){
	 isedit=0;
  	 var str='';
  	 str+='<form id="addculum" style="padding:15px">';
  	 str+='<div class="form-group col-sm-6">';
  	 str+='<label for="columnName">字段名<span style="color:red">*</span></label>';
  	 str+='<input type="text" class="form-control easyui-validatebox" data-options="required:true" id="columnName" name="columnName" placeholder="字段名">';
  	 str+='</div>';
  	 str+='<div class="form-group  col-sm-6">';
  	 str+='<label for="columnLabel">显示名<span style="color:red">*</span></label>';
  	 str+='<input type="text" class="form-control easyui-validatebox" data-options="required:true" id="columnLabel" name="columnLabel" placeholder="请输入显示名">';
  	 str+='</div>';
  	 str+='<div class="form-group col-sm-6">';
  	 str+='<label for="columnComment">字段注释</label>';
  	 str+='<input type="text" class="form-control" id="columnComment" name="columnComment" placeholder="请输入字段注释">';
  	 str+='</div>';
  	str+='<div class="form-group col-sm-6">';
 	 str+='<label for="columnType">字段类型</label>';
 	 str+='<input type="text" class="form-control" id="columnType" name="columnType" placeholder="请输入字段类型">';
 	 str+='</div>';
 	str+='<div class="form-group col-sm-6">';
 	 str+='<label for="scale">规模</label>';
 	 str+='<input type="text" class="form-control" id="scale" name="scale" placeholder="请输入规模">';
 	 str+='</div>';
 	str+='<div class="form-group col-sm-6">';
 	 str+='<label for="precision">精度</label>';
 	 str+='<input type="text" class="form-control" id="precision" name="precision" placeholder="请输入精度">';
 	 str+='</div>';
 	str+='<div class="form-group col-sm-6">';
 	 str+='<label for="nullable">是否可以为空Y/N</label>';
 	 str+='<input type="text" class="form-control" id="nullable" name="nullable" placeholder="请输入是否可以为空Y/N">';
 	 str+='</div>';
 	str+='<div class="form-group col-sm-6">';
	 str+='<label for="foreignKey">是否外键</label>';
	 str+='<select  class="form-control" id="foreignKey" name="foreignKey">';
		 str+='<option value="1">是</option>';
		 str+='<option value="0" selected>否</option>';
		 str+='</select>';
	 str+='</div>';
 	str+='<div class="form-group col-sm-6">';
 	 str+='<label for="filedType">Java类型</label>';
 	str+='<input type="text" class="form-control" id="filedType" name="filedType" placeholder="请输入Java类型">';
 	 str+='</div>';
 	str+='<div class="form-group col-sm-6">';
	 str+='<label for="length">字段长度</label>';
	 str+='<input type="number" class="form-control" id="length" name="length" placeholder="请输入length" pattern="^(\-?)\d+$"  title="请输入字段长度">';
	 str+='</div>';
	 str+='<div class="form-group col-sm-6">';
 	 str+='<label for="isSearch">是否查询条件</label>';
 	str+='<select  class="form-control" id="isSearch" name="isSearch">';
	 str+='<option value="1"  selected>显示</option>';
	 str+='<option value="0">不显示</option>';
	 str+='</select>';
 	 str+='</div>';
 	str+='<div class="form-group col-sm-6">';
	 str+='<label for="isList">是否列表显示</label>';
	 str+='<select  class="form-control" id="isList" name="isList">';
		 str+='<option value="1" selected>显示</option>';
		 str+='<option value="0">不显示</option>';
		 str+='</select>';
	 str+='</div>';
	 str+='<div class="form-group col-sm-6">';
 	 str+='<label for="listSort">列表顺序</label>';
 	 str+='<input type="number" class="form-control" id="listSort" name="listSort" placeholder="请输入listSort" pattern="^(\-?)\d+$"  title="请输入数字">';
 	 str+='</div>';
 	str+='<div class="form-group col-sm-6">';
	 str+='<label for="listWidth">列表宽度</label>';
	 str+='<input type="number" class="form-control" id="listWidth" name="listWidth" placeholder="请输入列表宽度" pattern="^(\-?)\d+$"  title="请输入数字">';
	 str+='</div>';
	 str+='<div class="form-group col-sm-6">';
 	 str+='<label for="isForm">是否表单显示<span style="color:red">*</span></label>';
 	 str+='<select  class="form-control"id="isForm" name="isForm">';
	 str+='<option value="1" selected>显示</option>';
	 str+='<option value="0">不显示</option>';
	 str+='</select>';
 	 str+='</div>';
 	str+='<div class="form-group col-sm-6">';
	 str+='<label for="formType">表单控件类型<span style="color:red">*</span></label>';
	 str+='<select  class="form-control" id="formType" name="formType">';
	 str+='<option value="0">hidden</option><option value="1" selected>text</option>';
	 str+='<option value="2">radio</option><option value="3">checkbox</option><option value="4">select</option>';
	 str+='<option value="5">date</option><option value="6">textarea</option>';
	str+='<option value="7">number</option>';
	str+='</select>';
	 str+='</div>';
	 str+='<div class="form-group col-sm-6">';
 	 str+='<label for="groupCode">数据字典</label>';
	 str+='<input type="text" class="form-control" id="groupCode" name="groupCode" placeholder="请输入数据字典">';
 	 str+='</div>';
 	str+='<div class="form-group col-sm-6">';
	 str+='<label for="formClass">表单Class</label>';
	 str+='<input type="text" class="form-control" id="formClass" name="formClass" placeholder="请输入表单Class">';
	 str+='</div>';
	 str+='<div class="form-group col-sm-6">';
 	 str+='<label for="formValidate">表单校验<span style="color:red">*</span></label><br>';
 	 str+='<input type="checkbox" name="formValidate" value="required:true"> 非空';
 	str+='<input type="checkbox" name="formValidate" value="validType:Mobile"> 身份证';
 	/*str+='<select  class="form-control easyui-validatebox" data-options="required:true" id="formValidate" name="formValidate">';
 	str+='<option value="">验证类型</option>';
	 str+='<option value="required:true">非空验证</option>';
	 str+='<option value="validType:'Mobile'">身份证验证</option>';
	 str+='</select>';*/
 	 str+='</div>';
 	str+='<div class="form-group col-sm-6">';
	 str+='<label for="fromWidth">控件宽度</label>';
	 str+='<input type="number" class="form-control" id="fromWidth" name="fromWidth" placeholder="请输入fromWidth" pattern="^(\-?)\d+$"  title="请输入数字">';
	 str+='</div>';
	 str+='<div class="form-group col-sm-6">';
	 str+='<label for="spacing">间隔宽度</label>';
	 str+='<input type="number" class="form-control" id="spacing" name="spacing" placeholder="请输入spacing" pattern="^(\-?)\d+$"  title="请输入数字">';
	 str+='</div>';
	 str+='<div class="form-group col-sm-6">';
	 str+='<label for="isNewLine">是否换行</label>';
	 str+='<select  class="form-control"id="isNewLine" name="isNewLine">';
	 str+='<option value="1" selected>是</option>';
	 str+='<option value="0">否</option>';
	 str+='</select>';
	 str+='</div>';
	 /*str+='<input type="" class="form-control from_wrap_input" id="limitdate" name="limitdate" onfocus="WdatePicker({minDate:\'%y-%M-%d\'})"/>';*/
  	 str+='</form>';
  	 str+='</div>';	
  	getDialog(str,"添加数据");
  	}
   
 //修改方法 
   function editDialog(){
  	 var row=$('#'+tbId).datagrid("getSelected");
   if(row){
  	 cid=row.cid;
  	 //加载数据 
  	 $.ajax({
  			type:"get",
  			url:"/df/columns/index/"+cid,
  			data:{},
  			dataType:'json',
  			success:function(rs){
  				isedit=1;
  				//console.log(JSON.stringify(rs.data))
  				var str='';
  			  	 str+='<form id="addculum" style="padding:15px">';
  			  	 str+='<div class="form-group col-sm-6">';
  			  	 str+='<label for="columnName">字段名<span style="color:red">*</span></label>';
  			  	 str+='<input type="text" class="form-control easyui-validatebox" data-options="required:true" id="columnName" name="columnName" value="'+(rs.data.columnName==null ? "": rs.data.columnName)+'" placeholder="字段名">';
  			  	 str+='</div>';
  			  	 str+='<div class="form-group  col-sm-6">';
  			  	 str+='<label for="columnLabel">显示名<span style="color:red">*</span></label>';
  			  	 str+='<input type="text" class="form-control easyui-validatebox" data-options="required:true"  id="columnLabel" name="columnLabel" value="'+(rs.data.columnLabel==null ? "": rs.data.columnLabel)+'"  placeholder="请输入显示名">';
  			  	 str+='</div>';
  			  	 str+='<div class="form-group col-sm-6">';
  			  	 str+='<label for="columnComment">字段注释<span style="color:red">*</span></label>';
  			  	 str+='<input type="text" class="form-control" id="columnComment" name="columnComment" value="'+(rs.data.columnComment==null ? "": rs.data.columnComment)+'"  placeholder="请输入字段注释">';
  			  	 str+='</div>';
  			  	str+='<div class="form-group col-sm-6">';
  			 	 str+='<label for="columnType">字段类型</label>';
  			 	 str+='<input type="text" class="form-control" id="columnType" name="columnType" value="'+(rs.data.columnType==null ? "": rs.data.columnType)+'"  placeholder="请输入字段类型">';
  			 	 str+='</div>';
  			 	str+='<div class="form-group col-sm-6">';
  			 	 str+='<label for="scale">规模</label>';
  			 	 str+='<input type="text" class="form-control" id="scale" name="scale" value="'+(rs.data.scale==null ? "": rs.data.scale)+'"  placeholder="请输入规模">';
  			 	 str+='</div>';
  			 	str+='<div class="form-group col-sm-6">';
  			 	 str+='<label for="precision">精度</label>';
  			 	 str+='<input type="text" class="form-control" id="precision" name="precision" value="'+(rs.data.precision==null ? "": rs.data.precision)+'"  placeholder="请输入精度">';
  			 	 str+='</div>';
  			 	str+='<div class="form-group col-sm-6">';
  			 	 str+='<label for="nullable">是否可以为空Y/N</label>';
  			 	 str+='<input type="text" class="form-control" id="nullable" name="nullable" value="'+(rs.data.nullable==null ? "": rs.data.nullable)+'"  placeholder="请输入是否可以为空">';
  			 	str+='</div>';
  			 	str+='<div class="form-group col-sm-6">';
 			 	 str+='<label for="foreignKey">是否外键</label>';
 			 	str+='<select  class="form-control" id="foreignKey" name="foreignKey">';
 				 str+='<option value="1" '+(rs.data.foreignKey=="1"?"selected":"")+'>是</option>';
 				 str+='<option value="0" '+(rs.data.foreignKey=="0"?"selected":"")+'>否</option>';
 				 str+='</select>';
 			 	 /*str+='<input type="text" class="form-control" id="foreignKey" name="foreignKey" value="'+(rs.data.foreignKey==null ? "": rs.data.foreignKey)+'"  placeholder="是否外键">';*/
 			 	str+='</div>';
  			 	 str+='<div class="form-group col-sm-6">';
  			 	 str+='<label for="filedType">Java类型</label>';
  			 	 str+='<input type="text" class="form-control" id="filedType" name="filedType" value="'+(rs.data.filedType==null ? "": rs.data.filedType)+'"  placeholder="请输入Java类型">';
  			 	 str+='</div>';
  			 	str+='<div class="form-group col-sm-6">';
  				 str+='<label for="length">字段长度</label>';
  				 str+='<input type="number" class="form-control" id="length" name="length" value="'+(rs.data.length==null ? "": rs.data.length)+'"  placeholder="请输入字段长度"  pattern="^(\-?)\d+$"  title="请输入数字">';
  				 str+='</div>';
  				 str+='<div class="form-group col-sm-6">';
  			 	 str+='<label for="isSearch">是否查询条件</label>';
  			 	str+='<select  class="form-control" id="isSearch" name="isSearch">';
  				 str+='<option value="1" '+(rs.data.isSearch=="1"?"selected":"")+'>显示</option>';
  				 str+='<option value="0" '+(rs.data.isSearch=="0"?"selected":"")+'>不显示</option>';
  				 str+='</select>';
  			 	 str+='</div>';
  			 	str+='<div class="form-group col-sm-6">';
  				 str+='<label for="isList">是否列表显示</label>';
  				str+='<select  class="form-control" id="isList" name="isList">';
  				 str+='<option value="1" '+(rs.data.isList=="1"?"selected":"")+'>显示</option>';
  				 str+='<option value="0" '+(rs.data.isList=="0"?"selected":"")+'>不显示</option>';
  				 str+='</select>';
  				 str+='</div>';
  				 str+='<div class="form-group col-sm-6">';
  			 	 str+='<label for="listSort">列表顺序</label>';
  			 	 str+='<input type="number" class="form-control" id="listSort" name="listSort" value="'+(rs.data.listSort==null ? "": rs.data.listSort)+'"  placeholder="请输入列表顺序" pattern="^(\-?)\d+$"  title="请输入数字">';
  			 	 str+='</div>';
  			 	str+='<div class="form-group col-sm-6">';
  				 str+='<label for="listWidth">列表宽度</label>';
  				 str+='<input type="number" class="form-control" id="listWidth" name="listWidth" value="'+(rs.data.listWidth==null ? "": rs.data.listWidth)+'"  placeholder="请输入列表宽度" pattern="^(\-?)\d+$"  title="请输入数字">';
  				 str+='</div>';
  				 str+='<div class="form-group col-sm-6">';
  			 	 str+='<label for="isForm">是否表单显示<span style="color:red">*</span></label>';
  			 	str+='<select  class="form-control" id="isForm" name="isForm">';
  				 str+='<option value="1" '+(rs.data.isForm=="1"?"selected":"")+'>显示</option>';
  				 str+='<option value="0" '+(rs.data.isForm=="0"?"selected":"")+'>不显示</option>';
  				 str+='</select>';
  			 	 str+='</div>';
  			 	str+='<div class="form-group col-sm-6">';
  				 str+='<label for="formType">表单控件类型<span style="color:red">*</span></label>';
  				str+='<select  class="form-control" id="formType" name="formType">';
  				 str+='<option value="0" '+(rs.data.formType=="0"?"selected":"")+'>hidden</option><option value="1" '+(rs.data.formType=="1"?"selected":"")+'>text</option>';
  				 str+='<option value="2" '+(rs.data.formType=="2"?"selected":"")+'>radio</option><option value="3" '+(rs.data.formType=="3"?"selected":"")+'>checkbox</option><option value="4"'+(rs.data.formType=="4"?"selected":"")+'>select</option>';
  				 str+='<option value="5" '+(rs.data.formType=="5"?"selected":"")+'>date</option><option value="6" '+(rs.data.formType=="6"?"selected":"")+'>textarea</option>';
  				str+='<option value="7" '+(rs.data.formType=="7"?"selected":"")+'>number</option>';
  				str+='</select>';
  				str+='</select>';
  			 	str+='</div>';
  				 str+='<div class="form-group col-sm-6">';
  			 	 str+='<label for="groupCode">数据字典</label>';
  			 	 str+='<input type="text" class="form-control" id="groupCode" name="groupCode" value="'+(rs.data.groupCode==null ? "": rs.data.groupCode)+'"  placeholder="请输入数据字典">';
  			 	 str+='</div>';
  			 	str+='<div class="form-group col-sm-6">';
  				 str+='<label for="formClass">表单Class</label>';
  				 str+='<input type="text" class="form-control" id="formClass" name="formClass" value="'+(rs.data.formClass==null ? "": rs.data.formClass)+'"  placeholder="请输入表单Class">';
  				 str+='</div>';
  				 str+='<div class="form-group col-sm-6">';
  			 	 str+='<label for="formValidate">表单校验<span style="color:red">*</span></label><br>';
  			 	str+='<input type="checkbox" name="formValidate" value="required:true" '+(rs.data.formValidate=="required:true"?"checked":"")+'> 非空';
  			 	str+='<input type="checkbox" name="formValidate" value="validType:Mobile" '+(rs.data.formValidate=="validType:Mobile"?"checked":"")+'> 身份证';
  			 	 str+='</div>';
  			 	str+='<div class="form-group col-sm-6">';
  				 str+='<label for="fromWidth">控件宽度</label>';
  				 str+='<input type="number" class="form-control" id="fromWidth" name="fromWidth" value="'+(rs.data.fromWidth==null ? "": rs.data.fromWidth)+'"  placeholder="请输入fromWidth" pattern="^(\-?)\d+$"  title="请输入控件宽度">';
  				 str+='</div>';
  				str+='<div class="form-group col-sm-6">';
 				 str+='<label for="spacing">间隔宽度</label>';
 				 str+='<input type="number" class="form-control" id="spacing" name="spacing" value="'+(rs.data.spacing==null ? "": rs.data.spacing)+'"  placeholder="请输入spacing" pattern="^(\-?)\d+$"  title="请输入间隔宽度">';
 				 str+='</div>';
 				str+='<div class="form-group col-sm-6">';
 				 str+='<label for="isNewLine">是否换行</label>';
 				str+='<select  class="form-control"id="isNewLine" name="isNewLine">';
 				 str+='<option value="1" '+(rs.data.isNewLine=="1"?"selected":"")+'>是</option>';
 				 str+='<option value="0" '+(rs.data.isNewLine=="0"?"selected":"")+'>否</option>';
 				 str+='</select>';
 				 str+='</div>';
  			  	 str+='</form>';
  			  	 str+='</div>';	
  			  	 getDialog(str,"修改数据");
  			}
  		}) 
   }else{
  	$.messager.alert('错误操作','请选择一条数据!','error');
  	 }
   }
   

   //保存方法
   function tableSave(){
	   var validate = $("#addculum").form('validate')
	   if (!validate) {  
	       $.messager.alert("确认", '请正确填写表单！',"",function(){  
	       $("#addculum").find(".validatebox-invalid:first").focus();  
	          });  
	          return false  
	      }  
   		var fromdata=getFormData("addculum");
   		fromdata.tid=tid;
   		var suburl="";
   		if(isedit==1){
   			fromdata.cid=cid;
   			suburl="/df/columns/update";
   		}else{
   			suburl="/df/columns/add";
   		}
   		$.ajax({
   			type:"post",
   			url:suburl,
   			data:fromdata,
   			dataType:'json',
   			success:function(rs){
   				if(rs.code=='1'){
   					$.messager.alert("成功", '提交成功！')
   					$("#dialogWrap").dialog('destroy');//销毁
   					//加载列表数据
   					getTableData();
   					isedit=0;
   				}
   			}
   		}) 
   	  }
   
   /* 公用弹出窗口 */	
   function getDialog(contentStr,title){
   	 $('<div id="dialogWrap"></div>').dialog({
   	    title: title,
   	    width: 700,
   	    height: 500,
   	    closed: false,
   	    cache: false,
   	    content:contentStr,
   	    modal: true,
   	    buttons:[{
   			text:'保存',
   			handler:tableSave

   		},{
   			text:'关闭',
   			handler:function(){
   				$("#dialogWrap").dialog('destroy');//销毁
   			}
   		}]
   	});
   }
   
 //删除方法
   function deleteDialog(){
  	 var row=$('#dg').datagrid("getSelected");
  	 if(row){
  		var cid=row.cid;
  		$.messager.confirm('警告', '您确定要删除此条数据吗?', function(r){
  			if (r){
  			 //加载数据 
  			 $.ajax({
  					type:"get",
  					url:deleteurl+cid,
  					data:{},
  					dataType:'json',
  					success:function(rs){
  						if(rs.code=="1"){
  							$.messager.alert('操作成功','删除成功');
  							//加载列表数据
  		   					getTableData();
  						}
  					}
  				});
  			}
  		});
  	 }else{
  		$.messager.alert('操作错误','请选择一条数据!','error');
  	 }
   }
 
 
