package com.jing.core.controller;

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
import com.jing.core.model.entity.Types;
import com.jing.core.service.TypesService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TypesController
 * @Description: 类型配置HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="类型配置")
public class TypesController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private TypesService typesService;

	
	@ApiOperation(value = "新增 添加类型配置信息", notes = "添加类型配置信息")
	@RequestMapping(value = "/types", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTypes(HttpServletResponse response,
			@ApiParam(value = "types") @RequestBody Types types) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(types, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		types.setTypeId(null);
		typesService.addTypes(types);
		return types;
	}
	
	
	@ApiOperation(value = "更新 根据类型配置标识更新类型配置信息", notes = "根据类型配置标识更新类型配置信息")
	@RequestMapping(value = "/types/{typeId:.+}", method = RequestMethod.PUT)
	public Object modifyTypesById(HttpServletResponse response,
			@PathVariable Integer typeId,
			@ApiParam(value = "types", required = true) @RequestBody Types types
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(types, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Types tempTypes = typesService.queryTypesByTypeId(typeId);
		types.setTypeId(typeId);
		if(null == tempTypes){
			throw new NotFoundException("类型配置");
		}
		return typesService.modifyTypes(types);
	}

	@ApiOperation(value = "删除 根据类型配置标识删除类型配置信息", notes = "根据类型配置标识删除类型配置信息")
	@RequestMapping(value = "/types/{typeId:.+}", method = RequestMethod.DELETE)
	public Object dropTypesByTypeId(HttpServletResponse response, @PathVariable Integer typeId) {
		Types types = typesService.queryTypesByTypeId(typeId);
		if(null == types){
			throw new NotFoundException("类型配置");
		}
		return typesService.dropTypesByTypeId(typeId);
	}
	
	@ApiOperation(value = "查询 根据类型配置标识查询类型配置信息", notes = "根据类型配置标识查询类型配置信息")
	@RequestMapping(value = "/types/{typeId:.+}", method = RequestMethod.GET)
	public Object queryTypesById(HttpServletResponse response,
			@PathVariable Integer typeId) {
		Types types = typesService.queryTypesByTypeId(typeId);
		if(null == types){
			throw new NotFoundException("类型配置");
		}
		return types;
	}
	
	@ApiOperation(value = "查询 根据类型配置属性查询类型配置信息列表", notes = "根据类型配置属性查询类型配置信息列表")
	@RequestMapping(value = "/types", method = RequestMethod.GET)
	public Object queryTypesList(HttpServletResponse response,
			Types types) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return typesService.queryTypesByProperty(ClassUtil.transBean2Map(types, false));
	}
	
	@ApiOperation(value = "查询分页 根据类型配置属性分页查询类型配置信息列表", notes = "根据类型配置属性分页查询类型配置信息列表")
	@RequestMapping(value = "/typess", method = RequestMethod.GET)
	public Object queryTypesPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Types types) {				
		return typesService.queryTypesForPage(pagenum, pagesize, sort, types);
	}

}
