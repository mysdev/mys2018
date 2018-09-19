package com.jing.system.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.system.dept.entity.Dept;
import com.jing.system.login.LoginService;
import com.jing.system.permission.service.UserRoleService;
import com.jing.system.user.dao.UserDao;
import com.jing.system.user.entity.User;
import com.jing.system.user.entity.UserDept;
import com.jing.system.user.service.UserDeptService;
import com.jing.system.user.service.UserService;
import com.jing.system.user.uitl.UserMapper;
import com.jing.utils.FrameworkUtils;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	@Autowired
	private UserDeptService userDeptService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private LoginService loginService;

	/**
	 * 添加 用户
	 * 
	 * @throws CustomException
	 */
	@Override
	@Transactional
	public User addUser(User user, int deptCode) throws CustomException {
		// 验证用户是否在同一个部门已经添加
		User db = UserMapper.getObj(user.getUsername());
		if (db == null) {
			if (user.getPassword() == null || "".equals(user.getPassword())) {
				user.setPassword(User.DEFAULT_PASSWORD);
			}
			this.addUser(user);
			userRoleService.grantRoleAll(user.getUserId());
			userDeptService.addUserDept(user.getUserId(), deptCode);
		} else {
			List<Dept> list = db.getDepts();
			if (list != null && list.size() > 0) {
				for (Dept dept : list) {
					if (dept.getDeptCode() == deptCode) {
						throw new CustomException("单位中已存在相同账号.");
					}
				}
			}
			userDeptService.addUserDept(db.getUserId(), deptCode);
			if(user.getStatus().intValue()==0){
				user.setStatus(1);
				this.updateUser(user);
			}
		}
		// 用户所在部门
		UserMapper.setValue(user);
		return user;
	}

	@Override
	public User getUserByUserName(String userName) {
		List<User> list = findUserList(FrameworkUtils.hashMap("userName", userName));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	public void addUser(User user){
		userDao.addUser(user);
		if(UserMapper.getObj(user.getUsername()) != null){
			throw new CustomException("账号重复.");
		}
		UserMapper.setValue(user);
	}
	

	/**
	 * 修改 用户
	 */
	@Override
	public void updateUser(User user) {
		//如果缓存中存在当前账户名，并且id ！= 当前id ，那么账号重复
		if(UserMapper.getObj(user.getUsername()) != null && UserMapper.getObj(user.getUsername()).getUserId().intValue() != user.getUserId().intValue()){
			throw new CustomException("账号重复.");
		}
		userDao.updateUser(user);
		UserMapper.setValue(user);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	@Transactional
	public void deleteUserById(int userId, int deptCode) {
		// userDao.deleteUserById(id);
		User user = UserMapper.getObj(userId);
		Map<String, Object> param = FrameworkUtils.hashMap("deptCode", deptCode);
		param.put("userName", user.getUsername());
		List<User> list = this.findUserList(param);
		if (list != null && list.size() > 0) {
			// 删除关系
			userDeptService.deleteUserDeptById(userId, deptCode);
		}
		// 如果所有关系都删除完了， 更改用户状态为已删除
		Map<String, Object> param2 = FrameworkUtils.hashMap("userId", userId);
		List<UserDept> dts = userDeptService.findUserDeptList(param2);
		if (dts == null || dts.size() == 0) {
			user.setStatus(0);
			this.updateUser(user);
		}
	}

	/**
	 * 根据ID查询记录
	 */
	@Override
	public User getUserById(int id) {
		User user = userDao.getUserById(id);
		UserMapper.setValue(user);
		return user;
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findUserListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(userDao.findUserListPage(page, param));
	}

	/**
	 * 根据属性查询用户
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<User> findUserList(Map<String, Object> param) {
		return userDao.findUserList(param);
	}

	@Override
	public List<User> findUserByResourceId(int resId) {
		return userDao.findUserByResourceId(resId);
	}

	@Override
	public List<User> findUserByRoleId(String roleId) {
		return userDao.findUserByRoleId(roleId);
	}

	@Override
	public void resetPassword(String username, String oldPassword, String password, int userId)
			throws CustomException {
		boolean ud = loginService.login(username, oldPassword);
		if (ud) {
			User user = new User();
			user.setPassword(password);
			user.setUserId(userId);
			userDao.updateUser(user);
		} else {
			throw new CustomException("原密码错误！");
		}

	}

}
