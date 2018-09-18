package com.jing.system.permission.controller;

import java.util.Iterator;
import java.util.List;
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
import com.jing.system.permission.entity.Role;
import com.jing.system.permission.service.RoleService;
import com.jing.system.user.entity.User;
import com.jing.utils.BaseController;
import com.jing.utils.FrameworkUtils;

/**
 * <br>
 * <b>功能：</b>角色 WEB接口<br>
 * <br>
 */
@Controller
@RequestMapping("/sys/permission/role")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;

	/**
	 * 新增保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Role role) throws CustomException {
		roleService.addRole(role);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Role role) throws CustomException {
		if (role == null || role.getRoleId() == null || "".equals(role.getRoleId())) {
			throw new CustomException("缺失修改参数.");
		}
		roleService.updateRole(role);
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
		roleService.deleteRoleById(id);
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
		return Result.getDefaultSuccMsgResult(roleService.getRoleById(id));
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request) throws Exception {
		Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return roleService.findRoleListPage(PageRequestUtils.getPageBean(request), map);
	}

	/**
	 * 查询所有角色(带权限)
	 * 
	 * @param user
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/alllist", method = RequestMethod.POST)
	public @ResponseBody Result findMyList(@SessionAttr(Config.USER_INFO) User user, HttpServletRequest request)
			throws Exception {
		Integer userId = user.getUserId();
		return Result.getDefaultSuccMsgResult(roleService.findRoleListAll(userId));
	}

	/**
	 * 查询部门下用户的角色
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectRole", method = RequestMethod.POST)
	public @ResponseBody Result selectRoleByDeptCode(@RequestParam(value = "deptCode") String deptCode)
			throws Exception {
		return Result.getDefaultSuccMsgResult(roleService.selectRoleByDeptCode(Integer.parseInt(deptCode)));
	}

	/**
	 * 查询角色【去除了ROLE0,ROLE1】
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Result selectRoles(HttpServletRequest request) {
		List<Role> list = roleService.findRoleList(FrameworkUtils.hashMap("status", 1));
		if(request.getParameter("all")==null){
			for (Iterator<Role> ite = list.iterator(); ite.hasNext();) {
				Role role = ite.next();
				if ("ROLE0".equals(role.getRoleId()) || "ROLE1".equals(role.getRoleId())) {
					ite.remove();
				}
			}
		}
		return Result.getDefaultSuccMsgResult(list);
	}
}