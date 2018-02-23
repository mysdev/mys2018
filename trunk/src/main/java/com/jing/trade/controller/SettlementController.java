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
import com.jing.trade.model.entity.Settlement;
import com.jing.trade.service.SettlementService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: SettlementController
 * @Description: 消费结算HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="消费结算", tags={"TradeSettlement"})
public class SettlementController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private SettlementService settlementService;

	
	@ApiOperation(value = "新增 添加消费结算信息", notes = "添加消费结算信息")
	@RequestMapping(value = "/settlement", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addSettlement(HttpServletResponse response,
			@ApiParam(value = "settlement") @RequestBody Settlement settlement) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(settlement, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		settlement.setSettlementId(null);
		settlementService.addSettlement(settlement);
		return settlement;
	}
	
	
	@ApiOperation(value = "更新 根据消费结算标识更新消费结算信息", notes = "根据消费结算标识更新消费结算信息")
	@RequestMapping(value = "/settlement/{settlementId:.+}", method = RequestMethod.PUT)
	public Object modifySettlementById(HttpServletResponse response,
			@PathVariable Integer settlementId,
			@ApiParam(value = "settlement", required = true) @RequestBody Settlement settlement
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(settlement, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Settlement tempSettlement = settlementService.querySettlementBySettlementId(settlementId);
		settlement.setSettlementId(settlementId);
		if(null == tempSettlement){
			throw new NotFoundException("消费结算");
		}
		return settlementService.modifySettlement(settlement);
	}

	@ApiOperation(value = "删除 根据消费结算标识删除消费结算信息", notes = "根据消费结算标识删除消费结算信息")
	@RequestMapping(value = "/settlement/{settlementId:.+}", method = RequestMethod.DELETE)
	public Object dropSettlementBySettlementId(HttpServletResponse response, @PathVariable Integer settlementId) {
		Settlement settlement = settlementService.querySettlementBySettlementId(settlementId);
		if(null == settlement){
			throw new NotFoundException("消费结算");
		}
		return settlementService.dropSettlementBySettlementId(settlementId);
	}
	
	@ApiOperation(value = "查询 根据消费结算标识查询消费结算信息", notes = "根据消费结算标识查询消费结算信息")
	@RequestMapping(value = "/settlement/{settlementId:.+}", method = RequestMethod.GET)
	public Object querySettlementById(HttpServletResponse response,
			@PathVariable Integer settlementId) {
		Settlement settlement = settlementService.querySettlementBySettlementId(settlementId);
		if(null == settlement){
			throw new NotFoundException("消费结算");
		}
		return settlement;
	}
	
	@ApiOperation(value = "查询 根据消费结算属性查询消费结算信息列表", notes = "根据消费结算属性查询消费结算信息列表")
	@RequestMapping(value = "/settlement", method = RequestMethod.GET)
	public Object querySettlementList(HttpServletResponse response,
			Settlement settlement) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return settlementService.querySettlementByProperty(ClassUtil.transBean2Map(settlement, false));
	}
	
	@ApiOperation(value = "查询分页 根据消费结算属性分页查询消费结算信息列表", notes = "根据消费结算属性分页查询消费结算信息列表")
	@RequestMapping(value = "/settlements", method = RequestMethod.GET)
	public Object querySettlementPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Settlement settlement) {				
		return settlementService.querySettlementForPage(pagenum, pagesize, sort, settlement);
	}

}
