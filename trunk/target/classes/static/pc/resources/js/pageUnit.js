var columns=[];

//加载搜索条件
	 function getSearch(){
		$.ajax({
			type:"post",
			url:"/orders/queryByodersuser.action?id=3",
			data:{},
			dataType:'json',
			success:function(rs){
				var str='<form class="form-horizontal" style="float:right;width:100%">';
				$.each(rs.rows,function(i,item){
					str+='<input id="itemid" class="search_input" placeholder="请输入'+item.userName+'">';
					str+='<input id="itemid" class="search_input" placeholder="请输入'+item.userName+'">';
					str+='<input id="itemid" class="search_input" placeholder="请输入'+item.userName+'">';
				});	
				str+='<a href="#" class="searchbox-but" plain="true" onclick="doSearch()">搜索</a>';
				str+='</form>';
				$("#search_wrap").prepend(str);
			}
		}) 
	 }


//动态获限列名
function getColumns(){
	$.ajax({
		type:"post",
		url:columnsUrl,
		data:{},
		dataType:'json',
		async:false,
		success:function(rs){
			   column=[];
			$.each(rs.rows,function(i,item){
				var obj={};
				obj.field="id",
				obj.title="标题",
				obj.align="center",
				obj.editor="text";
				column.push(obj);
			});	
			columns.push(column);
		}
	}) 
}

  /*		 var columns =[[
					{
					field: 'id', 
					title: '标题1',
					align: 'center', 
					editor: 'text' 
					},
					{field: 'number',
					title: '标题2', 
					align: 'center', 
					editor: 'text' 
					},
					{field: 'createtime', 
					title: '标题3', 
					align: 'center', 
					editor: 'text' 
					},
  		                ]];*/

//加载列表
 function getListData(option){
	 var defaults = {
			 "sortName":'updatedDate',
		         "sortOrder":'desc',
		         "pageSize":10,
		         "pageNumber":1
	        };
	 $.extend({},defaults,option);
	 $('#'+option.tableId).datagrid({   
	    url:option.url,
	    dataType: 'json',  
	    method:'post',
	    rownumbers:false,
        width: "100%", //宽度  
        sortName:option.sortName,
        /*sortOrder:option.sortOrder,*/
        pageSize:option.pageSize,
        pageNumber:option.pageNumber,
        striped: true, //把行条纹化（奇偶行背景色不同）  
        //idField: 'quesID', //标识字段  
        loadMsg: '正在加载用户的信息.......', //从远程站点加载数据是，显示的提示消息  
        pagination: true, //数据网格底部显示分页工具栏  
        //singleSelect: false, //只允许选中一行  
        pageList: [10, 20, 30, 40, 50], //设置每页记录条数的列表  
        pageSize: 1, //初始化页面尺寸（默认分页大小）  
        pageNumber: 1, //初始化页面（默认显示第一页）  
        beforePageText: '第', //页数文本框前显示的汉字   
        afterPageText: '页 共 {pages} 页',  
        displayMsg: '第{from}到{to}条，共{total}条',  
        columns: columns,
        onLoadSuccess: function (data) {
           //表格加载成功后执行的代码，如果不需要可以删除
        },
        onDblClickRow:function(rowIndex,rowData){
        	getDetail(rowData.id);
        }	
	}); 
 }
 
 //添加操作按钮
/* function addBut(){
	 str='<div style="background:#eaf2ff;overflow:hidden;margin-top:5px">';
	 str+='<div style="padding:5px;vertical-align: middle;">';
	 str+='<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:\'icon-add\',plain:true" onclick="addDialog()">添加</a>';
	 str+='<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:\'icon-edit\',plain:true" onclick="editDialog()">修改</a>';
	 str+='<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:\'icon-clear\',plain:true" onclick="deleteDialog()">删除</a>';
	 str+='</div>';
	 str+='</div>';
	 $("#tb").append(str);
 }*/
 
//添加方法 
 function addDialog(){
	//加载数据 
	 $.ajax({
			type:"post",
			url:addurl,
			data:{},
			dataType:'json',
			/* contentType: "application/x-www-form-urlencoded; charset=utf-8",  */
			success:function(rs){
				var str='<form class="form-horizontal"><div class="dialog_from_content">';
				$.each(rs.rows,function(i,item){
					str+='<div class="form-group col-sm-6 padding_in">';
					str+='<label for="inputEmail3" class="col-sm-4 control-label">姓名:</label>';
					str+='<div class="col-sm-8">';
					str+='<input type="email" class="form-control" id="inputEmail3" placeholder="Email">';
					str+='</div>';
					str+='</div>';
				});	
				str+='</div></form>';
				getDialog(str,"添加数据");
			}
		})	
 }
 
//修改方法 
 function editDialog(){
	 var row=$('#dg').datagrid("getSelected");
 if(row){
	var id=row.id;
	 //加载数据 
	 $.ajax({
			type:"post",
			url:editurl+id,
			data:{},
			dataType:'json',
			success:function(rs){
				var str='<form class="form-horizontal"><div class="dialog_from_content">';
				$.each(rs.rows,function(i,item){
					str+='<div class="form-group col-sm-6 padding_in">';
					str+='<label for="inputEmail3" class="col-sm-4 control-label">姓名:</label>';
					str+='<div class="col-sm-8">';
					str+='<input type="email" class="form-control" id="inputEmail3" placeholder="Email">';
					str+='</div>';
					str+='</div>';
				});	
				str+='</div></form>';
				getDialog(str,"修改数据");
			}
		}) 
 }else{
	$.messager.alert('错误操作','请选择一条数据!','error');
	 }
 }
 
//删作方法
 function deleteDialog(){
	 var row=$('#dg').datagrid("getSelected");
	 if(row){
		var id=row.id;
		 //加载数据 
		 $.ajax({
				type:"post",
				url:deleteurl+id,
				data:{},
				dataType:'json',
				success:function(rs){
					if(rs.code=="1"){
						$.messager.alert('操作成功','删除成功');
					}
				}
			}) 
	 }else{
		$.messager.alert('操作错误','请选择一条数据!','error');
	 }
 }
 
 //详情方法
//获取详情
 function getDetail(rowId){
	 var id=rowId;
	//加载数据 
	 $.ajax({
			type:"post",
			url:editurl+id,
			data:{},
			dataType:'json',
			success:function(rs){
				var str='<div class="apdding_out_10">';
				    str+='<table class="table table-bordered">';
				$.each(rs.rows,function(i,item){
					str+='<tr>';
					str+='<td class="active">项目</td>';
					str+='<td>'+item.number+'</td>';
					str+='</tr>';
				});	
				str+='</table>';
				str+='</div>';
				getDialog(str,"数据详情");
			}
		}) 
 }
 
 /* 公用弹出窗口 */	
function getDialog(contentStr,title){
	 $('<div id="dialogWrap"></div>').dialog({
	    title: title,
	    width: 750,
	    height: 500,
	    closed: false,
	    cache: false,
	    content:contentStr,
	    modal: true,
	    buttons:[{
			text:'保存',
			handler:function(){
			}
		},{
			text:'关闭',
			handler:function(){
				$("#dialogWrap").dialog('destroy');//销毁
			}
		}]
	});
}