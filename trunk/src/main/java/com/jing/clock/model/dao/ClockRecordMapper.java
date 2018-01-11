package com.jing.clock.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.clock.model.entity.ClockRecord;

/**
 * @ClassName: ClockRecordMapper
 * @Description: 应钟记录映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface ClockRecordMapper {

	/**
	 * @Title: addClockRecord
	 * @Description:添加应钟记录
	 * @param clockRecord 实体
	 * @return Integer
	 */
	Integer addClockRecord(ClockRecord clockRecord);
	
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
	 * @param pageBounds 分页信息
	 * @param clockRecord 实体
	 * @return List<ClockRecord>
	 */
	List<ClockRecord> queryClockRecordForPage(PageBounds pageBounds, @Param("clockRecord") ClockRecord clockRecord);
	 
	 /**
	  * @Title: queryClockRecordByProperty
	  * @Description:根据属性查询应钟记录
	  * @return List<ClockRecord>
	  */
	 List<ClockRecord> queryClockRecordByProperty(@Param("clockRecord") Map<String, Object> map);
	 
	 
	 
}
