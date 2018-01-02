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
import com.jing.system.model.entity.User;
import com.jing.system.service.UserService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: UserController
 * @Description: 用户HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@RestController
@Api(description="用户")
public class UserController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private UserService userService;

	
	@ApiOperation(value = "新增 添加用户信息", notes = "添加用户信息")
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addUser(HttpServletResponse response,
			@ApiParam(value = "user") @RequestBody User user) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(user, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		user.setUserId(null);
		userService.addUser(user);
		return user;
	}
	
	
	@ApiOperation(value = "更新 根据用户标识更新用户信息", notes = "根据用户标识更新用户信息")
	@RequestMapping(value = "/user/{userId:.+}", method = RequestMethod.PUT)
	public Object modifyUserById(HttpServletResponse response,
			@PathVariable Integer userId,
			@ApiParam(value = "user", required = true) @RequestBody User user
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(user, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		User tempUser = userService.queryUserByUserId(userId);
		user.setUserId(userId);
		if(null == tempUser){
			throw new NotFoundException("用户");
		}
		return userService.modifyUser(user);
	}

	@ApiOperation(value = "删除 根据用户标识删除用户信息", notes = "根据用户标识删除用户信息")
	@RequestMapping(value = "/user/{userId:.+}", method = RequestMethod.DELETE)
	public Object dropUserByUserId(HttpServletResponse response, @PathVariable Integer userId) {
		User user = userService.queryUserByUserId(userId);
		if(null == user){
			throw new NotFoundException("用户");
		}
		return userService.dropUserByUserId(userId);
	}
	
	@ApiOperation(value = "查询 根据用户标识查询用户信息", notes = "根据用户标识查询用户信息")
	@RequestMapping(value = "/user/{userId:.+}", method = RequestMethod.GET)
	public Object queryUserById(HttpServletResponse response,
			@PathVariable Integer userId) {
		User user = userService.queryUserByUserId(userId);
		if(null == user){
			throw new NotFoundException("用户");
		}
		return user;
	}
	
	@ApiOperation(value = "查询 根据用户属性查询用户信息列表", notes = "根据用户属性查询用户信息列表")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Object queryUserList(HttpServletResponse response,
			User user) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return userService.queryUserByProperty(ClassUtil.transBean2Map(user, false));
	}
	
	@ApiOperation(value = "查询分页 根据用户属性分页查询用户信息列表", notes = "根据用户属性分页查询用户信息列表")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Object queryUserPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, User user) {				
		return userService.queryUserForPage(pagenum, pagesize, sort, user);
	}

}
