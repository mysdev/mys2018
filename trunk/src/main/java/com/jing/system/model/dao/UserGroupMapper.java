package com.jing.system.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.system.model.entity.UserGroup;

/**
 * @ClassName: UserGroupMapper
 * @Description: 用户组映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@Mapper
public interface UserGroupMapper {

	/**
	 * @Title: addUserGroup
	 * @Description:添加用户组
	 * @param userGroup 实体
	 * @return Integer
	 */
	Integer addUserGroup(UserGroup userGroup);
	
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
	 * @param pageBounds 分页信息
	 * @param userGroup 实体
	 * @return List<UserGroup>
	 */
	List<UserGroup> queryUserGroupForPage(PageBounds pageBounds, @Param("userGroup") UserGroup userGroup);
	 
	 /**
	  * @Title: queryUserGroupByProperty
	  * @Description:根据属性查询用户组
	  * @return List<UserGroup>
	  */
	 List<UserGroup> queryUserGroupByProperty(@Param("userGroup") Map<String, Object> map);
	 
	 /**
	 * @Title: clearTableData
	 * @Description: 清空表信息
	 * @return 
	 */
	 void clearTableData();
	 
	 
}
