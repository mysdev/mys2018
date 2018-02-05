package com.jing.attendance.service;

import java.util.List;
import java.util.Map;


import com.jing.attendance.model.entity.AttendanceTime;

/**
 * @ClassName: AttendanceTime
 * @Description: 考勤时段 一个考勤方案至多三个时段服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月05日 09时32分
 */
public interface AttendanceTimeService {

    /**
	 * @Title: addAttendanceTime
	 * @Description:添加考勤时段 一个考勤方案至多三个时段
	 * @param attendanceTime 实体
	 * @return Integer
	 */
	AttendanceTime addAttendanceTime(AttendanceTime attendanceTime);
	
	/**
	 * @Title modifyAttendanceTime
	 * @Description:修改考勤时段 一个考勤方案至多三个时段
	 * @param attendanceTime 实体
	 * @return Integer
	 */
	Integer modifyAttendanceTime(AttendanceTime attendanceTime);
	
	/**
	 * @Title: dropAttendanceTimeById
	 * @Description:删除考勤时段 一个考勤方案至多三个时段
	 * @param id 实体标识
	 * @return Integer
	 */
	Integer dropAttendanceTimeById(Integer id);
	
	/**
	 * @Title: queryAttendanceTimeById
	 * @Description:根据实体标识查询考勤时段 一个考勤方案至多三个时段
	 * @param id 实体标识
	 * @return AttendanceTime
	 */
	AttendanceTime queryAttendanceTimeById(Integer id);
	 
	/**
	 * @Title: queryAttendanceTimeForPage
	 * @Description: 根据考勤时段 一个考勤方案至多三个时段属性与分页信息分页查询考勤时段 一个考勤方案至多三个时段信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param attendanceTime 实体
	 * @return List<AttendanceTime>
	 */
	Map<String, Object> queryAttendanceTimeForPage(Integer pagenum, Integer pagesize, String sort, AttendanceTime attendanceTime);
	 
	 /**
	 * @Title: queryAttendanceTimeByProperty
	 * @Description:根据属性查询考勤时段 一个考勤方案至多三个时段
	 * @return List<AttendanceTime>
	 */
	 List<AttendanceTime> queryAttendanceTimeByProperty(Map<String, Object> map);	 
	 
}
