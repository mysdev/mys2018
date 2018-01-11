package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.Reservation;

/**
 * @ClassName: Reservation
 * @Description: 房间预定服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface ReservationService {

    /**
	 * @Title: addReservation
	 * @Description:添加房间预定
	 * @param reservation 实体
	 * @return Integer
	 */
	Reservation addReservation(Reservation reservation);
	
	/**
	 * @Title modifyReservation
	 * @Description:修改房间预定
	 * @param reservation 实体
	 * @return Integer
	 */
	Integer modifyReservation(Reservation reservation);
	
	/**
	 * @Title: dropReservationByReservationId
	 * @Description:删除房间预定
	 * @param reservationId 实体标识
	 * @return Integer
	 */
	Integer dropReservationByReservationId(Integer reservationId);
	
	/**
	 * @Title: queryReservationByReservationId
	 * @Description:根据实体标识查询房间预定
	 * @param reservationId 实体标识
	 * @return Reservation
	 */
	Reservation queryReservationByReservationId(Integer reservationId);
	 
	/**
	 * @Title: queryReservationForPage
	 * @Description: 根据房间预定属性与分页信息分页查询房间预定信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param reservation 实体
	 * @return List<Reservation>
	 */
	Map<String, Object> queryReservationForPage(Integer pagenum, Integer pagesize, String sort, Reservation reservation);
	 
	 /**
	 * @Title: queryReservationByProperty
	 * @Description:根据属性查询房间预定
	 * @return List<Reservation>
	 */
	 List<Reservation> queryReservationByProperty(Map<String, Object> map);	 
	 
}
