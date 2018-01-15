package com.jing.attendance.controller;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.config.web.exception.CustomException;
import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import com.jing.core.model.entity.Employee;
import com.jing.core.service.EmployeeService;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import com.jing.config.validation.BeanValidator;
import com.jing.attendance.model.entity.Attendance;
import com.jing.attendance.model.entity.EmployeeAttendance;
import com.jing.attendance.service.AttendanceService;
import com.jing.attendance.service.EmployeeAttendanceService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: EmployeeAttendanceController
 * @Description: 员工考勤关系HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="员工考勤关系")
public class EmployeeAttendanceController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private EmployeeAttendanceService employeeAttendanceService;
	
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private EmployeeService employeeService;

	
	@ApiOperation(value = "绑定 绑定员工考勤关系信息", notes = "绑定员工考勤关系信息-如存在则修订考勤关系")
	@RequestMapping(value = "/employeeattendance", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addEmployeeAttendance(HttpServletResponse response,
			@ApiParam(value = "employeeAttendance") @RequestBody EmployeeAttendance employeeAttendance) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employeeAttendance, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Employee emp = employeeService.queryEmployeeByEmpId(employeeAttendance.getEmpId());
		if(emp==null){
			throw new NotFoundException("员工找不到");
		}		
		Attendance att = attendanceService.queryAttendanceByAttendanceId(employeeAttendance.getAttendanceId());
		if(att==null){
			throw new NotFoundException("考勤方案找不到");
		}
		if(att.getStatus().intValue()!=0){
			throw new CustomException(400, att.getAttendanceName()+" 已失效,不允许再使用。");
		}
		
		EmployeeAttendance tempEA = employeeAttendanceService.queryEmployeeAttendanceByEmpId(employeeAttendance.getEmpId());
		if(tempEA==null || tempEA.getAttendanceId()==null){
			//不存在，添加关联关系 
			employeeAttendance.setLinkId(null);
			employeeAttendanceService.addEmployeeAttendance(employeeAttendance);
			return employeeAttendance;
		}else{
			//存在，修订关联关系 
			employeeAttendance.setLinkId(tempEA.getLinkId());
			employeeAttendanceService.modifyEmployeeAttendance(employeeAttendance);
		}
		return employeeAttendance;
	}


	@ApiOperation(value = "删除 根据员工标识删除员工考勤关系信息", notes = "根据员工标识删除员工考勤关系信息")
	@RequestMapping(value = "/employeeattendance/{empId:.+}", method = RequestMethod.DELETE)
	public Object dropEmployeeAttendanceByLinkId(HttpServletResponse response, @PathVariable String empId) {
		Employee emp = employeeService.queryEmployeeByEmpId(empId);
		if(emp==null){
			throw new NotFoundException("员工找不到");
		}
		EmployeeAttendance employeeAttendance = employeeAttendanceService.queryEmployeeAttendanceByEmpId(empId);
		if(null == employeeAttendance){
			throw new NotFoundException("员工考勤关系");
		}
		return employeeAttendanceService.dropEmployeeAttendanceByEmpId(empId);
	}
	
	@ApiOperation(value = "查询 根据员工考勤关系标识查询员工考勤信息", notes = "根据员工考勤关系标识查询员工考勤信息")
	@RequestMapping(value = "/employeeattendance/{empId:.+}", method = RequestMethod.GET)
	public Object queryEmployeeAttendanceById(HttpServletResponse response,
			@PathVariable String empId) {
		Employee emp = employeeService.queryEmployeeByEmpId(empId);
		if(emp==null){
			throw new NotFoundException("员工找不到");
		}
		EmployeeAttendance employeeAttendance = employeeAttendanceService.queryEmployeeAttendanceByEmpId(empId);
		if(null == employeeAttendance){
			throw new NotFoundException("员工考勤关系");
		}
		return attendanceService.queryAttendanceByAttendanceId(employeeAttendance.getAttendanceId());
	}
	
	@ApiOperation(value = "查询 根据员工考勤关系属性查询员工考勤关系信息列表", notes = "根据员工考勤关系属性查询员工考勤关系信息列表")
	@RequestMapping(value = "/employeeattendance", method = RequestMethod.GET)
	public Object queryEmployeeAttendanceList(HttpServletResponse response,
			Integer attendanceId) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {	
		Map<String, Object> query = new HashMap<String, Object>();
		if(attendanceId!=null && attendanceId.intValue()!=0){
			query.put("attendanceId", attendanceId);
		}
		List<EmployeeAttendance> eaList = employeeAttendanceService.queryEmployeeAttendanceByProperty(query);
		if(eaList!=null && eaList.size()>0){
			String empIds = "";
			for(EmployeeAttendance ea: eaList){
				empIds += (ea.getEmpId()+",");
			}
			return employeeService.queryEmployeeByEmpIds(empIds);
		}
		return new ArrayList();
	}
	
	@ApiOperation(value = "查询分页 根据员工考勤关系属性分页查询员工考勤关系信息列表", notes = "根据员工考勤关系属性分页查询员工考勤关系信息列表")
	@RequestMapping(value = "/employeeattendances", method = RequestMethod.GET)
	public Object queryEmployeeAttendancePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, EmployeeAttendance employeeAttendance) {				
		return employeeAttendanceService.queryEmployeeAttendanceForPage(pagenum, pagesize, sort, employeeAttendance);
	}

}
