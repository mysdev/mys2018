package com.jing.attendance.model.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @ClassName: AttendanceTime
 * @Description: 考勤时段 一个考勤方案至多三个时段实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月05日 09时32分
 */
public class AttendanceTime implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer id;	//tw_attendance_time:id  自增标识  

	//@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer attendanceId;	//tw_attendance_time:attendance_id  考勤标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=3, message="{org.hibernate.validator.constraints.Length.message}")
	private String name;	//tw_attendance_time:name  时段名称  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Pattern(regexp="^((20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d)$", message="{validator.time.message}")
	private String signTime;	//tw_attendance_time:sign_time  上班时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Pattern(regexp="^((20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d)$", message="{validator.time.message}")
	private String outTime;	//tw_attendance_time:out_time  下班时间  


	/**
	* @DatabasetableColumnName: tw_attendance_time:id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getId(){
		return id;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_time:id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setId(Integer id){
		this.id = id;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_time:attendance_id
	* @Description: 获取属性        考勤标识
	* @return: Integer
	*/
	public Integer getAttendanceId(){
		return attendanceId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_time:attendance_id
	* @Description: 设置属性        考勤标识
	* @return: Integer
	*/
	public void setAttendanceId(Integer attendanceId){
		this.attendanceId = attendanceId;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_time:name
	* @Description: 获取属性        时段名称
	* @return: String
	*/
	public String getName(){
		return name;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_time:name
	* @Description: 设置属性        时段名称
	* @return: String
	*/
	public void setName(String name){
		this.name = name;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_time:sign_time
	* @Description: 获取属性        上班时间
	* @return: String
	*/
	public String getSignTime(){
		return signTime;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_time:sign_time
	* @Description: 设置属性        上班时间
	* @return: String
	*/
	public void setSignTime(String signTime){
		this.signTime = signTime;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_time:out_time
	* @Description: 获取属性        下班时间
	* @return: String
	*/
	public String getOutTime(){
		return outTime;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_time:out_time
	* @Description: 设置属性        下班时间
	* @return: String
	*/
	public void setOutTime(String outTime){
		this.outTime = outTime;	
	}	
	
	
	
	
}

