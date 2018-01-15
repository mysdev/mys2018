package com.jing.attendance.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.attendance.model.entity.EmployeeAttendance;
import com.jing.attendance.model.dao.EmployeeAttendanceMapper;
import com.jing.attendance.service.EmployeeAttendanceService;
import com.jing.attendance.service.bo.EmployeeAttendanceBo;
import com.jing.core.model.entity.Employee;

/**
 * @ClassName: EmployeeAttendance
 * @Description: 员工考勤关系服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("employeeAttendanceService")
@Transactional(readOnly=true)
public class  EmployeeAttendanceServiceImpl implements EmployeeAttendanceService {	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeAttendanceServiceImpl.class);
	
	@Autowired
    private EmployeeAttendanceMapper employeeAttendanceMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addEmployeeAttendance
	 * @Description:添加员工考勤关系
	 * @param employeeAttendance 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public EmployeeAttendance addEmployeeAttendance(EmployeeAttendance employeeAttendance){
		int ret = employeeAttendanceMapper.addEmployeeAttendance(employeeAttendance);
		if(ret>0){
			return employeeAttendance;
		}
		return null;
	}
	
	/**
	 * @Title modifyEmployeeAttendance
	 * @Description:修改员工考勤关系
	 * @param employeeAttendance 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyEmployeeAttendance(EmployeeAttendance employeeAttendance){
		return employeeAttendanceMapper.modifyEmployeeAttendance(employeeAttendance);
	}
	
	/**
	 * @Title: dropEmployeeAttendanceByLinkId
	 * @Description:删除员工考勤关系
	 * @param linkId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropEmployeeAttendanceByLinkId(Integer linkId){
		return employeeAttendanceMapper.dropEmployeeAttendanceByLinkId(linkId);
	}
	
	/**
	 * @Title: queryEmployeeAttendanceByLinkId
	 * @Description:根据实体标识查询员工考勤关系
	 * @param linkId 实体标识
	 * @return EmployeeAttendance
	 */
	@Override
	public EmployeeAttendance queryEmployeeAttendanceByLinkId(Integer linkId){
		return employeeAttendanceMapper.queryEmployeeAttendanceByLinkId(linkId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryEmployeeAttendanceForPage
	 * @Description: 根据员工考勤关系属性与分页信息分页查询员工考勤关系信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param employeeAttendance 实体
	 * @return List<EmployeeAttendance>
	 */
	@Override
	public Map<String, Object> queryEmployeeAttendanceForPage(Integer pagenum, Integer pagesize, String sort, EmployeeAttendance employeeAttendance){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, EmployeeAttendance.class);
		List<EmployeeAttendance> entityList = employeeAttendanceMapper.queryEmployeeAttendanceForPage(pageBounds, employeeAttendance);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, EmployeeAttendance.class);
		}
		if (!entityList.isEmpty()) {
			PageList<EmployeeAttendance> pagelist = (PageList<EmployeeAttendance>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryEmployeeAttendanceByProperty
	 * @Description:根据属性查询员工考勤关系
	 * @return List<EmployeeAttendance>
	 */
	@Override
	public List<EmployeeAttendance> queryEmployeeAttendanceByProperty(Map<String, Object> map){
		return employeeAttendanceMapper.queryEmployeeAttendanceByProperty(map);
	}

	@Override
	public EmployeeAttendance queryEmployeeAttendanceByEmpId(String empId) {
		return employeeAttendanceMapper.queryEmployeeAttendanceByEmpId(empId);
	}

	@Override
	@Transactional(readOnly = false)
	public Integer dropEmployeeAttendanceByEmpId(String empId) {
		EmployeeAttendance employeeAttendance = queryEmployeeAttendanceByEmpId(empId);
		return employeeAttendance==null?0:dropEmployeeAttendanceByLinkId(employeeAttendance.getLinkId());
	}

	@Override
	public HashMap<String, Object> queryEmployeeAttendanceForPage(Integer pagenum, Integer pagesize, String sort,
			Integer attendanceId, Employee employee) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, EmployeeAttendance.class);
		List<EmployeeAttendanceBo> entityList = employeeAttendanceMapper.queryEmployeeAttendanceForPage(pageBounds, attendanceId, employee);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, EmployeeAttendance.class);
		}
//		if (!entityList.isEmpty()) {
			PageList<EmployeeAttendanceBo> pagelist = (PageList<EmployeeAttendanceBo>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
//		}
		return returnMap;
	}


}
