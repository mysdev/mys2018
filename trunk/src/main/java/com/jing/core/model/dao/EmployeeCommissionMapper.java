package com.jing.core.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.EmployeeCommission;

@Mapper
public interface EmployeeCommissionMapper {

	/**
	* 添加 员工提成
	*/
	void addEmployeeCommission(EmployeeCommission employeeCommission);
	
	/**
	* 修改 员工提成
	*/
	void updateEmployeeCommission(EmployeeCommission employeeCommission);
	
	/**
	*根据ID删除记录
	*/
	void deleteEmployeeCommissionById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	EmployeeCommission getEmployeeCommissionById(Integer id);
	
	/**
	* 分页查询
	*/
	List<EmployeeCommission> findEmployeeCommissionListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询员工提成
	 * @param param
	 * @return
	 */
	List<EmployeeCommission> findEmployeeCommissionList(@Param("param") Map<String, Object> param);	
}