package com.jing.system.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.system.model.entity.Log;

/**
 * @ClassName: LogMapper
 * @Description: 日志映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Mapper
public interface LogMapper {

	/**
	 * @Title: addLog
	 * @Description:添加日志
	 * @param log 实体
	 * @return Integer
	 */
	Integer addLog(Log log);
	
	/**
	 * @Title modifyLog
	 * @Description:修改日志
	 * @param log 实体
	 * @return Integer
	 */
	Integer modifyLog(Log log);
	
	/**
	 * @Title: dropLogByLogId
	 * @Description:删除日志
	 * @param logId 实体标识
	 * @return Integer
	 */
	Integer dropLogByLogId(Integer logId);
	
	/**
	 * @Title: queryLogByLogId
	 * @Description:根据实体标识查询日志
	 * @param logId 实体标识
	 * @return Log
	 */
	Log queryLogByLogId(Integer logId);
	 
	/**
	 * @Title: queryLogForPage
	 * @Description: 根据日志属性与分页信息分页查询日志信息
	 * @param pageBounds 分页信息
	 * @param log 实体
	 * @return List<Log>
	 */
	List<Log> queryLogForPage(PageBounds pageBounds, @Param("log") Log log);
	 
	 /**
	  * @Title: queryLogByProperty
	  * @Description:根据属性查询日志
	  * @return List<Log>
	  */
	 List<Log> queryLogByProperty(@Param("log") Map<String, Object> map);
	 
	 
	 
}
