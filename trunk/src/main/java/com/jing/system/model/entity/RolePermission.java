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
 * @ClassName: RolePermission
 * @Description: 角色权限实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class RolePermission extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer roleId;	//ts_role_permission:role_id  角色标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer resourceId;	//ts_role_permission:resource_id  资源标识  


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
	
	
	
	
}

