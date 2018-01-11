package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.Employee;

/**
 * @ClassName: EmployeeMapper
 * @Description: 员工映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface EmployeeMapper {

	/**
	 * @Title: addEmployee
	 * @Description:添加员工
	 * @param employee 实体
	 * @return Integer
	 */
	Integer addEmployee(Employee employee);
	
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
	 * @param pageBounds 分页信息
	 * @param employee 实体
	 * @return List<Employee>
	 */
	List<Employee> queryEmployeeForPage(PageBounds pageBounds, @Param("employee") Employee employee);
	 
	 /**
	  * @Title: queryEmployeeByProperty
	  * @Description:根据属性查询员工
	  * @return List<Employee>
	  */
	 List<Employee> queryEmployeeByProperty(@Param("employee") Map<String, Object> map);
	 
	 
	 
}
