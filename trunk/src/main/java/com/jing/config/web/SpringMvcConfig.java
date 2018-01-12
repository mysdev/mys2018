package com.jing.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("jack.springmvc")
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

	/** 
     * 配置文件上传Bean 
     * @return 
     */  
    @Bean  
    public MultipartResolver multipartResolver(){  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();  
        multipartResolver.setMaxUploadSize(1000000);  
        return multipartResolver;  
    }
  
    @Override  
    public void addResourceHandlers(ResourceHandlerRegistry registry) {  
        //super.addResourceHandlers(registry);  
        //addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径  
//    	registry.addResourceHandler("/webpage/**").addResourceLocations("classpath:/static/webpage/");
        registry.addResourceHandler("/script/**").addResourceLocations("classpath:/static/script/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
        super.addResourceHandlers(registry);
    }  
}
