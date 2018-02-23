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
import com.jing.system.model.entity.RolePermission;
import com.jing.system.service.RolePermissionService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: RolePermissionController
 * @Description: 角色权限HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="角色权限", tags={"SystemRolePermission"})
public class RolePermissionController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private RolePermissionService rolePermissionService;

	
	@ApiOperation(value = "新增 添加角色权限信息", notes = "添加角色权限信息")
	@RequestMapping(value = "/rolepermission", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addRolePermission(HttpServletResponse response,
			@ApiParam(value = "rolePermission") @RequestBody RolePermission rolePermission) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(rolePermission, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		rolePermission.setRoleId(null);
		rolePermissionService.addRolePermission(rolePermission);
		return rolePermission;
	}
	
	
	@ApiOperation(value = "更新 根据角色权限标识更新角色权限信息", notes = "根据角色权限标识更新角色权限信息")
	@RequestMapping(value = "/rolepermission/{roleId:.+}", method = RequestMethod.PUT)
	public Object modifyRolePermissionById(HttpServletResponse response,
			@PathVariable Integer roleId,
			@ApiParam(value = "rolePermission", required = true) @RequestBody RolePermission rolePermission
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(rolePermission, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		RolePermission tempRolePermission = rolePermissionService.queryRolePermissionByRoleId(roleId);
		rolePermission.setRoleId(roleId);
		if(null == tempRolePermission){
			throw new NotFoundException("角色权限");
		}
		return rolePermissionService.modifyRolePermission(rolePermission);
	}

	@ApiOperation(value = "删除 根据角色权限标识删除角色权限信息", notes = "根据角色权限标识删除角色权限信息")
	@RequestMapping(value = "/rolepermission/{roleId:.+}", method = RequestMethod.DELETE)
	public Object dropRolePermissionByRoleId(HttpServletResponse response, @PathVariable Integer roleId) {
		RolePermission rolePermission = rolePermissionService.queryRolePermissionByRoleId(roleId);
		if(null == rolePermission){
			throw new NotFoundException("角色权限");
		}
		return rolePermissionService.dropRolePermissionByRoleId(roleId);
	}
	
	@ApiOperation(value = "查询 根据角色权限标识查询角色权限信息", notes = "根据角色权限标识查询角色权限信息")
	@RequestMapping(value = "/rolepermission/{roleId:.+}", method = RequestMethod.GET)
	public Object queryRolePermissionById(HttpServletResponse response,
			@PathVariable Integer roleId) {
		RolePermission rolePermission = rolePermissionService.queryRolePermissionByRoleId(roleId);
		if(null == rolePermission){
			throw new NotFoundException("角色权限");
		}
		return rolePermission;
	}
	
	@ApiOperation(value = "查询 根据角色权限属性查询角色权限信息列表", notes = "根据角色权限属性查询角色权限信息列表")
	@RequestMapping(value = "/rolepermission", method = RequestMethod.GET)
	public Object queryRolePermissionList(HttpServletResponse response,
			RolePermission rolePermission) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return rolePermissionService.queryRolePermissionByProperty(ClassUtil.transBean2Map(rolePermission, false));
	}
	
	@ApiOperation(value = "查询分页 根据角色权限属性分页查询角色权限信息列表", notes = "根据角色权限属性分页查询角色权限信息列表")
	@RequestMapping(value = "/rolepermissions", method = RequestMethod.GET)
	public Object queryRolePermissionPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, RolePermission rolePermission) {				
		return rolePermissionService.queryRolePermissionForPage(pagenum, pagesize, sort, rolePermission);
	}

}
