package com.jing.attendance.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.attendance.model.entity.AttendanceLogs;
import com.jing.attendance.service.AttendanceDiaryService;
import com.jing.attendance.service.AttendanceLogsService;
import com.jing.config.validation.BeanValidator;
import com.jing.config.web.exception.CustomException;
import com.jing.core.model.entity.Employee;
import com.jing.core.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: AttendanceDiaryController
 * @Description: 打卡记录HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月05日 22时39分
 */
@RestController
@Api(description="打卡记录", tags={"AttendanceDiary"})
public class AttendanceDiaryController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private AttendanceDiaryService attendanceDiaryService;
	
	@Autowired
	private AttendanceLogsService attendanceLogsService;
	
	@Autowired
	private EmployeeService employeeService;

	
	@ApiOperation(value = "新增 添加打卡记录信息", notes = "添加打卡记录信息")
	@RequestMapping(value = "/syswhite/cardattend", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addAttendanceDiary(HttpServletResponse response,
			@RequestParam(value = "empCard", required = true) String empCard) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Employee emp = employeeService.queryEmployeeByEmpCard(empCard);
		if(emp==null){
			throw new CustomException(400, "非法用户。");
		}
		AttendanceLogs logs = new AttendanceLogs();
		logs.setEmpId(emp.getEmpId());
		logs.setAttNote("{\"cardNo\":\""+empCard+"\"}");
		attendanceLogsService.addAttendanceLogs(logs);
		
		Map<String, Object> ret = new HashMap<String, Object>();
		
		ret.put("employeeName", emp.getEmpName());
		ret.put("message", attendanceDiaryService.processAttendanceDiary(emp.getEmpId()));		
		return ret;
	}
	
//	
//	@ApiOperation(value = "更新 根据打卡记录标识更新打卡记录信息", notes = "根据打卡记录标识更新打卡记录信息")
//	@RequestMapping(value = "/attendancediary/{attId:.+}", method = RequestMethod.PUT)
//	public Object modifyAttendanceDiaryById(HttpServletResponse response,
//			@PathVariable Integer attId,
//			@ApiParam(value = "attendanceDiary", required = true) @RequestBody AttendanceDiary attendanceDiary
//			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
//		AttendanceDiary tempAttendanceDiary = attendanceDiaryService.queryAttendanceDiaryByAttId(attId);
//		attendanceDiary.setAttId(attId);
//		if(null == tempAttendanceDiary){
//			throw new NotFoundException("打卡记录");
//		}
//		return attendanceDiaryService.modifyAttendanceDiary(attendanceDiary);
//	}
//
//	@ApiOperation(value = "删除 根据打卡记录标识删除打卡记录信息", notes = "根据打卡记录标识删除打卡记录信息")
//	@RequestMapping(value = "/attendancediary/{attId:.+}", method = RequestMethod.DELETE)
//	public Object dropAttendanceDiaryByAttId(HttpServletResponse response, @PathVariable Integer attId) {
//		AttendanceDiary attendanceDiary = attendanceDiaryService.queryAttendanceDiaryByAttId(attId);
//		if(null == attendanceDiary){
//			throw new NotFoundException("打卡记录");
//		}
//		return attendanceDiaryService.dropAttendanceDiaryByAttId(attId);
//	}
//	
//	@ApiOperation(value = "查询 根据打卡记录标识查询打卡记录信息", notes = "根据打卡记录标识查询打卡记录信息")
//	@RequestMapping(value = "/attendancediary/{attId:.+}", method = RequestMethod.GET)
//	public Object queryAttendanceDiaryById(HttpServletResponse response,
//			@PathVariable Integer attId) {
//		AttendanceDiary attendanceDiary = attendanceDiaryService.queryAttendanceDiaryByAttId(attId);
//		if(null == attendanceDiary){
//			throw new NotFoundException("打卡记录");
//		}
//		return attendanceDiary;
//	}
//	
//	@ApiOperation(value = "查询 根据打卡记录属性查询打卡记录信息列表", notes = "根据打卡记录属性查询打卡记录信息列表")
//	@RequestMapping(value = "/attendancediary", method = RequestMethod.GET)
//	public Object queryAttendanceDiaryList(HttpServletResponse response,
//			AttendanceDiary attendanceDiary) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
//		return attendanceDiaryService.queryAttendanceDiaryByProperty(ClassUtil.transBean2Map(attendanceDiary, false));
//	}
	
	@ApiOperation(value = "查询分页 根据打卡记录属性分页查询打卡记录信息列表", notes = "根据打卡记录属性分页查询打卡记录信息列表")
	@RequestMapping(value = "/attendance/employee/diarys", method = RequestMethod.GET)
	public Object queryAttendanceDiaryPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, 
			@RequestParam(value = "employeeId", required = false) String employeeId,
			@RequestParam(value = "namePYJob", required = false) String namePYJob,
			@RequestParam(value = "dptId", required = false) Integer dptId,
			@RequestParam(value = "storeId", required = false) String storeId,
			@RequestParam(value = "yearMonth", required = false) String yearMonth,
			@RequestParam(value = "empCard", required = false) String empCard) {				
		Map<String, Object> query = new HashMap<String, Object>();
		if(employeeId!=null) query.put("employeeId", employeeId);
		if(namePYJob!=null) query.put("namePYJob", namePYJob);
		if(dptId!=null) query.put("dptId", dptId);
		if(storeId!=null) query.put("storeId", storeId);
		if(yearMonth!=null) query.put("yearMonth", yearMonth);
		if(empCard!=null) query.put("empCard", empCard);
		if(sort==null || sort.length()==0){
			sort = "{\"attTime\":\"DESC\"}";
		}
		return attendanceDiaryService.queryAttendanceDiaryAllForPage(pagenum, pagesize, sort, query);
	}

}
