package com.jing.core.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: MemberRecord
 * @Description: 会员充值记录实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class MemberRecord extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer recordId;	//tb_member_record:record_id  记录标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String memberId;	//tb_member_record:member_id  会员标识  

	private Integer plusId;	//tb_member_record:plus_id  活动标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal plusMoney;	//tb_member_record:plus_money  充值金额  

	private java.math.BigDecimal giftMoney;	//tb_member_record:gift_money  赠送金额  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String employeeId;	//tb_member_record:employee_id  员工标识  

	private java.math.BigDecimal money;	//tb_member_record:money  员工提成  


	/**
	* @DatabasetableColumnName: tb_member_record:record_id
	* @Description: 获取属性        记录标识
	* @return: Integer
	*/
	public Integer getRecordId(){
		return recordId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_record:record_id
	* @Description: 设置属性        记录标识
	* @return: Integer
	*/
	public void setRecordId(Integer recordId){
		this.recordId = recordId;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_record:member_id
	* @Description: 获取属性        会员标识
	* @return: String
	*/
	public String getMemberId(){
		return memberId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_record:member_id
	* @Description: 设置属性        会员标识
	* @return: String
	*/
	public void setMemberId(String memberId){
		this.memberId = memberId;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_record:plus_id
	* @Description: 获取属性        活动标识
	* @return: Integer
	*/
	public Integer getPlusId(){
		return plusId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_record:plus_id
	* @Description: 设置属性        活动标识
	* @return: Integer
	*/
	public void setPlusId(Integer plusId){
		this.plusId = plusId;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_record:plus_money
	* @Description: 获取属性        充值金额
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getPlusMoney(){
		return plusMoney;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_record:plus_money
	* @Description: 设置属性        充值金额
	* @return: java.math.BigDecimal
	*/
	public void setPlusMoney(java.math.BigDecimal plusMoney){
		this.plusMoney = plusMoney;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_record:gift_money
	* @Description: 获取属性        赠送金额
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getGiftMoney(){
		return giftMoney;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_record:gift_money
	* @Description: 设置属性        赠送金额
	* @return: java.math.BigDecimal
	*/
	public void setGiftMoney(java.math.BigDecimal giftMoney){
		this.giftMoney = giftMoney;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_record:employee_id
	* @Description: 获取属性        员工标识
	* @return: String
	*/
	public String getEmployeeId(){
		return employeeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_record:employee_id
	* @Description: 设置属性        员工标识
	* @return: String
	*/
	public void setEmployeeId(String employeeId){
		this.employeeId = employeeId;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_record:money
	* @Description: 获取属性        员工提成
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getMoney(){
		return money;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_record:money
	* @Description: 设置属性        员工提成
	* @return: java.math.BigDecimal
	*/
	public void setMoney(java.math.BigDecimal money){
		this.money = money;	
	}	
	
	
	
	
}

