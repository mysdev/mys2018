package com.jing.codeing.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.codeing.dao.ColumnsDao;
import com.jing.codeing.entity.Columns;
import com.jing.codeing.service.ColumnsService;
import com.jing.config.web.page.PageInfo;

@Service("columnsService")
public class ColumnsServiceImpl implements ColumnsService{
	@Resource
	private ColumnsDao columnsDao;

	@Override
	public Columns addColumns(Columns columns) {
		columnsDao.addColumns(columns);
		return columns;
	}

	@Override
	public Columns updateColumns(Columns columns) {
		columnsDao.updateColumns(columns);
		return columns;
	}

	@Override
	public void deleteColumnsById(String cid) {
		columnsDao.deleteColumnsById(cid);
	}
	
	@Override
	public void deleteColumnsByTid(String tid) {
		columnsDao.deleteColumnsByTid(tid);
	}

	@Override
	public Columns getColumnsById(String cid) {
		return columnsDao.getColumnsById(cid);
	}

	@Override
	public List<Columns> findColumnsByProperty(Map<String, Object> map) {
		return columnsDao.findColumnsByProperty(map);
	}

	@Override
	public PageInfo findColumnsPageList(Map<String, Object> map, PageInfo page) {
		return page.setRows(columnsDao.findColumnsListPage(page, map));
	}
}
