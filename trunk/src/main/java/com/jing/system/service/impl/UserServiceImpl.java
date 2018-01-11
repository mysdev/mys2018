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


import com.jing.system.model.entity.User;
import com.jing.system.model.dao.UserMapper;
import com.jing.system.service.UserService;

/**
 * @ClassName: User
 * @Description: 用户服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("userService")
@Transactional(readOnly=true)
public class  UserServiceImpl implements UserService {	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
    private UserMapper userMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addUser
	 * @Description:添加用户
	 * @param user 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public User addUser(User user){
		int ret = userMapper.addUser(user);
		if(ret>0){
			return user;
		}
		return null;
	}
	
	/**
	 * @Title modifyUser
	 * @Description:修改用户
	 * @param user 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyUser(User user){
		return userMapper.modifyUser(user);
	}
	
	/**
	 * @Title: dropUserByUserId
	 * @Description:删除用户
	 * @param userId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropUserByUserId(Integer userId){
		return userMapper.dropUserByUserId(userId);
	}
	
	/**
	 * @Title: queryUserByUserId
	 * @Description:根据实体标识查询用户
	 * @param userId 实体标识
	 * @return User
	 */
	@Override
	public User queryUserByUserId(Integer userId){
		return userMapper.queryUserByUserId(userId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryUserForPage
	 * @Description: 根据用户属性与分页信息分页查询用户信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param user 实体
	 * @return List<User>
	 */
	@Override
	public Map<String, Object> queryUserForPage(Integer pagenum, Integer pagesize, String sort, User user){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, User.class);
		List<User> entityList = userMapper.queryUserForPage(pageBounds, user);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, User.class);
		}
		if (!entityList.isEmpty()) {
			PageList<User> pagelist = (PageList<User>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryUserByProperty
	 * @Description:根据属性查询用户
	 * @return List<User>
	 */
	@Override
	public List<User> queryUserByProperty(Map<String, Object> map){
		return userMapper.queryUserByProperty(map);
	}


}
