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
import com.jing.utils.DateUtil;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.attendance.model.entity.EmployeeAttend;
import com.jing.attendance.model.dao.EmployeeAttendMapper;
import com.jing.attendance.service.EmployeeAttendService;

/**
 * @ClassName: EmployeeAttend
 * @Description: 打卡记录服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("employeeAttendService")
@Transactional(readOnly=true)
public class  EmployeeAttendServiceImpl implements EmployeeAttendService {	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeAttendServiceImpl.class);
	
	@Autowired
    private EmployeeAttendMapper employeeAttendMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addEmployeeAttend
	 * @Description:添加打卡记录
	 * @param employeeAttend 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public EmployeeAttend addEmployeeAttend(EmployeeAttend employeeAttend){
		int ret = employeeAttendMapper.addEmployeeAttend(employeeAttend);
		if(ret>0){
			return employeeAttend;
		}
		return null;
	}
	
	/**
	 * @Title modifyEmployeeAttend
	 * @Description:修改打卡记录
	 * @param employeeAttend 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyEmployeeAttend(EmployeeAttend employeeAttend){
		return employeeAttendMapper.modifyEmployeeAttend(employeeAttend);
	}
	
	/**
	 * @Title: dropEmployeeAttendByAttId
	 * @Description:删除打卡记录
	 * @param attId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropEmployeeAttendByAttId(Integer attId){
		return employeeAttendMapper.dropEmployeeAttendByAttId(attId);
	}
	
	/**
	 * @Title: queryEmployeeAttendByEmployeeId
	 * @Description:根据员工标识查询打卡记录
	 * @param empId 员工标识
	 * @return EmployeeAttend
	 */
	@Override
	public List<EmployeeAttend> queryEmployeeAttendByEmployeeId(String empId, String yearMonth){
		if(yearMonth==null || yearMonth.length()!=7){
			yearMonth = DateUtil.getDateYyyyMM();
		}
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("employeeId", empId);
		query.put("yearMonth", yearMonth);
		return employeeAttendMapper.queryEmployeeAttendByProperty(query);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryEmployeeAttendForPage
	 * @Description: 根据打卡记录属性与分页信息分页查询打卡记录信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param employeeAttend 实体
	 * @return List<EmployeeAttend>
	 */
	@Override
	public Map<String, Object> queryEmployeeAttendForPage(Integer pagenum, Integer pagesize, String sort, Map<String, Object> map){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, EmployeeAttend.class);
		List<EmployeeAttend> entityList = employeeAttendMapper.queryEmployeeAttendForPage(pageBounds, map);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, EmployeeAttend.class);
		}
		if (!entityList.isEmpty()) {
			PageList<EmployeeAttend> pagelist = (PageList<EmployeeAttend>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryEmployeeAttendByProperty
	 * @Description:根据属性查询打卡记录
	 * @return List<EmployeeAttend>
	 */
	@Override
	public List<EmployeeAttend> queryEmployeeAttendByProperty(Map<String, Object> map){
		return employeeAttendMapper.queryEmployeeAttendByProperty(map);
	}


}
