package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.EmployeeSpecial;

/**
 * @ClassName: EmployeeSpecialMapper
 * @Description: 员工特殊权限(扩)映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface EmployeeSpecialMapper {

	/**
	 * @Title: addEmployeeSpecial
	 * @Description:添加员工特殊权限(扩)
	 * @param employeeSpecial 实体
	 * @return Integer
	 */
	Integer addEmployeeSpecial(EmployeeSpecial employeeSpecial);
	
	/**
	 * @Title modifyEmployeeSpecial
	 * @Description:修改员工特殊权限(扩)
	 * @param employeeSpecial 实体
	 * @return Integer
	 */
	Integer modifyEmployeeSpecial(EmployeeSpecial employeeSpecial);
	
	/**
	 * @Title: dropEmployeeSpecialByEmpId
	 * @Description:删除员工特殊权限(扩)
	 * @param empId 实体标识
	 * @return Integer
	 */
	Integer dropEmployeeSpecialByEmpId(String empId);
	
	/**
	 * @Title: queryEmployeeSpecialByEmpId
	 * @Description:根据实体标识查询员工特殊权限(扩)
	 * @param empId 实体标识
	 * @return EmployeeSpecial
	 */
	EmployeeSpecial queryEmployeeSpecialByEmpId(String empId);
	 
	/**
	 * @Title: queryEmployeeSpecialForPage
	 * @Description: 根据员工特殊权限(扩)属性与分页信息分页查询员工特殊权限(扩)信息
	 * @param pageBounds 分页信息
	 * @param employeeSpecial 实体
	 * @return List<EmployeeSpecial>
	 */
	List<EmployeeSpecial> queryEmployeeSpecialForPage(PageBounds pageBounds, @Param("employeeSpecial") EmployeeSpecial employeeSpecial);
	 
	 /**
	  * @Title: queryEmployeeSpecialByProperty
	  * @Description:根据属性查询员工特殊权限(扩)
	  * @return List<EmployeeSpecial>
	  */
	 List<EmployeeSpecial> queryEmployeeSpecialByProperty(@Param("employeeSpecial") Map<String, Object> map);
	 
	 
	 
}
