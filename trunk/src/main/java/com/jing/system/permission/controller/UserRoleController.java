package com.jing.system.permission.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.system.permission.entity.UserRole;
import com.jing.system.permission.service.UserRoleService;
import com.jing.utils.BaseController;

import io.swagger.annotations.Api;

@Api("用户角色(授权)管理")
@Controller
@RequestMapping("/sys/permission/userRole")
public class UserRoleController extends BaseController {
	@Autowired
	private UserRoleService userRoleService;
	/**
	 * 给角色批量添加用户
	 */
	@RequestMapping(value = "/saveUser/{roleId}", method = RequestMethod.POST)
	public @ResponseBody Result saveUser(@PathVariable String roleId) throws CustomException {

		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 给用户批量添加角色
	 */
	@RequestMapping(value = "/saveRole/{userId}", method = RequestMethod.POST)
	public @ResponseBody Result saveRole(@PathVariable int userId) throws CustomException {
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 给一个用户分配一个角色
	 * 
	 * @param roleId
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result saveUserRole(@RequestParam("userId") int userId, @RequestParam("roleId") String roleId,@RequestParam(value="deptCode") String deptCode)
			throws CustomException {
		UserRole userRole = new UserRole();
		userRole.setUserId(userId);
		userRole.setRoleId(roleId);
		userRole.setDeptCode(Integer.parseInt(deptCode));
		userRoleService.addUserRole(userRole);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 删除一个用户的一个角色
	 * 
	 * @param roleId
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Result saveUser(@RequestParam("userId") int userId, @RequestParam("roleId") String roleId,@RequestParam(value="deptCode") int deptCode) throws CustomException {
		userRoleService.deleteUserRoleByUserIdAndRoleId(userId, roleId,deptCode);
		return Result.getDefaultSuccMsgResult();
	}
	/**
	 * 查询用户拥有的角色
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getUserRole", method = RequestMethod.POST)
	public @ResponseBody Result getUserRole(@RequestParam("userId") int userId){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		return Result.getDefaultSuccMsgResult(userRoleService.findUserRoleList(map));		
	}
}
