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
import com.jing.clock.model.entity.ClockRecord;
import com.jing.clock.service.ClockRecordService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ClockRecordController
 * @Description: 应钟记录HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="应钟记录")
public class ClockRecordController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private ClockRecordService clockRecordService;

	
	@ApiOperation(value = "新增 添加应钟记录信息", notes = "添加应钟记录信息")
	@RequestMapping(value = "/clockrecord", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addClockRecord(HttpServletResponse response,
			@ApiParam(value = "clockRecord") @RequestBody ClockRecord clockRecord) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(clockRecord, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		clockRecord.setRecordId(null);
		clockRecordService.addClockRecord(clockRecord);
		return clockRecord;
	}
	
	
	@ApiOperation(value = "更新 根据应钟记录标识更新应钟记录信息", notes = "根据应钟记录标识更新应钟记录信息")
	@RequestMapping(value = "/clockrecord/{recordId:.+}", method = RequestMethod.PUT)
	public Object modifyClockRecordById(HttpServletResponse response,
			@PathVariable Integer recordId,
			@ApiParam(value = "clockRecord", required = true) @RequestBody ClockRecord clockRecord
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(clockRecord, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		ClockRecord tempClockRecord = clockRecordService.queryClockRecordByRecordId(recordId);
		clockRecord.setRecordId(recordId);
		if(null == tempClockRecord){
			throw new NotFoundException("应钟记录");
		}
		return clockRecordService.modifyClockRecord(clockRecord);
	}

	@ApiOperation(value = "删除 根据应钟记录标识删除应钟记录信息", notes = "根据应钟记录标识删除应钟记录信息")
	@RequestMapping(value = "/clockrecord/{recordId:.+}", method = RequestMethod.DELETE)
	public Object dropClockRecordByRecordId(HttpServletResponse response, @PathVariable Integer recordId) {
		ClockRecord clockRecord = clockRecordService.queryClockRecordByRecordId(recordId);
		if(null == clockRecord){
			throw new NotFoundException("应钟记录");
		}
		return clockRecordService.dropClockRecordByRecordId(recordId);
	}
	
	@ApiOperation(value = "查询 根据应钟记录标识查询应钟记录信息", notes = "根据应钟记录标识查询应钟记录信息")
	@RequestMapping(value = "/clockrecord/{recordId:.+}", method = RequestMethod.GET)
	public Object queryClockRecordById(HttpServletResponse response,
			@PathVariable Integer recordId) {
		ClockRecord clockRecord = clockRecordService.queryClockRecordByRecordId(recordId);
		if(null == clockRecord){
			throw new NotFoundException("应钟记录");
		}
		return clockRecord;
	}
	
	@ApiOperation(value = "查询 根据应钟记录属性查询应钟记录信息列表", notes = "根据应钟记录属性查询应钟记录信息列表")
	@RequestMapping(value = "/clockrecord", method = RequestMethod.GET)
	public Object queryClockRecordList(HttpServletResponse response,
			ClockRecord clockRecord) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return clockRecordService.queryClockRecordByProperty(ClassUtil.transBean2Map(clockRecord, false));
	}
	
	@ApiOperation(value = "查询分页 根据应钟记录属性分页查询应钟记录信息列表", notes = "根据应钟记录属性分页查询应钟记录信息列表")
	@RequestMapping(value = "/clockrecords", method = RequestMethod.GET)
	public Object queryClockRecordPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, ClockRecord clockRecord) {				
		return clockRecordService.queryClockRecordForPage(pagenum, pagesize, sort, clockRecord);
	}

}
