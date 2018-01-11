package com.jing.system.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.system.model.entity.UserRole;

/**
 * @ClassName: UserRoleMapper
 * @Description: 用户权限映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Mapper
public interface UserRoleMapper {

	/**
	 * @Title: addUserRole
	 * @Description:添加用户权限
	 * @param userRole 实体
	 * @return Integer
	 */
	Integer addUserRole(UserRole userRole);
	
	/**
	 * @Title modifyUserRole
	 * @Description:修改用户权限
	 * @param userRole 实体
	 * @return Integer
	 */
	Integer modifyUserRole(UserRole userRole);
	
	/**
	 * @Title: dropUserRoleByUserId
	 * @Description:删除用户权限
	 * @param userId 实体标识
	 * @return Integer
	 */
	Integer dropUserRoleByUserId(Integer userId);
	
	/**
	 * @Title: queryUserRoleByUserId
	 * @Description:根据实体标识查询用户权限
	 * @param userId 实体标识
	 * @return UserRole
	 */
	UserRole queryUserRoleByUserId(Integer userId);
	 
	/**
	 * @Title: queryUserRoleForPage
	 * @Description: 根据用户权限属性与分页信息分页查询用户权限信息
	 * @param pageBounds 分页信息
	 * @param userRole 实体
	 * @return List<UserRole>
	 */
	List<UserRole> queryUserRoleForPage(PageBounds pageBounds, @Param("userRole") UserRole userRole);
	 
	 /**
	  * @Title: queryUserRoleByProperty
	  * @Description:根据属性查询用户权限
	  * @return List<UserRole>
	  */
	 List<UserRole> queryUserRoleByProperty(@Param("userRole") Map<String, Object> map);
	 
	 
	 
}
