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
import com.jing.clock.model.entity.ClockBroadcast;
import com.jing.clock.service.ClockBroadcastService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ClockBroadcastController
 * @Description: 报钟播报HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="报钟播报")
public class ClockBroadcastController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private ClockBroadcastService clockBroadcastService;

	
	@ApiOperation(value = "新增 添加报钟播报信息", notes = "添加报钟播报信息")
	@RequestMapping(value = "/clockbroadcast", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addClockBroadcast(HttpServletResponse response,
			@ApiParam(value = "clockBroadcast") @RequestBody ClockBroadcast clockBroadcast) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(clockBroadcast, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		clockBroadcast.setBroadcastId(null);
		clockBroadcastService.addClockBroadcast(clockBroadcast);
		return clockBroadcast;
	}
	
	
	@ApiOperation(value = "更新 根据报钟播报标识更新报钟播报信息", notes = "根据报钟播报标识更新报钟播报信息")
	@RequestMapping(value = "/clockbroadcast/{broadcastId:.+}", method = RequestMethod.PUT)
	public Object modifyClockBroadcastById(HttpServletResponse response,
			@PathVariable Integer broadcastId,
			@ApiParam(value = "clockBroadcast", required = true) @RequestBody ClockBroadcast clockBroadcast
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(clockBroadcast, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		ClockBroadcast tempClockBroadcast = clockBroadcastService.queryClockBroadcastByBroadcastId(broadcastId);
		clockBroadcast.setBroadcastId(broadcastId);
		if(null == tempClockBroadcast){
			throw new NotFoundException("报钟播报");
		}
		return clockBroadcastService.modifyClockBroadcast(clockBroadcast);
	}

	@ApiOperation(value = "删除 根据报钟播报标识删除报钟播报信息", notes = "根据报钟播报标识删除报钟播报信息")
	@RequestMapping(value = "/clockbroadcast/{broadcastId:.+}", method = RequestMethod.DELETE)
	public Object dropClockBroadcastByBroadcastId(HttpServletResponse response, @PathVariable Integer broadcastId) {
		ClockBroadcast clockBroadcast = clockBroadcastService.queryClockBroadcastByBroadcastId(broadcastId);
		if(null == clockBroadcast){
			throw new NotFoundException("报钟播报");
		}
		return clockBroadcastService.dropClockBroadcastByBroadcastId(broadcastId);
	}
	
	@ApiOperation(value = "查询 根据报钟播报标识查询报钟播报信息", notes = "根据报钟播报标识查询报钟播报信息")
	@RequestMapping(value = "/clockbroadcast/{broadcastId:.+}", method = RequestMethod.GET)
	public Object queryClockBroadcastById(HttpServletResponse response,
			@PathVariable Integer broadcastId) {
		ClockBroadcast clockBroadcast = clockBroadcastService.queryClockBroadcastByBroadcastId(broadcastId);
		if(null == clockBroadcast){
			throw new NotFoundException("报钟播报");
		}
		return clockBroadcast;
	}
	
	@ApiOperation(value = "查询 根据报钟播报属性查询报钟播报信息列表", notes = "根据报钟播报属性查询报钟播报信息列表")
	@RequestMapping(value = "/clockbroadcast", method = RequestMethod.GET)
	public Object queryClockBroadcastList(HttpServletResponse response,
			ClockBroadcast clockBroadcast) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return clockBroadcastService.queryClockBroadcastByProperty(ClassUtil.transBean2Map(clockBroadcast, false));
	}
	
	@ApiOperation(value = "查询分页 根据报钟播报属性分页查询报钟播报信息列表", notes = "根据报钟播报属性分页查询报钟播报信息列表")
	@RequestMapping(value = "/clockbroadcasts", method = RequestMethod.GET)
	public Object queryClockBroadcastPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, ClockBroadcast clockBroadcast) {				
		return clockBroadcastService.queryClockBroadcastForPage(pagenum, pagesize, sort, clockBroadcast);
	}

}
