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
import com.jing.system.model.entity.UserGroup;
import com.jing.system.service.UserGroupService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: UserGroupController
 * @Description: 用户组HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
@RestController
@Api(description="用户组")
public class UserGroupController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private UserGroupService userGroupService;

	
	@ApiOperation(value = "新增 添加用户组信息", notes = "添加用户组信息")
	@RequestMapping(value = "/usergroup", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addUserGroup(HttpServletResponse response,
			@ApiParam(value = "userGroup") @RequestBody UserGroup userGroup) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(userGroup, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		userGroup.setTeamId(null);
		userGroupService.addUserGroup(userGroup);
		return userGroup;
	}
	
	
	@ApiOperation(value = "更新 根据用户组标识更新用户组信息", notes = "根据用户组标识更新用户组信息")
	@RequestMapping(value = "/usergroup/{teamId:.+}", method = RequestMethod.PUT)
	public Object modifyUserGroupById(HttpServletResponse response,
			@PathVariable Integer teamId,
			@ApiParam(value = "userGroup", required = true) @RequestBody UserGroup userGroup
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(userGroup, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		UserGroup tempUserGroup = userGroupService.queryUserGroupByTeamId(teamId);
		userGroup.setTeamId(teamId);
		if(null == tempUserGroup){
			throw new NotFoundException("用户组");
		}
		return userGroupService.modifyUserGroup(userGroup);
	}

	@ApiOperation(value = "删除 根据用户组标识删除用户组信息", notes = "根据用户组标识删除用户组信息")
	@RequestMapping(value = "/usergroup/{teamId:.+}", method = RequestMethod.DELETE)
	public Object dropUserGroupByTeamId(HttpServletResponse response, @PathVariable Integer teamId) {
		UserGroup userGroup = userGroupService.queryUserGroupByTeamId(teamId);
		if(null == userGroup){
			throw new NotFoundException("用户组");
		}
		return userGroupService.dropUserGroupByTeamId(teamId);
	}
	
	@ApiOperation(value = "查询 根据用户组标识查询用户组信息", notes = "根据用户组标识查询用户组信息")
	@RequestMapping(value = "/usergroup/{teamId:.+}", method = RequestMethod.GET)
	public Object queryUserGroupById(HttpServletResponse response,
			@PathVariable Integer teamId) {
		UserGroup userGroup = userGroupService.queryUserGroupByTeamId(teamId);
		if(null == userGroup){
			throw new NotFoundException("用户组");
		}
		return userGroup;
	}
	
	@ApiOperation(value = "查询 根据用户组属性查询用户组信息列表", notes = "根据用户组属性查询用户组信息列表")
	@RequestMapping(value = "/usergroup", method = RequestMethod.GET)
	public Object queryUserGroupList(HttpServletResponse response,
			UserGroup userGroup) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return userGroupService.queryUserGroupByProperty(ClassUtil.transBean2Map(userGroup, false));
	}
	
	@ApiOperation(value = "查询分页 根据用户组属性分页查询用户组信息列表", notes = "根据用户组属性分页查询用户组信息列表")
	@RequestMapping(value = "/usergroups", method = RequestMethod.GET)
	public Object queryUserGroupPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, UserGroup userGroup) {				
		return userGroupService.queryUserGroupForPage(pagenum, pagesize, sort, userGroup);
	}

}
