package com.jing.system.login.controller;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.config.web.Result;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.utils.BaseController;
import com.jing.utils.VerifyCodeIcon;

@Controller
public class LoginController extends BaseController {

	@RequestMapping(value = "/logout")
	public @ResponseBody boolean logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		User user = (User) request.getSession().getAttribute(Config.USER_INFO);
		clean(request, response, request.getSession());
		return true;
	}

	/**
	 * @param request
	 * @param response
	 * @param hs
	 */
	private void clean(HttpServletRequest request, HttpServletResponse response, HttpSession hs) {
		// 将session失效
		if (hs != null) {
			hs.invalidate();
		}
		// 清除sso cookie
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if ((cookies[i].getName()).equals("SMSESSION")) {
				String val = cookies[i].getValue();
				Cookie cookie = new Cookie("SMSESSION", val);
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String get(ModelMap model, HttpServletRequest request) throws Exception {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String post(ModelMap model, HttpServletRequest request) throws Exception {
		return "login";
	}

	@RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	public @ResponseBody boolean success(ModelMap model, HttpServletRequest request) throws Exception {
		return true;
	}

	@RequestMapping(value = "/login/user", method = RequestMethod.POST)
	public @ResponseBody User getUser(@SessionAttr(Config.USER_INFO) User user) throws Exception {
		// Area area = areaService.queryAreaInfoByAreaID(user.getAreaId());
		// user.setAreaName(area.getAreaName());
//		UserDetail ud = userDetailService.getUserDetailById(user.getUserId());
//		ud.setDeptCode(user.getDeptCode());
//		List roles = user.getUserRole();
//		ud.setUserRole(roles);
		return user;
	}
	
	@RequestMapping(value = "/login/setDept", method = RequestMethod.POST)
	public @ResponseBody Result setDept(@SessionAttr(Config.USER_INFO) User user,@RequestParam("deptCode") int deptCode) throws Exception {
		user.setDeptCode(deptCode);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName",user.getUsername());
		map.put("userId",user.getUserId());
		map.put("nickName",user.getNickName());
		map.put("deptCode",deptCode);	
		return Result.getDefaultSuccMsgResult(map);
	}

	@RequestMapping(value = "/login/checkcode", method = RequestMethod.GET)
	public void checkcode(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		VerifyCodeIcon vc = new VerifyCodeIcon();
		HttpSession session = request.getSession();
		BufferedImage bi = vc.getVerifyImg();
		session.setAttribute("validateCode", vc.getValidateCode());
		// 禁止图像缓存。
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(bi, "jpeg", sos);
		sos.close();

	}
}