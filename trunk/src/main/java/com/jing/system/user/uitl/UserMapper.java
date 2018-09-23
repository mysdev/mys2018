package com.jing.system.user.uitl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jing.core.cache.CacheMap;
import com.jing.core.cache.CacheObservable;
import com.jing.core.cache.CacheObserver;
import com.jing.system.permission.service.RoleService;
import com.jing.system.permission.service.UserRoleService;
import com.jing.system.user.entity.User;
import com.jing.system.user.service.UserService;
import com.jing.utils.FrameworkUtils;
import com.jing.utils.SpringContextHolder;

/**
 * 用户缓存
 * 
 * @author LIFENG
 *
 */
public class UserMapper implements CacheObserver {

	private static CacheMap<Integer, String> mapper = new CacheMap<Integer, String>("user&id");
	private static CacheMap<Integer, User> objMapper = new CacheMap<Integer, User>("user&obj");
	private static CacheMap<String, Integer> unmapper = new CacheMap<String, Integer>("user&userName");

	static {
		load();
		CacheObservable.addObserver(new UserMapper());
	}

	public void init() {
		UserMapper.load();
	}

	public static void load() {
		mapper.clear();
		objMapper.clear();
		UserService userService = (UserService) SpringContextHolder.getBean("userService");
		List<User> list = userService.findUserList(new HashMap<String, Object>());
		if (list != null && list.size() > 0) {
			for (User user : list) {
				mapper.put(user.getUserId(), user.getNickName(), 360000);
				objMapper.put(user.getUserId(), user, 360000);
				unmapper.put(user.getUsername(), user.getUserId(), 360000);
			}
		}
	}

	public synchronized static void setValue(User user) {
		if (user.getPassword() != null) {
			// throw new PbicAppException("密码缓存？");
			user.setPassword(null);
		}
		mapper.put(user.getUserId(), user.getNickName(), 360000);
		objMapper.put(user.getUserId(), user, 360000);
		unmapper.put(user.getUsername(), user.getUserId(), 360000);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized static void setRoles(int userid){
		User user = UserMapper.getObj(userid);
		RoleService roleService = (RoleService) SpringContextHolder.getBean("roleService");
		UserRoleService userRoleService = (UserRoleService) SpringContextHolder.getBean("userRoleService");
		List roles = roleService.findRoleListByUserId(user.getUserId());
		user.setUserRole(roles);
		user.setUserRoles(userRoleService.findUserRoleList(FrameworkUtils.hashMap("userId", user.getUserId())));
	}

	public static List<User> getAll() {
		List<User> list = new ArrayList<User>();
		for (Map.Entry<Integer, User> entry : objMapper.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

	public static String getValue(int userId) {
		if (mapper.get(userId) != null) {
			return mapper.get(userId);
		} else {
			if (userId == 0) {
				return "匿名用户";
			}
			return "数据错误，未知用户";
		}

	}

	public static User getObj(String username) {
		if (unmapper.get(username) != null) {
			return objMapper.get(unmapper.get(username));
		} else {
			return null;
		}
	}

	public static User getObj(int id) {
		if (mapper.get(id) != null) {
			return objMapper.get(id);
		} else {
			UserService userService = (UserService) SpringContextHolder.getBean("userService");
			User user = userService.getUserById(id);
			if (user != null) {
				UserMapper.setValue(user);
			} else {
				System.out.println("用户" + id + "在数据库查询了也不存在-------------------------");
			}
			return user;
		}
	}
}
