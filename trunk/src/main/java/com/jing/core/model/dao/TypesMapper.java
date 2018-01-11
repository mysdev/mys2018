package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.Types;

/**
 * @ClassName: TypesMapper
 * @Description: 类型配置映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface TypesMapper {

	/**
	 * @Title: addTypes
	 * @Description:添加类型配置
	 * @param types 实体
	 * @return Integer
	 */
	Integer addTypes(Types types);
	
	/**
	 * @Title modifyTypes
	 * @Description:修改类型配置
	 * @param types 实体
	 * @return Integer
	 */
	Integer modifyTypes(Types types);
	
	/**
	 * @Title: dropTypesByTypeId
	 * @Description:删除类型配置
	 * @param typeId 实体标识
	 * @return Integer
	 */
	Integer dropTypesByTypeId(Integer typeId);
	
	/**
	 * @Title: queryTypesByTypeId
	 * @Description:根据实体标识查询类型配置
	 * @param typeId 实体标识
	 * @return Types
	 */
	Types queryTypesByTypeId(Integer typeId);
	 
	/**
	 * @Title: queryTypesForPage
	 * @Description: 根据类型配置属性与分页信息分页查询类型配置信息
	 * @param pageBounds 分页信息
	 * @param types 实体
	 * @return List<Types>
	 */
	List<Types> queryTypesForPage(PageBounds pageBounds, @Param("types") Types types);
	 
	 /**
	  * @Title: queryTypesByProperty
	  * @Description:根据属性查询类型配置
	  * @return List<Types>
	  */
	 List<Types> queryTypesByProperty(@Param("types") Map<String, Object> map);
	 
	 
	 
}
