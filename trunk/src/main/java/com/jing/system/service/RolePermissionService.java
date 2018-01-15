package com.jing.system.service;

import java.util.List;
import java.util.Map;

import com.jing.system.model.entity.RolePermission;

/**
 * @ClassName: RolePermission
 * @Description: 角色权限服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public interface RolePermissionService {

	/**
	 * @Title: addRolePermission
	 * @Description:添加角色权限
	 * @param rolePermission
	 *            实体
	 * @return Integer
	 */
	RolePermission addRolePermission(RolePermission rolePermission);

	/**
	 * @Title modifyRolePermission
	 * @Description:修改角色权限
	 * @param rolePermission
	 *            实体
	 * @return Integer
	 */
	Integer modifyRolePermission(RolePermission rolePermission);

	/**
	 * @Title: dropRolePermissionByRoleId
	 * @Description:删除角色权限
	 * @param roleId
	 *            实体标识
	 * @return Integer
	 */
	Integer dropRolePermissionByRoleId(Integer roleId);

	/**
	 * @Title: queryRolePermissionByRoleId
	 * @Description:根据实体标识查询角色权限
	 * @param roleId
	 *            实体标识
	 * @return RolePermission
	 */
	RolePermission queryRolePermissionByRoleId(Integer roleId);

	/**
	 * @Title: queryRolePermissionForPage
	 * @Description: 根据角色权限属性与分页信息分页查询角色权限信息
	 * @param pagenum
	 *            页
	 * @param pagesize
	 *            页大小
	 * @param sort
	 *            排序
	 * @param rolePermission
	 *            实体
	 * @return List<RolePermission>
	 */
	Map<String, Object> queryRolePermissionForPage(Integer pagenum, Integer pagesize, String sort,
			RolePermission rolePermission);

	/**
	 * @Title: queryRolePermissionByProperty
	 * @Description:根据属性查询角色权限
	 * @return List<RolePermission>
	 */
	List<RolePermission> queryRolePermissionByProperty(Map<String, Object> map);

	/**
	 * 判断用户是否有资源的操作权限
	 * 
	 * @param url
	 * @param method
	 * @param userName
	 * @return
	 */
	boolean havePermission(String url, String method, String userName);

	/**
	 * 判断用户是否有资源的操作权限
	 * 
	 * @param url
	 * @param method
	 * @param userName
	 * @return
	 */
	boolean havePermission(String url, String method, int userId);

}
