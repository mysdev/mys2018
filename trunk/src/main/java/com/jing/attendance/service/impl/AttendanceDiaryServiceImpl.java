package com.jing.attendance.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.attendance.model.dao.AttendanceDiaryMapper;
import com.jing.attendance.model.entity.AttendanceDiary;
import com.jing.attendance.service.AttendanceDiaryService;
import com.jing.attendance.service.bo.AttendanceDiaryBo;
import com.jing.config.web.exception.CustomException;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

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

	@Override
	@Transactional(readOnly = false)
	public String processAttendanceDiary(String empId) {
		List<AttendanceDiaryBo> boList = attendanceDiaryMapper.queryEmployeeYesterdayToday(empId);
		if(boList==null || boList.size()==0) {
			throw new CustomException(400, "没有找到员工对应考勤需求。");
		}
		//根据时差绝对值取出最近的考勤
		AttendanceDiaryBo flag = boList.get(0);
		int min = boList.get(0).getSignCount();
		for(int i=0; i<boList.size(); i++) {
			int tempMin = Math.abs(boList.get(i).getSignCount());
			if(Math.abs(boList.get(i).getSignCount())>Math.abs(boList.get(i).getOutCount())) {
				tempMin = Math.abs(boList.get(i).getOutCount());
			}			
			if(i==0) {
				min = tempMin;				
			}else {
				if(tempMin<=min) {
					min = tempMin;
					flag = boList.get(i);
				}
			}			
		}
		
		//处理时差最近的考勤
		AttendanceDiary ad = new AttendanceDiary();
		ad.setAttId(flag.getAttId());
		if(Math.abs(flag.getSignCount())<Math.abs(flag.getOutCount())) {
			//签到
			if(flag.getSignTime()==null) {
				ad.setSignTime(flag.getSysSign()); //签到
				modifyAttendanceDiary(ad);
				return "签到成功。"+(flag.getSignCount()>0?"迟到"+flag.getSignCount()+"分钟":"");
			}else {
				return "今天已签到。";
			}
		}else {
			//签退
			ad.setOutTime(flag.getSysOut()); //签退
			modifyAttendanceDiary(ad);
			if(flag.getOutCount()<0) {
				return "未到签退时间，请于"+(Math.abs(flag.getOutCount()))+"分钟后即"+(new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒").format(flag.getSysOut()))+"前来签退。";
			}else {
				return "答退成功，感谢您的付出。";
			}
		}
	}

	@Override
	public Map<String, Object> queryAttendanceDiaryAllForPage(Integer pagenum, Integer pagesize, String sort,
			Map<String, Object> query) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJsonForMap(sort);
		List<Map<String, Object>> entityList = attendanceDiaryMapper.queryAttendanceDiaryAllForPage(pageBounds, query);
		//if (!entityList.isEmpty()) {
			PageList<Map<String, Object>> pagelist = (PageList<Map<String, Object>>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		//}
		return returnMap;
	}


}
