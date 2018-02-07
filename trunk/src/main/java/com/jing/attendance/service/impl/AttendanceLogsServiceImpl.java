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


import com.jing.attendance.model.entity.AttendanceLogs;
import com.jing.attendance.model.dao.AttendanceLogsMapper;
import com.jing.attendance.service.AttendanceLogsService;

/**
 * @ClassName: AttendanceLogs
 * @Description: 员工考勤记录表服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月07日 22时18分
 */
@Service("attendanceLogsService")
@Transactional(readOnly=true)
public class  AttendanceLogsServiceImpl implements AttendanceLogsService {	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceLogsServiceImpl.class);
	
	@Autowired
    private AttendanceLogsMapper attendanceLogsMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addAttendanceLogs
	 * @Description:添加员工考勤记录表
	 * @param attendanceLogs 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public AttendanceLogs addAttendanceLogs(AttendanceLogs attendanceLogs){
		int ret = attendanceLogsMapper.addAttendanceLogs(attendanceLogs);
		if(ret>0){
			return attendanceLogs;
		}
		return null;
	}
	
	/**
	 * @Title modifyAttendanceLogs
	 * @Description:修改员工考勤记录表
	 * @param attendanceLogs 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyAttendanceLogs(AttendanceLogs attendanceLogs){
		return attendanceLogsMapper.modifyAttendanceLogs(attendanceLogs);
	}
	
	/**
	 * @Title: dropAttendanceLogsById
	 * @Description:删除员工考勤记录表
	 * @param id 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropAttendanceLogsById(Integer id){
		return attendanceLogsMapper.dropAttendanceLogsById(id);
	}
	
	/**
	 * @Title: queryAttendanceLogsById
	 * @Description:根据实体标识查询员工考勤记录表
	 * @param id 实体标识
	 * @return AttendanceLogs
	 */
	@Override
	public AttendanceLogs queryAttendanceLogsById(Integer id){
		return attendanceLogsMapper.queryAttendanceLogsById(id);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryAttendanceLogsForPage
	 * @Description: 根据员工考勤记录表属性与分页信息分页查询员工考勤记录表信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param attendanceLogs 实体
	 * @return List<AttendanceLogs>
	 */
	@Override
	public Map<String, Object> queryAttendanceLogsForPage(Integer pagenum, Integer pagesize, String sort, AttendanceLogs attendanceLogs){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, AttendanceLogs.class);
		List<AttendanceLogs> entityList = attendanceLogsMapper.queryAttendanceLogsForPage(pageBounds, attendanceLogs);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, AttendanceLogs.class);
		}
		if (!entityList.isEmpty()) {
			PageList<AttendanceLogs> pagelist = (PageList<AttendanceLogs>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryAttendanceLogsByProperty
	 * @Description:根据属性查询员工考勤记录表
	 * @return List<AttendanceLogs>
	 */
	@Override
	public List<AttendanceLogs> queryAttendanceLogsByProperty(Map<String, Object> map){
		return attendanceLogsMapper.queryAttendanceLogsByProperty(map);
	}


}
