package com.jing.clock.controller;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.clock.model.entity.ClockSkill;
import com.jing.clock.model.entity.Technician;
import com.jing.clock.model.entity.TechnicianSkill;
import com.jing.clock.service.ClockSkillService;
import com.jing.clock.service.TechnicianService;
import com.jing.clock.service.TechnicianSkillService;
import com.jing.clock.service.bo.TechnicianSkillBo;
import com.jing.config.validation.BeanValidator;
import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import com.jing.core.model.entity.Employee;
import com.jing.core.service.EmployeeService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TechnicianController
 * @Description: 技师 技师技能HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="钟房 技师、技师技能", tags={"ClockTechnician"})
public class TechnicianController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private TechnicianService technicianService;
	
	@Autowired
	private TechnicianSkillService technicianSkillService;
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ClockSkillService clockSkillService;

	
	@ApiOperation(value = "新增 添加技师信息", notes = "添加技师信息")
	@RequestMapping(value = "/clock/technician", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTechnician(HttpServletResponse response,
			@ApiParam(value = "technician") @RequestBody Technician technician) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technician, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		if(technician.getEmpId()!=null){
			Employee employee = employeeService.getEmployeeById(technician.getEmpId());
			if(employee==null){
				throw new NotFoundException("员工");
			}
//			technician.setStoreId(employee.getStoreId());
		}
		technician.setTechnicianId(null);
		technicianService.addTechnician(technician);
		return technician;
	}
	
	@ApiOperation(value = "新增 员工转技师", notes = "员工转技师")
	@RequestMapping(value = "/clock/technician/{empId}", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTechnicianEmployee(HttpServletResponse response,
			@PathVariable String empId,
			@ApiParam(value = "technician") @RequestBody Technician technician) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Employee employee = employeeService.getEmployeeById(empId);
		if(employee==null){
			throw new NotFoundException("员工");
		}
//		technician.setStoreId(employee.getStoreId());
		technician.setEmpId(empId);
		technician.setTechName(employee.getEmpName());
		if(technician.getTechCard()==null){
			technician.setTechCard(employee.getEmpCard());
		}
		technician.setSex(employee.getSex());
		if(technician.getTechNo()==null){
			technician.setTechNo(employee.getEmpName());
		}
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technician, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}		
		technician.setTechnicianId(null);
		technicianService.addTechnician(technician);
		return technician;
	}
	
	
	@ApiOperation(value = "更新 根据技师标识更新技师信息", notes = "根据技师标识更新技师信息")
	@RequestMapping(value = "/clock/technician/{technicianId:.+}", method = RequestMethod.PUT)
	public Object modifyTechnicianById(HttpServletResponse response,
			@PathVariable Integer technicianId,
			@ApiParam(value = "technician", required = true) @RequestBody Technician technician
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technician, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Technician tempTechnician = technicianService.queryTechnicianByTechnicianId(technicianId);		
		if(null == tempTechnician){
			throw new NotFoundException("技师");
		}
		technician.setStoreId(null);
		technician.setTechnicianId(technicianId);
		return technicianService.modifyTechnician(technician);
	}

	@ApiOperation(value = "删除 根据技师标识删除技师信息", notes = "根据技师标识删除技师信息")
	@RequestMapping(value = "/clock/technician/{technicianId:.+}", method = RequestMethod.DELETE)
	public Object dropTechnicianByTechnicianId(HttpServletResponse response, @PathVariable Integer technicianId) {
		Technician technician = technicianService.queryTechnicianByTechnicianId(technicianId);
		if(null == technician){
			throw new NotFoundException("技师");
		}
		return technicianService.dropTechnicianByTechnicianId(technicianId);
	}
	
	@ApiOperation(value = "查询 根据技师标识查询技师信息", notes = "根据技师标识查询技师信息")
	@RequestMapping(value = "/clock/technician/{technicianId:.+}", method = RequestMethod.GET)
	public Object queryTechnicianById(HttpServletResponse response,
			@PathVariable Integer technicianId) {
		Technician technician = technicianService.queryTechnicianByTechnicianId(technicianId);
		if(null == technician){
			throw new NotFoundException("技师");
		}
		return technician;
	}
	
	@ApiOperation(value = "查询 根据技师属性查询技师信息列表", notes = "根据技师属性查询技师信息列表")
	@RequestMapping(value = "/clock/technician", method = RequestMethod.GET)
	public Object queryTechnicianList(HttpServletResponse response,
			Technician technician) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return technicianService.queryTechnicianByProperty(ClassUtil.transBean2Map(technician, false));
	}
	
	@ApiOperation(value = "查询分页 根据技师属性分页查询技师信息列表", notes = "根据技师属性分页查询技师信息列表")
	@RequestMapping(value = "/clock/technicians", method = RequestMethod.GET)
	public Object queryTechnicianPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Technician technician) {				
		return technicianService.queryTechnicianForPage(pagenum, pagesize, sort, technician);
	}
	
	

	
	@ApiOperation(value = "新增 添加技师技能信息", notes = "添加技师技能信息")
	@RequestMapping(value = "/clock/technician/{technicianId:.+}/skill", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTechnicianSkill(HttpServletResponse response,
			@PathVariable Integer technicianId,
			@ApiParam(value = "technicianSkill", required = true) @RequestBody TechnicianSkill technicianSkill) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		technicianSkill.setTechnicianId(technicianId);
		if(technicianSkill.getSkillLevel()==null) {
			technicianSkill.setSkillLevel(0);
		}
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technicianSkill, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}	
		Technician technician = technicianService.queryTechnicianByTechnicianId(technicianId);
		if(null == technician){
			throw new NotFoundException("技师");
		}
		ClockSkill skill = clockSkillService.queryClockSkillBySkillId(technicianSkill.getSkillId());
		if(skill==null) {
			throw new NotFoundException("技能");
		}
		if(!skill.getStoreId().equals(technician.getStoreId())) {
			throw new NotFoundException("技师与技能归属门店不匹配");
		}
		technicianSkill.setTsId(null);
		technicianSkillService.addTechnicianSkill(technicianSkill);
		return technicianSkill;
	}
	
	@ApiOperation(value = "绑定 技师绑定技能信息", notes = "绑定技师技能信息")
	@RequestMapping(value = "/clock/technician/{technicianId:.+}/skills", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object bindTechnicianSkill(HttpServletResponse response,
			@PathVariable Integer technicianId,
			@ApiParam(value = "technicianSkillList", required = true) @RequestBody TechnicianSkill[] technicianSkillList) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Technician technician = technicianService.queryTechnicianByTechnicianId(technicianId);
		if(null == technician){
			throw new NotFoundException("技师");
		}
		Map<Integer, Integer> skills = new HashMap<Integer, Integer>();
		List<Map<String, String>> errors = new ArrayList<Map<String, String>>();
		for(int i=0; i<technicianSkillList.length; i++) {			
			if(technicianSkillList[i].getSkillLevel()==null) {
				technicianSkillList[i].setSkillLevel(0);
			}
			if(technicianSkillList[i].getSkillId()==null) {
				errors.add(BeanValidator.gotErrorMessage(i, "skillId", "skillId必传"));
			}
			ClockSkill skill = clockSkillService.queryClockSkillBySkillId(technicianSkillList[i].getSkillId());
			if(skill==null) {
				errors.add(BeanValidator.gotErrorMessage(i, "skillId", "找不到对应技能"));
			}
			if(!skill.getStoreId().equals(technician.getStoreId())) {
				errors.add(BeanValidator.gotErrorMessage(i, "skillId", "技能与技师归属门店不一致"));
			}
			skills.put(technicianSkillList[i].getSkillId(), technicianSkillList[i].getSkillLevel());
		}
		
		return technicianSkillService.bindTechnicianSkill(technicianId, skills);
	}
	
	
	@ApiOperation(value = "更新 根据技师技能标识更新技师技能级别信息", notes = "根据技师技能标识更新技师技能级别信息")
	@RequestMapping(value = "/clock/technician/{technicianId:.+}/skill/{tsId:.+}/{skillLevel:.+}", method = RequestMethod.PUT)
	public Object modifyTechnicianSkillById(HttpServletResponse response,
			@PathVariable Integer technicianId, @PathVariable Integer tsId,
			@PathVariable Integer skillLevel
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {				
		TechnicianSkill tempTechnicianSkill = technicianSkillService.queryTechnicianSkillByTsId(tsId);		
		if(null == tempTechnicianSkill){
			throw new NotFoundException("技师技能");
		}
		if(technicianId.intValue()!=tempTechnicianSkill.getTechnicianId().intValue()){
			throw new NotFoundException("技师");
		}
		TechnicianSkill technicianSkill = new TechnicianSkill();
		technicianSkill.setTsId(tsId);
		technicianSkill.setSkillLevel(skillLevel);
		return technicianSkillService.modifyTechnicianSkill(technicianSkill);
	}	

	@ApiOperation(value = "删除 根据技师技能标识删除技师技能信息", notes = "根据技师技能标识删除技师技能信息")
	@RequestMapping(value = "/clock/technician/{t echnicianId:.+}/skill/{tsId:.+}", method = RequestMethod.DELETE)
	public Object dropTechnicianSkillByTsId(HttpServletResponse response,
			@PathVariable Integer technicianId, @PathVariable Integer tsId) {		
		TechnicianSkill technicianSkill = technicianSkillService.queryTechnicianSkillByTsId(tsId);
		if(null == technicianSkill){
			throw new NotFoundException("技师技能");
		}
		if(technicianId.intValue()!=technicianSkill.getTechnicianId().intValue()){
			throw new NotFoundException("技师");
		}
		return technicianSkillService.dropTechnicianSkillByTsId(tsId);
	}
	
	@ApiOperation(value = "查询 查询技师技能信息", notes = "查询技师技能信息")
	@RequestMapping(value = "/clock/technician/{technicianId:.+}/skills", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public Object queryTechnicianSkillByTechnicianId(HttpServletResponse response,
			@PathVariable Integer technicianId) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {		
		Technician technician = technicianService.queryTechnicianByTechnicianId(technicianId);
		if(null == technician){
			throw new NotFoundException("技师");
		}
		List<TechnicianSkillBo> ret = technicianSkillService.queryTechnicianSkillByTechnicianId(technicianId);
		for(TechnicianSkillBo tsb : ret) {
			tsb.setTechnicianName(technician.getTechNo());
		}
		return ret;
	}
	
	@ApiOperation(value = "查询分页 根据技师技能属性分页查询技师技能信息列表", notes = "根据技师技能属性分页查询技师技能信息列表")
	@RequestMapping(value = "/clock/technician/technician/skills", method = RequestMethod.GET)
	public Object queryTechnicianSkillPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, 
			@RequestParam(value = "employeeId", required = false) String employeeId,
			@RequestParam(value = "namePYJob", required = false) String namePYJob,
			@RequestParam(value = "dptId", required = false) Integer dptId,
			@RequestParam(value = "storeId", required = false) String storeId,
			@RequestParam(value = "empCard", required = false) String empCard,
			@RequestParam(value = "technicianId", required = false) String technicianId,
			@RequestParam(value = "technicianName", required = false) String technicianName) {
		Map<String, Object> query = new HashMap<String, Object>();
		if(employeeId!=null) query.put("employeeId", employeeId);
		if(namePYJob!=null) query.put("namePYJob", namePYJob);
		if(dptId!=null) query.put("dptId", dptId);
		if(storeId!=null) query.put("storeId", storeId);		
		if(empCard!=null) query.put("empCard", empCard);
		if(technicianId!=null) query.put("technicianId", technicianId);
		if(technicianId!=null) query.put("technicianName", technicianName);		
		return technicianSkillService.queryTechnicianSkillForPage(pagenum, pagesize, sort, query);
	}

}
