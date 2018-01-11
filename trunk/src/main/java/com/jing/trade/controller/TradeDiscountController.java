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
import com.jing.trade.model.entity.TradeDiscount;
import com.jing.trade.service.TradeDiscountService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TradeDiscountController
 * @Description: 结算优惠项HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="结算优惠项")
public class TradeDiscountController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private TradeDiscountService tradeDiscountService;

	
	@ApiOperation(value = "新增 添加结算优惠项信息", notes = "添加结算优惠项信息")
	@RequestMapping(value = "/tradediscount", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTradeDiscount(HttpServletResponse response,
			@ApiParam(value = "tradeDiscount") @RequestBody TradeDiscount tradeDiscount) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(tradeDiscount, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		tradeDiscount.setDiscountId(null);
		tradeDiscountService.addTradeDiscount(tradeDiscount);
		return tradeDiscount;
	}
	
	
	@ApiOperation(value = "更新 根据结算优惠项标识更新结算优惠项信息", notes = "根据结算优惠项标识更新结算优惠项信息")
	@RequestMapping(value = "/tradediscount/{discountId:.+}", method = RequestMethod.PUT)
	public Object modifyTradeDiscountById(HttpServletResponse response,
			@PathVariable Integer discountId,
			@ApiParam(value = "tradeDiscount", required = true) @RequestBody TradeDiscount tradeDiscount
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(tradeDiscount, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		TradeDiscount tempTradeDiscount = tradeDiscountService.queryTradeDiscountByDiscountId(discountId);
		tradeDiscount.setDiscountId(discountId);
		if(null == tempTradeDiscount){
			throw new NotFoundException("结算优惠项");
		}
		return tradeDiscountService.modifyTradeDiscount(tradeDiscount);
	}

	@ApiOperation(value = "删除 根据结算优惠项标识删除结算优惠项信息", notes = "根据结算优惠项标识删除结算优惠项信息")
	@RequestMapping(value = "/tradediscount/{discountId:.+}", method = RequestMethod.DELETE)
	public Object dropTradeDiscountByDiscountId(HttpServletResponse response, @PathVariable Integer discountId) {
		TradeDiscount tradeDiscount = tradeDiscountService.queryTradeDiscountByDiscountId(discountId);
		if(null == tradeDiscount){
			throw new NotFoundException("结算优惠项");
		}
		return tradeDiscountService.dropTradeDiscountByDiscountId(discountId);
	}
	
	@ApiOperation(value = "查询 根据结算优惠项标识查询结算优惠项信息", notes = "根据结算优惠项标识查询结算优惠项信息")
	@RequestMapping(value = "/tradediscount/{discountId:.+}", method = RequestMethod.GET)
	public Object queryTradeDiscountById(HttpServletResponse response,
			@PathVariable Integer discountId) {
		TradeDiscount tradeDiscount = tradeDiscountService.queryTradeDiscountByDiscountId(discountId);
		if(null == tradeDiscount){
			throw new NotFoundException("结算优惠项");
		}
		return tradeDiscount;
	}
	
	@ApiOperation(value = "查询 根据结算优惠项属性查询结算优惠项信息列表", notes = "根据结算优惠项属性查询结算优惠项信息列表")
	@RequestMapping(value = "/tradediscount", method = RequestMethod.GET)
	public Object queryTradeDiscountList(HttpServletResponse response,
			TradeDiscount tradeDiscount) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return tradeDiscountService.queryTradeDiscountByProperty(ClassUtil.transBean2Map(tradeDiscount, false));
	}
	
	@ApiOperation(value = "查询分页 根据结算优惠项属性分页查询结算优惠项信息列表", notes = "根据结算优惠项属性分页查询结算优惠项信息列表")
	@RequestMapping(value = "/tradediscounts", method = RequestMethod.GET)
	public Object queryTradeDiscountPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, TradeDiscount tradeDiscount) {				
		return tradeDiscountService.queryTradeDiscountForPage(pagenum, pagesize, sort, tradeDiscount);
	}

}
