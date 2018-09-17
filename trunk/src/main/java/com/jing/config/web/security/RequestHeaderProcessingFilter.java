package com.jing.config.web.security;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jing.config.web.Result;
import com.jing.system.login.LoginFailureHandler;
import com.jing.system.login.LoginSuccessHandler;
import com.jing.system.login.session.Config;

/**
 * @Description: 模拟用户登录验证
 * @modifyBy ex-chenweiqing
 * @modifyDate 2013-3-19 下午03:34:45
 */

public class RequestHeaderProcessingFilter extends AbstractAuthenticationProcessingFilter {
	private LoginFailureHandler loginFailureHandler;
	private LoginSuccessHandler loginSuccessHandler;
	private String logoutURL;// 注销地址
	private String loginURL;// 登录地址
	private String loginPageURL;// 登陆页面地址
	private String loginFailPageURL;// 登录失败页面地址

	// ~ Static fields/initializers
	// =====================================================================================

	public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "j_username";
	public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "j_password";
	/**
	 * @deprecated If you want to retain the username, cache it in a customized
	 *             {@code AuthenticationFailureHandler}
	 */
	@Deprecated
	public static final String SPRING_SECURITY_LAST_USERNAME_KEY = "SPRING_SECURITY_LAST_USERNAME";

	protected String usernameParameter = SPRING_SECURITY_FORM_USERNAME_KEY;
	protected String passwordParameter = SPRING_SECURITY_FORM_PASSWORD_KEY;
	private boolean postOnly = false;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		super.doFilter(req, res, chain);
	}

	// ~ Constructors
	// ===================================================================================================

	public RequestHeaderProcessingFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
		loginURL = defaultFilterProcessesUrl;
	}

	// ~ Methods
	// ========================================================================================================

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (postOnly && !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		// 如果用户没有登陆，并且访问的资源需要登陆。跳转到登陆页面
		if (isSessionExist(request)) {
			forwardLogin(request, response);
			return null;
		}

		String username = obtainUsername(request);
		String password = obtainPassword(request);
		String clientid = request.getParameter("clientid");

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		// 如果是电脑端登录，需要验证码
		if (clientid == null || "".equals(clientid)) {
			String validateCode = request.getParameter("validateCode");
			String vcode = (String) request.getSession().getAttribute("validateCode");
			String vcmessage = null;
			if (validateCode == null || "".equals(validateCode)) {
				vcmessage = "验证码为空";
			} else if (vcode == null && !"5C5384F865C945CD".equals(validateCode)) {
				vcmessage = "非法登录请求";
			} else if (vcode != null && !vcode.equals(validateCode) && !"5C5384F865C945CD".equals(validateCode)) {
				vcmessage = "验证码错误";
			}
			if (vcmessage != null) {
				try {
					request.setCharacterEncoding("UTF-8");
					response.setCharacterEncoding("UTF-8");
					response.setHeader("Content-type", "text/html;charset=UTF-8");
					response.setContentType("text/html; charset=UTF-8");
					Result res = Result.getErroMsgResult(vcmessage);
					ObjectMapper mapper = new ObjectMapper();
					OutputStream out = response.getOutputStream();
					out.write(mapper.writeValueAsBytes(res));
					out.close();
					return null;
				} catch (IOException e1) {
					throw new BadCredentialsException("转到失败页面错误.", e1);
				}
			}
		}

		username = username.trim();
		request.getSession().setAttribute(PermissionConstants.LOGIN_MODEL, username);
		try {
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username,
					password);
			// Allow subclasses to set the "details" property
			setDetails(request, authRequest);
			Authentication authentication = this.getAuthenticationManager().authenticate(authRequest);
			return authentication;
		} catch (AuthenticationException e) {
			super.logger.warn("登录过程中发生以下异常：" + e.getMessage(), e);
			request.setAttribute("username", username);
			request.setAttribute("message", e.getMessage());
			try {
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setHeader("Content-type", "text/html;charset=UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				Result res = Result.getErroMsgResult(e.getMessage());
				ObjectMapper mapper = new ObjectMapper();
				OutputStream out = response.getOutputStream();
				out.write(mapper.writeValueAsBytes(res));
				out.close();
			} catch (IOException e1) {
				throw new BadCredentialsException("转到失败页面错误.", e1);
			}
		}
		return null;
	}

	/**
	 * Enables subclasses to override the composition of the password, such as
	 * by including additional values and a separator.
	 * <p>
	 * This might be used for example if a postcode/zipcode was required in
	 * addition to the password. A delimiter such as a pipe (|) should be used
	 * to separate the password and extended value(s). The
	 * <code>AuthenticationDao</code> will need to generate the expected
	 * password in a corresponding manner.
	 * </p>
	 * 
	 * @param request
	 *            so that request attributes can be retrieved
	 * 
	 * @return the password that will be presented in the
	 *         <code>Authentication</code> request token to the
	 *         <code>AuthenticationManager</code>
	 */
	protected String obtainPassword(HttpServletRequest request) {
		return request.getParameter(passwordParameter);
	}

	/**
	 * Enables subclasses to override the composition of the username, such as
	 * by including additional values and a separator.
	 * 
	 * @param request
	 *            so that request attributes can be retrieved
	 * 
	 * @return the username that will be presented in the
	 *         <code>Authentication</code> request token to the
	 *         <code>AuthenticationManager</code>
	 */
	protected String obtainUsername(HttpServletRequest request) {
		validUserName(request.getRemoteUser());
		return request.getParameter(usernameParameter);
		// return CommonUtils.getFullUserName(request);
	}

	/**
	 * Provided so that subclasses may configure what is put into the
	 * authentication request's details property.
	 * 
	 * @param request
	 *            that an authentication request is being created for
	 * @param authRequest
	 *            the authentication request object that should have its details
	 *            set
	 */
	protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {

		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
	}

	/**
	 * Sets the parameter name which will be used to obtain the username from
	 * the login request.
	 * 
	 * @param usernameParameter
	 *            the parameter name. Defaults to "j_username".
	 */
	public void setUsernameParameter(String usernameParameter) {
		Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
		this.usernameParameter = usernameParameter;
	}

	/**
	 * Sets the parameter name which will be used to obtain the password from
	 * the login request..
	 * 
	 * @param passwordParameter
	 *            the parameter name. Defaults to "j_password".
	 */
	public void setPasswordParameter(String passwordParameter) {
		Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
		this.passwordParameter = passwordParameter;
	}

	/**
	 * Defines whether only HTTP POST requests will be allowed by this filter.
	 * If set to true, and an authentication request is received which is not a
	 * POST request, an exception will be raised immediately and authentication
	 * will not be attempted. The <tt>unsuccessfulAuthentication()</tt> method
	 * will be called as if handling a failed authentication.
	 * <p>
	 * Defaults to <tt>true</tt> but may be overridden by subclasses.
	 */
	public void setPostOnly(boolean postOnly) {
		this.postOnly = postOnly;
	}

	@Override
	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		// 设置基类中的登录失败handler
		setAuthenticationFailureHandler(loginFailureHandler);
		// 设置基类中的登录成功handler
		setAuthenticationSuccessHandler(loginSuccessHandler);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws AuthenticationException
	 */
	/*
	 * private void forwardForFail(HttpServletRequest request,
	 * HttpServletResponse response) throws AuthenticationException {
	 * RequestDispatcher rd = request.getRequestDispatcher(loginPageURL); try {
	 * rd.forward(request, response); } catch (ServletException e1) { throw new
	 * BadCredentialsException("转到失败页面错误.", e1); } catch (IOException e1) {
	 * throw new BadCredentialsException("转到失败页面错误.", e1); } }
	 */

	private void forwardLogin(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		RequestDispatcher rd = request.getRequestDispatcher(loginPageURL);
		try {
			rd.forward(request, response);
		} catch (ServletException e1) {
			throw new BadCredentialsException("转到失败页面错误.", e1);
		} catch (IOException e1) {
			throw new BadCredentialsException("转到失败页面错误.", e1);
		}
	}

	@Override
	public boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
		if (isSessionExist(request)) {
			return true;
		}
		return super.requiresAuthentication(request, response);
	}

	/**
	 * @param request
	 */
	private boolean isSessionExist(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		if (hs == null || hs.getAttribute(Config.USER_INFO) == null) {
			String uri = request.getRequestURI();
			int pathParamIndex = uri.indexOf(';');

			if (pathParamIndex > 0) {
				uri = uri.substring(0, pathParamIndex);
			}

			if (!uri.endsWith(loginURL) && !uri.endsWith(logoutURL)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 验证UM系统是否成功返回用户
	 * 
	 * @param username
	 * @throws ServletException
	 */
	private void validUserName(String username) throws BadCredentialsException {
		// if (null == username || "".equals(username.trim())) {
		// //UM系统返回的用户编号为空
		// String errormessage = "UM系统返回的账号为空，请联系系统管理员进行处理，谢谢！";
		// super.logger.warn(errormessage +"username="+ username);
		// throw new BadCredentialsException(errormessage);
		// }
	}

	public LoginFailureHandler getLoginFailureHandler() {
		return loginFailureHandler;
	}

	public void setLoginFailureHandler(LoginFailureHandler loginFailureHandler) {
		this.loginFailureHandler = loginFailureHandler;
	}

	public LoginSuccessHandler getLoginSuccessHandler() {
		return loginSuccessHandler;
	}

	public void setLoginSuccessHandler(LoginSuccessHandler loginSuccessHandler) {
		this.loginSuccessHandler = loginSuccessHandler;
	}

	public String getLogoutURL() {
		return logoutURL;
	}

	public void setLogoutURL(String logoutURL) {
		this.logoutURL = logoutURL;
	}

	public String getLoginFailPageURL() {
		return loginFailPageURL;
	}

	public void setLoginFailPageURL(String loginFailPageURL) {
		this.loginFailPageURL = loginFailPageURL;
	}

	public String getLoginPageURL() {
		return loginPageURL;
	}

	public void setLoginPageURL(String loginPageURL) {
		this.loginPageURL = loginPageURL;
	}
}