package com.jing.system.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.system.model.entity.Dictionary;

/**
 * @ClassName: DictionaryMapper
 * @Description: 字典值映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@Mapper
public interface DictionaryMapper {

	/**
	 * @Title: addDictionary
	 * @Description:添加字典值
	 * @param dictionary 实体
	 * @return Integer
	 */
	Integer addDictionary(Dictionary dictionary);
	
	/**
	 * @Title modifyDictionary
	 * @Description:修改字典值
	 * @param dictionary 实体
	 * @return Integer
	 */
	Integer modifyDictionary(Dictionary dictionary);
	
	/**
	 * @Title: dropDictionaryById
	 * @Description:删除字典值
	 * @param id 实体标识
	 * @return Integer
	 */
	Integer dropDictionaryById(Integer id);
	
	/**
	 * @Title: queryDictionaryById
	 * @Description:根据实体标识查询字典值
	 * @param id 实体标识
	 * @return Dictionary
	 */
	Dictionary queryDictionaryById(Integer id);
	 
	/**
	 * @Title: queryDictionaryForPage
	 * @Description: 根据字典值属性与分页信息分页查询字典值信息
	 * @param pageBounds 分页信息
	 * @param dictionary 实体
	 * @return List<Dictionary>
	 */
	List<Dictionary> queryDictionaryForPage(PageBounds pageBounds, @Param("dictionary") Dictionary dictionary);
	 
	 /**
	  * @Title: queryDictionaryByProperty
	  * @Description:根据属性查询字典值
	  * @return List<Dictionary>
	  */
	 List<Dictionary> queryDictionaryByProperty(@Param("dictionary") Map<String, Object> map);
	 
	 /**
	 * @Title: clearTableData
	 * @Description: 清空表信息
	 * @return 
	 */
	 void clearTableData();
	 
	 
}
