package com.jing.trade.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.trade.model.entity.Trade;

/**
 * @ClassName: TradeMapper
 * @Description: 消费清单映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Mapper
public interface TradeMapper {

	/**
	 * @Title: addTrade
	 * @Description:添加消费清单
	 * @param trade 实体
	 * @return Integer
	 */
	Integer addTrade(Trade trade);
	
	/**
	 * @Title modifyTrade
	 * @Description:修改消费清单
	 * @param trade 实体
	 * @return Integer
	 */
	Integer modifyTrade(Trade trade);
	
	/**
	 * @Title: dropTradeByTradeId
	 * @Description:删除消费清单
	 * @param tradeId 实体标识
	 * @return Integer
	 */
	Integer dropTradeByTradeId(Integer tradeId);
	
	/**
	 * @Title: queryTradeByTradeId
	 * @Description:根据实体标识查询消费清单
	 * @param tradeId 实体标识
	 * @return Trade
	 */
	Trade queryTradeByTradeId(Integer tradeId);
	 
	/**
	 * @Title: queryTradeForPage
	 * @Description: 根据消费清单属性与分页信息分页查询消费清单信息
	 * @param pageBounds 分页信息
	 * @param trade 实体
	 * @return List<Trade>
	 */
	List<Trade> queryTradeForPage(PageBounds pageBounds, @Param("trade") Trade trade);
	 
	 /**
	  * @Title: queryTradeByProperty
	  * @Description:根据属性查询消费清单
	  * @return List<Trade>
	  */
	 List<Trade> queryTradeByProperty(@Param("trade") Map<String, Object> map);
	 
	 
	 
}
