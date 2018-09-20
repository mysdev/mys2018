package com.jing.codeing.service;

import java.util.List;
import java.util.Map;

import com.jing.codeing.entity.Columns;
import com.jing.config.web.page.PageInfo;

/**
 * 
 * <br>
 * <b>功能：</b>CulumsService<br>
 */
public interface ColumnsService {
	/**
	 * @param model
	 *            添加列
	 */
	Columns addColumns(Columns culums);

	/**
	 * @param model
	 *            修改列
	 */
	Columns updateColumns(Columns culums);

	/**
	 * @param culumsId
	 *            删除列
	 */
	void deleteColumnsById(String cid);

	/**
	 * @param tableName
	 *            删除列
	 */
	void deleteColumnsByTid(String tid);

	/**
	 * @param culumsId
	 *            根据Id查询列
	 */
	Columns getColumnsById(String cid);

	/**
	 * 分页查询列
	 * 
	 * @param map
	 * @param page
	 * @return
	 */
	PageInfo findColumnsPageList(Map<String, Object> map, PageInfo page);

	/**
	 * @param map
	 *            根据属性查询列
	 */
	List<Columns> findColumnsByProperty(Map<String, Object> map);
}
