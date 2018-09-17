package com.jing.core.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: MemberPlus
 * @Description: 会员充值活动实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class MemberPlus extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer plusId;	//tb_member_plus:plus_id  活动标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String plusName;	//tb_member_plus:plus_name  活动名称  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal plusMoney;	//tb_member_plus:plus_money  充值金额  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal giftMoney;	//tb_member_plus:gift_money  赠送金额  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal money;	//tb_member_plus:money  提成金额  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tb_member_plus:status  活动状态 0正常  


	/**
	* @DatabasetableColumnName: tb_member_plus:plus_id
	* @Description: 获取属性        活动标识
	* @return: Integer
	*/
	public Integer getPlusId(){
		return plusId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_plus:plus_id
	* @Description: 设置属性        活动标识
	* @return: Integer
	*/
	public void setPlusId(Integer plusId){
		this.plusId = plusId;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_plus:plus_name
	* @Description: 获取属性        活动名称
	* @return: String
	*/
	public String getPlusName(){
		return plusName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_plus:plus_name
	* @Description: 设置属性        活动名称
	* @return: String
	*/
	public void setPlusName(String plusName){
		this.plusName = plusName;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_plus:plus_money
	* @Description: 获取属性        充值金额
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getPlusMoney(){
		return plusMoney;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_plus:plus_money
	* @Description: 设置属性        充值金额
	* @return: java.math.BigDecimal
	*/
	public void setPlusMoney(java.math.BigDecimal plusMoney){
		this.plusMoney = plusMoney;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_plus:gift_money
	* @Description: 获取属性        赠送金额
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getGiftMoney(){
		return giftMoney;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_plus:gift_money
	* @Description: 设置属性        赠送金额
	* @return: java.math.BigDecimal
	*/
	public void setGiftMoney(java.math.BigDecimal giftMoney){
		this.giftMoney = giftMoney;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_plus:money
	* @Description: 获取属性        提成金额
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getMoney(){
		return money;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_plus:money
	* @Description: 设置属性        提成金额
	* @return: java.math.BigDecimal
	*/
	public void setMoney(java.math.BigDecimal money){
		this.money = money;	
	}	
	/**
	* @DatabasetableColumnName: tb_member_plus:status
	* @Description: 获取属性        活动状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member_plus:status
	* @Description: 设置属性        活动状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	
	
	
	
}

