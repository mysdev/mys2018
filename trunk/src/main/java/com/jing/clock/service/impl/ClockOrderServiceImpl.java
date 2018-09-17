package com.jing.clock.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.clock.model.dao.ClockOrderMapper;
import com.jing.clock.model.entity.ClockOrder;
import com.jing.clock.service.ClockOrderService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: ClockOrder
 * @Description: 订单服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("clockOrderService")
@Transactional(readOnly=true)
public class  ClockOrderServiceImpl implements ClockOrderService {	
//	private static final Logger logger = LoggerFactory.getLogger(ClockOrderServiceImpl.class);
	
	@Autowired
    private ClockOrderMapper clockOrderMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addClockOrder
	 * @Description:添加订单
	 * @param clockOrder 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public ClockOrder addClockOrder(ClockOrder clockOrder){
		int ret = clockOrderMapper.addClockOrder(clockOrder);
		if(ret>0){
			return clockOrder;
		}
		return null;
	}
	
	/**
	 * @Title modifyClockOrder
	 * @Description:修改订单
	 * @param clockOrder 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyClockOrder(ClockOrder clockOrder){
		return clockOrderMapper.modifyClockOrder(clockOrder);
	}
	
	/**
	 * @Title: dropClockOrderByOrderId
	 * @Description:删除订单
	 * @param orderId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropClockOrderByOrderId(Integer orderId){
		return clockOrderMapper.dropClockOrderByOrderId(orderId);
	}
	
	/**
	 * @Title: queryClockOrderByOrderId
	 * @Description:根据实体标识查询订单
	 * @param orderId 实体标识
	 * @return ClockOrder
	 */
	@Override
	public ClockOrder queryClockOrderByOrderId(Integer orderId){
		return clockOrderMapper.queryClockOrderByOrderId(orderId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryClockOrderForPage
	 * @Description: 根据订单属性与分页信息分页查询订单信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param clockOrder 实体
	 * @return List<ClockOrder>
	 */
	@Override
	public Map<String, Object> queryClockOrderForPage(Integer pagenum, Integer pagesize, String sort, ClockOrder clockOrder){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, ClockOrder.class);
		List<ClockOrder> entityList = clockOrderMapper.queryClockOrderForPage(pageBounds, clockOrder);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, ClockOrder.class);
		}
		if (!entityList.isEmpty()) {
			PageList<ClockOrder> pagelist = (PageList<ClockOrder>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryClockOrderByProperty
	 * @Description:根据属性查询订单
	 * @return List<ClockOrder>
	 */
	@Override
	public List<ClockOrder> queryClockOrderByProperty(Map<String, Object> map){
		return clockOrderMapper.queryClockOrderByProperty(map);
	}


}
