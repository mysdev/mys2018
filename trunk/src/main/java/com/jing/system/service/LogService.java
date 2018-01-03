package com.jing.system.service;

import java.util.List;
import java.util.Map;


import com.jing.system.model.entity.Log;

/**
 * @ClassName: Log
 * @Description: 日志服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
public interface LogService {

    /**
	 * @Title: addLog
	 * @Description:添加日志
	 * @param log 实体
	 * @return Integer
	 */
	Log addLog(Log log);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param log 实体
	 * @return List<Log>
	 */
	Map<String, Object> queryLogForPage(Integer pagenum, Integer pagesize, String sort, Log log);
	 
	 /**
	 * @Title: queryLogByProperty
	 * @Description:根据属性查询日志
	 * @return List<Log>
	 */
	 List<Log> queryLogByProperty(Map<String, Object> map);	 
	 
}
