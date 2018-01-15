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
 * @ClassName: EmployeeAttend
 * @Description: 打卡记录实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class EmployeeAttend extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer attId;	//tw_employee_attend:att_id

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String employeeId;	//tw_employee_attend:employee_id    

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date attTime;	//tw_employee_attend:att_time    


	/**
	* @DatabasetableColumnName: tw_employee_attend:att_id
	* @Description: 获取属性        
	* @return: Integer
	*/
	public Integer getAttId(){
		return attId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_employee_attend:att_id
	* @Description: 设置属性        
	* @return: Integer
	*/
	public void setAttId(Integer attId){
		this.attId = attId;	
	}	
	/**
	* @DatabasetableColumnName: tw_employee_attend:employee_id
	* @Description: 获取属性        
	* @return: String
	*/
	public String getEmployeeId(){
		return employeeId;	
	}
	
	/**
	* @DatabasetableColumnName: tw_employee_attend:employee_id
	* @Description: 设置属性        
	* @return: String
	*/
	public void setEmployeeId(String employeeId){
		this.employeeId = employeeId;	
	}	
	/**
	* @DatabasetableColumnName: tw_employee_attend:att_time
	* @Description: 获取属性        
	* @return: Date
	*/
	public Date getAttTime(){
		return attTime;	
	}
	
	/**
	* @DatabasetableColumnName: tw_employee_attend:att_time
	* @Description: 设置属性        
	* @return: Date
	*/
	public void setAttTime(Date attTime){
		this.attTime = attTime;	
	}	
	
	
	
	
}

