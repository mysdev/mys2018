package com.jing.system.user.uitl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jing.core.cache.CacheMap;
import com.jing.core.cache.CacheObservable;
import com.jing.core.cache.CacheObserver;
import com.jing.system.dept.entity.Dept;
import com.jing.system.dept.util.DeptMapper;
import com.jing.system.user.entity.UserDept;
import com.jing.system.user.service.UserDeptService;
import com.jing.utils.SpringContextHolder;

/**
 * 用户部门信息缓存
 * 
 * @author LIFENG
 *
 */
public class UserDeptMapper implements CacheObserver {
	private static CacheMap<Integer, Integer> mapper = new CacheMap<Integer, Integer>("userDept&id");
	private static CacheMap<Integer, List<UserDept>> objMapper = new CacheMap<Integer, List<UserDept>>("userDept&obj");

	static {
		load();
		CacheObservable.addObserver(new UserDeptMapper());
	}

	@Override
	public void init() {
		UserDeptMapper.load();
	}

	public static void load() {
		mapper.clear();
		objMapper.clear();
		UserDeptService userDeptService = (UserDeptService) SpringContextHolder.getBean("userDeptService");
		List<UserDept> list = userDeptService.findUserDeptList(new HashMap<String, Object>());
		if (list != null && list.size() > 0) {
			for (UserDept userDept : list) {
				setValue(userDept);
			}
		}
	}

	public synchronized static void setValue(UserDept userDept) {
		List<UserDept> list = objMapper.get(userDept.getUserId());
		if (list == null) {
			list = new ArrayList<UserDept>();
			objMapper.put(userDept.getUserId(), list, 360000);
		}
		list.add(userDept);
	}
	
	public synchronized static void moveValue(int userId,int deptCode) {
		List<UserDept> list = objMapper.get(userId);
		if (list == null) {
			return;
		}
		List<UserDept> newList = new ArrayList<UserDept>();
		for (UserDept userDept : list) {
			if(userDept.getDeptCode().intValue() == deptCode){
				continue;
			}else{
				newList.add(userDept);
			}
		}
		objMapper.put(userId, newList, 360000);
	}

	public static List<UserDept> getObj(Integer userId) {
		if (objMapper.get(userId) != null) {
			return objMapper.get(userId);
		} else {
			return null;
		}
	}
	
	public static Dept getFirstDept(Integer userId) {
		if (objMapper.get(userId) != null) {
			List<UserDept> list = objMapper.get(userId);
			if(list!=null && list.size()>0){
				return DeptMapper.getObj(list.get(0).getDeptCode());
			}
			return null;
		} else {
			return null;
		}
	}

}
