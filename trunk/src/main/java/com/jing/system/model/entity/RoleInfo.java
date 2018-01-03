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
 * @ClassName: RoleInfo
 * @Description: 角色实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
public class RoleInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer roleId;	//ts_role_info:role_id  角色标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String roleName;	//ts_role_info:role_name  角色名称  

	@Length(min=0, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String roleTitle;	//ts_role_info:role_title  角色标题  

	private Integer parentId;	//ts_role_info:parent_id  父级角色  

	@Length(min=0, max=2, message="{org.hibernate.validator.constraints.Length.message}")
	private String roleType;	//ts_role_info:role_type  角色类型  

	private Integer isGlobal;	//ts_role_info:is_global  全局角色  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer enabled;	//ts_role_info:enabled  是否启用 0正常  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String createdBy;	//ts_role_info:created_by  创建人员  

	private Date createdDate;	//ts_role_info:created_date  创建时间  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String updatedBy;	//ts_role_info:updated_by  修订人员  

	private Date updatedDate;	//ts_role_info:updated_date  修订时间  

	/**
	* @DatabasetableColumnName: ts_role_info:role_id
	* @Description: 获取属性        角色标识
	* @return: Integer
	*/
	public Integer getRoleId(){
		return roleId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:role_id
	* @Description: 设置属性        角色标识
	* @return: Integer
	*/
	public void setRoleId(Integer roleId){
		this.roleId = roleId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:role_name
	* @Description: 获取属性        角色名称
	* @return: String
	*/
	public String getRoleName(){
		return roleName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:role_name
	* @Description: 设置属性        角色名称
	* @return: String
	*/
	public void setRoleName(String roleName){
		this.roleName = roleName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:role_title
	* @Description: 获取属性        角色标题
	* @return: String
	*/
	public String getRoleTitle(){
		return roleTitle;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:role_title
	* @Description: 设置属性        角色标题
	* @return: String
	*/
	public void setRoleTitle(String roleTitle){
		this.roleTitle = roleTitle;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:parent_id
	* @Description: 获取属性        父级角色
	* @return: Integer
	*/
	public Integer getParentId(){
		return parentId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:parent_id
	* @Description: 设置属性        父级角色
	* @return: Integer
	*/
	public void setParentId(Integer parentId){
		this.parentId = parentId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:role_type
	* @Description: 获取属性        角色类型
	* @return: String
	*/
	public String getRoleType(){
		return roleType;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:role_type
	* @Description: 设置属性        角色类型
	* @return: String
	*/
	public void setRoleType(String roleType){
		this.roleType = roleType;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:is_global
	* @Description: 获取属性        全局角色
	* @return: Integer
	*/
	public Integer getIsGlobal(){
		return isGlobal;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:is_global
	* @Description: 设置属性        全局角色
	* @return: Integer
	*/
	public void setIsGlobal(Integer isGlobal){
		this.isGlobal = isGlobal;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:enabled
	* @Description: 获取属性        是否启用 0正常
	* @return: Integer
	*/
	public Integer getEnabled(){
		return enabled;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:enabled
	* @Description: 设置属性        是否启用 0正常
	* @return: Integer
	*/
	public void setEnabled(Integer enabled){
		this.enabled = enabled;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:created_by
	* @Description: 获取属性        创建人员
	* @return: String
	*/
	public String getCreatedBy(){
		return createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:created_by
	* @Description: 设置属性        创建人员
	* @return: String
	*/
	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:created_date
	* @Description: 获取属性        创建时间
	* @return: Date
	*/
	public Date getCreatedDate(){
		return createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:created_date
	* @Description: 设置属性        创建时间
	* @return: Date
	*/
	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:updated_by
	* @Description: 获取属性        修订人员
	* @return: String
	*/
	public String getUpdatedBy(){
		return updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:updated_by
	* @Description: 设置属性        修订人员
	* @return: String
	*/
	public void setUpdatedBy(String updatedBy){
		this.updatedBy = updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:updated_date
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getUpdatedDate(){
		return updatedDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_role_info:updated_date
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setUpdatedDate(Date updatedDate){
		this.updatedDate = updatedDate;	
	}
	
	
	
	
	
}

