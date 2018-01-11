package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.ReservationTrade;

/**
 * @ClassName: ReservationTrade
 * @Description: 消费商品详情服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface ReservationTradeService {

    /**
	 * @Title: addReservationTrade
	 * @Description:添加消费商品详情
	 * @param reservationTrade 实体
	 * @return Integer
	 */
	ReservationTrade addReservationTrade(ReservationTrade reservationTrade);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param reservationTrade 实体
	 * @return List<ReservationTrade>
	 */
	Map<String, Object> queryReservationTradeForPage(Integer pagenum, Integer pagesize, String sort, ReservationTrade reservationTrade);
	 
	 /**
	 * @Title: queryReservationTradeByProperty
	 * @Description:根据属性查询消费商品详情
	 * @return List<ReservationTrade>
	 */
	 List<ReservationTrade> queryReservationTradeByProperty(Map<String, Object> map);	 
	 
}
