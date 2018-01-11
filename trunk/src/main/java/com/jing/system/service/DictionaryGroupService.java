package com.jing.system.service;

import java.util.List;
import java.util.Map;


import com.jing.system.model.entity.DictionaryGroup;

/**
 * @ClassName: DictionaryGroup
 * @Description: 字典分组服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public interface DictionaryGroupService {

    /**
	 * @Title: addDictionaryGroup
	 * @Description:添加字典分组
	 * @param dictionaryGroup 实体
	 * @return Integer
	 */
	DictionaryGroup addDictionaryGroup(DictionaryGroup dictionaryGroup);
	
	/**
	 * @Title modifyDictionaryGroup
	 * @Description:修改字典分组
	 * @param dictionaryGroup 实体
	 * @return Integer
	 */
	Integer modifyDictionaryGroup(DictionaryGroup dictionaryGroup);
	
	/**
	 * @Title: dropDictionaryGroupByGroupId
	 * @Description:删除字典分组
	 * @param groupId 实体标识
	 * @return Integer
	 */
	Integer dropDictionaryGroupByGroupId(Integer groupId);
	
	/**
	 * @Title: queryDictionaryGroupByGroupId
	 * @Description:根据实体标识查询字典分组
	 * @param groupId 实体标识
	 * @return DictionaryGroup
	 */
	DictionaryGroup queryDictionaryGroupByGroupId(Integer groupId);
	 
	/**
	 * @Title: queryDictionaryGroupForPage
	 * @Description: 根据字典分组属性与分页信息分页查询字典分组信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param dictionaryGroup 实体
	 * @return List<DictionaryGroup>
	 */
	Map<String, Object> queryDictionaryGroupForPage(Integer pagenum, Integer pagesize, String sort, DictionaryGroup dictionaryGroup);
	 
	 /**
	 * @Title: queryDictionaryGroupByProperty
	 * @Description:根据属性查询字典分组
	 * @return List<DictionaryGroup>
	 */
	 List<DictionaryGroup> queryDictionaryGroupByProperty(Map<String, Object> map);	 
	 
}
