package com.jing.attendance.service.bo;

import com.jing.core.model.entity.Employee;

/**
 * @ClassName: EmployeeAttendanceBo
 * @Description: 员工、考勤规则、关联
 * @author: Jinlong He
 * @date: 2018年1月15日 下午4:58:48
 */
public class EmployeeAttendanceBo extends Employee{	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer linkId;
	private String attendanceName;
	private Integer attendanceId;
	private String namePYJob;
	
	public Integer getLinkId() {
		return linkId;
	}
	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}
	public String getAttendanceName() {
		return attendanceName;
	}
	public void setAttendanceName(String attendanceName) {
		this.attendanceName = attendanceName;
	}
	public Integer getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}
	public String getNamePYJob() {
		return namePYJob;
	}
	public void setNamePYJob(String namePYJob) {
		this.namePYJob = namePYJob;
	}
	
	

}
