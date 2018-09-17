package com.jing.config.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jing.config.web.exception.CustomException;
import com.jing.system.login.LoginService;
import com.jing.utils.SpringContextHolder;


public class PermissionUserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	public PermissionUserDetailsAuthenticationProvider() {
	}

	private LoginService loginService = getLoginService();

	private LoginService getLoginService() {
		try {
			return (LoginService) SpringContextHolder.getBean(LoginService.class);
		} catch (Exception e) {
			throw new CustomException("系统没有配置登录服务.");
		}
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// 如果想做点额外的检查,可以在这个方法里处理,校验不通时,直接抛异常即可
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		String password = (String) authentication.getCredentials();
		boolean isLogin = false;
		this.setHideUserNotFoundExceptions(false);

		if (username == null || "".equals(username) || password == null || "".equals(password)) {
			throw new UsernameNotFoundException("密码为空.");
		}
		if (loginService == null) {
			throw new UsernameNotFoundException("系统找不到登陆验证的实现类，确认已经引入了登陆验证jar包。");
		}

		try {
			loginService.afterLogin(username, password);
			if (loginService.isAuthen() && loginService.login(username, password)) {
				// CacheUtil.cacheManager.putCache(username, loginService);
				loginService.afterLogin(username, password);
				isLogin = true;
			}
		} catch (Exception e) {
			super.logger.error("系统错误!", e);
			throw new UsernameNotFoundException("系统错误!");
		}
		if (!isLogin) {
			throw new UsernameNotFoundException("用户名或密码错误!");
		}

		UserDetail user = loginService.getUserDetailByName(username);
		// 验证用户
		validUser(username, user);

		// 查询员工的角色列表
		List roles = loginService.getRolesByUserName(username);
		// 验证是否设置了用户权限
		validSetRole(username, roles);

		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		for (int i = 0; i < roles.size(); i++) {
			auths.add(new SimpleGrantedAuthority(((RoleDetail) roles.get(i)).getRoleName()));
		}
		user.setAuthorities(auths);
		user.setUserRole(roles);
		return user;
	}

	/**
	 * 验证用户是否存在
	 * 
	 * @param username
	 * @param user
	 */
	private void validUser(String username, UserDetails user) {
		if (null == user) {
			throw new UsernameNotFoundException(("您输入的账号：" + username + "：在本系统中不存在，请联系系统管理员进行处理，谢谢！"));
		}
	}

	/**
	 * 验证员工是否设置角色信息
	 * 
	 * @param username
	 * @param roles
	 */
	private void validSetRole(String username, List<RoleDetail> roles) {
		if (roles == null || roles.size() == 0) {
			String errormessage = username + "：在本系统中没有设置角色信息，请联系系统管理员进行处理，谢谢！";
			super.logger.warn(errormessage);
			throw new UsernameNotFoundException(errormessage);
		}
	}

}
