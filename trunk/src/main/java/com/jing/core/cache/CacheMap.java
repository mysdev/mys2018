package com.jing.core.cache;

import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

public class CacheMap<K, V> extends HashMap<K, V> {
	private Log logger = LogFactory.getLog(this.getClass());
	private static final long serialVersionUID = 1L;
	// private static final String cacheType =
	// SystemConfigMapper.getValue("cache.type");
	private static final String cacheType = "local";

	private HashMap<String, HashMap<K, V>> localMapper = new HashMap<String, HashMap<K, V>>();
	private String nameSpace = null;

	public CacheMap(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	/**
	 * 写入缓存
	 * 
	 * @param nameSpace
	 * @param key
	 * @param value
	 * @param expiredTime
	 */
	public void put(K key, V value, int expiredTime) {
		if ("memcached".equals(cacheType)) {
			this.putMemcached(key, value, expiredTime);
		} else if ("local".equals(cacheType)) {
			super.put(key, value);
		}
		logger.debug("写入缓存:" + nameSpace + ",key=" + key);
	}

	@Deprecated
	@Override
	public V put(K key, V value) {
		return super.put(key, value);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void clear() {
		if ("memcached".equals(cacheType)) {
			MemcachedClient memcachedClient = MemcachedUtil.getClient();
			try {
				net.rubyeye.xmemcached.KeyIterator it = memcachedClient.getKeyIterator(MemcachedUtil.address);
				while (it.hasNext()) {
					String key = it.next();
					if (key.startsWith("_" + nameSpace + "_")) {
						memcachedClient.delete(key);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("local".equals(cacheType)) {
			localMapper.remove(nameSpace);
		}
	}

	/**
	 * 获取缓存
	 * 
	 * @param nameSpace
	 * @param key
	 * @return
	 */
	@Override
	public V get(Object key) {
		if ("memcached".equals(cacheType)) {
			return getMemcached(key);
		} else if ("local".equals(cacheType)) {
			return super.get(key);
		} else {
			return super.get(key);
		}
	}

	/**
	 * Memcached缓存
	 * 
	 * @param nameSpace
	 * @param key
	 * @param value
	 * @param expiredTime
	 * @return
	 */
	private void putMemcached(K key, V value, int expiredTime) {
		MemcachedClient memcachedClient = MemcachedUtil.getClient();
		try {
			memcachedClient.set("_" + nameSpace + "_" + key, expiredTime, value);
		} catch (Exception e) {
			logger.error("缓存存储异常", e);
		}
	}

	@SuppressWarnings("unchecked")
	private V getMemcached(Object key) {
		MemcachedClient memcachedClient = MemcachedUtil.getClient();
		try {
			return (V) memcachedClient.get("_" + nameSpace + "_" + key);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			logger.error("缓存读取异常", e);
			return null;
		}
	}

}
