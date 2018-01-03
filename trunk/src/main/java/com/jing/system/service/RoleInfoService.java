package com.jing.system.service;

import java.util.List;
import java.util.Map;


import com.jing.system.model.entity.RoleInfo;

/**
 * @ClassName: RoleInfo
 * @Description: 角色服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
public interface RoleInfoService {

    /**
	 * @Title: addRoleInfo
	 * @Description:添加角色
	 * @param roleInfo 实体
	 * @return Integer
	 */
	RoleInfo addRoleInfo(RoleInfo roleInfo);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param roleInfo 实体
	 * @return List<RoleInfo>
	 */
	Map<String, Object> queryRoleInfoForPage(Integer pagenum, Integer pagesize, String sort, RoleInfo roleInfo);
	 
	 /**
	 * @Title: queryRoleInfoByProperty
	 * @Description:根据属性查询角色
	 * @return List<RoleInfo>
	 */
	 List<RoleInfo> queryRoleInfoByProperty(Map<String, Object> map);	 
	 
}
