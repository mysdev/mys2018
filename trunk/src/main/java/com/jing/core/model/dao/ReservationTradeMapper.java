package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.ReservationTrade;

/**
 * @ClassName: ReservationTradeMapper
 * @Description: 消费商品详情映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface ReservationTradeMapper {

	/**
	 * @Title: addReservationTrade
	 * @Description:添加消费商品详情
	 * @param reservationTrade 实体
	 * @return Integer
	 */
	Integer addReservationTrade(ReservationTrade reservationTrade);
	
	/**
	 * @Title modifyReservationTrade
	 * @Description:修改消费商品详情
	 * @param reservationTrade 实体
	 * @return Integer
	 */
	Integer modifyReservationTrade(ReservationTrade reservationTrade);
	
	/**
	 * @Title: dropReservationTradeByDetailId
	 * @Description:删除消费商品详情
	 * @param detailId 实体标识
	 * @return Integer
	 */
	Integer dropReservationTradeByDetailId(Integer detailId);
	
	/**
	 * @Title: queryReservationTradeByDetailId
	 * @Description:根据实体标识查询消费商品详情
	 * @param detailId 实体标识
	 * @return ReservationTrade
	 */
	ReservationTrade queryReservationTradeByDetailId(Integer detailId);
	 
	/**
	 * @Title: queryReservationTradeForPage
	 * @Description: 根据消费商品详情属性与分页信息分页查询消费商品详情信息
	 * @param pageBounds 分页信息
	 * @param reservationTrade 实体
	 * @return List<ReservationTrade>
	 */
	List<ReservationTrade> queryReservationTradeForPage(PageBounds pageBounds, @Param("reservationTrade") ReservationTrade reservationTrade);
	 
	 /**
	  * @Title: queryReservationTradeByProperty
	  * @Description:根据属性查询消费商品详情
	  * @return List<ReservationTrade>
	  */
	 List<ReservationTrade> queryReservationTradeByProperty(@Param("reservationTrade") Map<String, Object> map);
	 
	 
	 
}
