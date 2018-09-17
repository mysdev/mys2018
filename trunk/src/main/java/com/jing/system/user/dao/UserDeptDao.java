package com.jing.system.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.user.entity.UserDept;

@Mapper
public interface UserDeptDao {

	/**
	* 添加 用户部门
	*/
	void addUserDept(UserDept userDept);
	
	/**
	* 修改 用户部门
	*/
	void updateUserDept(UserDept userDept);
	
	/**
	*根据ID删除记录
	*/
	void deleteUserDeptById(@Param("userId") Integer userId,@Param("deptCode") Integer deptCode);	
	
	/**
	*根据ID查询记录
	*/
	UserDept getUserDeptById(Integer id);
	
	/**
	* 分页查询
	*/
	List<UserDept> findUserDeptListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询用户部门
	 * @param param
	 * @return
	 */
	List<UserDept> findUserDeptList(@Param("param") Map<String, Object> param);	
}