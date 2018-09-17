package com.jing.core.cache;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jing.system.sysconfig.SysConfigMapper;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class MemcachedUtil {
	private static Log logger = LogFactory.getLog(MemcachedUtil.class);
	private static MemcachedClient memcachedClient = null;

	public static final InetSocketAddress address = AddrUtil.getOneAddress("localhost:11211");
	private static final MemcachedClientBuilder build = new XMemcachedClientBuilder(
			AddrUtil.getAddresses(SysConfigMapper.getValue("cache.memcached.ip") + ":"
					+ SysConfigMapper.getValue("cache.memcached.port")));

	public static MemcachedClient getClient() {
		try {
			if (memcachedClient == null) {
				memcachedClient = build.build();
				memcachedClient.addStateListener(new CacheObservable());
			}
			return memcachedClient;
		} catch (IOException e) {
			logger.error("连接memcached失败.", e);
			return null;
		}
	}

	public static void resetClient() {
		try {
			memcachedClient = build.build();
			memcachedClient.addStateListener(new CacheObservable());
		} catch (IOException e) {
			logger.error("连接memcached失败.", e);
		}
	}

}
