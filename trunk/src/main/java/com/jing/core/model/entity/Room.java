package com.jing.core.model.entity;

import com.jing.utils.BaseEntity;

/**
 * 房间 实体类
 * @author codeing gen
 */
public class Room extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private String roomId;   // 房间标识
	private Integer types;   // 房间类型
	private String area;   // 归属区域
	private String roomNo;   // 房间编号
	private String roomName;   // 房间名称
	private Integer status;   // 状态 0正常【0=正常，1=删除】
	private Integer roomStatus;   // 自身状态【0=空闲，1=繁忙，2=打扫卫生，3=预约，4=维修】
	private Integer chair;   // 椅子数量
	private Integer bed;   // 床数量
	private String mark;   // 标记
	private String phone;   // 房间分机
	private Integer isConsumption;   // 是否包含基础消费
	private String commodity;   // 商品id，逗号分隔
	public String getRoomId() {	    return this.roomId;	}
	public Integer getTypes() {	    return this.types;	}
	public String getArea() {	    return this.area;	}
	public String getRoomNo() {	    return this.roomNo;	}
	public String getRoomName() {	    return this.roomName;	}
	public Integer getStatus() {	    return this.status;	}
	public Integer getRoomStatus() {	    return this.roomStatus;	}
	public Integer getChair() {	    return this.chair;	}
	public Integer getBed() {	    return this.bed;	}
	public String getMark() {	    return this.mark;	}
	public String getPhone() {	    return this.phone;	}
	public Integer getIsConsumption() {	    return this.isConsumption;	}
	public String getCommodity() {	    return this.commodity;	}
	public void setRoomId(String roomId){	this.roomId = roomId;	}
	public void setTypes(Integer types){	this.types = types;	}
	public void setArea(String area){	this.area = area;	}
	public void setRoomNo(String roomNo){	this.roomNo = roomNo;	}
	public void setRoomName(String roomName){	this.roomName = roomName;	}
	public void setStatus(Integer status){	this.status = status;	}
	public void setRoomStatus(Integer roomStatus){	this.roomStatus = roomStatus;	}
	public void setChair(Integer chair){	this.chair = chair;	}
	public void setBed(Integer bed){	this.bed = bed;	}
	public void setMark(String mark){	this.mark = mark;	}
	public void setPhone(String phone){	this.phone = phone;	}
	public void setIsConsumption(Integer isConsumption){	this.isConsumption = isConsumption;	}
	public void setCommodity(String commodity){	this.commodity = commodity;	}
}