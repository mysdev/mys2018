<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="../../../resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../../../resources/css/public_style.css" />
<link rel="stylesheet" type="text/css" href="../../../resources/js/easyui/easyui_add.css" /> 
<link href="../../../resources/js/plugins/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../../resources/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../../resources/js/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../../resources/js/Faith.js"></script>
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
	<div id="search" class="search wrap_border">
#foreach( $col in $!{columns} )
#if($!col.isSearch == 1 )
		<div class="search-wrap">
			<input type="text" class="easyui-textbox" labelWidth="70" label="${col.columnLabel}" id="${col.filedName}" name="${col.filedName}" />
		</div>
#end	
#end
		<div class="search-btn-wrap">
			<button type="button" data-loading-text="正在搜索" class="btn btn-primary btn-search"  id="btn_search">搜索</button>
		</div>
	</div>
	<div class="grid">
		<table id="grid_${lowerName}" class="easyui-datagrid"></table>
	</div>
</body>
</html>