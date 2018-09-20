package ${packge}.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.faith.framework.core.web.page.PageInfo;

import ${packge}.entity.${className};

@Mapper
public interface ${className}Dao {

	/**
	* 添加 ${comment}
	*/
#if($!pkType == 'Intger')
	Intger add${className}(${className} ${lowerName});
#else
	void add${className}(${className} ${lowerName});
#end
	
	/**
	* 修改 ${comment}
	*/
	void update${className}(${className} ${lowerName});
	
	/**
	*根据ID删除记录
	*/
	void delete${className}ById(${pkType} id);	
	
	/**
	*根据ID查询记录
	*/
	${className} get${className}ById(${pkType} id);
	
	/**
	* 分页查询
	*/
	List<${className}> find${className}ListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
#if($!foreignKey)
	/**
	*根据外键值删除记录
	*/
	void delete${className}By${foreignKey.method}Id(${foreignKey.filedType} ${foreignKey.method}Id);
	
	List<${className}> find${className}ListBy${foreignKey.method}Id(${foreignKey.filedType} ${foreignKey.method}Id));
#end
	
	/**
	 * 根据属性查询${comment}
	 * @param param
	 * @return
	 */
	List<${className}> find${className}List(@Param("param") Map<String, Object> param);	
}