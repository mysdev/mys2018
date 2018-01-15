package com.jing.attendance.service;

import java.util.List;
import java.util.Map;


import com.jing.attendance.model.entity.EmployeeAttendance;

/**
 * @ClassName: EmployeeAttendance
 * @Description: 员工考勤关系服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public interface EmployeeAttendanceService {

    /**
	 * @Title: addEmployeeAttendance
	 * @Description:添加员工考勤关系
	 * @param employeeAttendance 实体
	 * @return Integer
	 */
	EmployeeAttendance addEmployeeAttendance(EmployeeAttendance employeeAttendance);
	
	/**
	 * @Title modifyEmployeeAttendance
	 * @Description:修改员工考勤关系
	 * @param employeeAttendance 实体
	 * @return Integer
	 */
	Integer modifyEmployeeAttendance(EmployeeAttendance employeeAttendance);
	
	/**
	 * @Title: dropEmployeeAttendanceByLinkId
	 * @Description:删除员工考勤关系
	 * @param linkId 实体标识
	 * @return Integer
	 */
	Integer dropEmployeeAttendanceByLinkId(Integer linkId);
	
	/**
	 * @Title: dropEmployeeAttendanceByLinkId
	 * @Description:删除员工考勤关系
	 * @param empId 员工标识
	 * @return Integer
	 */
	Integer dropEmployeeAttendanceByEmpId(String empId);
	
	/**
	 * @Title: queryEmployeeAttendanceByLinkId
	 * @Description:根据实体标识查询员工考勤关系
	 * @param linkId 实体标识
	 * @return EmployeeAttendance
	 */
	EmployeeAttendance queryEmployeeAttendanceByLinkId(Integer linkId);
	
	/** 
	* @Title: queryEmployeeAttendanceByEmpId
	 * @Description:根据员工标识查询员工考勤关系
	 * @param empId 员工标识
	 * @return EmployeeAttendance
	*/
	EmployeeAttendance queryEmployeeAttendanceByEmpId(String empId);
	 
	/**
	 * @Title: queryEmployeeAttendanceForPage
	 * @Description: 根据员工考勤关系属性与分页信息分页查询员工考勤关系信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param employeeAttendance 实体
	 * @return List<EmployeeAttendance>
	 */
	Map<String, Object> queryEmployeeAttendanceForPage(Integer pagenum, Integer pagesize, String sort, EmployeeAttendance employeeAttendance);
	 
	 /**
	 * @Title: queryEmployeeAttendanceByProperty
	 * @Description:根据属性查询员工考勤关系
	 * @return List<EmployeeAttendance>
	 */
	 List<EmployeeAttendance> queryEmployeeAttendanceByProperty(Map<String, Object> map);	 
	 
}
