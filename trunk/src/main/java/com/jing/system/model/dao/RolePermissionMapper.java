package com.jing.system.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.system.model.entity.RolePermission;

/**
 * @ClassName: RolePermissionMapper
 * @Description: 角色权限映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
@Mapper
public interface RolePermissionMapper {

	/**
	 * @Title: addRolePermission
	 * @Description:添加角色权限
	 * @param rolePermission 实体
	 * @return Integer
	 */
	Integer addRolePermission(RolePermission rolePermission);
	
	/**
	 * @Title modifyRolePermission
	 * @Description:修改角色权限
	 * @param rolePermission 实体
	 * @return Integer
	 */
	Integer modifyRolePermission(RolePermission rolePermission);
	
	/**
	 * @Title: dropRolePermissionByRoleId
	 * @Description:删除角色权限
	 * @param roleId 实体标识
	 * @return Integer
	 */
	Integer dropRolePermissionByRoleId(Integer roleId);
	
	/**
	 * @Title: queryRolePermissionByRoleId
	 * @Description:根据实体标识查询角色权限
	 * @param roleId 实体标识
	 * @return RolePermission
	 */
	RolePermission queryRolePermissionByRoleId(Integer roleId);
	 
	/**
	 * @Title: queryRolePermissionForPage
	 * @Description: 根据角色权限属性与分页信息分页查询角色权限信息
	 * @param pageBounds 分页信息
	 * @param rolePermission 实体
	 * @return List<RolePermission>
	 */
	List<RolePermission> queryRolePermissionForPage(PageBounds pageBounds, @Param("rolePermission") RolePermission rolePermission);
	 
	 /**
	  * @Title: queryRolePermissionByProperty
	  * @Description:根据属性查询角色权限
	  * @return List<RolePermission>
	  */
	 List<RolePermission> queryRolePermissionByProperty(@Param("rolePermission") Map<String, Object> map);
	 
	 
	 
}
