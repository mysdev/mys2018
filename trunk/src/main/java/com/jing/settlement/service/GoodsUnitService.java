package com.jing.settlement.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.GoodsUnit;

public interface GoodsUnitService {

	/**
	* 添加 商品单位
	*/
	void addGoodsUnit(GoodsUnit goodsUnit);
	
	/**
	* 修改 商品单位
	*/
	void updateGoodsUnit(GoodsUnit goodsUnit);
	
	/**
	*根据ID删除记录
	*/
	void deleteGoodsUnitById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	GoodsUnit getGoodsUnitById(Integer id);
	
	/**
	* 分页查询
	*/
	PageInfo findGoodsUnitListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询商品单位
	 * @param param
	 * @return
	 */
	List<GoodsUnit> findGoodsUnitList(Map<String, Object> param);
}