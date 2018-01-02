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


import com.jing.system.model.entity.UserRole;
import com.jing.system.model.dao.UserRoleMapper;
import com.jing.system.service.UserRoleService;

/**
 * @ClassName: UserRole
 * @Description: 用户权限服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@Service("userRoleService")
@Transactional(readOnly=true)
public class  UserRoleServiceImpl implements UserRoleService {

	@Autowired
    private UserRoleMapper userRoleMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addUserRole
	 * @Description:添加用户权限
	 * @param userRole 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public UserRole addUserRole(UserRole userRole){
		int ret = userRoleMapper.addUserRole(userRole);
		if(ret>0){
			return userRole;
		}
		return null;
	}
	
	/**
	 * @Title modifyUserRole
	 * @Description:修改用户权限
	 * @param userRole 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyUserRole(UserRole userRole){
		return userRoleMapper.modifyUserRole(userRole);
	}
	
	/**
	 * @Title: dropUserRoleByUserId
	 * @Description:删除用户权限
	 * @param userId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropUserRoleByUserId(Integer userId){
		return userRoleMapper.dropUserRoleByUserId(userId);
	}
	
	/**
	 * @Title: queryUserRoleByUserId
	 * @Description:根据实体标识查询用户权限
	 * @param userId 实体标识
	 * @return UserRole
	 */
	@Override
	public UserRole queryUserRoleByUserId(Integer userId){
		return userRoleMapper.queryUserRoleByUserId(userId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryUserRoleForPage
	 * @Description: 根据用户权限属性与分页信息分页查询用户权限信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param userRole 实体
	 * @return List<UserRole>
	 */
	@Override
	public Map<String, Object> queryUserRoleForPage(Integer pagenum, Integer pagesize, String sort, UserRole userRole){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, UserRole.class);
		List<UserRole> entityList = userRoleMapper.queryUserRoleForPage(pageBounds, userRole);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, UserRole.class);
		}
		if (!entityList.isEmpty()) {
			PageList<UserRole> pagelist = (PageList<UserRole>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryUserRoleByProperty
	 * @Description:根据属性查询用户权限
	 * @return List<UserRole>
	 */
	@Override
	public List<UserRole> queryUserRoleByProperty(Map<String, Object> map){
		return userRoleMapper.queryUserRoleByProperty(map);
	}


}
