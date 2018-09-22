package com.jing.core.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.core.model.entity.Room;

@Mapper
public interface RoomMapper {

	/**
	* 添加 房间
	*/
	void addRoom(Room room);
	
	/**
	* 修改 房间
	*/
	void updateRoom(Room room);
	
	/**
	*根据ID删除记录
	*/
	void deleteRoomById(String id);	
	
	/**
	*根据ID查询记录
	*/
	Room getRoomById(String id);
	
	/**
	* 分页查询
	*/
	List<Room> findRoomListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询房间
	 * @param param
	 * @return
	 */
	List<Room> findRoomList(@Param("param") Map<String, Object> param);	
}