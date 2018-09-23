package com.jing.core.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.Employee;

/**
 * @ClassName: Employee
 * @Description: 员工服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface EmployeeService {

	/**
	 * 添加 员工
	 */
	void addEmployee(Employee employee);

	/**
	 * 修改 员工
	 */
	void updateEmployee(Employee employee);

	/**
	 * 根据ID删除记录
	 */
	void deleteEmployeeById(String id);

	/**
	 * 根据ID查询记录
	 */
	Employee getEmployeeById(String id);

	/**
	 * 分页查询
	 */
	PageInfo findEmployeeListPage(PageInfo page, Map<String, Object> param);

	/**
	 * 根据属性查询员工
	 * 
	 * @param param
	 * @return
	 */
	List<Employee> findEmployeeList(Map<String, Object> param);

	/**
	 * @Title: queryEmployeeByEmpCard @Description: 根据实体标识查询员工 @param empCard
	 * 用户卡号 @return Employee 返回类型 @throws
	 */
	Employee queryEmployeeByEmpCard(String empCard);

	/**
	 * @Title: queryEmployeeByEmpIds @Description: 根据员工标识查询员工信息 @param empIds
	 * 员工标识,多个员工号之间以逗号分隔 @return List<Employee> 返回类型 @throws
	 */
	List<Employee> queryEmployeeByEmpIds(String empIds);
	
	/**
	 * 员工同步用户 
	 * @param empId
	 * @param username
	 */
	void toUser(String empId,String username);

}
