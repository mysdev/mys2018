package com.jing.clock.service;

import java.util.List;
import java.util.Map;


import com.jing.clock.model.entity.ClockBroadcast;

/**
 * @ClassName: ClockBroadcast
 * @Description: 报钟播报服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface ClockBroadcastService {

    /**
	 * @Title: addClockBroadcast
	 * @Description:添加报钟播报
	 * @param clockBroadcast 实体
	 * @return Integer
	 */
	ClockBroadcast addClockBroadcast(ClockBroadcast clockBroadcast);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param clockBroadcast 实体
	 * @return List<ClockBroadcast>
	 */
	Map<String, Object> queryClockBroadcastForPage(Integer pagenum, Integer pagesize, String sort, ClockBroadcast clockBroadcast);
	 
	 /**
	 * @Title: queryClockBroadcastByProperty
	 * @Description:根据属性查询报钟播报
	 * @return List<ClockBroadcast>
	 */
	 List<ClockBroadcast> queryClockBroadcastByProperty(Map<String, Object> map);	 
	 
}
