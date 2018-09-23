package com.jing.attendance.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.attendance.model.entity.AttendanceEmployee;
import com.jing.utils.paginator.domain.PageBounds;

/**
 * @ClassName: AttendanceEmployeeMapper
 * @Description: 员工考勤关系映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Mapper
public interface AttendanceEmployeeMapper {

	/**
	 * @Title: addAttendanceEmployee
	 * @Description:添加员工考勤关系
	 * @param employeeAttendance 实体
	 * @return Integer
	 */
	Integer addAttendanceEmployee(AttendanceEmployee employeeAttendance);
	
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
	  * @Title: queryAttendanceEmployeeByProperty
	  * @Description:查询已经绑定考勤关系的员工
	  * @return List<AttendanceEmployee>
	  */
	List<Map<String, String>> queryAttendanceEmployeeByProperty(Integer attendanceId);
	
	/** 
	* @Title: queryAttendanceEmployeeFree 
	* @Description: 查询没有绑定考勤的员工
	* @return  
	* List<Map<String,String>>    返回类型 
	* @throws 
	*/
	List<Map<String, String>> queryAttendanceEmployeeFree();

	/** 
	* @Title: queryAttendanceEmployeeAllForPage 
	* @Description: 根据员工考勤关系、员工、考勤规则属性与分页信息分页查询员工考勤信息
	* @param pageBounds
	* @param attendanceId
	* @param employee
	* @return  List<AttendanceEmployeeBo>    返回类型 
	* @throws 
	*/
	List<Map<String, Object>> queryAttendanceEmployeeAllForPage(PageBounds pageBounds, @Param("param") Map<String, Object> param);
	
	/** 
	* @Title: queryAttendanceEmployeeNotForPage 
	* @Description: 未关联考勤规则用户
	* @param pageBounds
	* @param param
	* @return  List<AttendanceEmployeeBo>    返回类型 
	* @throws 
	*/
	List<Map<String, Object>> queryAttendanceEmployeeForPage(PageBounds pageBounds, @Param("param") Map<String, Object> param);
	
	
	Integer dropAttendanceEmployeeByAttendanceId(Integer attendanceId);
	 
	 
	 
}
