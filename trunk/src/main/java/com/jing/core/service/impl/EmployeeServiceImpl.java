package com.jing.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.core.model.dao.EmployeeMapper;
import com.jing.core.model.entity.Employee;
import com.jing.core.service.EmployeeService;
import com.jing.system.user.entity.User;
import com.jing.system.user.service.UserService;
import com.jing.utils.PrimaryKey;

/**
 * @ClassName: Employee
 * @Description: 员工服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("employeeService")
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeMapper employeeMapper;
	@Autowired
	private UserService userService;

	/**
	 * 添加 员工
	 */
	@Override
	@Transactional(readOnly = false)
	public void addEmployee(Employee employee) {
		employee.setEmpId(PrimaryKey.getUUID());
		employeeMapper.addEmployee(employee);
	}

	/**
	 * 修改 员工
	 */
	@Override
	@Transactional(readOnly = false)
	public void updateEmployee(Employee employee) {
		employeeMapper.updateEmployee(employee);
	}

	/**
	 * 根据ID删除记录
	 */
	@Override
	@Transactional(readOnly = false)
	public void deleteEmployeeById(String id) {
		employeeMapper.deleteEmployeeById(id);
	}

	/**
	 * 根据ID查询记录
	 */
	@Override
	public Employee getEmployeeById(String id) {
		return employeeMapper.getEmployeeById(id);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageInfo findEmployeeListPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(employeeMapper.findEmployeeListPage(page, param));
	}

	/**
	 * 根据属性查询员工
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public List<Employee> findEmployeeList(Map<String, Object> param) {
		return employeeMapper.findEmployeeList(param);
	}

	@Override
	public List<Employee> queryEmployeeByEmpIds(String empIds) {
		if (empIds == null || empIds.length() == 0) {
			return new ArrayList<Employee>();
		}
		empIds = empIds.replaceAll("，", ",");
		String[] temp = empIds.split(",");
		List<String> query = new ArrayList<String>();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null && temp[i].trim().length() > 0) {
				query.add(temp[i]);
			}
		}
		if (query.size() == 0) {
			return new ArrayList<Employee>();
		}
		return employeeMapper.queryEmployeeByEmpIds(query);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void toUser(String empId, String username) {
		Employee employee = this.getEmployeeById(empId);
		if(employee ==null) {
			throw new CustomException("员工信息不存在.");
		}else if(employee.getUserId() !=null) {
			throw new CustomException("该员工已同步用户.");
		}
		
		User user = new User();
		user.setUsername(username);
		user.setNickName(employee.getEmpName());
		user = userService.addUser(user, employee.getDptId());
		employee.setUserId(user.getUserId());
		this.updateEmployee(employee);
	}

	@Override
	public Employee queryEmployeeByEmpCard(String empCard) {
		return employeeMapper.queryEmployeeByEmpCard(empCard);
	}

}
