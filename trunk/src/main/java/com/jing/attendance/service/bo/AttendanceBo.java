package com.jing.attendance.service.bo;

import java.util.List;

import com.jing.attendance.model.entity.Attendance;
import com.jing.attendance.model.entity.AttendanceDetail;

/**
 * @ClassName: AttendanceBo
 * @Description: 考勤信息与详情
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
		this.setStoreId(attendance.getStoreId());
		this.setAttendanceName(attendance.getAttendanceName());
		this.setSignTime(attendance.getSignTime());
		this.setOutTime(attendance.getOutTime());
		this.setAttendance(attendance.getAttendance());
		this.setTypes(attendance.getTypes());
		this.setCreatedBy(attendance.getCreatedBy());
		this.setCreatedDate(attendance.getCreatedDate());
		this.setUpdatedBy(attendance.getUpdatedBy());
		this.setUpdatedDate(attendance.getUpdatedDate());
		this.setStatus(attendance.getStatus());		
	}
	
	//考勤详情信息
	private List<AttendanceDetail> attendanceDetailList;

	public List<AttendanceDetail> getAttendanceDetailList() {
		return attendanceDetailList;
	}

	public void setAttendanceDetailList(List<AttendanceDetail> attendanceDetailList) {
		this.attendanceDetailList = attendanceDetailList;
	}
}
