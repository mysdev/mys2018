package com.jing.settlement.util;

import java.util.ArrayList;
import java.util.List;

public class AuthorizationObservable {

	private static List<AuthorizationObserver> observers = new ArrayList<AuthorizationObserver>();

	public static void addObserver(AuthorizationObserver o) {
		observers.add(o);
	}

	/**
	 * 查找有授权码开立的对象
	 * 授权码一旦开立，则执行附加消费
	 */
	public static void createdAuthorization() {
		for (AuthorizationObserver observer : observers) {
			
			observer.created();
		}
	}
	
	/**
	 * 查找有授权码取消的对象
	 * 授权码一旦取消，则执行取消附加消费
	 */
	public static void cancelAuthorization() {
		for (AuthorizationObserver observer : observers) {
			observer.created();
		}
	}
}
