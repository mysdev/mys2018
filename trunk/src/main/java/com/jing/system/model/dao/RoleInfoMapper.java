package com.jing.system.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.system.model.entity.RoleInfo;

/**
 * @ClassName: RoleInfoMapper
 * @Description: 角色映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Mapper
public interface RoleInfoMapper {

	/**
	 * @Title: addRoleInfo
	 * @Description:添加角色
	 * @param roleInfo 实体
	 * @return Integer
	 */
	Integer addRoleInfo(RoleInfo roleInfo);
	
	/**
	 * @Title modifyRoleInfo
	 * @Description:修改角色
	 * @param roleInfo 实体
	 * @return Integer
	 */
	Integer modifyRoleInfo(RoleInfo roleInfo);
	
	/**
	 * @Title: dropRoleInfoByRoleId
	 * @Description:删除角色
	 * @param roleId 实体标识
	 * @return Integer
	 */
	Integer dropRoleInfoByRoleId(Integer roleId);
	
	/**
	 * @Title: queryRoleInfoByRoleId
	 * @Description:根据实体标识查询角色
	 * @param roleId 实体标识
	 * @return RoleInfo
	 */
	RoleInfo queryRoleInfoByRoleId(Integer roleId);
	 
	/**
	 * @Title: queryRoleInfoForPage
	 * @Description: 根据角色属性与分页信息分页查询角色信息
	 * @param pageBounds 分页信息
	 * @param roleInfo 实体
	 * @return List<RoleInfo>
	 */
	List<RoleInfo> queryRoleInfoForPage(PageBounds pageBounds, @Param("roleInfo") RoleInfo roleInfo);
	 
	 /**
	  * @Title: queryRoleInfoByProperty
	  * @Description:根据属性查询角色
	  * @return List<RoleInfo>
	  */
	 List<RoleInfo> queryRoleInfoByProperty(@Param("roleInfo") Map<String, Object> map);
	 
	 
	 
}
