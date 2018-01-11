package com.jing.trade.service;

import java.util.List;
import java.util.Map;


import com.jing.trade.model.entity.MemberPrice;

/**
 * @ClassName: MemberPrice
 * @Description: 会员价格服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public interface MemberPriceService {

    /**
	 * @Title: addMemberPrice
	 * @Description:添加会员价格
	 * @param memberPrice 实体
	 * @return Integer
	 */
	MemberPrice addMemberPrice(MemberPrice memberPrice);
	
	/**
	 * @Title modifyMemberPrice
	 * @Description:修改会员价格
	 * @param memberPrice 实体
	 * @return Integer
	 */
	Integer modifyMemberPrice(MemberPrice memberPrice);
	
	/**
	 * @Title: dropMemberPriceByPriceId
	 * @Description:删除会员价格
	 * @param priceId 实体标识
	 * @return Integer
	 */
	Integer dropMemberPriceByPriceId(Integer priceId);
	
	/**
	 * @Title: queryMemberPriceByPriceId
	 * @Description:根据实体标识查询会员价格
	 * @param priceId 实体标识
	 * @return MemberPrice
	 */
	MemberPrice queryMemberPriceByPriceId(Integer priceId);
	 
	/**
	 * @Title: queryMemberPriceForPage
	 * @Description: 根据会员价格属性与分页信息分页查询会员价格信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param memberPrice 实体
	 * @return List<MemberPrice>
	 */
	Map<String, Object> queryMemberPriceForPage(Integer pagenum, Integer pagesize, String sort, MemberPrice memberPrice);
	 
	 /**
	 * @Title: queryMemberPriceByProperty
	 * @Description:根据属性查询会员价格
	 * @return List<MemberPrice>
	 */
	 List<MemberPrice> queryMemberPriceByProperty(Map<String, Object> map);	 
	 
}
