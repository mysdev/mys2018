package com.jing.system.user.entity;

import com.jing.utils.BaseEntity;

/**
 * 用户部门 实体类
 * @author codeing gen
 */
public class UserDept extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private Integer userId;   // 用户ID
	private Integer deptCode;   // 部门编码
	public UserDept() {
	}
	
	public UserDept(int userId,int deptCode) {
		this.userId=userId;
		this.deptCode = deptCode;
	}

	public Integer getUserId() {	    return this.userId;	}
	public Integer getDeptCode() {	    return this.deptCode;	}

	public void setUserId(Integer userId){	this.userId = userId;	}
	public void setDeptCode(Integer deptCode){	this.deptCode = deptCode;	}

}