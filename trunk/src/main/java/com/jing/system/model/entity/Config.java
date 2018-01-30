package com.jing.system.model.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Config
 * @Description: 系统配置实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class Config extends BaseEntity {
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
	
	
	
	
}

