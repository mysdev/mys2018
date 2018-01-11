package com.jing.attendance.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.attendance.model.entity.EmployeeJournal;

/**
 * @ClassName: EmployeeJournalMapper
 * @Description: 员工考勤日志映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Mapper
public interface EmployeeJournalMapper {

	/**
	 * @Title: addEmployeeJournal
	 * @Description:添加员工考勤日志
	 * @param employeeJournal 实体
	 * @return Integer
	 */
	Integer addEmployeeJournal(EmployeeJournal employeeJournal);
	
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
	 * @param pageBounds 分页信息
	 * @param employeeJournal 实体
	 * @return List<EmployeeJournal>
	 */
	List<EmployeeJournal> queryEmployeeJournalForPage(PageBounds pageBounds, @Param("employeeJournal") EmployeeJournal employeeJournal);
	 
	 /**
	  * @Title: queryEmployeeJournalByProperty
	  * @Description:根据属性查询员工考勤日志
	  * @return List<EmployeeJournal>
	  */
	 List<EmployeeJournal> queryEmployeeJournalByProperty(@Param("employeeJournal") Map<String, Object> map);
	 
	 
	 
}
