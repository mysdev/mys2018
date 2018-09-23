package com.jing.core.model.entity;

import com.jing.utils.BaseEntity;

/**
 * 手牌 实体类
 * 
 * @author codeing gen
 */
public class Strap extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String strapId; // 手牌标识
	private String strapSerial; // 手牌号码
	private String strapNo; // 手牌编号
	private Integer types; // 手牌类型
	private Integer status=0; // 手牌状态 0正常

	public String getStrapId() {
		return this.strapId;
	}

	public String getStrapSerial() {
		return this.strapSerial;
	}

	public String getStrapNo() {
		return this.strapNo;
	}

	public Integer getTypes() {
		return this.types;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStrapId(String strapId) {
		this.strapId = strapId;
	}

	public void setStrapSerial(String strapSerial) {
		this.strapSerial = strapSerial;
	}

	public void setStrapNo(String strapNo) {
		this.strapNo = strapNo;
	}

	public void setTypes(Integer types) {
		this.types = types;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}