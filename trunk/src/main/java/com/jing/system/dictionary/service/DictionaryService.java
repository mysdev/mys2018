package com.jing.system.dictionary.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.system.dictionary.entity.Dictionary;
import com.jing.system.dictionary.entity.DictionaryGroup;

/**
 * 数据字典相关操作
 * 
 * @author lifeng
 *
 */
public interface DictionaryService {

	/**
	 * 添加字典组
	 * 
	 * @param code
	 * @param desc
	 */
	void addDictionaryGroup(String code,String desc,String username);

	/**
	 * @Title: modDictionaryGroup
	 * @Description: 修订字典组名称,根据代码
	 * @param code
	 * @param desc
	 * @param updatedBy
	 *
	 */
	void modDictionaryGroup(String code, String desc,String username);

	/**
	 * @Title: delDictionaryGroup
	 * @Description: 删除字典组，根据代码
	 * @param code
	 * @param desc
	 * @param updatedBy
	 *
	 */
	boolean delDictionaryGroup(String code, int updatedBy);

	/**
	 * 添加字典值
	 * 
	 * @param groupId
	 * @param dictionary
	 */
	void addDictionary(String groupCode, Dictionary dictionary);

	/**
	 * 删除字典值(flag=0)
	 * 
	 * @param groupId
	 * @param dictionary
	 */
	void deleteDictionary(Dictionary dictionary);

	/**
	 * 修改数据字典值
	 * 
	 * @param groupId
	 * @param dictionary
	 */
	void updateDictionary(Map<String, Object> param);

	/**
	 * 获取数据字典
	 * 
	 * @param code
	 * @return
	 */
	DictionaryGroup findDictionaryGroup(String code);

	/**
	 * 获取数据字典，不带缓存
	 * 
	 * @param code
	 * @return
	 */
	DictionaryGroup findDictionaryGroupNoCache(String code);

	/**
	 * 获取所有数据字典
	 * 
	 * @param code
	 * @return
	 */
	List<DictionaryGroup> findAllDictionaryGroup();

	/**
	 * 获取所有数据字典, 不缓存，不包含字典值
	 * 
	 * @param code
	 * @return
	 */
	List<DictionaryGroup> findAllDictionaryGroupNoCache();

	/**
	 * 
	 * @param rootCode
	 * @return
	 */
	List<Dictionary> findDictionaryGroupByCode(String rootCode);

	/**
	 * 通过groupCode获取数据字典的值
	 */
	List<Dictionary> findDictionaryByGroupCode(String groupCode);

	/**
	 * @Title: deleteDictionaryGroup
	 * @Description: 删除字典组名称,根据代码
	 * @param code
	 * @param username
	 * @return
	 *
	 */
	boolean deleteDictionaryGroup(String code, int username);

	/**
	 * @Title: addDictionaryGroup
	 * @Description:
	 * @param code
	 * @param desc
	 * @param user
	 *
	 */
	/*void addDictionaryGroup(String code, String desc, int user);*/

	/**
	 * 刷新数据字典所存文件
	 * 
	 * @throws IOException
	 */
	void refreshDictionaryFile() throws IOException;

	/**
	 * 获取字典值
	 * 
	 * @param group
	 * @param code
	 * @return
	 */
	String getValue(String group, String code);

	/**
	 * 获取字典值
	 * 
	 * @param group
	 * @param code
	 * @return
	 */
	Dictionary Dictionary(String group, String code);

	/**
	 * 查询字典组
	 */
	List<DictionaryGroup> getDictionaryGroupList();
	
	/**
	* 分页查询
	*/
	PageInfo findDictionaryListPage(PageInfo page, Map<String, Object> param);
	
	Dictionary getDictionaryById(String code);
	
	void deleteDictionaryGroupById(String code);
}
