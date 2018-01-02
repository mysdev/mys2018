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
import com.jing.system.model.entity.Config;
import com.jing.system.service.ConfigService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ConfigController
 * @Description: 系统配置HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@RestController
@Api(description="系统配置")
public class ConfigController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private ConfigService configService;

	
	@ApiOperation(value = "新增 添加系统配置信息", notes = "添加系统配置信息")
	@RequestMapping(value = "/config", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addConfig(HttpServletResponse response,
			@ApiParam(value = "config") @RequestBody Config config) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(config, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		config.setPropertyId(null);
		configService.addConfig(config);
		return config;
	}
	
	
	@ApiOperation(value = "更新 根据系统配置标识更新系统配置信息", notes = "根据系统配置标识更新系统配置信息")
	@RequestMapping(value = "/config/{propertyId:.+}", method = RequestMethod.PUT)
	public Object modifyConfigById(HttpServletResponse response,
			@PathVariable Integer propertyId,
			@ApiParam(value = "config", required = true) @RequestBody Config config
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(config, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Config tempConfig = configService.queryConfigByPropertyId(propertyId);
		config.setPropertyId(propertyId);
		if(null == tempConfig){
			throw new NotFoundException("系统配置");
		}
		return configService.modifyConfig(config);
	}

	@ApiOperation(value = "删除 根据系统配置标识删除系统配置信息", notes = "根据系统配置标识删除系统配置信息")
	@RequestMapping(value = "/config/{propertyId:.+}", method = RequestMethod.DELETE)
	public Object dropConfigByPropertyId(HttpServletResponse response, @PathVariable Integer propertyId) {
		Config config = configService.queryConfigByPropertyId(propertyId);
		if(null == config){
			throw new NotFoundException("系统配置");
		}
		return configService.dropConfigByPropertyId(propertyId);
	}
	
	@ApiOperation(value = "查询 根据系统配置标识查询系统配置信息", notes = "根据系统配置标识查询系统配置信息")
	@RequestMapping(value = "/config/{propertyId:.+}", method = RequestMethod.GET)
	public Object queryConfigById(HttpServletResponse response,
			@PathVariable Integer propertyId) {
		Config config = configService.queryConfigByPropertyId(propertyId);
		if(null == config){
			throw new NotFoundException("系统配置");
		}
		return config;
	}
	
	@ApiOperation(value = "查询 根据系统配置属性查询系统配置信息列表", notes = "根据系统配置属性查询系统配置信息列表")
	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public Object queryConfigList(HttpServletResponse response,
			Config config) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return configService.queryConfigByProperty(ClassUtil.transBean2Map(config, false));
	}
	
	@ApiOperation(value = "查询分页 根据系统配置属性分页查询系统配置信息列表", notes = "根据系统配置属性分页查询系统配置信息列表")
	@RequestMapping(value = "/configs", method = RequestMethod.GET)
	public Object queryConfigPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Config config) {				
		return configService.queryConfigForPage(pagenum, pagesize, sort, config);
	}

}
