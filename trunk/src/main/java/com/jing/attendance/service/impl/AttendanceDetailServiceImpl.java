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


import com.jing.attendance.model.entity.AttendanceDetail;
import com.jing.attendance.model.dao.AttendanceDetailMapper;
import com.jing.attendance.service.AttendanceDetailService;

/**
 * @ClassName: AttendanceDetail
 * @Description: 门店考勤详情服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("attendanceDetailService")
@Transactional(readOnly=true)
public class  AttendanceDetailServiceImpl implements AttendanceDetailService {	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceDetailServiceImpl.class);
	
	@Autowired
    private AttendanceDetailMapper attendanceDetailMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addAttendanceDetail
	 * @Description:添加门店考勤详情
	 * @param attendanceDetail 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public AttendanceDetail addAttendanceDetail(AttendanceDetail attendanceDetail){
		int ret = attendanceDetailMapper.addAttendanceDetail(attendanceDetail);
		if(ret>0){
			return attendanceDetail;
		}
		return null;
	}
	
	/**
	 * @Title modifyAttendanceDetail
	 * @Description:修改门店考勤详情
	 * @param attendanceDetail 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyAttendanceDetail(AttendanceDetail attendanceDetail){
		return attendanceDetailMapper.modifyAttendanceDetail(attendanceDetail);
	}
	
	/**
	 * @Title: dropAttendanceDetailByAttId
	 * @Description:删除门店考勤详情
	 * @param attId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropAttendanceDetailByAttId(Integer attId){
		return attendanceDetailMapper.dropAttendanceDetailByAttId(attId);
	}
	
	/**
	 * @Title: queryAttendanceDetailByAttId
	 * @Description:根据实体标识查询门店考勤详情
	 * @param attId 实体标识
	 * @return AttendanceDetail
	 */
	@Override
	public AttendanceDetail queryAttendanceDetailByAttId(Integer attId){
		return attendanceDetailMapper.queryAttendanceDetailByAttId(attId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryAttendanceDetailForPage
	 * @Description: 根据门店考勤详情属性与分页信息分页查询门店考勤详情信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param attendanceDetail 实体
	 * @return List<AttendanceDetail>
	 */
	@Override
	public Map<String, Object> queryAttendanceDetailForPage(Integer pagenum, Integer pagesize, String sort, AttendanceDetail attendanceDetail){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, AttendanceDetail.class);
		List<AttendanceDetail> entityList = attendanceDetailMapper.queryAttendanceDetailForPage(pageBounds, attendanceDetail);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, AttendanceDetail.class);
		}
		if (!entityList.isEmpty()) {
			PageList<AttendanceDetail> pagelist = (PageList<AttendanceDetail>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryAttendanceDetailByProperty
	 * @Description:根据属性查询门店考勤详情
	 * @return List<AttendanceDetail>
	 */
	@Override
	public List<AttendanceDetail> queryAttendanceDetailByProperty(Map<String, Object> map){
		return attendanceDetailMapper.queryAttendanceDetailByProperty(map);
	}


}
