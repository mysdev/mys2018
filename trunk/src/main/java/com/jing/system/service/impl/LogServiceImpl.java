package com.jing.system.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.system.model.entity.Log;
import com.jing.system.model.dao.LogMapper;
import com.jing.system.service.LogService;

/**
 * @ClassName: Log
 * @Description: 日志服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@Service("logService")
@Transactional(readOnly=true)
public class  LogServiceImpl implements LogService {

	@Autowired
    private LogMapper logMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addLog
	 * @Description:添加日志
	 * @param log 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Log addLog(Log log){
		int ret = logMapper.addLog(log);
		if(ret>0){
			return log;
		}
		return null;
	}
	
	/**
	 * @Title modifyLog
	 * @Description:修改日志
	 * @param log 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyLog(Log log){
		return logMapper.modifyLog(log);
	}
	
	/**
	 * @Title: dropLogByLogId
	 * @Description:删除日志
	 * @param logId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropLogByLogId(Integer logId){
		return logMapper.dropLogByLogId(logId);
	}
	
	/**
	 * @Title: queryLogByLogId
	 * @Description:根据实体标识查询日志
	 * @param logId 实体标识
	 * @return Log
	 */
	@Override
	public Log queryLogByLogId(Integer logId){
		return logMapper.queryLogByLogId(logId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryLogForPage
	 * @Description: 根据日志属性与分页信息分页查询日志信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param log 实体
	 * @return List<Log>
	 */
	@Override
	public Map<String, Object> queryLogForPage(Integer pagenum, Integer pagesize, String sort, Log log){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Log.class);
		List<Log> entityList = logMapper.queryLogForPage(pageBounds, log);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Log.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Log> pagelist = (PageList<Log>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryLogByProperty
	 * @Description:根据属性查询日志
	 * @return List<Log>
	 */
	@Override
	public List<Log> queryLogByProperty(Map<String, Object> map){
		return logMapper.queryLogByProperty(map);
	}


}
