package com.jing.system.dept.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jing.core.cache.CacheMap;
import com.jing.core.cache.CacheObservable;
import com.jing.core.cache.CacheObserver;
import com.jing.system.dept.entity.Dept;
import com.jing.system.dept.service.DeptService;
import com.jing.utils.SpringContextHolder;

public class DeptMapper implements CacheObserver{
	private static CacheMap<Integer, String> mapper = new CacheMap<Integer, String>("dept&name");
	private static CacheMap<Integer, Dept> objMapper = new CacheMap<Integer, Dept>("dept&obj");

	static {
		load();// 初始化
		CacheObservable.addObserver(new DeptMapper());// 加入重启缓存监听
	}

	public void init() {
		DeptMapper.load();
	}

	private static void load() {
		DeptService deptService = (DeptService) SpringContextHolder.getBean("deptService");
		List<Dept> list = deptService.findDeptList(new HashMap<String, Object>());
		if (list != null && list.size() > 0) {
			for (Dept org : list) {
				mapper.put(org.getDeptCode(), org.getDeptName(), 0);
				objMapper.put(org.getDeptCode(), org, 0);
			}
		}
	}

	public static String getValue(int code) {
		if (mapper.get(code) != null) {
			return mapper.get(code);
		} else {
			return "数据错误，未知组织机构";
		}
	}

	public synchronized static void setValue(Dept org) {
		mapper.put(org.getDeptCode(), org.getDeptName(), 0);
		objMapper.put(org.getDeptCode(), org, 0);
	}

	public static List<Dept> getAll() {
		List<Dept> list = new ArrayList<Dept>();
		for (Map.Entry<Integer, Dept> entry : objMapper.entrySet()) {
			Dept org = entry.getValue();
			if (org.getStatus().intValue() > 0) {
				list.add(org);
			}
		}
		return list;
	}

	public static Dept getObj(Integer id) {
		if (mapper.get(id) != null) {
			return objMapper.get(id);
		} else {
			return null;
		}
	}

	public synchronized static void delObj(Integer id) {
		objMapper.remove(id);
		mapper.remove(id);
	}
}
