package com.jing.core.model.entity;

import com.jing.utils.BaseEntity;

/**
 * 类型消费绑定 实体类
 * 
 * @author codeing gen
 */
public class TypesBind extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Integer bindId; // 绑定标识
	private Integer typeId; // 类型标识 0商品1套餐
	private String objectId; // 物品标识 商品 套餐
	private Integer objectCt; // 物品数量

	public Integer getBindId() {
		return this.bindId;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public String getObjectId() {
		return this.objectId;
	}

	public Integer getObjectCt() {
		return this.objectCt;
	}

	public void setBindId(Integer bindId) {
		this.bindId = bindId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public void setObjectCt(Integer objectCt) {
		this.objectCt = objectCt;
	}

}