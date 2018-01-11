package com.jing.trade.service;

import java.util.List;
import java.util.Map;


import com.jing.trade.model.entity.Coupon;

/**
 * @ClassName: Coupon
 * @Description: 优惠卷组服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public interface CouponService {

    /**
	 * @Title: addCoupon
	 * @Description:添加优惠卷组
	 * @param coupon 实体
	 * @return Integer
	 */
	Coupon addCoupon(Coupon coupon);
	
	/**
	 * @Title modifyCoupon
	 * @Description:修改优惠卷组
	 * @param coupon 实体
	 * @return Integer
	 */
	Integer modifyCoupon(Coupon coupon);
	
	/**
	 * @Title: dropCouponByCouponId
	 * @Description:删除优惠卷组
	 * @param couponId 实体标识
	 * @return Integer
	 */
	Integer dropCouponByCouponId(Integer couponId);
	
	/**
	 * @Title: queryCouponByCouponId
	 * @Description:根据实体标识查询优惠卷组
	 * @param couponId 实体标识
	 * @return Coupon
	 */
	Coupon queryCouponByCouponId(Integer couponId);
	 
	/**
	 * @Title: queryCouponForPage
	 * @Description: 根据优惠卷组属性与分页信息分页查询优惠卷组信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param coupon 实体
	 * @return List<Coupon>
	 */
	Map<String, Object> queryCouponForPage(Integer pagenum, Integer pagesize, String sort, Coupon coupon);
	 
	 /**
	 * @Title: queryCouponByProperty
	 * @Description:根据属性查询优惠卷组
	 * @return List<Coupon>
	 */
	 List<Coupon> queryCouponByProperty(Map<String, Object> map);	 
	 
}
