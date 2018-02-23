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
import com.jing.core.model.entity.TypesBind;
import com.jing.core.service.TypesBindService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TypesBindController
 * @Description: 类型消费绑定HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="类型消费绑定", tags={"CoreTypesBind"})
public class TypesBindController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private TypesBindService typesBindService;

	
	@ApiOperation(value = "新增 添加类型消费绑定信息", notes = "添加类型消费绑定信息")
	@RequestMapping(value = "/typesbind", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTypesBind(HttpServletResponse response,
			@ApiParam(value = "typesBind") @RequestBody TypesBind typesBind) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(typesBind, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		typesBind.setBindId(null);
		typesBindService.addTypesBind(typesBind);
		return typesBind;
	}
	
	
	@ApiOperation(value = "更新 根据类型消费绑定标识更新类型消费绑定信息", notes = "根据类型消费绑定标识更新类型消费绑定信息")
	@RequestMapping(value = "/typesbind/{bindId:.+}", method = RequestMethod.PUT)
	public Object modifyTypesBindById(HttpServletResponse response,
			@PathVariable Integer bindId,
			@ApiParam(value = "typesBind", required = true) @RequestBody TypesBind typesBind
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(typesBind, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		TypesBind tempTypesBind = typesBindService.queryTypesBindByBindId(bindId);
		typesBind.setBindId(bindId);
		if(null == tempTypesBind){
			throw new NotFoundException("类型消费绑定");
		}
		return typesBindService.modifyTypesBind(typesBind);
	}

	@ApiOperation(value = "删除 根据类型消费绑定标识删除类型消费绑定信息", notes = "根据类型消费绑定标识删除类型消费绑定信息")
	@RequestMapping(value = "/typesbind/{bindId:.+}", method = RequestMethod.DELETE)
	public Object dropTypesBindByBindId(HttpServletResponse response, @PathVariable Integer bindId) {
		TypesBind typesBind = typesBindService.queryTypesBindByBindId(bindId);
		if(null == typesBind){
			throw new NotFoundException("类型消费绑定");
		}
		return typesBindService.dropTypesBindByBindId(bindId);
	}
	
	@ApiOperation(value = "查询 根据类型消费绑定标识查询类型消费绑定信息", notes = "根据类型消费绑定标识查询类型消费绑定信息")
	@RequestMapping(value = "/typesbind/{bindId:.+}", method = RequestMethod.GET)
	public Object queryTypesBindById(HttpServletResponse response,
			@PathVariable Integer bindId) {
		TypesBind typesBind = typesBindService.queryTypesBindByBindId(bindId);
		if(null == typesBind){
			throw new NotFoundException("类型消费绑定");
		}
		return typesBind;
	}
	
	@ApiOperation(value = "查询 根据类型消费绑定属性查询类型消费绑定信息列表", notes = "根据类型消费绑定属性查询类型消费绑定信息列表")
	@RequestMapping(value = "/typesbind", method = RequestMethod.GET)
	public Object queryTypesBindList(HttpServletResponse response,
			TypesBind typesBind) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return typesBindService.queryTypesBindByProperty(ClassUtil.transBean2Map(typesBind, false));
	}
	
	@ApiOperation(value = "查询分页 根据类型消费绑定属性分页查询类型消费绑定信息列表", notes = "根据类型消费绑定属性分页查询类型消费绑定信息列表")
	@RequestMapping(value = "/typesbinds", method = RequestMethod.GET)
	public Object queryTypesBindPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, TypesBind typesBind) {				
		return typesBindService.queryTypesBindForPage(pagenum, pagesize, sort, typesBind);
	}

}
