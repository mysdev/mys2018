package com.jing.core.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.EmployeeCommission;

public interface EmployeeCommissionService {

	/**
	 * 添加 员工提成
	 */
	void addEmployeeCommission(EmployeeCommission employeeCommission);

	/**
	 * 修改 员工提成
	 */
	void updateEmployeeCommission(EmployeeCommission employeeCommission);

	/**
	 * 根据ID删除记录
	 */
	void deleteEmployeeCommissionById(Integer id);

	/**
	 * 根据ID查询记录
	 */
	EmployeeCommission getEmployeeCommissionById(Integer id);

	/**
	 * 分页查询
	 */
	PageInfo findEmployeeCommissionListPage(PageInfo page, Map<String, Object> param);

	/**
	 * 根据属性查询员工提成
	 * 
	 * @param param
	 * @return
	 */
	List<EmployeeCommission> findEmployeeCommissionList(Map<String, Object> param);
}