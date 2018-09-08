package com.jing.attendance.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.attendance.controller.vo.AttendanceBo;
import com.jing.attendance.model.dao.AttendanceDetailMapper;
import com.jing.attendance.model.entity.AttendanceDetail;
import com.jing.attendance.model.entity.AttendanceTime;
import com.jing.attendance.service.AttendanceDetailService;
import com.jing.attendance.service.AttendanceService;
import com.jing.attendance.service.PublicAttendanceService;
import com.jing.config.web.exception.CustomException;
import com.jing.utils.Constant;
import com.jing.utils.DateUtil;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

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
	private AttendanceService attendanceService;
	
	@Autowired
	private PublicAttendanceService publicAttendanceService;
    
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
		//TODO 执行员工末来考勤数据初始化
		Integer ret = attendanceDetailMapper.dropAttendanceDetailByAttId(attId);
		publicAttendanceService.doAndRedoPersonAttendanceByAttendanceId(attId);
		return ret;
	}
	

	/**
	 * @Title: disableDetailEditable
	 * @Description:锁定当天考勤详情
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer disableDetailEditable(){
		return attendanceDetailMapper.disableDetailEditable();
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
	* @Title: queryAttendanceDetail 
	* @Description: 查询考勤详情 没有时生成考勤详情
	* @param attendanceId 考勤标识
	* @param yearMonth 月份 为空时取当前月
	* @return  List<AttendanceDetail>    返回类型 
	* @throws 
	*/
	@Override
	@Transactional(readOnly = false)
	public List<AttendanceDetail> queryAttendanceDetail(Integer attendanceId, String yearMonth){
		if(yearMonth==null || yearMonth.length()!=7){
			yearMonth = DateUtil.getDate();
			yearMonth = yearMonth.substring(0, yearMonth.lastIndexOf("-"));
		}
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("attendanceId", attendanceId);
		query.put("attMonth", yearMonth);
		List<AttendanceDetail> ret = queryAttendanceDetailByProperty(query);		
		if(ret!=null && ret.size()>0){
			return ret;//已有数据，不再生成
		}
		
		AttendanceBo ab = attendanceService.queryAttendanceByAttendanceId(attendanceId);
		AttendanceTime at = ab.getAttTime().get(0);
		
		ret = new ArrayList<AttendanceDetail>();
		try {
			Calendar cal = DateUtil.getCalendar(yearMonth);
			int maxDay = cal.getActualMaximum(Calendar.DATE);
			int week = cal.get(Calendar.DAY_OF_WEEK-1);
			for(int i=0; i<maxDay; i++){
				AttendanceDetail ad = new AttendanceDetail();
				ad.setTimeId(at.getId());
				ad.setSignTime(DateUtil.String2DateTime(yearMonth+"-"+(i+1)+" "+at.getSignTime()));
				ad.setOutTime(DateUtil.String2DateTime(yearMonth+"-"+(i+1)+" "+at.getOutTime()));
				if(ad.getSignTime().getTime()>ad.getOutTime().getTime()) {
					//结束时间  跨天处理
					Calendar cala = Calendar.getInstance();
					cala.setTime(ad.getOutTime());
					cala.set(Calendar.DATE, cala.get(Calendar.DATE)+1);
					ad.setOutTime(cala.getTime());
				}
				
				ad.setAttendanceId(attendanceId);
				ad.setAttMonth(yearMonth);
				ad.setWeekday((week+i)%7);
				if(ad.getWeekday().intValue()==0){
					ad.setWeekday(7);
				}
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
			//TODO 执行员工末来考勤数据初始化
			publicAttendanceService.doAndRedoPersonAttendanceByAttendanceId(attendanceId);
		} catch (ParseException e) {			
			logger.error("(yyyy-MM)年月格式转换异常，参数："+yearMonth, e);
			throw new CustomException(400, "参数错误", "yearMonth", "格式非七位(yyyy-MM)日期。");
		}
		return ret;
	}

	@Override
	public List<String> queryAttendanceDetailHistory(Integer attendanceId) {
		return attendanceDetailMapper.queryAttendanceDetailHistory(attendanceId);
	}

	@Override
	@Transactional(readOnly = false)
	public Integer modifyAttendanceDetailBatch(AttendanceDetail[] attendanceList) {
		int ret = 0;
		Integer attendanceId = attendanceList[0].getAttendanceId();
		for(AttendanceDetail ad : attendanceList){
			ret+=attendanceDetailMapper.modifyAttendanceDetail(ad);
		}
		//TODO 执行员工末来考勤数据初始化
		publicAttendanceService.doAndRedoPersonAttendanceByAttendanceId(attendanceId);
		return ret;
	}

	/*
	 * @Title: modifyAttendanceDetailChange
	 * @Description: 
	 * @param @param attendanceId
	 * @param @param attendanceTime
	 * @param @return    参数  
	 * @author Jinlong He
	 * @param attendanceId
	 * @param attendanceTime
	 * @return
	 * @see com.jing.attendance.service.AttendanceDetailService#modifyAttendanceDetailChange(java.lang.Integer, com.jing.attendance.model.entity.AttendanceTime)
	 */ 
	@Override
	public Integer modifyAttendanceDetailChange(Integer attendanceId, AttendanceTime attendanceTime, Integer oldId) {
		if(attendanceTime==null || attendanceTime.getId()==null) {
			AttendanceBo ab = attendanceService.queryAttendanceByAttendanceId(attendanceId);
			attendanceTime = ab.getAttTime().get(0);
		}
		if(attendanceTime==null) {
			attendanceTime = new AttendanceTime();
		}
		if(attendanceTime.getSignTime()==null) attendanceTime.setSignTime("08:30:00");
		if(attendanceTime.getOutTime()==null) attendanceTime.setOutTime("17:30:00");
		attendanceTime.setAttendanceId(attendanceId);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("attendanceId", attendanceTime.getAttendanceId());
		params.put("signTime", attendanceTime.getSignTime());
		params.put("outTime", attendanceTime.getOutTime());
		params.put("timeId", attendanceTime.getId());
		if(oldId!=null && oldId.intValue()>0) {
			params.put("oldTimeId", oldId);
		}
		Integer ret = attendanceDetailMapper.modifyAttendanceDetailChange(params);
		attendanceDetailMapper.modifyOutTimeBefore();
		//TODO 执行员工末来考勤数据初始化
		publicAttendanceService.doAndRedoPersonAttendanceByAttendanceId(attendanceId);
		return ret;
	}
	
//	
//	public static void main(String[] arg) {
//		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		String startTime ="21:30:00";
//		String endTime = "08:30:00";
//		try {
//			Date startDate = DateUtil.String2DateTime("2018-02-05 "+startTime);
//			Date endDate = DateUtil.String2DateTime("2018-02-05 "+endTime);
//			
//			if(startDate.getTime()>endDate.getTime()) {
//				//结束时间  跨天处理
//				Calendar cala = Calendar.getInstance();
//				cala.setTime(endDate);
//				cala.set(Calendar.DATE, cala.get(Calendar.DATE)+1);
//				endDate = cala.getTime();
//			}
//			
//			System.out.println(format.format(startDate));
//			System.out.println(format.format(endDate));
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	

}
