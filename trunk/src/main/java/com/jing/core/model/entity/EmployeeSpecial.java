package com.jing.core.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: EmployeeSpecial
 * @Description: 员工特殊权限(扩)实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class EmployeeSpecial extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String empId;	//tb_employee_special:emp_id  员工标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String empPwd;	//tb_employee_special:emp_pwd  授权码  

	private java.math.BigDecimal creditMount;	//tb_employee_special:credit_mount  授信额度  

	private java.math.BigDecimal creditLeft;	//tb_employee_special:credit_left  授信余额  


	/**
	* @DatabasetableColumnName: tb_employee_special:emp_id
	* @Description: 获取属性        员工标识
	* @return: String
	*/
	public String getEmpId(){
		return empId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee_special:emp_id
	* @Description: 设置属性        员工标识
	* @return: String
	*/
	public void setEmpId(String empId){
		this.empId = empId;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee_special:emp_pwd
	* @Description: 获取属性        授权码
	* @return: String
	*/
	public String getEmpPwd(){
		return empPwd;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee_special:emp_pwd
	* @Description: 设置属性        授权码
	* @return: String
	*/
	public void setEmpPwd(String empPwd){
		this.empPwd = empPwd;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee_special:credit_mount
	* @Description: 获取属性        授信额度
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getCreditMount(){
		return creditMount;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee_special:credit_mount
	* @Description: 设置属性        授信额度
	* @return: java.math.BigDecimal
	*/
	public void setCreditMount(java.math.BigDecimal creditMount){
		this.creditMount = creditMount;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee_special:credit_left
	* @Description: 获取属性        授信余额
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getCreditLeft(){
		return creditLeft;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee_special:credit_left
	* @Description: 设置属性        授信余额
	* @return: java.math.BigDecimal
	*/
	public void setCreditLeft(java.math.BigDecimal creditLeft){
		this.creditLeft = creditLeft;	
	}	
	
	
	
	
}

