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


import com.jing.trade.model.entity.MemberPrice;
import com.jing.trade.model.dao.MemberPriceMapper;
import com.jing.trade.service.MemberPriceService;

/**
 * @ClassName: MemberPrice
 * @Description: 会员价格服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("memberPriceService")
@Transactional(readOnly=true)
public class  MemberPriceServiceImpl implements MemberPriceService {	
	private static final Logger logger = LoggerFactory.getLogger(MemberPriceServiceImpl.class);
	
	@Autowired
    private MemberPriceMapper memberPriceMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addMemberPrice
	 * @Description:添加会员价格
	 * @param memberPrice 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public MemberPrice addMemberPrice(MemberPrice memberPrice){
		int ret = memberPriceMapper.addMemberPrice(memberPrice);
		if(ret>0){
			return memberPrice;
		}
		return null;
	}
	
	/**
	 * @Title modifyMemberPrice
	 * @Description:修改会员价格
	 * @param memberPrice 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyMemberPrice(MemberPrice memberPrice){
		return memberPriceMapper.modifyMemberPrice(memberPrice);
	}
	
	/**
	 * @Title: dropMemberPriceByPriceId
	 * @Description:删除会员价格
	 * @param priceId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropMemberPriceByPriceId(Integer priceId){
		return memberPriceMapper.dropMemberPriceByPriceId(priceId);
	}
	
	/**
	 * @Title: queryMemberPriceByPriceId
	 * @Description:根据实体标识查询会员价格
	 * @param priceId 实体标识
	 * @return MemberPrice
	 */
	@Override
	public MemberPrice queryMemberPriceByPriceId(Integer priceId){
		return memberPriceMapper.queryMemberPriceByPriceId(priceId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryMemberPriceForPage
	 * @Description: 根据会员价格属性与分页信息分页查询会员价格信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param memberPrice 实体
	 * @return List<MemberPrice>
	 */
	@Override
	public Map<String, Object> queryMemberPriceForPage(Integer pagenum, Integer pagesize, String sort, MemberPrice memberPrice){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, MemberPrice.class);
		List<MemberPrice> entityList = memberPriceMapper.queryMemberPriceForPage(pageBounds, memberPrice);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, MemberPrice.class);
		}
		if (!entityList.isEmpty()) {
			PageList<MemberPrice> pagelist = (PageList<MemberPrice>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryMemberPriceByProperty
	 * @Description:根据属性查询会员价格
	 * @return List<MemberPrice>
	 */
	@Override
	public List<MemberPrice> queryMemberPriceByProperty(Map<String, Object> map){
		return memberPriceMapper.queryMemberPriceByProperty(map);
	}


}
