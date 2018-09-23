package com.jing.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jing.config.web.exception.CustomException;
import com.jing.core.cache.CacheMap;
import com.jing.core.cache.CacheObserver;
import com.jing.core.model.entity.MemberLevel;
import com.jing.core.service.MemberLevelService;
import com.jing.utils.SpringContextHolder;

public class MemberLevelCache implements CacheObserver {

	private static CacheMap<Integer, MemberLevel> mapper = new CacheMap<Integer, MemberLevel>("memberLevel&id");
	static {
		load();
	}

	@Override
	public void init() {
		MemberLevelCache.load();
	}

	public static void load() {
		mapper.clear();
		MemberLevelService memberLevelService = (MemberLevelService) SpringContextHolder.getBean("memberLevelService");
		List<MemberLevel> list = memberLevelService.findMemberLevelList(new HashMap<String, Object>());
		if (list != null && list.size() > 0) {
			for (MemberLevel memberLevel : list) {
				mapper.put(memberLevel.getLevelId(), memberLevel, 360000);
			}
		}
	}
	
	/**
	 * 获取会员等级对象
	 * @param id
	 * @return
	 */
	public static MemberLevel getObj(int id) {
		return mapper.get(id);
	}
	
	/**
	 * 获取会员等级名称
	 * @param id
	 * @return
	 */
	public static String getName(int id) {
		MemberLevel memberLevel = mapper.get(id);
		if(memberLevel != null) {
			return memberLevel.getLevelName();
		}else {
			return null;
		}
	}
	
	/**
	 * 获取上一级会员对象
	 * @param id
	 * @return
	 */
	public static MemberLevel getUp(int id) {
		MemberLevel memberLevel = mapper.get(id);
		if(memberLevel != null && memberLevel.getParentId() != null) {
			MemberLevel up = mapper.get(memberLevel.getParentId());
			if(up !=null) {
				return up;
			}else {
				throw new CustomException(memberLevel.getLevelName()+"配置的上级会员等级不存在，会员等级配置错误.");
			}
		}else {
			return null;
		}
	}

	/**
	 * 获取所有会员等级
	 * @return
	 */
	public static List<MemberLevel> getAll() {
		List<MemberLevel> list = new ArrayList<MemberLevel>();
		for (Map.Entry<Integer, MemberLevel> entry : mapper.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

}
