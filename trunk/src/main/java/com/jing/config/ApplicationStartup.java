/**  
 * Copyright © 2018公司名字. All rights reserved.
 * @Title: A.java
 * @Prject: mys
 * @Package: com.jing.config
 * @Description: TODO
 * @author: Jinlong He
 * @mail: hejinlong01@hnjing.com
 * @date: 2018年9月8日 下午4:10:53
 * @version: V1.0  
 */
package com.jing.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jing.attendance.service.AttendanceDetailService;
import com.jing.attendance.service.impl.AttendanceDetailServiceImpl;

/**
 * @ClassName: A
 * @Description: 系统启动后执行任务
 * @author: Jinlong He
 * @date: 2018年9月8日 下午4:10:53
 */
@Component
@Order(value = 1)
public class ApplicationStartup implements ApplicationRunner{ 
	private static final Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);
	@Autowired
	private AttendanceDetailService attendanceDetailService;	
	
    public void run(ApplicationArguments var1) throws Exception{
    	logger.info("**********************系统启动完成-执行必要初始化开始*************************");
    	logger.info("1、锁定当天及以前考勤详情信息");
    	attendanceDetailService.disableDetailEditable();
    	logger.info("**********************系统启动完成-执行必要初始化成功*************************");
    }
}
