package com.jing.config.web.page;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class PageUtil implements java.io.Serializable {
    /**
         * 
         */
    private static final long serialVersionUID = -8948452811320973587L;

    public final static int DEFAULT_INIT_PAGE = 1;

    public static String sortName = "sortName";
    public static String orderName = "orderName";
    public static String currentPage = "pageNumber";
    public static String pageSize = "pageSize";

    public static int selectPageCounts(int maxRowCount, int pageSize) {
        int page_num = 0;

        if (maxRowCount % pageSize == 0) {
            page_num = maxRowCount / pageSize;
        } else {
            page_num = maxRowCount / pageSize + 1;
        }

        return page_num;
    }
    
    public static Map<String, Object> transBean2Map(Object obj) {  
    	  
        if(obj == null){  
            return null;  
        }          
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                // 过滤class属性  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
  
                    map.put(key, value);  
                }  
  
            }  
        } catch (Exception e) {  
            System.out.println("transBean2Map Error " + e);  
        }  
  
        return map;  
  
    }  
}
