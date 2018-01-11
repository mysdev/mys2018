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
 * @ClassName: Store
 * @Description: 门店实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class Store extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tb_store:store_id  门店标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeName;	//tb_store:store_name  门店名称  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tb_store:status  状态 0正常  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=256, message="{org.hibernate.validator.constraints.Length.message}")
	private String address;	//tb_store:address  地址  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	@Pattern(regexp="((\\d{3,4}-)[0-9]{7,8}(-[0-9]{0,4})?)", message="{javax.validation.constraints.Pattern.message}")
	private String phone;	//tb_store:phone  电话  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String license;	//tb_store:license  营业执照  

	@Length(min=0, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String sno;	//tb_store:sno  门店编号  

	@Length(min=0, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String logitude;	//tb_store:logitude  经度  

	@Length(min=0, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String latitude;	//tb_store:latitude  纬度  


	/**
	* @DatabasetableColumnName: tb_store:store_id
	* @Description: 获取属性        门店标识
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_store:store_id
	* @Description: 设置属性        门店标识
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: tb_store:store_name
	* @Description: 获取属性        门店名称
	* @return: String
	*/
	public String getStoreName(){
		return storeName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_store:store_name
	* @Description: 设置属性        门店名称
	* @return: String
	*/
	public void setStoreName(String storeName){
		this.storeName = storeName;	
	}	
	/**
	* @DatabasetableColumnName: tb_store:status
	* @Description: 获取属性        状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_store:status
	* @Description: 设置属性        状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tb_store:address
	* @Description: 获取属性        地址
	* @return: String
	*/
	public String getAddress(){
		return address;	
	}
	
	/**
	* @DatabasetableColumnName: tb_store:address
	* @Description: 设置属性        地址
	* @return: String
	*/
	public void setAddress(String address){
		this.address = address;	
	}	
	/**
	* @DatabasetableColumnName: tb_store:phone
	* @Description: 获取属性        电话
	* @return: String
	*/
	public String getPhone(){
		return phone;	
	}
	
	/**
	* @DatabasetableColumnName: tb_store:phone
	* @Description: 设置属性        电话
	* @return: String
	*/
	public void setPhone(String phone){
		this.phone = phone;	
	}	
	/**
	* @DatabasetableColumnName: tb_store:license
	* @Description: 获取属性        营业执照
	* @return: String
	*/
	public String getLicense(){
		return license;	
	}
	
	/**
	* @DatabasetableColumnName: tb_store:license
	* @Description: 设置属性        营业执照
	* @return: String
	*/
	public void setLicense(String license){
		this.license = license;	
	}	
	/**
	* @DatabasetableColumnName: tb_store:sno
	* @Description: 获取属性        门店编号
	* @return: String
	*/
	public String getSno(){
		return sno;	
	}
	
	/**
	* @DatabasetableColumnName: tb_store:sno
	* @Description: 设置属性        门店编号
	* @return: String
	*/
	public void setSno(String sno){
		this.sno = sno;	
	}	
	/**
	* @DatabasetableColumnName: tb_store:logitude
	* @Description: 获取属性        经度
	* @return: String
	*/
	public String getLogitude(){
		return logitude;	
	}
	
	/**
	* @DatabasetableColumnName: tb_store:logitude
	* @Description: 设置属性        经度
	* @return: String
	*/
	public void setLogitude(String logitude){
		this.logitude = logitude;	
	}	
	/**
	* @DatabasetableColumnName: tb_store:latitude
	* @Description: 获取属性        纬度
	* @return: String
	*/
	public String getLatitude(){
		return latitude;	
	}
	
	/**
	* @DatabasetableColumnName: tb_store:latitude
	* @Description: 设置属性        纬度
	* @return: String
	*/
	public void setLatitude(String latitude){
		this.latitude = latitude;	
	}	
	
	
	
	
}

