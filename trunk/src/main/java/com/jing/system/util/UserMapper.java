package com.jing.system.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jing.system.model.entity.User;
import com.jing.system.model.entity.UserRole;
import com.jing.system.service.UserRoleService;
import com.jing.system.service.UserService;
import com.jing.utils.SpringContextUtils;

/**
 * 用户缓存
 * @author Administrator
 *
 */
public class UserMapper {

	private static Map<Integer, String> mapper = new HashMap<Integer, String>();
	private static Map<Integer, User> objMapper = new HashMap<Integer, User>();
	
	private static Map<String, User> namemapper = new HashMap<String, User>();

	static {
		UserService userService = SpringContextUtils.getBean(UserService.class);
		UserRoleService userRoleService = SpringContextUtils.getBean(UserRoleService.class);
		List<User> list = userService.queryUserByProperty(new HashMap<String, Object>());
		if (list != null && list.size() > 0) {
			for (User user : list) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("userId", user.getUserId());
				List<UserRole> roles = userRoleService.queryUserRoleByProperty(map);
				user.setUserRoleList(roles);
				mapper.put(user.getUserId(), user.getNickName());
				objMapper.put(user.getUserId(), user);
				namemapper.put(user.getUserName(), user);
			}
		}
	}

	public static String getValue(int userId) {
		if (mapper.get(userId) != null) {
			return mapper.get(userId);
		} else {
			return "数据错误，未知用户";
		}
	}

	public synchronized static void setValue(User user) {
		mapper.put(user.getUserId(), user.getNickName());
		objMapper.put(user.getUserId(), user);
		namemapper.put(user.getUserName(), user);
	}

	public static List<User> getAll() {
		List<User> list = new ArrayList<User>();
		for (Map.Entry<Integer, User> entry : objMapper.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

	public static User getObj(int userId) {
		if (mapper.get(userId) != null) {
			return objMapper.get(userId);
		} else {
			UserService userService = SpringContextUtils.getBean(UserService.class);
			User user = userService.queryUserByUserId(userId);
			if (user != null) {
				UserMapper.setValue(user);
			} else {
				System.out.println("用户" + userId + "在数据库查询了也不存在-------------------------");
			}
			return user;
		}
	}
	
	/**
	 * 根据账找用户
	 * @param userName
	 * @return
	 */
	public static User getObj(String userName) {
		return namemapper.get(userName);
	}
}
