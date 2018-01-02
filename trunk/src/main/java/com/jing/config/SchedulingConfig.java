package com.jing.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * @ClassName: SchedulingConfig
 * @Description: 定时任务配置类
 * @author: Jinlong He
 * @date: 2017年11月16日
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
	private static final Logger logger = LoggerFactory.getLogger(SchedulingConfig.class);
//	
//	
//	
	/** 
	* @Title: updateProductAuthOutTime 
	* @Description: 定时任务-0点7分
	* @throws 
	*/
	@Scheduled(cron = "0 7 0 * * ?")
	public void updateProductAuthOutTime() {
		logger.info("定时任务启动");
	}
	
	
	
}
