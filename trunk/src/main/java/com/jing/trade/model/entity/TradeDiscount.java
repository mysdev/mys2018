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
 * @ClassName: TradeDiscount
 * @Description: 结算优惠项实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class TradeDiscount extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer discountId;	//tt_trade_discount:discount_id  自增标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String serialNumber;	//tt_trade_discount:serial_number  流水号  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer couponId;	//tt_trade_discount:coupon_id  优惠卷组  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer volumeId;	//tt_trade_discount:volume_id  卡券标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal discountPrice;	//tt_trade_discount:discount_price  折扣金额  


	/**
	* @DatabasetableColumnName: tt_trade_discount:discount_id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getDiscountId(){
		return discountId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade_discount:discount_id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setDiscountId(Integer discountId){
		this.discountId = discountId;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade_discount:serial_number
	* @Description: 获取属性        流水号
	* @return: String
	*/
	public String getSerialNumber(){
		return serialNumber;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade_discount:serial_number
	* @Description: 设置属性        流水号
	* @return: String
	*/
	public void setSerialNumber(String serialNumber){
		this.serialNumber = serialNumber;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade_discount:coupon_id
	* @Description: 获取属性        优惠卷组
	* @return: Integer
	*/
	public Integer getCouponId(){
		return couponId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade_discount:coupon_id
	* @Description: 设置属性        优惠卷组
	* @return: Integer
	*/
	public void setCouponId(Integer couponId){
		this.couponId = couponId;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade_discount:volume_id
	* @Description: 获取属性        卡券标识
	* @return: Integer
	*/
	public Integer getVolumeId(){
		return volumeId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade_discount:volume_id
	* @Description: 设置属性        卡券标识
	* @return: Integer
	*/
	public void setVolumeId(Integer volumeId){
		this.volumeId = volumeId;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade_discount:discount_price
	* @Description: 获取属性        折扣金额
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getDiscountPrice(){
		return discountPrice;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade_discount:discount_price
	* @Description: 设置属性        折扣金额
	* @return: java.math.BigDecimal
	*/
	public void setDiscountPrice(java.math.BigDecimal discountPrice){
		this.discountPrice = discountPrice;	
	}	
	
	
	
	
}

