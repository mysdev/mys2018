package com.jing.system.permission.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.config.web.security.SecurityRoleDetail;
import com.jing.system.permission.dao.RoleDao;
import com.jing.system.permission.entity.Role;
import com.jing.system.permission.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	/**
	 * 添加 角色
	 */
	@Override
	public void addRole(Role role) {
		roleDao.addRole(role);
	}

	/**
	 * 修改 角色
	 */
	@Override
	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	public void deleteRoleById(String id) {
		roleDao.deleteRoleById(id);
	}

	/**
	 * 根据ID查询记录
	 */
	@Override
	public Role getRoleById(String id) {
		return roleDao.getRoleById(id);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findRoleListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(roleDao.findRoleListPage(page, param));
	}

	/**
	 * 根据属性查询角色
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<Role> findRoleList(Map<String, Object> param) {
		return roleDao.findRoleList(param);
	}

	@Override
	public List<Role> findRoleListByUserId(int userId) {
		return roleDao.findRoleListByUserId(userId);
	}
	
	@Override
	public List<SecurityRoleDetail> findRolesByResUrl(String url) {
		return roleDao.findRolesByResUrl(url);
	}
	
	@Override
	public List<Role> findRoleListAll(Integer userId) {
		List<Role> list=roleDao.findRoleLisRemoveRole0tByUserId(userId);
		for(Role role:list){
			if("ROLE3".equals(role.getRoleId())){
				List<Role> rolelist=roleDao.findRolesByAll(role.getRoleId());
				list.addAll(rolelist);
				break;
			}else if("ROLE4".equals(role.getRoleId())){
				List<Role> rolelist=roleDao.findRolesByAll(role.getRoleId());
				list.addAll(rolelist);
				break;
			}else {
				List<Role> rolelist=roleDao.findRolesByAll(role.getRoleId());
				list.addAll(rolelist);
				break;
		}
		}
		return list;
	}
		
	
	
	/*@Override
	public List<Role> findRoleListAll(Integer userId) {
		List<Role> list=roleDao.findRoleListByUserId(userId);
		List<Role> child=new  ArrayList<Role>();
		for(Role role:list){
			String roleId=role.getRoleId();
			child.addAll(findChildRole(roleId));
		}
		list.addAll(child);
		return list;
	}*/
	
	/*private List<Role> findChildRole(String roleId){
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("parentRole",roleId);
		List<Role> roleList=roleDao.findRoleList(param);
		for(Role role:roleList){
			String childPid=role.getParentRole();
			if(childPid!=null){
				roleList.addAll(findChildRole(childPid));
			}
		}
		
		return roleList;
	}*/




	@Override
	public List<Role> selectRoleByDeptCode(int deptCode) {
		return roleDao.selectRoleByDeptCode(deptCode);
	}

}
