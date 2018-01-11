package com.jing.trade.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.trade.model.entity.Exchange;

/**
 * @ClassName: ExchangeMapper
 * @Description: 结算币种映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Mapper
public interface ExchangeMapper {

	/**
	 * @Title: addExchange
	 * @Description:添加结算币种
	 * @param exchange 实体
	 * @return Integer
	 */
	Integer addExchange(Exchange exchange);
	
	/**
	 * @Title modifyExchange
	 * @Description:修改结算币种
	 * @param exchange 实体
	 * @return Integer
	 */
	Integer modifyExchange(Exchange exchange);
	
	/**
	 * @Title: dropExchangeByExchangeId
	 * @Description:删除结算币种
	 * @param exchangeId 实体标识
	 * @return Integer
	 */
	Integer dropExchangeByExchangeId(Integer exchangeId);
	
	/**
	 * @Title: queryExchangeByExchangeId
	 * @Description:根据实体标识查询结算币种
	 * @param exchangeId 实体标识
	 * @return Exchange
	 */
	Exchange queryExchangeByExchangeId(Integer exchangeId);
	 
	/**
	 * @Title: queryExchangeForPage
	 * @Description: 根据结算币种属性与分页信息分页查询结算币种信息
	 * @param pageBounds 分页信息
	 * @param exchange 实体
	 * @return List<Exchange>
	 */
	List<Exchange> queryExchangeForPage(PageBounds pageBounds, @Param("exchange") Exchange exchange);
	 
	 /**
	  * @Title: queryExchangeByProperty
	  * @Description:根据属性查询结算币种
	  * @return List<Exchange>
	  */
	 List<Exchange> queryExchangeByProperty(@Param("exchange") Map<String, Object> map);
	 
	 
	 
}
