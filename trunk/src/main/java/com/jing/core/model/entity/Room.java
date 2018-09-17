package com.jing.core.model.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Room
 * @Description: 房间实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class Room extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String roomId;	//tb_room:room_id  房间标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tb_room:store_id  归属门店  

	private Integer types;	//tb_room:types  房间类型  

	@Length(min=0, max=8, message="{org.hibernate.validator.constraints.Length.message}")
	private String area;	//tb_room:area  归属区域  

	@Length(min=0, max=8, message="{org.hibernate.validator.constraints.Length.message}")
	private String roomNo;	//tb_room:room_no  房间编号  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String roomName;	//tb_room:room_name  房间名称  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tb_room:status  状态 0正常  

	private Integer roomStatus;	//tb_room:room_status  自身状态  

	private Integer chair;	//tb_room:chair  椅子数量  

	private Integer bed;	//tb_room:bed  床数量  

	@Length(min=0, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String mark;	//tb_room:mark  标记  

	@Length(min=0, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	@Pattern(regexp="((\\d{3,4}-)[0-9]{7,8}(-[0-9]{0,4})?)", message="{javax.validation.constraints.Pattern.message}")
	private String phone;	//tb_room:phone  房间分机  


	/**
	* @DatabasetableColumnName: tb_room:room_id
	* @Description: 获取属性        房间标识
	* @return: String
	*/
	public String getRoomId(){
		return roomId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:room_id
	* @Description: 设置属性        房间标识
	* @return: String
	*/
	public void setRoomId(String roomId){
		this.roomId = roomId;	
	}	
	/**
	* @DatabasetableColumnName: tb_room:store_id
	* @Description: 获取属性        归属门店
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:store_id
	* @Description: 设置属性        归属门店
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: tb_room:types
	* @Description: 获取属性        房间类型
	* @return: Integer
	*/
	public Integer getTypes(){
		return types;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:types
	* @Description: 设置属性        房间类型
	* @return: Integer
	*/
	public void setTypes(Integer types){
		this.types = types;	
	}	
	/**
	* @DatabasetableColumnName: tb_room:area
	* @Description: 获取属性        归属区域
	* @return: String
	*/
	public String getArea(){
		return area;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:area
	* @Description: 设置属性        归属区域
	* @return: String
	*/
	public void setArea(String area){
		this.area = area;	
	}	
	/**
	* @DatabasetableColumnName: tb_room:room_no
	* @Description: 获取属性        房间编号
	* @return: String
	*/
	public String getRoomNo(){
		return roomNo;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:room_no
	* @Description: 设置属性        房间编号
	* @return: String
	*/
	public void setRoomNo(String roomNo){
		this.roomNo = roomNo;	
	}	
	/**
	* @DatabasetableColumnName: tb_room:room_name
	* @Description: 获取属性        房间名称
	* @return: String
	*/
	public String getRoomName(){
		return roomName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:room_name
	* @Description: 设置属性        房间名称
	* @return: String
	*/
	public void setRoomName(String roomName){
		this.roomName = roomName;	
	}	
	/**
	* @DatabasetableColumnName: tb_room:status
	* @Description: 获取属性        状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:status
	* @Description: 设置属性        状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tb_room:room_status
	* @Description: 获取属性        自身状态
	* @return: Integer
	*/
	public Integer getRoomStatus(){
		return roomStatus;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:room_status
	* @Description: 设置属性        自身状态
	* @return: Integer
	*/
	public void setRoomStatus(Integer roomStatus){
		this.roomStatus = roomStatus;	
	}	
	/**
	* @DatabasetableColumnName: tb_room:chair
	* @Description: 获取属性        椅子数量
	* @return: Integer
	*/
	public Integer getChair(){
		return chair;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:chair
	* @Description: 设置属性        椅子数量
	* @return: Integer
	*/
	public void setChair(Integer chair){
		this.chair = chair;	
	}	
	/**
	* @DatabasetableColumnName: tb_room:bed
	* @Description: 获取属性        床数量
	* @return: Integer
	*/
	public Integer getBed(){
		return bed;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:bed
	* @Description: 设置属性        床数量
	* @return: Integer
	*/
	public void setBed(Integer bed){
		this.bed = bed;	
	}	
	/**
	* @DatabasetableColumnName: tb_room:mark
	* @Description: 获取属性        标记
	* @return: String
	*/
	public String getMark(){
		return mark;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:mark
	* @Description: 设置属性        标记
	* @return: String
	*/
	public void setMark(String mark){
		this.mark = mark;	
	}	
	/**
	* @DatabasetableColumnName: tb_room:phone
	* @Description: 获取属性        房间分机
	* @return: String
	*/
	public String getPhone(){
		return phone;	
	}
	
	/**
	* @DatabasetableColumnName: tb_room:phone
	* @Description: 设置属性        房间分机
	* @return: String
	*/
	public void setPhone(String phone){
		this.phone = phone;	
	}	
	
	
	
	
}

