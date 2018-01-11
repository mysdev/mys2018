package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.Types;

/**
 * @ClassName: Types
 * @Description: 类型配置服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface TypesService {

    /**
	 * @Title: addTypes
	 * @Description:添加类型配置
	 * @param types 实体
	 * @return Integer
	 */
	Types addTypes(Types types);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param types 实体
	 * @return List<Types>
	 */
	Map<String, Object> queryTypesForPage(Integer pagenum, Integer pagesize, String sort, Types types);
	 
	 /**
	 * @Title: queryTypesByProperty
	 * @Description:根据属性查询类型配置
	 * @return List<Types>
	 */
	 List<Types> queryTypesByProperty(Map<String, Object> map);	 
	 
}
