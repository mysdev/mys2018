package com.jing.core.service;

import com.jing.core.model.entity.Employee;
import com.jing.system.user.entity.User;

/**
 * 员工+用户
 * @author Administrator
 *
 */
public interface EmployUserService {

	/**
	 * 添加员工 + 用户
	 * 1.新增user
	 * 2.赋值userId到employee
	 * 3.新增employee
	 */
	void addEmployee(Employee employee,User user);
	
	/**
	 * 员工转用户
	 * 1.查询employee
	 * 2.新增user
	 * 3.修改employee的userId
	 * @param employee
	 * @param user
	 */
	Integer employeeToUser(String empId,User user);
	
	/**
	 * 修改员工 + 用户
	 * 1.update user
	 * 2.update employee
	 */
	//Integer updateEmployee(Employee employee,User user);
	
	/**
	 * 删除员工 + 用户
	 * 1.查询员工
	 * 2.逻辑删除emplyee
	 * 3.修改user的status=1
	 */
	void deleteEmployee(String empId);
	
	
}
