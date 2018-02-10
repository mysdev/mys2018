package com.jing.utils.paginator.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.jing.utils.ClassUtil;
import com.jing.utils.StringUtil;
import com.jing.utils.paginator.domain.Order.Direction;

/**
* @ClassName: PageBounds  
* @Description: 分页查询对象
* @author li chao
* @date 2015年9月23日 下午1:51:12 
* @version V1.0  
 */
public class PageBounds extends RowBounds implements Serializable {
    private static final long serialVersionUID = -6414350656252331011L;
    public final static int NO_PAGE = 1;
    /** 页号 */
    protected int page = NO_PAGE;
    /** 分页大小 */
    protected int limit = NO_ROW_LIMIT;
    /** 分页排序信息 */
    protected List<Order> orders = new ArrayList<Order>();
    /** 结果集是否包含TotalCount */
    protected boolean containsTotalCount;

    protected Boolean asyncTotalCount;

    public PageBounds(){
        containsTotalCount = false;
    }

    public PageBounds(RowBounds rowBounds) {
        if(rowBounds instanceof PageBounds){
            PageBounds pageBounds = (PageBounds)rowBounds;
            this.page = pageBounds.page;
            this.limit = pageBounds.limit;
            this.orders = pageBounds.orders;
            this.containsTotalCount = pageBounds.containsTotalCount;
            this.asyncTotalCount = pageBounds.asyncTotalCount;
        }else{
            this.page = (rowBounds.getOffset()/rowBounds.getLimit())+1;
            this.limit = rowBounds.getLimit();
        }

    }

    /**
     * Query TOP N, default containsTotalCount = false
     * @param limit
     */
    public PageBounds(int limit) {
        this.limit = limit;
        this.containsTotalCount = false;
    }

    public PageBounds(int page, int limit) {
        this(page, limit, new ArrayList<Order>(), true);
    }

    public PageBounds(int page, int limit, boolean containsTotalCount) {
        this(page, limit, new ArrayList<Order>(), containsTotalCount);
    }

    /**
     * Just sorting, default containsTotalCount = false
     * @param orders
     */
    public PageBounds(List<Order> orders) {
        this(NO_PAGE, NO_ROW_LIMIT,orders ,false);
    }

    /**
     * Just sorting, default containsTotalCount = false
     * @param order
     */
    public PageBounds(Order... order) {
        this(NO_PAGE, NO_ROW_LIMIT,order);
        this.containsTotalCount = false;
    }

    public PageBounds(int page, int limit, Order... order) {
        this(page, limit, Arrays.asList(order), true);
    }

    public PageBounds(int page, int limit, List<Order> orders) {
        this(page, limit, orders, true);
    }

