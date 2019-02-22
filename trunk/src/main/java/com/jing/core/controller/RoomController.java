package com.jing.core.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.utils.BaseController;
import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.core.model.entity.Room;
import com.jing.core.service.RoomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>房间 WEB接口<br>
 * <br>
 */
@Api("客房")
@Controller
@RequestMapping("/core/room")
public class RoomController extends BaseController{

	@Autowired
	private RoomService roomService;
	
	@ApiOperation(value = "新增房间", notes = "添加房间")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Room room,@SessionAttr(Config.USER_INFO) User user) {
		room.setCreatedBy(user.getUserId());
		room.setCreatedDateNow();
		room.setUpdatedBy(user.getUserId());
		room.setUpdatedDateNow();
		roomService.addRoom(room);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改房间", notes = "修改房间")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Room room,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(room==null || room.getRoomId()==null || "".equals(room.getRoomId())){
			throw new CustomException("缺失修改参数.");
		}
		room.setUpdatedBy(user.getUserId());
		room.setUpdatedDateNow();
		roomService.updateRoom(room);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "打扫房间", notes = "修改房间")
	@RequestMapping(value = "/clean/{rid}", method = RequestMethod.GET)
	public @ResponseBody Result clean( @ApiParam("rid") @PathVariable("rid") String rid,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		Room room = roomService.getRoomById(rid);
		room.setRoomStatus(2);
		roomService.updateRoom(room);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除房间", notes = "根据ID删除房间")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		roomService.deleteRoomById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询房间", notes = "根据ID查询房间")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(roomService.getRoomById(id));
	}
		
	@ApiOperation(value = "分页查询房间", notes = "分页查询房间")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return roomService.findRoomListPage(PageRequestUtils.getPageBean(request), map);
	}
}