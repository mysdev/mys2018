package com.jing.attendance.model.entity;

import java.io.Serializable;
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
 * @date: 2018年01月31日 10时00分
 */
public class AttendanceDetail extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer attId;	//tw_attendance_detail:att_id  详情标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")	
	private Integer attendanceId;	//tw_attendance_detail:attendance_id  考勤标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=1, max=7, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer weekday;	//tw_attendance_detail:weekday  星期  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date attDate;	//tw_attendance_detail:att_date  考勤日期  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=7, message="{org.hibernate.validator.constraints.Length.message}")
	private String attMonth;	//tw_attendance_detail:att_month  归属月份  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=1, max=31, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer attDay;	//tw_attendance_detail:att_day  日-月  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer attendance;	//tw_attendance_detail:attendance  是否考勤 0考勤 
	
	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer editable;

	private Integer timeId;
	
	//@Pattern(regexp="^((20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d)$", message="{validator.time.message}")
	private Date signTime;
	
	//@Pattern(regexp="^((20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d)$", message="{validator.time.message}")
	private Date outTime;

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
	* @DatabasetableColumnName: tw_attendance_detail:weekday
	* @Description: 获取属性        星期
	* @return: Integer
	*/
	public Integer getWeekday(){
		return weekday;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_detail:weekday
	* @Description: 设置属性        星期
	* @return: Integer
	*/
	public void setWeekday(Integer weekday){
		this.weekday = weekday;	
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
	* @DatabasetableColumnName: tw_attendance_detail:att_month
	* @Description: 获取属性        归属月份
	* @return: String
	*/
	public String getAttMonth(){
		return attMonth;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_detail:att_month
	* @Description: 设置属性        归属月份
	* @return: String
	*/
	public void setAttMonth(String attMonth){
		this.attMonth = attMonth;	
	}	
	/**
	* @DatabasetableColumnName: tw_attendance_detail:att_day
	* @Description: 获取属性        日-月
	* @return: Integer
	*/
	public Integer getAttDay(){
		return attDay;	
	}
	
	/**
	* @DatabasetableColumnName: tw_attendance_detail:att_day
	* @Description: 设置属性        日-月
	* @return: Integer
	*/
	public void setAttDay(Integer attDay){
		this.attDay = attDay;	
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

	/**
	 * @return the timeId
	 */
	public Integer getTimeId() {
		return timeId;
	}

	/**
	 * @param timeId the timeId to set
	 */
	public void setTimeId(Integer timeId) {
		this.timeId = timeId;
	}

	/**
	 * @return the signTime
	 */
	public Date getSignTime() {
		return signTime;
	}

	/**
	 * @param signTime the signTime to set
	 */
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	/**
	 * @return the outTime
	 */
	public Date getOutTime() {
		return outTime;
	}

	/**
	 * @param outTime the outTime to set
	 */
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	/**
	 * @return the editable
	 */
	public Integer getEditable() {
		return editable;
	}

	/**
	 * @param editable the editable to set
	 */
	public void setEditable(Integer editable) {
		this.editable = editable;
	}	
	
	
	
	
}

