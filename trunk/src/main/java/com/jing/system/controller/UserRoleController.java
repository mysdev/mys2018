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
import com.jing.system.model.entity.UserRole;
import com.jing.system.service.UserRoleService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: UserRoleController
 * @Description: 用户权限HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="用户权限", tags={"SystemUserRole"})
public class UserRoleController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private UserRoleService userRoleService;

	
	@ApiOperation(value = "新增 添加用户权限信息", notes = "添加用户权限信息")
	@RequestMapping(value = "/userrole", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addUserRole(HttpServletResponse response,
			@ApiParam(value = "userRole") @RequestBody UserRole userRole) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(userRole, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		userRole.setUserId(null);
		userRoleService.addUserRole(userRole);
		return userRole;
	}
	
	
	@ApiOperation(value = "更新 根据用户权限标识更新用户权限信息", notes = "根据用户权限标识更新用户权限信息")
	@RequestMapping(value = "/userrole/{userId:.+}", method = RequestMethod.PUT)
	public Object modifyUserRoleById(HttpServletResponse response,
			@PathVariable Integer userId,
			@ApiParam(value = "userRole", required = true) @RequestBody UserRole userRole
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(userRole, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		UserRole tempUserRole = userRoleService.queryUserRoleByUserId(userId);
		userRole.setUserId(userId);
		if(null == tempUserRole){
			throw new NotFoundException("用户权限");
		}
		return userRoleService.modifyUserRole(userRole);
	}

	@ApiOperation(value = "删除 根据用户权限标识删除用户权限信息", notes = "根据用户权限标识删除用户权限信息")
	@RequestMapping(value = "/userrole/{userId:.+}", method = RequestMethod.DELETE)
	public Object dropUserRoleByUserId(HttpServletResponse response, @PathVariable Integer userId) {
		UserRole userRole = userRoleService.queryUserRoleByUserId(userId);
		if(null == userRole){
			throw new NotFoundException("用户权限");
		}
		return userRoleService.dropUserRoleByUserId(userId);
	}
	
	@ApiOperation(value = "查询 根据用户权限标识查询用户权限信息", notes = "根据用户权限标识查询用户权限信息")
	@RequestMapping(value = "/userrole/{userId:.+}", method = RequestMethod.GET)
	public Object queryUserRoleById(HttpServletResponse response,
			@PathVariable Integer userId) {
		UserRole userRole = userRoleService.queryUserRoleByUserId(userId);
		if(null == userRole){
			throw new NotFoundException("用户权限");
		}
		return userRole;
	}
	
	@ApiOperation(value = "查询 根据用户权限属性查询用户权限信息列表", notes = "根据用户权限属性查询用户权限信息列表")
	@RequestMapping(value = "/userrole", method = RequestMethod.GET)
	public Object queryUserRoleList(HttpServletResponse response,
			UserRole userRole) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return userRoleService.queryUserRoleByProperty(ClassUtil.transBean2Map(userRole, false));
	}
	
	@ApiOperation(value = "查询分页 根据用户权限属性分页查询用户权限信息列表", notes = "根据用户权限属性分页查询用户权限信息列表")
	@RequestMapping(value = "/userroles", method = RequestMethod.GET)
	public Object queryUserRolePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, UserRole userRole) {				
		return userRoleService.queryUserRoleForPage(pagenum, pagesize, sort, userRole);
	}

}
