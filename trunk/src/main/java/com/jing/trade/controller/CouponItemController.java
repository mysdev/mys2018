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
import com.jing.trade.model.entity.CouponItem;
import com.jing.trade.service.CouponItemService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: CouponItemController
 * @Description: 优惠项目HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="优惠项目", tags={"TradeCouponItem"})
public class CouponItemController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private CouponItemService couponItemService;

	
	@ApiOperation(value = "新增 添加优惠项目信息", notes = "添加优惠项目信息")
	@RequestMapping(value = "/couponitem", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addCouponItem(HttpServletResponse response,
			@ApiParam(value = "couponItem") @RequestBody CouponItem couponItem) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(couponItem, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		couponItem.setItemId(null);
		couponItemService.addCouponItem(couponItem);
		return couponItem;
	}
	
	
	@ApiOperation(value = "更新 根据优惠项目标识更新优惠项目信息", notes = "根据优惠项目标识更新优惠项目信息")
	@RequestMapping(value = "/couponitem/{itemId:.+}", method = RequestMethod.PUT)
	public Object modifyCouponItemById(HttpServletResponse response,
			@PathVariable Integer itemId,
			@ApiParam(value = "couponItem", required = true) @RequestBody CouponItem couponItem
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(couponItem, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		CouponItem tempCouponItem = couponItemService.queryCouponItemByItemId(itemId);
		couponItem.setItemId(itemId);
		if(null == tempCouponItem){
			throw new NotFoundException("优惠项目");
		}
		return couponItemService.modifyCouponItem(couponItem);
	}

	@ApiOperation(value = "删除 根据优惠项目标识删除优惠项目信息", notes = "根据优惠项目标识删除优惠项目信息")
	@RequestMapping(value = "/couponitem/{itemId:.+}", method = RequestMethod.DELETE)
	public Object dropCouponItemByItemId(HttpServletResponse response, @PathVariable Integer itemId) {
		CouponItem couponItem = couponItemService.queryCouponItemByItemId(itemId);
		if(null == couponItem){
			throw new NotFoundException("优惠项目");
		}
		return couponItemService.dropCouponItemByItemId(itemId);
	}
	
	@ApiOperation(value = "查询 根据优惠项目标识查询优惠项目信息", notes = "根据优惠项目标识查询优惠项目信息")
	@RequestMapping(value = "/couponitem/{itemId:.+}", method = RequestMethod.GET)
	public Object queryCouponItemById(HttpServletResponse response,
			@PathVariable Integer itemId) {
		CouponItem couponItem = couponItemService.queryCouponItemByItemId(itemId);
		if(null == couponItem){
			throw new NotFoundException("优惠项目");
		}
		return couponItem;
	}
	
	@ApiOperation(value = "查询 根据优惠项目属性查询优惠项目信息列表", notes = "根据优惠项目属性查询优惠项目信息列表")
	@RequestMapping(value = "/couponitem", method = RequestMethod.GET)
	public Object queryCouponItemList(HttpServletResponse response,
			CouponItem couponItem) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return couponItemService.queryCouponItemByProperty(ClassUtil.transBean2Map(couponItem, false));
	}
	
	@ApiOperation(value = "查询分页 根据优惠项目属性分页查询优惠项目信息列表", notes = "根据优惠项目属性分页查询优惠项目信息列表")
	@RequestMapping(value = "/couponitems", method = RequestMethod.GET)
	public Object queryCouponItemPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, CouponItem couponItem) {				
		return couponItemService.queryCouponItemForPage(pagenum, pagesize, sort, couponItem);
	}

}
