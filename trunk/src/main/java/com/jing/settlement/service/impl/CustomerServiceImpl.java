package com.jing.settlement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.settlement.model.dao.CustomerMapper;
import com.jing.settlement.model.entity.Customer;
import com.jing.settlement.service.CustomerService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Customer
 * @Description: 客户服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("customerService")
@Transactional(readOnly=true)
public class  CustomerServiceImpl implements CustomerService {	
//	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
    private CustomerMapper customerMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addCustomer
	 * @Description:添加客户
	 * @param customer 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Customer addCustomer(Customer customer){
		int ret = customerMapper.addCustomer(customer);
		if(ret>0){
			return customer;
		}
		return null;
	}
	
	/**
	 * @Title modifyCustomer
	 * @Description:修改客户
	 * @param customer 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyCustomer(Customer customer){
		return customerMapper.modifyCustomer(customer);
	}
	
	/**
	 * @Title: dropCustomerByCustomerId
	 * @Description:删除客户
	 * @param customerId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropCustomerByCustomerId(Integer customerId){
		return customerMapper.dropCustomerByCustomerId(customerId);
	}
	
	/**
	 * @Title: queryCustomerByCustomerId
	 * @Description:根据实体标识查询客户
	 * @param customerId 实体标识
	 * @return Customer
	 */
	@Override
	public Customer queryCustomerByCustomerId(Integer customerId){
		return customerMapper.queryCustomerByCustomerId(customerId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryCustomerForPage
	 * @Description: 根据客户属性与分页信息分页查询客户信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param customer 实体
	 * @return List<Customer>
	 */
	@Override
	public Map<String, Object> queryCustomerForPage(Integer pagenum, Integer pagesize, String sort, Customer customer){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Customer.class);
		List<Customer> entityList = customerMapper.queryCustomerForPage(pageBounds, customer);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Customer.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Customer> pagelist = (PageList<Customer>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryCustomerByProperty
	 * @Description:根据属性查询客户
	 * @return List<Customer>
	 */
	@Override
	public List<Customer> queryCustomerByProperty(Map<String, Object> map){
		return customerMapper.queryCustomerByProperty(map);
	}


}
