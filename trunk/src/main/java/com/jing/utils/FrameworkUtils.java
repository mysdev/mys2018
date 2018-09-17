package com.jing.utils;

import java.util.HashMap;
import java.util.Map;

public class FrameworkUtils {

	/**
	 * 创建一个HashMap
	 * @param key
	 * @param value
	 * @return
	 */
	public static Map<String, Object> hashMap(String key, Object value) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(key, value);
		return param;
	}

}
