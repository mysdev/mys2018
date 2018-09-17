package com.jing.trade.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.trade.model.dao.ExchangeMapper;
import com.jing.trade.model.entity.Exchange;
import com.jing.trade.service.ExchangeService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Exchange
 * @Description: 结算币种服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("exchangeService")
@Transactional(readOnly=true)
public class  ExchangeServiceImpl implements ExchangeService {	
//	private static final Logger logger = LoggerFactory.getLogger(ExchangeServiceImpl.class);
	
	@Autowired
    private ExchangeMapper exchangeMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addExchange
	 * @Description:添加结算币种
	 * @param exchange 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Exchange addExchange(Exchange exchange){
		int ret = exchangeMapper.addExchange(exchange);
		if(ret>0){
			return exchange;
		}
		return null;
	}
	
	/**
	 * @Title modifyExchange
	 * @Description:修改结算币种
	 * @param exchange 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyExchange(Exchange exchange){
		return exchangeMapper.modifyExchange(exchange);
	}
	
	/**
	 * @Title: dropExchangeByExchangeId
	 * @Description:删除结算币种
	 * @param exchangeId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropExchangeByExchangeId(Integer exchangeId){
		return exchangeMapper.dropExchangeByExchangeId(exchangeId);
	}
	
	/**
	 * @Title: queryExchangeByExchangeId
	 * @Description:根据实体标识查询结算币种
	 * @param exchangeId 实体标识
	 * @return Exchange
	 */
	@Override
	public Exchange queryExchangeByExchangeId(Integer exchangeId){
		return exchangeMapper.queryExchangeByExchangeId(exchangeId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryExchangeForPage
	 * @Description: 根据结算币种属性与分页信息分页查询结算币种信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param exchange 实体
	 * @return List<Exchange>
	 */
	@Override
	public Map<String, Object> queryExchangeForPage(Integer pagenum, Integer pagesize, String sort, Exchange exchange){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Exchange.class);
		List<Exchange> entityList = exchangeMapper.queryExchangeForPage(pageBounds, exchange);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Exchange.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Exchange> pagelist = (PageList<Exchange>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryExchangeByProperty
	 * @Description:根据属性查询结算币种
	 * @return List<Exchange>
	 */
	@Override
	public List<Exchange> queryExchangeByProperty(Map<String, Object> map){
		return exchangeMapper.queryExchangeByProperty(map);
	}


}
