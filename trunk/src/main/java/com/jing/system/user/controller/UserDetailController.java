package com.jing.system.user.controller;

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
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.system.user.entity.UserDetail;
import com.jing.system.user.service.UserDetailService;
import com.jing.utils.BaseController;

/**
 * <br>
 * <b>功能：</b>用户详情 WEB接口<br>
 * <br>
 */
@Controller
@RequestMapping("/sys/user/detail")
public class UserDetailController extends BaseController{

	@Autowired
	private UserDetailService userDetailService;
	
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody Result register(UserDetail userDetail,HttpServletRequest request)throws CustomException  {
		String roleId = request.getParameter("roleId");
		userDetailService.addFullUser(userDetail,roleId);
		return Result.getDefaultSuccMsgResult();
	}
	
	/**
	 * 新增保存
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(UserDetail userDetail)throws CustomException  {
		userDetailService.addUserDetail(userDetail);
		return Result.getDefaultSuccMsgResult();
	}
	
	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(UserDetail userDetail,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(userDetail==null || userDetail.getUserId()==null){
			throw new CustomException("缺失修改参数.");
		}
		userDetail.setUserId(user.getUserId());
		UserDetail ud = userDetailService.getUserDetailByIdSimple(user.getUserId());
		if(ud==null){
			userDetailService.addUserDetail(userDetail);
		}else{
			userDetailService.updateUserDetail(userDetail);
		}
		return Result.getDefaultSuccMsgResult();
	}

	
	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@PathVariable int id)throws CustomException {
		userDetailService.deleteUserDetailById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable("id") int id)throws CustomException {
		return Result.getDefaultSuccMsgResult(userDetailService.getUserDetailById(id));
	}
	
	
	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return userDetailService.findUserDetailListPage(PageRequestUtils.getPageBean(request), map);
	}
	
	/**
	 * 分页查询 user
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userpage", method = RequestMethod.POST)
	public @ResponseBody PageInfo finduserPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		if(map.get("areaCode") ==null || "".equals(map.get("areaCode"))){
			return new PageInfo();
		}
		return userDetailService.findGridUserDetailListPage(PageRequestUtils.getPageBean(request), map);
	}
	
	/**
	 * 查询
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Result findList(HttpServletRequest request)throws Exception {
		Map<String,Object> param=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		if(param.get("roleId") !=null){
			param.put("roleId", param.get("roleId").toString().split(",",-1));
		}
		if(param.get("deptCode") !=null){
			param.put("deptCode", param.get("deptCode").toString().split(",",-1));
		}
		if(param.get("areaCode") !=null){
			param.put("areaCode", param.get("areaCode").toString().split(",",-1));
		}
		return Result.getDefaultSuccMsgResult(userDetailService.findUserListComplex(param));
	}
	
}