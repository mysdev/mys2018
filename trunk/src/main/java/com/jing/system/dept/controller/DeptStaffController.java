package com.jing.system.dept.controller;

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
import com.jing.system.dept.entity.DeptStaff;
import com.jing.system.dept.service.DeptStaffService;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.utils.BaseController;

import io.swagger.annotations.Api;

/**
 * <br>
 * <b>功能：</b>部门职工 WEB接口<br>
 * <br>
 */
@Api("职员")
@Controller
@RequestMapping("/sys/dept/staff")
public class DeptStaffController extends BaseController {

	@Autowired
	private DeptStaffService deptStaffService;

	/**
	 * 新增保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(DeptStaff deptStaff, @SessionAttr(Config.USER_INFO) User user)
			throws CustomException {
		deptStaff.setCreatedBy(user.getUserId());
		deptStaff.setCreatedDateNow();
		deptStaff.setUpdatedBy(user.getUserId());
		deptStaff.setUpdatedDateNow();
		deptStaffService.addDeptStaff(deptStaff);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(DeptStaff deptStaff, @SessionAttr(Config.USER_INFO) User user)
			throws CustomException {
		if (deptStaff == null || deptStaff.getDsid() == null) {
			throw new CustomException("缺失修改参数.");
		}
		deptStaff.setUpdatedBy(user.getUserId());
		deptStaff.setUpdatedDateNow();
		deptStaffService.updateDeptStaff(deptStaff);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@PathVariable("id") int id) throws CustomException {
		deptStaffService.deleteDeptStaffById(id);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable("id") Integer id) throws CustomException {
		return Result.getDefaultSuccMsgResult(deptStaffService.getDeptStaffById(id));
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request) throws Exception {
		Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return deptStaffService.findDeptStaffListPage(PageRequestUtils.getPageBean(request), map);
	}
	
	/**
	 * 属性查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Result findDeptStaffList(HttpServletRequest request) throws Exception {
		Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return Result.getDefaultSuccMsgResult(deptStaffService.findDeptStaffList(map));
	}
}