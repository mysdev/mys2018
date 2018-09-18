package com.jing.system.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.user.entity.UserDetail;

@Mapper
public interface UserDetailDao {

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
	 * 根据ID查询用户详情单表
	 */
	UserDetail getUserDetailByIdSimple(Integer id);
	
	/**
	* 分页查询
	*/
	List<UserDetail> findUserDetailListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	/**
	* 分页查询
	*/
	List<UserDetail> findGridUserDetailListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询用户详情
	 * @param param
	 * @return
	 */
	List<UserDetail> findUserDetailList(@Param("param") Map<String, Object> param);	
	
	
	/**
	 * 根据属性查询用户详情【综合查询】[nickName,roleId,deptCode,areaCode]
	 * @param param
	 * @return
	 */
	List<UserDetail> findUserListComplex(@Param("param") Map<String, Object> param);
}