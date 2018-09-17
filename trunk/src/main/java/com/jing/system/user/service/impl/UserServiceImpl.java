package com.jing.system.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.system.user.entity.User;
import com.jing.system.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Override
	public User addUser(User user, int deptCode) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(int userId, int deptCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findUserListPage(PageInfo page, Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByResourceId(int resId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetPassword(String username, String oldPassword, String password, int userId)
			throws CustomException {
		// TODO Auto-generated method stub
		
	}

}
