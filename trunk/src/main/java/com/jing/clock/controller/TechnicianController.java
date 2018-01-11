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
import com.jing.clock.model.entity.Technician;
import com.jing.clock.service.TechnicianService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TechnicianController
 * @Description: 技师HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="技师")
public class TechnicianController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private TechnicianService technicianService;

	
	@ApiOperation(value = "新增 添加技师信息", notes = "添加技师信息")
	@RequestMapping(value = "/technician", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTechnician(HttpServletResponse response,
			@ApiParam(value = "technician") @RequestBody Technician technician) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technician, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		technician.setTechnicianId(null);
		technicianService.addTechnician(technician);
		return technician;
	}
	
	
	@ApiOperation(value = "更新 根据技师标识更新技师信息", notes = "根据技师标识更新技师信息")
	@RequestMapping(value = "/technician/{technicianId:.+}", method = RequestMethod.PUT)
	public Object modifyTechnicianById(HttpServletResponse response,
			@PathVariable Integer technicianId,
			@ApiParam(value = "technician", required = true) @RequestBody Technician technician
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technician, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Technician tempTechnician = technicianService.queryTechnicianByTechnicianId(technicianId);
		technician.setTechnicianId(technicianId);
		if(null == tempTechnician){
			throw new NotFoundException("技师");
		}
		return technicianService.modifyTechnician(technician);
	}

	@ApiOperation(value = "删除 根据技师标识删除技师信息", notes = "根据技师标识删除技师信息")
	@RequestMapping(value = "/technician/{technicianId:.+}", method = RequestMethod.DELETE)
	public Object dropTechnicianByTechnicianId(HttpServletResponse response, @PathVariable Integer technicianId) {
		Technician technician = technicianService.queryTechnicianByTechnicianId(technicianId);
		if(null == technician){
			throw new NotFoundException("技师");
		}
		return technicianService.dropTechnicianByTechnicianId(technicianId);
	}
	
	@ApiOperation(value = "查询 根据技师标识查询技师信息", notes = "根据技师标识查询技师信息")
	@RequestMapping(value = "/technician/{technicianId:.+}", method = RequestMethod.GET)
	public Object queryTechnicianById(HttpServletResponse response,
			@PathVariable Integer technicianId) {
		Technician technician = technicianService.queryTechnicianByTechnicianId(technicianId);
		if(null == technician){
			throw new NotFoundException("技师");
		}
		return technician;
	}
	
	@ApiOperation(value = "查询 根据技师属性查询技师信息列表", notes = "根据技师属性查询技师信息列表")
	@RequestMapping(value = "/technician", method = RequestMethod.GET)
	public Object queryTechnicianList(HttpServletResponse response,
			Technician technician) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return technicianService.queryTechnicianByProperty(ClassUtil.transBean2Map(technician, false));
	}
	
	@ApiOperation(value = "查询分页 根据技师属性分页查询技师信息列表", notes = "根据技师属性分页查询技师信息列表")
	@RequestMapping(value = "/technicians", method = RequestMethod.GET)
	public Object queryTechnicianPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Technician technician) {				
		return technicianService.queryTechnicianForPage(pagenum, pagesize, sort, technician);
	}

}
