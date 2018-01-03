package com.jing.system.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.system.model.entity.RoleInfo;
import com.jing.system.model.dao.RoleInfoMapper;
import com.jing.system.service.RoleInfoService;

/**
 * @ClassName: RoleInfo
 * @Description: 角色服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
@Service("roleInfoService")
@Transactional(readOnly=true)
public class  RoleInfoServiceImpl implements RoleInfoService {

	@Autowired
    private RoleInfoMapper roleInfoMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addRoleInfo
	 * @Description:添加角色
	 * @param roleInfo 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public RoleInfo addRoleInfo(RoleInfo roleInfo){
		int ret = roleInfoMapper.addRoleInfo(roleInfo);
		if(ret>0){
			return roleInfo;
		}
		return null;
	}
	
	/**
	 * @Title modifyRoleInfo
	 * @Description:修改角色
	 * @param roleInfo 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyRoleInfo(RoleInfo roleInfo){
		return roleInfoMapper.modifyRoleInfo(roleInfo);
	}
	
	/**
	 * @Title: dropRoleInfoByRoleId
	 * @Description:删除角色
	 * @param roleId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropRoleInfoByRoleId(Integer roleId){
		return roleInfoMapper.dropRoleInfoByRoleId(roleId);
	}
	
	/**
	 * @Title: queryRoleInfoByRoleId
	 * @Description:根据实体标识查询角色
	 * @param roleId 实体标识
	 * @return RoleInfo
	 */
	@Override
	public RoleInfo queryRoleInfoByRoleId(Integer roleId){
		return roleInfoMapper.queryRoleInfoByRoleId(roleId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryRoleInfoForPage
	 * @Description: 根据角色属性与分页信息分页查询角色信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param roleInfo 实体
	 * @return List<RoleInfo>
	 */
	@Override
	public Map<String, Object> queryRoleInfoForPage(Integer pagenum, Integer pagesize, String sort, RoleInfo roleInfo){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, RoleInfo.class);
		List<RoleInfo> entityList = roleInfoMapper.queryRoleInfoForPage(pageBounds, roleInfo);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, RoleInfo.class);
		}
		if (!entityList.isEmpty()) {
			PageList<RoleInfo> pagelist = (PageList<RoleInfo>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryRoleInfoByProperty
	 * @Description:根据属性查询角色
	 * @return List<RoleInfo>
	 */
	@Override
	public List<RoleInfo> queryRoleInfoByProperty(Map<String, Object> map){
		return roleInfoMapper.queryRoleInfoByProperty(map);
	}


}
