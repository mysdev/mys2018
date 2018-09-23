package com.jing.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.dao.EmployeeCommissionMapper;
import com.jing.core.model.entity.EmployeeCommission;
import com.jing.core.service.EmployeeCommissionService;

@Service("employeeCommissionService")
public class EmployeeCommissionServiceImpl implements EmployeeCommissionService {

	@Resource
	private EmployeeCommissionMapper employeeCommissionMapper;

	/**
	 * 添加 员工提成
	 */
	@Override
	public void addEmployeeCommission(EmployeeCommission employeeCommission) {
		employeeCommissionMapper.addEmployeeCommission(employeeCommission);
	}

	/**
	 * 修改 员工提成
	 */
	@Override
	public void updateEmployeeCommission(EmployeeCommission employeeCommission) {
		employeeCommissionMapper.updateEmployeeCommission(employeeCommission);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	public void deleteEmployeeCommissionById(Integer id) {
		employeeCommissionMapper.deleteEmployeeCommissionById(id);
	}

	/**
	 * 根据ID查询记录
	 */
	@Override
	public EmployeeCommission getEmployeeCommissionById(Integer id) {
		return employeeCommissionMapper.getEmployeeCommissionById(id);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findEmployeeCommissionListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(employeeCommissionMapper.findEmployeeCommissionListPage(page, param));
	}

	/**
	 * 根据属性查询员工提成
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<EmployeeCommission> findEmployeeCommissionList(Map<String, Object> param) {
		return employeeCommissionMapper.findEmployeeCommissionList(param);
	}

}