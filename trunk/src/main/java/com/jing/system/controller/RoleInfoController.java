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
import com.jing.system.model.entity.RoleInfo;
import com.jing.system.service.RoleInfoService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: RoleInfoController
 * @Description: 角色HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="角色")
public class RoleInfoController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private RoleInfoService roleInfoService;

	
	@ApiOperation(value = "新增 添加角色信息", notes = "添加角色信息")
	@RequestMapping(value = "/roleinfo", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addRoleInfo(HttpServletResponse response,
			@ApiParam(value = "roleInfo") @RequestBody RoleInfo roleInfo) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(roleInfo, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		roleInfo.setRoleId(null);
		roleInfoService.addRoleInfo(roleInfo);
		return roleInfo;
	}
	
	
	@ApiOperation(value = "更新 根据角色标识更新角色信息", notes = "根据角色标识更新角色信息")
	@RequestMapping(value = "/roleinfo/{roleId:.+}", method = RequestMethod.PUT)
	public Object modifyRoleInfoById(HttpServletResponse response,
			@PathVariable Integer roleId,
			@ApiParam(value = "roleInfo", required = true) @RequestBody RoleInfo roleInfo
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(roleInfo, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		RoleInfo tempRoleInfo = roleInfoService.queryRoleInfoByRoleId(roleId);
		roleInfo.setRoleId(roleId);
		if(null == tempRoleInfo){
			throw new NotFoundException("角色");
		}
		return roleInfoService.modifyRoleInfo(roleInfo);
	}

	@ApiOperation(value = "删除 根据角色标识删除角色信息", notes = "根据角色标识删除角色信息")
	@RequestMapping(value = "/roleinfo/{roleId:.+}", method = RequestMethod.DELETE)
	public Object dropRoleInfoByRoleId(HttpServletResponse response, @PathVariable Integer roleId) {
		RoleInfo roleInfo = roleInfoService.queryRoleInfoByRoleId(roleId);
		if(null == roleInfo){
			throw new NotFoundException("角色");
		}
		return roleInfoService.dropRoleInfoByRoleId(roleId);
	}
	
	@ApiOperation(value = "查询 根据角色标识查询角色信息", notes = "根据角色标识查询角色信息")
	@RequestMapping(value = "/roleinfo/{roleId:.+}", method = RequestMethod.GET)
	public Object queryRoleInfoById(HttpServletResponse response,
			@PathVariable Integer roleId) {
		RoleInfo roleInfo = roleInfoService.queryRoleInfoByRoleId(roleId);
		if(null == roleInfo){
			throw new NotFoundException("角色");
		}
		return roleInfo;
	}
	
	@ApiOperation(value = "查询 根据角色属性查询角色信息列表", notes = "根据角色属性查询角色信息列表")
	@RequestMapping(value = "/roleinfo", method = RequestMethod.GET)
	public Object queryRoleInfoList(HttpServletResponse response,
			RoleInfo roleInfo) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return roleInfoService.queryRoleInfoByProperty(ClassUtil.transBean2Map(roleInfo, false));
	}
	
	@ApiOperation(value = "查询分页 根据角色属性分页查询角色信息列表", notes = "根据角色属性分页查询角色信息列表")
	@RequestMapping(value = "/roleinfos", method = RequestMethod.GET)
	public Object queryRoleInfoPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, RoleInfo roleInfo) {				
		return roleInfoService.queryRoleInfoForPage(pagenum, pagesize, sort, roleInfo);
	}

}
