package com.jing.system.dept.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.system.dept.dao.DeptDao;
import com.jing.system.dept.entity.Dept;
import com.jing.system.dept.service.DeptService;
import com.jing.system.dept.util.DeptMapper;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptDao deptDao;

	/**
	 * 添加 部门
	 */
	@Override
	public void addDept(Dept dept) {
		deptDao.addDept(dept);
		DeptMapper.setValue(dept);
	}

	/**
	 * 修改 部门
	 */
	@Override
	public void updateDept(Dept dept) {
		deptDao.updateDept(dept);
		DeptMapper.setValue(dept);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	public void deleteDeptById(Integer id) {
		deptDao.deleteDeptById(id);
		DeptMapper.delObj(id);
	}

	/**
	 * 根据ID查询记录
	 */
	@Override
	public Dept getDeptById(Integer id) {
		Dept dept = DeptMapper.getObj(id);
		if (dept == null) {
			dept = deptDao.getDeptById(id);
			DeptMapper.setValue(dept);
		}
		return dept;
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findDeptListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(deptDao.findDeptListPage(page, param));
	}

	/**
	 * 根据属性查询部门
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<Dept> findDeptList(Map<String, Object> param) {
		return deptDao.findDeptList(param);
	}

	@Override
	public List<Dept> findDeptPermissionList(Map<String, Object> param) {
		return deptDao.findDeptPermissionList(param);
	}

	public String findDepNameById(Integer id) {
		return deptDao.findDeptName(id);
	}

	@Override
	public Dept findOrganizationByAreaAndName(String areaCode, String deptName) {
		return deptDao.findDeptByAreaAndName(areaCode, deptName);
	}

	@Override
	public Dept findDeptByRoleAndArea(String areaCode, String roleId) {
		return deptDao.findDeptByRoleAndArea(areaCode, roleId);
	}
}