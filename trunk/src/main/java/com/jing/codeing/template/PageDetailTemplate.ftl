<div id="detail_${lowerName}" class="fromstyle">
#foreach( $col in $!{columns} ) 
	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 nopadding">
		<div class="border_tab padding_int">
			<label class="column_t">${col.columnLabel}:</label>
			<div class="column_z column_title" id="${col.columnName}" name="${col.columnName}"></div>
		</div>
	</div>
#end	
 </div>