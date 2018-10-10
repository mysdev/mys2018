package com.jing.trade.service;

/**
 * 消费
 * @author Administrator
 *
 */
public interface MyTradeService {

	/**
	 * 消费码，消费某商品 多少个。
	 * @param authorizationId
	 * @param goodsId
	 * @param ct
	 */
	void trade(String authorizationId,String goodsId,int ct);
}
