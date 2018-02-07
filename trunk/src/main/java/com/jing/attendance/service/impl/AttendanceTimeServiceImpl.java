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


import com.jing.attendance.model.entity.AttendanceTime;
import com.jing.attendance.model.dao.AttendanceTimeMapper;
import com.jing.attendance.service.AttendanceDetailService;
import com.jing.attendance.service.AttendanceTimeService;

/**
 * @ClassName: AttendanceTime
 * @Description: 考勤时段 一个考勤方案至多三个时段服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月05日 09时32分
 */
@Service("attendanceTimeService")
@Transactional(readOnly=true)
public class  AttendanceTimeServiceImpl implements AttendanceTimeService {	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceTimeServiceImpl.class);
	
	@Autowired
    private AttendanceTimeMapper attendanceTimeMapper;  
	
	@Autowired
	private AttendanceDetailService attendanceDetailService;
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addAttendanceTime
	 * @Description:添加考勤时段 一个考勤方案至多三个时段
	 * @param attendanceTime 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public AttendanceTime addAttendanceTime(AttendanceTime attendanceTime){
		int ret = attendanceTimeMapper.addAttendanceTime(attendanceTime);
		if(ret>0){
			return attendanceTime;
		}
		return null;
	}
	
	/**
	 * @Title modifyAttendanceTime
	 * @Description:修改考勤时段 一个考勤方案至多三个时段
	 * @param attendanceTime 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyAttendanceTime(AttendanceTime attendanceTime){		
		Integer ret = attendanceTimeMapper.modifyAttendanceTime(attendanceTime);
		attendanceDetailService.modifyAttendanceDetailChange(attendanceTime.getAttendanceId(), this.queryAttendanceTimeById(attendanceTime.getId()), null);
		return ret;
	}
	
	/**
	 * @Title: dropAttendanceTimeById
	 * @Description:删除考勤时段 一个考勤方案至多三个时段
	 * @param id 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropAttendanceTimeById(Integer id){
		AttendanceTime at = this.queryAttendanceTimeById(id);
		Integer ret = attendanceTimeMapper.dropAttendanceTimeById(id);
		attendanceDetailService.modifyAttendanceDetailChange(at.getAttendanceId(), null, id);
		return ret;
	}
	
	/**
	 * @Title: queryAttendanceTimeById
	 * @Description:根据实体标识查询考勤时段 一个考勤方案至多三个时段
	 * @param id 实体标识
	 * @return AttendanceTime
	 */
	@Override
	public AttendanceTime queryAttendanceTimeById(Integer id){
		return attendanceTimeMapper.queryAttendanceTimeById(id);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryAttendanceTimeForPage
	 * @Description: 根据考勤时段 一个考勤方案至多三个时段属性与分页信息分页查询考勤时段 一个考勤方案至多三个时段信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param attendanceTime 实体
	 * @return List<AttendanceTime>
	 */
	@Override
	public Map<String, Object> queryAttendanceTimeForPage(Integer pagenum, Integer pagesize, String sort, AttendanceTime attendanceTime){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, AttendanceTime.class);
		List<AttendanceTime> entityList = attendanceTimeMapper.queryAttendanceTimeForPage(pageBounds, attendanceTime);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, AttendanceTime.class);
		}
		if (!entityList.isEmpty()) {
			PageList<AttendanceTime> pagelist = (PageList<AttendanceTime>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryAttendanceTimeByProperty
	 * @Description:根据属性查询考勤时段 一个考勤方案至多三个时段
	 * @return List<AttendanceTime>
	 */
	@Override
	public List<AttendanceTime> queryAttendanceTimeByProperty(Map<String, Object> map){
		return attendanceTimeMapper.queryAttendanceTimeByProperty(map);
	}


}
