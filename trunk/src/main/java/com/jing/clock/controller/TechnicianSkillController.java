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
import com.jing.clock.model.entity.TechnicianSkill;
import com.jing.clock.service.TechnicianSkillService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TechnicianSkillController
 * @Description: 技师技能HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="技师技能")
public class TechnicianSkillController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private TechnicianSkillService technicianSkillService;

	
	@ApiOperation(value = "新增 添加技师技能信息", notes = "添加技师技能信息")
	@RequestMapping(value = "/technicianskill", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTechnicianSkill(HttpServletResponse response,
			@ApiParam(value = "technicianSkill") @RequestBody TechnicianSkill technicianSkill) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technicianSkill, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		technicianSkill.setTsId(null);
		technicianSkillService.addTechnicianSkill(technicianSkill);
		return technicianSkill;
	}
	
	
	@ApiOperation(value = "更新 根据技师技能标识更新技师技能信息", notes = "根据技师技能标识更新技师技能信息")
	@RequestMapping(value = "/technicianskill/{tsId:.+}", method = RequestMethod.PUT)
	public Object modifyTechnicianSkillById(HttpServletResponse response,
			@PathVariable Integer tsId,
			@ApiParam(value = "technicianSkill", required = true) @RequestBody TechnicianSkill technicianSkill
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technicianSkill, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		TechnicianSkill tempTechnicianSkill = technicianSkillService.queryTechnicianSkillByTsId(tsId);
		technicianSkill.setTsId(tsId);
		if(null == tempTechnicianSkill){
			throw new NotFoundException("技师技能");
		}
		return technicianSkillService.modifyTechnicianSkill(technicianSkill);
	}

	@ApiOperation(value = "删除 根据技师技能标识删除技师技能信息", notes = "根据技师技能标识删除技师技能信息")
	@RequestMapping(value = "/technicianskill/{tsId:.+}", method = RequestMethod.DELETE)
	public Object dropTechnicianSkillByTsId(HttpServletResponse response, @PathVariable Integer tsId) {
		TechnicianSkill technicianSkill = technicianSkillService.queryTechnicianSkillByTsId(tsId);
		if(null == technicianSkill){
			throw new NotFoundException("技师技能");
		}
		return technicianSkillService.dropTechnicianSkillByTsId(tsId);
	}
	
	@ApiOperation(value = "查询 根据技师技能标识查询技师技能信息", notes = "根据技师技能标识查询技师技能信息")
	@RequestMapping(value = "/technicianskill/{tsId:.+}", method = RequestMethod.GET)
	public Object queryTechnicianSkillById(HttpServletResponse response,
			@PathVariable Integer tsId) {
		TechnicianSkill technicianSkill = technicianSkillService.queryTechnicianSkillByTsId(tsId);
		if(null == technicianSkill){
			throw new NotFoundException("技师技能");
		}
		return technicianSkill;
	}
	
	@ApiOperation(value = "查询 根据技师技能属性查询技师技能信息列表", notes = "根据技师技能属性查询技师技能信息列表")
	@RequestMapping(value = "/technicianskill", method = RequestMethod.GET)
	public Object queryTechnicianSkillList(HttpServletResponse response,
			TechnicianSkill technicianSkill) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return technicianSkillService.queryTechnicianSkillByProperty(ClassUtil.transBean2Map(technicianSkill, false));
	}
	
	@ApiOperation(value = "查询分页 根据技师技能属性分页查询技师技能信息列表", notes = "根据技师技能属性分页查询技师技能信息列表")
	@RequestMapping(value = "/technicianskills", method = RequestMethod.GET)
	public Object queryTechnicianSkillPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, TechnicianSkill technicianSkill) {				
		return technicianSkillService.queryTechnicianSkillForPage(pagenum, pagesize, sort, technicianSkill);
	}

}
