package com.jing.core.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jing.config.validation.BeanValidator;
import com.jing.config.web.exception.ParameterException;
import com.jing.core.model.entity.Employee;
import com.jing.core.service.EmployUserService;
import com.jing.system.model.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 员工管理
 * @author Administrator
 *
 */
@RestController
@Api(description="员工与用户")
public class EmployUserController {
	@Autowired
	BeanValidator beanValidator;
	@Autowired
	private EmployUserService employUserService;
	
	
	@ApiOperation(value = "新增 添加员工信息", notes = "添加员工信息")
	@RequestMapping(value = "/employeeUser/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addEmployee(HttpServletResponse response,
			@ApiParam(value = "employee") @RequestBody Employee employee,@RequestBody User user) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employee, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		employee.setEmpId(null);
		employUserService.addEmployee(employee, null);
		return employee;
	}
	
	@ApiOperation(value = "新增 添加员工信息", notes = "添加员工信息")
	@RequestMapping(value = "/employeeUser/update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object updateEmployee(HttpServletResponse response,
			@ApiParam(value = "employee") @RequestBody Employee employee,@RequestBody User user) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employee, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		employee.setEmpId(null);
		employUserService.addEmployee(employee, null);
		return employee;
	}
}
