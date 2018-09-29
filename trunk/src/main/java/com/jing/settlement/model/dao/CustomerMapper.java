package com.jing.settlement.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.Customer;

@Mapper
public interface CustomerMapper {

	/**
	* 添加 客户
	*/
	void addCustomer(Customer customer);
	
	/**
	* 修改 客户
	*/
	void updateCustomer(Customer customer);
	
	/**
	*根据ID删除记录
	*/
	void deleteCustomerById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	Customer getCustomerById(Integer id);
	
	/**
	* 分页查询
	*/
	List<Customer> findCustomerListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询客户
	 * @param param
	 * @return
	 */
	List<Customer> findCustomerList(@Param("param") Map<String, Object> param);	
}