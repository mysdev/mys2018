package com.jing.core.service;

import java.util.List;
import java.util.Map;


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
	 * @Title: addEmployee
	 * @Description:添加员工
	 * @param employee 实体
	 * @return Integer
	 */
	Employee addEmployee(Employee employee);
	
	/**
	 * @Title modifyEmployee
	 * @Description:修改员工
	 * @param employee 实体
	 * @return Integer
	 */
	Integer modifyEmployee(Employee employee);
	
	/**
	 * @Title: dropEmployeeByEmpId
	 * @Description:删除员工
	 * @param empId 实体标识
	 * @return Integer
	 */
	Integer dropEmployeeByEmpId(String empId);
	
	/**
	 * @Title: queryEmployeeByEmpId
	 * @Description:根据实体标识查询员工
	 * @param empId 实体标识
	 * @return Employee
	 */
	Employee queryEmployeeByEmpId(String empId);
	 
	/**
	 * @Title: queryEmployeeForPage
	 * @Description: 根据员工属性与分页信息分页查询员工信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param employee 实体
	 * @return List<Employee>
	 */
	Map<String, Object> queryEmployeeForPage(Integer pagenum, Integer pagesize, String sort, Employee employee);
	 
	 /**
	 * @Title: queryEmployeeByProperty
	 * @Description:根据属性查询员工
	 * @return List<Employee>
	 */
	 List<Employee> queryEmployeeByProperty(Map<String, Object> map);	
	 
	 /** 
	* @Title: queryEmployeeByEmpIds 
	* @Description: 根据员工标识查询员工信息
	* @param empIds 员工标识
	* @return  List<Employee>    返回类型 
	* @throws 
	*/
	List<Employee> queryEmployeeByEmpIds(String empIds);
	 
}
