package com.jing.system.permission.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.system.permission.entity.Permission;
import com.jing.system.permission.entity.Resources;
import com.jing.system.user.entity.User;

public interface PermissionService {

	/**
	* 添加 权限
	*/
	void addPermission(Permission permission);
	
	/**
	* 修改 权限
	*/
	void updatePermission(Permission permission);
	
	/**
	*根据ID删除记录
	*/
	void deletePermssionByRoleId(String id);	
	
	/**
	*根据ID查询记录
	*/
	List<Permission> getPermissionById(String id);
	
	/**
	* 分页查询
	*/
	PageInfo findPermissionListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 新增角色权限
	 * @param param
	 * @return
	 */
	void addPermission(String roleIdm,String resId);
	/**
	 * 根据角色id和权限id删除权限
	 * @param roleId
	 * @param resid
	 */
	void deletePermssionByRoleIdAndResId(String roleId,int resid);
	
	/**
	 * 判断用户是否有资源的权限
	 * @param user
	 * @param resId
	 * @return
	 */
	boolean hasPermission(User user,int resId);
	
	/**
	 * 查询具有权限的按钮
	 * @param user
	 * @param resId
	 * @return
	 */
	List<Resources> findActions(User user,int parentId,String pageButtonKey);
	
	/**
	 * 查询具有权限的菜单
	 */
	List<Resources> findMyMenus(int userId);
}