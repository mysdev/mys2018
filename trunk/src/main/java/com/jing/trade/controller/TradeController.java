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
import com.jing.trade.model.entity.Trade;
import com.jing.trade.service.TradeService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TradeController
 * @Description: 消费清单HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="消费清单", tags={"TradeTrade"})
public class TradeController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private TradeService tradeService;

	
	@ApiOperation(value = "新增 添加消费清单信息", notes = "添加消费清单信息")
	@RequestMapping(value = "/trade", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTrade(HttpServletResponse response,
			@ApiParam(value = "trade") @RequestBody Trade trade) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(trade, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		trade.setTradeId(null);
		tradeService.addTrade(trade);
		return trade;
	}
	
	
	@ApiOperation(value = "更新 根据消费清单标识更新消费清单信息", notes = "根据消费清单标识更新消费清单信息")
	@RequestMapping(value = "/trade/{tradeId:.+}", method = RequestMethod.PUT)
	public Object modifyTradeById(HttpServletResponse response,
			@PathVariable Integer tradeId,
			@ApiParam(value = "trade", required = true) @RequestBody Trade trade
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(trade, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Trade tempTrade = tradeService.queryTradeByTradeId(tradeId);
		trade.setTradeId(tradeId);
		if(null == tempTrade){
			throw new NotFoundException("消费清单");
		}
		return tradeService.modifyTrade(trade);
	}

	@ApiOperation(value = "删除 根据消费清单标识删除消费清单信息", notes = "根据消费清单标识删除消费清单信息")
	@RequestMapping(value = "/trade/{tradeId:.+}", method = RequestMethod.DELETE)
	public Object dropTradeByTradeId(HttpServletResponse response, @PathVariable Integer tradeId) {
		Trade trade = tradeService.queryTradeByTradeId(tradeId);
		if(null == trade){
			throw new NotFoundException("消费清单");
		}
		return tradeService.dropTradeByTradeId(tradeId);
	}
	
	@ApiOperation(value = "查询 根据消费清单标识查询消费清单信息", notes = "根据消费清单标识查询消费清单信息")
	@RequestMapping(value = "/trade/{tradeId:.+}", method = RequestMethod.GET)
	public Object queryTradeById(HttpServletResponse response,
			@PathVariable Integer tradeId) {
		Trade trade = tradeService.queryTradeByTradeId(tradeId);
		if(null == trade){
			throw new NotFoundException("消费清单");
		}
		return trade;
	}
	
	@ApiOperation(value = "查询 根据消费清单属性查询消费清单信息列表", notes = "根据消费清单属性查询消费清单信息列表")
	@RequestMapping(value = "/trade", method = RequestMethod.GET)
	public Object queryTradeList(HttpServletResponse response,
			Trade trade) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return tradeService.queryTradeByProperty(ClassUtil.transBean2Map(trade, false));
	}
	
	@ApiOperation(value = "查询分页 根据消费清单属性分页查询消费清单信息列表", notes = "根据消费清单属性分页查询消费清单信息列表")
	@RequestMapping(value = "/trades", method = RequestMethod.GET)
	public Object queryTradePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Trade trade) {				
		return tradeService.queryTradeForPage(pagenum, pagesize, sort, trade);
	}

}
