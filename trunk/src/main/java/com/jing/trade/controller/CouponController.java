package com.jing.trade.controller;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import com.jing.config.validation.BeanValidator;
import com.jing.trade.model.entity.Coupon;
import com.jing.trade.service.CouponService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: CouponController
 * @Description: 优惠卷组HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="优惠卷组")
public class CouponController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private CouponService couponService;

	
	@ApiOperation(value = "新增 添加优惠卷组信息", notes = "添加优惠卷组信息")
	@RequestMapping(value = "/coupon", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addCoupon(HttpServletResponse response,
			@ApiParam(value = "coupon") @RequestBody Coupon coupon) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(coupon, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		coupon.setCouponId(null);
		couponService.addCoupon(coupon);
		return coupon;
	}
	
	
	@ApiOperation(value = "更新 根据优惠卷组标识更新优惠卷组信息", notes = "根据优惠卷组标识更新优惠卷组信息")
	@RequestMapping(value = "/coupon/{couponId:.+}", method = RequestMethod.PUT)
	public Object modifyCouponById(HttpServletResponse response,
			@PathVariable Integer couponId,
			@ApiParam(value = "coupon", required = true) @RequestBody Coupon coupon
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(coupon, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Coupon tempCoupon = couponService.queryCouponByCouponId(couponId);
		coupon.setCouponId(couponId);
		if(null == tempCoupon){
			throw new NotFoundException("优惠卷组");
		}
		return couponService.modifyCoupon(coupon);
	}

	@ApiOperation(value = "删除 根据优惠卷组标识删除优惠卷组信息", notes = "根据优惠卷组标识删除优惠卷组信息")
	@RequestMapping(value = "/coupon/{couponId:.+}", method = RequestMethod.DELETE)
	public Object dropCouponByCouponId(HttpServletResponse response, @PathVariable Integer couponId) {
		Coupon coupon = couponService.queryCouponByCouponId(couponId);
		if(null == coupon){
			throw new NotFoundException("优惠卷组");
		}
		return couponService.dropCouponByCouponId(couponId);
	}
	
	@ApiOperation(value = "查询 根据优惠卷组标识查询优惠卷组信息", notes = "根据优惠卷组标识查询优惠卷组信息")
	@RequestMapping(value = "/coupon/{couponId:.+}", method = RequestMethod.GET)
	public Object queryCouponById(HttpServletResponse response,
			@PathVariable Integer couponId) {
		Coupon coupon = couponService.queryCouponByCouponId(couponId);
		if(null == coupon){
			throw new NotFoundException("优惠卷组");
		}
		return coupon;
	}
	
	@ApiOperation(value = "查询 根据优惠卷组属性查询优惠卷组信息列表", notes = "根据优惠卷组属性查询优惠卷组信息列表")
	@RequestMapping(value = "/coupon", method = RequestMethod.GET)
	public Object queryCouponList(HttpServletResponse response,
			Coupon coupon) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return couponService.queryCouponByProperty(ClassUtil.transBean2Map(coupon, false));
	}
	
	@ApiOperation(value = "查询分页 根据优惠卷组属性分页查询优惠卷组信息列表", notes = "根据优惠卷组属性分页查询优惠卷组信息列表")
	@RequestMapping(value = "/coupons", method = RequestMethod.GET)
	public Object queryCouponPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Coupon coupon) {				
		return couponService.queryCouponForPage(pagenum, pagesize, sort, coupon);
	}

}
