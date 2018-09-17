package com.jing.core.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.config.web.exception.NotFoundException;
import com.jing.core.model.entity.Employee;
import com.jing.core.service.EmployUserService;
import com.jing.core.service.EmployeeService;
import com.jing.system.user.entity.User;
import com.jing.system.user.service.UserService;

@Service("employUserService")
public class EmployUserServiceImpl implements EmployUserService{
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserService userService;

	@Override
	@Transactional
	public void addEmployee(Employee employee, User user) {
		user = userService.addUser(user,0);
		employee.setUserId(user.getUserId());
		employee = employeeService.addEmployee(employee);
	}

	@Override
	@Transactional
	public Integer employeeToUser(String empId, User user) {
		Employee employee = employeeService.queryEmployeeByEmpId(empId);
		if(employee==null) {
			throw new NotFoundException("员工");
		}
		user = userService.addUser(user,0);
		employee.setUserId(user.getUserId());
		return employeeService.modifyEmployee(employee);
	}

	/*
	@Override
	@Transactional
	public Integer updateEmployee(Employee employee, User user) {
		//修改用户？no
		
		return employeeService.modifyEmployee(employee);
	}
	*/

	@Override
	@Transactional
	public void deleteEmployee(String empId) {
		Employee employee = employeeService.queryEmployeeByEmpId(empId);
		if(employee==null) {
			throw new NotFoundException("员工");
		}
		if(employee.getUserId() != null) {
			userService.deleteUserById(employee.getUserId(),0);
		}
		employeeService.dropEmployeeByEmpId(empId);
	}

}
