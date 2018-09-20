package com.jing.codeing.service;

import java.util.List;
import java.util.Map;

import com.jing.codeing.entity.Tables;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;

/**
 * 
 * <br>
 * <b>功能：</b>TablesService<br>
 */
public interface TablesService {
	/**
	 * @param model
	 *            添加表格
	 * @throws CustomException 
	 */
	Tables addTables(Tables tables) throws CustomException;
	/**
	 * @param model
	 *           读取数据库物理表结构，然后 添加表格
	 * @throws CustomException 
	 */
	Tables addTables(String tableName) throws CustomException;

	/**
	 * @param model
	 *            修改表格
	 */
	Tables updateTables(Tables tables);

	/**
	 * @param tablesId
	 *            删除表格
	 */
	void deleteTablesById(String tid);

	/**
	 * @param tid
	 *            根据Id查询表格
	 */
	Tables getTablesById(String tid);

	/**
	 * @param map
	 *            根据属性查询表格
	 */
	List<Tables> findTablesByProperty(Map<String, Object> param);
	
	/**
	 * 
	 * @param page
	 * @param param
	 *            分页查询
	 */
	PageInfo findTablesPage(PageInfo page, Map<String, Object> param)throws Exception;
	
}
