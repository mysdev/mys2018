package com.jing.trade.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.trade.model.entity.TradeDiscount;
import com.jing.trade.model.dao.TradeDiscountMapper;
import com.jing.trade.service.TradeDiscountService;

/**
 * @ClassName: TradeDiscount
 * @Description: 结算优惠项服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("tradeDiscountService")
@Transactional(readOnly=true)
public class  TradeDiscountServiceImpl implements TradeDiscountService {	
	private static final Logger logger = LoggerFactory.getLogger(TradeDiscountServiceImpl.class);
	
	@Autowired
    private TradeDiscountMapper tradeDiscountMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addTradeDiscount
	 * @Description:添加结算优惠项
	 * @param tradeDiscount 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public TradeDiscount addTradeDiscount(TradeDiscount tradeDiscount){
		int ret = tradeDiscountMapper.addTradeDiscount(tradeDiscount);
		if(ret>0){
			return tradeDiscount;
		}
		return null;
	}
	
	/**
	 * @Title modifyTradeDiscount
	 * @Description:修改结算优惠项
	 * @param tradeDiscount 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyTradeDiscount(TradeDiscount tradeDiscount){
		return tradeDiscountMapper.modifyTradeDiscount(tradeDiscount);
	}
	
	/**
	 * @Title: dropTradeDiscountByDiscountId
	 * @Description:删除结算优惠项
	 * @param discountId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropTradeDiscountByDiscountId(Integer discountId){
		return tradeDiscountMapper.dropTradeDiscountByDiscountId(discountId);
	}
	
	/**
	 * @Title: queryTradeDiscountByDiscountId
	 * @Description:根据实体标识查询结算优惠项
	 * @param discountId 实体标识
	 * @return TradeDiscount
	 */
	@Override
	public TradeDiscount queryTradeDiscountByDiscountId(Integer discountId){
		return tradeDiscountMapper.queryTradeDiscountByDiscountId(discountId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryTradeDiscountForPage
	 * @Description: 根据结算优惠项属性与分页信息分页查询结算优惠项信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param tradeDiscount 实体
	 * @return List<TradeDiscount>
	 */
	@Override
	public Map<String, Object> queryTradeDiscountForPage(Integer pagenum, Integer pagesize, String sort, TradeDiscount tradeDiscount){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, TradeDiscount.class);
		List<TradeDiscount> entityList = tradeDiscountMapper.queryTradeDiscountForPage(pageBounds, tradeDiscount);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, TradeDiscount.class);
		}
		if (!entityList.isEmpty()) {
			PageList<TradeDiscount> pagelist = (PageList<TradeDiscount>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryTradeDiscountByProperty
	 * @Description:根据属性查询结算优惠项
	 * @return List<TradeDiscount>
	 */
	@Override
	public List<TradeDiscount> queryTradeDiscountByProperty(Map<String, Object> map){
		return tradeDiscountMapper.queryTradeDiscountByProperty(map);
	}


}
