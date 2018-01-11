package com.jing.system.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Dictionary
 * @Description: 字典值实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class Dictionary extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer id;	//ts_dictionary:id  字典标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String code;	//ts_dictionary:code  字典编码  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String value;	//ts_dictionary:value  字典值  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String groupCode;	//ts_dictionary:group_code  归属字典分组  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String parentCode;	//ts_dictionary:parent_code  父字典编码  

	private Integer sequence;	//ts_dictionary:sequence  字典排序  

	private Integer flag;	//ts_dictionary:flag  字典状态 0正常1停用  


	/**
	* @DatabasetableColumnName: ts_dictionary:id
	* @Description: 获取属性        字典标识
	* @return: Integer
	*/
	public Integer getId(){
		return id;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary:id
	* @Description: 设置属性        字典标识
	* @return: Integer
	*/
	public void setId(Integer id){
		this.id = id;	
	}	
	/**
	* @DatabasetableColumnName: ts_dictionary:code
	* @Description: 获取属性        字典编码
	* @return: String
	*/
	public String getCode(){
		return code;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary:code
	* @Description: 设置属性        字典编码
	* @return: String
	*/
	public void setCode(String code){
		this.code = code;	
	}	
	/**
	* @DatabasetableColumnName: ts_dictionary:value
	* @Description: 获取属性        字典值
	* @return: String
	*/
	public String getValue(){
		return value;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary:value
	* @Description: 设置属性        字典值
	* @return: String
	*/
	public void setValue(String value){
		this.value = value;	
	}	
	/**
	* @DatabasetableColumnName: ts_dictionary:group_code
	* @Description: 获取属性        归属字典分组
	* @return: String
	*/
	public String getGroupCode(){
		return groupCode;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary:group_code
	* @Description: 设置属性        归属字典分组
	* @return: String
	*/
	public void setGroupCode(String groupCode){
		this.groupCode = groupCode;	
	}	
	/**
	* @DatabasetableColumnName: ts_dictionary:parent_code
	* @Description: 获取属性        父字典编码
	* @return: String
	*/
	public String getParentCode(){
		return parentCode;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary:parent_code
	* @Description: 设置属性        父字典编码
	* @return: String
	*/
	public void setParentCode(String parentCode){
		this.parentCode = parentCode;	
	}	
	/**
	* @DatabasetableColumnName: ts_dictionary:sequence
	* @Description: 获取属性        字典排序
	* @return: Integer
	*/
	public Integer getSequence(){
		return sequence;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary:sequence
	* @Description: 设置属性        字典排序
	* @return: Integer
	*/
	public void setSequence(Integer sequence){
		this.sequence = sequence;	
	}	
	/**
	* @DatabasetableColumnName: ts_dictionary:flag
	* @Description: 获取属性        字典状态 0正常1停用
	* @return: Integer
	*/
	public Integer getFlag(){
		return flag;	
	}
	
	/**
	* @DatabasetableColumnName: ts_dictionary:flag
	* @Description: 设置属性        字典状态 0正常1停用
	* @return: Integer
	*/
	public void setFlag(Integer flag){
		this.flag = flag;	
	}	
	
	
	
	
}

