package com.jing.settlement.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.settlement.model.entity.GoodsUnit;

/**
 * @ClassName: GoodsUnitMapper
 * @Description: 商品单位映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Mapper
public interface GoodsUnitMapper {

	/**
	 * @Title: addGoodsUnit
	 * @Description:添加商品单位
	 * @param goodsUnit 实体
	 * @return Integer
	 */
	Integer addGoodsUnit(GoodsUnit goodsUnit);
	
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
	 * @param pageBounds 分页信息
	 * @param goodsUnit 实体
	 * @return List<GoodsUnit>
	 */
	List<GoodsUnit> queryGoodsUnitForPage(PageBounds pageBounds, @Param("goodsUnit") GoodsUnit goodsUnit);
	 
	 /**
	  * @Title: queryGoodsUnitByProperty
	  * @Description:根据属性查询商品单位
	  * @return List<GoodsUnit>
	  */
	 List<GoodsUnit> queryGoodsUnitByProperty(@Param("goodsUnit") Map<String, Object> map);
	 
	 
	 
}
