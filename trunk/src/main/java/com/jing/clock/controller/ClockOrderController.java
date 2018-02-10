package com.jing.clock.controller;

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
import com.jing.clock.model.entity.ClockOrder;
import com.jing.clock.service.ClockOrderService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ClockOrderController
 * @Description: 订单HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="订单", tags={"Clock&Order"})
public class ClockOrderController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private ClockOrderService clockOrderService;

	
	@ApiOperation(value = "新增 添加订单信息", notes = "添加订单信息")
	@RequestMapping(value = "/clockorder", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addClockOrder(HttpServletResponse response,
			@ApiParam(value = "clockOrder") @RequestBody ClockOrder clockOrder) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(clockOrder, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		clockOrder.setOrderId(null);
		clockOrderService.addClockOrder(clockOrder);
		return clockOrder;
	}
	
	
	@ApiOperation(value = "更新 根据订单标识更新订单信息", notes = "根据订单标识更新订单信息")
	@RequestMapping(value = "/clockorder/{orderId:.+}", method = RequestMethod.PUT)
	public Object modifyClockOrderById(HttpServletResponse response,
			@PathVariable Integer orderId,
			@ApiParam(value = "clockOrder", required = true) @RequestBody ClockOrder clockOrder
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(clockOrder, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		ClockOrder tempClockOrder = clockOrderService.queryClockOrderByOrderId(orderId);
		clockOrder.setOrderId(orderId);
		if(null == tempClockOrder){
			throw new NotFoundException("订单");
		}
		return clockOrderService.modifyClockOrder(clockOrder);
	}

	@ApiOperation(value = "删除 根据订单标识删除订单信息", notes = "根据订单标识删除订单信息")
	@RequestMapping(value = "/clockorder/{orderId:.+}", method = RequestMethod.DELETE)
	public Object dropClockOrderByOrderId(HttpServletResponse response, @PathVariable Integer orderId) {
		ClockOrder clockOrder = clockOrderService.queryClockOrderByOrderId(orderId);
		if(null == clockOrder){
			throw new NotFoundException("订单");
		}
		return clockOrderService.dropClockOrderByOrderId(orderId);
	}
	
	@ApiOperation(value = "查询 根据订单标识查询订单信息", notes = "根据订单标识查询订单信息")
	@RequestMapping(value = "/clockorder/{orderId:.+}", method = RequestMethod.GET)
	public Object queryClockOrderById(HttpServletResponse response,
			@PathVariable Integer orderId) {
		ClockOrder clockOrder = clockOrderService.queryClockOrderByOrderId(orderId);
		if(null == clockOrder){
			throw new NotFoundException("订单");
		}
		return clockOrder;
	}
	
	@ApiOperation(value = "查询 根据订单属性查询订单信息列表", notes = "根据订单属性查询订单信息列表")
	@RequestMapping(value = "/clockorder", method = RequestMethod.GET)
	public Object queryClockOrderList(HttpServletResponse response,
			ClockOrder clockOrder) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return clockOrderService.queryClockOrderByProperty(ClassUtil.transBean2Map(clockOrder, false));
	}
	
	@ApiOperation(value = "查询分页 根据订单属性分页查询订单信息列表", notes = "根据订单属性分页查询订单信息列表")
	@RequestMapping(value = "/clockorders", method = RequestMethod.GET)
	public Object queryClockOrderPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, ClockOrder clockOrder) {				
		return clockOrderService.queryClockOrderForPage(pagenum, pagesize, sort, clockOrder);
	}

}
