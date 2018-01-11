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
 * @ClassName: EmployeeJournal
 * @Description: 员工考勤日志实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class EmployeeJournal extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer journalId;	//tw_employee_journal:journal_id  自增标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String empId;	//tw_employee_journal:emp_id  员工标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date attendanceDate;	//tw_employee_journal:attendance_date  考勤日期  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date signTime;	//tw_employee_journal:sign_time  签到时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date outTime;	//tw_employee_journal:out_time  签退时间  


	/**
	* @DatabasetableColumnName: tw_employee_journal:journal_id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getJournalId(){
		return journalId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_employee_journal:journal_id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setJournalId(Integer journalId){
		this.journalId = journalId;	
	}	
	/**
	* @DatabasetableColumnName: tw_employee_journal:emp_id
	* @Description: 获取属性        员工标识
	* @return: String
	*/
	public String getEmpId(){
		return empId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_employee_journal:emp_id
	* @Description: 设置属性        员工标识
	* @return: String
	*/
	public void setEmpId(String empId){
		this.empId = empId;	
	}	
	/**
	* @DatabasetableColumnName: tw_employee_journal:attendance_date
	* @Description: 获取属性        考勤日期
	* @return: Date
	*/
	public Date getAttendanceDate(){
		return attendanceDate;	
	}
	
	/**
	* @DatabasetableColumnName: tw_employee_journal:attendance_date
	* @Description: 设置属性        考勤日期
	* @return: Date
	*/
	public void setAttendanceDate(Date attendanceDate){
		this.attendanceDate = attendanceDate;	
	}	
	/**
	* @DatabasetableColumnName: tw_employee_journal:sign_time
	* @Description: 获取属性        签到时间
	* @return: Date
	*/
	public Date getSignTime(){
		return signTime;	
	}
	
	/**
	* @DatabasetableColumnName: tw_employee_journal:sign_time
	* @Description: 设置属性        签到时间
	* @return: Date
	*/
	public void setSignTime(Date signTime){
		this.signTime = signTime;	
	}	
	/**
	* @DatabasetableColumnName: tw_employee_journal:out_time
	* @Description: 获取属性        签退时间
	* @return: Date
	*/
	public Date getOutTime(){
		return outTime;	
	}
	
	/**
	* @DatabasetableColumnName: tw_employee_journal:out_time
	* @Description: 设置属性        签退时间
	* @return: Date
	*/
	public void setOutTime(Date outTime){
		this.outTime = outTime;	
	}	
	
	
	
	
}

