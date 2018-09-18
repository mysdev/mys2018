package com.jing.config.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.jing.config.web.exception.CustomException;
import com.jing.system.login.LoginService;
import com.jing.utils.SpringContextHolder;

/**
 * 
 * 
 * @author WUYANPING007
 * @createDate 2015-4-23
 * @modifyBy WUYANPING007
 * @modifyDate 2015-4-23
 */
public class PermissionSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	protected Log logger = LogFactory.getLog(this.getClass());

	private AntPathMatcher urlMatcher = new AntPathMatcher();

	private LoginService loginService = this.getLoginService();

	public PermissionSecurityMetadataSource() {

	}

	private List<String> patternPath;// 无需验证权限的资源

	private Collection<ConfigAttribute> allAttribute = new HashSet<ConfigAttribute>();

	/**
	 * Description
	 * 
	 * @return
	 * @see org.springframework.security.access.SecurityMetadataSource#getAllConfigAttributes()
	 */

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return this.allAttribute;
	}

	/**
	 * Description
	 * 
	 * @param arg0
	 * @return
	 * @throws IllegalArgumentException
	 * @see org.springframework.security.access.SecurityMetadataSource#getAttributes(java.lang.Object)
	 */
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		String requestMappingValue = null;
		HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
		ServletContext servletContext = request.getSession().getServletContext();
		if (servletContext == null) {
			return null;
		}
		try {
			WebApplicationContext context = (WebApplicationContext) servletContext
					.getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet");
			// 获取所有的RequestMapping
			Map<String, HandlerMapping> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(context,
					HandlerMapping.class, true, false);
			if (!matchingBeans.isEmpty() && isNeedCheckUrl(requestUrl)) {
				for (HandlerMapping handlerMapping : matchingBeans.values()) {
					// 本项目只需要RequestMappingHandlerMapping中的URL映射
					if (handlerMapping instanceof RequestMappingHandlerMapping) {
						HandlerExecutionChain hc = ((RequestMappingHandlerMapping) handlerMapping).getHandler(request);
						if (hc != null) {
							HandlerMethod handler = (HandlerMethod) hc.getHandler();
							// method
							// 优先取method的RequestMapping注解的value，然后再取method的class的RequestMapping注解value
							RequestMapping rm = handler.getMethodAnnotation(RequestMapping.class);
							if (rm.value().length > 0) {
								requestMappingValue = rm.value()[0];
								rm = handler.getBeanType().getAnnotation(RequestMapping.class);
								if (rm != null && rm.value().length > 0) {
									requestMappingValue = rm.value()[0] + requestMappingValue;
									break;
								}
							} else {
								rm = handler.getBeanType().getAnnotation(RequestMapping.class);
								if (rm.value().length > 0) {
									requestMappingValue = rm.value()[0];
									break;
								} else {
									logger.error("系统错误，获取注解controller路径失败！");
									throw new CustomException("系统错误！");
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("系统错误，权限验证失败:" + requestUrl);
			throw new CustomException("系统错误,无授权.");
		}

		if (requestMappingValue != null) {
			if (requestUrl.indexOf("?") > 0) {
				requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
			}
			this.logger.info("请求的资源为：" + requestUrl);

			if (!requestUrl.equals(requestMappingValue) && requestMappingValue.indexOf("{") >= 0) {
				// 请求/index/5，响应/index/{id},进行相同转化
				requestMappingValue = requestUrl.substring(0, requestMappingValue.indexOf("{") - 1);
			}
			if (!requestUrl.equals(requestMappingValue) && requestMappingValue.indexOf(".") >= 0) {
				// 请求/index/5，响应/index/{id},进行相同转化
				requestMappingValue = requestUrl.substring(0, requestMappingValue.indexOf(".") - 1);
			}
			List<SecurityRoleDetail> resRoleList = loginService.getRolesByResUrl(requestMappingValue);
			// 验证该资源的是否设置了访问权限
			validSetRole(requestUrl, resRoleList);
			Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
			for (SecurityRoleDetail role : resRoleList) {
				atts.add(new SecurityConfig(role.getRoleName()));
			}
			return atts;

		}
		return null;
	}

	private LoginService getLoginService() {
		try {
			LoginService loginService = (LoginService) SpringContextHolder.getBean(LoginService.class);
			return loginService;
		} catch (Exception e) {
			throw new CustomException("系统未提供登录服务");
		}
	}

	/**
	 * 验证该资源的是否设置了访问权限
	 * 
	 * @param requestUrl
	 * @param resRoleList
	 */
	private void validSetRole(String requestUrl, List<SecurityRoleDetail> resRoleList) {
		if (resRoleList == null || resRoleList.size() == 0) {
			String msg = "未设置此资源:" + requestUrl + " 的访问权限，请联系系统管理员进行处理，谢谢.";
			this.logger.warn(msg);
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * 需要检查权限的URL标识
	 * 
	 * @param requestUrl
	 * @return
	 */
	private boolean isNeedCheckUrl(String requestUrl) {
		if (patternPath != null) {
			for (String pattern : patternPath) {
				if (urlMatcher.match(pattern, requestUrl)) {
					// 请求资源与配置文件中的免验证资源匹配，取消检查此资源的权限
					return false;
				}
			}
		}
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public List<String> getPatternPath() {
		return patternPath;
	}

	public void setPatternPath(List<String> patternPath) {
		this.patternPath = patternPath;
	}

}