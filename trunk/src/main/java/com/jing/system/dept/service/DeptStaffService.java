package com.jing.system.dept.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.system.dept.entity.DeptStaff;

public interface DeptStaffService {

	/**
	* 添加 部门职工
	*/
	void addDeptStaff(DeptStaff deptStaff);
	
	/**
	* 修改 部门职工
	*/
	void updateDeptStaff(DeptStaff deptStaff);
	
	/**
	*根据ID删除记录
	*/
	void deleteDeptStaffById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	DeptStaff getDeptStaffById(Integer id);
	
	/**
	* 分页查询
	*/
	PageInfo findDeptStaffListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询部门职工
	 * @param param
	 * @return
	 */
	List<DeptStaff> findDeptStaffList(Map<String, Object> param);
}