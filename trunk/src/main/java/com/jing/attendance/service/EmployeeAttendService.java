package com.jing.attendance.service;

import java.util.List;
import java.util.Map;


import com.jing.attendance.model.entity.EmployeeAttend;

/**
 * @ClassName: EmployeeAttend
 * @Description: 打卡记录服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
public interface EmployeeAttendService {

    /**
	 * @Title: addEmployeeAttend
	 * @Description:添加打卡记录
	 * @param employeeAttend 实体
	 * @return Integer
	 */
	EmployeeAttend addEmployeeAttend(EmployeeAttend employeeAttend);
	
	/**
	 * @Title modifyEmployeeAttend
	 * @Description:修改打卡记录
	 * @param employeeAttend 实体
	 * @return Integer
	 */
	Integer modifyEmployeeAttend(EmployeeAttend employeeAttend);
	
	/**
	 * @Title: dropEmployeeAttendByAttId
	 * @Description:删除打卡记录
	 * @param attId 实体标识
	 * @return Integer
	 */
	Integer dropEmployeeAttendByAttId(Integer attId);
	
	/**
	 * @Title: queryEmployeeAttendByEmployeeId
	 * @Description:根据员工标识查询打卡记录
	 * @param empId 员工标识
	 * @return EmployeeAttend
	 */
	List<EmployeeAttend> queryEmployeeAttendByEmployeeId(String empId, String yearMonth);
	 
	/**
	 * @Title: queryEmployeeAttendForPage
	 * @Description: 根据打卡记录属性与分页信息分页查询打卡记录信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param qeury 实体
	 * @return List<EmployeeAttend>
	 */
	Map<String, Object> queryEmployeeAttendForPage(Integer pagenum, Integer pagesize, String sort, Map<String, Object> qeury);
	 
	 /**
	 * @Title: queryEmployeeAttendByProperty
	 * @Description:根据属性查询打卡记录
	 * @return List<EmployeeAttend>
	 */
	 List<EmployeeAttend> queryEmployeeAttendByProperty(Map<String, Object> map);	 
	 
}
