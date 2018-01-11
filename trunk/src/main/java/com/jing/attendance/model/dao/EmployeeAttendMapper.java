package com.jing.attendance.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.attendance.model.entity.EmployeeAttend;

/**
 * @ClassName: EmployeeAttendMapper
 * @Description: 打卡记录映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Mapper
public interface EmployeeAttendMapper {

	/**
	 * @Title: addEmployeeAttend
	 * @Description:添加打卡记录
	 * @param employeeAttend 实体
	 * @return Integer
	 */
	Integer addEmployeeAttend(EmployeeAttend employeeAttend);
	
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
	 * @Title: queryEmployeeAttendByAttId
	 * @Description:根据实体标识查询打卡记录
	 * @param attId 实体标识
	 * @return EmployeeAttend
	 */
	EmployeeAttend queryEmployeeAttendByAttId(Integer attId);
	 
	/**
	 * @Title: queryEmployeeAttendForPage
	 * @Description: 根据打卡记录属性与分页信息分页查询打卡记录信息
	 * @param pageBounds 分页信息
	 * @param employeeAttend 实体
	 * @return List<EmployeeAttend>
	 */
	List<EmployeeAttend> queryEmployeeAttendForPage(PageBounds pageBounds, @Param("employeeAttend") EmployeeAttend employeeAttend);
	 
	 /**
	  * @Title: queryEmployeeAttendByProperty
	  * @Description:根据属性查询打卡记录
	  * @return List<EmployeeAttend>
	  */
	 List<EmployeeAttend> queryEmployeeAttendByProperty(@Param("employeeAttend") Map<String, Object> map);
	 
	 
	 
}
