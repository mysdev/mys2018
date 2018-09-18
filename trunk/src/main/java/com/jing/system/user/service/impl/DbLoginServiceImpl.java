package com.jing.system.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.config.web.security.SecurityRoleDetail;
import com.jing.config.web.security.SecurityUserDetail;
import com.jing.system.login.LoginService;
import com.jing.system.permission.entity.Role;
import com.jing.system.permission.service.RoleService;
import com.jing.system.permission.service.UserRoleService;
import com.jing.system.user.dao.DbLoginDao;
import com.jing.system.user.entity.User;
import com.jing.system.user.uitl.UserMapper;
import com.jing.utils.CustomizedDES;
import com.jing.utils.FrameworkUtils;

@Service("loginService")
public class DbLoginServiceImpl implements LoginService {
	@Autowired
	private RoleService roleService;
	@Resource
	private DbLoginDao dbLoginDao;
	@Autowired
	private UserRoleService userRoleService;

	@Override
	public boolean login(String username, String password) {
		User user = dbLoginDao.login(username, CustomizedDES.getEncodeText(password));
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void afterLogin(String username, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public SecurityUserDetail getUserDetailByName(String name) {
		User ud = UserMapper.getObj(name);
		if(ud==null){
			ud = dbLoginDao.getUserDetailByName(name);
		}
		ud.setUserRoles(userRoleService.findUserRoleList(FrameworkUtils.hashMap("userId", ud.getUserId())));
		return ud;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Role> getRolesByUserName(String userName) {
		User user = UserMapper.getObj(userName);
		List list = roleService.findRoleListByUserId(user.getUserId());
		user.setUserRole(list);
		return list;
	}

	@Override
	public List<SecurityRoleDetail> getRolesByResUrl(String url) {
		return roleService.findRolesByResUrl(url);
	}

	@Override
	public boolean isAuthen() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setAuthen(boolean auth) {
		// TODO Auto-generated method stub

	}

}
