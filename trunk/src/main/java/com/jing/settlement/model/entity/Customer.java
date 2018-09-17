package com.jing.settlement.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Customer
 * @Description: 客户实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class Customer extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer customerId;	//to_customer:customer_id  客户标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String customerName;	//to_customer:customer_name  客户名称  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal advance;	//to_customer:advance  押金  

	@Length(min=0, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String note;	//to_customer:note  备注  


	/**
	* @DatabasetableColumnName: to_customer:customer_id
	* @Description: 获取属性        客户标识
	* @return: Integer
	*/
	public Integer getCustomerId(){
		return customerId;	
	}
	
	/**
	* @DatabasetableColumnName: to_customer:customer_id
	* @Description: 设置属性        客户标识
	* @return: Integer
	*/
	public void setCustomerId(Integer customerId){
		this.customerId = customerId;	
	}	
	/**
	* @DatabasetableColumnName: to_customer:customer_name
	* @Description: 获取属性        客户名称
	* @return: String
	*/
	public String getCustomerName(){
		return customerName;	
	}
	
	/**
	* @DatabasetableColumnName: to_customer:customer_name
	* @Description: 设置属性        客户名称
	* @return: String
	*/
	public void setCustomerName(String customerName){
		this.customerName = customerName;	
	}	
	/**
	* @DatabasetableColumnName: to_customer:advance
	* @Description: 获取属性        押金
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getAdvance(){
		return advance;	
	}
	
	/**
	* @DatabasetableColumnName: to_customer:advance
	* @Description: 设置属性        押金
	* @return: java.math.BigDecimal
	*/
	public void setAdvance(java.math.BigDecimal advance){
		this.advance = advance;	
	}	
	/**
	* @DatabasetableColumnName: to_customer:note
	* @Description: 获取属性        备注
	* @return: String
	*/
	public String getNote(){
		return note;	
	}
	
	/**
	* @DatabasetableColumnName: to_customer:note
	* @Description: 设置属性        备注
	* @return: String
	*/
	public void setNote(String note){
		this.note = note;	
	}	
	
	
	
	
}

