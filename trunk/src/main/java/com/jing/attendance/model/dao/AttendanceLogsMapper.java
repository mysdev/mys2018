package com.jing.attendance.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.attendance.model.entity.AttendanceLogs;

/**
 * @ClassName: AttendanceLogsMapper
 * @Description: 员工考勤记录表映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月07日 22时18分
 */
@Mapper
public interface AttendanceLogsMapper {

	/**
	 * @Title: addAttendanceLogs
	 * @Description:添加员工考勤记录表
	 * @param attendanceLogs 实体
	 * @return Integer
	 */
	Integer addAttendanceLogs(AttendanceLogs attendanceLogs);
	
	/**
	 * @Title modifyAttendanceLogs
	 * @Description:修改员工考勤记录表
	 * @param attendanceLogs 实体
	 * @return Integer
	 */
	Integer modifyAttendanceLogs(AttendanceLogs attendanceLogs);
	
	/**
	 * @Title: dropAttendanceLogsById
	 * @Description:删除员工考勤记录表
	 * @param id 实体标识
	 * @return Integer
	 */
	Integer dropAttendanceLogsById(Integer id);
	
	/**
	 * @Title: queryAttendanceLogsById
	 * @Description:根据实体标识查询员工考勤记录表
	 * @param id 实体标识
	 * @return AttendanceLogs
	 */
	AttendanceLogs queryAttendanceLogsById(Integer id);
	 
	/**
	 * @Title: queryAttendanceLogsForPage
	 * @Description: 根据员工考勤记录表属性与分页信息分页查询员工考勤记录表信息
	 * @param pageBounds 分页信息
	 * @param attendanceLogs 实体
	 * @return List<AttendanceLogs>
	 */
	List<AttendanceLogs> queryAttendanceLogsForPage(PageBounds pageBounds, @Param("attendanceLogs") AttendanceLogs attendanceLogs);
	 
	 /**
	  * @Title: queryAttendanceLogsByProperty
	  * @Description:根据属性查询员工考勤记录表
	  * @return List<AttendanceLogs>
	  */
	 List<AttendanceLogs> queryAttendanceLogsByProperty(@Param("attendanceLogs") Map<String, Object> map);
	 
	 
	 
}
