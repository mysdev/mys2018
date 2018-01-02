package com.jing.system.controller;

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
import com.jing.system.model.entity.Log;
import com.jing.system.service.LogService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: LogController
 * @Description: 日志HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@RestController
@Api(description="日志")
public class LogController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private LogService logService;

	
	@ApiOperation(value = "新增 添加日志信息", notes = "添加日志信息")
	@RequestMapping(value = "/log", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addLog(HttpServletResponse response,
			@ApiParam(value = "log") @RequestBody Log log) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(log, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		log.setLogId(null);
		logService.addLog(log);
		return log;
	}
	
	
	@ApiOperation(value = "更新 根据日志标识更新日志信息", notes = "根据日志标识更新日志信息")
	@RequestMapping(value = "/log/{logId:.+}", method = RequestMethod.PUT)
	public Object modifyLogById(HttpServletResponse response,
			@PathVariable Integer logId,
			@ApiParam(value = "log", required = true) @RequestBody Log log
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(log, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Log tempLog = logService.queryLogByLogId(logId);
		log.setLogId(logId);
		if(null == tempLog){
			throw new NotFoundException("日志");
		}
		return logService.modifyLog(log);
	}

	@ApiOperation(value = "删除 根据日志标识删除日志信息", notes = "根据日志标识删除日志信息")
	@RequestMapping(value = "/log/{logId:.+}", method = RequestMethod.DELETE)
	public Object dropLogByLogId(HttpServletResponse response, @PathVariable Integer logId) {
		Log log = logService.queryLogByLogId(logId);
		if(null == log){
			throw new NotFoundException("日志");
		}
		return logService.dropLogByLogId(logId);
	}
	
	@ApiOperation(value = "查询 根据日志标识查询日志信息", notes = "根据日志标识查询日志信息")
	@RequestMapping(value = "/log/{logId:.+}", method = RequestMethod.GET)
	public Object queryLogById(HttpServletResponse response,
			@PathVariable Integer logId) {
		Log log = logService.queryLogByLogId(logId);
		if(null == log){
			throw new NotFoundException("日志");
		}
		return log;
	}
	
	@ApiOperation(value = "查询 根据日志属性查询日志信息列表", notes = "根据日志属性查询日志信息列表")
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public Object queryLogList(HttpServletResponse response,
			Log log) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return logService.queryLogByProperty(ClassUtil.transBean2Map(log, false));
	}
	
	@ApiOperation(value = "查询分页 根据日志属性分页查询日志信息列表", notes = "根据日志属性分页查询日志信息列表")
	@RequestMapping(value = "/logs", method = RequestMethod.GET)
	public Object queryLogPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Log log) {				
		return logService.queryLogForPage(pagenum, pagesize, sort, log);
	}

}
