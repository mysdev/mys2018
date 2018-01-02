package com.jing.system.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;


/**
 * @ClassName: Config
 * @Description: 系统配置实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
public class Config implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer propertyId;	//ts_config:property_id  属性标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String propertyCode;	//ts_config:property_code  属性代码  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=512, message="{org.hibernate.validator.constraints.Length.message}")
	private String propertyValue;	//ts_config:property_value  属性值  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String propertyNote;	//ts_config:property_note  属性描述  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String createdBy;	//ts_config:created_by  创建人员  

	private Date createdDate;	//ts_config:created_date  创建时间  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String updatedBy;	//ts_config:updated_by  修订人员  

	private Date updatedDate;	//ts_config:updated_date  修订时间  

	/**
	* @DatabasetableColumnName: ts_config:property_id
	* @Description: 获取属性        属性标识
	* @return: Integer
	*/
	public Integer getPropertyId(){
		return propertyId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:property_id
	* @Description: 设置属性        属性标识
	* @return: Integer
	*/
	public void setPropertyId(Integer propertyId){
		this.propertyId = propertyId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:property_code
	* @Description: 获取属性        属性代码
	* @return: String
	*/
	public String getPropertyCode(){
		return propertyCode;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:property_code
	* @Description: 设置属性        属性代码
	* @return: String
	*/
	public void setPropertyCode(String propertyCode){
		this.propertyCode = propertyCode;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:property_value
	* @Description: 获取属性        属性值
	* @return: String
	*/
	public String getPropertyValue(){
		return propertyValue;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:property_value
	* @Description: 设置属性        属性值
	* @return: String
	*/
	public void setPropertyValue(String propertyValue){
		this.propertyValue = propertyValue;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:property_note
	* @Description: 获取属性        属性描述
	* @return: String
	*/
	public String getPropertyNote(){
		return propertyNote;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:property_note
	* @Description: 设置属性        属性描述
	* @return: String
	*/
	public void setPropertyNote(String propertyNote){
		this.propertyNote = propertyNote;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:created_by
	* @Description: 获取属性        创建人员
	* @return: String
	*/
	public String getCreatedBy(){
		return createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:created_by
	* @Description: 设置属性        创建人员
	* @return: String
	*/
	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:created_date
	* @Description: 获取属性        创建时间
	* @return: Date
	*/
	public Date getCreatedDate(){
		return createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:created_date
	* @Description: 设置属性        创建时间
	* @return: Date
	*/
	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:updated_by
	* @Description: 获取属性        修订人员
	* @return: String
	*/
	public String getUpdatedBy(){
		return updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:updated_by
	* @Description: 设置属性        修订人员
	* @return: String
	*/
	public void setUpdatedBy(String updatedBy){
		this.updatedBy = updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:updated_date
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getUpdatedDate(){
		return updatedDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_config:updated_date
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setUpdatedDate(Date updatedDate){
		this.updatedDate = updatedDate;	
	}
	
	
	
	
	
}

