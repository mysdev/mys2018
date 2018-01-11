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
import com.jing.clock.model.entity.TechnicianClass;
import com.jing.clock.service.TechnicianClassService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: TechnicianClassController
 * @Description: 轮班详情HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="轮班详情")
public class TechnicianClassController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private TechnicianClassService technicianClassService;

	
	@ApiOperation(value = "新增 添加轮班详情信息", notes = "添加轮班详情信息")
	@RequestMapping(value = "/technicianclass", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addTechnicianClass(HttpServletResponse response,
			@ApiParam(value = "technicianClass") @RequestBody TechnicianClass technicianClass) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technicianClass, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		technicianClass.setDetailId(null);
		technicianClassService.addTechnicianClass(technicianClass);
		return technicianClass;
	}
	
	
	@ApiOperation(value = "更新 根据轮班详情标识更新轮班详情信息", notes = "根据轮班详情标识更新轮班详情信息")
	@RequestMapping(value = "/technicianclass/{detailId:.+}", method = RequestMethod.PUT)
	public Object modifyTechnicianClassById(HttpServletResponse response,
			@PathVariable Integer detailId,
			@ApiParam(value = "technicianClass", required = true) @RequestBody TechnicianClass technicianClass
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(technicianClass, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		TechnicianClass tempTechnicianClass = technicianClassService.queryTechnicianClassByDetailId(detailId);
		technicianClass.setDetailId(detailId);
		if(null == tempTechnicianClass){
			throw new NotFoundException("轮班详情");
		}
		return technicianClassService.modifyTechnicianClass(technicianClass);
	}

	@ApiOperation(value = "删除 根据轮班详情标识删除轮班详情信息", notes = "根据轮班详情标识删除轮班详情信息")
	@RequestMapping(value = "/technicianclass/{detailId:.+}", method = RequestMethod.DELETE)
	public Object dropTechnicianClassByDetailId(HttpServletResponse response, @PathVariable Integer detailId) {
		TechnicianClass technicianClass = technicianClassService.queryTechnicianClassByDetailId(detailId);
		if(null == technicianClass){
			throw new NotFoundException("轮班详情");
		}
		return technicianClassService.dropTechnicianClassByDetailId(detailId);
	}
	
	@ApiOperation(value = "查询 根据轮班详情标识查询轮班详情信息", notes = "根据轮班详情标识查询轮班详情信息")
	@RequestMapping(value = "/technicianclass/{detailId:.+}", method = RequestMethod.GET)
	public Object queryTechnicianClassById(HttpServletResponse response,
			@PathVariable Integer detailId) {
		TechnicianClass technicianClass = technicianClassService.queryTechnicianClassByDetailId(detailId);
		if(null == technicianClass){
			throw new NotFoundException("轮班详情");
		}
		return technicianClass;
	}
	
	@ApiOperation(value = "查询 根据轮班详情属性查询轮班详情信息列表", notes = "根据轮班详情属性查询轮班详情信息列表")
	@RequestMapping(value = "/technicianclass", method = RequestMethod.GET)
	public Object queryTechnicianClassList(HttpServletResponse response,
			TechnicianClass technicianClass) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return technicianClassService.queryTechnicianClassByProperty(ClassUtil.transBean2Map(technicianClass, false));
	}
	
	@ApiOperation(value = "查询分页 根据轮班详情属性分页查询轮班详情信息列表", notes = "根据轮班详情属性分页查询轮班详情信息列表")
	@RequestMapping(value = "/technicianclasss", method = RequestMethod.GET)
	public Object queryTechnicianClassPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, TechnicianClass technicianClass) {				
		return technicianClassService.queryTechnicianClassForPage(pagenum, pagesize, sort, technicianClass);
	}

}
