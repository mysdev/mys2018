package com.jing.core.controller;

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
import com.jing.core.model.entity.ReservationTrade;
import com.jing.core.service.ReservationTradeService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ReservationTradeController
 * @Description: 消费商品详情HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="消费商品详情")
public class ReservationTradeController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private ReservationTradeService reservationTradeService;

	
	@ApiOperation(value = "新增 添加消费商品详情信息", notes = "添加消费商品详情信息")
	@RequestMapping(value = "/reservationtrade", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addReservationTrade(HttpServletResponse response,
			@ApiParam(value = "reservationTrade") @RequestBody ReservationTrade reservationTrade) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(reservationTrade, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		reservationTrade.setDetailId(null);
		reservationTradeService.addReservationTrade(reservationTrade);
		return reservationTrade;
	}
	
	
	@ApiOperation(value = "更新 根据消费商品详情标识更新消费商品详情信息", notes = "根据消费商品详情标识更新消费商品详情信息")
	@RequestMapping(value = "/reservationtrade/{detailId:.+}", method = RequestMethod.PUT)
	public Object modifyReservationTradeById(HttpServletResponse response,
			@PathVariable Integer detailId,
			@ApiParam(value = "reservationTrade", required = true) @RequestBody ReservationTrade reservationTrade
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(reservationTrade, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		ReservationTrade tempReservationTrade = reservationTradeService.queryReservationTradeByDetailId(detailId);
		reservationTrade.setDetailId(detailId);
		if(null == tempReservationTrade){
			throw new NotFoundException("消费商品详情");
		}
		return reservationTradeService.modifyReservationTrade(reservationTrade);
	}

	@ApiOperation(value = "删除 根据消费商品详情标识删除消费商品详情信息", notes = "根据消费商品详情标识删除消费商品详情信息")
	@RequestMapping(value = "/reservationtrade/{detailId:.+}", method = RequestMethod.DELETE)
	public Object dropReservationTradeByDetailId(HttpServletResponse response, @PathVariable Integer detailId) {
		ReservationTrade reservationTrade = reservationTradeService.queryReservationTradeByDetailId(detailId);
		if(null == reservationTrade){
			throw new NotFoundException("消费商品详情");
		}
		return reservationTradeService.dropReservationTradeByDetailId(detailId);
	}
	
	@ApiOperation(value = "查询 根据消费商品详情标识查询消费商品详情信息", notes = "根据消费商品详情标识查询消费商品详情信息")
	@RequestMapping(value = "/reservationtrade/{detailId:.+}", method = RequestMethod.GET)
	public Object queryReservationTradeById(HttpServletResponse response,
			@PathVariable Integer detailId) {
		ReservationTrade reservationTrade = reservationTradeService.queryReservationTradeByDetailId(detailId);
		if(null == reservationTrade){
			throw new NotFoundException("消费商品详情");
		}
		return reservationTrade;
	}
	
	@ApiOperation(value = "查询 根据消费商品详情属性查询消费商品详情信息列表", notes = "根据消费商品详情属性查询消费商品详情信息列表")
	@RequestMapping(value = "/reservationtrade", method = RequestMethod.GET)
	public Object queryReservationTradeList(HttpServletResponse response,
			ReservationTrade reservationTrade) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return reservationTradeService.queryReservationTradeByProperty(ClassUtil.transBean2Map(reservationTrade, false));
	}
	
	@ApiOperation(value = "查询分页 根据消费商品详情属性分页查询消费商品详情信息列表", notes = "根据消费商品详情属性分页查询消费商品详情信息列表")
	@RequestMapping(value = "/reservationtrades", method = RequestMethod.GET)
	public Object queryReservationTradePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, ReservationTrade reservationTrade) {				
		return reservationTradeService.queryReservationTradeForPage(pagenum, pagesize, sort, reservationTrade);
	}

}
