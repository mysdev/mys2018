package com.jing.attendance.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.attendance.model.dao.AttendanceEmployeeMapper;
import com.jing.attendance.model.entity.AttendanceEmployee;
import com.jing.attendance.service.AttendanceEmployeeService;
import com.jing.attendance.service.bo.AttendanceEmployeeBo;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: AttendanceEmployee
 * @Description: 员工考勤关系服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("employeeAttendanceService")
@Transactional(readOnly=true)
public class  AttendanceEmployeeServiceImpl implements AttendanceEmployeeService {	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceEmployeeServiceImpl.class);
	
	@Autowired
    private AttendanceEmployeeMapper employeeAttendanceMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addAttendanceEmployee
	 * @Description:添加员工考勤关系
	 * @param employeeAttendance 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public AttendanceEmployee addAttendanceEmployee(AttendanceEmployee employeeAttendance){
		int ret = employeeAttendanceMapper.addAttendanceEmployee(employeeAttendance);
		if(ret>0){
			return employeeAttendance;
		}
		return null;
	}
	
	/**
	 * @Title modifyAttendanceEmployee
	 * @Description:修改员工考勤关系
	 * @param employeeAttendance 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyAttendanceEmployee(AttendanceEmployee employeeAttendance){
		return employeeAttendanceMapper.modifyAttendanceEmployee(employeeAttendance);
	}
	
	/**
	 * @Title: dropAttendanceEmployeeByLinkId
	 * @Description:删除员工考勤关系
	 * @param linkId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropAttendanceEmployeeByLinkId(Integer linkId){
		return employeeAttendanceMapper.dropAttendanceEmployeeByLinkId(linkId);
	}
	
	/**
	 * @Title: queryAttendanceEmployeeByLinkId
	 * @Description:根据实体标识查询员工考勤关系
	 * @param linkId 实体标识
	 * @return AttendanceEmployee
	 */
	@Override
	public AttendanceEmployee queryAttendanceEmployeeByLinkId(Integer linkId){
		return employeeAttendanceMapper.queryAttendanceEmployeeByLinkId(linkId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryAttendanceEmployeeForPage
	 * @Description: 根据员工考勤关系属性与分页信息分页查询员工考勤关系信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param employeeAttendance 实体
	 * @return List<AttendanceEmployee>
	 */
	@Override
	public Map<String, Object> queryAttendanceEmployeeForPage(Integer pagenum, Integer pagesize, String sort, AttendanceEmployee employeeAttendance){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, AttendanceEmployee.class);
		List<AttendanceEmployee> entityList = employeeAttendanceMapper.queryAttendanceEmployeeForPage(pageBounds, employeeAttendance);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, AttendanceEmployee.class);
		}
		if (!entityList.isEmpty()) {
			PageList<AttendanceEmployee> pagelist = (PageList<AttendanceEmployee>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryAttendanceEmployeeByProperty
	 * @Description:根据属性查询员工考勤关系
	 * @return List<AttendanceEmployee>
	 */
	@Override
	public List<AttendanceEmployee> queryAttendanceEmployeeByProperty(Map<String, Object> map){
		return employeeAttendanceMapper.queryAttendanceEmployeeByProperty(map);
	}

	@Override
	public AttendanceEmployee queryAttendanceEmployeeByEmpId(String empId) {
		return employeeAttendanceMapper.queryAttendanceEmployeeByEmpId(empId);
	}

	@Override
	@Transactional(readOnly = false)
	public Integer dropAttendanceEmployeeByEmpId(String empId) {
		AttendanceEmployee employeeAttendance = queryAttendanceEmployeeByEmpId(empId);
		return employeeAttendance==null?0:dropAttendanceEmployeeByLinkId(employeeAttendance.getLinkId());
	}

	@Override
	public HashMap<String, Object> queryAttendanceEmployeeForPage(Integer pagenum, Integer pagesize, String sort,
			Integer attendanceId, Map<String, Object> params) {
		if(params==null){
			params = new HashMap<String, Object>();
		}
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, null);
		List<AttendanceEmployeeBo> entityList;
		if(attendanceId!=null && attendanceId.intValue()==-1){
			//查询未分配考勤员工
			entityList = employeeAttendanceMapper.queryAttendanceEmployeeNotForPage(pageBounds, params);
		}else{
			//查询已分配考勤员工
			if(attendanceId!=null && attendanceId.intValue()>0) {
				params.put("attendanceId", attendanceId);
			}
			entityList = employeeAttendanceMapper.queryAttendanceEmployeeAllForPage(pageBounds, params);
		}
//		if (!entityList.isEmpty()) {
			PageList<AttendanceEmployeeBo> pagelist = (PageList<AttendanceEmployeeBo>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
//		}
		return returnMap;
	}

	@Override
	@Transactional(readOnly = false)
	public Integer bindAttendanceEmployee(String userId, Integer attendanceId, List<String> empList) {
		for(String empId : empList){
			AttendanceEmployee ae = employeeAttendanceMapper.queryAttendanceEmployeeByEmpId(empId);
			if(ae==null){
				ae = new AttendanceEmployee();
				ae.setCreatedBy(userId);
				ae.setAttendanceId(attendanceId);
				ae.setEmpId(empId);
				employeeAttendanceMapper.addAttendanceEmployee(ae);
			}else{
				ae.setUpdatedBy(userId);
				ae.setAttendanceId(attendanceId);
				employeeAttendanceMapper.modifyAttendanceEmployee(ae);
			}
		}		
		return empList.size();
	}


}
