package com.jing.trade.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.trade.model.dao.TradeMapper;
import com.jing.trade.model.entity.Trade;
import com.jing.trade.service.TradeService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Trade
 * @Description: 消费清单服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("tradeService")
@Transactional(readOnly=true)
public class  TradeServiceImpl implements TradeService {	
//	private static final Logger logger = LoggerFactory.getLogger(TradeServiceImpl.class);
	
	@Autowired
    private TradeMapper tradeMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addTrade
	 * @Description:添加消费清单
	 * @param trade 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Trade addTrade(Trade trade){
		int ret = tradeMapper.addTrade(trade);
		if(ret>0){
			return trade;
		}
		return null;
	}
	
	/**
	 * @Title modifyTrade
	 * @Description:修改消费清单
	 * @param trade 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyTrade(Trade trade){
		return tradeMapper.modifyTrade(trade);
	}
	
	/**
	 * @Title: dropTradeByTradeId
	 * @Description:删除消费清单
	 * @param tradeId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropTradeByTradeId(Integer tradeId){
		return tradeMapper.dropTradeByTradeId(tradeId);
	}
	
	/**
	 * @Title: queryTradeByTradeId
	 * @Description:根据实体标识查询消费清单
	 * @param tradeId 实体标识
	 * @return Trade
	 */
	@Override
	public Trade queryTradeByTradeId(Integer tradeId){
		return tradeMapper.queryTradeByTradeId(tradeId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryTradeForPage
	 * @Description: 根据消费清单属性与分页信息分页查询消费清单信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param trade 实体
	 * @return List<Trade>
	 */
	@Override
	public Map<String, Object> queryTradeForPage(Integer pagenum, Integer pagesize, String sort, Trade trade){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Trade.class);
		List<Trade> entityList = tradeMapper.queryTradeForPage(pageBounds, trade);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Trade.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Trade> pagelist = (PageList<Trade>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryTradeByProperty
	 * @Description:根据属性查询消费清单
	 * @return List<Trade>
	 */
	@Override
	public List<Trade> queryTradeByProperty(Map<String, Object> map){
		return tradeMapper.queryTradeByProperty(map);
	}


}
