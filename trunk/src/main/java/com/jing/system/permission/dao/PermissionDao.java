package com.jing.system.permission.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.permission.entity.Permission;
import com.jing.system.permission.entity.Resources;

@Mapper
public interface PermissionDao {

	/**
	 * 添加 权限
	 */
	void addPermission(Permission permission);
	
	/**
	 * 批量插入
	 * @param list
	 */
	void batchAddPermission(@Param("list") List<Permission> list);

	/**
	 * 修改 权限
	 */
	void updatePermission(Permission permission);

	/**
	 * 根据RoleId删除记录
	 */
	void deletePermssionByRoleId(String id);

	/**
	 * 根据ID查询记录
	 */
	List<Permission> getPermissionById(String id);

	/**
	 * 分页查询
	 */
	List<Permission> findPermissionListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);

	/**
	 * 根据属性查询权限
	 * 
	 * @param param
	 * @return
	 */
	List<Permission> findPermissionList(@Param("param") Map<String, Object> param);

	/**
	 * 根据角色id和权限id删除权限
	 * 
	 * @param roleId
	 * @param resId
	 */
	void deletePermssionByRoleIdAndResId(@Param("roleId") String roleId, @Param("resId") Integer resId);
	
	/**
	 * 查询具有权限的按钮
	 * 
	 * @param user
	 * @param resId
	 * @return
	 */
	List<Resources> findActions(@Param("userId") int userId, @Param("parentId") int parentId,
			@Param("pageButtonKey") String pageButtonKey);
	
	/**
	 * 查询具有权限的菜单
	 * 
	 * @param user
	 * @param resId
	 * @return
	 */
	List<Resources> findMyMenus(@Param("userId") int userId);
}