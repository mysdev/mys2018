package com.jing.system.service;

import java.util.List;
import java.util.Map;


import com.jing.system.model.entity.Dictionary;

/**
 * @ClassName: Dictionary
 * @Description: 字典值服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
public interface DictionaryService {

    /**
	 * @Title: addDictionary
	 * @Description:添加字典值
	 * @param dictionary 实体
	 * @return Integer
	 */
	Dictionary addDictionary(Dictionary dictionary);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param dictionary 实体
	 * @return List<Dictionary>
	 */
	Map<String, Object> queryDictionaryForPage(Integer pagenum, Integer pagesize, String sort, Dictionary dictionary);
	 
	 /**
	 * @Title: queryDictionaryByProperty
	 * @Description:根据属性查询字典值
	 * @return List<Dictionary>
	 */
	 List<Dictionary> queryDictionaryByProperty(Map<String, Object> map);	 
	 
}
