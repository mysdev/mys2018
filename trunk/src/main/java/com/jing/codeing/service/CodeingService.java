package com.jing.codeing.service;

import com.jing.codeing.entity.Tables;
import com.jing.config.web.exception.CustomException;

public interface CodeingService {

	/**
	 * 读取数据库表结构
	 * @param tableName
	 * @return
	 */
	Tables readDbTable(String tableName);
	
	/**
	 * 读取数据库表结构到Tables表中 
	 * @param tableName
	 * @throws CustomException 
	 */
	void addTables(String tid) throws CustomException;
	
	/**
	 * 生成代码
	 * @param tid
	 * @throws CustomException
	 */
	void generate(String tid) throws CustomException;
}