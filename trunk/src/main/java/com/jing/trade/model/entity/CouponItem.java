package com.jing.trade.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: CouponItem
 * @Description: 优惠项目实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class CouponItem extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer itemId;	//tt_coupon_item:item_id  自增标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer couponId;	//tt_coupon_item:coupon_id  归属券组  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer objectType;	//tt_coupon_item:object_type  商品服务类型  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String objectId;	//tt_coupon_item:object_id  商品服务标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tt_coupon_item:status  状态  


	/**
	* @DatabasetableColumnName: tt_coupon_item:item_id
	* @Description: 获取属性        自增标识
	* @return: Integer
	*/
	public Integer getItemId(){
		return itemId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon_item:item_id
	* @Description: 设置属性        自增标识
	* @return: Integer
	*/
	public void setItemId(Integer itemId){
		this.itemId = itemId;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon_item:coupon_id
	* @Description: 获取属性        归属券组
	* @return: Integer
	*/
	public Integer getCouponId(){
		return couponId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon_item:coupon_id
	* @Description: 设置属性        归属券组
	* @return: Integer
	*/
	public void setCouponId(Integer couponId){
		this.couponId = couponId;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon_item:object_type
	* @Description: 获取属性        商品服务类型
	* @return: Integer
	*/
	public Integer getObjectType(){
		return objectType;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon_item:object_type
	* @Description: 设置属性        商品服务类型
	* @return: Integer
	*/
	public void setObjectType(Integer objectType){
		this.objectType = objectType;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon_item:object_id
	* @Description: 获取属性        商品服务标识
	* @return: String
	*/
	public String getObjectId(){
		return objectId;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon_item:object_id
	* @Description: 设置属性        商品服务标识
	* @return: String
	*/
	public void setObjectId(String objectId){
		this.objectId = objectId;	
	}	
	/**
	* @DatabasetableColumnName: tt_coupon_item:status
	* @Description: 获取属性        状态
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tt_coupon_item:status
	* @Description: 设置属性        状态
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	
	
	
	
}

