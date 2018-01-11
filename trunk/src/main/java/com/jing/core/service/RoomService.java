package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.Room;

/**
 * @ClassName: Room
 * @Description: 房间服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface RoomService {

    /**
	 * @Title: addRoom
	 * @Description:添加房间
	 * @param room 实体
	 * @return Integer
	 */
	Room addRoom(Room room);
	
	/**
	 * @Title modifyRoom
	 * @Description:修改房间
	 * @param room 实体
	 * @return Integer
	 */
	Integer modifyRoom(Room room);
	
	/**
	 * @Title: dropRoomByRoomId
	 * @Description:删除房间
	 * @param roomId 实体标识
	 * @return Integer
	 */
	Integer dropRoomByRoomId(String roomId);
	
	/**
	 * @Title: queryRoomByRoomId
	 * @Description:根据实体标识查询房间
	 * @param roomId 实体标识
	 * @return Room
	 */
	Room queryRoomByRoomId(String roomId);
	 
	/**
	 * @Title: queryRoomForPage
	 * @Description: 根据房间属性与分页信息分页查询房间信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param room 实体
	 * @return List<Room>
	 */
	Map<String, Object> queryRoomForPage(Integer pagenum, Integer pagesize, String sort, Room room);
	 
	 /**
	 * @Title: queryRoomByProperty
	 * @Description:根据属性查询房间
	 * @return List<Room>
	 */
	 List<Room> queryRoomByProperty(Map<String, Object> map);	 
	 
}
