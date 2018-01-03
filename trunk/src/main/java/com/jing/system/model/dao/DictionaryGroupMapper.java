package com.jing.system.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.system.model.entity.DictionaryGroup;

/**
 * @ClassName: DictionaryGroupMapper
 * @Description: 字典分组映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
@Mapper
public interface DictionaryGroupMapper {

	/**
	 * @Title: addDictionaryGroup
	 * @Description:添加字典分组
	 * @param dictionaryGroup 实体
	 * @return Integer
	 */
	Integer addDictionaryGroup(DictionaryGroup dictionaryGroup);
	
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
	 * @param pageBounds 分页信息
	 * @param dictionaryGroup 实体
	 * @return List<DictionaryGroup>
	 */
	List<DictionaryGroup> queryDictionaryGroupForPage(PageBounds pageBounds, @Param("dictionaryGroup") DictionaryGroup dictionaryGroup);
	 
	 /**
	  * @Title: queryDictionaryGroupByProperty
	  * @Description:根据属性查询字典分组
	  * @return List<DictionaryGroup>
	  */
	 List<DictionaryGroup> queryDictionaryGroupByProperty(@Param("dictionaryGroup") Map<String, Object> map);
	 
	 
	 
}
