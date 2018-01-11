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
 * @ClassName: AttendanceDetail
 * @Description: 门店考勤详情实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class AttendanceDetail extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer attId;	//tw_attendance_detail:att_id  门店标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer attendanceId;	//tw_attendance_detail:attendance_id  考勤标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date attDate;	//tw_attendance_detail:att_date  考勤日期  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer attendance;	//tw_attendance_detail:attendance  是否考勤 0考勤  


	/**
	* @DatabasetableColumnName: tw_attendance_detail:att_id
	* @Description: 获取属性        门店标识
	* @return: Integer
	*/
	public Integer getAttId(){
		return attId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_detail:att_id
	* @Description: 设置属性        门店标识
	* @return: Integer
	*/
	public void setAttId(Integer attId){
		this.attId = attId;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_detail:attendance_id
	* @Description: 获取属性        考勤标识
	* @return: Integer
	*/
	public Integer getAttendanceId(){
		return attendanceId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_detail:attendance_id
	* @Description: 设置属性        考勤标识
	* @return: Integer
	*/
	public void setAttendanceId(Integer attendanceId){
		this.attendanceId = attendanceId;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_detail:att_date
	* @Description: 获取属性        考勤日期
	* @return: Date
	*/
	public Date getAttDate(){
		return attDate;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_detail:att_date
	* @Description: 设置属性        考勤日期
	* @return: Date
	*/
	public void setAttDate(Date attDate){
		this.attDate = attDate;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_detail:attendance
	* @Description: 获取属性        是否考勤 0考勤
	* @return: Integer
	*/
	public Integer getAttendance(){
		return attendance;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_detail:attendance
	* @Description: 设置属性        是否考勤 0考勤
	* @return: Integer
	*/
	public void setAttendance(Integer attendance){
		this.attendance = attendance;	
	}	
	
	
	
	
}

