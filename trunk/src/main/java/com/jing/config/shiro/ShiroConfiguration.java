package com.jing.config.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 权限认证 shiro的配置
 * 
 * @author Lifeng
 *
 */
@Configuration
public class ShiroConfiguration {

	/**
	 * ShiroFilterFactoryBean 处理拦截资源文件问题。 注意：单独一个ShiroFilterFactoryBean配置是或报错的
	 * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
	 */
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
		filters.put("myanuc", new MyAccessControlFilter());
		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// filterChainDefinitionMap.put("/page/*", "authc");
		// 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
		// filterChainDefinitionMap.put("/security/logoff", "logout");
		// 不拦截的URL
		filterChainDefinitionMap.put("*/css/**", "anon");// 静态资源权限不校验
		filterChainDefinitionMap.put("/login/auth", "anon");// 登录接口权限不校验
		filterChainDefinitionMap.put("/public/**", "anon");// 开放接口权限不校验
		// 拦截的URL
		filterChainDefinitionMap.put("/**", "user,myanuc");// 其他资源统统校验
		// 登录
		shiroFilterFactoryBean.setLoginUrl("/webpage/login.html");
		shiroFilterFactoryBean.setSuccessUrl("/webpage/index.html");
		// 未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403.html");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return shiroFilterFactoryBean;
	}

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		CustomizeAuthorizingRealm myRealm = new CustomizeAuthorizingRealm();
		securityManager.setRealm(myRealm);
		securityManager.setSessionManager(sessionManager());
		// securityManager.setCacheManager(ehCacheManager());
		return securityManager;
	}

	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		Collection<SessionListener> listeners = new ArrayList<SessionListener>();
		listeners.add(new CustomizeSessionListener());
		sessionManager.setSessionListeners(listeners);
		return sessionManager;
	}

	@Bean
	public EhCacheManager ehCacheManager() {
		EhCacheManager ehCacheManager = new EhCacheManager();
		ehCacheManager.setCacheManagerConfigFile("classpath:encache.xml");
		return ehCacheManager;
	}
}
