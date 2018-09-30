package com.jing.attendance.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.attendance.model.dao.AttendanceEmployeeMapper;
import com.jing.attendance.model.entity.AttendanceEmployee;
import com.jing.attendance.service.AttendanceEmployeeService;
import com.jing.attendance.service.PublicAttendanceService;
import com.jing.config.web.exception.CustomException;
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
//	private static final Logger logger = LoggerFactory.getLogger(AttendanceEmployeeServiceImpl.class);
	
	@Autowired
    private AttendanceEmployeeMapper employeeAttendanceMapper;
	
	@Autowired
	private PublicAttendanceService publicAttendanceService;
    
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
			publicAttendanceService.doAndRedoPersonAttendanceByEmpId(employeeAttendance.getEmpId()); //初始化末来考勤数据
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
		AttendanceEmployee ae = queryAttendanceEmployeeByLinkId(employeeAttendance.getLinkId());		
		if(employeeAttendance.getEmpId()==null || !ae.getEmpId().equals(employeeAttendance.getEmpId())) {
			throw new CustomException(400, "参数错误", "empId", "员工号为空或员工号发生改变"); //员工
		}
		employeeAttendanceMapper.modifyAttendanceEmployee(employeeAttendance);
		publicAttendanceService.doAndRedoPersonAttendanceByEmpId(ae.getEmpId()); //初始化末来考勤数据
		return 1;
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
		AttendanceEmployee ae = queryAttendanceEmployeeByLinkId(linkId);
		employeeAttendanceMapper.dropAttendanceEmployeeByLinkId(linkId);
		publicAttendanceService.doAndRedoPersonAttendanceByEmpId(ae.getEmpId()); //初始化末来考勤数据
		return 1;
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
	 * @return HashMap<String, Object>
	 */
	@Override
	public HashMap<String, Object> queryAttendanceEmployeeForPage(Integer pagenum, Integer pagesize, String sort,
			Integer attendanceId, Map<String, Object> params) {
		if(params==null){
			params = new HashMap<String, Object>();
		}
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJsonForMap(sort);
		List<Map<String, Object>> entityList = employeeAttendanceMapper.queryAttendanceEmployeeForPage(pageBounds, params);		
//		if (!entityList.isEmpty()) {
			PageList<Map<String, Object>> pagelist = (PageList<Map<String, Object>>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
//		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryAttendanceEmployeeByProperty
	 * @Description:根据属性查询员工考勤关系 为0时查询未绑定员工，其它查询考勤规则下的员工
	 * @return List<AttendanceEmployee>
	 */
	@Override
	public List<Map<String, String>> queryAttendanceEmployeeByProperty(Integer attendanceId){
		if(attendanceId.intValue()>0) {
			return employeeAttendanceMapper.queryAttendanceEmployeeByProperty(attendanceId);
		}else {
			return employeeAttendanceMapper.queryAttendanceEmployeeFree();
		}		
	}

	@Override
	public AttendanceEmployee queryAttendanceEmployeeByEmpId(String empId) {
		return employeeAttendanceMapper.queryAttendanceEmployeeByEmpId(empId);
	}

	@Override
	@Transactional(readOnly = false)
	public Integer dropAttendanceEmployeeByEmpId(String empId) {
		AttendanceEmployee employeeAttendance = queryAttendanceEmployeeByEmpId(empId);
		if(employeeAttendance!=null) {
			dropAttendanceEmployeeByLinkId(employeeAttendance.getLinkId());
			publicAttendanceService.doAndRedoPersonAttendanceByEmpId(empId); //初始化末来考勤数据
		}
		return employeeAttendance==null?0:1;
	}

	@Override
	@Transactional(readOnly = false)
	public Integer bindAttendanceEmployee(int userId, Integer attendanceId, List<String> empList) {
		for(String empId : empList){
			AttendanceEmployee ae = employeeAttendanceMapper.queryAttendanceEmployeeByEmpId(empId);
			if(ae==null){
				ae = new AttendanceEmployee();
				ae.setCreatedBy(userId);
				ae.setUpdatedBy(userId);
				ae.setAttendanceId(attendanceId);
				ae.setEmpId(empId);
				employeeAttendanceMapper.addAttendanceEmployee(ae);
			}else{
				ae.setUpdatedBy(userId);
				ae.setAttendanceId(attendanceId);
				employeeAttendanceMapper.modifyAttendanceEmployee(ae);
			}
			publicAttendanceService.doAndRedoPersonAttendanceByEmpId(empId); //初始化末来考勤数据
		}		
		return empList.size();
	}

	/*
	 * @Title: manageAttendanceEmployee
	 * @Description: 
	 * @param @param userId
	 * @param @param attendanceId
	 * @param @param empList
	 * @param @return    参数  
	 * @author Jinlong He
	 * @param userId
	 * @param attendanceId
	 * @param empList
	 * @return
	 * @see com.jing.attendance.service.AttendanceEmployeeService#manageAttendanceEmployee(java.lang.Integer, java.lang.Integer, java.util.List)
	 */ 
	@Override
	@Transactional(readOnly = false)
	public Integer manageAttendanceEmployee(Integer userId, Integer attendanceId, List<String> empList) {
		//查询所有，清除未在清单中的
		List<Map<String, String>> temp = employeeAttendanceMapper.queryAttendanceEmployeeByProperty(attendanceId);
		for(int i=temp.size()-1; i>=0; i--) {
			Map<String, String> tempA = temp.get(i);
			if(tempA!=null) {
				boolean yn = true;
				for(String ename: empList) {
					if(tempA.get("empId")!=null && tempA.get("empId").equals(ename)){	
						yn=false;
						continue;
					}
				}
				if(yn) {
					dropAttendanceEmployeeByEmpId(tempA.get("empId"));	
				}
			}
		}
		//新增或修订
		return bindAttendanceEmployee(userId, attendanceId, empList);
	}


}
