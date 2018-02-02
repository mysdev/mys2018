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


import com.jing.attendance.model.entity.EmployeeJournal;
import com.jing.attendance.model.dao.EmployeeJournalMapper;
import com.jing.attendance.service.EmployeeJournalService;

/**
 * @ClassName: EmployeeJournal
 * @Description: 员工考勤日志服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("employeeJournalService")
@Transactional(readOnly=true)
public class  EmployeeJournalServiceImpl implements EmployeeJournalService {	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeJournalServiceImpl.class);
	
	@Autowired
    private EmployeeJournalMapper employeeJournalMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addEmployeeJournal
	 * @Description:添加员工考勤日志
	 * @param employeeJournal 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public EmployeeJournal addEmployeeJournal(EmployeeJournal employeeJournal){
		int ret = employeeJournalMapper.addEmployeeJournal(employeeJournal);
		if(ret>0){
			return employeeJournal;
		}
		return null;
	}
	
	/**
	 * @Title modifyEmployeeJournal
	 * @Description:修改员工考勤日志
	 * @param employeeJournal 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyEmployeeJournal(EmployeeJournal employeeJournal){
		return employeeJournalMapper.modifyEmployeeJournal(employeeJournal);
	}
	
	/**
	 * @Title: dropEmployeeJournalByJournalId
	 * @Description:删除员工考勤日志
	 * @param journalId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropEmployeeJournalByJournalId(Integer journalId){
		return employeeJournalMapper.dropEmployeeJournalByJournalId(journalId);
	}
	
	/**
	 * @Title: queryEmployeeJournalByJournalId
	 * @Description:根据实体标识查询员工考勤日志
	 * @param journalId 实体标识
	 * @return EmployeeJournal
	 */
	@Override
	public EmployeeJournal queryEmployeeJournalByJournalId(Integer journalId){
		return employeeJournalMapper.queryEmployeeJournalByJournalId(journalId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryEmployeeJournalForPage
	 * @Description: 根据员工考勤日志属性与分页信息分页查询员工考勤日志信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param employeeJournal 实体
	 * @return List<EmployeeJournal>
	 */
	@Override
	public Map<String, Object> queryEmployeeJournalForPage(Integer pagenum, Integer pagesize, String sort, EmployeeJournal employeeJournal){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, EmployeeJournal.class);
		List<EmployeeJournal> entityList = employeeJournalMapper.queryEmployeeJournalForPage(pageBounds, employeeJournal);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, EmployeeJournal.class);
		}
		if (!entityList.isEmpty()) {
			PageList<EmployeeJournal> pagelist = (PageList<EmployeeJournal>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryEmployeeJournalByProperty
	 * @Description:根据属性查询员工考勤日志
	 * @return List<EmployeeJournal>
	 */
	@Override
	public List<EmployeeJournal> queryEmployeeJournalByProperty(Map<String, Object> map){
		return employeeJournalMapper.queryEmployeeJournalByProperty(map);
	}

	@Override
	public List<EmployeeJournal> queryEmployeeJournalByEmpId(String employeeId, String yearMonth) {
		if(yearMonth==null || yearMonth.length()!=7){
			yearMonth = DateUtil.getDateYyyyMM();
		}
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("employeeId", employeeId);
		query.put("yearMonth", yearMonth);
		return employeeJournalMapper.queryEmployeeJournalByProperty(query);
	}

	@Override
	public Map<String, Object> queryEmployeeJournalAllForPage(Integer pagenum, Integer pagesize, String sort, Map<String, Object> query) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, null);
		List<Map<String, Object>> entityList = employeeJournalMapper.queryEmployeeJournalAllForPage(pageBounds, query);
		
//		if (!entityList.isEmpty()) {
			PageList<Map<String, Object>> pagelist = (PageList<Map<String, Object>>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
//		}
		return returnMap;
	}


}
