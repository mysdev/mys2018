package com.jing.trade.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.trade.model.entity.Trade;

@Mapper
public interface TradeMapper {

	/**
	* 添加 消费清单
	*/
	void addTrade(Trade trade);
	
	/**
	* 修改 消费清单
	*/
	void updateTrade(Trade trade);
	
	/**
	*根据ID删除记录
	*/
	void deleteTradeById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	Trade getTradeById(Integer id);
	
	/**
	* 分页查询
	*/
	List<Trade> findTradeListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询消费清单
	 * @param param
	 * @return
	 */
	List<Trade> findTradeList(@Param("param") Map<String, Object> param);	
}