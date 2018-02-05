package com.jing.attendance.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.attendance.model.entity.AttendanceDiary;
import com.jing.attendance.model.dao.AttendanceDiaryMapper;
import com.jing.attendance.service.AttendanceDiaryService;

/**
 * @ClassName: AttendanceDiary
 * @Description: 打卡记录服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月05日 22时39分
 */
@Service("attendanceDiaryService")
@Transactional(readOnly=true)
public class  AttendanceDiaryServiceImpl implements AttendanceDiaryService {	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceDiaryServiceImpl.class);
	
	@Autowired
    private AttendanceDiaryMapper attendanceDiaryMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addAttendanceDiary
	 * @Description:添加打卡记录
	 * @param attendanceDiary 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public AttendanceDiary addAttendanceDiary(AttendanceDiary attendanceDiary){
		int ret = attendanceDiaryMapper.addAttendanceDiary(attendanceDiary);
		if(ret>0){
			return attendanceDiary;
		}
		return null;
	}
	
	/**
	 * @Title modifyAttendanceDiary
	 * @Description:修改打卡记录
	 * @param attendanceDiary 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyAttendanceDiary(AttendanceDiary attendanceDiary){
		return attendanceDiaryMapper.modifyAttendanceDiary(attendanceDiary);
	}
	
	/**
	 * @Title: dropAttendanceDiaryByAttId
	 * @Description:删除打卡记录
	 * @param attId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropAttendanceDiaryByAttId(Integer attId){
		return attendanceDiaryMapper.dropAttendanceDiaryByAttId(attId);
	}
	
	/**
	 * @Title: queryAttendanceDiaryByAttId
	 * @Description:根据实体标识查询打卡记录
	 * @param attId 实体标识
	 * @return AttendanceDiary
	 */
	@Override
	public AttendanceDiary queryAttendanceDiaryByAttId(Integer attId){
		return attendanceDiaryMapper.queryAttendanceDiaryByAttId(attId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryAttendanceDiaryForPage
	 * @Description: 根据打卡记录属性与分页信息分页查询打卡记录信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param attendanceDiary 实体
	 * @return List<AttendanceDiary>
	 */
	@Override
	public Map<String, Object> queryAttendanceDiaryForPage(Integer pagenum, Integer pagesize, String sort, AttendanceDiary attendanceDiary){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, AttendanceDiary.class);
		List<AttendanceDiary> entityList = attendanceDiaryMapper.queryAttendanceDiaryForPage(pageBounds, attendanceDiary);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, AttendanceDiary.class);
		}
		if (!entityList.isEmpty()) {
			PageList<AttendanceDiary> pagelist = (PageList<AttendanceDiary>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryAttendanceDiaryByProperty
	 * @Description:根据属性查询打卡记录
	 * @return List<AttendanceDiary>
	 */
	@Override
	public List<AttendanceDiary> queryAttendanceDiaryByProperty(Map<String, Object> map){
		return attendanceDiaryMapper.queryAttendanceDiaryByProperty(map);
	}


}
