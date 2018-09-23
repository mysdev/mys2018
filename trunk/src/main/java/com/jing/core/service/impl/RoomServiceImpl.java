package com.jing.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;

import com.jing.core.model.entity.Room;
import com.jing.core.model.dao.RoomMapper;
import com.jing.core.service.RoomService;
import com.jing.utils.PrimaryKey;

@Service("roomService")
public class RoomServiceImpl implements RoomService{

	@Resource
	private RoomMapper roomMapper;

	/**
	* 添加 房间
	*/
	@Override
	public void addRoom(Room room){
		room.setRoomId(PrimaryKey.getUUID());
		roomMapper.addRoom(room);
	}
	
	/**
	* 修改 房间
	*/
	@Override
	public void updateRoom(Room room){
		roomMapper.updateRoom(room);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deleteRoomById(String id){
		roomMapper.deleteRoomById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Room getRoomById(String id){
		return roomMapper.getRoomById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findRoomListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(roomMapper.findRoomListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询房间
	 * @param param
	 * @return
	 */
	 @Override
	public List<Room> findRoomList(Map<String, Object> param){
		return roomMapper.findRoomList(param);
	}
	
}