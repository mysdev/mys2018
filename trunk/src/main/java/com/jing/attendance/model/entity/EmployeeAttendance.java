package com.jing.attendance.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: EmployeeAttendance
 * @Description: 员工考勤关系实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class EmployeeAttendance extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer linkId;	//tw_employee_attendance:link_id  自增标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String empId;	//tw_employee_attendance:emp_id  员工标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer attendanceId;	//tw_employee_attendance:attendance_id  考勤方案标识  


	/**
	* @DatabasetableColumnName: tw_employee_attendance:link_id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getLinkId(){
		return linkId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_employee_attendance:link_id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setLinkId(Integer linkId){
		this.linkId = linkId;	
	}	
	/**
	* @DatabasetableColumnName: tw_employee_attendance:emp_id
	* @Description: 获取属性        员工标识
	* @return: String
	*/
	public String getEmpId(){
		return empId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_employee_attendance:emp_id
	* @Description: 设置属性        员工标识
	* @return: String
	*/
	public void setEmpId(String empId){
		this.empId = empId;	
	}	
	/**
	* @DatabasetableColumnName: tw_employee_attendance:attendance_id
	* @Description: 获取属性        考勤方案标识
	* @return: Integer
	*/
	public Integer getAttendanceId(){
		return attendanceId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_employee_attendance:attendance_id
	* @Description: 设置属性        考勤方案标识
	* @return: Integer
	*/
	public void setAttendanceId(Integer attendanceId){
		this.attendanceId = attendanceId;	
	}	
	
	
	
	
}

