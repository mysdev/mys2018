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


import com.jing.system.model.entity.UserGroup;
import com.jing.system.model.dao.UserGroupMapper;
import com.jing.system.service.UserGroupService;

/**
 * @ClassName: UserGroup
 * @Description: 用户组服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@Service("userGroupService")
@Transactional(readOnly=true)
public class  UserGroupServiceImpl implements UserGroupService {

	@Autowired
    private UserGroupMapper userGroupMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addUserGroup
	 * @Description:添加用户组
	 * @param userGroup 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public UserGroup addUserGroup(UserGroup userGroup){
		int ret = userGroupMapper.addUserGroup(userGroup);
		if(ret>0){
			return userGroup;
		}
		return null;
	}
	
	/**
	 * @Title modifyUserGroup
	 * @Description:修改用户组
	 * @param userGroup 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyUserGroup(UserGroup userGroup){
		return userGroupMapper.modifyUserGroup(userGroup);
	}
	
	/**
	 * @Title: dropUserGroupByTeamId
	 * @Description:删除用户组
	 * @param teamId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropUserGroupByTeamId(Integer teamId){
		return userGroupMapper.dropUserGroupByTeamId(teamId);
	}
	
	/**
	 * @Title: queryUserGroupByTeamId
	 * @Description:根据实体标识查询用户组
	 * @param teamId 实体标识
	 * @return UserGroup
	 */
	@Override
	public UserGroup queryUserGroupByTeamId(Integer teamId){
		return userGroupMapper.queryUserGroupByTeamId(teamId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryUserGroupForPage
	 * @Description: 根据用户组属性与分页信息分页查询用户组信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param userGroup 实体
	 * @return List<UserGroup>
	 */
	@Override
	public Map<String, Object> queryUserGroupForPage(Integer pagenum, Integer pagesize, String sort, UserGroup userGroup){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, UserGroup.class);
		List<UserGroup> entityList = userGroupMapper.queryUserGroupForPage(pageBounds, userGroup);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, UserGroup.class);
		}
		if (!entityList.isEmpty()) {
			PageList<UserGroup> pagelist = (PageList<UserGroup>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryUserGroupByProperty
	 * @Description:根据属性查询用户组
	 * @return List<UserGroup>
	 */
	@Override
	public List<UserGroup> queryUserGroupByProperty(Map<String, Object> map){
		return userGroupMapper.queryUserGroupByProperty(map);
	}


}
