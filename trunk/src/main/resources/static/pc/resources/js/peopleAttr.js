var special_list_url= {//"260004":"/cm/specialcrowd/drug/page",    //吸毒人员
					   "260012":"/cm/specialcrowd/teeny/page",  //问题青少年
					   //"260023":"/cm/specialcrowd/aids/page",  //爱滋病
					   "260001":"/cm/specialcrowd/ccp/page",   //直管党员
					   "260011":"/cm/specialcrowd/child/page", //留守儿童
					   "260003":"/cm/specialcrowd/emancipation/page",  //刑满释放人员
					   "260010":"/cm/specialcrowd/greybeard/page",    //空巢老人
					   //"260005":"/cm/specialcrowd/mental/page",  //精神病
					   /*"260007":"/cm/specialcrowd/petition/page",  //非访人员*/
					   "260002":"/cm/specialcrowd/redress/page",  //社区矫正
						   };

var special_columns={
	"260001":[{field : 'files',title : '附件',align : 'center',width :100,
				formatter : function(value, row, index) {
					if (row.files && row.files != null) {
						var filesArry = row.files.split(",");
						return "<img class='thumbnails gallery' height='25px' src="+Faith.projectName+"/document/show/" + filesArry[0] + "/>"
					}
				}},
				{field : 'branch',title : '所在党支部',align : 'center',width : 150}, 
				{field : 'pdate',title : '入党日期',align : 'center',width : 200,
					formatter : function(value, row, index) {
			    	var  pdate= Faith.getDateFormat(row.pdate);
			    	return pdate;
			        }},
			    {field : 'ppost',title : '职务',align : 'center', width : 150}, 
			    {field : 'remark',title : '备注',align : 'center',width : 200
			} ],
	"260002":[{field : 'pname',title : '姓名',align : 'center',width:30},
	          {field : 'mareaCode',title : '管理区域',align : 'center',width:50,
				    formatter : function(value, row, index) {
				    	if(row.marea){
				    		 var fullName = row.marea.fullName;
						        return fullName;
				    	}else{
				    		return "未知";
				    	}  
				    }},
			    {field : 'phone',title : '电话',align : 'center',width:30},
			    {field : 'criminalCharge',title : '罪名',align : 'center',width:40}, 
			    {field : 'rdateStart', title : '矫正起日期',align : 'center',width:40,
				    formatter : function(value, row, index) {
						var rdateStart = getLongDateAsString(row.rdateStart, "yyyy-MM-dd hh:mm:ss" );
						return rdateStart;
					    }
				},
				{field : 'rdateEnd',title : '矫正止日期',align : 'center',width:40,
				    formatter : function(value, row, index) {
						var rdateEnd = getLongDateAsString(row.rdateEnd, "yyyy-MM-dd hh:mm:ss" );
						return rdateEnd;
					    }
				},
				{field : 'prisonTerm',title : '原判刑期',align : 'center',width:65
				}],
		"260010":[{field : 'gname',title : '监护人',align : 'center',width:40},
		          {field : 'phone',title : '监护人电话',align : 'center', width:50}, 
		          {field : 'relation',title : '与监护人关系',align : 'center', width:50}, 
		          {field : 'sreason',title : '纳入列管原因',align : 'center',width:100},
		          {field : 'sdate',title : '纳入列管时间',align : 'center',width:80,
					    formatter : function(value, row, index) {
							var sdate = getLongDateAsString(row.sdate, "yyyy-MM-dd hh:mm:ss" );
							return sdate;
						    }
					},
		          {field : 'remark',title : '备注',align : 'center',width:100},
		          {field : 'files',title : '附件',align : 'center',width:100,
		        	  formatter : function(value, row, index) {
		  				if (row.files && row.files != null) {
		  					var filesArry = row.files.split(",");
		  					return "<img class='thumbnails gallery' height='25px' src="+Faith.projectName+"/document/show/" + filesArry[0] + "/>";
		  				}
		  			}
		          }],
			
		"260011":[{field : 'gname',title : '监护人',align : 'center',width:40},
		          {field : 'phone',title : '监护人电话',align : 'center', width:50}, 
		          {field : 'relation',title : '与监护人关系',align : 'center', width:80}, 
		          {field : 'sreason',title : '纳入列管原因',align : 'center',width:100},
		          {field : 'sdate',title : '纳入列管时间',align : 'center',width:80,
					    formatter : function(value, row, index) {
							var sdate = getLongDateAsString(row.sdate, "yyyy-MM-dd hh:mm:ss" );
							return sdate;
						    }
					},
		          {field : 'remark',title : '备注',align : 'center',width:100},
		          {field : 'files',title : '附件',align : 'center',width:200,
		        	  formatter : function(value, row, index) {
		  				if (row.files && row.files != null) {
		  					var filesArry = row.files.split(",");
		  					return "<img class='thumbnails gallery' height='25px' src="+Faith.projectName+"/document/show/" + filesArry[0] + "/>";
		  				}
		  			}
		          }],
			
		"260012":[{
			field : 'files',title : '附件',align : 'center',width :100,
			formatter : function(value, row, index) {
				if (row.files && row.files != null) {
					var filesArry = row.files.split(",");
					return "<img class='thumbnails gallery' height='25px' src="+Faith.projectName+"/document/show/" + filesArry[0] + "/>";
				}
			}},
			{field : 'fettle',title : '目前状况',align : 'center',width : 100}, 
			{field : 'parents',title : '父母单位及职务',align : 'center',width : 300}, 
			{field : 'ftype',title : '犯罪类型',align : 'center',width : 200}, 
			{field : 'measures',title : '监控措施',align : 'center',width : 300}],
		
		
}
		
		