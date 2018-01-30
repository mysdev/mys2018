package com.jing.system.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jing.system.model.entity.Config;
import com.jing.system.service.ConfigService;
import com.jing.utils.SpringContextUtils;

/**
 * 系统配置缓存
 * @author Administrator
 *
 */
public class SystemConfigMapper {

	private static Map<String, Config> objMapper = new HashMap<String, Config>();
	
	static {
		ConfigService configService = SpringContextUtils.getBean(ConfigService.class);
		List<Config> list = configService.queryConfigByProperty(new HashMap<String, Object>());
		if (list != null && list.size() > 0) {
			for (Config config : list) {
				objMapper.put(config.getPropertyCode(), config);
			}
		}
	}
	
	public synchronized static void setValue(Config config) {
		objMapper.put(config.getPropertyCode(), config);
	}
	
	public static String getValue(String code) {
		if (objMapper.get(code) != null) {
			return objMapper.get(code).getPropertyValue();
		} else {
			return "数据错误，未知用户";
		}
	}
	
	public static List<Config> getAll() {
		List<Config> list = new ArrayList<Config>();
		for (Map.Entry<String, Config> entry : objMapper.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
	public static Config getObj(String code) {
		if (objMapper.get(code) != null) {
			return objMapper.get(code);
		} else {
			ConfigService configService = SpringContextUtils.getBean(ConfigService.class);
			Config config = configService.queryConfigByPropertyCode(code);
			if (config != null) {
				SystemConfigMapper.setValue(config);
			} else {
				System.out.println("配置" + code + "在数据库查询了也不存在-------------------------");
			}
			return config;
		}
	}
}
