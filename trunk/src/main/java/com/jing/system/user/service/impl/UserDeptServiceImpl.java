package com.jing.system.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.system.user.dao.UserDeptDao;
import com.jing.system.user.entity.UserDept;
import com.jing.system.user.service.UserDeptService;
import com.jing.system.user.uitl.UserDeptMapper;

@Service("userDeptService")
public class UserDeptServiceImpl implements UserDeptService{

	@Resource
	private UserDeptDao userDeptDao;

	/**
	* 添加 用户部门
	*/
	@Override
	public void addUserDept(int userId,int deptCode){
		UserDept userDept = new UserDept(userId,deptCode);
		userDeptDao.addUserDept(userDept);
		UserDeptMapper.setValue(userDept);
	}
	
	/**
	* 修改 用户部门
	*/
	@Override
	public void updateUserDept(UserDept userDept){
		userDeptDao.updateUserDept(userDept);
		UserDeptMapper.setValue(userDept);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteUserDeptById(int userId,int deptCode){
		userDeptDao.deleteUserDeptById(userId,deptCode);
		UserDeptMapper.moveValue(userId, deptCode);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public UserDept getUserDeptById(Integer id){
		return userDeptDao.getUserDeptById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findUserDeptListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(userDeptDao.findUserDeptListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询用户部门
	 * @param param
	 * @return
	 */
	 @Override
	public List<UserDept> findUserDeptList(Map<String, Object> param){
		return userDeptDao.findUserDeptList(param);
	}
	
}