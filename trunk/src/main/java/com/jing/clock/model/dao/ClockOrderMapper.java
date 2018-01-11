package com.jing.clock.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.clock.model.entity.ClockOrder;

/**
 * @ClassName: ClockOrderMapper
 * @Description: 订单映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface ClockOrderMapper {

	/**
	 * @Title: addClockOrder
	 * @Description:添加订单
	 * @param clockOrder 实体
	 * @return Integer
	 */
	Integer addClockOrder(ClockOrder clockOrder);
	
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
	 * @param pageBounds 分页信息
	 * @param clockOrder 实体
	 * @return List<ClockOrder>
	 */
	List<ClockOrder> queryClockOrderForPage(PageBounds pageBounds, @Param("clockOrder") ClockOrder clockOrder);
	 
	 /**
	  * @Title: queryClockOrderByProperty
	  * @Description:根据属性查询订单
	  * @return List<ClockOrder>
	  */
	 List<ClockOrder> queryClockOrderByProperty(@Param("clockOrder") Map<String, Object> map);
	 
	 
	 
}
