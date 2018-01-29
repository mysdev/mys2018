package com.jing.attendance.model.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Attendance
 * @Description: 门店考勤实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class Attendance extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer attendanceId;	//tw_attendance:attendance_id  考勤方案标识  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tw_attendance:store_id  门店标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String attendanceName;	//tw_attendance:attendance_name  考勤方案名称  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer status;	//tw_attendance:status  考勤方案状态 0正常 1停用

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=2, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer types;	//tw_attendance:types  考勤方案方案 0休天数 1考勤天数 2详情  

	@Range(min=0, max=31, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer attendance;	//tw_attendance:attendance  休息天数 类型0休天数 1考勤天数时有效  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Pattern(regexp="^((20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d)$", message="{validator.time.message}")
	private String signTime;	//tw_attendance:sign_time  上班时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Pattern(regexp="^((20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d)$", message="{validator.time.message}")
	private String outTime;	//tw_attendance:out_time  下班时间  

	/**
	* @DatabasetableColumnName: tw_attendance:attendance_id
	* @Description: 获取属性        考勤方案标识
	* @return: Integer
	*/
	public Integer getAttendanceId(){
		return attendanceId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance:attendance_id
	* @Description: 设置属性        考勤方案标识
	* @return: Integer
	*/
	public void setAttendanceId(Integer attendanceId){
		this.attendanceId = attendanceId;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance:store_id
	* @Description: 获取属性        门店标识
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance:store_id
	* @Description: 设置属性        门店标识
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance:attendance_name
	* @Description: 获取属性        考勤方案名称
	* @return: String
	*/
	public String getAttendanceName(){
		return attendanceName;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance:attendance_name
	* @Description: 设置属性        考勤方案名称
	* @return: String
	*/
	public void setAttendanceName(String attendanceName){
		this.attendanceName = attendanceName;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance:status
	* @Description: 获取属性        考勤方案状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance:status
	* @Description: 设置属性        考勤方案状态 0正常 1停用
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance:types
	* @Description: 获取属性        考勤方案方案 0休天数 1考勤天数 2详情  
	* @return: Integer
	*/
	public Integer getTypes(){
		return types;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance:types
	* @Description: 设置属性        考勤方案方案 0休天数 1考勤天数 2详情
	* @return: Integer
	*/
	public void setTypes(Integer types){
		this.types = types;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance:attendance
	* @Description: 获取属性        休息天数 类型0休天数 1考勤天数时有效
	* @return: Integer
	*/
	public Integer getAttendance(){
		return attendance;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance:attendance
	* @Description: 设置属性        休息天数 类型0休天数 1考勤天数时有效
	* @return: Integer
	*/
	public void setAttendance(Integer attendance){
		this.attendance = attendance;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance:sign_time
	* @Description: 获取属性        上班时间
	* @return: java.sql.Timestamp
	*/
	public String getSignTime(){
		return signTime;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance:sign_time
	* @Description: 设置属性        上班时间
	* @return: java.sql.Timestamp
	*/
	public void setSignTime(String signTime){
		this.signTime = signTime;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance:out_time
	* @Description: 获取属性        下班时间
	* @return: java.sql.Timestamp
	*/
	public String getOutTime(){
		return outTime;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance:out_time
	* @Description: 设置属性        下班时间
	* @return: java.sql.Timestamp
	*/
	public void setOutTime(String outTime){
		this.outTime = outTime;	
	}	
	
	
	
	
}

