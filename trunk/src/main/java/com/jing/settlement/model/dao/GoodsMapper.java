package com.jing.settlement.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.Goods;

@Mapper
public interface GoodsMapper {

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
	List<Goods> findGoodsListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询商品服务
	 * @param param
	 * @return
	 */
	List<Goods> findGoodsList(@Param("param") Map<String, Object> param);	
}