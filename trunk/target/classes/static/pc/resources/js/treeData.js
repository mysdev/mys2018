function getTreeByEasyui(option){
	var defaults = {
            "treeId":"orgName",
            "hiddenId":"orgId",
            "valueField":"deptCode",
            "textField":"deptName",
            "parentId":"parentId"            
        };
	var op = $.extend({}, defaults, option);
	$('#'+op.treeId).combotree({
		url:projectName+"/partymanage/treeBy?pid=0",
		method:'get',
		required:true,
        loadFilter: function (rows) {  
            return convert(rows);  
        },  
        panelHeight:'auto', 
	    onBeforeSelect:function(node){

	    		$("#"+op.hiddenId).val(node.id)

	    },
        onBeforeExpand:function(node,param){
            $(this).tree('options').url = projectName+'/partymanage/treeBy?pid='+node.id                
        },  
	}); 
	
	function convert(rows) {
	    var nodes = [];  
	    	for (var i = 0; i < rows.length; i++) {  
		        var row = rows[i];  
		        if(row.level==1){
		        	nodes.push({  
		                id: row[op.valueField],  
		                text: row[op.textField],  
		                parentId:row[op.parentId],
		                level:row.level,
		                "state": "closed"
		            }); 
		        }else{
		        	nodes.push({  
		                id: row[op.valueField],  
		                text: row[op.textField],  
		                parentId:row[op.parentId],
		                level:row.level
		            }); 
		        }
		         
		    } 
	    return nodes;  
	} 
}
	