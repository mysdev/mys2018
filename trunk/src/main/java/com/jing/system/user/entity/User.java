package com.jing.system.user.entity;

import java.util.ArrayList;
import java.util.List;

import com.jing.config.web.security.SecurityRoleDetail;
import com.jing.config.web.security.SecurityUserDetail;
import com.jing.system.dept.entity.Dept;
import com.jing.system.dept.util.DeptMapper;
import com.jing.system.permission.entity.Role;
import com.jing.system.permission.entity.UserRole;
import com.jing.system.user.uitl.UserDeptMapper;
import com.jing.utils.CustomizedDES;

/**
 * 用户 实体类
 * 
 * @author codeing gen
 */
public class User extends SecurityUserDetail {
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_PASSWORD = "123456";

	private Integer userId; // 用户ID
	private String username; // 用户名
	private String password; // 密码
	private String nickName; // 昵称
	private Integer status; // 账号状态
	private Integer loginStatus; // 登录状态
	private String clintId; // 客户端标识	
	
	private Integer deptCode;	
	private Dept dept;    //部门对象;
	private List<Dept> depts;//关联部门
	
	private List<Role> userRole;
	private List<UserRole> userRoles;
	
	public Dept getDept() {
		if(getDeptCode()!=null){
			return DeptMapper.getObj(getDeptCode());
		}
		return dept;
	}
	
	public List<Dept> getDepts() {
		List<UserDept> list = UserDeptMapper.getObj(getUserId());
		if(list !=null && list.size()>0){
			depts = new ArrayList<Dept>();
			for (UserDept userDept : list) {
				depts.add(DeptMapper.getObj(userDept.getDeptCode()));
			}
		}
		return depts;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public boolean isAdmin() {
		if (userRole != null && userRole.size() > 0) {
			for (Role role : userRole) {
				if ("ROLE1".equals(role.getRoleId())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public List<Role> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<SecurityRoleDetail> roles) {
		if (roles != null) {
			userRole = new ArrayList<Role>();
			for (SecurityRoleDetail role : roles) {
				userRole.add((Role) role);
			}
		}
	}

	public Integer getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(Integer deptCode) {
		this.deptCode = deptCode;
	}

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getClintId() {
		return clintId;
	}

	public void setClintId(String clintId) {
		this.clintId = clintId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Override
	public String getPassword() {
		return CustomizedDES.getEncodeText(password);
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}