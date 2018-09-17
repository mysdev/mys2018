package com.jing.trade.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Coupon
 * @Description: 优惠卷组实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class Coupon extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer couponId;	//tt_coupon:coupon_id  优惠券标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String couponName;	//tt_coupon:coupon_name  优惠券名称  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer types;	//tt_coupon:types  类型 0卷 1减 2送  

	private Integer totalCount;	//tt_coupon:total_count  总量  

	private Integer allowance;	//tt_coupon:allowance  余量  

	private java.math.BigDecimal totalPrice;	//tt_coupon:total_price  价值  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date fromTime;	//tt_coupon:from_time  生效日期  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Date toTime;	//tt_coupon:to_time  失效日期  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tt_coupon:status  当前状态 0正常  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer isStack;	//tt_coupon:is_stack  叠加使用 0是  


	/**
	* @DatabasetableColumnName: tt_coupon:coupon_id
	* @Description: 获取属性        优惠券标识
	* @return: Integer
	*/
	public Integer getCouponId(){
		return couponId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:coupon_id
	* @Description: 设置属性        优惠券标识
	* @return: Integer
	*/
	public void setCouponId(Integer couponId){
		this.couponId = couponId;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon:coupon_name
	* @Description: 获取属性        优惠券名称
	* @return: String
	*/
	public String getCouponName(){
		return couponName;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:coupon_name
	* @Description: 设置属性        优惠券名称
	* @return: String
	*/
	public void setCouponName(String couponName){
		this.couponName = couponName;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon:types
	* @Description: 获取属性        类型 0卷 1减 2送
	* @return: Integer
	*/
	public Integer getTypes(){
		return types;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:types
	* @Description: 设置属性        类型 0卷 1减 2送
	* @return: Integer
	*/
	public void setTypes(Integer types){
		this.types = types;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon:total_count
	* @Description: 获取属性        总量
	* @return: Integer
	*/
	public Integer getTotalCount(){
		return totalCount;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:total_count
	* @Description: 设置属性        总量
	* @return: Integer
	*/
	public void setTotalCount(Integer totalCount){
		this.totalCount = totalCount;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon:allowance
	* @Description: 获取属性        余量
	* @return: Integer
	*/
	public Integer getAllowance(){
		return allowance;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:allowance
	* @Description: 设置属性        余量
	* @return: Integer
	*/
	public void setAllowance(Integer allowance){
		this.allowance = allowance;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon:total_price
	* @Description: 获取属性        价值
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getTotalPrice(){
		return totalPrice;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:total_price
	* @Description: 设置属性        价值
	* @return: java.math.BigDecimal
	*/
	public void setTotalPrice(java.math.BigDecimal totalPrice){
		this.totalPrice = totalPrice;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon:from_time
	* @Description: 获取属性        生效日期
	* @return: Date
	*/
	public Date getFromTime(){
		return fromTime;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:from_time
	* @Description: 设置属性        生效日期
	* @return: Date
	*/
	public void setFromTime(Date fromTime){
		this.fromTime = fromTime;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon:to_time
	* @Description: 获取属性        失效日期
	* @return: Date
	*/
	public Date getToTime(){
		return toTime;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:to_time
	* @Description: 设置属性        失效日期
	* @return: Date
	*/
	public void setToTime(Date toTime){
		this.toTime = toTime;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon:status
	* @Description: 获取属性        当前状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:status
	* @Description: 设置属性        当前状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon:is_stack
	* @Description: 获取属性        叠加使用 0是
	* @return: Integer
	*/
	public Integer getIsStack(){
		return isStack;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon:is_stack
	* @Description: 设置属性        叠加使用 0是
	* @return: Integer
	*/
	public void setIsStack(Integer isStack){
		this.isStack = isStack;	
	}	
	
	
	
	
}

