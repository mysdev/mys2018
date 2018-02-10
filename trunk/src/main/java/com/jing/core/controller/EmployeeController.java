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
import com.jing.core.model.entity.Employee;
import com.jing.core.service.EmployeeService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: EmployeeController
 * @Description: 员工HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="员工", tags={"CoreDepartment"})
public class EmployeeController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private EmployeeService employeeService;

	
	@ApiOperation(value = "新增 添加员工信息", notes = "添加员工信息")
	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addEmployee(HttpServletResponse response,
			@ApiParam(value = "employee") @RequestBody Employee employee) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employee, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		employee.setEmpId(null);
		employeeService.addEmployee(employee);
		return employee;
	}
	
	
	@ApiOperation(value = "更新 根据员工标识更新员工信息", notes = "根据员工标识更新员工信息")
	@RequestMapping(value = "/employee/{empId:.+}", method = RequestMethod.PUT)
	public Object modifyEmployeeById(HttpServletResponse response,
			@PathVariable String empId,
			@ApiParam(value = "employee", required = true) @RequestBody Employee employee
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employee, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Employee tempEmployee = employeeService.queryEmployeeByEmpId(empId);
		employee.setEmpId(empId);
		if(null == tempEmployee){
			throw new NotFoundException("员工");
		}
		return employeeService.modifyEmployee(employee);
	}

	@ApiOperation(value = "删除 根据员工标识删除员工信息", notes = "根据员工标识删除员工信息")
	@RequestMapping(value = "/employee/{empId:.+}", method = RequestMethod.DELETE)
	public Object dropEmployeeByEmpId(HttpServletResponse response, @PathVariable String empId) {
		Employee employee = employeeService.queryEmployeeByEmpId(empId);
		if(null == employee){
			throw new NotFoundException("员工");
		}
		return employeeService.dropEmployeeByEmpId(empId);
	}
	
	@ApiOperation(value = "查询 根据员工标识查询员工信息", notes = "根据员工标识查询员工信息")
	@RequestMapping(value = "/employee/{empId:.+}", method = RequestMethod.GET)
	public Object queryEmployeeById(HttpServletResponse response,
			@PathVariable String empId) {
		Employee employee = employeeService.queryEmployeeByEmpId(empId);
		if(null == employee){
			throw new NotFoundException("员工");
		}
		return employee;
	}
	
	@ApiOperation(value = "查询 根据员工属性查询员工信息列表", notes = "根据员工属性查询员工信息列表")
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Object queryEmployeeList(HttpServletResponse response,
			Employee employee) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return employeeService.queryEmployeeByProperty(ClassUtil.transBean2Map(employee, false));
	}
	
	@ApiOperation(value = "查询分页 根据员工属性分页查询员工信息列表", notes = "根据员工属性分页查询员工信息列表")
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public Object queryEmployeePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Employee employee) {				
		return employeeService.queryEmployeeForPage(pagenum, pagesize, sort, employee);
	}

}
