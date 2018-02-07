package com.jing.attendance.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 * @ClassName: AttendanceLogs
 * @Description: 员工考勤记录表实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月07日 22时18分
 */
public class AttendanceLogs implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer id;	//tw_attendance_logs:id  标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String empId;	//tw_attendance_logs:emp_id  员工标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date attTime;	//tw_attendance_logs:att_time  签名时间  

	@Length(min=0, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String attNote;	//tw_attendance_logs:att_note  说明  


	/**
	* @DatabasetableColumnName: tw_attendance_logs:id
	* @Description: 获取属性        标识
	* @return: Integer
	*/
	public Integer getId(){
		return id;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_logs:id
	* @Description: 设置属性        标识
	* @return: Integer
	*/
	public void setId(Integer id){
		this.id = id;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_logs:emp_id
	* @Description: 获取属性        员工标识
	* @return: String
	*/
	public String getEmpId(){
		return empId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_logs:emp_id
	* @Description: 设置属性        员工标识
	* @return: String
	*/
	public void setEmpId(String empId){
		this.empId = empId;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_logs:att_time
	* @Description: 获取属性        签名时间
	* @return: Date
	*/
	public Date getAttTime(){
		return attTime;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_logs:att_time
	* @Description: 设置属性        签名时间
	* @return: Date
	*/
	public void setAttTime(Date attTime){
		this.attTime = attTime;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_logs:att_note
	* @Description: 获取属性        说明
	* @return: String
	*/
	public String getAttNote(){
		return attNote;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_logs:att_note
	* @Description: 设置属性        说明
	* @return: String
	*/
	public void setAttNote(String attNote){
		this.attNote = attNote;	
	}	
	
	
	
	
}

