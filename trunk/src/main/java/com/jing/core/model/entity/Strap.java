package com.jing.core.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Strap
 * @Description: 手牌实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class Strap extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String strapId;	//tb_strap:strap_id  手牌标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tb_strap:store_id  归属门店  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String strapSerial;	//tb_strap:strap_serial  手牌号码  

	@Length(min=0, max=8, message="{org.hibernate.validator.constraints.Length.message}")
	private String strapNo;	//tb_strap:strap_no  手牌编号  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer types;	//tb_strap:types  手牌类型  

	private Integer status;	//tb_strap:status  手牌状态 0正常  


	/**
	* @DatabasetableColumnName: tb_strap:strap_id
	* @Description: 获取属性        手牌标识
	* @return: String
	*/
	public String getStrapId(){
		return strapId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_strap:strap_id
	* @Description: 设置属性        手牌标识
	* @return: String
	*/
	public void setStrapId(String strapId){
		this.strapId = strapId;	
	}	
	/**
	* @DatabasetableColumnName: tb_strap:store_id
	* @Description: 获取属性        归属门店
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_strap:store_id
	* @Description: 设置属性        归属门店
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: tb_strap:strap_serial
	* @Description: 获取属性        手牌号码
	* @return: String
	*/
	public String getStrapSerial(){
		return strapSerial;	
	}
	
	/**
	* @DatabasetableColumnName: tb_strap:strap_serial
	* @Description: 设置属性        手牌号码
	* @return: String
	*/
	public void setStrapSerial(String strapSerial){
		this.strapSerial = strapSerial;	
	}	
	/**
	* @DatabasetableColumnName: tb_strap:strap_no
	* @Description: 获取属性        手牌编号
	* @return: String
	*/
	public String getStrapNo(){
		return strapNo;	
	}
	
	/**
	* @DatabasetableColumnName: tb_strap:strap_no
	* @Description: 设置属性        手牌编号
	* @return: String
	*/
	public void setStrapNo(String strapNo){
		this.strapNo = strapNo;	
	}	
	/**
	* @DatabasetableColumnName: tb_strap:types
	* @Description: 获取属性        手牌类型
	* @return: Integer
	*/
	public Integer getTypes(){
		return types;	
	}
	
	/**
	* @DatabasetableColumnName: tb_strap:types
	* @Description: 设置属性        手牌类型
	* @return: Integer
	*/
	public void setTypes(Integer types){
		this.types = types;	
	}	
	/**
	* @DatabasetableColumnName: tb_strap:status
	* @Description: 获取属性        手牌状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_strap:status
	* @Description: 设置属性        手牌状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	
	
	
	
}

