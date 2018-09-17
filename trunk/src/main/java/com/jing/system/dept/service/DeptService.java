package com.jing.system.dept.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.system.dept.entity.Dept;

public interface DeptService {

	/**
	 * 添加 部门
	 */
	void addDept(Dept dept);

	/**
	 * 修改 部门
	 */
	void updateDept(Dept dept);

	/**
	 * 根据ID删除记录
	 */
	void deleteDeptById(Integer id);

	/**
	 * 根据ID查询记录
	 */
	Dept getDeptById(Integer id);

	/**
	 * 分页查询
	 */
	PageInfo findDeptListPage(PageInfo page, Map<String, Object> param);

	/**
	 * 根据属性查询部门
	 * 
	 * @param param
	 * @return
	 */
	List<Dept> findDeptList(Map<String, Object> param);
	
	/**
     * 根据属性查询部门
     * 
     * @param param
     * @return
     */
    List<Dept> findDeptPermissionList(Map<String, Object> param);

	/**
	 * 根据id查询单位名
	 * 
	 * @param id
	 * @return
	 */
	String findDepNameById(Integer id);
	
	/**
	 * 根据区划ID查询管辖单位
	 */
	Dept findOrganizationByAreaAndName(String areaCode,String deptName);
	
	/**
	 * 根据区域和角色找单位
	 * @param areaCode
	 * @param deptName
	 * @return
	 */
	Dept findDeptByRoleAndArea(String areaCode,String roleId);
}