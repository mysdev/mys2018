package com.jing.system.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.system.user.service.UserService;
import com.jing.system.user.uitl.UserMapper;
import com.jing.utils.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <br>
 * <b>功能：</b>用户 WEB接口<br>
 * <br>
 */
@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 * 新增保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add/{deptCode}", method = RequestMethod.POST)
	public @ResponseBody Result add(User user, @PathVariable("deptCode") int deptCode) throws CustomException {
		if (user.getUsername().indexOf(" ") >= 0) {
			throw new CustomException("用户名不允许包含空格.");
		}
		userService.addUser(user, deptCode);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(User user) throws CustomException {
		if (user == null || user.getUserId() == null) {
			throw new CustomException("缺失修改参数.");
		}
		userService.updateUser(user);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@SessionAttr(Config.USER_INFO) User user, @PathVariable("userId") int userId,
			@RequestParam("deptCode") int deptCode) throws CustomException {
		if (user.getUserId().intValue() == userId) {
			return Result.getErroMsgResult("用户不能删除自己");
		}
		userService.deleteUserById(userId, deptCode);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable("id") int id) throws CustomException {
		return Result.getDefaultSuccMsgResult(userService.getUserById(id));
	}
	
	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getByUsername", method = RequestMethod.GET)
	public @ResponseBody Result getByUsername(@RequestParam("username") String username) throws CustomException {
		if(UserMapper.getObj(username) != null) {
			return Result.getDefaultSuccMsgResult(UserMapper.getObj(username));
		}else {
			return Result.getWaringMsgResult("用户不存在.");
		}
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request) throws Exception {
		Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return userService.findUserListPage(PageRequestUtils.getPageBean(request), map);
	}

	/**
	 * 修改密码
	 * 
	 * @param uid
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "用户修改自己密码", notes = "用户修改自己密码", response = Result.class)
	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public @ResponseBody Result updatePassword(@SessionAttr(Config.USER_INFO) User user, HttpServletRequest request)
			throws Exception {
		String password = request.getParameter("newpassword");
		String oldpassword = request.getParameter("oldpassword");
		Integer userId = user.getUserId();
		userService.resetPassword(user.getUsername(), oldpassword, password, userId);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 修改密码
	 * 
	 * @param uid
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "用户修改自己密码", notes = "用户修改自己密码", response = Result.class)
	@RequestMapping(value = "/restPassword", method = RequestMethod.POST)
	public @ResponseBody Result resetPassword(@RequestParam("userId") int userId) throws Exception {
		User newUser = new User();
		newUser.setUserId(userId);
		newUser.setPassword(User.DEFAULT_PASSWORD);
		userService.updateUser(newUser);
		return Result.getDefaultSuccMsgResult();
	}
}