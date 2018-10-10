package com.jing.core.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.TypesBind;

public interface TypesBindService {

	/**
	* 添加 类型消费绑定
	*/
	void addTypesBind(TypesBind typesBind);
	
	/**
	* 修改 类型消费绑定
	*/
	void updateTypesBind(TypesBind typesBind);
	
	/**
	*根据ID删除记录
	*/
	void deleteTypesBindById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	TypesBind getTypesBindById(Integer id);
	
	/**
	* 分页查询
	*/
	PageInfo findTypesBindListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询类型消费绑定
	 * @param param
	 * @return
	 */
	List<TypesBind> findTypesBindList(Map<String, Object> param);
}