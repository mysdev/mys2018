package com.jing.trade.service.impl;

import java.util.List;

import com.jing.settlement.model.entity.Packages;
import com.jing.trade.model.entity.Trade;
import com.jing.trade.service.CashierService;

public class CashierServiceImpl implements CashierService{

	@Override
	public List<?> calculate(int tradeId) {
		//唯一标识找出消费内容出来[哪个对象？]
		
		//列出消费列表
		List<Trade> tradeList = null;
		//列出所有有效的套餐列表
		List<Packages> packages = null;
		
		return null;
	}
	
	/**
	 * 把单个的商品替换成 套餐
	 * @param tradeList 消费清单
	 * @param packages 有效套餐
	 */
	public void trade(List<Trade> tradeList, List<Packages> packages) {
		for (Packages packages2 : packages) {
			
		}
	}

	/**
	 * 计费，商品数量*商品价格【优惠价格】=总价,减去优惠劵，减去特权价格= 实际支付价格.
	 */
	@Override
	public String pay(int tradeId,float amount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
