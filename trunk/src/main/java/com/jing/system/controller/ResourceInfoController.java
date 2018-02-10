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
import com.jing.system.model.entity.ResourceInfo;
import com.jing.system.service.ResourceInfoService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ResourceInfoController
 * @Description: 资源菜单HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="资源菜单", tags={"SystemResourceInfo"})
public class ResourceInfoController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private ResourceInfoService resourceInfoService;

	
	@ApiOperation(value = "新增 添加资源菜单信息", notes = "添加资源菜单信息")
	@RequestMapping(value = "/resourceinfo", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addResourceInfo(HttpServletResponse response,
			@ApiParam(value = "resourceInfo") @RequestBody ResourceInfo resourceInfo) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(resourceInfo, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		resourceInfo.setResourceId(null);
		resourceInfoService.addResourceInfo(resourceInfo);
		return resourceInfo;
	}
	
	
	@ApiOperation(value = "更新 根据资源菜单标识更新资源菜单信息", notes = "根据资源菜单标识更新资源菜单信息")
	@RequestMapping(value = "/resourceinfo/{resourceId:.+}", method = RequestMethod.PUT)
	public Object modifyResourceInfoById(HttpServletResponse response,
			@PathVariable Integer resourceId,
			@ApiParam(value = "resourceInfo", required = true) @RequestBody ResourceInfo resourceInfo
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(resourceInfo, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		ResourceInfo tempResourceInfo = resourceInfoService.queryResourceInfoByResourceId(resourceId);
		resourceInfo.setResourceId(resourceId);
		if(null == tempResourceInfo){
			throw new NotFoundException("资源菜单");
		}
		return resourceInfoService.modifyResourceInfo(resourceInfo);
	}

	@ApiOperation(value = "删除 根据资源菜单标识删除资源菜单信息", notes = "根据资源菜单标识删除资源菜单信息")
	@RequestMapping(value = "/resourceinfo/{resourceId:.+}", method = RequestMethod.DELETE)
	public Object dropResourceInfoByResourceId(HttpServletResponse response, @PathVariable Integer resourceId) {
		ResourceInfo resourceInfo = resourceInfoService.queryResourceInfoByResourceId(resourceId);
		if(null == resourceInfo){
			throw new NotFoundException("资源菜单");
		}
		return resourceInfoService.dropResourceInfoByResourceId(resourceId);
	}
	
	@ApiOperation(value = "查询 根据资源菜单标识查询资源菜单信息", notes = "根据资源菜单标识查询资源菜单信息")
	@RequestMapping(value = "/resourceinfo/{resourceId:.+}", method = RequestMethod.GET)
	public Object queryResourceInfoById(HttpServletResponse response,
			@PathVariable Integer resourceId) {
		ResourceInfo resourceInfo = resourceInfoService.queryResourceInfoByResourceId(resourceId);
		if(null == resourceInfo){
			throw new NotFoundException("资源菜单");
		}
		return resourceInfo;
	}
	
	@ApiOperation(value = "查询 根据资源菜单属性查询资源菜单信息列表", notes = "根据资源菜单属性查询资源菜单信息列表")
	@RequestMapping(value = "/resourceinfo", method = RequestMethod.GET)
	public Object queryResourceInfoList(HttpServletResponse response,
			ResourceInfo resourceInfo) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return resourceInfoService.queryResourceInfoByProperty(ClassUtil.transBean2Map(resourceInfo, false));
	}
	
	@ApiOperation(value = "查询分页 根据资源菜单属性分页查询资源菜单信息列表", notes = "根据资源菜单属性分页查询资源菜单信息列表")
	@RequestMapping(value = "/resourceinfos", method = RequestMethod.GET)
	public Object queryResourceInfoPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, ResourceInfo resourceInfo) {				
		return resourceInfoService.queryResourceInfoForPage(pagenum, pagesize, sort, resourceInfo);
	}

}
