package com.jing.system.login;

import java.util.List;

import com.jing.config.web.security.RoleDetail;
import com.jing.config.web.security.UserDetail;

public interface LoginService {

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws PbicBusinessException
	 */
	boolean login(String username, String password);

	/**
	 * 登录之后
	 * 
	 * @param username
	 * @param password
	 * @throws PbicBusinessException
	 */
	void afterLogin(String username, String password);

	/**
	 * 获取登录用户信息
	 * 
	 * @param name
	 * @return
	 * @throws PbicBusinessException
	 */
	UserDetail getUserDetailByName(String name);

	/**
	 * 通过用户名获取用户角色信息
	 * 
	 * @param userName
	 * @return
	 * @throws PbicBusinessException
	 */
	List<RoleDetail> getRolesByUserName(String userName);

	/**
	 * 通过地址获取对应的角色信息
	 * 
	 * @param url
	 * @return
	 * @throws PbicBusinessException
	 */
	List<RoleDetail> getRolesByResUrl(String url);

	/**
	 * 是否采用该认证
	 * 
	 * @return
	 */
	boolean isAuthen();

	/**
	 * 
	 * @param auth
	 */
	void setAuthen(boolean auth);
}
