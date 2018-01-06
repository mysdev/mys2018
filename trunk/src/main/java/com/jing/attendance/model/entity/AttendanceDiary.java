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
 * @ClassName: AttendanceDiary
 * @Description: 打卡记录实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月05日 22时39分
 */
public class AttendanceDiary implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer attId;	//tw_attendance_diary:att_id  自增标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String employeeId;	//tw_attendance_diary:employee_id  员工号 
	
	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer attendance;	//tw_attendance_diary:attendance  是否考勤 0考勤

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date attTime;	//tw_attendance_diary:att_time  打卡时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date sysSign;	//tw_attendance_diary:sys_sign  应到时间  

	private Date signTime;	//tw_attendance_diary:sign_time  实签时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date sysOut;	//tw_attendance_diary:sys_out  应退时间  

	private Date outTime;	//tw_attendance_diary:out_time  实退时间  


	/**
	* @DatabasetableColumnName: tw_attendance_diary:att_id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getAttId(){
		return attId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:att_id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setAttId(Integer attId){
		this.attId = attId;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:employee_id
	* @Description: 获取属性        员工号
	* @return: String
	*/
	public String getEmployeeId(){
		return employeeId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:employee_id
	* @Description: 设置属性        员工号
	* @return: String
	*/
	public void setEmployeeId(String employeeId){
		this.employeeId = employeeId;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:att_time
	* @Description: 获取属性        打卡时间
	* @return: Date
	*/
	public Date getAttTime(){
		return attTime;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:att_time
	* @Description: 设置属性        打卡时间
	* @return: Date
	*/
	public void setAttTime(Date attTime){
		this.attTime = attTime;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:sys_sign
	* @Description: 获取属性        应到时间
	* @return: Date
	*/
	public Date getSysSign(){
		return sysSign;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:sys_sign
	* @Description: 设置属性        应到时间
	* @return: Date
	*/
	public void setSysSign(Date sysSign){
		this.sysSign = sysSign;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:sign_time
	* @Description: 获取属性        实签时间
	* @return: Date
	*/
	public Date getSignTime(){
		return signTime;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:sign_time
	* @Description: 设置属性        实签时间
	* @return: Date
	*/
	public void setSignTime(Date signTime){
		this.signTime = signTime;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:sys_out
	* @Description: 获取属性        应退时间
	* @return: Date
	*/
	public Date getSysOut(){
		return sysOut;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:sys_out
	* @Description: 设置属性        应退时间
	* @return: Date
	*/
	public void setSysOut(Date sysOut){
		this.sysOut = sysOut;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:out_time
	* @Description: 获取属性        实退时间
	* @return: Date
	*/
	public Date getOutTime(){
		return outTime;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_diary:out_time
	* @Description: 设置属性        实退时间
	* @return: Date
	*/
	public void setOutTime(Date outTime){
		this.outTime = outTime;	
	}

	/**
	 * @return the attendance
	 */
	public Integer getAttendance() {
		return attendance;
	}

	/**
	 * @param attendance the attendance to set
	 */
	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}	
	
	
	
	
}

