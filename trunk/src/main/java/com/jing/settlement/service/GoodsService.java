package com.jing.settlement.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.Goods;

public interface GoodsService {

	/**
	* 添加 商品服务
	*/
	void addGoods(Goods goods);
	
	/**
	* 修改 商品服务
	*/
	void updateGoods(Goods goods);
	
	/**
	*根据ID删除记录
	*/
	void deleteGoodsById(String id);	
	
	/**
	*根据ID查询记录
	*/
	Goods getGoodsById(String id);
	
	/**
	* 分页查询
	*/
	PageInfo findGoodsListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询商品服务
	 * @param param
	 * @return
	 */
	List<Goods> findGoodsList(Map<String, Object> param);
}