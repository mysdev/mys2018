package com.jing.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;

/**
 * 系统登录相关
 * @author Administrator
 *
 */
@Controller
@Api(description="登录用户相关")
public class LoginController {
	
	@RequestMapping(value="/login/auth",method=RequestMethod.POST)  
    public String doLogin(HttpServletRequest request){  
        String username = request.getParameter("userName");  
        String pwd = request.getParameter("password");  
        String captcha = request.getParameter("captcha");  
        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd, captcha);   
        Subject currentUser = SecurityUtils.getSubject();   
        currentUser.login(token);    
        System.out.println(currentUser);
        return "redirect:/webpage/index.html";  
    }
	
	@RequestMapping(value="/login/user",method=RequestMethod.POST)
	public Object queryLoginUser(HttpServletRequest request){  
		
		
		return null;
	}
	
}
