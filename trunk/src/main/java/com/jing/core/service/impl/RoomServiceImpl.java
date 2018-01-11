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
import java.util.UUID;


import com.jing.core.model.entity.Room;
import com.jing.core.model.dao.RoomMapper;
import com.jing.core.service.RoomService;

/**
 * @ClassName: Room
 * @Description: 房间服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("roomService")
@Transactional(readOnly=true)
public class  RoomServiceImpl implements RoomService {	
	private static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);
	
	@Autowired
    private RoomMapper roomMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addRoom
	 * @Description:添加房间
	 * @param room 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Room addRoom(Room room){
		room.setRoomId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		int ret = roomMapper.addRoom(room);
		if(ret>0){
			return room;
		}
		return null;
	}
	
	/**
	 * @Title modifyRoom
	 * @Description:修改房间
	 * @param room 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyRoom(Room room){
		return roomMapper.modifyRoom(room);
	}
	
	/**
	 * @Title: dropRoomByRoomId
	 * @Description:删除房间
	 * @param roomId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropRoomByRoomId(String roomId){
		return roomMapper.dropRoomByRoomId(roomId);
	}
	
	/**
	 * @Title: queryRoomByRoomId
	 * @Description:根据实体标识查询房间
	 * @param roomId 实体标识
	 * @return Room
	 */
	@Override
	public Room queryRoomByRoomId(String roomId){
		return roomMapper.queryRoomByRoomId(roomId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryRoomForPage
	 * @Description: 根据房间属性与分页信息分页查询房间信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param room 实体
	 * @return List<Room>
	 */
	@Override
	public Map<String, Object> queryRoomForPage(Integer pagenum, Integer pagesize, String sort, Room room){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Room.class);
		List<Room> entityList = roomMapper.queryRoomForPage(pageBounds, room);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Room.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Room> pagelist = (PageList<Room>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryRoomByProperty
	 * @Description:根据属性查询房间
	 * @return List<Room>
	 */
	@Override
	public List<Room> queryRoomByProperty(Map<String, Object> map){
		return roomMapper.queryRoomByProperty(map);
	}


}
