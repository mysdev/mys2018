package com.jing.system.logger;

import javax.servlet.http.HttpServletRequest;

import com.jing.config.web.exception.CustomException;
import com.jing.system.logger.service.DbloggerService;
import com.jing.system.login.session.Config;
import com.jing.system.user.entity.User;
import com.jing.utils.SpringContextHolder;

import eu.bitwalker.useragentutils.UserAgent;

public class DbLogger {

	private static final DbloggerService logger = getPasmpDbLogservice();

	/**
	 * @Description: 登陆日志-成功
	 * @author LIFENG
	 */
	public static void login(String userName, HttpServletRequest request) {
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		logger.logger(userName, getIp(request), userAgent.getBrowser().toString(), "登录成功", null);
	}

	/**
	 * @Description: 登陆日志-失败
	 * @author LIFENG
	 */
	public static void loginError(String userName, HttpServletRequest request) {
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		logger.logger(userName, getIp(request), userAgent.getBrowser().toString(), "登录失败", null);
	}

	/**
	 * 日常日志
	 * 
	 * @param request
	 * @param subject
	 * @param centent
	 */
	public static void info(HttpServletRequest request, String subject, String centent) {
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		logger.logger(getUser(request), getIp(request), userAgent.getBrowser().toString(), subject, centent);
	}
	
	/**
	 * 日常日志
	 * 
	 * @param request
	 * @param subject
	 * @param centent
	 */
	public static void info(HttpServletRequest request, String subject) {
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		logger.logger(getUser(request), getIp(request), userAgent.getBrowser().toString(), subject, null);
	}

	/**
	 * 错误日志
	 * 
	 * @param request
	 * @param ex
	 */
	public static void error(HttpServletRequest request, Exception ex) {
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		logger.logger(getUser(request), getIp(request), userAgent.getBrowser().toString(), ex.getMessage(),
				ex.getStackTrace().toString());
	}

	private static String getUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Config.USER_INFO);
		if (user != null) {
			return user.getUsername().toString();
		} else {
			return "匿名用户";
		}
	}

	private static String getIp(HttpServletRequest request) {
		String ip;
		if (request.getHeader("x-forwarded-for") == null) {
			ip = request.getRemoteAddr();
		} else {
			ip = request.getHeader("x-forwarded-for");
		}
		return ip;
	}

	private static DbloggerService getPasmpDbLogservice() {
		try {
			return (DbloggerService) SpringContextHolder.getBean(DbloggerService.class);
		} catch (Exception e) {
			throw new CustomException("系统未指定日志服务类.");
		}
	}
}
