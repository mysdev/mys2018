package com.jing.core.model.entity;

import com.jing.utils.BaseEntity;

/**
 * 员工提成 实体类
 * @author codeing gen
 */
public class EmployeeCommission extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private Integer cid;   // 记录标识
	private String employeeId;   // 员工标识
	private java.math.BigDecimal money;   // 金额
	private String cause;   // 原由
	private String remark;   // 备注

	public String getRemark() {
		return remark;
	}

	public Integer getCid() {	    return this.cid;	}
	public String getEmployeeId() {	    return this.employeeId;	}
	public java.math.BigDecimal getMoney() {	    return this.money;	}
	public String getCause() {	    return this.cause;	}
	public void setCid(Integer cid){	this.cid = cid;	}
	public void setEmployeeId(String employeeId){	this.employeeId = employeeId;	}
	public void setMoney(java.math.BigDecimal money){	this.money = money;	}
	public void setCause(String cause){	this.cause = cause;	}
	public void setRemark(String remark){	this.remark = remark;	}

}