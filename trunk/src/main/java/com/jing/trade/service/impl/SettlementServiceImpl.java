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


import com.jing.trade.model.entity.Settlement;
import com.jing.trade.model.dao.SettlementMapper;
import com.jing.trade.service.SettlementService;

/**
 * @ClassName: Settlement
 * @Description: 消费结算服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("settlementService")
@Transactional(readOnly=true)
public class  SettlementServiceImpl implements SettlementService {	
	private static final Logger logger = LoggerFactory.getLogger(SettlementServiceImpl.class);
	
	@Autowired
    private SettlementMapper settlementMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addSettlement
	 * @Description:添加消费结算
	 * @param settlement 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Settlement addSettlement(Settlement settlement){
		int ret = settlementMapper.addSettlement(settlement);
		if(ret>0){
			return settlement;
		}
		return null;
	}
	
	/**
	 * @Title modifySettlement
	 * @Description:修改消费结算
	 * @param settlement 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifySettlement(Settlement settlement){
		return settlementMapper.modifySettlement(settlement);
	}
	
	/**
	 * @Title: dropSettlementBySettlementId
	 * @Description:删除消费结算
	 * @param settlementId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropSettlementBySettlementId(Integer settlementId){
		return settlementMapper.dropSettlementBySettlementId(settlementId);
	}
	
	/**
	 * @Title: querySettlementBySettlementId
	 * @Description:根据实体标识查询消费结算
	 * @param settlementId 实体标识
	 * @return Settlement
	 */
	@Override
	public Settlement querySettlementBySettlementId(Integer settlementId){
		return settlementMapper.querySettlementBySettlementId(settlementId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: querySettlementForPage
	 * @Description: 根据消费结算属性与分页信息分页查询消费结算信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param settlement 实体
	 * @return List<Settlement>
	 */
	@Override
	public Map<String, Object> querySettlementForPage(Integer pagenum, Integer pagesize, String sort, Settlement settlement){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Settlement.class);
		List<Settlement> entityList = settlementMapper.querySettlementForPage(pageBounds, settlement);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Settlement.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Settlement> pagelist = (PageList<Settlement>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: querySettlementByProperty
	 * @Description:根据属性查询消费结算
	 * @return List<Settlement>
	 */
	@Override
	public List<Settlement> querySettlementByProperty(Map<String, Object> map){
		return settlementMapper.querySettlementByProperty(map);
	}


}
