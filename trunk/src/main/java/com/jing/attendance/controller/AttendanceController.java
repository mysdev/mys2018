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
import com.jing.attendance.model.entity.Attendance;
import com.jing.attendance.service.AttendanceService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: AttendanceController
 * @Description: 门店考勤HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="门店考勤")
public class AttendanceController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private AttendanceService attendanceService;

	
	@ApiOperation(value = "新增 添加门店考勤信息", notes = "添加门店考勤信息")
	@RequestMapping(value = "/attendance", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addAttendance(HttpServletResponse response,
			@ApiParam(value = "attendance") @RequestBody Attendance attendance) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(attendance, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		attendance.setAttendanceId(null);
		attendanceService.addAttendance(attendance);
		return attendance;
	}
	
	
	@ApiOperation(value = "更新 根据门店考勤标识更新门店考勤信息", notes = "根据门店考勤标识更新门店考勤信息")
	@RequestMapping(value = "/attendance/{attendanceId:.+}", method = RequestMethod.PUT)
	public Object modifyAttendanceById(HttpServletResponse response,
			@PathVariable Integer attendanceId,
			@ApiParam(value = "attendance", required = true) @RequestBody Attendance attendance
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(attendance, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Attendance tempAttendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);
		attendance.setAttendanceId(attendanceId);
		if(null == tempAttendance){
			throw new NotFoundException("门店考勤");
		}
		return attendanceService.modifyAttendance(attendance);
	}

	@ApiOperation(value = "删除 根据门店考勤标识删除门店考勤信息", notes = "根据门店考勤标识删除门店考勤信息")
	@RequestMapping(value = "/attendance/{attendanceId:.+}", method = RequestMethod.DELETE)
	public Object dropAttendanceByAttendanceId(HttpServletResponse response, @PathVariable Integer attendanceId) {
		Attendance attendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);
		if(null == attendance){
			throw new NotFoundException("门店考勤");
		}
		return attendanceService.dropAttendanceByAttendanceId(attendanceId);
	}
	
	@ApiOperation(value = "查询 根据门店考勤标识查询门店考勤信息", notes = "根据门店考勤标识查询门店考勤信息")
	@RequestMapping(value = "/attendance/{attendanceId:.+}", method = RequestMethod.GET)
	public Object queryAttendanceById(HttpServletResponse response,
			@PathVariable Integer attendanceId) {
		Attendance attendance = attendanceService.queryAttendanceByAttendanceId(attendanceId);
		if(null == attendance){
			throw new NotFoundException("门店考勤");
		}
		return attendance;
	}
	
	@ApiOperation(value = "查询 根据门店考勤属性查询门店考勤信息列表", notes = "根据门店考勤属性查询门店考勤信息列表")
	@RequestMapping(value = "/attendance", method = RequestMethod.GET)
	public Object queryAttendanceList(HttpServletResponse response,
			Attendance attendance) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return attendanceService.queryAttendanceByProperty(ClassUtil.transBean2Map(attendance, false));
	}
	
	@ApiOperation(value = "查询分页 根据门店考勤属性分页查询门店考勤信息列表", notes = "根据门店考勤属性分页查询门店考勤信息列表")
	@RequestMapping(value = "/attendances", method = RequestMethod.GET)
	public Object queryAttendancePage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Attendance attendance) {				
		return attendanceService.queryAttendanceForPage(pagenum, pagesize, sort, attendance);
	}

}
