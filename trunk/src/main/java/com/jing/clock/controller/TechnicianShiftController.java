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
import com.jing.clock.model.entity.TechnicianShift;
import com.jing.clock.service.TechnicianShiftService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TechnicianShiftController
 * @Description: 技师班次HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="技师 班次", tags={"ClockTechnicianShift"})
public class TechnicianShiftController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private TechnicianShiftService technicianShiftService;

	
	@ApiOperation(value = "新增 添加技师班次信息", notes = "添加技师班次信息")
	@RequestMapping(value = "/technicianshift", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTechnicianShift(HttpServletResponse response,
			@ApiParam(value = "technicianShift") @RequestBody TechnicianShift technicianShift) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technicianShift, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		technicianShift.setShiftId(null);
		technicianShiftService.addTechnicianShift(technicianShift);
		return technicianShift;
	}
	
	
	@ApiOperation(value = "更新 根据技师班次标识更新技师班次信息", notes = "根据技师班次标识更新技师班次信息")
	@RequestMapping(value = "/technicianshift/{shiftId:.+}", method = RequestMethod.PUT)
	public Object modifyTechnicianShiftById(HttpServletResponse response,
			@PathVariable Integer shiftId,
			@ApiParam(value = "technicianShift", required = true) @RequestBody TechnicianShift technicianShift
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technicianShift, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		TechnicianShift tempTechnicianShift = technicianShiftService.queryTechnicianShiftByShiftId(shiftId);
		technicianShift.setShiftId(shiftId);
		if(null == tempTechnicianShift){
			throw new NotFoundException("技师班次");
		}
		return technicianShiftService.modifyTechnicianShift(technicianShift);
	}

	@ApiOperation(value = "删除 根据技师班次标识删除技师班次信息", notes = "根据技师班次标识删除技师班次信息")
	@RequestMapping(value = "/technicianshift/{shiftId:.+}", method = RequestMethod.DELETE)
	public Object dropTechnicianShiftByShiftId(HttpServletResponse response, @PathVariable Integer shiftId) {
		TechnicianShift technicianShift = technicianShiftService.queryTechnicianShiftByShiftId(shiftId);
		if(null == technicianShift){
			throw new NotFoundException("技师班次");
		}
		return technicianShiftService.dropTechnicianShiftByShiftId(shiftId);
	}
	
	@ApiOperation(value = "查询 根据技师班次标识查询技师班次信息", notes = "根据技师班次标识查询技师班次信息")
	@RequestMapping(value = "/technicianshift/{shiftId:.+}", method = RequestMethod.GET)
	public Object queryTechnicianShiftById(HttpServletResponse response,
			@PathVariable Integer shiftId) {
		TechnicianShift technicianShift = technicianShiftService.queryTechnicianShiftByShiftId(shiftId);
		if(null == technicianShift){
			throw new NotFoundException("技师班次");
		}
		return technicianShift;
	}
	
	@ApiOperation(value = "查询 根据技师班次属性查询技师班次信息列表", notes = "根据技师班次属性查询技师班次信息列表")
	@RequestMapping(value = "/technicianshift", method = RequestMethod.GET)
	public Object queryTechnicianShiftList(HttpServletResponse response,
			TechnicianShift technicianShift) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return technicianShiftService.queryTechnicianShiftByProperty(ClassUtil.transBean2Map(technicianShift, false));
	}
	
	@ApiOperation(value = "查询分页 根据技师班次属性分页查询技师班次信息列表", notes = "根据技师班次属性分页查询技师班次信息列表")
	@RequestMapping(value = "/technicianshifts", method = RequestMethod.GET)
	public Object queryTechnicianShiftPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, TechnicianShift technicianShift) {				
		return technicianShiftService.queryTechnicianShiftForPage(pagenum, pagesize, sort, technicianShift);
	}

}
