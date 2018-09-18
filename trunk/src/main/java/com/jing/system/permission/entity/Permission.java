package com.jing.system.permission.entity;

import com.jing.utils.BaseEntity;

/**
 * 权限 实体类
 * @author codeing gen
 */
public class Permission extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private String roleId;   // 角色ID
	private Integer resId;   // 资源ID

	public String getRoleId() {	    return this.roleId;	}
	public Integer getResId() {	    return this.resId;	}

	public void setRoleId(String roleId){	this.roleId = roleId;	}
	public void setResId(Integer resId){	this.resId = resId;	}

}