package ${packge}.service;

import java.util.List;
import java.util.Map;

import com.faith.framework.core.web.page.PageInfo;

import ${packge}.entity.${className};

public interface ${className}Service {

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
	PageInfo find${className}ListPage(PageInfo page, Map<String, Object> param);
	
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
	List<${className}> find${className}List(Map<String, Object> param);
}