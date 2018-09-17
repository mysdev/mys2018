package com.jing.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.core.model.dao.ReservationTradeMapper;
import com.jing.core.model.entity.ReservationTrade;
import com.jing.core.service.ReservationTradeService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: ReservationTrade
 * @Description: 消费商品详情服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("reservationTradeService")
@Transactional(readOnly=true)
public class  ReservationTradeServiceImpl implements ReservationTradeService {	
//	private static final Logger logger = LoggerFactory.getLogger(ReservationTradeServiceImpl.class);
	
	@Autowired
    private ReservationTradeMapper reservationTradeMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addReservationTrade
	 * @Description:添加消费商品详情
	 * @param reservationTrade 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public ReservationTrade addReservationTrade(ReservationTrade reservationTrade){
		int ret = reservationTradeMapper.addReservationTrade(reservationTrade);
		if(ret>0){
			return reservationTrade;
		}
		return null;
	}
	
	/**
	 * @Title modifyReservationTrade
	 * @Description:修改消费商品详情
	 * @param reservationTrade 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyReservationTrade(ReservationTrade reservationTrade){
		return reservationTradeMapper.modifyReservationTrade(reservationTrade);
	}
	
	/**
	 * @Title: dropReservationTradeByDetailId
	 * @Description:删除消费商品详情
	 * @param detailId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropReservationTradeByDetailId(Integer detailId){
		return reservationTradeMapper.dropReservationTradeByDetailId(detailId);
	}
	
	/**
	 * @Title: queryReservationTradeByDetailId
	 * @Description:根据实体标识查询消费商品详情
	 * @param detailId 实体标识
	 * @return ReservationTrade
	 */
	@Override
	public ReservationTrade queryReservationTradeByDetailId(Integer detailId){
		return reservationTradeMapper.queryReservationTradeByDetailId(detailId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryReservationTradeForPage
	 * @Description: 根据消费商品详情属性与分页信息分页查询消费商品详情信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param reservationTrade 实体
	 * @return List<ReservationTrade>
	 */
	@Override
	public Map<String, Object> queryReservationTradeForPage(Integer pagenum, Integer pagesize, String sort, ReservationTrade reservationTrade){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, ReservationTrade.class);
		List<ReservationTrade> entityList = reservationTradeMapper.queryReservationTradeForPage(pageBounds, reservationTrade);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, ReservationTrade.class);
		}
		if (!entityList.isEmpty()) {
			PageList<ReservationTrade> pagelist = (PageList<ReservationTrade>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryReservationTradeByProperty
	 * @Description:根据属性查询消费商品详情
	 * @return List<ReservationTrade>
	 */
	@Override
	public List<ReservationTrade> queryReservationTradeByProperty(Map<String, Object> map){
		return reservationTradeMapper.queryReservationTradeByProperty(map);
	}


}
