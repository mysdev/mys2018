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
 * @ClassName: UserRole
 * @Description: 用户权限实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class UserRole extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer userId;	//ts_user_role:user_id  用户标识  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer roleId;	//ts_user_role:role_id  角色标识  


	/**
	* @DatabasetableColumnName: ts_user_role:user_id
	* @Description: 获取属性        用户标识
	* @return: Integer
	*/
	public Integer getUserId(){
		return userId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_user_role:user_id
	* @Description: 设置属性        用户标识
	* @return: Integer
	*/
	public void setUserId(Integer userId){
		this.userId = userId;	
	}	
	/**
	* @DatabasetableColumnName: ts_user_role:role_id
	* @Description: 获取属性        角色标识
	* @return: Integer
	*/
	public Integer getRoleId(){
		return roleId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_user_role:role_id
	* @Description: 设置属性        角色标识
	* @return: Integer
	*/
	public void setRoleId(Integer roleId){
		this.roleId = roleId;	
	}	
	
	
	
	
}

