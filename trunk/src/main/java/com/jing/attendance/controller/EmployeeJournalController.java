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
import com.jing.attendance.model.entity.EmployeeJournal;
import com.jing.attendance.service.EmployeeJournalService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: EmployeeJournalController
 * @Description: 员工考勤日志HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="员工考勤日志")
public class EmployeeJournalController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private EmployeeJournalService employeeJournalService;

	
	@ApiOperation(value = "新增 添加员工考勤日志信息", notes = "添加员工考勤日志信息")
	@RequestMapping(value = "/employeejournal", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addEmployeeJournal(HttpServletResponse response,
			@ApiParam(value = "employeeJournal") @RequestBody EmployeeJournal employeeJournal) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employeeJournal, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		employeeJournal.setJournalId(null);
		employeeJournalService.addEmployeeJournal(employeeJournal);
		return employeeJournal;
	}
	
	
	@ApiOperation(value = "更新 根据员工考勤日志标识更新员工考勤日志信息", notes = "根据员工考勤日志标识更新员工考勤日志信息")
	@RequestMapping(value = "/employeejournal/{journalId:.+}", method = RequestMethod.PUT)
	public Object modifyEmployeeJournalById(HttpServletResponse response,
			@PathVariable Integer journalId,
			@ApiParam(value = "employeeJournal", required = true) @RequestBody EmployeeJournal employeeJournal
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employeeJournal, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		EmployeeJournal tempEmployeeJournal = employeeJournalService.queryEmployeeJournalByJournalId(journalId);
		employeeJournal.setJournalId(journalId);
		if(null == tempEmployeeJournal){
			throw new NotFoundException("员工考勤日志");
		}
		return employeeJournalService.modifyEmployeeJournal(employeeJournal);
	}

	@ApiOperation(value = "删除 根据员工考勤日志标识删除员工考勤日志信息", notes = "根据员工考勤日志标识删除员工考勤日志信息")
	@RequestMapping(value = "/employeejournal/{journalId:.+}", method = RequestMethod.DELETE)
	public Object dropEmployeeJournalByJournalId(HttpServletResponse response, @PathVariable Integer journalId) {
		EmployeeJournal employeeJournal = employeeJournalService.queryEmployeeJournalByJournalId(journalId);
		if(null == employeeJournal){
			throw new NotFoundException("员工考勤日志");
		}
		return employeeJournalService.dropEmployeeJournalByJournalId(journalId);
	}
	
	@ApiOperation(value = "查询 根据员工考勤日志标识查询员工考勤日志信息", notes = "根据员工考勤日志标识查询员工考勤日志信息")
	@RequestMapping(value = "/employeejournal/{journalId:.+}", method = RequestMethod.GET)
	public Object queryEmployeeJournalById(HttpServletResponse response,
			@PathVariable Integer journalId) {
		EmployeeJournal employeeJournal = employeeJournalService.queryEmployeeJournalByJournalId(journalId);
		if(null == employeeJournal){
			throw new NotFoundException("员工考勤日志");
		}
		return employeeJournal;
	}
	
	@ApiOperation(value = "查询 根据员工考勤日志属性查询员工考勤日志信息列表", notes = "根据员工考勤日志属性查询员工考勤日志信息列表")
	@RequestMapping(value = "/employeejournal", method = RequestMethod.GET)
	public Object queryEmployeeJournalList(HttpServletResponse response,
			EmployeeJournal employeeJournal) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return employeeJournalService.queryEmployeeJournalByProperty(ClassUtil.transBean2Map(employeeJournal, false));
	}
	
	@ApiOperation(value = "查询分页 根据员工考勤日志属性分页查询员工考勤日志信息列表", notes = "根据员工考勤日志属性分页查询员工考勤日志信息列表")
	@RequestMapping(value = "/employeejournals", method = RequestMethod.GET)
	public Object queryEmployeeJournalPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, EmployeeJournal employeeJournal) {				
		return employeeJournalService.queryEmployeeJournalForPage(pagenum, pagesize, sort, employeeJournal);
	}

}
