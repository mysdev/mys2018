package com.jing.system.dept.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.system.dept.dao.DeptStaffDao;
import com.jing.system.dept.entity.DeptStaff;
import com.jing.system.dept.service.DeptStaffService;

@Service("deptStaffService")
public class DeptStaffServiceImpl implements DeptStaffService{

	@Resource
	private DeptStaffDao deptStaffDao;
	/**
	* 添加 部门职工
	*/
	@Override
	public void addDeptStaff(DeptStaff deptStaff){
		deptStaffDao.addDeptStaff(deptStaff);
	}
	
	/**
	* 修改 部门职工
	*/
	@Override
	public void updateDeptStaff(DeptStaff deptStaff){
		deptStaffDao.updateDeptStaff(deptStaff);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteDeptStaffById(Integer id){
		deptStaffDao.deleteDeptStaffById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public DeptStaff getDeptStaffById(Integer id){
		DeptStaff deptStaff=deptStaffDao.getDeptStaffById(id);	
		return deptStaff;
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findDeptStaffListPage(PageInfo page, Map<String, Object> param){
		List<DeptStaff> list=deptStaffDao.findDeptStaffListPage(page,param);
		return page.setRows(list);
	}
	
	
	/**
	 * 根据属性查询部门职工
	 * @param param
	 * @return
	 */
	 @Override
	public List<DeptStaff> findDeptStaffList(Map<String, Object> param){
		return deptStaffDao.findDeptStaffList(param);
	}
	
}