    public PageBounds(int page, int limit, List<Order> orders, boolean containsTotalCount) {
        this.page = page;
        this.limit = limit;
        this.orders = orders;
        this.containsTotalCount = containsTotalCount;
    }
    
    
    public PageBounds(int page, int limit, List<Order> orders, boolean containsTotalCount,boolean asyncTotalCount) {
        this.page = page;
        this.limit = limit;
        this.orders = orders;
        this.containsTotalCount = containsTotalCount;
        this.asyncTotalCount = asyncTotalCount;
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

    public boolean isContainsTotalCount() {
        return containsTotalCount;
    }

    public void setContainsTotalCount(boolean containsTotalCount) {
        this.containsTotalCount = containsTotalCount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    /** 
    * @Title: setOrdersByJsonForMap 
    * @Title: setOrdersByString 
     * @Description:  排序查询参数  此方法直接将传入参数进行数据过滤，可能会因为字段不存在导致错误
     * 防止先后顺序影响数据，手工解析数据。
     * @param jsonS {"id":"asc","name":"desc"}
     * @return  void    返回类型 
    * @throws 
    */
    public void setOrdersByJsonForMap(String jsonS){
		if (jsonS == null) {
			return;
		}
		if (jsonS.startsWith("{")) {
			jsonS = jsonS.substring(1, jsonS.length());
		}
		if (jsonS.endsWith("}")) {
			jsonS = jsonS.substring(0, jsonS.length() - 1);
		}
		// //防止参数出问题
		// jsonS = jsonS.toUpperCase();
		// jsonS = jsonS.replaceAll(" DESC", "");
		// jsonS = jsonS.replaceAll(" ASC", "");
		// jsonS = jsonS.replaceAll(" ", ""); //去空格-方式一 容错
		jsonS = jsonS.trim(); // 去首尾空格-方式二 数据格式正确

		if (jsonS.length() == 0) {
			return;
		}
		List<Order> order = new ArrayList<Order>();
		String[] orders = jsonS.split(",\"");
		for (int i = 0; i < orders.length; i++) {
			if (orders[i] != null && orders[i].length() > 0) {
				String[] item = orders[i].replaceAll("\"", "").split(":");
				if (item[0] == null || item[0].trim().length() == 0) {
					continue; // 字段数据为空
				}
				Order o = new Order(item[0].trim(), Direction.ASC, null);
				if (item.length > 1 && item[1] != null && "desc".equals(item[1].trim().toLowerCase())) {
					o.setDirection(Direction.DESC);
				}
				order.add(o);				
			}
		}
		if (order.size() > 0) {
			this.setOrders(order);
		}
    }
    
    /**
     * @param class  
     * @Title: setOrdersByString 
     * @Description:  排序查询参数
     * 防止先后顺序影响数据，手工解析数据。
     * @param jsonS {"id":"asc","name":"desc"}
     * @param cla 类 如果传入则将参数进行属性校验，否则不作校验
     * @throws 
     */
	public void setOrdersByJson(String jsonS, Class<?> cla) {
		Map<String, Object>  pmap = null;
		try {
			if (cla != null) {
				Object obj = cla.newInstance();	//获取实体对象			
				pmap = ClassUtil.transBean2Map(obj, true); //获取包括null的属性
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		if (jsonS == null) {
			return;
		}
		if (jsonS.startsWith("{")) {
			jsonS = jsonS.substring(1, jsonS.length());
		}
		if (jsonS.endsWith("}")) {
			jsonS = jsonS.substring(0, jsonS.length() - 1);
		}
		// //防止参数出问题
		// jsonS = jsonS.toUpperCase();
		// jsonS = jsonS.replaceAll(" DESC", "");
		// jsonS = jsonS.replaceAll(" ASC", "");
		// jsonS = jsonS.replaceAll(" ", ""); //去空格-方式一 容错
		jsonS = jsonS.trim(); // 去首尾空格-方式二 数据格式正确

		if (jsonS.length() == 0) {
			return;
		}
		List<Order> order = new ArrayList<Order>();
		String[] orders = jsonS.split(",\"");
		for (int i = 0; i < orders.length; i++) {
			if (orders[i] != null && orders[i].length() > 0) {
				String[] item = orders[i].replaceAll("\"", "").split(":");
				if (item[0] == null || item[0].trim().length() == 0) {
					continue; // 字段数据为空
				}
				if(cla!=null){
					String pro = ClassUtil.camel2Underline(item[0].trim()); //带下划线格式
					if(pmap!=null && pro!=null && pmap.containsKey(item[0].trim())){
						//对象存在属性方限定，否则视作无效数据丢弃
						Order o = new Order(pro, Direction.ASC, null);
						if (item.length > 1 && item[1] != null && "desc".equals(item[1].trim().toLowerCase())) {
							o.setDirection(Direction.DESC);
						}
						order.add(o);
					}
				}else{
					Order o = new Order(ClassUtil.camel2Underline(item[0].trim()), Direction.ASC, null);
					if (item.length > 1 && item[1] != null && "desc".equals(item[1].trim().toLowerCase())) {
						o.setDirection(Direction.DESC);
					}
					order.add(o);
				}
			}
		}
		if (order.size() > 0) {
			this.setOrders(order);
		}
	}

    public Boolean getAsyncTotalCount() {
        return asyncTotalCount;
    }

    public void setAsyncTotalCount(Boolean asyncTotalCount) {
        this.asyncTotalCount = asyncTotalCount;
    }

    @Override
    public int getOffset() {
        if(page >= 1){
            return (page-1) * limit;
        }
        return 0;
    }

    @Override
    public String toString() {
    	return StringUtil.entityToString(this);
    }
}