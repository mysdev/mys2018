package com.jing.system.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.user.entity.User;

@Mapper
public interface UserDao {

	/**
	* 添加 用户
	*/
	void addUser(User user);
	
	/**
	* 修改 用户
	*/
	void updateUser(User user);
	
	/**
	*根据ID删除记录
	*/
	void deleteUserById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	User getUserById(Integer id);
	
	/**
	* 分页查询
	*/
	List<User> findUserListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询用户
	 * @param param
	 * @return
	 */
	List<User> findUserList(@Param("param") Map<String, Object> param);	
	
	
	/**
	 * 根据资源ID查找有权限的用户
	 * @param resId
	 * @return
	 */
	List<User> findUserByResourceId(int resId);
	
	/**
	 * 根据角色ID找用户
	 * @param roleId
	 * @return
	 */
	List<User> findUserByRoleId(String roleId);
}