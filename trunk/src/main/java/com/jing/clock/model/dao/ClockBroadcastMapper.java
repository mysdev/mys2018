package com.jing.clock.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.clock.model.entity.ClockBroadcast;

/**
 * @ClassName: ClockBroadcastMapper
 * @Description: 报钟播报映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface ClockBroadcastMapper {

	/**
	 * @Title: addClockBroadcast
	 * @Description:添加报钟播报
	 * @param clockBroadcast 实体
	 * @return Integer
	 */
	Integer addClockBroadcast(ClockBroadcast clockBroadcast);
	
	/**
	 * @Title modifyClockBroadcast
	 * @Description:修改报钟播报
	 * @param clockBroadcast 实体
	 * @return Integer
	 */
	Integer modifyClockBroadcast(ClockBroadcast clockBroadcast);
	
	/**
	 * @Title: dropClockBroadcastByBroadcastId
	 * @Description:删除报钟播报
	 * @param broadcastId 实体标识
	 * @return Integer
	 */
	Integer dropClockBroadcastByBroadcastId(Integer broadcastId);
	
	/**
	 * @Title: queryClockBroadcastByBroadcastId
	 * @Description:根据实体标识查询报钟播报
	 * @param broadcastId 实体标识
	 * @return ClockBroadcast
	 */
	ClockBroadcast queryClockBroadcastByBroadcastId(Integer broadcastId);
	 
	/**
	 * @Title: queryClockBroadcastForPage
	 * @Description: 根据报钟播报属性与分页信息分页查询报钟播报信息
	 * @param pageBounds 分页信息
	 * @param clockBroadcast 实体
	 * @return List<ClockBroadcast>
	 */
	List<ClockBroadcast> queryClockBroadcastForPage(PageBounds pageBounds, @Param("clockBroadcast") ClockBroadcast clockBroadcast);
	 
	 /**
	  * @Title: queryClockBroadcastByProperty
	  * @Description:根据属性查询报钟播报
	  * @return List<ClockBroadcast>
	  */
	 List<ClockBroadcast> queryClockBroadcastByProperty(@Param("clockBroadcast") Map<String, Object> map);
	 
	 
	 
}
