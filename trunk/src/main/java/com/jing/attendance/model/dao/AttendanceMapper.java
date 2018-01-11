package com.jing.attendance.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.attendance.model.entity.Attendance;

/**
 * @ClassName: AttendanceMapper
 * @Description: 门店考勤映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Mapper
public interface AttendanceMapper {

	/**
	 * @Title: addAttendance
	 * @Description:添加门店考勤
	 * @param attendance 实体
	 * @return Integer
	 */
	Integer addAttendance(Attendance attendance);
	
	/**
	 * @Title modifyAttendance
	 * @Description:修改门店考勤
	 * @param attendance 实体
	 * @return Integer
	 */
	Integer modifyAttendance(Attendance attendance);
	
	/**
	 * @Title: dropAttendanceByAttendanceId
	 * @Description:删除门店考勤
	 * @param attendanceId 实体标识
	 * @return Integer
	 */
	Integer dropAttendanceByAttendanceId(Integer attendanceId);
	
	/**
	 * @Title: queryAttendanceByAttendanceId
	 * @Description:根据实体标识查询门店考勤
	 * @param attendanceId 实体标识
	 * @return Attendance
	 */
	Attendance queryAttendanceByAttendanceId(Integer attendanceId);
	 
	/**
	 * @Title: queryAttendanceForPage
	 * @Description: 根据门店考勤属性与分页信息分页查询门店考勤信息
	 * @param pageBounds 分页信息
	 * @param attendance 实体
	 * @return List<Attendance>
	 */
	List<Attendance> queryAttendanceForPage(PageBounds pageBounds, @Param("attendance") Attendance attendance);
	 
	 /**
	  * @Title: queryAttendanceByProperty
	  * @Description:根据属性查询门店考勤
	  * @return List<Attendance>
	  */
	 List<Attendance> queryAttendanceByProperty(@Param("attendance") Map<String, Object> map);
	 
	 
	 
}
