package com.jing.core.model.entity;

import java.util.Date;
import java.util.List;

import com.jing.utils.BaseEntity;

/**
 * 类型配置 实体类
 * 
 * @author codeing gen
 */
public class Types extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Integer typeId; // 类型标识
	private String typeName; // 类型名称
	private java.math.BigDecimal lowConsumption; // 最低消费
	private Integer status; // 类型状态 0正常
	private Integer isCircle; // 重复计费 0否1时长2时间点
	private Integer circleStep; // 周期步长 时
	private Date circleTime; // 计费时间点
	
	private List<TypesBind> binds;

	public Integer getTypeId() {
		return this.typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public java.math.BigDecimal getLowConsumption() {
		return this.lowConsumption;
	}

	public Integer getStatus() {
		return this.status;
	}

	public Integer getIsCircle() {
		return this.isCircle;
	}

	public Integer getCircleStep() {
		return this.circleStep;
	}

	public Date getCircleTime() {
		return this.circleTime;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setLowConsumption(java.math.BigDecimal lowConsumption) {
		this.lowConsumption = lowConsumption;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setIsCircle(Integer isCircle) {
		this.isCircle = isCircle;
	}

	public void setCircleStep(Integer circleStep) {
		this.circleStep = circleStep;
	}

	public void setCircleTime(Date circleTime) {
		this.circleTime = circleTime;
	}

	public List<TypesBind> getBinds() {
		return binds;
	}

	public void setBinds(List<TypesBind> binds) {
		this.binds = binds;
	}
}