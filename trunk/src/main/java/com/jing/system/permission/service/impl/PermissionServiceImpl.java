package com.jing.system.permission.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.config.web.page.PageInfo;
import com.jing.system.permission.dao.PermissionDao;
import com.jing.system.permission.entity.Permission;
import com.jing.system.permission.entity.Resources;
import com.jing.system.permission.service.PermissionService;
import com.jing.system.user.entity.User;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Resource
	private PermissionDao permissionDao;
	
	/**
	 * 添加 权限
	 */
	@Override
	public void addPermission(Permission permission) {
		permissionDao.addPermission(permission);
	}

	/**
	 * 修改 权限
	 */
	@Override
	public void updatePermission(Permission permission) {
		permissionDao.updatePermission(permission);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	public void deletePermssionByRoleId(String id) {
		permissionDao.deletePermssionByRoleId(id);
	}

	/**
	 * 根据ID查询记录
	 */
	@Override
	public List<Permission> getPermissionById(String id) {
		return permissionDao.getPermissionById(id);
	}
	
 

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findPermissionListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(permissionDao.findPermissionListPage(page, param));
	}

	/**
	 * 根据属性查询权限
	 * 
	 * @param param
	 * @return
	 */
	@Override
	@Transactional
	public void addPermission(String roleId, String resId) {
		permissionDao.deletePermssionByRoleId(roleId);
		// 查出原有的角色数据
		// List<Permission> listOld = permissionDao.getPermissionById(roleId);
		String[] resIds = resId.split(",");
		List<Permission> listNew = new ArrayList<>();
		for (int i = 0; i < resIds.length; i++) {
			Permission permission = new Permission();
			permission.setRoleId(roleId);
			permission.setResId(Integer.parseInt(resIds[i]));
			// 经过页面修改后的角色数据
			listNew.add(permission);
		}
		permissionDao.batchAddPermission(listNew);
		/*
		// set去除重复数据
		Set<Permission> set = new HashSet<Permission>();
		set.addAll(listOld);
		set.addAll(listNew);
		// 该角色权限全部删除
		listOld.removeAll(listNew);
		for (Permission in : listOld) {
			permissionDao.deletePermssionByRoleIdAndResId(in.getRoleId(), in.getResId());
		}
		// 新增该角色权限
		set.removeAll(listOld);
		if (!resId.equals("0")) {
			for (Permission in : listNew) {
				permissionDao.addPermission(in);
			}
		}
		*/
	}

	/**
	 * 根据角色id和权限id删除权限
	 * 
	 * @param roleId
	 * @param resid
	 */
	@Override
	public void deletePermssionByRoleIdAndResId(String roleId, int resId) {
		permissionDao.deletePermssionByRoleIdAndResId(roleId, resId);
	}

	@Override
	public boolean hasPermission(User user, int resId) {
		return false;
	}

	@Override
	public List<Resources> findActions(User user, int parentId, String pageButtonKey) {
		return permissionDao.findActions(user.getUserId(), parentId, pageButtonKey);
	}

	@Override
	public List<Resources> findMyMenus(int userId) {
		return permissionDao.findMyMenus(userId);
	}
}