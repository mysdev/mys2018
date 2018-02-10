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
import com.jing.clock.model.entity.ClockSkill;
import com.jing.clock.service.ClockSkillService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ClockSkillController
 * @Description: 技能HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="技能", tags={"Clock&Skill"})
public class ClockSkillController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private ClockSkillService clockSkillService;

	
	@ApiOperation(value = "新增 添加技能信息", notes = "添加技能信息")
	@RequestMapping(value = "/clockskill", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addClockSkill(HttpServletResponse response,
			@ApiParam(value = "clockSkill") @RequestBody ClockSkill clockSkill) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(clockSkill, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		clockSkill.setSkillId(null);
		clockSkillService.addClockSkill(clockSkill);
		return clockSkill;
	}
	
	
	@ApiOperation(value = "更新 根据技能标识更新技能信息", notes = "根据技能标识更新技能信息")
	@RequestMapping(value = "/clockskill/{skillId:.+}", method = RequestMethod.PUT)
	public Object modifyClockSkillById(HttpServletResponse response,
			@PathVariable Integer skillId,
			@ApiParam(value = "clockSkill", required = true) @RequestBody ClockSkill clockSkill
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(clockSkill, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		ClockSkill tempClockSkill = clockSkillService.queryClockSkillBySkillId(skillId);
		clockSkill.setSkillId(skillId);
		if(null == tempClockSkill){
			throw new NotFoundException("技能");
		}
		return clockSkillService.modifyClockSkill(clockSkill);
	}

	@ApiOperation(value = "删除 根据技能标识删除技能信息", notes = "根据技能标识删除技能信息")
	@RequestMapping(value = "/clockskill/{skillId:.+}", method = RequestMethod.DELETE)
	public Object dropClockSkillBySkillId(HttpServletResponse response, @PathVariable Integer skillId) {
		ClockSkill clockSkill = clockSkillService.queryClockSkillBySkillId(skillId);
		if(null == clockSkill){
			throw new NotFoundException("技能");
		}
		return clockSkillService.dropClockSkillBySkillId(skillId);
	}
	
	@ApiOperation(value = "查询 根据技能标识查询技能信息", notes = "根据技能标识查询技能信息")
	@RequestMapping(value = "/clockskill/{skillId:.+}", method = RequestMethod.GET)
	public Object queryClockSkillById(HttpServletResponse response,
			@PathVariable Integer skillId) {
		ClockSkill clockSkill = clockSkillService.queryClockSkillBySkillId(skillId);
		if(null == clockSkill){
			throw new NotFoundException("技能");
		}
		return clockSkill;
	}
	
	@ApiOperation(value = "查询 根据技能属性查询技能信息列表", notes = "根据技能属性查询技能信息列表")
	@RequestMapping(value = "/clockskill", method = RequestMethod.GET)
	public Object queryClockSkillList(HttpServletResponse response,
			ClockSkill clockSkill) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return clockSkillService.queryClockSkillByProperty(ClassUtil.transBean2Map(clockSkill, false));
	}
	
	@ApiOperation(value = "查询分页 根据技能属性分页查询技能信息列表", notes = "根据技能属性分页查询技能信息列表")
	@RequestMapping(value = "/clockskills", method = RequestMethod.GET)
	public Object queryClockSkillPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, ClockSkill clockSkill) {				
		return clockSkillService.queryClockSkillForPage(pagenum, pagesize, sort, clockSkill);
	}

}
