package com.jing.trade.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.trade.model.entity.Settlement;
import com.jing.trade.model.dao.SettlementMapper;
import com.jing.trade.service.SettlementService;

@Service("settlementService")
public class SettlementServiceImpl implements SettlementService{

	@Resource
	private SettlementMapper settlementMapper;

	/**
	* 添加 消费结算
	*/
	@Override
	public void addSettlement(Settlement settlement){
		settlementMapper.addSettlement(settlement);
	}
	
	/**
	* 修改 消费结算
	*/
	@Override
	public void updateSettlement(Settlement settlement){
		settlementMapper.updateSettlement(settlement);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteSettlementById(Integer id){
		settlementMapper.deleteSettlementById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Settlement getSettlementById(Integer id){
		return settlementMapper.getSettlementById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findSettlementListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(settlementMapper.findSettlementListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询消费结算
	 * @param param
	 * @return
	 */
	 @Override
	public List<Settlement> findSettlementList(Map<String, Object> param){
		return settlementMapper.findSettlementList(param);
	}
	
}