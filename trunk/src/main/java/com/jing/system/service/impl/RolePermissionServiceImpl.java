package com.jing.system.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.system.model.entity.RolePermission;
import com.jing.system.model.dao.RolePermissionMapper;
import com.jing.system.service.RolePermissionService;

/**
 * @ClassName: RolePermission
 * @Description: 角色权限服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("rolePermissionService")
@Transactional(readOnly=true)
public class  RolePermissionServiceImpl implements RolePermissionService {	
	private static final Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);
	
	@Autowired
    private RolePermissionMapper rolePermissionMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addRolePermission
	 * @Description:添加角色权限
	 * @param rolePermission 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public RolePermission addRolePermission(RolePermission rolePermission){
		int ret = rolePermissionMapper.addRolePermission(rolePermission);
		if(ret>0){
			return rolePermission;
		}
		return null;
	}
	
	/**
	 * @Title modifyRolePermission
	 * @Description:修改角色权限
	 * @param rolePermission 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyRolePermission(RolePermission rolePermission){
		return rolePermissionMapper.modifyRolePermission(rolePermission);
	}
	
	/**
	 * @Title: dropRolePermissionByRoleId
	 * @Description:删除角色权限
	 * @param roleId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropRolePermissionByRoleId(Integer roleId){
		return rolePermissionMapper.dropRolePermissionByRoleId(roleId);
	}
	
	/**
	 * @Title: queryRolePermissionByRoleId
	 * @Description:根据实体标识查询角色权限
	 * @param roleId 实体标识
	 * @return RolePermission
	 */
	@Override
	public RolePermission queryRolePermissionByRoleId(Integer roleId){
		return rolePermissionMapper.queryRolePermissionByRoleId(roleId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryRolePermissionForPage
	 * @Description: 根据角色权限属性与分页信息分页查询角色权限信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param rolePermission 实体
	 * @return List<RolePermission>
	 */
	@Override
	public Map<String, Object> queryRolePermissionForPage(Integer pagenum, Integer pagesize, String sort, RolePermission rolePermission){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, RolePermission.class);
		List<RolePermission> entityList = rolePermissionMapper.queryRolePermissionForPage(pageBounds, rolePermission);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, RolePermission.class);
		}
		if (!entityList.isEmpty()) {
			PageList<RolePermission> pagelist = (PageList<RolePermission>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryRolePermissionByProperty
	 * @Description:根据属性查询角色权限
	 * @return List<RolePermission>
	 */
	@Override
	public List<RolePermission> queryRolePermissionByProperty(Map<String, Object> map){
		return rolePermissionMapper.queryRolePermissionByProperty(map);
	}


	@Override
	public boolean havePermission(String url, String method, String userName) {
		// TODO Auto-generated method stub
		return false;
	}
}
