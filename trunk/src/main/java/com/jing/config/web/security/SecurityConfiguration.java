package com.jing.config.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.jing.system.login.LoginFailureHandler;
import com.jing.system.login.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**/script/**").permitAll().antMatchers("/**/images/**").permitAll()
				.antMatchers("/**/css/**").permitAll().and().formLogin().loginPage("/login.jsp").permitAll()
				.successHandler(loginSuccessHandler()) // 登录
				.and().logout().invalidateHttpSession(true).logoutSuccessUrl("/login.jsp").permitAll()// 注销
				.and().exceptionHandling().accessDeniedPage("/Access_Denied");// 权限验证错误
		http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
	}

	@Bean
	public LoginSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}

	@Bean
	public LoginFailureHandler loginFailureHandler() {
		return new LoginFailureHandler();
	}

}