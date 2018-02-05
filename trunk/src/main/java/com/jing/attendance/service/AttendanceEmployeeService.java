package com.jing.attendance.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.jing.attendance.model.entity.AttendanceEmployee;
import com.jing.attendance.service.bo.AttendanceEmployeeBo;
import com.jing.core.model.entity.Employee;

/**
 * @ClassName: AttendanceEmployee
 * @Description: 员工考勤关系服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public interface AttendanceEmployeeService {

    /**
	 * @Title: addAttendanceEmployee
	 * @Description:添加员工考勤关系
	 * @param employeeAttendance 实体
	 * @return Integer
	 */
	AttendanceEmployee addAttendanceEmployee(AttendanceEmployee employeeAttendance);
	
	/**
	 * @Title modifyAttendanceEmployee
	 * @Description:修改员工考勤关系
	 * @param employeeAttendance 实体
	 * @return Integer
	 */
	Integer modifyAttendanceEmployee(AttendanceEmployee employeeAttendance);
	
	/**
	 * @Title: dropAttendanceEmployeeByLinkId
	 * @Description:删除员工考勤关系
	 * @param linkId 实体标识
	 * @return Integer
	 */
	Integer dropAttendanceEmployeeByLinkId(Integer linkId);
	
	/**
	 * @Title: dropAttendanceEmployeeByLinkId
	 * @Description:删除员工考勤关系
	 * @param empId 员工标识
	 * @return Integer
	 */
	Integer dropAttendanceEmployeeByEmpId(String empId);
	
	/**
	 * @Title: queryAttendanceEmployeeByLinkId
	 * @Description:根据实体标识查询员工考勤关系
	 * @param linkId 实体标识
	 * @return AttendanceEmployee
	 */
	AttendanceEmployee queryAttendanceEmployeeByLinkId(Integer linkId);
	
	/** 
	* @Title: queryAttendanceEmployeeByEmpId
	 * @Description:根据员工标识查询员工考勤关系
	 * @param empId 员工标识
	 * @return AttendanceEmployee
	*/
	AttendanceEmployee queryAttendanceEmployeeByEmpId(String empId);
	 
	/**
	 * @Title: queryAttendanceEmployeeForPage
	 * @Description: 根据员工考勤关系属性与分页信息分页查询员工考勤关系信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param employeeAttendance 实体
	 * @return List<AttendanceEmployee>
	 */
	Map<String, Object> queryAttendanceEmployeeForPage(Integer pagenum, Integer pagesize, String sort, AttendanceEmployee employeeAttendance);
	 
	 /**
	 * @Title: queryAttendanceEmployeeByProperty
	 * @Description:根据属性查询员工考勤关系
	 * @return List<AttendanceEmployee>
	 */
	List<AttendanceEmployee> queryAttendanceEmployeeByProperty(Map<String, Object> map);

	/** 
	* @Title: queryAttendanceEmployeeForPage 
	* @Description: 根据考勤或员工属性查询信息
	* @param pagenum
	* @param pagesize
	* @param sort
	* @param attendanceId 考勤标识
	* @param employee 员工属性
	* @param namePYJob 员工姓名、拼音、工号
	* @return  List<AttendanceEmployeeBo>    返回类型 
	* @throws 
	*/
	HashMap<String, Object> queryAttendanceEmployeeForPage(Integer pagenum, Integer pagesize, String sort, Integer attendanceId,
			Employee employee, String namePYJob);

	/** 
	* @Title: bindAttendanceEmployee 
	* @Description: 员工考勤关系绑定
	* @param attendanceId
	* @param empList
	* @return  Integer    返回类型 
	* @throws 
	*/
	Integer bindAttendanceEmployee(String userId, Integer attendanceId, List<String> empList);	 
	 
}
