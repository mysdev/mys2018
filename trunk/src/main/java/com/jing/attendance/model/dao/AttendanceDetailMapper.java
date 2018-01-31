package com.jing.attendance.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.attendance.model.entity.AttendanceDetail;

/**
 * @ClassName: AttendanceDetailMapper
 * @Description: 门店考勤详情映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月15日 09时43分
 */
@Mapper
public interface AttendanceDetailMapper {

	/**
	 * @Title: addAttendanceDetail
	 * @Description:添加门店考勤详情
	 * @param attendanceDetail 实体
	 * @return Integer
	 */
	Integer addAttendanceDetail(AttendanceDetail attendanceDetail);
	
	/**
	 * @Title modifyAttendanceDetail
	 * @Description:修改门店考勤详情
	 * @param attendanceDetail 实体
	 * @return Integer
	 */
	Integer modifyAttendanceDetail(AttendanceDetail attendanceDetail);
	
	/**
	 * @Title: dropAttendanceDetailByAttId
	 * @Description:删除门店考勤详情
	 * @param attId 实体标识
	 * @return Integer
	 */
	Integer dropAttendanceDetailByAttId(Integer attId);
	
	/** 
	* @Title: dropAttendanceDetailByAttendanceId 
	* @Description: 清空规则下的所有详情配置
	* @param attendanceId
	* @return  Integer    返回类型 
	* @throws 
	*/
	Integer dropAttendanceDetailByAttendanceId(Integer attendanceId);
	
	/**
	 * @Title: queryAttendanceDetailByAttId
	 * @Description:根据实体标识查询门店考勤详情
	 * @param attId 实体标识
	 * @return AttendanceDetail
	 */
	AttendanceDetail queryAttendanceDetailByAttId(Integer attId);
	 
	/**
	 * @Title: queryAttendanceDetailForPage
	 * @Description: 根据门店考勤详情属性与分页信息分页查询门店考勤详情信息
	 * @param pageBounds 分页信息
	 * @param attendanceDetail 实体
	 * @return List<AttendanceDetail>
	 */
	List<AttendanceDetail> queryAttendanceDetailForPage(PageBounds pageBounds, @Param("attendanceDetail") AttendanceDetail attendanceDetail);
	 
	 /**
	  * @Title: queryAttendanceDetailByProperty
	  * @Description:根据属性查询门店考勤详情
	  * @return List<AttendanceDetail>
	  */
	 List<AttendanceDetail> queryAttendanceDetailByProperty(@Param("attendanceDetail") Map<String, Object> map);

	 /** 
		* @Title: queryAttendanceDetailHistory 
		* @Description: 查询考勤规则历史
		* @param attendanceId 规则标识
		* @return  List<String>    返回类型 
		* @throws 
		*/
	List<String> queryAttendanceDetailHistory(Integer attendanceId);
	 
	 
	 
}
