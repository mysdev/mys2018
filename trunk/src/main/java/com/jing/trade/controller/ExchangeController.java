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
import com.jing.trade.model.entity.Exchange;
import com.jing.trade.service.ExchangeService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ExchangeController
 * @Description: 结算币种HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="结算币种", tags={"TradeExchange"})
public class ExchangeController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private ExchangeService exchangeService;

	
	@ApiOperation(value = "新增 添加结算币种信息", notes = "添加结算币种信息")
	@RequestMapping(value = "/exchange", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addExchange(HttpServletResponse response,
			@ApiParam(value = "exchange") @RequestBody Exchange exchange) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(exchange, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		exchange.setExchangeId(null);
		exchangeService.addExchange(exchange);
		return exchange;
	}
	
	
	@ApiOperation(value = "更新 根据结算币种标识更新结算币种信息", notes = "根据结算币种标识更新结算币种信息")
	@RequestMapping(value = "/exchange/{exchangeId:.+}", method = RequestMethod.PUT)
	public Object modifyExchangeById(HttpServletResponse response,
			@PathVariable Integer exchangeId,
			@ApiParam(value = "exchange", required = true) @RequestBody Exchange exchange
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(exchange, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Exchange tempExchange = exchangeService.queryExchangeByExchangeId(exchangeId);
		exchange.setExchangeId(exchangeId);
		if(null == tempExchange){
			throw new NotFoundException("结算币种");
		}
		return exchangeService.modifyExchange(exchange);
	}

	@ApiOperation(value = "删除 根据结算币种标识删除结算币种信息", notes = "根据结算币种标识删除结算币种信息")
	@RequestMapping(value = "/exchange/{exchangeId:.+}", method = RequestMethod.DELETE)
	public Object dropExchangeByExchangeId(HttpServletResponse response, @PathVariable Integer exchangeId) {
		Exchange exchange = exchangeService.queryExchangeByExchangeId(exchangeId);
		if(null == exchange){
			throw new NotFoundException("结算币种");
		}
		return exchangeService.dropExchangeByExchangeId(exchangeId);
	}
	
	@ApiOperation(value = "查询 根据结算币种标识查询结算币种信息", notes = "根据结算币种标识查询结算币种信息")
	@RequestMapping(value = "/exchange/{exchangeId:.+}", method = RequestMethod.GET)
	public Object queryExchangeById(HttpServletResponse response,
			@PathVariable Integer exchangeId) {
		Exchange exchange = exchangeService.queryExchangeByExchangeId(exchangeId);
		if(null == exchange){
			throw new NotFoundException("结算币种");
		}
		return exchange;
	}
	
	@ApiOperation(value = "查询 根据结算币种属性查询结算币种信息列表", notes = "根据结算币种属性查询结算币种信息列表")
	@RequestMapping(value = "/exchange", method = RequestMethod.GET)
	public Object queryExchangeList(HttpServletResponse response,
			Exchange exchange) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return exchangeService.queryExchangeByProperty(ClassUtil.transBean2Map(exchange, false));
	}
	
	@ApiOperation(value = "查询分页 根据结算币种属性分页查询结算币种信息列表", notes = "根据结算币种属性分页查询结算币种信息列表")
	@RequestMapping(value = "/exchanges", method = RequestMethod.GET)
	public Object queryExchangePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Exchange exchange) {				
		return exchangeService.queryExchangeForPage(pagenum, pagesize, sort, exchange);
	}

}
