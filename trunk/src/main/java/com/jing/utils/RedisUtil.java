package com.jing.utils;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: RedisUtil
 * @Description: redicache 工具类（需要逐步完善）
 * @author: lichao
 * @date: 2016年12月26日 上午9:55:05
 */
@Component
public class RedisUtil {

	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	/**
	 * 
	* @Title: remove 
	* @Description: 批量删除对应的value 
	* @param keys  void    返回类型 
	* @throws
	 */
	public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 
	* @Title: removePattern 
	* @Description: 批量删除key 
	* @param pattern  void    返回类型 
	* @throws
	 */
	public void removePattern(final String pattern) {
		Set<String> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0)
			redisTemplate.delete(keys);
	}
	
	/**
	 * 
	* @Title: remove 
	* @Description: 删除对应的value
	* @param key  void    返回类型 
	* @throws
	 */
	public void remove(final String key) {
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}
	
	/**
	 * 
	* @Title: exists 
	* @Description: 判断缓存中是否有对应的value
	* @param key
	* @return  boolean    返回类型 
	* @throws
	 */
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}
	
	/**
	 * 
	* @Title: getString 
	* @Description: 获取redis数据 
	* @param key
	* @return Object
	* @author: li chao
	 */
	public Object getString(final String key) {
		Object result = null;
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		return result;
	}
	
	
	/**
	 * 
	* @Title: setString 
	* @Description: 写入redis数据
	* @param key
	* @param value
	* @param expireTime
	* @return  boolean    返回类型 
	* @throws
	 */
	public boolean setString(final String key, String value, Integer expireTime) {
		boolean result = false;
		try {
			ValueOperations<String, String> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			if(expireTime!=null && expireTime>0){
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			}
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 
	* @Title: hashSet 
	* @Description: 写入缓存
	* @param key
	* @param value
	* @param expireTime
	* @return  boolean    返回类型 
	* @throws
	 */
	public boolean hashSet(final String key, String hashkey,String value, Integer expireTime) {
		boolean result = false;
		try {
			HashOperations<String,String,String> operations = redisTemplate.opsForHash();
			operations.put(key, hashkey, value);
			if(expireTime!=null && expireTime>0){
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			}
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	* @Title: hashSet 
	* @Description: 写入缓存
	* @param key
	* @param map
	* @param expireTime
	* @return boolean
	* @author: li chao
	 */
	public boolean hashSet(final String key, Map<? extends String, ? extends String> map, Integer expireTime) {
		boolean result = false;
		try {
			HashOperations<String,String,String> operations = redisTemplate.opsForHash();
			operations.putAll(key, map);
			if(expireTime!=null && expireTime>0){
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			}
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 
	* @Title: hashGet 
	* @Description: 读入缓存
	* @param key
    * @param hashkey
	* @return  object    返回类型 
	* @throws
	 */
	public Object hashGet(final String key, String hashkey) {
		HashOperations<String,String,String> operations = redisTemplate.opsForHash();
		return operations.get(key, hashkey);
	}
	
	
	/**
	 * 
	* @Title: Set 
	* @Description: Set写缓存
	* @param key
	* @param value
	* @param expireTime
	* @return boolean
	* @author: li chao
	 */
	public boolean Set(final String key, String value, Integer expireTime) {
		boolean result = false;
		try {
			SetOperations<String, String> operations = redisTemplate.opsForSet();
			operations.add(key, value);
			if(expireTime!=null && expireTime>0){
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			}
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
