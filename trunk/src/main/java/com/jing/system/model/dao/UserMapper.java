package com.jing.system.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.system.model.entity.User;

/**
 * @ClassName: UserMapper
 * @Description: 用户映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Mapper
public interface UserMapper {

	/**
	 * @Title: addUser
	 * @Description:添加用户
	 * @param user
	 *            实体
	 * @return Integer
	 */
	Integer addUser(User user);

	/**
	 * @Title modifyUser
	 * @Description:修改用户
	 * @param user
	 *            实体
	 * @return Integer
	 */
	Integer modifyUser(User user);

	/**
	 * @Title: dropUserByUserId
	 * @Description:删除用户
	 * @param userId
	 *            实体标识
	 * @return Integer
	 */
	Integer dropUserByUserId(Integer userId);

	/**
	 * @Title: queryUserByUserId
	 * @Description:根据实体标识查询用户
	 * @param userId
	 *            实体标识
	 * @return User
	 */
	User queryUserByUserId(Integer userId);

	/**
	 * @Title: queryUserForPage
	 * @Description: 根据用户属性与分页信息分页查询用户信息
	 * @param pageBounds
	 *            分页信息
	 * @param user
	 *            实体
	 * @return List<User>
	 */
	List<User> queryUserForPage(PageBounds pageBounds, @Param("user") User user);

	/**
	 * @Title: queryUserByProperty
	 * @Description:根据属性查询用户
	 * @return List<User>
	 */
	List<User> queryUserByProperty(@Param("user") Map<String, Object> map);

	/**
	 * 登录
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	User userLogin(User user);

	/**
	 * @Title: queryUserByUsername
	 * @Description:根据账户查询用户
	 * @param userId
	 *            实体标识
	 * @return User
	 */
	User queryUserByUsername(String userName);

}
