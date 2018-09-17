package com.jing.system.logger.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.system.logger.dao.SysLogDao;
import com.jing.system.logger.entity.SysLog;
import com.jing.system.logger.service.DbloggerService;
import com.jing.system.user.uitl.UserMapper;

@Service("dbloggerService")
public class DefultLoggerServiceImpl implements DbloggerService{
	@Resource
	private SysLogDao sysLogDao;

	@Override
	public void logger(String username, String ip, String client, String subject, String centent) {
		SysLog log = new SysLog();
		log.setUserIp(ip);
		log.setOper(subject);
		log.setRequest(centent);
		log.setOperClient(client);
		log.setOperStatus(1);
		log.setUserId(UserMapper.getObj(username).getUserId());
		sysLogDao.addSysLog(log);
	}

}
