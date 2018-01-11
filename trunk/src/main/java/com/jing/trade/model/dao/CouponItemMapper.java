package com.jing.trade.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.trade.model.entity.CouponItem;

/**
 * @ClassName: CouponItemMapper
 * @Description: 优惠项目映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Mapper
public interface CouponItemMapper {

	/**
	 * @Title: addCouponItem
	 * @Description:添加优惠项目
	 * @param couponItem 实体
	 * @return Integer
	 */
	Integer addCouponItem(CouponItem couponItem);
	
	/**
	 * @Title modifyCouponItem
	 * @Description:修改优惠项目
	 * @param couponItem 实体
	 * @return Integer
	 */
	Integer modifyCouponItem(CouponItem couponItem);
	
	/**
	 * @Title: dropCouponItemByItemId
	 * @Description:删除优惠项目
	 * @param itemId 实体标识
	 * @return Integer
	 */
	Integer dropCouponItemByItemId(Integer itemId);
	
	/**
	 * @Title: queryCouponItemByItemId
	 * @Description:根据实体标识查询优惠项目
	 * @param itemId 实体标识
	 * @return CouponItem
	 */
	CouponItem queryCouponItemByItemId(Integer itemId);
	 
	/**
	 * @Title: queryCouponItemForPage
	 * @Description: 根据优惠项目属性与分页信息分页查询优惠项目信息
	 * @param pageBounds 分页信息
	 * @param couponItem 实体
	 * @return List<CouponItem>
	 */
	List<CouponItem> queryCouponItemForPage(PageBounds pageBounds, @Param("couponItem") CouponItem couponItem);
	 
	 /**
	  * @Title: queryCouponItemByProperty
	  * @Description:根据属性查询优惠项目
	  * @return List<CouponItem>
	  */
	 List<CouponItem> queryCouponItemByProperty(@Param("couponItem") Map<String, Object> map);
	 
	 
	 
}
