package com.jing.trade.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.trade.model.entity.MemberPrice;

/**
 * @ClassName: MemberPriceMapper
 * @Description: 会员价格映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Mapper
public interface MemberPriceMapper {

	/**
	 * @Title: addMemberPrice
	 * @Description:添加会员价格
	 * @param memberPrice 实体
	 * @return Integer
	 */
	Integer addMemberPrice(MemberPrice memberPrice);
	
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
	 * @param pageBounds 分页信息
	 * @param memberPrice 实体
	 * @return List<MemberPrice>
	 */
	List<MemberPrice> queryMemberPriceForPage(PageBounds pageBounds, @Param("memberPrice") MemberPrice memberPrice);
	 
	 /**
	  * @Title: queryMemberPriceByProperty
	  * @Description:根据属性查询会员价格
	  * @return List<MemberPrice>
	  */
	 List<MemberPrice> queryMemberPriceByProperty(@Param("memberPrice") Map<String, Object> map);
	 
	 
	 
}
