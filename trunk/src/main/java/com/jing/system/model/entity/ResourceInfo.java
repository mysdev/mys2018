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
 * @ClassName: ResourceInfo
 * @Description: 资源菜单实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
public class ResourceInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer resourceId;	//ts_resource_info:resource_id  资源标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String title;	//ts_resource_info:title  资源名称  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String type;	//ts_resource_info:type  资源类型  

	@Length(min=0, max=8, message="{org.hibernate.validator.constraints.Length.message}")
	private String url;	//ts_resource_info:url  资源地址  

	@Length(min=0, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String image;	//ts_resource_info:image  资源图片  

	private Integer parentId;	//ts_resource_info:parent_id  父资源  

	private Integer isDisplay;	//ts_resource_info:is_display  是否显示 0显示  

	private Integer sequence;	//ts_resource_info:sequence  资源排序  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer enabled;	//ts_resource_info:enabled  是否启用 0正常  

	@Length(min=0, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String note;	//ts_resource_info:note  资源描述  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String createdBy;	//ts_resource_info:created_by  创建人员  

	private Date createdDate;	//ts_resource_info:created_date  创建时间  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String updatedBy;	//ts_resource_info:updated_by  修订人员  

	private Date updatedDate;	//ts_resource_info:updated_date  修订时间  

	/**
	* @DatabasetableColumnName: ts_resource_info:resource_id
	* @Description: 获取属性        资源标识
	* @return: Integer
	*/
	public Integer getResourceId(){
		return resourceId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:resource_id
	* @Description: 设置属性        资源标识
	* @return: Integer
	*/
	public void setResourceId(Integer resourceId){
		this.resourceId = resourceId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:title
	* @Description: 获取属性        资源名称
	* @return: String
	*/
	public String getTitle(){
		return title;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:title
	* @Description: 设置属性        资源名称
	* @return: String
	*/
	public void setTitle(String title){
		this.title = title;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:type
	* @Description: 获取属性        资源类型
	* @return: String
	*/
	public String getType(){
		return type;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:type
	* @Description: 设置属性        资源类型
	* @return: String
	*/
	public void setType(String type){
		this.type = type;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:url
	* @Description: 获取属性        资源地址
	* @return: String
	*/
	public String getUrl(){
		return url;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:url
	* @Description: 设置属性        资源地址
	* @return: String
	*/
	public void setUrl(String url){
		this.url = url;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:image
	* @Description: 获取属性        资源图片
	* @return: String
	*/
	public String getImage(){
		return image;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:image
	* @Description: 设置属性        资源图片
	* @return: String
	*/
	public void setImage(String image){
		this.image = image;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:parent_id
	* @Description: 获取属性        父资源
	* @return: Integer
	*/
	public Integer getParentId(){
		return parentId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:parent_id
	* @Description: 设置属性        父资源
	* @return: Integer
	*/
	public void setParentId(Integer parentId){
		this.parentId = parentId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:is_display
	* @Description: 获取属性        是否显示 0显示
	* @return: Integer
	*/
	public Integer getIsDisplay(){
		return isDisplay;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:is_display
	* @Description: 设置属性        是否显示 0显示
	* @return: Integer
	*/
	public void setIsDisplay(Integer isDisplay){
		this.isDisplay = isDisplay;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:sequence
	* @Description: 获取属性        资源排序
	* @return: Integer
	*/
	public Integer getSequence(){
		return sequence;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:sequence
	* @Description: 设置属性        资源排序
	* @return: Integer
	*/
	public void setSequence(Integer sequence){
		this.sequence = sequence;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:enabled
	* @Description: 获取属性        是否启用 0正常
	* @return: Integer
	*/
	public Integer getEnabled(){
		return enabled;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:enabled
	* @Description: 设置属性        是否启用 0正常
	* @return: Integer
	*/
	public void setEnabled(Integer enabled){
		this.enabled = enabled;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:note
	* @Description: 获取属性        资源描述
	* @return: String
	*/
	public String getNote(){
		return note;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:note
	* @Description: 设置属性        资源描述
	* @return: String
	*/
	public void setNote(String note){
		this.note = note;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:created_by
	* @Description: 获取属性        创建人员
	* @return: String
	*/
	public String getCreatedBy(){
		return createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:created_by
	* @Description: 设置属性        创建人员
	* @return: String
	*/
	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:created_date
	* @Description: 获取属性        创建时间
	* @return: Date
	*/
	public Date getCreatedDate(){
		return createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:created_date
	* @Description: 设置属性        创建时间
	* @return: Date
	*/
	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:updated_by
	* @Description: 获取属性        修订人员
	* @return: String
	*/
	public String getUpdatedBy(){
		return updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:updated_by
	* @Description: 设置属性        修订人员
	* @return: String
	*/
	public void setUpdatedBy(String updatedBy){
		this.updatedBy = updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:updated_date
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getUpdatedDate(){
		return updatedDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_resource_info:updated_date
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setUpdatedDate(Date updatedDate){
		this.updatedDate = updatedDate;	
	}
	
	
	
	
	
}

