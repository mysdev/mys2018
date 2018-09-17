package com.jing.clock.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.clock.model.dao.ClockBroadcastMapper;
import com.jing.clock.model.entity.ClockBroadcast;
import com.jing.clock.service.ClockBroadcastService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: ClockBroadcast
 * @Description: 报钟播报服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("clockBroadcastService")
@Transactional(readOnly=true)
public class  ClockBroadcastServiceImpl implements ClockBroadcastService {	
//	private static final Logger logger = LoggerFactory.getLogger(ClockBroadcastServiceImpl.class);
	
	@Autowired
    private ClockBroadcastMapper clockBroadcastMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addClockBroadcast
	 * @Description:添加报钟播报
	 * @param clockBroadcast 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public ClockBroadcast addClockBroadcast(ClockBroadcast clockBroadcast){
		int ret = clockBroadcastMapper.addClockBroadcast(clockBroadcast);
		if(ret>0){
			return clockBroadcast;
		}
		return null;
	}
	
	/**
	 * @Title modifyClockBroadcast
	 * @Description:修改报钟播报
	 * @param clockBroadcast 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyClockBroadcast(ClockBroadcast clockBroadcast){
		return clockBroadcastMapper.modifyClockBroadcast(clockBroadcast);
	}
	
	/**
	 * @Title: dropClockBroadcastByBroadcastId
	 * @Description:删除报钟播报
	 * @param broadcastId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropClockBroadcastByBroadcastId(Integer broadcastId){
		return clockBroadcastMapper.dropClockBroadcastByBroadcastId(broadcastId);
	}
	
	/**
	 * @Title: queryClockBroadcastByBroadcastId
	 * @Description:根据实体标识查询报钟播报
	 * @param broadcastId 实体标识
	 * @return ClockBroadcast
	 */
	@Override
	public ClockBroadcast queryClockBroadcastByBroadcastId(Integer broadcastId){
		return clockBroadcastMapper.queryClockBroadcastByBroadcastId(broadcastId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryClockBroadcastForPage
	 * @Description: 根据报钟播报属性与分页信息分页查询报钟播报信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param clockBroadcast 实体
	 * @return List<ClockBroadcast>
	 */
	@Override
	public Map<String, Object> queryClockBroadcastForPage(Integer pagenum, Integer pagesize, String sort, ClockBroadcast clockBroadcast){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, ClockBroadcast.class);
		List<ClockBroadcast> entityList = clockBroadcastMapper.queryClockBroadcastForPage(pageBounds, clockBroadcast);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, ClockBroadcast.class);
		}
		if (!entityList.isEmpty()) {
			PageList<ClockBroadcast> pagelist = (PageList<ClockBroadcast>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryClockBroadcastByProperty
	 * @Description:根据属性查询报钟播报
	 * @return List<ClockBroadcast>
	 */
	@Override
	public List<ClockBroadcast> queryClockBroadcastByProperty(Map<String, Object> map){
		return clockBroadcastMapper.queryClockBroadcastByProperty(map);
	}


}
