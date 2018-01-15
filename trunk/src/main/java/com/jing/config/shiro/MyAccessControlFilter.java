package com.jing.config.shiro;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpServletResponse;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.jing.system.service.RolePermissionService;
import com.jing.utils.SpringContextUtils;

/**
 * <p>
 * User: Lifeng
 * <p>
 * Date: 14-2-3
 * <p>
 * Version: 1.0
 */
public class MyAccessControlFilter extends AccessControlFilter {
	private RolePermissionService permission;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		//判定是否匹配到当前filter
		
		ShiroHttpServletRequest hrequest = (ShiroHttpServletRequest) request;
		ShiroHttpServletResponse hresponse = (ShiroHttpServletResponse) response;
		// StringBuffer url = hrequest.getRequestURL();
		String method = hrequest.getMethod();
		String url = null;

		ServletContext servletContext = hrequest.getSession().getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		Map<String, HandlerMapping> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(context,
				HandlerMapping.class, true, false);
		if (!matchingBeans.isEmpty()) {
			for (HandlerMapping handlerMapping : matchingBeans.values()) {
				// 本项目只需要RequestMappingHandlerMapping中的URL映射
				if (handlerMapping instanceof RequestMappingHandlerMapping) {
					try {
						HandlerExecutionChain hc = ((RequestMappingHandlerMapping) handlerMapping).getHandler(hrequest);
						if (hc != null) {
							HandlerMethod handler = (HandlerMethod) hc.getHandler();
							// method
							// 优先取method的RequestMapping注解的value，然后再取method的class的RequestMapping注解value
							RequestMapping rm = handler.getMethodAnnotation(RequestMapping.class);
							String value = rm.value()[0];
							url = value.replaceAll("\\{[^}]*\\}", "{}");
						} else {
							url = hrequest.getRequestURI();
						}
					} catch (Exception e) {
						return false;
					}
				}
			}
		}
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return this.checkUrl(url.toString(), method, hresponse);
		}else {
			return false;
		}
		
		// throw new UnauthorizedException("no");
	}

	boolean checkUrl(String url, String method, HttpServletResponse response) {
		if (permission == null) {
			permission = (RolePermissionService) SpringContextUtils.getBean(RolePermissionService.class);
		}
		if (!permission.havePermission("/mys"+url, method,
				 SecurityUtils.getSubject().getPrincipal().toString())) {
			response.setStatus(403);
//			throw new UnauthorizedException("没有权限执行" + url + " " + method);
			return false;
		}
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// 如果登录了，就不继续后面的拦截器了，否则继续
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		String str = "/user/{userId}";
		System.out.println(str.replaceAll("\\{[^}]*\\}", "{}"));
		Pattern p = Pattern.compile("\\{.*?\\}}");
		Matcher m = p.matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
