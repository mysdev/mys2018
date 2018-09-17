package com.jing.config.web.page;

import java.util.ArrayList;
import java.util.List;

public class PageInfo implements java.io.Serializable {
	private static final long serialVersionUID = 5262733160928677127L;

	private int pageNumber = PageUtil.DEFAULT_INIT_PAGE; // 当前要查询页码
	
	private int pageSize = 10;// 每页记录数

	private int nextPage = 0; // 下一页码

	private int previousPage = 0; // 上一页码

	private List<?> rows = null; // 数据集合

	private int nextReusltIndex = 1 + pageSize; // 下一页开始的数据索引号

	private int previousResultIndex = 0; // 上一页开始的数据索引号

	private int currentResultIndex = 0; // 当前页开始的索引号

	private int pageCount = 0; // 总页数

	private int total = 0; // 总记录数

	private int firstPageResultIndex = 0; // 第一页数据索引

	private int lastPageResultIndex = 0; // 最后一页数据索引

	private String orderName;
	private String sortName;

	/**
	 * 静态分页，将所有记录查询出来后，执行分页
	 * 
	 * @param resultList
	 *            记录总集
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo limitPage(List resultList) {
		if (resultList != null && resultList.size() > 0) {
			this.setTotal(resultList.size());
			List pageList = new ArrayList();
			for (int i = getStartRecord(); i < getEndRecord(); i++) {
				pageList.add(resultList.get(i));
			}

			this.setRows(pageList);
		} else {
			this.setTotal(0);
			this.setRows(null);
		}
		return this;
	}

	/**
	 * 获取分页开始记录
	 * 
	 * @return 分页开始记录
	 */
	public int getStartRecord() {
		if ((this.pageNumber > this.getPageCount()) && (this.getPageCount() != 0)) {
			return this.getPageSize() * (this.pageNumber - 2);
		}

		return this.getPageSize() * (this.pageNumber - 1);
	}

	/**
	 * 获取分页结束记录
	 * 
	 * @return 分页结束记录
	 */
	public int getEndRecord() {
		if (this.pageNumber >= this.getPageCount()) {
			return this.getTotal();
		} else {
			return this.getPageSize() * this.pageNumber;
		}
	}

	/**
	 * 获取首记录
	 * 
	 * @return
	 */
	public int getFirstPageResultIndex() {
		return 0;
	}

	public int getLastPageResultIndex() {
		if (rows == null) {
			return 0;
		}
		if (rows.size() % this.pageSize == 0) {
			return (this.getPageCount() - 1) * this.pageSize + 1;
		} else {
			return (rows.size() - rows.size() % this.pageSize) + 1;
		}
	}

	public PageInfo() {
		super();
	}

	public PageInfo(List<?> resultList, int recordCounts) {
		super();
		this.rows = resultList;
		this.total = recordCounts;
	}

	public PageInfo(List<?> resultList, int total, int currentPage) {
		super();
		this.rows = resultList;
		this.pageNumber = currentPage;
		this.total = total;
	}

	public PageInfo(List<?> resultList, int total, int pageSize, int currentPage) {
		super();
		this.rows = resultList;
		this.pageSize = pageSize;
		this.pageNumber = currentPage;
		this.total = total;
	}

	public PageInfo(List<?> resultList, int total, int pageSize, int currentPage, String orderName,
			String sortName) {
		super();
		this.rows = resultList;
		this.pageSize = pageSize;
		this.pageNumber = currentPage;
		this.total = total;
		this.sortName = sortName;
		this.orderName = orderName;
	}

	public int getCurrentPage() {
		if (this.pageNumber > this.getPageCount()) {
			return this.getPageCount();
		}
		return this.pageNumber;
	}

	public int getNextPage() {
		if (this.getCurrentPage() == this.getPageCount()) {
			return this.getCurrentResultIndex();
		} else {
			return this.getCurrentPage() + 1;
		}

	}

	public int getPreviousPage() {
		if (this.getCurrentPage() == 1) {
			return this.getCurrentPage();
		} else {
			return this.getCurrentPage() - 1;
		}
	}

	public List<?> getRows() {
		return rows;
	}

	public PageInfo setRows(List<?> rows) {
		this.rows = rows;
		return this;
	}

	public int getNextReusltIndex() {
		if (this.getCurrentPage() == this.getPageCount()) {
			return this.getCurrentResultIndex();
		} else {
			return this.getCurrentResultIndex() + this.pageSize + 1;
		}
	}

	public int getPreviousResultIndex() {
		if (this.getCurrentPage() == 1) {
			return this.getCurrentResultIndex();
		} else {
			return this.getCurrentResultIndex() - this.pageSize;
		}
	}

	public int getCurrentResultIndex() {
		return (this.pageNumber-1) * this.pageSize;
	}

	public PageInfo setCurrentResultIndex(int currentResultIndex) {
		this.currentResultIndex = currentResultIndex;
		return this;
	}

	public int getPageCount() {
		if (this.getTotal() == 0) {
			return 0;
		} else {
			if (this.getTotal() % this.getPageSize() == 0) {
				return this.getTotal() / this.getPageSize();
			} else {
				return this.getTotal() / this.getPageSize() + 1;
			}
		}
	}

	public int getTotal() {
		return total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public PageInfo setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public String getOrderName() {
		return orderName;
	}

	public PageInfo setOrderName(String orderName) {
		this.orderName = orderName;
		return this;
	}

	public String getSortName() {
		return sortName;
	}

	public PageInfo setSortName(String sortName) {
		this.sortName = sortName;
		return this;
	}

	public String toString() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("currentPage: ").append(this.pageNumber);
		strBuf.append(" nextPage: ").append(this.nextPage);
		strBuf.append(" previousPage: ").append(this.previousPage);
		strBuf.append(" resultList: ").append(this.rows);
		strBuf.append(" pageSize: ").append(this.pageSize);
		strBuf.append(" nextReusltIndex: ").append(this.nextReusltIndex);
		strBuf.append(" previousResultIndex: ").append(this.previousResultIndex);
		strBuf.append(" currentResultIndex: ").append(this.currentResultIndex);
		strBuf.append(" pageCount: ").append(this.pageCount);
		strBuf.append(" total: ").append(this.total);
		strBuf.append(" firstPageResultIndex: ").append(this.firstPageResultIndex);
		strBuf.append(" lastPageResultIndex: ").append(this.lastPageResultIndex);
		strBuf.append(" orderName: ").append(this.orderName);
		strBuf.append(" SortName: ").append(this.sortName);
		return strBuf.toString();
	}

	public PageInfo setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		return this;
	}

	public PageInfo setTotal(int total) {
		this.total = total;
		return this;
	}

	public PageInfo setNextPage(int nextPage) {
		this.nextPage = nextPage;
		return this;
	}

	public PageInfo setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
		return this;
	}

	public PageInfo setNextReusltIndex(int nextReusltIndex) {
		this.nextReusltIndex = nextReusltIndex;
		return this;
	}

	public PageInfo setPreviousResultIndex(int previousResultIndex) {
		this.previousResultIndex = previousResultIndex;
		return this;
	}

	public PageInfo setPageCount(int pageCount) {
		this.pageCount = pageCount;
		return this;
	}

	public PageInfo setFirstPageResultIndex(int firstPageResultIndex) {
		this.firstPageResultIndex = firstPageResultIndex;
		return this;
	}

	public PageInfo setLastPageResultIndex(int lastPageResultIndex) {
		this.lastPageResultIndex = lastPageResultIndex;
		return this;
	}

}
