<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../../resources/css/public_style.css" />
<link rel="stylesheet" type="text/css" href="../../resources/js/easyui/easyui_add.css" /> 
<link href="../../resources/js/plugins/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../resources/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../resources/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../resources/js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../resources/js/Faith.js"></script>
<script>
	var columns = [
#foreach( $col in $!{columns} ) 
			{field:'${col.filedName}', title:'${col.columnLabel}', width:${col.listWidth}, align:'center' #if($!col.isList == 0 ),hidden:true#end }#if($columns.size() > $velocityCount ),
	#else 

#end
#end			
			];
			
	//接收 菜单id
	var resId = Faith.getQueryStringByName("resId");//当前页面id
	
	//配置页面参数
	$.extend(true, Faith, {
		gridOptions : {
			gridId : 'grid_${lowerName}', //表格容器id
			tableKey : "${primaryKey.filedName}",
			resId:resId,
			pageButtonKey:'',
			isToolBar:true,
			url : Faith.projectName + '/${model}/${lowerName}/page', //列表接口
			sortName : '${primaryKey.columnName}',
			sortOrder : 'desc',
			columns : [ columns ],//数据列
			onDblClickRow : function(rowIndex, rowData) {
				Faith.doView();
			}
		},
		addOptions : {
			title : "添加${comment}",
			addUrl : "/pc/webpage/${model}/${lowerName}/${lowerName}_form.html"
		},
		updateOptions : {
			title : "修改${comment}",
			updateUrl : "/pc/webpage/${model}/${lowerName}/${lowerName}_form.html"
		},
		deleteOptions : {
			deleteAction : Faith.projectName + '/${model}/${lowerName}/delete/'
		},
		viewOptions : {
			title:'查看${comment}',
			viewUrl : "/pc/webpage/${model}/${lowerName}/${lowerName}_detail.html"
		}
	});
	$(function() {
		// 加载表格
		Faith.initGrid(Faith.gridOptions);
		//初始化搜
		Faith.doSearch("btn_search", "search");
	});	
			
</script>
</head>
<body>
	<div region="center" title="" href="" style="padding: 5px; border-top: 1px solid #e0e0e0;" class="panel-body layout-body panel-noscroll">
		<div class="easyui-layout layout easyui-fluid">
   			<!-- 搜索容器 -->
			<div id="search_wrap" class="search_wrap" style="border:1px solid #e0e0e0;overflow:hidden;" >
				<form class="form-horizontal" style="width:100%">
				<div class="cl-9 ">
					<!-- 必要搜索条件 -->
#foreach( $col in $!{columns} ) 
#if($!col.isSearch == 1 )
#if($!col.formType == 1 )
					<input id="${col.filedName}" name="${col.filedName}" class="search_input_imp" placeholder="请输入${col.columnLabel}">
#end
#if($!col.formType == 4 )
					<select id="${col.filedName}" name="${col.filedName}" class="search_input_imp  select_sty">
						<option value="-1">请选择${col.columnLabel}</option>
					</select>
#end
#if($!col.formType == 5 )
					<div class="search_input_imp">
						<input type="" class="search_input dateinput" placeholder="请选择${col.columnLabel}开始时间" id="start${col.method}" name="start${col.method}" onfocus="WdatePicker({minDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
						<input type="" class="search_input dateinput" placeholder="请选择${col.columnLabel}结束时间" id="end${col.method}" name="end${col.method}" onfocus="WdatePicker({minDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="margin-left:7%"/>
					</div>
#end
#end
#end
				</div>
				<div class="cl-1" style="margin-top:10px">
					<a href="#" class="searchbox-but" plain="true" onclick="doSearch('search_wrap')">搜索</a>
					<span class="down_up" style="float:right"></span>
				</div>
				</form>
			</div>
		</div>
		<div style="margin-top:5px;">
			<table id="grid_${lowerName}" class="easyui-datagrid" data-options="rownumbers:true,singleSelect:true,pagePosition:'bottom',autoRowHeight:false,pagination:true" style="width:800px" >
			</table>
        </div>  
	</div> 	
</body>
</html>