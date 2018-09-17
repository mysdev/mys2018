package com.jing.system.user.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.system.user.entity.UserDept;

public interface UserDeptService {

	/**
	* 添加 用户部门
	*/
	void addUserDept(int userId,int deptCode);
	
	/**
	* 修改 用户部门
	*/
	void updateUserDept(UserDept userDept);
	
	/**
	*根据ID删除记录
	*/
	void deleteUserDeptById(int userId,int deptCode);	
	
	/**
	*根据ID查询记录
	*/
	UserDept getUserDeptById(Integer id);
	
	/**
	* 分页查询
	*/
	PageInfo findUserDeptListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询用户部门
	 * @param param
	 * @return
	 */
	List<UserDept> findUserDeptList(Map<String, Object> param);
}