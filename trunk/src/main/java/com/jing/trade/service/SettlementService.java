package com.jing.trade.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.trade.model.entity.Settlement;

public interface SettlementService {

	/**
	* 添加 消费结算
	*/
	void addSettlement(Settlement settlement);
	
	/**
	* 修改 消费结算
	*/
	void updateSettlement(Settlement settlement);
	
	/**
	*根据ID删除记录
	*/
	void deleteSettlementById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	Settlement getSettlementById(Integer id);
	
	/**
	* 分页查询
	*/
	PageInfo findSettlementListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询消费结算
	 * @param param
	 * @return
	 */
	List<Settlement> findSettlementList(Map<String, Object> param);
}