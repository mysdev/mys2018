package com.jing.settlement.service;

import java.util.List;
import java.util.Map;


import com.jing.settlement.model.entity.Customer;

/**
 * @ClassName: Customer
 * @Description: 客户服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public interface CustomerService {

    /**
	 * @Title: addCustomer
	 * @Description:添加客户
	 * @param customer 实体
	 * @return Integer
	 */
	Customer addCustomer(Customer customer);
	
	/**
	 * @Title modifyCustomer
	 * @Description:修改客户
	 * @param customer 实体
	 * @return Integer
	 */
	Integer modifyCustomer(Customer customer);
	
	/**
	 * @Title: dropCustomerByCustomerId
	 * @Description:删除客户
	 * @param customerId 实体标识
	 * @return Integer
	 */
	Integer dropCustomerByCustomerId(Integer customerId);
	
	/**
	 * @Title: queryCustomerByCustomerId
	 * @Description:根据实体标识查询客户
	 * @param customerId 实体标识
	 * @return Customer
	 */
	Customer queryCustomerByCustomerId(Integer customerId);
	 
	/**
	 * @Title: queryCustomerForPage
	 * @Description: 根据客户属性与分页信息分页查询客户信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param customer 实体
	 * @return List<Customer>
	 */
	Map<String, Object> queryCustomerForPage(Integer pagenum, Integer pagesize, String sort, Customer customer);
	 
	 /**
	 * @Title: queryCustomerByProperty
	 * @Description:根据属性查询客户
	 * @return List<Customer>
	 */
	 List<Customer> queryCustomerByProperty(Map<String, Object> map);	 
	 
}
