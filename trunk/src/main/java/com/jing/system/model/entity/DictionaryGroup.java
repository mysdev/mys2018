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
 * @ClassName: DictionaryGroup
 * @Description: 字典分组实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
public class DictionaryGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer groupId;	//ts_dictionary_group:group_id  分组标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String groupCode;	//ts_dictionary_group:group_code  分组代码  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String groupName;	//ts_dictionary_group:group_name  分组名称  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String createdBy;	//ts_dictionary_group:created_by  创建人员  

	private Date createdDate;	//ts_dictionary_group:created_date  创建时间  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String updatedBy;	//ts_dictionary_group:updated_by  修订人员  

	private Date updatedDate;	//ts_dictionary_group:updated_date  修订时间  

	/**
	* @DatabasetableColumnName: ts_dictionary_group:group_id
	* @Description: 获取属性        分组标识
	* @return: Integer
	*/
	public Integer getGroupId(){
		return groupId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:group_id
	* @Description: 设置属性        分组标识
	* @return: Integer
	*/
	public void setGroupId(Integer groupId){
		this.groupId = groupId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:group_code
	* @Description: 获取属性        分组代码
	* @return: String
	*/
	public String getGroupCode(){
		return groupCode;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:group_code
	* @Description: 设置属性        分组代码
	* @return: String
	*/
	public void setGroupCode(String groupCode){
		this.groupCode = groupCode;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:group_name
	* @Description: 获取属性        分组名称
	* @return: String
	*/
	public String getGroupName(){
		return groupName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:group_name
	* @Description: 设置属性        分组名称
	* @return: String
	*/
	public void setGroupName(String groupName){
		this.groupName = groupName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:created_by
	* @Description: 获取属性        创建人员
	* @return: String
	*/
	public String getCreatedBy(){
		return createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:created_by
	* @Description: 设置属性        创建人员
	* @return: String
	*/
	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:created_date
	* @Description: 获取属性        创建时间
	* @return: Date
	*/
	public Date getCreatedDate(){
		return createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:created_date
	* @Description: 设置属性        创建时间
	* @return: Date
	*/
	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:updated_by
	* @Description: 获取属性        修订人员
	* @return: String
	*/
	public String getUpdatedBy(){
		return updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:updated_by
	* @Description: 设置属性        修订人员
	* @return: String
	*/
	public void setUpdatedBy(String updatedBy){
		this.updatedBy = updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:updated_date
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getUpdatedDate(){
		return updatedDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary_group:updated_date
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setUpdatedDate(Date updatedDate){
		this.updatedDate = updatedDate;	
	}
	
	
	
	
	
}

