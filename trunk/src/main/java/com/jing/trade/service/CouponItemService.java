package com.jing.trade.service;

import java.util.List;
import java.util.Map;


import com.jing.trade.model.entity.CouponItem;

/**
 * @ClassName: CouponItem
 * @Description: 优惠项目服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public interface CouponItemService {

    /**
	 * @Title: addCouponItem
	 * @Description:添加优惠项目
	 * @param couponItem 实体
	 * @return Integer
	 */
	CouponItem addCouponItem(CouponItem couponItem);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param couponItem 实体
	 * @return List<CouponItem>
	 */
	Map<String, Object> queryCouponItemForPage(Integer pagenum, Integer pagesize, String sort, CouponItem couponItem);
	 
	 /**
	 * @Title: queryCouponItemByProperty
	 * @Description:根据属性查询优惠项目
	 * @return List<CouponItem>
	 */
	 List<CouponItem> queryCouponItemByProperty(Map<String, Object> map);	 
	 
}
