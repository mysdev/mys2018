package com.jing.core.model.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: TypesBind
 * @Description: 类型消费绑定实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class TypesBind extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer bindId;	//tb_types_bind:bind_id  绑定标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer typeId;	//tb_types_bind:type_id  类型标识 0商品1套餐  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String objectId;	//tb_types_bind:object_id  物品标识 商品 套餐  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer objectCt;	//tb_types_bind:object_ct  物品数量  


	/**
	* @DatabasetableColumnName: tb_types_bind:bind_id
	* @Description: 获取属性        绑定标识
	* @return: Integer
	*/
	public Integer getBindId(){
		return bindId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types_bind:bind_id
	* @Description: 设置属性        绑定标识
	* @return: Integer
	*/
	public void setBindId(Integer bindId){
		this.bindId = bindId;	
	}	
	/**
	* @DatabasetableColumnName: tb_types_bind:type_id
	* @Description: 获取属性        类型标识 0商品1套餐
	* @return: Integer
	*/
	public Integer getTypeId(){
		return typeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types_bind:type_id
	* @Description: 设置属性        类型标识 0商品1套餐
	* @return: Integer
	*/
	public void setTypeId(Integer typeId){
		this.typeId = typeId;	
	}	
	/**
	* @DatabasetableColumnName: tb_types_bind:object_id
	* @Description: 获取属性        物品标识 商品 套餐
	* @return: String
	*/
	public String getObjectId(){
		return objectId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types_bind:object_id
	* @Description: 设置属性        物品标识 商品 套餐
	* @return: String
	*/
	public void setObjectId(String objectId){
		this.objectId = objectId;	
	}	
	/**
	* @DatabasetableColumnName: tb_types_bind:object_ct
	* @Description: 获取属性        物品数量
	* @return: Integer
	*/
	public Integer getObjectCt(){
		return objectCt;	
	}
	
	/**
	* @DatabasetableColumnName: tb_types_bind:object_ct
	* @Description: 设置属性        物品数量
	* @return: Integer
	*/
	public void setObjectCt(Integer objectCt){
		this.objectCt = objectCt;	
	}	
	
	
	
	
}

