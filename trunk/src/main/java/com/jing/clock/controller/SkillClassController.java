package com.jing.clock.controller;

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
import com.jing.clock.model.entity.SkillClass;
import com.jing.clock.service.SkillClassService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: SkillClassController
 * @Description: 轮班HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="钟房 轮班", tags={"ClockSkillClass"})
public class SkillClassController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private SkillClassService skillClassService;

	
	@ApiOperation(value = "新增 添加轮班信息", notes = "添加轮班信息")
	@RequestMapping(value = "/skillclass", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addSkillClass(HttpServletResponse response,
			@ApiParam(value = "skillClass") @RequestBody SkillClass skillClass) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(skillClass, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		skillClass.setClassId(null);
		skillClassService.addSkillClass(skillClass);
		return skillClass;
	}
	
	
	@ApiOperation(value = "更新 根据轮班标识更新轮班信息", notes = "根据轮班标识更新轮班信息")
	@RequestMapping(value = "/skillclass/{classId:.+}", method = RequestMethod.PUT)
	public Object modifySkillClassById(HttpServletResponse response,
			@PathVariable Integer classId,
			@ApiParam(value = "skillClass", required = true) @RequestBody SkillClass skillClass
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(skillClass, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		SkillClass tempSkillClass = skillClassService.querySkillClassByClassId(classId);
		skillClass.setClassId(classId);
		if(null == tempSkillClass){
			throw new NotFoundException("轮班");
		}
		return skillClassService.modifySkillClass(skillClass);
	}

	@ApiOperation(value = "删除 根据轮班标识删除轮班信息", notes = "根据轮班标识删除轮班信息")
	@RequestMapping(value = "/skillclass/{classId:.+}", method = RequestMethod.DELETE)
	public Object dropSkillClassByClassId(HttpServletResponse response, @PathVariable Integer classId) {
		SkillClass skillClass = skillClassService.querySkillClassByClassId(classId);
		if(null == skillClass){
			throw new NotFoundException("轮班");
		}
		return skillClassService.dropSkillClassByClassId(classId);
	}
	
	@ApiOperation(value = "查询 根据轮班标识查询轮班信息", notes = "根据轮班标识查询轮班信息")
	@RequestMapping(value = "/skillclass/{classId:.+}", method = RequestMethod.GET)
	public Object querySkillClassById(HttpServletResponse response,
			@PathVariable Integer classId) {
		SkillClass skillClass = skillClassService.querySkillClassByClassId(classId);
		if(null == skillClass){
			throw new NotFoundException("轮班");
		}
		return skillClass;
	}
	
	@ApiOperation(value = "查询 根据轮班属性查询轮班信息列表", notes = "根据轮班属性查询轮班信息列表")
	@RequestMapping(value = "/skillclass", method = RequestMethod.GET)
	public Object querySkillClassList(HttpServletResponse response,
			SkillClass skillClass) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return skillClassService.querySkillClassByProperty(ClassUtil.transBean2Map(skillClass, false));
	}
	
	@ApiOperation(value = "查询分页 根据轮班属性分页查询轮班信息列表", notes = "根据轮班属性分页查询轮班信息列表")
	@RequestMapping(value = "/skillclasss", method = RequestMethod.GET)
	public Object querySkillClassPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, SkillClass skillClass) {				
		return skillClassService.querySkillClassForPage(pagenum, pagesize, sort, skillClass);
	}

}
