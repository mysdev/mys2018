package com.jing.config.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jing.system.model.entity.User;
import com.jing.system.service.UserService;
import com.jing.utils.SpringContextUtils;

/**
 * 登录
 * 
 * @author Lifeng
 *
 */
public class CustomizeAuthorizingRealm extends AuthorizingRealm {
	private final static Logger logger = LoggerFactory.getLogger(CustomizeAuthorizingRealm.class);

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		logger.debug("登录验证后进行权限认证....");
		Set<String> roleNames = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();
		roleNames.add("administrator");// 添加角色
		permissions.add("newPage.jhtml"); // 添加权限
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		info.setStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		logger.debug("登录操作进行登录认证......");
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		User user = SpringContextUtils.getBean(UserService.class).login(token.getUsername(),
				token.getPassword().toString());
		if (user == null) {
			// 没找到帐号
			throw new UnknownAccountException("用户名或者密码错误.");
		} else if (user.getStatus().intValue() != 0) {
			throw new LockedAccountException("账号状态异常.");
		} else {
			System.out.println(token.getUsername() + "登录.");
			logger.info("用户："+user.getUserName()+" 登录成功.");
			//session
		}
		// 简单验证
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());

		return info;
	}

}
