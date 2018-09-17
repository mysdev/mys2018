package com.jing.system.login;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.jing.config.web.security.PermissionConstants;
import com.jing.system.logger.DbLogger;
import com.jing.system.login.session.Config;
import com.jing.system.user.entity.User;
import com.jing.system.user.entity.UserDept;
import com.jing.system.user.uitl.UserDeptMapper;

public class LoginSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
implements AuthenticationSuccessHandler{

	private String successUrl;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		setAlwaysUseDefaultTargetUrl(true);
		setDefaultTargetUrl(successUrl);
		HttpSession hs = request.getSession();
		if (authentication != null && authentication.getPrincipal() != null) {
			User user = (User) authentication.getPrincipal();
			User ud = new User();
			try {
				String deptCode = (String)request.getSession().getAttribute("deptCode");
				if(deptCode!=null && !"".equals(deptCode)){
					user.setDeptCode(Integer.parseInt(deptCode));
				}else{
					List<UserDept> list =  UserDeptMapper.getObj(user.getUserId());
					if(list!=null ){
						user.setDeptCode(list.get(0).getDeptCode());
					}
				}
				BeanUtils.copyProperties(ud, user);
				
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			DbLogger.login( user.getUsername(),request);
			super.logger.info(user.getUsername() + "已登录，做登录日志");
			hs.setAttribute(Config.USER_INFO, ud);
			hs.setAttribute(Config.UID, user.getUsername());
			hs.setAttribute(PermissionConstants.SPRING_SECURITY_CONTEXT, authentication);
		}
		handle(request, response, authentication);
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}
	
	
}
