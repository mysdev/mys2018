package com.jing.utils.paginator.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PageService  
 * @Description: 分页处理
 * @author li chao
 * @date 2015年9月23日 下午2:55:09   @version V1.0  
 */
@Service("pageService")
@Scope("prototype")
public class PageService {

	/** 页号 */
	private int page = 1;
	/** 页号 */
	private int pageinit = 1;

	// 绑定错误信息
	/** 分页大小 */
	private int limit = 10;
	
	/** 分页大小 */
	private int limitinit = 10;

	/** 分页排序信息 */
	private List<Order> orders = new ArrayList<Order>();

	/** 结果集是否包含TotalCount */
	private boolean containsTotalCount = true;

	/** 是否异步查询 */
	private Boolean asyncTotalCount = false;

	// 分页查询对象
	private PageBounds pageBounds;


	public PageBounds getPageBounds() {
		return pageBounds;
	}

	public void setAsyncTotalCount(boolean asyncTotalCount) {
		this.asyncTotalCount = asyncTotalCount;
	}

	public void setPageBounds(PageBounds pageBounds) {
		this.pageBounds = pageBounds;
	}

	
	/**
	 * 
	* @Title: getPageBounds  
	* @Description: 根据参数获取PageBounds对象
	* @param page 当前页  limit 每页条数  orders  排序信息  containsTotalCount 是否包含总页数   asyncTotalCount  是否异步统计总数
	* @return PageBounds    返回类型  
	* @author li chao
	* @throws  
	 */
	public PageBounds getPageBounds(Integer page, Integer limit, List<Order> orders,
			boolean containsTotalCount, boolean asyncTotalCount) {
		if (null == pageBounds) {
			if(null==limit){
				limit = limitinit;
			}
			if(null==page){
				page = pageinit;
			}
			pageBounds = new PageBounds(page, limit, orders,
					containsTotalCount, asyncTotalCount);
		} else {
			if(null==page){
				page = pageinit;
			}
			if(null==limit){
				limit = limitinit;
			}
			pageBounds.setPage(page);
			pageBounds.setLimit(limit);
			pageBounds.setOrders(orders);
			pageBounds.setContainsTotalCount(containsTotalCount);
			pageBounds.setAsyncTotalCount(asyncTotalCount);
		}
		return pageBounds;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public boolean isContainsTotalCount() {
		return containsTotalCount;
	}

	public void setContainsTotalCount(boolean containsTotalCount) {
		this.containsTotalCount = containsTotalCount;
	}

	public Boolean getAsyncTotalCount() {
		return asyncTotalCount;
	}

	public void setAsyncTotalCount(Boolean asyncTotalCount) {
		this.asyncTotalCount = asyncTotalCount;
	}

}
