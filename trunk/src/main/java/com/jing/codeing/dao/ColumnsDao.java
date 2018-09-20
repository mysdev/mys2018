package com.jing.codeing.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.codeing.entity.Columns;
import com.jing.config.web.page.PageInfo;

/**
 * <br>
 * <b>功能：</b>列 Dao<br>
 */
@Mapper
public interface ColumnsDao {

	/**
	 * @param model
	 *            添加列
	 */
	void addColumns(Columns columns);

	/**
	 * @param model
	 *            修改列
	 */
	void updateColumns(Columns cid);

	/**
	 * @param id
	 *            删除列
	 */
	void deleteColumnsById(String cid);
	
	/**
	 * @param culumsId
	 * 删除列
	 */
	void deleteColumnsByTid(String tid);

	/**
	 * @param id
	 *            根据Id查询列
	 */
	Columns getColumnsById(String cid);

	/**
	 * @param map
	 *            根据属性查询列
	 */
	List<Columns> findColumnsByProperty(@Param("param") Map<String, Object> param);
	
	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return
	 */
	List<Columns> findColumnsListPage(@Param("page") PageInfo page,@Param("param") Map<String, Object> param);
}
