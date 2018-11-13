package com.jing.trade.model.entity;

import com.jing.utils.BaseEntity;

/**
 * 消费清单 实体类
 * 
 * @author codeing gen
 */
public class Trade extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Integer tradeId; // 交易标识
	private String serialNumber; // 流水号
	private Integer customerId; // 客户标识
	private Integer customerCt; // 客人数
	private String authorizationId; // 授权码标识
	private Integer objectType; // 商品服务类型
	private String objectId; // 商品服务标识
	private Integer objectCt; // 交易数量
	private Integer status; // 清单状态 0正常
	private String note; // 交易说明
	private java.math.BigDecimal markedPrice; // 原价
	private java.math.BigDecimal discountPrice; // 优惠金额
	private java.math.BigDecimal dealPrice; // 成交价
	private Integer couponId; // 活动标识

	public Integer getTradeId() {
		return this.tradeId;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public Integer getCustomerCt() {
		return this.customerCt;
	}

	public String getAuthorizationId() {
		return this.authorizationId;
	}

	public Integer getObjectType() {
		return this.objectType;
	}

	public String getObjectId() {
		return this.objectId;
	}

	public Integer getObjectCt() {
		return this.objectCt;
	}

	public Integer getStatus() {
		return this.status;
	}

	public String getNote() {
		return this.note;
	}

	public java.math.BigDecimal getMarkedPrice() {
		return this.markedPrice;
	}

	public java.math.BigDecimal getDiscountPrice() {
		return this.discountPrice;
	}

	public java.math.BigDecimal getDealPrice() {
		return this.dealPrice;
	}

	public Integer getCouponId() {
		return this.couponId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public void setCustomerCt(Integer customerCt) {
		this.customerCt = customerCt;
	}

	public void setAuthorizationId(String authorizationId) {
		this.authorizationId = authorizationId;
	}

	public void setObjectType(Integer objectType) {
		this.objectType = objectType;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public void setObjectCt(Integer objectCt) {
		this.objectCt = objectCt;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setMarkedPrice(java.math.BigDecimal markedPrice) {
		this.markedPrice = markedPrice;
	}

	public void setDiscountPrice(java.math.BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public void setDealPrice(java.math.BigDecimal dealPrice) {
		this.dealPrice = dealPrice;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

}