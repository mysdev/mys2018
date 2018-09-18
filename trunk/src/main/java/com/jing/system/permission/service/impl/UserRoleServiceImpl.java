package com.jing.system.permission.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.system.permission.dao.UserRoleDao;
import com.jing.system.permission.entity.UserRole;
import com.jing.system.permission.service.UserRoleService;
import com.jing.system.user.uitl.UserMapper;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	private final String ROLE_ALL = "ROLE0";

	@Resource
	private UserRoleDao userRoleDao;

	/**
	 * 添加 用户角色
	 */
	@Override
	public void addUserRole(UserRole userRole) {
		userRoleDao.addUserRole(userRole);
		UserMapper.setRoles(userRole.getUserId());
	}

	@Override
	public void grantRoleAll(int userId) {
		UserRole ur = new UserRole();
		ur.setRoleId(ROLE_ALL);
		ur.setUserId(userId);
		this.addUserRole(ur);
	}

	@Override
	public void gantRole(String roleId, int userId) {
		UserRole ur = new UserRole();
		ur.setRoleId(roleId);
		ur.setUserId(userId);
		this.addUserRole(ur);
	}

	/**
	 * 修改 用户角色
	 */
	@Override
	public void updateUserRole(UserRole userRole) {
		userRoleDao.updateUserRole(userRole);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	public void deleteUserRoleById(Integer userId) {
		userRoleDao.deleteUserRoleById(userId);
		UserMapper.setRoles(userId);
	}

	/**
	 * 根据ID查询记录
	 */
	@Override
	public UserRole getUserRoleById(Integer id) {
		return userRoleDao.getUserRoleById(id);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findUserRoleListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(userRoleDao.findUserRoleListPage(page, param));
	}

	/**
	 * 根据属性查询用户角色
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<UserRole> findUserRoleList(Map<String, Object> param) {
		return userRoleDao.findUserRoleList(param);
	}
	/**
	 * 根据用户ID和角色ID删除角色
	 */
	@Override
	public void deleteUserRoleByUserIdAndRoleId(int userId, String roleId,int deptCode) {
		userRoleDao.deleteUserRoleByUserIdAndRoleId(userId, roleId,deptCode);
		
	}

	
}