package ${packge}.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import ${packge}.model.entity.${className};
import ${packge}.dao.${className}Mapper;
import ${packge}.service.${className}Service;

@Service("${lowerName}Service")
public class ${className}ServiceImpl implements ${className}Service{

	@Resource
	private ${className}Mapper ${lowerName}Mapper;

	/**
	* 添加 ${comment}
	*/
	@Override
#if($!pkType == 'Intger')
	public Intger add${className}(${className} ${lowerName}){
		int id = ${lowerName}Mapper.add${className}(${lowerName});
		${lowerName}.set${primaryKey.method}(id);
		return ${lowerName};
	}
#else
	public void add${className}(${className} ${lowerName}){
		${lowerName}Mapper.add${className}(${lowerName});
	}
#end
	
	/**
	* 修改 ${comment}
	*/
	@Override
	public void update${className}(${className} ${lowerName}){
		${lowerName}Mapper.update${className}(${lowerName});
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void delete${className}ById(${primaryKey.filedType} id){
		${lowerName}Mapper.delete${className}ById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public ${className} get${className}ById(${primaryKey.filedType} id){
		return ${lowerName}Mapper.get${className}ById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo find${className}ListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(${lowerName}Mapper.find${className}ListPage(page,param));
	}
	
#if($!foreignKey)
	/**
	*根据外键值删除记录
	*/
	@Override
	public void delete${className}By${foreignKey.method}Id(${foreignKey.filedType} ${foreignKey.method}Id){
		${lowerName}Mapper.delete${className}By${foreignKey.method}Id(${foreignKey.method}Id);
	}
	
	@Override
	public List<${className}> find${className}ListBy${foreignKey.method}Id(${foreignKey.filedType} ${foreignKey.method}Id)){
		return ${lowerName}Mapper.find${className}ListBy${foreignKey.method}Id(${foreignKey.method}Id);
	}
#end
	
	/**
	 * 根据属性查询${comment}
	 * @param param
	 * @return
	 */
	 @Override
	public List<${className}> find${className}List(Map<String, Object> param){
		return ${lowerName}Mapper.find${className}List(param);
	}
	
}