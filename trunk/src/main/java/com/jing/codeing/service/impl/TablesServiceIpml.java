package com.jing.codeing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.codeing.dao.TablesDao;
import com.jing.codeing.entity.Columns;
import com.jing.codeing.entity.Tables;
import com.jing.codeing.service.CodeingService;
import com.jing.codeing.service.ColumnsService;
import com.jing.codeing.service.TablesService;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;

@Service("tablesService")
public class TablesServiceIpml implements TablesService {

	@Resource
	private TablesDao tablesDao;
	@Autowired
	private ColumnsService columnsService;
	@Autowired
	private CodeingService codeingService;

	/* 添加 */
	@Override
	public Tables addTables(Tables tables) throws CustomException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tableName", tables.getTableName());
		List<Tables> list = findTablesByProperty(param);
		if(list==null || list.size()==0){
			tablesDao.addTables(tables);
		}else{
			throw new CustomException("表名冲突，无法添加");
		}
		return tables;
	}
	
	@Override
	@Transactional
	public Tables addTables(String tableName) throws CustomException {
		Tables tables = codeingService.readDbTable(tableName);
		if(tables.getColumns()==null || tables.getColumns().size()==0){
			throw new CustomException("表"+tableName+"不存在");
		}
		tables = this.addTables(tables);
		for (Columns columns : tables.getColumns()) {
			columns.setTid(tables.getTid());
			columnsService.addColumns(columns);
		}
		return tables;
	}

	/* 更新 */
	@Override
	public Tables updateTables(Tables tables) {
		tablesDao.updateTables(tables);
		return tables;
	}

	/* 删除 */
	@Override
	@Transactional
	public void deleteTablesById(String tid) {
		columnsService.deleteColumnsByTid(tid);
		tablesDao.deleteTablesById(tid);
	}

	/* Id查询 */
	@Override
	public Tables getTablesById(String tid) {
		Tables table = tablesDao.getTablesById(tid);
		return table;
	}

	/* 分页查询 */
	@Override
	public PageInfo findTablesPage(PageInfo page, Map<String, Object> param) {
		return page.setRows(tablesDao.findTablesListPage(page,param));
	}

	/* 属性查询 */
	@Override
	public List<Tables> findTablesByProperty(Map<String, Object> param) {
		return tablesDao.findTablesByProperty(param);
	}

}
