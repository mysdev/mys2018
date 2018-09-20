package com.jing.attendance.controller.vo;

import java.util.List;

import com.jing.attendance.model.entity.Attendance;
import com.jing.attendance.model.entity.AttendanceTime;

/**
 * @ClassName: AttendanceBo
 * @Description: 考勤信息与详情
 * 考勤信息只负责考勤表的操作
 * 详情分年月处理
 * @author: Jinlong He
 * @date: 2018年1月15日 下午2:29:25
 */
public class AttendanceBo extends Attendance{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;

	public AttendanceBo(){
		super();
	}
	
	public AttendanceBo(Attendance attendance){
		super();
		this.setAttendanceId(attendance.getAttendanceId());
		this.setAttendanceName(attendance.getAttendanceName());
		this.setSignCt(attendance.getSignCt());
		this.setOutCt(attendance.getOutCt());
		this.setAttendance(attendance.getAttendance());
		this.setTypes(attendance.getTypes());
		this.setCreatedBy(attendance.getCreatedBy());
		this.setCreatedDate(attendance.getCreatedDate());
		this.setUpdatedBy(attendance.getUpdatedBy());
		this.setUpdatedDate(attendance.getUpdatedDate());
		this.setStatus(attendance.getStatus());		
	}
	
	/**
	 * @fieldName: attTime
	 * @fieldType: List<AttendanceTime>
	 * @Description: 考勤时段
	 */
	private List<AttendanceTime> attTime;
	
	public List<AttendanceTime> getAttTime() {
		return attTime;
	}

	public void setAttTime(List<AttendanceTime> attTime) {
		this.attTime = attTime;
	}

	
}
