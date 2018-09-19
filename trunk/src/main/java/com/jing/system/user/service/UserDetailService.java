package com.jing.system.user.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.system.user.entity.UserDetail;

public interface UserDetailService {
	
	void addFullUser(UserDetail userDetail,String roleId) throws CustomException;

	/**
	* 添加 用户详情
	*/
	void addUserDetail(UserDetail userDetail);
	
	/**
	* 修改 用户详情
	*/
	void updateUserDetail(UserDetail userDetail);
	
	/**
	*根据ID删除记录
	*/
	void deleteUserDetailById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	UserDetail getUserDetailById(Integer id);
	
	/**
	*根据ID查询记录
	*/
	UserDetail getUserDetailByIdSimple(Integer id);
	
	/**
	* 分页查询
	*/
	PageInfo findUserDetailListPage(PageInfo page, Map<String, Object> param);
	
	/**
	 * 分页查询user
	 */
	PageInfo findGridUserDetailListPage(PageInfo page, Map<String, Object> param);
	/**
	 * 根据属性查询用户详情
	 * @param param
	 * @return
	 */
	List<UserDetail> findUserDetailList(Map<String, Object> param);
	
	/**
	 * 根据属性查询用户详情【综合查询】
	 * @param param
	 * @return
	 */
	List<UserDetail> findUserListComplex(Map<String, Object> param);
	
}