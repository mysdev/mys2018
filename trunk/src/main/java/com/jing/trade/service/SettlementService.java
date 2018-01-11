package com.jing.trade.service;

import java.util.List;
import java.util.Map;


import com.jing.trade.model.entity.Settlement;

/**
 * @ClassName: Settlement
 * @Description: 消费结算服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public interface SettlementService {

    /**
	 * @Title: addSettlement
	 * @Description:添加消费结算
	 * @param settlement 实体
	 * @return Integer
	 */
	Settlement addSettlement(Settlement settlement);
	
	/**
	 * @Title modifySettlement
	 * @Description:修改消费结算
	 * @param settlement 实体
	 * @return Integer
	 */
	Integer modifySettlement(Settlement settlement);
	
	/**
	 * @Title: dropSettlementBySettlementId
	 * @Description:删除消费结算
	 * @param settlementId 实体标识
	 * @return Integer
	 */
	Integer dropSettlementBySettlementId(Integer settlementId);
	
	/**
	 * @Title: querySettlementBySettlementId
	 * @Description:根据实体标识查询消费结算
	 * @param settlementId 实体标识
	 * @return Settlement
	 */
	Settlement querySettlementBySettlementId(Integer settlementId);
	 
	/**
	 * @Title: querySettlementForPage
	 * @Description: 根据消费结算属性与分页信息分页查询消费结算信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param settlement 实体
	 * @return List<Settlement>
	 */
	Map<String, Object> querySettlementForPage(Integer pagenum, Integer pagesize, String sort, Settlement settlement);
	 
	 /**
	 * @Title: querySettlementByProperty
	 * @Description:根据属性查询消费结算
	 * @return List<Settlement>
	 */
	 List<Settlement> querySettlementByProperty(Map<String, Object> map);	 
	 
}
