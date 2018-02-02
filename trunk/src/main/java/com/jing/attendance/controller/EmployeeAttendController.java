package com.jing.attendance.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.attendance.model.entity.EmployeeAttend;
import com.jing.attendance.service.EmployeeAttendService;
import com.jing.attendance.service.EmployeeJournalService;
import com.jing.config.validation.BeanValidator;
import com.jing.config.web.exception.CustomException;
import com.jing.core.model.entity.Employee;
import com.jing.core.service.EmployeeService;
import com.jing.utils.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: EmployeeAttendController
 * @Description: 打卡记录HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="打卡记录")
public class EmployeeAttendController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private EmployeeAttendService employeeAttendService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value = "新增 添加打卡记录信息", notes = "添加打卡记录信息")
	@RequestMapping(value = "/employeeattend", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addEmployeeAttend(HttpServletResponse response,
			@RequestParam(value = "EmpId", required = true) String employeeId) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Employee emp = employeeService.queryEmployeeByEmpId(employeeId);
		if(emp==null){
			throw new CustomException(400, "非法用户。");
		}
		EmployeeAttend employeeAttend = new EmployeeAttend();
		employeeAttend.setEmployeeId(employeeId);
		employeeAttendService.addEmployeeAttend(employeeAttend);
		return employeeAttend;
	}

	@ApiOperation(value = "新增 添加打卡记录信息", notes = "添加打卡记录信息")
	@RequestMapping(value = "/syswhite/cardattend", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addCardAttend(HttpServletResponse response,
			@RequestParam(value = "empCard", required = true) String empCard) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Employee emp = employeeService.queryEmployeeByEmpCard(empCard);
		if(emp==null){
			throw new CustomException(400, "非法用户。");
		}
		EmployeeAttend employeeAttend = new EmployeeAttend();
		employeeAttend.setEmployeeId(emp.getEmpId());
		employeeAttendService.addEmployeeAttend(employeeAttend);
		//此处可以做到提示签到或签退
		return emp;
	}	
	
	@ApiOperation(value = "查询 查询员工本月打卡记录详情", notes = "查询员工本月打卡记录详情")
	@RequestMapping(value = "/employeeattend/{employeeId:.+}", method = RequestMethod.GET)
	public Object queryEmployeeAttendById(HttpServletResponse response,
			@PathVariable String employeeId,
			@RequestParam(value = "yearMonth", required = false) String yearMonth) {
		Employee emp = employeeService.queryEmployeeByEmpId(employeeId);
		if(emp==null){
			throw new CustomException(400, "非法用户。");
		}
		if(yearMonth!=null && !DateUtil.is20yyMM(yearMonth)){
			throw new CustomException(400, "参数错误", "yearMonth", "非法年月格式(20yy-MM)");
		}
		return employeeAttendService.queryEmployeeAttendByEmployeeId(employeeId, yearMonth);
	}	
	
//	@ApiOperation(value = "查询分页 分页查询指定员工打卡记录信息列表", notes = "分页查询指定员工打卡记录信息列表")
//	@RequestMapping(value = "/employeeattends", method = RequestMethod.GET)
//	public Object queryEmployeeAttendPage(HttpServletResponse response,
//			@RequestParam(value = "pageNo", required = false) Integer pagenum,
//			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
//			@RequestParam(value = "sort", required = false) String sort, 
//			@RequestParam(value = "employeeId", required = false) String employeeId, 
//			@RequestParam(value = "yearMonth", required = false) String yearMonth) {
//		//TODO 门店 部门 员工 时间
//		if(sort==null){
//			sort = "{\"attTime\":\"desc\"}";
//		}
//		Map<String, Object> query = new HashMap<String, Object>();
//		if(employeeId!=null)query.put("employeeId", employeeId);
//		if(yearMonth!=null)query.put("yearMonth", yearMonth);
//		
////		if(storeId!=null)query.put("storeId", storeId);		
////		if(dptId!=null)query.put("dptId", dptId);
//		return employeeAttendService.queryEmployeeAttendForPage(pagenum, pagesize, sort, query);
//	}
	
	
	@Autowired
	private EmployeeJournalService employeeJournalService;
	
	@ApiOperation(value = "查询 查询员工考勤日志信息", notes = "查询员工考勤日志信息")
	@RequestMapping(value = "/employeejournal/{employeeId:.+}", method = RequestMethod.GET)
	public Object queryEmployeeJournalById(HttpServletResponse response,
			@PathVariable String employeeId,
			@RequestParam(value = "yearMonth", required = false) String yearMonth) {
		Employee emp = employeeService.queryEmployeeByEmpId(employeeId);
		if(emp==null){
			throw new CustomException(400, "非法用户。");
		}
		if(yearMonth!=null && !DateUtil.is20yyMM(yearMonth)){
			throw new CustomException(400, "参数错误", "yearMonth", "非法年月格式(20yy-MM)");
		}
		return employeeJournalService.queryEmployeeJournalByEmpId(employeeId, yearMonth);
	}
	
//	@ApiOperation(value = "查询 根据员工考勤日志属性查询员工考勤日志信息列表", notes = "根据员工考勤日志属性查询员工考勤日志信息列表")
//	@RequestMapping(value = "/employeejournal", method = RequestMethod.GET)
//	public Object queryEmployeeJournalList(HttpServletResponse response,
//			EmployeeJournal employeeJournal) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
//		return employeeJournalService.queryEmployeeJournalAllForPage(ClassUtil.transBean2Map(employeeJournal, false));
//	}
	
	@ApiOperation(value = "查询分页 根据员工考勤日志属性分页查询员工考勤日志信息列表", notes = "根据员工考勤日志属性分页查询员工考勤日志信息列表")
	@RequestMapping(value = "/employeejournals", method = RequestMethod.GET)
	public Object queryEmployeeJournalPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "storeId", required = false) String storeId,
			@RequestParam(value = "employeeId", required = false) String employeeId,
			@RequestParam(value = "yearMonth", required = false) String yearMonth,
			@RequestParam(value = "empName", required = false) String empName,
			@RequestParam(value = "empNo", required = false) String empNo,
			@RequestParam(value = "pinyin", required = false) String pinyin) {	
		Map<String, Object> query =new HashMap<String, Object>();
		if(storeId!=null)query.put("storeId", storeId);
		if(storeId!=null)query.put("empId", employeeId);
		
		if(yearMonth!=null)query.put("yearMonth", yearMonth);
		if(empName!=null)query.put("empName", empName);
		if(empNo!=null)query.put("empNo", empNo);
		if(pinyin!=null)query.put("pinyin", pinyin);
		return employeeJournalService.queryEmployeeJournalAllForPage(pagenum, pagesize, sort, query);
	}

}
