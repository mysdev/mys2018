package com.jing.trade.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.trade.model.entity.Trade;
import com.jing.trade.model.dao.TradeMapper;
import com.jing.trade.service.TradeService;

@Service("tradeService")
public class TradeServiceImpl implements TradeService{

	@Resource
	private TradeMapper tradeMapper;

	/**
	* 添加 消费清单
	*/
	@Override
	public void addTrade(Trade trade){
		tradeMapper.addTrade(trade);
	}
	
	/**
	* 修改 消费清单
	*/
	@Override
	public void updateTrade(Trade trade){
		tradeMapper.updateTrade(trade);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteTradeById(Integer id){
		tradeMapper.deleteTradeById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Trade getTradeById(Integer id){
		return tradeMapper.getTradeById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findTradeListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(tradeMapper.findTradeListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询消费清单
	 * @param param
	 * @return
	 */
	 @Override
	public List<Trade> findTradeList(Map<String, Object> param){
		return tradeMapper.findTradeList(param);
	}
	
}