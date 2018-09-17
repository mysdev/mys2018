package com.jing.system.logger.service;

/**
 * 系统日志存储服务
 * 
 * @author LIFENG
 *
 */
public interface DbloggerService {

	/**
	 * 多线程异步操作日志表
	 * 
	 * @Async
	 * @param username
	 *            操作用户
	 * @param ip
	 *            客户端IP
	 * @param client
	 *            客户端类型(浏览器版本号，或者Android，IOS)
	 * @param subject
	 *            日志标题
	 * @param centent
	 *            内容
	 */
	void logger(String username, String ip, String client, String subject, String centent);
}
