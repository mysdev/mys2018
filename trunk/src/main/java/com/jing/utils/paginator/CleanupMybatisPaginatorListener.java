package com.jing.utils.paginator;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
* @ClassName: CleanupMybatisPaginatorListener  
* @Description:   
* @author li chao
* @date 2015年9月23日 下午1:36:17 
* @version V1.0  
 */
public class CleanupMybatisPaginatorListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        OffsetLimitInterceptor.Pool.shutdownNow();
    }
}
