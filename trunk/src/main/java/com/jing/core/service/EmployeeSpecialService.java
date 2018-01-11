package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.EmployeeSpecial;

/**
 * @ClassName: EmployeeSpecial
 * @Description: 员工特殊权限(扩)服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface EmployeeSpecialService {

    /**
	 * @Title: addEmployeeSpecial
	 * @Description:添加员工特殊权限(扩)
	 * @param employeeSpecial 实体
	 * @return Integer
	 */
	EmployeeSpecial addEmployeeSpecial(EmployeeSpecial employeeSpecial);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param employeeSpecial 实体
	 * @return List<EmployeeSpecial>
	 */
	Map<String, Object> queryEmployeeSpecialForPage(Integer pagenum, Integer pagesize, String sort, EmployeeSpecial employeeSpecial);
	 
	 /**
	 * @Title: queryEmployeeSpecialByProperty
	 * @Description:根据属性查询员工特殊权限(扩)
	 * @return List<EmployeeSpecial>
	 */
	 List<EmployeeSpecial> queryEmployeeSpecialByProperty(Map<String, Object> map);	 
	 
}
