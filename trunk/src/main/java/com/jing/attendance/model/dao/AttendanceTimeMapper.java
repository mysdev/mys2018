package com.jing.attendance.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.attendance.model.entity.AttendanceTime;

/**
 * @ClassName: AttendanceTimeMapper
 * @Description: 考勤时段 一个考勤方案至多三个时段映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月05日 09时32分
 */
@Mapper
public interface AttendanceTimeMapper {

	/**
	 * @Title: addAttendanceTime
	 * @Description:添加考勤时段 一个考勤方案至多三个时段
	 * @param attendanceTime 实体
	 * @return Integer
	 */
	Integer addAttendanceTime(AttendanceTime attendanceTime);
	
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
	 * @param pageBounds 分页信息
	 * @param attendanceTime 实体
	 * @return List<AttendanceTime>
	 */
	List<AttendanceTime> queryAttendanceTimeForPage(PageBounds pageBounds, @Param("attendanceTime") AttendanceTime attendanceTime);
	 
	 /**
	  * @Title: queryAttendanceTimeByProperty
	  * @Description:根据属性查询考勤时段 一个考勤方案至多三个时段
	  * @return List<AttendanceTime>
	  */
	 List<AttendanceTime> queryAttendanceTimeByProperty(@Param("attendanceTime") Map<String, Object> map);

	/** 
	* @Title: dropAttendanceTimeByAttendanceId 
	* @Description: 考勤规则下时间段定义清空
	* @param attendanceId
	* @return  Integer    返回类型 
	* @throws 
	*/
	Integer dropAttendanceTimeByAttendanceId(Integer attendanceId);
	 
	 
	 
}
