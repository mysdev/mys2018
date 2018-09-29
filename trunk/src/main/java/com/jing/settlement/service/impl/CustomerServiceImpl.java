package com.jing.settlement.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.settlement.model.entity.Customer;
import com.jing.settlement.model.dao.CustomerMapper;
import com.jing.settlement.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Resource
	private CustomerMapper customerMapper;

	/**
	* 添加 客户
	*/
	@Override
	public void addCustomer(Customer customer){
		customerMapper.addCustomer(customer);
	}
	
	/**
	* 修改 客户
	*/
	@Override
	public void updateCustomer(Customer customer){
		customerMapper.updateCustomer(customer);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteCustomerById(Integer id){
		customerMapper.deleteCustomerById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Customer getCustomerById(Integer id){
		return customerMapper.getCustomerById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findCustomerListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(customerMapper.findCustomerListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询客户
	 * @param param
	 * @return
	 */
	 @Override
	public List<Customer> findCustomerList(Map<String, Object> param){
		return customerMapper.findCustomerList(param);
	}
	
}