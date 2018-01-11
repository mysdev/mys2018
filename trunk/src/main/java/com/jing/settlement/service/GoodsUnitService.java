package com.jing.settlement.service;

import java.util.List;
import java.util.Map;


import com.jing.settlement.model.entity.GoodsUnit;

/**
 * @ClassName: GoodsUnit
 * @Description: 商品单位服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public interface GoodsUnitService {

    /**
	 * @Title: addGoodsUnit
	 * @Description:添加商品单位
	 * @param goodsUnit 实体
	 * @return Integer
	 */
	GoodsUnit addGoodsUnit(GoodsUnit goodsUnit);
	
	/**
	 * @Title modifyGoodsUnit
	 * @Description:修改商品单位
	 * @param goodsUnit 实体
	 * @return Integer
	 */
	Integer modifyGoodsUnit(GoodsUnit goodsUnit);
	
	/**
	 * @Title: dropGoodsUnitByUnitId
	 * @Description:删除商品单位
	 * @param unitId 实体标识
	 * @return Integer
	 */
	Integer dropGoodsUnitByUnitId(Integer unitId);
	
	/**
	 * @Title: queryGoodsUnitByUnitId
	 * @Description:根据实体标识查询商品单位
	 * @param unitId 实体标识
	 * @return GoodsUnit
	 */
	GoodsUnit queryGoodsUnitByUnitId(Integer unitId);
	 
	/**
	 * @Title: queryGoodsUnitForPage
	 * @Description: 根据商品单位属性与分页信息分页查询商品单位信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param goodsUnit 实体
	 * @return List<GoodsUnit>
	 */
	Map<String, Object> queryGoodsUnitForPage(Integer pagenum, Integer pagesize, String sort, GoodsUnit goodsUnit);
	 
	 /**
	 * @Title: queryGoodsUnitByProperty
	 * @Description:根据属性查询商品单位
	 * @return List<GoodsUnit>
	 */
	 List<GoodsUnit> queryGoodsUnitByProperty(Map<String, Object> map);	 
	 
}
