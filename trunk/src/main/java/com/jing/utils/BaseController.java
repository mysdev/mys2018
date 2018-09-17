package com.jing.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;

import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.system.login.session.Config;
import com.jing.system.user.entity.User;

public class BaseController {

	protected final static String INDEX_PATH = "/index";
	protected final static String ADD_PATH = "/save";
	protected final static String UPDATE_PATH = "/update";
	protected final static String LIST_PATH = "/list";
	protected final static String DELETE_PATH = "/delete";
	protected final static String PAGE_PARAMETER = "?action=cls";

	protected final static String ADD_INDEX_PATH = ADD_PATH + INDEX_PATH;

	protected Log logger = LogFactory.getLog(this.getClass());

	protected String getForward(String path) {
		return "forward:" + path;
	}

	protected String getRedirect(String path) {
		return "redirect:" + path;
	}

	protected String goToErrorPage(ModelMap modelMap, String message, Exception e) {
		logger.error(message, e);
		modelMap.put("message", message + " " + e.getMessage());
		return "errorView";
	}

	protected String goToErrorPage(ModelMap modelMap, String message) {
		modelMap.put("message", message);
		return "errorView";
	}

	/**
	 * @param e
	 */
	protected void error(Exception e) {
		logger.error(e.getStackTrace());
	}

	/**
	 * @param e
	 * @return
	 */
	protected Result SysErrorMsg(Exception e) {
		error(e);
		return Result.getErroMsgResult("系统错误！");
	}

	@SuppressWarnings("unchecked")
	protected <T> T getObjectByRequest(Class<T> cls, HttpServletRequest request) throws CustomException {
		try {
			T model = cls.newInstance();
			if (BaseEntity.class.isAssignableFrom(cls)) {
				Class<?> tclass = cls;
				while (!tclass.getSimpleName().equals("BaseEntity")) {
					Field[] fileds = tclass.getDeclaredFields();// 获取所有属性
					for (Field f : fileds) {
						f.setAccessible(true);
						String key = f.getName();
						String value = request.getParameter(key);
						if (value != null && !"".equals(value)) {
							setValue(model, f, value);
						}
					}
					tclass = tclass.getSuperclass();
				}
				// createby ,updateby
				BaseEntity res = (BaseEntity) model;
				User user = (User) request.getSession().getAttribute(Config.USER_INFO);
				if (user != null) {
					res.setCreatedBy(user.getUserId());
					res.setUpdatedBy(user.getUserId());
					res.setCreatedDateNow();
					res.setUpdatedDateNow();
				}
				return (T) res;
			} else {
				Field[] fileds = cls.getDeclaredFields();// 获取所有属性
				for (Field f : fileds) {
					f.setAccessible(true);
					String key = f.getName();
					String value = request.getParameter(key);
					if (value != null && !"".equals(value)) {
						setValue(model, f, value);
					}
				}
				return model;
			}

		} catch (Exception e) {
			logger.error("从request获取参数错误！", e);
			throw new CustomException("从request获取参数错误！");
		}

	}

	/**
	 * 通过反射设置值到model中
	 * 
	 * @param model
	 * @param f
	 * @param value
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private void setValue(Object model, Field f, String value) throws IllegalArgumentException, IllegalAccessException {
		f.setAccessible(true);// 设置值可访问
		String type = f.getType().toString();// 得到此属性的类型
		if (type.endsWith("String")) {
			f.set(model, value.toString());
		} else if (type.endsWith("int") || type.endsWith("Integer")) {
			f.set(model, Integer.parseInt(value.toString()));
		} else if (type.endsWith("Float") || type.endsWith("float")) {
			f.set(model, Float.parseFloat(value.toString()));
		} else if (type.endsWith("Long") || type.endsWith("long")) {
			f.set(model, Long.parseLong(value.toString()));
		} else if (type.endsWith("Date")) {
			// yyyy-MM-dd HH:mm:ss
			if (value != null && (value.length() == 10 || value.length() == 9)) {
				f.set(model, DateUtils.parseDateFormat(value, "yyyy-MM-dd"));
			} else if (value != null && value.length() == 19) {
				f.set(model, DateUtils.parseDateFormat(value, "yyyy-MM-dd HH:mm:ss"));
			} else if (value != null && value.length() == 16) {
				f.set(model, DateUtils.parseDateFormat(value, "yyyy-MM-dd HH:mm"));
			}
		} else if (type.endsWith("BigDecimal")) {
			f.set(model, new BigDecimal(value));
		} else {
			// 其他待定
		}
	}

}
