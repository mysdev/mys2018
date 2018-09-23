/**  
 * Copyright © 2018公司名字. All rights reserved.
 * @Title: PublicAttendanceService.java
 * @Prject: mys
 * @Package: com.jing.attendance.service
 * @Description: TODO
 * @author: Jinlong He
 * @mail: hejinlong01@hnjing.com
 * @date: 2018年9月7日 下午2:20:19
 * @version: V1.0  
 */
package com.jing.attendance.service;

/**
 * @ClassName: PublicAttendanceService
 * @Description: 考勤公共处理类
 * @author: Jinlong He
 * @date: 2018年9月7日 下午2:20:19
 */
public interface PublicAttendanceService {
	
	/** 
	* @Title: doAndRedoPersonAttendance 
	* @Description: 初始化或重新生成员工考勤-全部 
	* @return void    返回类型 
	* @throws 
	*/
	void doAndRedoPersonAttendance();
	
	/** 
	* @Title: doAndRedoPersonAttendanceByAttendanceId 
	* @Description: 初始化或重新生成员工考勤-考勤
	* @param  attendanceId 考勤标识
	* @return void    返回类型 
	* @throws 
	*/
	void doAndRedoPersonAttendanceByAttendanceId(Integer attendanceId);
	
	/** 
	* @Title: doAndRedoPersonAttendanceByEmpId 
	* @Description: 初始化或重新生成员工考勤-人员
	* @param  empId 员工标识 
	* @return void    返回类型 
	* @throws 
	*/
	void doAndRedoPersonAttendanceByEmpId(String empId);
	
	
    /** 
	* @Title: initAttendanceDayWork 
	* @Description: 执行考勤日常任务：  锁定当日考勤详情，根据当日考勤详情生成员工考勤详情
	* @return  Boolean    返回类型 
	* @throws 
	*/
	Boolean initAttendanceDayWork();
}
