/**  
 * Copyright © 2018公司名字. All rights reserved.
 * @Title: PublicAttendanceServiceImpl.java
 * @Prject: mys
 * @Package: com.jing.attendance.service.impl
 * @Description: TODO
 * @author: Jinlong He
 * @mail: hejinlong01@hnjing.com
 * @date: 2018年9月7日 下午2:21:16
 * @version: V1.0  
 */
package com.jing.attendance.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.attendance.model.dao.AttendanceEmployeeMapper;
import com.jing.attendance.model.entity.Attendance;
import com.jing.attendance.model.entity.AttendanceEmployee;
import com.jing.attendance.service.AttendanceDiaryService;
import com.jing.attendance.service.AttendanceService;
import com.jing.attendance.service.PublicAttendanceService;

/**
 * @ClassName: PublicAttendanceServiceImpl
 * @Description: 考勤处理公共类
 * @author: Jinlong He
 * @date: 2018年9月7日 下午2:21:16
 */
@Service("publicAttendanceService")
@Transactional(readOnly=true)
public class PublicAttendanceServiceImpl implements PublicAttendanceService {

	@Autowired
	private AttendanceDiaryService attendanceDiaryService;
	
	@Autowired
    private AttendanceEmployeeMapper employeeAttendanceMapper;   
	
	@Autowired
	private AttendanceService attendanceService;
	
	/*
	 * @Title: doAndRedoPersonAttendance
	 * @Description: 
	 * @param     参数  
	 * @author Jinlong He
	 * @see com.jing.attendance.service.PublicAttendanceService#doAndRedoPersonAttendance()
	 */ 
	@Override
	@Transactional(readOnly = false)
	public void doAndRedoPersonAttendance() {
		//获取所有考勤规则
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", 0); //有效规则
		List<Attendance> ret = attendanceService.queryAttendanceByProperty(map); 
		if(ret!=null && ret.size()>0) {
			for(Attendance a : ret) {
				//循环处理所有考勤规则
				doAndRedoPersonAttendanceByAttendanceId(a.getAttendanceId());
			}
		}
	}

	/*
	 * @Title: doAndRedoPersonAttendanceByAttendanceId
	 * @Description: 
	 * @param @param attendanceId    参数  
	 * @author Jinlong He
	 * @param attendanceId
	 * @see com.jing.attendance.service.PublicAttendanceService#doAndRedoPersonAttendanceByAttendanceId(java.lang.Integer)
	 */ 
	@Override
	@Transactional(readOnly = false)
	public void doAndRedoPersonAttendanceByAttendanceId(Integer attendanceId) {
		//清空第二天以后规则下所有员工考勤数据
		attendanceDiaryService.clearFutureDiaryRecordByAttendanceId(attendanceId);
		//重新写入
		attendanceDiaryService.insertFutureDiaryRecordByAttendanceId(attendanceId);
	}

	/*
	 * @Title: doAndRedoPersonAttendanceByEmpId
	 * @Description: 
	 * @param @param empId    参数  
	 * @author Jinlong He
	 * @param empId
	 * @see com.jing.attendance.service.PublicAttendanceService#doAndRedoPersonAttendanceByEmpId(java.lang.String)
	 */ 
	@Override
	@Transactional(readOnly = false)
	public void doAndRedoPersonAttendanceByEmpId(String empId) {
		//清空第二天以后个人考勤数据
		attendanceDiaryService.clearFutureDiaryRecord(empId);
		//查询员工对应的考勤规则
		AttendanceEmployee ae = employeeAttendanceMapper.queryAttendanceEmployeeByEmpId(empId);
		if(ae!=null && ae.getAttendanceId()!=null) {
			//重新写入
			attendanceDiaryService.insertFutureDiaryRecordByEmployeeId(empId);
		}
	}


}
