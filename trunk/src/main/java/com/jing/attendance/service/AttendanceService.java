package com.jing.attendance.service;

import java.util.List;
import java.util.Map;

import com.jing.attendance.controller.vo.AttendanceBo;
import com.jing.attendance.model.entity.Attendance;

/**
 * @ClassName: Attendance
 * @Description: 门店考勤服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public interface AttendanceService {

    /**
	 * @Title: addAttendance
	 * @Description:添加门店考勤
	 * @param AttendanceBo 实体
	 * @return Integer
	 */
	Attendance addAttendance(AttendanceBo attendance);
	
	/**
	 * @Title modifyAttendance
	 * @Description:修改门店考勤
	 * @param AttendanceBo 实体
	 * @return Integer
	 */
	Integer modifyAttendance(AttendanceBo attendance);
	
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
	 * @return AttendanceBo
	 */
	AttendanceBo queryAttendanceByAttendanceId(Integer attendanceId);
	 
	/**
	 * @Title: queryAttendanceForPage
	 * @Description: 根据门店考勤属性与分页信息分页查询门店考勤信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param attendance 实体
	 * @return List<Attendance>
	 */
	Map<String, Object> queryAttendanceForPage(Integer pagenum, Integer pagesize, String sort, Attendance attendance);
	 
	 /**
	 * @Title: queryAttendanceByProperty
	 * @Description:根据属性查询门店考勤
	 * @return List<Attendance>
	 */
	 List<Attendance> queryAttendanceByProperty(Map<String, Object> map);	 
	 
	 

	 
}
