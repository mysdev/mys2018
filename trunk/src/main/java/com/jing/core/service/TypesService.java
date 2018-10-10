package com.jing.core.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.Types;

public interface TypesService {

	/**
	* 添加 类型配置
	*/
	void addTypes(Types types);
	
	/**
	* 修改 类型配置
	*/
	void updateTypes(Types types);
	
	/**
	*根据ID删除记录
	*/
	void deleteTypesById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	Types getTypesById(Integer id);
	
	/**
	* 分页查询
	*/
	PageInfo findTypesListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询类型配置
	 * @param param
	 * @return
	 */
	List<Types> findTypesList(Map<String, Object> param);
}