package com.jing.core.service.impl;

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


import com.jing.core.model.entity.Reservation;
import com.jing.core.model.dao.ReservationMapper;
import com.jing.core.service.ReservationService;

/**
 * @ClassName: Reservation
 * @Description: 房间预定服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("reservationService")
@Transactional(readOnly=true)
public class  ReservationServiceImpl implements ReservationService {	
	private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
    private ReservationMapper reservationMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addReservation
	 * @Description:添加房间预定
	 * @param reservation 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Reservation addReservation(Reservation reservation){
		int ret = reservationMapper.addReservation(reservation);
		if(ret>0){
			return reservation;
		}
		return null;
	}
	
	/**
	 * @Title modifyReservation
	 * @Description:修改房间预定
	 * @param reservation 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyReservation(Reservation reservation){
		return reservationMapper.modifyReservation(reservation);
	}
	
	/**
	 * @Title: dropReservationByReservationId
	 * @Description:删除房间预定
	 * @param reservationId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropReservationByReservationId(Integer reservationId){
		return reservationMapper.dropReservationByReservationId(reservationId);
	}
	
	/**
	 * @Title: queryReservationByReservationId
	 * @Description:根据实体标识查询房间预定
	 * @param reservationId 实体标识
	 * @return Reservation
	 */
	@Override
	public Reservation queryReservationByReservationId(Integer reservationId){
		return reservationMapper.queryReservationByReservationId(reservationId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryReservationForPage
	 * @Description: 根据房间预定属性与分页信息分页查询房间预定信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param reservation 实体
	 * @return List<Reservation>
	 */
	@Override
	public Map<String, Object> queryReservationForPage(Integer pagenum, Integer pagesize, String sort, Reservation reservation){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Reservation.class);
		List<Reservation> entityList = reservationMapper.queryReservationForPage(pageBounds, reservation);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Reservation.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Reservation> pagelist = (PageList<Reservation>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryReservationByProperty
	 * @Description:根据属性查询房间预定
	 * @return List<Reservation>
	 */
	@Override
	public List<Reservation> queryReservationByProperty(Map<String, Object> map){
		return reservationMapper.queryReservationByProperty(map);
	}


}
