package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.Department;

/**
 * @ClassName: Department
 * @Description: 部门服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface DepartmentService {

    /**
	 * @Title: addDepartment
	 * @Description:添加部门
	 * @param department 实体
	 * @return Integer
	 */
	Department addDepartment(Department department);
	
	/**
	 * @Title modifyDepartment
	 * @Description:修改部门
	 * @param department 实体
	 * @return Integer
	 */
	Integer modifyDepartment(Department department);
	
	/**
	 * @Title: dropDepartmentByDptId
	 * @Description:删除部门
	 * @param dptId 实体标识
	 * @return Integer
	 */
	Integer dropDepartmentByDptId(Integer dptId);
	
	/**
	 * @Title: queryDepartmentByDptId
	 * @Description:根据实体标识查询部门
	 * @param dptId 实体标识
	 * @return Department
	 */
	Department queryDepartmentByDptId(Integer dptId);
	 
	/**
	 * @Title: queryDepartmentForPage
	 * @Description: 根据部门属性与分页信息分页查询部门信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param department 实体
	 * @return List<Department>
	 */
	Map<String, Object> queryDepartmentForPage(Integer pagenum, Integer pagesize, String sort, Department department);
	 
	 /**
	 * @Title: queryDepartmentByProperty
	 * @Description:根据属性查询部门
	 * @return List<Department>
	 */
	 List<Department> queryDepartmentByProperty(Map<String, Object> map);	 
	 
}
