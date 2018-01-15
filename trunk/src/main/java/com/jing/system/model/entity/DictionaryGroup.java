package com.jing.system.model.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: DictionaryGroup
 * @Description: 字典分组实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class DictionaryGroup extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer groupId;	//ts_dictionary_group:group_id  分组标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String groupCode;	//ts_dictionary_group:group_code  分组代码  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String groupName;	//ts_dictionary_group:group_name  分组名称  

	@Length(min=1, max=255, message="{org.hibernate.validator.constraints.Length.message}")
	private String remark;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}	
	
	
}

