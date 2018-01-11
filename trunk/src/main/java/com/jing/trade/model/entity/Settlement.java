package com.jing.trade.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Settlement
 * @Description: 消费结算实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class Settlement extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer settlementId;	//tt_settlement:settlement_id  结算标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String serialNumber;	//tt_settlement:serial_number  流水号  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date settlementTime;	//tt_settlement:settlement_time  结算时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal markedPrice;	//tt_settlement:marked_price  原价  

	private java.math.BigDecimal discountPrice;	//tt_settlement:discount_price  优惠总计  

	private java.math.BigDecimal reductionPrice;	//tt_settlement:reduction_price  折扣  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal dealPrice;	//tt_settlement:deal_price  成交价  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer exchangeId;	//tt_settlement:exchange_id  支付方式 0本币  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal payPrice;	//tt_settlement:pay_price  支付数量  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String empId;	//tt_settlement:emp_id  折扣授权员工  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String memberId;	//tt_settlement:member_id  会员  


	/**
	* @DatabasetableColumnName: tt_settlement:settlement_id
	* @Description: 获取属性        结算标识
	* @return: Integer
	*/
	public Integer getSettlementId(){
		return settlementId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_settlement:settlement_id
	* @Description: 设置属性        结算标识
	* @return: Integer
	*/
	public void setSettlementId(Integer settlementId){
		this.settlementId = settlementId;	
	}	
	/**
	* @DatabasetableColumnName: tt_settlement:serial_number
	* @Description: 获取属性        流水号
	* @return: String
	*/
	public String getSerialNumber(){
		return serialNumber;	
	}
	
	/**
	* @DatabasetableColumnName: tt_settlement:serial_number
	* @Description: 设置属性        流水号
	* @return: String
	*/
	public void setSerialNumber(String serialNumber){
		this.serialNumber = serialNumber;	
	}	
	/**
	* @DatabasetableColumnName: tt_settlement:settlement_time
	* @Description: 获取属性        结算时间
	* @return: Date
	*/
	public Date getSettlementTime(){
		return settlementTime;	
	}
	
	/**
	* @DatabasetableColumnName: tt_settlement:settlement_time
	* @Description: 设置属性        结算时间
	* @return: Date
	*/
	public void setSettlementTime(Date settlementTime){
		this.settlementTime = settlementTime;	
	}	
	/**
	* @DatabasetableColumnName: tt_settlement:marked_price
	* @Description: 获取属性        原价
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getMarkedPrice(){
		return markedPrice;	
	}
	
	/**
	* @DatabasetableColumnName: tt_settlement:marked_price
	* @Description: 设置属性        原价
	* @return: java.math.BigDecimal
	*/
	public void setMarkedPrice(java.math.BigDecimal markedPrice){
		this.markedPrice = markedPrice;	
	}	
	/**
	* @DatabasetableColumnName: tt_settlement:discount_price
	* @Description: 获取属性        优惠总计
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getDiscountPrice(){
		return discountPrice;	
	}
	
	/**
	* @DatabasetableColumnName: tt_settlement:discount_price
	* @Description: 设置属性        优惠总计
	* @return: java.math.BigDecimal
	*/
	public void setDiscountPrice(java.math.BigDecimal discountPrice){
		this.discountPrice = discountPrice;	
	}	
	/**
	* @DatabasetableColumnName: tt_settlement:reduction_price
	* @Description: 获取属性        折扣
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getReductionPrice(){
		return reductionPrice;	
	}
	
	/**
	* @DatabasetableColumnName: tt_settlement:reduction_price
	* @Description: 设置属性        折扣
	* @return: java.math.BigDecimal
	*/
	public void setReductionPrice(java.math.BigDecimal reductionPrice){
		this.reductionPrice = reductionPrice;	
	}	
	/**
	* @DatabasetableColumnName: tt_settlement:deal_price
	* @Description: 获取属性        成交价
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getDealPrice(){
		return dealPrice;	
	}
	
	/**
	* @DatabasetableColumnName: tt_settlement:deal_price
	* @Description: 设置属性        成交价
	* @return: java.math.BigDecimal
	*/
	public void setDealPrice(java.math.BigDecimal dealPrice){
		this.dealPrice = dealPrice;	
	}	
	/**
	* @DatabasetableColumnName: tt_settlement:exchange_id
	* @Description: 获取属性        支付方式 0本币
	* @return: Integer
	*/
	public Integer getExchangeId(){
		return exchangeId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_settlement:exchange_id
	* @Description: 设置属性        支付方式 0本币
	* @return: Integer
	*/
	public void setExchangeId(Integer exchangeId){
		this.exchangeId = exchangeId;	
	}	
	/**
	* @DatabasetableColumnName: tt_settlement:pay_price
	* @Description: 获取属性        支付数量
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getPayPrice(){
		return payPrice;	
	}
	
	/**
	* @DatabasetableColumnName: tt_settlement:pay_price
	* @Description: 设置属性        支付数量
	* @return: java.math.BigDecimal
	*/
	public void setPayPrice(java.math.BigDecimal payPrice){
		this.payPrice = payPrice;	
	}	
	/**
	* @DatabasetableColumnName: tt_settlement:emp_id
	* @Description: 获取属性        折扣授权员工
	* @return: String
	*/
	public String getEmpId(){
		return empId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_settlement:emp_id
	* @Description: 设置属性        折扣授权员工
	* @return: String
	*/
	public void setEmpId(String empId){
		this.empId = empId;	
	}	
	/**
	* @DatabasetableColumnName: tt_settlement:member_id
	* @Description: 获取属性        会员
	* @return: String
	*/
	public String getMemberId(){
		return memberId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_settlement:member_id
	* @Description: 设置属性        会员
	* @return: String
	*/
	public void setMemberId(String memberId){
		this.memberId = memberId;	
	}	
	
	
	
	
}

