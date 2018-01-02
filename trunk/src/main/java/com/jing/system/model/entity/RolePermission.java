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
 * @ClassName: RolePermission
 * @Description: 角色权限实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
public class RolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer roleId;	//ts_role_permission:role_id  角色标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer resourceId;	//ts_role_permission:resource_id  资源标识  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String createdBy;	//ts_role_permission:created_by  创建人员  

	private Date createdDate;	//ts_role_permission:created_date  创建时间  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String updatedBy;	//ts_role_permission:updated_by  修订人员  

	private Date updatedDate;	//ts_role_permission:updated_date  修订时间  

	/**
	* @DatabasetableColumnName: ts_role_permission:role_id
	* @Description: 获取属性        角色标识
	* @return: Integer
	*/
	public Integer getRoleId(){
		return roleId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_permission:role_id
	* @Description: 设置属性        角色标识
	* @return: Integer
	*/
	public void setRoleId(Integer roleId){
		this.roleId = roleId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_permission:resource_id
	* @Description: 获取属性        资源标识
	* @return: Integer
	*/
	public Integer getResourceId(){
		return resourceId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_permission:resource_id
	* @Description: 设置属性        资源标识
	* @return: Integer
	*/
	public void setResourceId(Integer resourceId){
		this.resourceId = resourceId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_permission:created_by
	* @Description: 获取属性        创建人员
	* @return: String
	*/
	public String getCreatedBy(){
		return createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_permission:created_by
	* @Description: 设置属性        创建人员
	* @return: String
	*/
	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_permission:created_date
	* @Description: 获取属性        创建时间
	* @return: Date
	*/
	public Date getCreatedDate(){
		return createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_permission:created_date
	* @Description: 设置属性        创建时间
	* @return: Date
	*/
	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_permission:updated_by
	* @Description: 获取属性        修订人员
	* @return: String
	*/
	public String getUpdatedBy(){
		return updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_permission:updated_by
	* @Description: 设置属性        修订人员
	* @return: String
	*/
	public void setUpdatedBy(String updatedBy){
		this.updatedBy = updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_permission:updated_date
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getUpdatedDate(){
		return updatedDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_permission:updated_date
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setUpdatedDate(Date updatedDate){
		this.updatedDate = updatedDate;	
	}
	
	
	
	
	
}

