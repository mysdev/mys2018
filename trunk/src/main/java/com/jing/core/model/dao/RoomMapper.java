package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.Room;

/**
 * @ClassName: RoomMapper
 * @Description: 房间映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface RoomMapper {

	/**
	 * @Title: addRoom
	 * @Description:添加房间
	 * @param room 实体
	 * @return Integer
	 */
	Integer addRoom(Room room);
	
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
	 * @param pageBounds 分页信息
	 * @param room 实体
	 * @return List<Room>
	 */
	List<Room> queryRoomForPage(PageBounds pageBounds, @Param("room") Room room);
	 
	 /**
	  * @Title: queryRoomByProperty
	  * @Description:根据属性查询房间
	  * @return List<Room>
	  */
	 List<Room> queryRoomByProperty(@Param("room") Map<String, Object> map);
	 
	 
	 
}
