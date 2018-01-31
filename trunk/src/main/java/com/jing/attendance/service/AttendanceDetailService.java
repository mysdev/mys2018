package com.jing.attendance.service;

import java.util.List;
import java.util.Map;


import com.jing.attendance.model.entity.AttendanceDetail;

/**
 * @ClassName: AttendanceDetail
 * @Description: 门店考勤详情服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月15日 09时43分
 */
public interface AttendanceDetailService {
	
	
	/** 
	* @Title: queryAttendanceDetail 
	* @Description: 查询考勤详情
	* @param attendanceId 考勤标识
	* @param yearMonth 月份
	* @return  List<AttendanceDetail>    返回类型 
	* @throws 
	*/
	List<AttendanceDetail> queryAttendanceDetail(Integer attendanceId, String yearMonth);

    /**
	 * @Title: addAttendanceDetail
	 * @Description:添加门店考勤详情
	 * @param attendanceDetail 实体
	 * @return Integer
	 */
	AttendanceDetail addAttendanceDetail(AttendanceDetail attendanceDetail);	
	
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
	 * @Title: queryAttendanceDetailByAttId
	 * @Description:根据实体标识查询门店考勤详情
	 * @param attId 实体标识
	 * @return AttendanceDetail
	 */
	AttendanceDetail queryAttendanceDetailByAttId(Integer attId);
	 
	/**
	 * @Title: queryAttendanceDetailForPage
	 * @Description: 根据门店考勤详情属性与分页信息分页查询门店考勤详情信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param attendanceDetail 实体
	 * @return List<AttendanceDetail>
	 */
	Map<String, Object> queryAttendanceDetailForPage(Integer pagenum, Integer pagesize, String sort, AttendanceDetail attendanceDetail);
	 
	 /**
	 * @Title: queryAttendanceDetailByProperty
	 * @Description:根据属性查询门店考勤详情
	 * @return List<AttendanceDetail>
	 */
	List<AttendanceDetail> queryAttendanceDetailByProperty(Map<String, Object> map);

	/** 
	* @Title: queryAttendanceDetailHistory 
	* @Description: 查询考勤规则历史
	* @param attendanceId 规则标识
	* @return  List<String>    返回类型 
	* @throws 
	*/
	List<String> queryAttendanceDetailHistory(Integer attendanceId);

	/** 
	* @Title: modifyAttendanceDetailBatch 
	* @Description: 修改门店考勤详情
	* @param attendanceList
	* @return  Integer    返回类型 
	* @throws 
	*/
	Integer modifyAttendanceDetailBatch(AttendanceDetail[] attendanceList);	 
	 
}
