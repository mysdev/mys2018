package com.jing.clock.service;

import java.util.List;
import java.util.Map;


import com.jing.clock.model.entity.ClockOrder;

/**
 * @ClassName: ClockOrder
 * @Description: 订单服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface ClockOrderService {

    /**
	 * @Title: addClockOrder
	 * @Description:添加订单
	 * @param clockOrder 实体
	 * @return Integer
	 */
	ClockOrder addClockOrder(ClockOrder clockOrder);
	
	/**
	 * @Title modifyClockOrder
	 * @Description:修改订单
	 * @param clockOrder 实体
	 * @return Integer
	 */
	Integer modifyClockOrder(ClockOrder clockOrder);
	
	/**
	 * @Title: dropClockOrderByOrderId
	 * @Description:删除订单
	 * @param orderId 实体标识
	 * @return Integer
	 */
	Integer dropClockOrderByOrderId(Integer orderId);
	
	/**
	 * @Title: queryClockOrderByOrderId
	 * @Description:根据实体标识查询订单
	 * @param orderId 实体标识
	 * @return ClockOrder
	 */
	ClockOrder queryClockOrderByOrderId(Integer orderId);
	 
	/**
	 * @Title: queryClockOrderForPage
	 * @Description: 根据订单属性与分页信息分页查询订单信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param clockOrder 实体
	 * @return List<ClockOrder>
	 */
	Map<String, Object> queryClockOrderForPage(Integer pagenum, Integer pagesize, String sort, ClockOrder clockOrder);
	 
	 /**
	 * @Title: queryClockOrderByProperty
	 * @Description:根据属性查询订单
	 * @return List<ClockOrder>
	 */
	 List<ClockOrder> queryClockOrderByProperty(Map<String, Object> map);	 
	 
}
