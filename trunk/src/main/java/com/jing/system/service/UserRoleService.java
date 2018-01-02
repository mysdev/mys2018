package com.jing.system.service;

import java.util.List;
import java.util.Map;


import com.jing.system.model.entity.UserRole;

/**
 * @ClassName: UserRole
 * @Description: 用户权限服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
public interface UserRoleService {

    /**
	 * @Title: addUserRole
	 * @Description:添加用户权限
	 * @param userRole 实体
	 * @return Integer
	 */
	UserRole addUserRole(UserRole userRole);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param userRole 实体
	 * @return List<UserRole>
	 */
	Map<String, Object> queryUserRoleForPage(Integer pagenum, Integer pagesize, String sort, UserRole userRole);
	 
	 /**
	 * @Title: queryUserRoleByProperty
	 * @Description:根据属性查询用户权限
	 * @return List<UserRole>
	 */
	 List<UserRole> queryUserRoleByProperty(Map<String, Object> map);	 
	 
}
