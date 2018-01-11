package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.Reservation;

/**
 * @ClassName: ReservationMapper
 * @Description: 房间预定映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface ReservationMapper {

	/**
	 * @Title: addReservation
	 * @Description:添加房间预定
	 * @param reservation 实体
	 * @return Integer
	 */
	Integer addReservation(Reservation reservation);
	
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
	 * @param pageBounds 分页信息
	 * @param reservation 实体
	 * @return List<Reservation>
	 */
	List<Reservation> queryReservationForPage(PageBounds pageBounds, @Param("reservation") Reservation reservation);
	 
	 /**
	  * @Title: queryReservationByProperty
	  * @Description:根据属性查询房间预定
	  * @return List<Reservation>
	  */
	 List<Reservation> queryReservationByProperty(@Param("reservation") Map<String, Object> map);
	 
	 
	 
}
