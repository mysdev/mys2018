package com.jing.clock.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: ClockOrder
 * @Description: 订单实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月23日 16时14分
 */
public class ClockOrder extends BaseEntity{
	private static final long serialVersionUID = 1L;
	

	private Integer orderId;	//tc_clock_order:order_id  自增标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String authorizationId;	//tc_clock_order:authorization_id  授权标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tc_clock_order:store_id  归属门店  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=1, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer types;	//tc_clock_order:types  来源类型 0房间1手环  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String objectId;	//tc_clock_order:object_id  来源标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	@Range(min=0, max=4, message = "{org.hibernate.validator.constraints.Range.message}")
	private Integer status;	//tc_clock_order:status  订单状态 0等待1进行中2完成4取消  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=0, message="{org.hibernate.validator.constraints.Length.message}")
	private String materialId;	//tc_clock_order:material_id  服务标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=0, message="{org.hibernate.validator.constraints.Length.message}")
	private String goodsId;	//tc_clock_order:goods_id  商品标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer goodsTime;	//tc_clock_order:goods_time  服务时长  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String technicianId;	//tc_clock_order:technician_id  技师标识  

	@Length(min=0, max=256, message="{org.hibernate.validator.constraints.Length.message}")
	private String customerNote;	//tc_clock_order:customer_note  客户备注  

	@Length(min=0, max=256, message="{org.hibernate.validator.constraints.Length.message}")
	private String note;	//tc_clock_order:note  备注  


	/**
	* @DatabasetableColumnName: tc_clock_order:order_id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getOrderId(){
		return orderId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:order_id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setOrderId(Integer orderId){
		this.orderId = orderId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_order:authorization_id
	* @Description: 获取属性        授权标识
	* @return: String
	*/
	public String getAuthorizationId(){
		return authorizationId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:authorization_id
	* @Description: 设置属性        授权标识
	* @return: String
	*/
	public void setAuthorizationId(String authorizationId){
		this.authorizationId = authorizationId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_order:store_id
	* @Description: 获取属性        归属门店
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:store_id
	* @Description: 设置属性        归属门店
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_order:types
	* @Description: 获取属性        来源类型 0房间1手环
	* @return: Integer
	*/
	public Integer getTypes(){
		return types;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:types
	* @Description: 设置属性        来源类型 0房间1手环
	* @return: Integer
	*/
	public void setTypes(Integer types){
		this.types = types;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_order:object_id
	* @Description: 获取属性        来源标识
	* @return: String
	*/
	public String getObjectId(){
		return objectId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:object_id
	* @Description: 设置属性        来源标识
	* @return: String
	*/
	public void setObjectId(String objectId){
		this.objectId = objectId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_order:status
	* @Description: 获取属性        订单状态 0等待1进行中2完成4取消
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:status
	* @Description: 设置属性        订单状态 0等待1进行中2完成4取消
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_order:material_id
	* @Description: 获取属性        服务标识
	* @return: String
	*/
	public String getMaterialId(){
		return materialId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:material_id
	* @Description: 设置属性        服务标识
	* @return: String
	*/
	public void setMaterialId(String materialId){
		this.materialId = materialId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_order:goods_id
	* @Description: 获取属性        商品标识
	* @return: String
	*/
	public String getGoodsId(){
		return goodsId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:goods_id
	* @Description: 设置属性        商品标识
	* @return: String
	*/
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_order:goods_time
	* @Description: 获取属性        服务时长
	* @return: Integer
	*/
	public Integer getGoodsTime(){
		return goodsTime;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:goods_time
	* @Description: 设置属性        服务时长
	* @return: Integer
	*/
	public void setGoodsTime(Integer goodsTime){
		this.goodsTime = goodsTime;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_order:technician_id
	* @Description: 获取属性        技师标识
	* @return: String
	*/
	public String getTechnicianId(){
		return technicianId;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:technician_id
	* @Description: 设置属性        技师标识
	* @return: String
	*/
	public void setTechnicianId(String technicianId){
		this.technicianId = technicianId;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_order:customer_note
	* @Description: 获取属性        客户备注
	* @return: String
	*/
	public String getCustomerNote(){
		return customerNote;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:customer_note
	* @Description: 设置属性        客户备注
	* @return: String
	*/
	public void setCustomerNote(String customerNote){
		this.customerNote = customerNote;	
	}	
	/**
	* @DatabasetableColumnName: tc_clock_order:note
	* @Description: 获取属性        备注
	* @return: String
	*/
	public String getNote(){
		return note;	
	}
	
	/**
	* @DatabasetableColumnName: tc_clock_order:note
	* @Description: 设置属性        备注
	* @return: String
	*/
	public void setNote(String note){
		this.note = note;	
	}	
	
	
	
	
}

