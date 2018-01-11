package com.jing.trade.service;

import java.util.List;
import java.util.Map;


import com.jing.trade.model.entity.TradeDiscount;

/**
 * @ClassName: TradeDiscount
 * @Description: 结算优惠项服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public interface TradeDiscountService {

    /**
	 * @Title: addTradeDiscount
	 * @Description:添加结算优惠项
	 * @param tradeDiscount 实体
	 * @return Integer
	 */
	TradeDiscount addTradeDiscount(TradeDiscount tradeDiscount);
	
	/**
	 * @Title modifyTradeDiscount
	 * @Description:修改结算优惠项
	 * @param tradeDiscount 实体
	 * @return Integer
	 */
	Integer modifyTradeDiscount(TradeDiscount tradeDiscount);
	
	/**
	 * @Title: dropTradeDiscountByDiscountId
	 * @Description:删除结算优惠项
	 * @param discountId 实体标识
	 * @return Integer
	 */
	Integer dropTradeDiscountByDiscountId(Integer discountId);
	
	/**
	 * @Title: queryTradeDiscountByDiscountId
	 * @Description:根据实体标识查询结算优惠项
	 * @param discountId 实体标识
	 * @return TradeDiscount
	 */
	TradeDiscount queryTradeDiscountByDiscountId(Integer discountId);
	 
	/**
	 * @Title: queryTradeDiscountForPage
	 * @Description: 根据结算优惠项属性与分页信息分页查询结算优惠项信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param tradeDiscount 实体
	 * @return List<TradeDiscount>
	 */
	Map<String, Object> queryTradeDiscountForPage(Integer pagenum, Integer pagesize, String sort, TradeDiscount tradeDiscount);
	 
	 /**
	 * @Title: queryTradeDiscountByProperty
	 * @Description:根据属性查询结算优惠项
	 * @return List<TradeDiscount>
	 */
	 List<TradeDiscount> queryTradeDiscountByProperty(Map<String, Object> map);	 
	 
}
