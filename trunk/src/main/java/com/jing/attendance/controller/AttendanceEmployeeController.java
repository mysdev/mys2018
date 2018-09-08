package com.jing.attendance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.attendance.model.entity.Attendance;
import com.jing.attendance.model.entity.AttendanceEmployee;
import com.jing.attendance.service.AttendanceEmployeeService;
import com.jing.attendance.service.AttendanceService;
import com.jing.config.validation.BeanValidator;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import com.jing.core.model.entity.Employee;
import com.jing.core.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: AttendanceEmployeeController
 * @Description: 员工考勤关系HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="员工考勤关系", tags={"AttendanceEmployee"})
public class AttendanceEmployeeController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private AttendanceEmployeeService attendanceEmployeeService;
	
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private EmployeeService employeeService;

	
	@ApiOperation(value = "绑定 绑定员工考勤关系信息", notes = "绑定员工考勤关系信息-如存在则修订考勤关系")
	@RequestMapping(value = "/attendance/{attendanceId:.+}/employee", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addAttendanceEmployee(HttpServletResponse response,
			@PathVariable Integer attendanceId,
			@ApiParam(value = "attendanceEmployee") @RequestBody String[] employeeIds) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = new ArrayList<Map<String, String>>();
		Attendance att = attendanceService.queryAttendanceByAttendanceId(attendanceId);
		if(att==null){
			throw new NotFoundException("考勤方案找不到");
		}
		if(att.getStatus().intValue()!=0){
			throw new CustomException(400, att.getAttendanceName()+" 已失效,不允许再使用。");
		}
		int i=1;
		List<String> empList = new ArrayList<String>();
		for(String empId : employeeIds){
			Employee emp = employeeService.queryEmployeeByEmpId(empId);
			if(emp==null){
				Map<String, String> e0 = new HashMap<String, String>();
				e0.put("index", ""+i);
				e0.put("filed", "employeeId");
				e0.put("message", "员工不存在。");
				errors.add(e0);
			}	
			empList.add(empId);
			i++;
		}			
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}		
		return attendanceEmployeeService.bindAttendanceEmployee("system", attendanceId, empList);
	}


	@ApiOperation(value = "删除 根据员工标识删除员工考勤关系信息", notes = "根据员工标识删除员工考勤关系信息")
	@RequestMapping(value = "/attendance/{attendanceId:.+}/employee/{empId:.+}", method = RequestMethod.DELETE)
	public Object dropAttendanceEmployeeByLinkId(HttpServletResponse response,
			@PathVariable Integer attendanceId,
			@PathVariable String empId) {
		AttendanceEmployee attendanceEmployee = attendanceEmployeeService.queryAttendanceEmployeeByEmpId(empId);
		if(null == attendanceEmployee){
			throw new NotFoundException("员工考勤关系");
		}
		if(attendanceEmployee.getAttendanceId().intValue()!=attendanceId.intValue()){
			throw new ParameterException("attendanceId", "用户与考勤规则关系不匹配。");
		}
		return attendanceEmployeeService.dropAttendanceEmployeeByLinkId(attendanceEmployee.getLinkId());//.dropAttendanceEmployeeByEmpId(empId);
	}
	
	@ApiOperation(value = "查询 根据员工标识查询员工考勤信息", notes = "根据员工标识查询员工考勤信息-attendanceId不作强制校验")
	@RequestMapping(value = "/attendance/{attendanceId:.+}/employee/{empId:.+}", method = RequestMethod.GET)
	public Object queryAttendanceEmployeeById(HttpServletResponse response,
			@PathVariable Integer attendanceId,
			@PathVariable String empId) {
		Employee emp = employeeService.queryEmployeeByEmpId(empId);
		if(emp==null){
			throw new NotFoundException("员工找不到");
		}
		AttendanceEmployee attendanceEmployee = attendanceEmployeeService.queryAttendanceEmployeeByEmpId(empId);
		if(null == attendanceEmployee){
			throw new NotFoundException("员工考勤关系");
		}
		return attendanceService.queryAttendanceByAttendanceId(attendanceEmployee.getAttendanceId());
	}
	
//	@ApiOperation(value = "查询 根据考勤标识查询员工考勤关系信息列表", notes = "根据考勤标识查询员工考勤关系信息列表 attendanceId=0")
//	@RequestMapping(value = "/attendance/{attendanceId:.+}/employee", method = RequestMethod.GET)
//	public Object queryAttendanceEmployeeList(HttpServletResponse response,
//			@PathVariable Integer attendanceId) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {	
//		Map<String, Object> query = new HashMap<String, Object>();
//		if(attendanceId!=null && attendanceId.intValue()!=0){
//			query.put("attendanceId", attendanceId);
//		}
//		List<AttendanceEmployee> eaList = attendanceEmployeeService.queryAttendanceEmployeeByProperty(query);
//		if(eaList!=null && eaList.size()>0){
//			String empIds = "";
//			for(AttendanceEmployee ea: eaList){
//				empIds += (ea.getEmpId()+",");
//			}
//			return employeeService.queryEmployeeByEmpIds(empIds);
//		} 
//		return new ArrayList();
//	}
	
	@ApiOperation(value = "查询分页 查询员工考勤关系信息列表", notes = "查询员工考勤关系信息列表 attendanceId 考勤标识 -1未分配  0全部    其它为指定考勤规则")
	@RequestMapping(value = "/attendance/{attendanceId:.+}/employees", method = RequestMethod.GET)
	public Object queryAttendanceEmployeePage(HttpServletResponse response,
			@PathVariable Integer attendanceId,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, 
			@RequestParam(value = "namePYJob", required = false) String namePYJob,
			@RequestParam(value = "dptId", required = false) Integer dptId,
			@RequestParam(value = "storeId", required = false) String storeId) {	
		Map<String, Object> query = new HashMap<String, Object>();
		if(namePYJob!=null && namePYJob.trim().length()>0){
			query.put("namePYJob", namePYJob.trim());
		}
		if(dptId!=null && dptId.intValue()>0){
			query.put("dptId", dptId);
		}
		if(storeId!=null && storeId.trim().length()>0){
			query.put("storeId", storeId.trim());
		}
		return attendanceEmployeeService.queryAttendanceEmployeeForPage(pagenum, pagesize, sort, attendanceId, query);
	}

}
