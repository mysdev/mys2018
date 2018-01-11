package com.jing.system.service;

import java.util.List;
import java.util.Map;


import com.jing.system.model.entity.User;

/**
 * @ClassName: User
 * @Description: 用户服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public interface UserService {

    /**
	 * @Title: addUser
	 * @Description:添加用户
	 * @param user 实体
	 * @return Integer
	 */
	User addUser(User user);
	
	/**
	 * @Title modifyUser
	 * @Description:修改用户
	 * @param user 实体
	 * @return Integer
	 */
	Integer modifyUser(User user);
	
	/**
	 * @Title: dropUserByUserId
	 * @Description:删除用户
	 * @param userId 实体标识
	 * @return Integer
	 */
	Integer dropUserByUserId(Integer userId);
	
	/**
	 * @Title: queryUserByUserId
	 * @Description:根据实体标识查询用户
	 * @param userId 实体标识
	 * @return User
	 */
	User queryUserByUserId(Integer userId);
	 
	/**
	 * @Title: queryUserForPage
	 * @Description: 根据用户属性与分页信息分页查询用户信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param user 实体
	 * @return List<User>
	 */
	Map<String, Object> queryUserForPage(Integer pagenum, Integer pagesize, String sort, User user);
	 
	 /**
	 * @Title: queryUserByProperty
	 * @Description:根据属性查询用户
	 * @return List<User>
	 */
	 List<User> queryUserByProperty(Map<String, Object> map);	 
	 
}
