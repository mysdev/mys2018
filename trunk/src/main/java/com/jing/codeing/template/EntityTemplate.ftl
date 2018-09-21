package ${packge}.entity;

import com.jing.utils.BaseEntity;

/**
 * ${comment} 实体类
 * @author codeing gen
 */
public class ${className} extends BaseEntity{
	private static final long serialVersionUID = 1L;

#foreach( $col in $!{columns} ) 
	${col.filedStr}
#end 

#foreach( $col in $!{columns} )
${col.getMethodStr}
#end

#foreach( $col in $!{columns} )
${col.setMethodStr}
#end

}