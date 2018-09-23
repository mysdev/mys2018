package com.jing.core.model.entity;

import com.jing.utils.BaseEntity;

/**
 * 会员金额流水 实体类
 * @author codeing gen
 */
public class MemberMoneyRecord extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private Integer recordId;   // 记录标识
	private String memberId;   // 会员标识
	private Integer rtype;   // 收支
	private java.math.BigDecimal money;   // 金额
	private java.math.BigDecimal balance;   // 余额
	private String remark;   // 备注

	public Integer getRecordId() {	    return this.recordId;	}
	public String getMemberId() {	    return this.memberId;	}
	public Integer getRtype() {	    return this.rtype;	}
	public java.math.BigDecimal getMoney() {	    return this.money;	}
	public java.math.BigDecimal getBalance() {	    return this.balance;	}
	public String getRemark() {	    return this.remark;	}
	public void setRecordId(Integer recordId){	this.recordId = recordId;	}
	public void setMemberId(String memberId){	this.memberId = memberId;	}
	public void setRtype(Integer rtype){	this.rtype = rtype;	}
	public void setMoney(java.math.BigDecimal money){	this.money = money;	}
	public void setBalance(java.math.BigDecimal balance){	this.balance = balance;	}
	public void setRemark(String remark){	this.remark = remark;	}
}