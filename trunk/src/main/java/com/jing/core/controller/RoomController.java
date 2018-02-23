package com.jing.core.controller;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import com.jing.config.validation.BeanValidator;
import com.jing.core.model.entity.Room;
import com.jing.core.service.RoomService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: RoomController
 * @Description: 房间HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="房间", tags={"CoreRoom"})
public class RoomController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private RoomService roomService;

	
	@ApiOperation(value = "新增 添加房间信息", notes = "添加房间信息")
	@RequestMapping(value = "/room", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addRoom(HttpServletResponse response,
			@ApiParam(value = "room") @RequestBody Room room) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(room, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		room.setRoomId(null);
		roomService.addRoom(room);
		return room;
	}
	
	
	@ApiOperation(value = "更新 根据房间标识更新房间信息", notes = "根据房间标识更新房间信息")
	@RequestMapping(value = "/room/{roomId:.+}", method = RequestMethod.PUT)
	public Object modifyRoomById(HttpServletResponse response,
			@PathVariable String roomId,
			@ApiParam(value = "room", required = true) @RequestBody Room room
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(room, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Room tempRoom = roomService.queryRoomByRoomId(roomId);
		room.setRoomId(roomId);
		if(null == tempRoom){
			throw new NotFoundException("房间");
		}
		return roomService.modifyRoom(room);
	}

	@ApiOperation(value = "删除 根据房间标识删除房间信息", notes = "根据房间标识删除房间信息")
	@RequestMapping(value = "/room/{roomId:.+}", method = RequestMethod.DELETE)
	public Object dropRoomByRoomId(HttpServletResponse response, @PathVariable String roomId) {
		Room room = roomService.queryRoomByRoomId(roomId);
		if(null == room){
			throw new NotFoundException("房间");
		}
		return roomService.dropRoomByRoomId(roomId);
	}
	
	@ApiOperation(value = "查询 根据房间标识查询房间信息", notes = "根据房间标识查询房间信息")
	@RequestMapping(value = "/room/{roomId:.+}", method = RequestMethod.GET)
	public Object queryRoomById(HttpServletResponse response,
			@PathVariable String roomId) {
		Room room = roomService.queryRoomByRoomId(roomId);
		if(null == room){
			throw new NotFoundException("房间");
		}
		return room;
	}
	
	@ApiOperation(value = "查询 根据房间属性查询房间信息列表", notes = "根据房间属性查询房间信息列表")
	@RequestMapping(value = "/room", method = RequestMethod.GET)
	public Object queryRoomList(HttpServletResponse response,
			Room room) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return roomService.queryRoomByProperty(ClassUtil.transBean2Map(room, false));
	}
	
	@ApiOperation(value = "查询分页 根据房间属性分页查询房间信息列表", notes = "根据房间属性分页查询房间信息列表")
	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
	public Object queryRoomPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Room room) {				
		return roomService.queryRoomForPage(pagenum, pagesize, sort, room);
	}

}
