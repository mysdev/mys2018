package com.jing.core.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.utils.BaseController;
import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.core.model.entity.EmployeeCommission;
import com.jing.core.service.EmployeeCommissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>员工提成 WEB接口<br>
 * <br>
 */
@Api("员工提成")
@Controller
@RequestMapping("/core/employeeCommission")
public class EmployeeCommissionController extends BaseController{

	@Autowired
	private EmployeeCommissionService employeeCommissionService;
	
	@ApiOperation(value = "新增员工提成", notes = "添加员工提成")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(EmployeeCommission employeeCommission,@SessionAttr(Config.USER_INFO) User user) {
		employeeCommission.setCreatedBy(user.getUserId());
		employeeCommission.setCreatedDateNow();
		employeeCommission.setUpdatedBy(user.getUserId());
		employeeCommission.setUpdatedDateNow();
		employeeCommissionService.addEmployeeCommission(employeeCommission);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改员工提成", notes = "修改员工提成")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(EmployeeCommission employeeCommission,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(employeeCommission==null || employeeCommission.getCid()==null){
			throw new CustomException("缺失修改参数.");
		}
		employeeCommission.setUpdatedBy(user.getUserId());
		employeeCommission.setUpdatedDateNow();
		employeeCommissionService.updateEmployeeCommission(employeeCommission);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除员工提成", notes = "根据ID删除员工提成")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null){
			throw new CustomException("缺失删除参数.");
		}
		employeeCommissionService.deleteEmployeeCommissionById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询员工提成", notes = "根据ID查询员工提成")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(employeeCommissionService.getEmployeeCommissionById(id));
	}
		
	@ApiOperation(value = "分页查询员工提成", notes = "分页查询员工提成")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return employeeCommissionService.findEmployeeCommissionListPage(PageRequestUtils.getPageBean(request), map);
	}
}