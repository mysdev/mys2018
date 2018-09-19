package com.jing.system.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.security.SecurityRoleDetail;
import com.jing.system.dept.util.DeptMapper;
import com.jing.system.permission.entity.Role;
import com.jing.system.permission.entity.UserRole;
import com.jing.system.permission.service.RoleService;
import com.jing.system.permission.service.UserRoleService;
import com.jing.system.user.dao.UserDetailDao;
import com.jing.system.user.entity.User;
import com.jing.system.user.entity.UserDept;
import com.jing.system.user.entity.UserDetail;
import com.jing.system.user.service.UserDetailService;
import com.jing.system.user.service.UserService;
import com.jing.system.user.uitl.UserDeptMapper;
import com.jing.system.user.uitl.UserMapper;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService {

	@Resource
	private UserDetailDao userDetailDao;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleService roleService;

	@Override
	@Transactional
	public void addFullUser(UserDetail userDetail, String roleId) throws CustomException {
		List<SecurityRoleDetail> roles = new ArrayList<SecurityRoleDetail>();
		if(roleId!=null && !"".equals(roleId)){
			roles.add(roleService.getRoleById(roleId));
			userDetail.setUserRole(roles);
		}
		User user = UserMapper.getObj(userDetail.getUsername());
		if (user != null) {
			user.setUserRole(roles);
			if (user.getStatus().intValue() != 1) {
				throw new CustomException("用户名重复.");
			} else {
				user.setStatus(1);
				userService.updateUser(user);
			}
			userDetail.setUserId(user.getUserId());
		}else{
			userService.addUser(userDetail, userDetail.getDeptCode());
		}
		UserDetail ud = this.getUserDetailByIdSimple(userDetail.getUserId());
		if (ud != null) {
			this.updateUserDetail(userDetail);
		} else {
			this.addUserDetail(userDetail);
		}
		if(roleId!=null && !"".equals(roleId)){
			UserRole userRole = new UserRole(userDetail.getUserId(), roleId, userDetail.getDeptCode());
			userRoleService.addUserRole(userRole);
		}
	}

	/**
	 * 添加 用户详情
	 */
	@Override
	public void addUserDetail(UserDetail userDetail) {
		userDetailDao.addUserDetail(userDetail);
	}

	/**
	 * 修改 用户详情
	 */
	@Override
	public void updateUserDetail(UserDetail userDetail) {
		userDetailDao.updateUserDetail(userDetail);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	public void deleteUserDetailById(Integer id) {
		userDetailDao.deleteUserDetailById(id);
	}

	/**
	 * 根据ID查询记录 连表
	 */
	@Override
	public UserDetail getUserDetailById(Integer id) {
		return userDetailDao.getUserDetailById(id);
	}


	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findUserDetailListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(userDetailDao.findUserDetailListPage(page, param));
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findGridUserDetailListPage(PageInfo page, Map<String, Object> param) {
		List<UserDetail> list = userDetailDao.findGridUserDetailListPage(page, param);
		if (list != null && list.size() > 0) {
			for (UserDetail userDetail : list) {
				List<UserDept> depts = UserDeptMapper.getObj(userDetail.getUserId());
				if (depts != null) {
					StringBuffer sbf = new StringBuffer();
					for (UserDept userDept : depts) {
						if (sbf.length() > 0) {
							sbf.append(" | ");
						}
						sbf.append(DeptMapper.getValue(userDept.getDeptCode()));
					}
					userDetail.setDeptName(sbf.toString());
				}
				List<Role> roles = UserMapper.getObj(userDetail.getUserId()).getUserRole();
				if (roles != null && roles.size() > 0) {
					StringBuffer sbf = new StringBuffer();
					for (Role role : roles) {
						if (sbf.length() > 0) {
							sbf.append(" | ");
						}
						sbf.append(role.getRoleTitle());
					}
					userDetail.setRoleName(sbf.toString());
				}
			}

		}

		return page.setRows(list);
		// return page.setRows(userDetailDao.findGridUserDetailListPage(page,
		// param));
	}

	/**
	 * 根据属性查询用户详情
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<UserDetail> findUserDetailList(Map<String, Object> param) {
		return userDetailDao.findUserDetailList(param);
	}

	@Override
	public List<UserDetail> findUserListComplex(Map<String, Object> param) {
		List<UserDetail> list = userDetailDao.findUserListComplex(param);
		if (list != null && list.size() > 0) {
			for (UserDetail userDetail : list) {
				if (userDetail.getUserId().intValue() == 816) {
					System.out.println(userDetail.getUserId() + "->" + userDetail.getUsername());
				}
				System.out.println(userDetail.getUserId() + "->" + userDetail.getUsername());
				List<UserDept> depts = UserDeptMapper.getObj(userDetail.getUserId());
				if (depts != null) {
					StringBuffer sbf = new StringBuffer();
					for (UserDept userDept : depts) {
						if (sbf.length() > 0) {
							sbf.append(" | ");
						}
						sbf.append(DeptMapper.getValue(userDept.getDeptCode()));
					}
					userDetail.setDeptName(sbf.toString());
				}
				List<Role> roles = UserMapper.getObj(userDetail.getUserId()).getUserRole();
				if (roles != null && roles.size() > 0) {
					StringBuffer sbf = new StringBuffer();
					for (Role role : roles) {
						if (sbf.length() > 0) {
							sbf.append(" | ");
						}
						sbf.append(role.getRoleTitle());
					}
					userDetail.setRoleName(sbf.toString());
				}
			}

		}
		return list;
	}

	/**
	 * 根据ID查询用户详情单表
	 */
	@Override
	public UserDetail getUserDetailByIdSimple(Integer id) {
		return userDetailDao.getUserDetailByIdSimple(id);
	}

}