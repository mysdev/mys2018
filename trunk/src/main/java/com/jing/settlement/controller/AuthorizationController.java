package com.jing.settlement.controller;

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
import com.jing.settlement.model.entity.Authorization;
import com.jing.settlement.service.AuthorizationService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: AuthorizationController
 * @Description: 消费授权HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="消费授权", tags={"SettlementAuthorization"})
public class AuthorizationController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private AuthorizationService authorizationService;

	
	@ApiOperation(value = "新增 添加消费授权信息", notes = "添加消费授权信息")
	@RequestMapping(value = "/authorization", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addAuthorization(HttpServletResponse response,
			@ApiParam(value = "authorization") @RequestBody Authorization authorization) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(authorization, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		authorization.setAuthorizationId(null);
		authorizationService.addAuthorization(authorization);
		return authorization;
	}
	
	
	@ApiOperation(value = "更新 根据消费授权标识更新消费授权信息", notes = "根据消费授权标识更新消费授权信息")
	@RequestMapping(value = "/authorization/{authorizationId:.+}", method = RequestMethod.PUT)
	public Object modifyAuthorizationById(HttpServletResponse response,
			@PathVariable String authorizationId,
			@ApiParam(value = "authorization", required = true) @RequestBody Authorization authorization
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(authorization, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Authorization tempAuthorization = authorizationService.queryAuthorizationByAuthorizationId(authorizationId);
		authorization.setAuthorizationId(authorizationId);
		if(null == tempAuthorization){
			throw new NotFoundException("消费授权");
		}
		return authorizationService.modifyAuthorization(authorization);
	}

	@ApiOperation(value = "删除 根据消费授权标识删除消费授权信息", notes = "根据消费授权标识删除消费授权信息")
	@RequestMapping(value = "/authorization/{authorizationId:.+}", method = RequestMethod.DELETE)
	public Object dropAuthorizationByAuthorizationId(HttpServletResponse response, @PathVariable String authorizationId) {
		Authorization authorization = authorizationService.queryAuthorizationByAuthorizationId(authorizationId);
		if(null == authorization){
			throw new NotFoundException("消费授权");
		}
		return authorizationService.dropAuthorizationByAuthorizationId(authorizationId);
	}
	
	@ApiOperation(value = "查询 根据消费授权标识查询消费授权信息", notes = "根据消费授权标识查询消费授权信息")
	@RequestMapping(value = "/authorization/{authorizationId:.+}", method = RequestMethod.GET)
	public Object queryAuthorizationById(HttpServletResponse response,
			@PathVariable String authorizationId) {
		Authorization authorization = authorizationService.queryAuthorizationByAuthorizationId(authorizationId);
		if(null == authorization){
			throw new NotFoundException("消费授权");
		}
		return authorization;
	}
	
	@ApiOperation(value = "查询 根据消费授权属性查询消费授权信息列表", notes = "根据消费授权属性查询消费授权信息列表")
	@RequestMapping(value = "/authorization", method = RequestMethod.GET)
	public Object queryAuthorizationList(HttpServletResponse response,
			Authorization authorization) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return authorizationService.queryAuthorizationByProperty(ClassUtil.transBean2Map(authorization, false));
	}
	
	@ApiOperation(value = "查询分页 根据消费授权属性分页查询消费授权信息列表", notes = "根据消费授权属性分页查询消费授权信息列表")
	@RequestMapping(value = "/authorizations", method = RequestMethod.GET)
	public Object queryAuthorizationPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Authorization authorization) {				
		return authorizationService.queryAuthorizationForPage(pagenum, pagesize, sort, authorization);
	}

}
