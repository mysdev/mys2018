package com.jing.system.permission.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.system.permission.entity.UserRole;

public interface UserRoleService {

	/**
	 * 添加 用户角色
	 */
	void addUserRole(UserRole userRole);

	/**
	 * 给用户添加所有人角色
	 * 
	 * @param userId
	 */
	void grantRoleAll(int userId);

	/**
	 * 分配角色
	 * 
	 * @param roleId
	 * @param userId
	 */
	void gantRole(String roleId, int userId);

	/**
	 * 修改 用户角色
	 */
	void updateUserRole(UserRole userRole);

	/**
	 * 根据ID删除记录
	 */
	void deleteUserRoleById(Integer id);

	/**
	 * 根据ID查询记录
	 */
	UserRole getUserRoleById(Integer id);

	/**
	 * 分页查询
	 */
	PageInfo findUserRoleListPage(PageInfo page, Map<String, Object> param);

	/**
	 * 根据属性查询用户角色
	 * 
	 * @param param
	 * @return
	 */
	List<UserRole> findUserRoleList(Map<String, Object> param);

	/**
	 * 根据用户ID和角色ID删除角色
	 * 
	 * @param userId
	 * @param roleId
	 */
	void deleteUserRoleByUserIdAndRoleId(int userId, String roleId, int deptCode);
}