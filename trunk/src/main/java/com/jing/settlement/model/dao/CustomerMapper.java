package com.jing.settlement.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.settlement.model.entity.Customer;

/**
 * @ClassName: CustomerMapper
 * @Description: 客户映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Mapper
public interface CustomerMapper {

	/**
	 * @Title: addCustomer
	 * @Description:添加客户
	 * @param customer 实体
	 * @return Integer
	 */
	Integer addCustomer(Customer customer);
	
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
	 * @param pageBounds 分页信息
	 * @param customer 实体
	 * @return List<Customer>
	 */
	List<Customer> queryCustomerForPage(PageBounds pageBounds, @Param("customer") Customer customer);
	 
	 /**
	  * @Title: queryCustomerByProperty
	  * @Description:根据属性查询客户
	  * @return List<Customer>
	  */
	 List<Customer> queryCustomerByProperty(@Param("customer") Map<String, Object> map);
	 
	 
	 
}
