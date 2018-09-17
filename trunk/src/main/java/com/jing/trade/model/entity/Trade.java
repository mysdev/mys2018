package com.jing.trade.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Trade
 * @Description: 消费清单实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class Trade extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer tradeId;	//tt_trade:trade_id  交易标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String serialNumber;	//tt_trade:serial_number  流水号  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer customerId;	//tt_trade:customer_id  客户标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer customerCt;	//tt_trade:customer_ct  客人数  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String authorizationId;	//tt_trade:authorization_id  授权码标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer objectType;	//tt_trade:object_type  商品服务类型  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String objectId;	//tt_trade:object_id  商品服务标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer objectCt;	//tt_trade:object_ct  交易数量  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tt_trade:status  清单状态 0正常  

	@Length(min=0, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String note;	//tt_trade:note  交易说明  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal markedPrice;	//tt_trade:marked_price  原价  

	private java.math.BigDecimal discountPrice;	//tt_trade:discount_price  优惠金额  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal dealPrice;	//tt_trade:deal_price  成交价  

	private Integer couponId;	//tt_trade:coupon_id  活动标识  


	/**
	* @DatabasetableColumnName: tt_trade:trade_id
	* @Description: 获取属性        交易标识
	* @return: Integer
	*/
	public Integer getTradeId(){
		return tradeId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:trade_id
	* @Description: 设置属性        交易标识
	* @return: Integer
	*/
	public void setTradeId(Integer tradeId){
		this.tradeId = tradeId;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:serial_number
	* @Description: 获取属性        流水号
	* @return: String
	*/
	public String getSerialNumber(){
		return serialNumber;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:serial_number
	* @Description: 设置属性        流水号
	* @return: String
	*/
	public void setSerialNumber(String serialNumber){
		this.serialNumber = serialNumber;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:customer_id
	* @Description: 获取属性        客户标识
	* @return: Integer
	*/
	public Integer getCustomerId(){
		return customerId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:customer_id
	* @Description: 设置属性        客户标识
	* @return: Integer
	*/
	public void setCustomerId(Integer customerId){
		this.customerId = customerId;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:customer_ct
	* @Description: 获取属性        客人数
	* @return: Integer
	*/
	public Integer getCustomerCt(){
		return customerCt;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:customer_ct
	* @Description: 设置属性        客人数
	* @return: Integer
	*/
	public void setCustomerCt(Integer customerCt){
		this.customerCt = customerCt;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:authorization_id
	* @Description: 获取属性        授权码标识
	* @return: String
	*/
	public String getAuthorizationId(){
		return authorizationId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:authorization_id
	* @Description: 设置属性        授权码标识
	* @return: String
	*/
	public void setAuthorizationId(String authorizationId){
		this.authorizationId = authorizationId;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:object_type
	* @Description: 获取属性        商品服务类型
	* @return: Integer
	*/
	public Integer getObjectType(){
		return objectType;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:object_type
	* @Description: 设置属性        商品服务类型
	* @return: Integer
	*/
	public void setObjectType(Integer objectType){
		this.objectType = objectType;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:object_id
	* @Description: 获取属性        商品服务标识
	* @return: String
	*/
	public String getObjectId(){
		return objectId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:object_id
	* @Description: 设置属性        商品服务标识
	* @return: String
	*/
	public void setObjectId(String objectId){
		this.objectId = objectId;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:object_ct
	* @Description: 获取属性        交易数量
	* @return: Integer
	*/
	public Integer getObjectCt(){
		return objectCt;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:object_ct
	* @Description: 设置属性        交易数量
	* @return: Integer
	*/
	public void setObjectCt(Integer objectCt){
		this.objectCt = objectCt;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:status
	* @Description: 获取属性        清单状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:status
	* @Description: 设置属性        清单状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:note
	* @Description: 获取属性        交易说明
	* @return: String
	*/
	public String getNote(){
		return note;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:note
	* @Description: 设置属性        交易说明
	* @return: String
	*/
	public void setNote(String note){
		this.note = note;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:marked_price
	* @Description: 获取属性        原价
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getMarkedPrice(){
		return markedPrice;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:marked_price
	* @Description: 设置属性        原价
	* @return: java.math.BigDecimal
	*/
	public void setMarkedPrice(java.math.BigDecimal markedPrice){
		this.markedPrice = markedPrice;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:discount_price
	* @Description: 获取属性        优惠金额
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getDiscountPrice(){
		return discountPrice;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:discount_price
	* @Description: 设置属性        优惠金额
	* @return: java.math.BigDecimal
	*/
	public void setDiscountPrice(java.math.BigDecimal discountPrice){
		this.discountPrice = discountPrice;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:deal_price
	* @Description: 获取属性        成交价
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getDealPrice(){
		return dealPrice;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:deal_price
	* @Description: 设置属性        成交价
	* @return: java.math.BigDecimal
	*/
	public void setDealPrice(java.math.BigDecimal dealPrice){
		this.dealPrice = dealPrice;	
	}	
	/**
	* @DatabasetableColumnName: tt_trade:coupon_id
	* @Description: 获取属性        活动标识
	* @return: Integer
	*/
	public Integer getCouponId(){
		return couponId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_trade:coupon_id
	* @Description: 设置属性        活动标识
	* @return: Integer
	*/
	public void setCouponId(Integer couponId){
		this.couponId = couponId;	
	}	
	
	
	
	
}

