package com.jing.core.model.entity;

import com.jing.utils.BaseEntity;

/**
 * 会员充值活动 实体类
 * @author codeing gen
 */
public class MemberPlus extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private Integer plusId;   // 活动标识
	private String plusName;   // 活动名称
	private java.math.BigDecimal plusMoney;   // 充值金额
	private java.math.BigDecimal giftMoney;   // 赠送金额
	private java.math.BigDecimal money;   // 提成金额
	private Integer status;   // 活动状态 0正常

	public Integer getPlusId() {	    return this.plusId;	}
	public String getPlusName() {	    return this.plusName;	}
	public java.math.BigDecimal getPlusMoney() {	    return this.plusMoney;	}
	public java.math.BigDecimal getGiftMoney() {	    return this.giftMoney;	}
	public java.math.BigDecimal getMoney() {	    return this.money;	}
	public Integer getStatus() {	    return this.status;	}
	public void setPlusId(Integer plusId){	this.plusId = plusId;	}
	public void setPlusName(String plusName){	this.plusName = plusName;	}
	public void setPlusMoney(java.math.BigDecimal plusMoney){	this.plusMoney = plusMoney;	}
	public void setGiftMoney(java.math.BigDecimal giftMoney){	this.giftMoney = giftMoney;	}
	public void setMoney(java.math.BigDecimal money){	this.money = money;	}
	public void setStatus(Integer status){	this.status = status;	}
}