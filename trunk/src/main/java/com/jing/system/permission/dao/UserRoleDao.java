package com.jing.system.permission.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.permission.entity.UserRole;

@Mapper
public interface UserRoleDao {

	/**
	* 添加 用户角色
	*/
	void addUserRole(UserRole userRole);
	
	/**
	* 修改 用户角色
	*/
	void updateUserRole(UserRole userRole);
	
	/**
	*根据ID删除记录
	*/
	void deleteUserRoleById(Integer userId);	
	
	/**
	*根据ID查询记录
	*/
	UserRole getUserRoleById(Integer id);
	
	/**
	* 分页查询
	*/
	List<UserRole> findUserRoleListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询用户角色
	 * @param param
	 * @return
	 */
	List<UserRole> findUserRoleList(@Param("param") Map<String, Object> param);	
	/**
	 * 根据用户id和角色id删除角色信息
	 * @param userId
	 * @param roleId
	 */
	void deleteUserRoleByUserIdAndRoleId(@Param("userId")int userId,@Param("roleId")String roleId,@Param("deptCode")int deptCode);
}