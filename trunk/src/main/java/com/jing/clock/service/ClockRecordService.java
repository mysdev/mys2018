package com.jing.clock.service;

import java.util.List;
import java.util.Map;


import com.jing.clock.model.entity.ClockRecord;

/**
 * @ClassName: ClockRecord
 * @Description: 应钟记录服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface ClockRecordService {

    /**
	 * @Title: addClockRecord
	 * @Description:添加应钟记录
	 * @param clockRecord 实体
	 * @return Integer
	 */
	ClockRecord addClockRecord(ClockRecord clockRecord);
	
	/**
	 * @Title modifyClockRecord
	 * @Description:修改应钟记录
	 * @param clockRecord 实体
	 * @return Integer
	 */
	Integer modifyClockRecord(ClockRecord clockRecord);
	
	/**
	 * @Title: dropClockRecordByRecordId
	 * @Description:删除应钟记录
	 * @param recordId 实体标识
	 * @return Integer
	 */
	Integer dropClockRecordByRecordId(Integer recordId);
	
	/**
	 * @Title: queryClockRecordByRecordId
	 * @Description:根据实体标识查询应钟记录
	 * @param recordId 实体标识
	 * @return ClockRecord
	 */
	ClockRecord queryClockRecordByRecordId(Integer recordId);
	 
	/**
	 * @Title: queryClockRecordForPage
	 * @Description: 根据应钟记录属性与分页信息分页查询应钟记录信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param clockRecord 实体
	 * @return List<ClockRecord>
	 */
	Map<String, Object> queryClockRecordForPage(Integer pagenum, Integer pagesize, String sort, ClockRecord clockRecord);
	 
	 /**
	 * @Title: queryClockRecordByProperty
	 * @Description:根据属性查询应钟记录
	 * @return List<ClockRecord>
	 */
	 List<ClockRecord> queryClockRecordByProperty(Map<String, Object> map);	 
	 
}
