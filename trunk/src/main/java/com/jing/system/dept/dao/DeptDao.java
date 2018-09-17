package com.jing.system.dept.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.dept.entity.Dept;

@Mapper
public interface DeptDao {

	/**
	* 添加 部门
	*/
	void addDept(Dept dept);
	
	/**
	* 修改 部门
	*/
	void updateDept(Dept dept);
	
	/**
	*根据ID删除记录
	*/
	void deleteDeptById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	Dept getDeptById(Integer id);
	
	/**
	* 分页查询
	*/
	List<Dept> findDeptListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询部门
	 * @param param
	 * @return
	 */
	List<Dept> findDeptList(@Param("param") Map<String, Object> param);
	
	/**
     * 根据属性查询部门-权限
     * @param param
     * @return
     */
    List<Dept> findDeptPermissionList(@Param("param") Map<String, Object> param);
	
	/**
	 * 根据id查询部门名称
	 * @param id
	 * @return
	 */
	String findDeptName(Integer id);
	
	/**
	 * 根据区域和名称找单位
	 * @param areaCode
	 * @param deptName
	 * @return
	 */
	Dept findDeptByAreaAndName(@Param("areaCode") String areaCode, @Param("deptName")String deptName);
	
	/**
	 * 根据区域和角色找单位
	 * @param areaCode
	 * @param deptName
	 * @return
	 */
	Dept findDeptByRoleAndArea(@Param("areaCode") String areaCode, @Param("roleId")String roleId);
}