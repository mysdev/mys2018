package com.jing.settlement.controller;

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
import com.jing.settlement.model.entity.Customer;
import com.jing.settlement.service.CustomerService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: CustomerController
 * @Description: 客户HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="客户", tags={"SettlementCustomer"})
public class CustomerController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private CustomerService customerService;

	
	@ApiOperation(value = "新增 添加客户信息", notes = "添加客户信息")
	@RequestMapping(value = "/customer", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addCustomer(HttpServletResponse response,
			@ApiParam(value = "customer") @RequestBody Customer customer) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(customer, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		customer.setCustomerId(null);
		customerService.addCustomer(customer);
		return customer;
	}
	
	
	@ApiOperation(value = "更新 根据客户标识更新客户信息", notes = "根据客户标识更新客户信息")
	@RequestMapping(value = "/customer/{customerId:.+}", method = RequestMethod.PUT)
	public Object modifyCustomerById(HttpServletResponse response,
			@PathVariable Integer customerId,
			@ApiParam(value = "customer", required = true) @RequestBody Customer customer
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(customer, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Customer tempCustomer = customerService.queryCustomerByCustomerId(customerId);
		customer.setCustomerId(customerId);
		if(null == tempCustomer){
			throw new NotFoundException("客户");
		}
		return customerService.modifyCustomer(customer);
	}

	@ApiOperation(value = "删除 根据客户标识删除客户信息", notes = "根据客户标识删除客户信息")
	@RequestMapping(value = "/customer/{customerId:.+}", method = RequestMethod.DELETE)
	public Object dropCustomerByCustomerId(HttpServletResponse response, @PathVariable Integer customerId) {
		Customer customer = customerService.queryCustomerByCustomerId(customerId);
		if(null == customer){
			throw new NotFoundException("客户");
		}
		return customerService.dropCustomerByCustomerId(customerId);
	}
	
	@ApiOperation(value = "查询 根据客户标识查询客户信息", notes = "根据客户标识查询客户信息")
	@RequestMapping(value = "/customer/{customerId:.+}", method = RequestMethod.GET)
	public Object queryCustomerById(HttpServletResponse response,
			@PathVariable Integer customerId) {
		Customer customer = customerService.queryCustomerByCustomerId(customerId);
		if(null == customer){
			throw new NotFoundException("客户");
		}
		return customer;
	}
	
	@ApiOperation(value = "查询 根据客户属性查询客户信息列表", notes = "根据客户属性查询客户信息列表")
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public Object queryCustomerList(HttpServletResponse response,
			Customer customer) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return customerService.queryCustomerByProperty(ClassUtil.transBean2Map(customer, false));
	}
	
	@ApiOperation(value = "查询分页 根据客户属性分页查询客户信息列表", notes = "根据客户属性分页查询客户信息列表")
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public Object queryCustomerPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Customer customer) {				
		return customerService.queryCustomerForPage(pagenum, pagesize, sort, customer);
	}

}
