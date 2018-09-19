package com.jing.system.dictionary.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.dictionary.entity.Dictionary;
import com.jing.system.dictionary.entity.DictionaryGroup;
import com.jing.system.permission.entity.Resources;

/**
 * 字典操作
 * @author lifeng
 *
 */
@Mapper
public interface DictionaryDao {

	/**
	 * 添加字典组
	 * @param code
	 * @param desc
	 */
	void addDictionaryGroup(@Param("code")String code,@Param("desc") String desc,@Param("name") String username);
	
	/** 
	 * @Title: modDictionaryGroup 
	 * @Description: 修订字典组名称,根据代码 
	 * @param dictionaryGroup 
	 *
	 */ 
	boolean modDictionaryGroup(@Param("code")String code,@Param("desc") String desc,@Param("name") String username);
	
	/** 
	 * @Title: delDictionaryGroup 
	 * @Description: 删除字典组，根据代码
	 * @param code
	 * @param updatedBy  
	 *
	 */ 
	boolean delDictionaryGroup(String code);
	
	/**
	 * 添加字典值
	 * @param groupId
	 * @param dictionary
	 */
	void addDictionary(Dictionary dictionary);
	
	/**
	 * 删除字典值(flag=0)
	 * @param dictionary
	 */
	void deleteDictionary(Dictionary dictionary);
	
	/** 
	 * @Title: deleteDictionaryByGroupCode 
	 * @Description: 将字典更新为不可用，不作物理删除 
	 * @param dictionary
	 * @return  
	 *
	 */ 
	boolean deleteDictionaryByGroupCode(Dictionary dictionary);
	
	/**
	 * 修改数据字典值
	 * @param dictionary
	 */
	void updateDictionary(Map<String, Object> param);
	
	/**
	 * 获取数据字典
	 * @param code
	 * @return
	 */
	DictionaryGroup getDictionaryGroupByCode(String code);
	
	/**
	 * 根据组ID查询字典值(不包含已经删除的)
	 * @param groupCode
	 * @return
	 */
	List<Dictionary> findDictionaryByGroupCode(String groupCode);
	
	/**
	 * 根据组ID查询所有字典值
	 * @param groupCode
	 * @return
	 */
	List<Dictionary> findAllDictionaryByGroupCode(String groupCode);
	
	/**
	 * 查询所有字典组 ，包含字典值
	 * @return
	 */
	List<DictionaryGroup> findAllDictionaryGroup();
	
	/**
	 * 查询所有字典组 ，但不包含字典值
	 * @return
	 */
	List<DictionaryGroup> findDictionaryGroupSimple();
	
	
	/**
	 * 查询Dictionary的值
	 */
	List<Dictionary> findAllDictionary();

	/**
	 * 根据code查询dictionary的列表
	 * @param rootCode
	 * @return
	 */
	List<Dictionary> findDictionaryGroupByCode(String rootCode);
	/**
	 * 查询字典组
	 */
	List<DictionaryGroup> getDictionaryGroupList();
	/**
	 * 分页查询字典
	 * @param page
	 * @param param
	 * @return
	 */
	List<Resources> findDictionaryListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	Dictionary getDictionaryById(String code);
	
	void deleteDictionaryById(String code);
	
	void deleteDictionaryGroupById(String code);
}
