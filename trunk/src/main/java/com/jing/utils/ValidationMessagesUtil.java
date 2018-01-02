package com.jing.utils;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.google.common.collect.Maps;

/**
 * @ClassName: PropertiesUtil  
 * @Description: 属性工具类（需要逐步完善）
 * @author li chao
 * @date 2016年3月15日 下午4:31:34   @version V1.0  
 */
public class ValidationMessagesUtil {

	private static final Logger logger = LoggerFactory.getLogger(ValidationMessagesUtil.class);
	
	private static Map<String, String> propertiesMap = Maps.newHashMap();
	
	public static Map<String, String>  validationMessages() throws IOException {
		Properties properties = PropertiesLoaderUtils.loadAllProperties("ValidationMessages.properties");
		for (Object key : properties.keySet()) {
			 String keyStr = (String)key;
			propertiesMap.put(keyStr, new String(properties.getProperty(keyStr).getBytes("UTF-8"),"utf-8"));
		}
		return propertiesMap;
	}
	
	public static String  getValue(String key) {
		if(propertiesMap.isEmpty()){
			try {
				propertiesMap = validationMessages();
			} catch (IOException e) {
				logger.error("读取国际化文件ValidationMessages.properties异常");
			}
		}
		return propertiesMap.get(key);
	}
	
}
