package com.jing.system.permission.entity;

import com.jing.utils.BaseEntity;

/**
 * 用户角色 实体类
 * @author codeing gen
 */
public class UserRole extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private Integer userId;   // 用户ID
	private String roleId;   // 角色ID
	private Integer deptCode;   // 部门编号
	
	public UserRole(int userId,String roleId,int deptCode) {
		this.userId = userId;
		this.roleId = roleId;
		this.deptCode = deptCode;
	}
	
	public UserRole() {
	}

	public Integer getUserId() {	    return this.userId;	}
	public String getRoleId() {	    return this.roleId;	}
	public Integer getDeptCode() {	    return this.deptCode;	}

	public void setUserId(Integer userId){	this.userId = userId;	}
	public void setRoleId(String roleId){	this.roleId = roleId;	}
	public void setDeptCode(Integer deptCode){	this.deptCode = deptCode;	}

}