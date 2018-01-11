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


import com.jing.trade.model.entity.CouponItem;
import com.jing.trade.model.dao.CouponItemMapper;
import com.jing.trade.service.CouponItemService;

/**
 * @ClassName: CouponItem
 * @Description: 优惠项目服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("couponItemService")
@Transactional(readOnly=true)
public class  CouponItemServiceImpl implements CouponItemService {	
	private static final Logger logger = LoggerFactory.getLogger(CouponItemServiceImpl.class);
	
	@Autowired
    private CouponItemMapper couponItemMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addCouponItem
	 * @Description:添加优惠项目
	 * @param couponItem 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public CouponItem addCouponItem(CouponItem couponItem){
		int ret = couponItemMapper.addCouponItem(couponItem);
		if(ret>0){
			return couponItem;
		}
		return null;
	}
	
	/**
	 * @Title modifyCouponItem
	 * @Description:修改优惠项目
	 * @param couponItem 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyCouponItem(CouponItem couponItem){
		return couponItemMapper.modifyCouponItem(couponItem);
	}
	
	/**
	 * @Title: dropCouponItemByItemId
	 * @Description:删除优惠项目
	 * @param itemId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropCouponItemByItemId(Integer itemId){
		return couponItemMapper.dropCouponItemByItemId(itemId);
	}
	
	/**
	 * @Title: queryCouponItemByItemId
	 * @Description:根据实体标识查询优惠项目
	 * @param itemId 实体标识
	 * @return CouponItem
	 */
	@Override
	public CouponItem queryCouponItemByItemId(Integer itemId){
		return couponItemMapper.queryCouponItemByItemId(itemId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryCouponItemForPage
	 * @Description: 根据优惠项目属性与分页信息分页查询优惠项目信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param couponItem 实体
	 * @return List<CouponItem>
	 */
	@Override
	public Map<String, Object> queryCouponItemForPage(Integer pagenum, Integer pagesize, String sort, CouponItem couponItem){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, CouponItem.class);
		List<CouponItem> entityList = couponItemMapper.queryCouponItemForPage(pageBounds, couponItem);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, CouponItem.class);
		}
		if (!entityList.isEmpty()) {
			PageList<CouponItem> pagelist = (PageList<CouponItem>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryCouponItemByProperty
	 * @Description:根据属性查询优惠项目
	 * @return List<CouponItem>
	 */
	@Override
	public List<CouponItem> queryCouponItemByProperty(Map<String, Object> map){
		return couponItemMapper.queryCouponItemByProperty(map);
	}


}
