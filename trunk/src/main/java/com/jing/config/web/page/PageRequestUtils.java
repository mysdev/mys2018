package com.jing.config.web.page;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class PageRequestUtils {
    public static PageInfo getPageBean(HttpServletRequest request) {
        return PageBeanFactory.createPageBean(request);
    }
    
    /** 
     * @Title: getStringMapFromStringsMap 
     * @Description: request.getParameterMap()的返回类型是Map类型的对象，
     * 			也就是符合key-value的对应关系，但这里要注意的是，value的类型是String[],而不是String. 
     * @param maps
     * @return  
     *
     */ 
    public static Map<String, Object> getStringMapFromStringsMap(Map<String, String[]> maps){
    	Map<String, Object> ret = new HashMap<String, Object>();
    	Set<Entry<String, String[]>> set = maps.entrySet();  
    	Iterator<Entry<String, String[]>> it = set.iterator();  
    	while(it.hasNext()){
    		Entry<String, String[]> entry = it.next();
    		ret.put(entry.getKey(), entry.getValue()[0]);
    	}
    	return ret;
    }
}
