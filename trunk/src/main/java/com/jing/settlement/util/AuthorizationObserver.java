package com.jing.settlement.util;

public interface AuthorizationObserver {

	//创建
	void created();
	
	//取消
	void cancel();
}
