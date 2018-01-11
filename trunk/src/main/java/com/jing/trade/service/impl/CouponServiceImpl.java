package com.jing.trade.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.trade.model.entity.Coupon;
import com.jing.trade.model.dao.CouponMapper;
import com.jing.trade.service.CouponService;

/**
 * @ClassName: Coupon
 * @Description: 优惠卷组服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("couponService")
@Transactional(readOnly=true)
public class  CouponServiceImpl implements CouponService {	
	private static final Logger logger = LoggerFactory.getLogger(CouponServiceImpl.class);
	
	@Autowired
    private CouponMapper couponMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addCoupon
	 * @Description:添加优惠卷组
	 * @param coupon 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Coupon addCoupon(Coupon coupon){
		int ret = couponMapper.addCoupon(coupon);
		if(ret>0){
			return coupon;
		}
		return null;
	}
	
	/**
	 * @Title modifyCoupon
	 * @Description:修改优惠卷组
	 * @param coupon 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyCoupon(Coupon coupon){
		return couponMapper.modifyCoupon(coupon);
	}
	
	/**
	 * @Title: dropCouponByCouponId
	 * @Description:删除优惠卷组
	 * @param couponId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropCouponByCouponId(Integer couponId){
		return couponMapper.dropCouponByCouponId(couponId);
	}
	
	/**
	 * @Title: queryCouponByCouponId
	 * @Description:根据实体标识查询优惠卷组
	 * @param couponId 实体标识
	 * @return Coupon
	 */
	@Override
	public Coupon queryCouponByCouponId(Integer couponId){
		return couponMapper.queryCouponByCouponId(couponId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryCouponForPage
	 * @Description: 根据优惠卷组属性与分页信息分页查询优惠卷组信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param coupon 实体
	 * @return List<Coupon>
	 */
	@Override
	public Map<String, Object> queryCouponForPage(Integer pagenum, Integer pagesize, String sort, Coupon coupon){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Coupon.class);
		List<Coupon> entityList = couponMapper.queryCouponForPage(pageBounds, coupon);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Coupon.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Coupon> pagelist = (PageList<Coupon>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryCouponByProperty
	 * @Description:根据属性查询优惠卷组
	 * @return List<Coupon>
	 */
	@Override
	public List<Coupon> queryCouponByProperty(Map<String, Object> map){
		return couponMapper.queryCouponByProperty(map);
	}


}
