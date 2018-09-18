package com.jing.system.permission.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.config.web.security.SecurityRoleDetail;
import com.jing.system.permission.entity.Role;

@Mapper
public interface RoleDao {

	/**
	* 添加 角色
	*/
	void addRole(Role role);
	
	/**
	* 修改 角色
	*/
	void updateRole(Role role);
	
	/**
	*根据ID删除记录
	*/
	void deleteRoleById(String id);	
	
	/**
	*根据ID查询记录
	*/
	Role getRoleById(String id);
	
	/**
	* 分页查询
	*/
	List<Role> findRoleListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);	
	
	/**
	 * 根据属性查询角色
	 * @param param
	 * @return
	 */
	List<Role> findRoleList(@Param("param") Map<String, Object> param);	
	
	/**
	 * 根据用户查询角色
	 * @param userId
	 * @return
	 */
	List<Role> findRoleListByUserId(int userId);
	
	
	/**
	 * 查询可访问资源的角色列表
	 * @param url
	 * @return
	 */
	List<SecurityRoleDetail> findRolesByResUrl(String url);
	
	/**
	 * 
	 * 根据用户查询角色(除ROLE0)
	 * @param UserId
	 * @return
	 */
	List<Role> findRoleLisRemoveRole0tByUserId(int UserId);
	
	/**
	 * 查询所有角色(带权限)
	 * @param roleId
	 * @return
	 */
	List<Role> findRolesByAll(String roleId);

	/**
	 * 根据部门ID查询能分配给用户的角色
	 * @param deptCode
	 * @return
	 */
	List<Role> selectRoleByDeptCode(int deptCode);

}