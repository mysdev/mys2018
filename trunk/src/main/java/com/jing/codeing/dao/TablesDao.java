package com.jing.codeing.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.codeing.entity.Tables;
import com.jing.config.web.page.PageInfo;

/**
 * <br>
 * <b>功能：</b>表格 Dao<br>
 */
@Mapper
public interface TablesDao {

	/**
	 * @param model
	 *            添加表格
	 */
	void addTables(Tables tables);

	/**
	 * @param model
	 *            修改表格
	 */
	void updateTables(Tables tables);

	/**
	 * @param id
	 *            删除表格
	 */
	void deleteTablesById(String tablesId);

	/**
	 * @param id
	 *            根据Id查询表格
	 */
	Tables getTablesById(String tablesId);

	/**
	 * @param map
	 *            根据属性查询表格
	 */
	List<Tables> findTablesByProperty(@Param("param") Map<String, Object> param);
	
	/**
	 * @param page
	 * 分页查询表格
	 */
	List<Tables> findTablesListPage(@Param("page") PageInfo page,@Param("param") Map<String, Object> param);
}
