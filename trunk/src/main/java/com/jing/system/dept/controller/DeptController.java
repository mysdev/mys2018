package com.jing.system.dept.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.system.dept.entity.Dept;
import com.jing.system.dept.service.DeptService;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.utils.BaseController;
import com.jing.utils.FrameworkUtils;

/**
 * <br>
 * <b>功能：</b>部门 WEB接口<br>
 * <br>
 */
@Controller
@RequestMapping("/sys/dept")
public class DeptController extends BaseController {

	@Autowired
	private DeptService deptService;

	/**
	 * 新增保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Dept dept, @SessionAttr(Config.USER_INFO) User user) throws CustomException {
		dept.setCreatedBy(user.getUserId());
		dept.setCreatedDateNow();
		dept.setUpdatedBy(user.getUserId());
		dept.setUpdatedDateNow();
		deptService.addDept(dept);
		return Result.getDefaultSuccMsgResult(dept);
	}

	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Dept dept, @SessionAttr(Config.USER_INFO) User user) throws CustomException {
		if (dept == null || dept.getDeptCode() == null) {
			throw new CustomException("缺失修改参数.");
		}
		dept.setUpdatedBy(user.getUserId());
		dept.setUpdatedDateNow();
		deptService.updateDept(dept);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@PathVariable("id") Integer id) throws CustomException {
		deptService.deleteDeptById(id);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable("id") Integer id) throws CustomException {
		return Result.getDefaultSuccMsgResult(deptService.getDeptById(id));
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request) throws Exception {
		Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return deptService.findDeptListPage(PageRequestUtils.getPageBean(request), map);
	}

	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public @ResponseBody List<Dept> tree(HttpServletRequest request) throws CustomException {
		String str = request.getParameter("pid");
		if (str == null || "".equals(str)) {
			str = "0";
		}
		return deptService.findDeptList(FrameworkUtils.hashMap("pid", Integer.parseInt(str)));
	}

}