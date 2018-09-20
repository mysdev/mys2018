package ${packge}.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.faith.framework.core.web.page.PageInfo;

import ${packge}.entity.${className};
import ${packge}.dao.${className}Dao;
import ${packge}.service.${className}Service;

@Service("${lowerName}Service")
public class ${className}ServiceImpl implements ${className}Service{

	@Resource
	private ${className}Dao ${lowerName}Dao;

	/**
	* 添加 ${comment}
	*/
	@Override
#if($!pkType == 'Intger')
	public Intger add${className}(${className} ${lowerName}){
		int id = ${lowerName}Dao.add${className}(${lowerName});
		${lowerName}.set${primaryKey.method}(id);
		return ${lowerName};
	}
#else
	public void add${className}(${className} ${lowerName}){
		${lowerName}Dao.add${className}(${lowerName});
	}
#end
	
	/**
	* 修改 ${comment}
	*/
	@Override
	public void update${className}(${className} ${lowerName}){
		${lowerName}Dao.update${className}(${lowerName});
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void delete${className}ById(${primaryKey.filedType} id){
		${lowerName}Dao.delete${className}ById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public ${className} get${className}ById(${primaryKey.filedType} id){
		return ${lowerName}Dao.get${className}ById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo find${className}ListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(${lowerName}Dao.find${className}ListPage(page,param));
	}
	
#if($!foreignKey)
	/**
	*根据外键值删除记录
	*/
	@Override
	public void delete${className}By${foreignKey.method}Id(${foreignKey.filedType} ${foreignKey.method}Id){
		${lowerName}Dao.delete${className}By${foreignKey.method}Id(${foreignKey.method}Id);
	}
	
	@Override
	public List<${className}> find${className}ListBy${foreignKey.method}Id(${foreignKey.filedType} ${foreignKey.method}Id)){
		return ${lowerName}Dao.find${className}ListBy${foreignKey.method}Id(${foreignKey.method}Id);
	}
#end
	
	/**
	 * 根据属性查询${comment}
	 * @param param
	 * @return
	 */
	 @Override
	public List<${className}> find${className}List(Map<String, Object> param){
		return ${lowerName}Dao.find${className}List(param);
	}
	
}