package com.jing.settlement.controller;

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
import com.jing.settlement.model.entity.Customer;
import com.jing.settlement.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>客户 WEB接口<br>
 * <br>
 */
@Api("客户")
@Controller
@RequestMapping("/settlement/customer")
public class CustomerController extends BaseController{

	@Autowired
	private CustomerService customerService;
	
	
	//第一个接口： 接待
	@ApiOperation(value = "新增客户", notes = "添加客户")
	@RequestMapping(value = "/addSimple", method = RequestMethod.POST)
	public @ResponseBody Result addSimple(Customer customer,@SessionAttr(Config.USER_INFO) User user) {
		
		customer.setCreatedBy(user.getUserId());
		customer.setCreatedDateNow();
		customer.setUpdatedBy(user.getUserId());
		customer.setUpdatedDateNow();
		customerService.addCustomer(customer);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "新增客户[开房]", notes = "添加客户")
	@RequestMapping(value = "/rentRoom", method = RequestMethod.POST)
	public @ResponseBody Result rentRoom(Customer customer,@SessionAttr(Config.USER_INFO) User user) {
		customer.setCreatedBy(user.getUserId());
		customer.setCreatedDateNow();
		customer.setUpdatedBy(user.getUserId());
		customer.setUpdatedDateNow();
		customerService.addCustomer(customer);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "新增客户【发手环】", notes = "添加客户")
	@RequestMapping(value = "/rentStrap", method = RequestMethod.POST)
	public @ResponseBody Result rentStrap(Customer customer,@SessionAttr(Config.USER_INFO) User user) {
		customer.setCreatedBy(user.getUserId());
		customer.setCreatedDateNow();
		customer.setUpdatedBy(user.getUserId());
		customer.setUpdatedDateNow();
		customerService.addCustomer(customer);
		return Result.getDefaultSuccMsgResult();
	}
	
	
	//第二个接口：开客房卡 或者 手环序列号
	@ApiOperation(value = "增加手环", notes = "给已有客户增发一个手环")
	@RequestMapping(value = "/addStrap", method = RequestMethod.POST)
	public @ResponseBody Result addStrap(Customer customer,@SessionAttr(Config.USER_INFO) User user) {
		customer.setCreatedBy(user.getUserId());
		customer.setCreatedDateNow();
		customer.setUpdatedBy(user.getUserId());
		customer.setUpdatedDateNow();
		customerService.addCustomer(customer);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "增加客房", notes = "给已有客户增开一个客房")
	@RequestMapping(value = "/addRoom", method = RequestMethod.POST)
	public @ResponseBody Result addRoom(Customer customer,@SessionAttr(Config.USER_INFO) User user) {
		customer.setCreatedBy(user.getUserId());
		customer.setCreatedDateNow();
		customer.setUpdatedBy(user.getUserId());
		customer.setUpdatedDateNow();
		customerService.addCustomer(customer);
		return Result.getDefaultSuccMsgResult();
	}
	
	
	//第三个接口， 删除房间或手环
	@ApiOperation(value = "取消授权码", notes = "在客户未使用时发起取消授权码")
	@RequestMapping(value = "/authorization/delete/{authorizationId}", method = RequestMethod.POST)
	public @ResponseBody Result delRoom(@PathVariable("authorizationId") String authorizationId,@SessionAttr(Config.USER_INFO) User user) {
	
		return Result.getDefaultSuccMsgResult();
	}
	
	
	
	
	@ApiOperation(value = "修改客户", notes = "修改客户")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Customer customer,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(customer==null || customer.getCustomerId()==null || "".equals(customer.getCustomerId())){
			throw new CustomException("缺失修改参数.");
		}
		customer.setUpdatedBy(user.getUserId());
		customer.setUpdatedDateNow();
		customerService.updateCustomer(customer);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除客户", notes = "根据ID删除客户")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		customerService.deleteCustomerById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询客户", notes = "根据ID查询客户")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(customerService.getCustomerById(id));
	}
		
	@ApiOperation(value = "分页查询客户", notes = "分页查询客户")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return customerService.findCustomerListPage(PageRequestUtils.getPageBean(request), map);
	}
}