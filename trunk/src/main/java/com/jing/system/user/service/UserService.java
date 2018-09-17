package com.jing.system.user.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.system.user.entity.User;

public interface UserService {

	/**
	 * 添加 用户
	 * 
	 * @throws CustomException
	 */
	User addUser(User user, int deptCode) throws CustomException;

	/**
	 * 修改 用户
	 */
	void updateUser(User user);

	/**
	 * 根据ID删除记录
	 */
	void deleteUserById(int userId, int deptCode);

	/**
	 * 根据ID查询记录
	 */
	User getUserById(int id);

	/**
	 * 根据账号查询用户记录
	 * 
	 * @param userName
	 * @return
	 */
	User getUserByUserName(String userName);

	/**
	 * 分页查询
	 */
	PageInfo findUserListPage(PageInfo page, Map<String, Object> param);

	/**
	 * 根据属性查询用户
	 * 
	 * @param param
	 * @return
	 */
	List<User> findUserList(Map<String, Object> param);

	/**
	 * 根据资源ID查找有权限的用户
	 * 
	 * @param resId
	 * @return
	 */
	List<User> findUserByResourceId(int resId);

	/**
	 * 根据角色ID找用户
	 * 
	 * @param roleId
	 * @return
	 */
	List<User> findUserByRoleId(String roleId);

	/**
	 * 修改密码
	 * 
	 * @param username
	 * @param oldPassword
	 * @param password
	 */
	void resetPassword(String username, String oldPassword, String password, int userId) throws CustomException;

}
