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
import com.jing.system.model.entity.DictionaryGroup;
import com.jing.system.service.DictionaryGroupService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: DictionaryGroupController
 * @Description: 字典分组HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@RestController
@Api(description="字典分组")
public class DictionaryGroupController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private DictionaryGroupService dictionaryGroupService;

	
	@ApiOperation(value = "新增 添加字典分组信息", notes = "添加字典分组信息")
	@RequestMapping(value = "/dictionarygroup", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addDictionaryGroup(HttpServletResponse response,
			@ApiParam(value = "dictionaryGroup") @RequestBody DictionaryGroup dictionaryGroup) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(dictionaryGroup, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		dictionaryGroup.setGroupId(null);
		dictionaryGroupService.addDictionaryGroup(dictionaryGroup);
		return dictionaryGroup;
	}
	
	
	@ApiOperation(value = "更新 根据字典分组标识更新字典分组信息", notes = "根据字典分组标识更新字典分组信息")
	@RequestMapping(value = "/dictionarygroup/{groupId:.+}", method = RequestMethod.PUT)
	public Object modifyDictionaryGroupById(HttpServletResponse response,
			@PathVariable Integer groupId,
			@ApiParam(value = "dictionaryGroup", required = true) @RequestBody DictionaryGroup dictionaryGroup
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(dictionaryGroup, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		DictionaryGroup tempDictionaryGroup = dictionaryGroupService.queryDictionaryGroupByGroupId(groupId);
		dictionaryGroup.setGroupId(groupId);
		if(null == tempDictionaryGroup){
			throw new NotFoundException("字典分组");
		}
		return dictionaryGroupService.modifyDictionaryGroup(dictionaryGroup);
	}

	@ApiOperation(value = "删除 根据字典分组标识删除字典分组信息", notes = "根据字典分组标识删除字典分组信息")
	@RequestMapping(value = "/dictionarygroup/{groupId:.+}", method = RequestMethod.DELETE)
	public Object dropDictionaryGroupByGroupId(HttpServletResponse response, @PathVariable Integer groupId) {
		DictionaryGroup dictionaryGroup = dictionaryGroupService.queryDictionaryGroupByGroupId(groupId);
		if(null == dictionaryGroup){
			throw new NotFoundException("字典分组");
		}
		return dictionaryGroupService.dropDictionaryGroupByGroupId(groupId);
	}
	
	@ApiOperation(value = "查询 根据字典分组标识查询字典分组信息", notes = "根据字典分组标识查询字典分组信息")
	@RequestMapping(value = "/dictionarygroup/{groupId:.+}", method = RequestMethod.GET)
	public Object queryDictionaryGroupById(HttpServletResponse response,
			@PathVariable Integer groupId) {
		DictionaryGroup dictionaryGroup = dictionaryGroupService.queryDictionaryGroupByGroupId(groupId);
		if(null == dictionaryGroup){
			throw new NotFoundException("字典分组");
		}
		return dictionaryGroup;
	}
	
	@ApiOperation(value = "查询 根据字典分组属性查询字典分组信息列表", notes = "根据字典分组属性查询字典分组信息列表")
	@RequestMapping(value = "/dictionarygroup", method = RequestMethod.GET)
	public Object queryDictionaryGroupList(HttpServletResponse response,
			DictionaryGroup dictionaryGroup) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return dictionaryGroupService.queryDictionaryGroupByProperty(ClassUtil.transBean2Map(dictionaryGroup, false));
	}
	
	@ApiOperation(value = "查询分页 根据字典分组属性分页查询字典分组信息列表", notes = "根据字典分组属性分页查询字典分组信息列表")
	@RequestMapping(value = "/dictionarygroups", method = RequestMethod.GET)
	public Object queryDictionaryGroupPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, DictionaryGroup dictionaryGroup) {				
		return dictionaryGroupService.queryDictionaryGroupForPage(pagenum, pagesize, sort, dictionaryGroup);
	}

}
