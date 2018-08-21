package com.jing.core.cache;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientStateListener;

/**
 * 
 * @author LIFENG
 *
 */
public class CacheObservable implements MemcachedClientStateListener{
	private static List<CacheObserver> observers = new ArrayList<CacheObserver>();

	public static void addObserver(CacheObserver o) {
		observers.add(o);
	}

	/**
	 * 查找有监听连接重置事件的对象 重置缓存
	 */
	public static void notifyObservers() {
		for (CacheObserver observer : observers) {
			observer.init();
		}
	}

	@Override
	public void onStarted(MemcachedClient memcachedclient) {
		System.out.println("onStarted");
	}

	@Override
	public void onShutDown(MemcachedClient memcachedclient) {
		System.out.println("onShutDown");
	}

	/**
	 * 重连
	 */
	@Override
	public void onConnected(MemcachedClient memcachedclient, InetSocketAddress inetsocketaddress) {
		System.out.println("memcached client on connected...");
		MemcachedUtil.resetClient();
		notifyObservers();
		System.out.println("memcached client caches reseted...");
	}

	/**
	 * 断开链接
	 */
	@Override
	public void onDisconnected(MemcachedClient memcachedclient, InetSocketAddress inetsocketaddress) {
		System.out.println("memcached client on disconnected...");
	}

	@Override
	public void onException(MemcachedClient memcachedclient, Throwable throwable) {
		// TODO Auto-generated method stub
		System.out.println("onException");
	}
}
