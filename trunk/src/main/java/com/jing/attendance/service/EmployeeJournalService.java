package com.jing.attendance.service;

import java.util.List;
import java.util.Map;

import com.jing.attendance.model.entity.EmployeeJournal;

/**
 * @ClassName: EmployeeJournal
 * @Description: 员工考勤日志服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public interface EmployeeJournalService {

    /**
	 * @Title: addEmployeeJournal
	 * @Description:添加员工考勤日志
	 * @param employeeJournal 实体
	 * @return Integer
	 */
	EmployeeJournal addEmployeeJournal(EmployeeJournal employeeJournal);
	
	/**
	 * @Title modifyEmployeeJournal
	 * @Description:修改员工考勤日志
	 * @param employeeJournal 实体
	 * @return Integer
	 */
	Integer modifyEmployeeJournal(EmployeeJournal employeeJournal);
	
	/**
	 * @Title: dropEmployeeJournalByJournalId
	 * @Description:删除员工考勤日志
	 * @param journalId 实体标识
	 * @return Integer
	 */
	Integer dropEmployeeJournalByJournalId(Integer journalId);
	
	/**
	 * @Title: queryEmployeeJournalByJournalId
	 * @Description:根据实体标识查询员工考勤日志
	 * @param journalId 实体标识
	 * @return EmployeeJournal
	 */
	EmployeeJournal queryEmployeeJournalByJournalId(Integer journalId);
	 
	/**
	 * @Title: queryEmployeeJournalForPage
	 * @Description: 根据员工考勤日志属性与分页信息分页查询员工考勤日志信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param employeeJournal 实体
	 * @return List<EmployeeJournal>
	 */
	Map<String, Object> queryEmployeeJournalForPage(Integer pagenum, Integer pagesize, String sort, EmployeeJournal employeeJournal);
	 
	 /**
	 * @Title: queryEmployeeJournalByProperty
	 * @Description:根据属性查询员工考勤日志
	 * @return List<EmployeeJournal>
	 */
	 List<EmployeeJournal> queryEmployeeJournalByProperty(Map<String, Object> map);

	/** 
	* @Title: queryEmployeeJournalByEmpId 
	* @Description: 查询员工指定月份考勤日志
	* @param employeeId
	* @param yearMonth 为空时查当月
	* @return  List<EmployeeJournal>    返回类型 
	* @throws 
	*/
	List<EmployeeJournal> queryEmployeeJournalByEmpId(String employeeId, String yearMonth);	 
	
	/**
	 * @Title: queryEmployeeJournalAllForPage
	 * @Description: 根据员工等属性与分页信息分页查询员工考勤日志信息
	 * @param pageBounds 分页信息
	 * @param query 实体
	 * @return List<EmployeeJournal>
	 */
	Map<String, Object> queryEmployeeJournalAllForPage(Integer pagenum, Integer pagesize, String sort, Map<String, Object> query);
	 
}
