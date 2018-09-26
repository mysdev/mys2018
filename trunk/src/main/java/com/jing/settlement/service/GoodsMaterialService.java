package com.jing.settlement.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.GoodsMaterial;

public interface GoodsMaterialService {

	/**
	* 添加 基本原料
	*/
	void addGoodsMaterial(GoodsMaterial goodsMaterial);
	
	/**
	* 修改 基本原料
	*/
	void updateGoodsMaterial(GoodsMaterial goodsMaterial);
	
	/**
	*根据ID删除记录
	*/
	void deleteGoodsMaterialById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	GoodsMaterial getGoodsMaterialById(Integer id);
	
	/**
	* 分页查询
	*/
	PageInfo findGoodsMaterialListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询基本原料
	 * @param param
	 * @return
	 */
	List<GoodsMaterial> findGoodsMaterialList(Map<String, Object> param);
}