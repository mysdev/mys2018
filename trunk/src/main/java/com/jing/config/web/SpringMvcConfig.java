package com.jing.config.web;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jing.system.login.session.SessionAttrArgumentResolver;
import com.jing.system.login.session.UidArgumentResolver;

@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		argumentResolvers.add(new SessionAttrArgumentResolver());
		argumentResolvers.add(new UidArgumentResolver());
	}
  
}
