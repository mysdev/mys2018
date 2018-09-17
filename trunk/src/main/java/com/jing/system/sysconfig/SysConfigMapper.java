package com.jing.system.sysconfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jing.config.web.exception.CustomException;
import com.jing.system.sysconfig.entity.SysConfig;
import com.jing.system.sysconfig.service.SysConfigService;
import com.jing.utils.SpringContextHolder;

public class SysConfigMapper {

	private static Map<String, String> config = new HashMap<String, String>();

	static {
		SysConfigService systemConfigService = (SysConfigService) SpringContextHolder.getBean("sysConfigService");
		List<SysConfig> list = systemConfigService.findSysConfigList(new HashMap<String, Object>());
		if (list != null && list.size() > 0) {
			for (SysConfig dbconfig : list) {
				System.err.println(dbconfig.getPcode() + "=" + dbconfig.getPvalue());
				config.put(dbconfig.getPcode(), dbconfig.getPvalue());
			}
		}
	}

	public static String getValue(String code) {
		if (config.get(code) != null) {
			return config.get(code);
		} else {
			throw new CustomException("系统配置项错误！未知配置项:" + code);
		}
	}

	public static void setValue(String code, String value) {
		config.put(code, value);
	}
}
