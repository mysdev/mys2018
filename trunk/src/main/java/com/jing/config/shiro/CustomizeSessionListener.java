package com.jing.config.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * 权限
 * 
 * @author Lifeng
 *
 */
public class CustomizeSessionListener implements SessionListener {

	private final AtomicInteger sessionCount = new AtomicInteger(0);

	@Override
	public void onStart(Session session) {
		sessionCount.incrementAndGet();
		System.out.println("登录+1==" + sessionCount.get());
	}

	@Override
	public void onStop(Session session) {
		sessionCount.decrementAndGet();
		System.out.println("登录退出-1==" + sessionCount.get());
	}

	@Override
	public void onExpiration(Session session) {
		sessionCount.decrementAndGet();
		System.out.println("登录过期-1==" + sessionCount.get());

	}

	public int getSessionCount() {
		return sessionCount.get();
	}

}
