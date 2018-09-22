package com.jing.core.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.utils.BaseController;
import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.core.model.entity.Employee;
import com.jing.core.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>员工 WEB接口<br>
 * <br>
 */
@Api("员工")
@Controller
@RequestMapping("/core/employee")
public class EmployeeController extends BaseController{

	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value = "新增员工", notes = "添加员工")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Employee employee,@SessionAttr(Config.USER_INFO) User user) {
		employee.setCreatedBy(user.getUserId());
		employee.setCreatedDateNow();
		employee.setUpdatedBy(user.getUserId());
		employee.setUpdatedDateNow();
		employeeService.addEmployee(employee);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改员工", notes = "修改员工")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Employee employee,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(employee==null || employee.getEmpId()==null || "".equals(employee.getEmpId())){
			throw new CustomException("缺失修改参数.");
		}
		employee.setUpdatedBy(user.getUserId());
		employee.setUpdatedDateNow();
		employeeService.updateEmployee(employee);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除员工", notes = "根据ID删除员工")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		employeeService.deleteEmployeeById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询员工", notes = "根据ID查询员工")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(employeeService.getEmployeeById(id));
	}
		
	@ApiOperation(value = "分页查询员工", notes = "分页查询员工")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return employeeService.findEmployeeListPage(PageRequestUtils.getPageBean(request), map);
	}
	
	
	@ApiOperation(value = "转用户", notes = "转用户")
	@RequestMapping(value = "/toUser", method = RequestMethod.POST)
	public @ResponseBody Result toUser(@RequestParam("empId") String empId,@RequestParam("username") String username,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		employeeService.toUser(empId, username);
		return Result.getDefaultSuccMsgResult();
	}
}