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
import com.jing.core.model.entity.EmployeeSpecial;
import com.jing.core.service.EmployeeSpecialService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: EmployeeSpecialController
 * @Description: 员工特殊权限(扩)HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="员工特殊权限(扩)")
public class EmployeeSpecialController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private EmployeeSpecialService employeeSpecialService;

	
	@ApiOperation(value = "新增 添加员工特殊权限(扩)信息", notes = "添加员工特殊权限(扩)信息")
	@RequestMapping(value = "/employeespecial", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addEmployeeSpecial(HttpServletResponse response,
			@ApiParam(value = "employeeSpecial") @RequestBody EmployeeSpecial employeeSpecial) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employeeSpecial, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		employeeSpecial.setEmpId(null);
		employeeSpecialService.addEmployeeSpecial(employeeSpecial);
		return employeeSpecial;
	}
	
	
	@ApiOperation(value = "更新 根据员工特殊权限(扩)标识更新员工特殊权限(扩)信息", notes = "根据员工特殊权限(扩)标识更新员工特殊权限(扩)信息")
	@RequestMapping(value = "/employeespecial/{empId:.+}", method = RequestMethod.PUT)
	public Object modifyEmployeeSpecialById(HttpServletResponse response,
			@PathVariable String empId,
			@ApiParam(value = "employeeSpecial", required = true) @RequestBody EmployeeSpecial employeeSpecial
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employeeSpecial, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		EmployeeSpecial tempEmployeeSpecial = employeeSpecialService.queryEmployeeSpecialByEmpId(empId);
		employeeSpecial.setEmpId(empId);
		if(null == tempEmployeeSpecial){
			throw new NotFoundException("员工特殊权限(扩)");
		}
		return employeeSpecialService.modifyEmployeeSpecial(employeeSpecial);
	}

	@ApiOperation(value = "删除 根据员工特殊权限(扩)标识删除员工特殊权限(扩)信息", notes = "根据员工特殊权限(扩)标识删除员工特殊权限(扩)信息")
	@RequestMapping(value = "/employeespecial/{empId:.+}", method = RequestMethod.DELETE)
	public Object dropEmployeeSpecialByEmpId(HttpServletResponse response, @PathVariable String empId) {
		EmployeeSpecial employeeSpecial = employeeSpecialService.queryEmployeeSpecialByEmpId(empId);
		if(null == employeeSpecial){
			throw new NotFoundException("员工特殊权限(扩)");
		}
		return employeeSpecialService.dropEmployeeSpecialByEmpId(empId);
	}
	
	@ApiOperation(value = "查询 根据员工特殊权限(扩)标识查询员工特殊权限(扩)信息", notes = "根据员工特殊权限(扩)标识查询员工特殊权限(扩)信息")
	@RequestMapping(value = "/employeespecial/{empId:.+}", method = RequestMethod.GET)
	public Object queryEmployeeSpecialById(HttpServletResponse response,
			@PathVariable String empId) {
		EmployeeSpecial employeeSpecial = employeeSpecialService.queryEmployeeSpecialByEmpId(empId);
		if(null == employeeSpecial){
			throw new NotFoundException("员工特殊权限(扩)");
		}
		return employeeSpecial;
	}
	
	@ApiOperation(value = "查询 根据员工特殊权限(扩)属性查询员工特殊权限(扩)信息列表", notes = "根据员工特殊权限(扩)属性查询员工特殊权限(扩)信息列表")
	@RequestMapping(value = "/employeespecial", method = RequestMethod.GET)
	public Object queryEmployeeSpecialList(HttpServletResponse response,
			EmployeeSpecial employeeSpecial) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return employeeSpecialService.queryEmployeeSpecialByProperty(ClassUtil.transBean2Map(employeeSpecial, false));
	}
	
	@ApiOperation(value = "查询分页 根据员工特殊权限(扩)属性分页查询员工特殊权限(扩)信息列表", notes = "根据员工特殊权限(扩)属性分页查询员工特殊权限(扩)信息列表")
	@RequestMapping(value = "/employeespecials", method = RequestMethod.GET)
	public Object queryEmployeeSpecialPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, EmployeeSpecial employeeSpecial) {				
		return employeeSpecialService.queryEmployeeSpecialForPage(pagenum, pagesize, sort, employeeSpecial);
	}

}
