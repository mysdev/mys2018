<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8" />
<title>单位详情</title>
<link rel="stylesheet" type="text/css" href="../../../resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../../../resources/css/public_style.css" />
<link href="../../../resources/js/plugins/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../../resources/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/dictionary.js"></script>
<script type="text/javascript" src="../../../resources/js/Faith.js"></script>

<script type="text/javascript">
	var pkVal = Faith.getQueryStringByName("pkVal");

	function initData(id) {
		$.get(Faith.projectName + "/base/unit/index/" + id, {}, function(rs) {
			if (rs.code == 1) { 
				Faith.setTableData("detail_${lowerName}", rs.data); 
 				if(rs.data.point&&rs.data.point!=""){
 					Faith.addMarker(rs.data.point);
 				}
			} else {
				$.messager.alert("提示", rs.message);
			}
		}, 'json');
	}

	$(function() {
		initData(pkVal);
	});
</script>
</head>
<body>
<div id="detail_${lowerName}" class="fromstyle">
#foreach( $col in $!{columns} ) 
	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 nopadding">
		<div class="border_tab padding_int">
			<label class="column_t">${col.columnLabel}:</label>
			<div class="column_z column_title" id="${col.filedName}" name="${col.filedName}"></div>
		</div>
	</div>
#end	
 </div>
 </body>
</html>