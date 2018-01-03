package com.jing.system.service;

import java.util.List;
import java.util.Map;


import com.jing.system.model.entity.UserGroup;

/**
 * @ClassName: UserGroup
 * @Description: 用户组服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
public interface UserGroupService {

    /**
	 * @Title: addUserGroup
	 * @Description:添加用户组
	 * @param userGroup 实体
	 * @return Integer
	 */
	UserGroup addUserGroup(UserGroup userGroup);
	
	/**
	 * @Title modifyUserGroup
	 * @Description:修改用户组
	 * @param userGroup 实体
	 * @return Integer
	 */
	Integer modifyUserGroup(UserGroup userGroup);
	
	/**
	 * @Title: dropUserGroupByTeamId
	 * @Description:删除用户组
	 * @param teamId 实体标识
	 * @return Integer
	 */
	Integer dropUserGroupByTeamId(Integer teamId);
	
	/**
	 * @Title: queryUserGroupByTeamId
	 * @Description:根据实体标识查询用户组
	 * @param teamId 实体标识
	 * @return UserGroup
	 */
	UserGroup queryUserGroupByTeamId(Integer teamId);
	 
	/**
	 * @Title: queryUserGroupForPage
	 * @Description: 根据用户组属性与分页信息分页查询用户组信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param userGroup 实体
	 * @return List<UserGroup>
	 */
	Map<String, Object> queryUserGroupForPage(Integer pagenum, Integer pagesize, String sort, UserGroup userGroup);
	 
	 /**
	 * @Title: queryUserGroupByProperty
	 * @Description:根据属性查询用户组
	 * @return List<UserGroup>
	 */
	 List<UserGroup> queryUserGroupByProperty(Map<String, Object> map);	 
	 
}
