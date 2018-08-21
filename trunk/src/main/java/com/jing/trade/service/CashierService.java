package com.jing.trade.service;

import java.util.List;

/**
 * 收银台
 * @author LiFeng
 *
 */
public interface CashierService {

	/**
	 * 结算
	 * 优惠、套餐、价格
	 * @param tradeId
	 */
	List<?> calculate(int tradeId);
	
	/**
	 * 支付
	 * @param tradeId
	 */
	String pay(int tradeId,float amount);
	
}
