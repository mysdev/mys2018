package com.jing.core.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.Strap;

public interface StrapService {

	/**
	* 添加 手牌
	*/
	void addStrap(Strap strap);
	
	/**
	* 修改 手牌
	*/
	void updateStrap(Strap strap);
	
	/**
	*根据ID删除记录
	*/
	void deleteStrapById(String id);	
	
	/**
	*根据ID查询记录
	*/
	Strap getStrapById(String id);
	
	/**
	* 分页查询
	*/
	PageInfo findStrapListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询手牌
	 * @param param
	 * @return
	 */
	List<Strap> findStrapList(Map<String, Object> param);
}