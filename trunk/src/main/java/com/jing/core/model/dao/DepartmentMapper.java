package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.Department;

/**
 * @ClassName: DepartmentMapper
 * @Description: 部门映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface DepartmentMapper {

	/**
	 * @Title: addDepartment
	 * @Description:添加部门
	 * @param department 实体
	 * @return Integer
	 */
	Integer addDepartment(Department department);
	
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
	 * @param pageBounds 分页信息
	 * @param department 实体
	 * @return List<Department>
	 */
	List<Department> queryDepartmentForPage(PageBounds pageBounds, @Param("department") Department department);
	 
	 /**
	  * @Title: queryDepartmentByProperty
	  * @Description:根据属性查询部门
	  * @return List<Department>
	  */
	 List<Department> queryDepartmentByProperty(@Param("department") Map<String, Object> map);
	 
	 
	 
}
