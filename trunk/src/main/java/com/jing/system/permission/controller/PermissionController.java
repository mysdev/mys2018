package com.jing.system.permission.controller;

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
import com.jing.system.permission.entity.Permission;
import com.jing.system.permission.entity.Resources;
import com.jing.system.permission.service.PermissionService;
import com.jing.system.user.entity.User;
import com.jing.utils.BaseController;

/**
 * <br>
 * <b>功能：</b>权限 WEB接口<br>
 * <br>
 */
@Controller
@RequestMapping("/sys/permission")
public class PermissionController extends BaseController {

	@Autowired
	private PermissionService permissionService;

	/**
	 * 新增保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Permission permission) throws CustomException {
		permissionService.addPermission(permission);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Permission permission) throws CustomException {
		if (permission == null || permission.getRoleId() == null || "".equals(permission.getRoleId())) {
			throw new CustomException("缺失修改参数.");
		}
		permissionService.updatePermission(permission);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@PathVariable("id") String id) throws CustomException {
		if (id == null || "".equals(id)) {
			throw new CustomException("缺失删除参数.");
		}
		permissionService.deletePermssionByRoleId(id);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable("id") String id) throws CustomException {
		if (id == null || "".equals(id)) {
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(permissionService.getPermissionById(id));
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request) throws Exception {
		Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return permissionService.findPermissionListPage(PageRequestUtils.getPageBean(request), map);
	}

	/**
	 * 分配角色
	 * 
	 * @param roleId
	 * @param resId
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping(value = "/addPermission", method = RequestMethod.POST)
	public @ResponseBody Result addPermission(@RequestParam("roleId") String roleId, @RequestParam("resId") String resId)
			throws CustomException {
		permissionService.addPermission(roleId, resId);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 查询查单下的按钮权限
	 * 
	 * @param resId
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/action", method = RequestMethod.GET)
	public @ResponseBody Result findActions(@RequestParam(value="pageButtonKey") String pageButtonKey,@RequestParam(value="resId") int resId, @SessionAttr(Config.USER_INFO) User user) {
		return Result.getDefaultSuccMsgResult(permissionService.findActions(user,resId, pageButtonKey));
	}
	
	/**
	 * 查询菜单[resType=菜单，而且是有权限的]
	 * [如果请求中有参数menuId,返回的是用户有权限的子菜单][否则就查询用户有权限的顶级菜单返回]
	 */
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public @ResponseBody Result menu(Resources resources,@SessionAttr(Config.USER_INFO) User user)throws CustomException  {
		return Result.getDefaultSuccMsgResult(permissionService.findMyMenus(user.getUserId()));
	}
}