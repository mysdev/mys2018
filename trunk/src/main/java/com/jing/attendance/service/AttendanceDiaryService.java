package com.jing.attendance.service;

import java.util.List;
import java.util.Map;


import com.jing.attendance.model.entity.AttendanceDiary;

/**
 * @ClassName: AttendanceDiary
 * @Description: 打卡记录服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年02月05日 22时39分
 */
public interface AttendanceDiaryService {

    /**
	 * @Title: addAttendanceDiary
	 * @Description:添加打卡记录
	 * @param attendanceDiary 实体
	 * @return Integer
	 */
	AttendanceDiary addAttendanceDiary(AttendanceDiary attendanceDiary);
	
	/**
	 * @Title modifyAttendanceDiary
	 * @Description:修改打卡记录
	 * @param attendanceDiary 实体
	 * @return Integer
	 */
	Integer modifyAttendanceDiary(AttendanceDiary attendanceDiary);
	
	/**
	 * @Title: dropAttendanceDiaryByAttId
	 * @Description:删除打卡记录
	 * @param attId 实体标识
	 * @return Integer
	 */
	Integer dropAttendanceDiaryByAttId(Integer attId);
	
	/**
	 * @Title: queryAttendanceDiaryByAttId
	 * @Description:根据实体标识查询打卡记录
	 * @param attId 实体标识
	 * @return AttendanceDiary
	 */
	AttendanceDiary queryAttendanceDiaryByAttId(Integer attId);
	 
	/**
	 * @Title: queryAttendanceDiaryForPage
	 * @Description: 根据打卡记录属性与分页信息分页查询打卡记录信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param attendanceDiary 实体
	 * @return List<AttendanceDiary>
	 */
	Map<String, Object> queryAttendanceDiaryForPage(Integer pagenum, Integer pagesize, String sort, AttendanceDiary attendanceDiary);
	 
	 /**
	 * @Title: queryAttendanceDiaryByProperty
	 * @Description:根据属性查询打卡记录
	 * @return List<AttendanceDiary>
	 */
	 List<AttendanceDiary> queryAttendanceDiaryByProperty(Map<String, Object> map);

	/** 
	* @Title: processAttendanceDiary 
	* @Description: 处理用户签到
	* @param empId
	* @return  String    返回类型 
	* @throws 
	*/
	String processAttendanceDiary(String empId);

	/** 
	* @Title: queryAttendanceDiaryAllForPage 
	* @Description: 查询用户考勤信息
	* @param pagenum
	* @param pagesize
	* @param sort
	* @param query
	* @return  Map<String,Object>    返回类型 
	* @throws 
	*/
	Map<String, Object> queryAttendanceDiaryAllForPage(Integer pagenum, Integer pagesize, String sort, Map<String, Object> query);	 
	 
}
