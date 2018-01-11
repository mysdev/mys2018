package com.jing.attendance.controller;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import com.jing.config.validation.BeanValidator;
import com.jing.attendance.model.entity.EmployeeAttendance;
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

	
	@ApiOperation(value = "新增 添加员工考勤关系信息", notes = "添加员工考勤关系信息")
	@RequestMapping(value = "/employeeattendance", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addEmployeeAttendance(HttpServletResponse response,
			@ApiParam(value = "employeeAttendance") @RequestBody EmployeeAttendance employeeAttendance) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employeeAttendance, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		employeeAttendance.setLinkId(null);
		employeeAttendanceService.addEmployeeAttendance(employeeAttendance);
		return employeeAttendance;
	}
	
	
	@ApiOperation(value = "更新 根据员工考勤关系标识更新员工考勤关系信息", notes = "根据员工考勤关系标识更新员工考勤关系信息")
	@RequestMapping(value = "/employeeattendance/{linkId:.+}", method = RequestMethod.PUT)
	public Object modifyEmployeeAttendanceById(HttpServletResponse response,
			@PathVariable Integer linkId,
			@ApiParam(value = "employeeAttendance", required = true) @RequestBody EmployeeAttendance employeeAttendance
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employeeAttendance, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		EmployeeAttendance tempEmployeeAttendance = employeeAttendanceService.queryEmployeeAttendanceByLinkId(linkId);
		employeeAttendance.setLinkId(linkId);
		if(null == tempEmployeeAttendance){
			throw new NotFoundException("员工考勤关系");
		}
		return employeeAttendanceService.modifyEmployeeAttendance(employeeAttendance);
	}

	@ApiOperation(value = "删除 根据员工考勤关系标识删除员工考勤关系信息", notes = "根据员工考勤关系标识删除员工考勤关系信息")
	@RequestMapping(value = "/employeeattendance/{linkId:.+}", method = RequestMethod.DELETE)
	public Object dropEmployeeAttendanceByLinkId(HttpServletResponse response, @PathVariable Integer linkId) {
		EmployeeAttendance employeeAttendance = employeeAttendanceService.queryEmployeeAttendanceByLinkId(linkId);
		if(null == employeeAttendance){
			throw new NotFoundException("员工考勤关系");
		}
		return employeeAttendanceService.dropEmployeeAttendanceByLinkId(linkId);
	}
	
	@ApiOperation(value = "查询 根据员工考勤关系标识查询员工考勤关系信息", notes = "根据员工考勤关系标识查询员工考勤关系信息")
	@RequestMapping(value = "/employeeattendance/{linkId:.+}", method = RequestMethod.GET)
	public Object queryEmployeeAttendanceById(HttpServletResponse response,
			@PathVariable Integer linkId) {
		EmployeeAttendance employeeAttendance = employeeAttendanceService.queryEmployeeAttendanceByLinkId(linkId);
		if(null == employeeAttendance){
			throw new NotFoundException("员工考勤关系");
		}
		return employeeAttendance;
	}
	
	@ApiOperation(value = "查询 根据员工考勤关系属性查询员工考勤关系信息列表", notes = "根据员工考勤关系属性查询员工考勤关系信息列表")
	@RequestMapping(value = "/employeeattendance", method = RequestMethod.GET)
	public Object queryEmployeeAttendanceList(HttpServletResponse response,
			EmployeeAttendance employeeAttendance) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return employeeAttendanceService.queryEmployeeAttendanceByProperty(ClassUtil.transBean2Map(employeeAttendance, false));
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
