package com.jing.trade.service;

import java.util.List;
import java.util.Map;


import com.jing.trade.model.entity.Trade;

/**
 * @ClassName: Trade
 * @Description: 消费清单服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public interface TradeService {

    /**
	 * @Title: addTrade
	 * @Description:添加消费清单
	 * @param trade 实体
	 * @return Integer
	 */
	Trade addTrade(Trade trade);
	
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
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param trade 实体
	 * @return List<Trade>
	 */
	Map<String, Object> queryTradeForPage(Integer pagenum, Integer pagesize, String sort, Trade trade);
	 
	 /**
	 * @Title: queryTradeByProperty
	 * @Description:根据属性查询消费清单
	 * @return List<Trade>
	 */
	 List<Trade> queryTradeByProperty(Map<String, Object> map);	 
	 
}
