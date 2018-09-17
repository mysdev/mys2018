package com.jing.system.dept.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.dept.entity.DeptStaff;

@Mapper
public interface DeptStaffDao {

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
	List<DeptStaff> findDeptStaffListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询部门职工
	 * @param param
	 * @return
	 */
	List<DeptStaff> findDeptStaffList(@Param("param") Map<String, Object> param);	
}