package com.jing.settlement.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.GoodsUnit;

@Mapper
public interface GoodsUnitMapper {

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
	List<GoodsUnit> findGoodsUnitListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询商品单位
	 * @param param
	 * @return
	 */
	List<GoodsUnit> findGoodsUnitList(@Param("param") Map<String, Object> param);	
}