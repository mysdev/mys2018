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
import com.jing.attendance.model.entity.EmployeeAttend;
import com.jing.attendance.service.EmployeeAttendService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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

	
	@ApiOperation(value = "新增 添加打卡记录信息", notes = "添加打卡记录信息")
	@RequestMapping(value = "/employeeattend", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addEmployeeAttend(HttpServletResponse response,
			@ApiParam(value = "employeeAttend") @RequestBody EmployeeAttend employeeAttend) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employeeAttend, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		employeeAttend.setAttId(null);
		employeeAttendService.addEmployeeAttend(employeeAttend);
		return employeeAttend;
	}
	
	
	@ApiOperation(value = "更新 根据打卡记录标识更新打卡记录信息", notes = "根据打卡记录标识更新打卡记录信息")
	@RequestMapping(value = "/employeeattend/{attId:.+}", method = RequestMethod.PUT)
	public Object modifyEmployeeAttendById(HttpServletResponse response,
			@PathVariable Integer attId,
			@ApiParam(value = "employeeAttend", required = true) @RequestBody EmployeeAttend employeeAttend
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(employeeAttend, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		EmployeeAttend tempEmployeeAttend = employeeAttendService.queryEmployeeAttendByAttId(attId);
		employeeAttend.setAttId(attId);
		if(null == tempEmployeeAttend){
			throw new NotFoundException("打卡记录");
		}
		return employeeAttendService.modifyEmployeeAttend(employeeAttend);
	}

	@ApiOperation(value = "删除 根据打卡记录标识删除打卡记录信息", notes = "根据打卡记录标识删除打卡记录信息")
	@RequestMapping(value = "/employeeattend/{attId:.+}", method = RequestMethod.DELETE)
	public Object dropEmployeeAttendByAttId(HttpServletResponse response, @PathVariable Integer attId) {
		EmployeeAttend employeeAttend = employeeAttendService.queryEmployeeAttendByAttId(attId);
		if(null == employeeAttend){
			throw new NotFoundException("打卡记录");
		}
		return employeeAttendService.dropEmployeeAttendByAttId(attId);
	}
	
	@ApiOperation(value = "查询 根据打卡记录标识查询打卡记录信息", notes = "根据打卡记录标识查询打卡记录信息")
	@RequestMapping(value = "/employeeattend/{attId:.+}", method = RequestMethod.GET)
	public Object queryEmployeeAttendById(HttpServletResponse response,
			@PathVariable Integer attId) {
		EmployeeAttend employeeAttend = employeeAttendService.queryEmployeeAttendByAttId(attId);
		if(null == employeeAttend){
			throw new NotFoundException("打卡记录");
		}
		return employeeAttend;
	}
	
	@ApiOperation(value = "查询 根据打卡记录属性查询打卡记录信息列表", notes = "根据打卡记录属性查询打卡记录信息列表")
	@RequestMapping(value = "/employeeattend", method = RequestMethod.GET)
	public Object queryEmployeeAttendList(HttpServletResponse response,
			EmployeeAttend employeeAttend) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return employeeAttendService.queryEmployeeAttendByProperty(ClassUtil.transBean2Map(employeeAttend, false));
	}
	
	@ApiOperation(value = "查询分页 根据打卡记录属性分页查询打卡记录信息列表", notes = "根据打卡记录属性分页查询打卡记录信息列表")
	@RequestMapping(value = "/employeeattends", method = RequestMethod.GET)
	public Object queryEmployeeAttendPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, EmployeeAttend employeeAttend) {				
		return employeeAttendService.queryEmployeeAttendForPage(pagenum, pagesize, sort, employeeAttend);
	}

}
