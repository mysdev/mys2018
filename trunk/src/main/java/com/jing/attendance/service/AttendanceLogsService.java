package com.jing.attendance.service;

import java.util.List;
import java.util.Map;


import com.jing.attendance.model.entity.AttendanceLogs;

/**
 * @ClassName: AttendanceLogs
 * @Description: 员工考勤记录表服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月07日 22时18分
 */
public interface AttendanceLogsService {

    /**
	 * @Title: addAttendanceLogs
	 * @Description:添加员工考勤记录表
	 * @param attendanceLogs 实体
	 * @return Integer
	 */
	AttendanceLogs addAttendanceLogs(AttendanceLogs attendanceLogs);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param attendanceLogs 实体
	 * @return List<AttendanceLogs>
	 */
	Map<String, Object> queryAttendanceLogsForPage(Integer pagenum, Integer pagesize, String sort, AttendanceLogs attendanceLogs);
	 
	 /**
	 * @Title: queryAttendanceLogsByProperty
	 * @Description:根据属性查询员工考勤记录表
	 * @return List<AttendanceLogs>
	 */
	 List<AttendanceLogs> queryAttendanceLogsByProperty(Map<String, Object> map);	 
	 
}
