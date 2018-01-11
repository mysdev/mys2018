package com.jing.settlement.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Authorization
 * @Description: 消费授权实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public class Authorization extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String authorizationId;	//to_authorization:authorization_id  授权码  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer customerId;	//to_authorization:customer_id  归属客户  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer types;	//to_authorization:types  终端类型 0房间 1手环  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String deviceId;	//to_authorization:device_id  终端标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//to_authorization:status  授权码状态 0正常  


	/**
	* @DatabasetableColumnName: to_authorization:authorization_id
	* @Description: 获取属性        授权码
	* @return: String
	*/
	public String getAuthorizationId(){
		return authorizationId;	
	}
	
	/**
	* @DatabasetableColumnName: to_authorization:authorization_id
	* @Description: 设置属性        授权码
	* @return: String
	*/
	public void setAuthorizationId(String authorizationId){
		this.authorizationId = authorizationId;	
	}	
	/**
	* @DatabasetableColumnName: to_authorization:customer_id
	* @Description: 获取属性        归属客户
	* @return: Integer
	*/
	public Integer getCustomerId(){
		return customerId;	
	}
	
	/**
	* @DatabasetableColumnName: to_authorization:customer_id
	* @Description: 设置属性        归属客户
	* @return: Integer
	*/
	public void setCustomerId(Integer customerId){
		this.customerId = customerId;	
	}	
	/**
	* @DatabasetableColumnName: to_authorization:types
	* @Description: 获取属性        终端类型 0房间 1手环
	* @return: Integer
	*/
	public Integer getTypes(){
		return types;	
	}
	
	/**
	* @DatabasetableColumnName: to_authorization:types
	* @Description: 设置属性        终端类型 0房间 1手环
	* @return: Integer
	*/
	public void setTypes(Integer types){
		this.types = types;	
	}	
	/**
	* @DatabasetableColumnName: to_authorization:device_id
	* @Description: 获取属性        终端标识
	* @return: String
	*/
	public String getDeviceId(){
		return deviceId;	
	}
	
	/**
	* @DatabasetableColumnName: to_authorization:device_id
	* @Description: 设置属性        终端标识
	* @return: String
	*/
	public void setDeviceId(String deviceId){
		this.deviceId = deviceId;	
	}	
	/**
	* @DatabasetableColumnName: to_authorization:status
	* @Description: 获取属性        授权码状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: to_authorization:status
	* @Description: 设置属性        授权码状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	
	
	
	
}

