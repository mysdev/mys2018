function getRoleBy(fileId){
	$.ajax({
		type : "post",
		url : projectName+"/sys/permission/role/alllist",
		data : {},
		dataType : 'json',
		success : function(rs) {
			//console.log(JSON.stringify(rs));
			var str="<option>请选择职务</option>";
			$.each(rs.data,function(i,item){
				str += '<option value="'+item.roleId+'">'+item.roleTitle+'</option>';
			})
			$("#"+fileId).append(str);
		}
	});
	
	
}