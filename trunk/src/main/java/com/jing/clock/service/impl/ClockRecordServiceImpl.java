package com.jing.clock.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.clock.model.dao.ClockRecordMapper;
import com.jing.clock.model.entity.ClockRecord;
import com.jing.clock.service.ClockRecordService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: ClockRecord
 * @Description: 应钟记录服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("clockRecordService")
@Transactional(readOnly=true)
public class  ClockRecordServiceImpl implements ClockRecordService {	
//	private static final Logger logger = LoggerFactory.getLogger(ClockRecordServiceImpl.class);
	
	@Autowired
    private ClockRecordMapper clockRecordMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addClockRecord
	 * @Description:添加应钟记录
	 * @param clockRecord 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public ClockRecord addClockRecord(ClockRecord clockRecord){
		int ret = clockRecordMapper.addClockRecord(clockRecord);
		if(ret>0){
			return clockRecord;
		}
		return null;
	}
	
	/**
	 * @Title modifyClockRecord
	 * @Description:修改应钟记录
	 * @param clockRecord 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyClockRecord(ClockRecord clockRecord){
		return clockRecordMapper.modifyClockRecord(clockRecord);
	}
	
	/**
	 * @Title: dropClockRecordByRecordId
	 * @Description:删除应钟记录
	 * @param recordId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropClockRecordByRecordId(Integer recordId){
		return clockRecordMapper.dropClockRecordByRecordId(recordId);
	}
	
	/**
	 * @Title: queryClockRecordByRecordId
	 * @Description:根据实体标识查询应钟记录
	 * @param recordId 实体标识
	 * @return ClockRecord
	 */
	@Override
	public ClockRecord queryClockRecordByRecordId(Integer recordId){
		return clockRecordMapper.queryClockRecordByRecordId(recordId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryClockRecordForPage
	 * @Description: 根据应钟记录属性与分页信息分页查询应钟记录信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param clockRecord 实体
	 * @return List<ClockRecord>
	 */
	@Override
	public Map<String, Object> queryClockRecordForPage(Integer pagenum, Integer pagesize, String sort, ClockRecord clockRecord){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, ClockRecord.class);
		List<ClockRecord> entityList = clockRecordMapper.queryClockRecordForPage(pageBounds, clockRecord);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, ClockRecord.class);
		}
		if (!entityList.isEmpty()) {
			PageList<ClockRecord> pagelist = (PageList<ClockRecord>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryClockRecordByProperty
	 * @Description:根据属性查询应钟记录
	 * @return List<ClockRecord>
	 */
	@Override
	public List<ClockRecord> queryClockRecordByProperty(Map<String, Object> map){
		return clockRecordMapper.queryClockRecordByProperty(map);
	}


}
