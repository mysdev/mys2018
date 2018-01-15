package com.jing.attendance.service.impl;

import java.util.List;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.DateUtil;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.attendance.model.entity.AttendanceDetail;
import com.jing.attendance.model.dao.AttendanceDetailMapper;
import com.jing.attendance.service.AttendanceDetailService;
import com.jing.config.web.exception.CustomException;

/**
 * @ClassName: AttendanceDetail
 * @Description: 门店考勤详情服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月15日 09时43分
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

	/** 
	* @Title: createAttendanceDetail 
	* @Description: 生成考勤详情
	* @param attendanceId 考勤标识
	* @param yearMonth 待生成月份
	* @return  List<AttendanceDetail>    返回类型 
	* @throws 
	*/
	@Override
	@Transactional(readOnly = false)
	public List<AttendanceDetail> createAttendanceDetail(Integer attendanceId, String yearMonth){
		if(yearMonth==null || yearMonth.length()!=7){
			yearMonth = DateUtil.getDate();
			yearMonth.substring(0, yearMonth.lastIndexOf("-"));
		}
		List<AttendanceDetail> ret = queryAttendanceDetail(attendanceId, yearMonth);
		if(ret!=null && ret.size()>0){
			return ret;//已有数据，不再生成
		}
		ret = new ArrayList<AttendanceDetail>();
		try {
			Calendar cal = getCalendar(yearMonth);
			int maxDay = cal.getActualMaximum(Calendar.DATE);
			int week = cal.get(Calendar.DAY_OF_WEEK)-1;
			for(int i=0; i<maxDay; i++){
				AttendanceDetail ad = new AttendanceDetail();
				ad.setAttendanceId(attendanceId);
				ad.setAttMonth(yearMonth);
				ad.setWeekday((week+i)%7-1);
				if(ad.getWeekday().intValue()<6){
					ad.setAttendance(0);
				}else{
					ad.setAttendance(1);
				}	
				ad.setAttDay(i+1);
				ad.setAttDate(cal.getTime());
				cal.add(Calendar.DATE, 1);
				addAttendanceDetail(ad);
				ret.add(ad);
			}
		} catch (ParseException e) {			
			logger.error("(yyyy-MM)年月格式转换异常，参数："+yearMonth, e);
			throw new CustomException(400, "参数错误", "yearMonth", "格式非七位(yyyy-MM)日期。");
		}
		return ret;
	}
	
	private static Calendar getCalendar(String yearMonth) throws ParseException{
		yearMonth = yearMonth+"-01";		
		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(yearMonth);
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
	}
	
	/** 
	* @Title: queryAttendanceDetail 
	* @Description: 查询考勤详情
	* @param attendanceId 考勤标识
	* @param yearMonth 月份
	* @return  List<AttendanceDetail>    返回类型 
	* @throws 
	*/
	@Override
	public List<AttendanceDetail> queryAttendanceDetail(Integer attendanceId, String yearMonth){
		if(yearMonth==null || yearMonth.length()!=7){
			yearMonth = DateUtil.getDate();
			yearMonth.substring(0, yearMonth.lastIndexOf("-"));
		}
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("attendanceId", attendanceId);
		query.put("attMonth", yearMonth);
		return this.queryAttendanceDetailByProperty(query);
	}


}
