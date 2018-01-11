package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.Store;

/**
 * @ClassName: Store
 * @Description: 门店服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface StoreService {

    /**
	 * @Title: addStore
	 * @Description:添加门店
	 * @param store 实体
	 * @return Integer
	 */
	Store addStore(Store store);
	
	/**
	 * @Title modifyStore
	 * @Description:修改门店
	 * @param store 实体
	 * @return Integer
	 */
	Integer modifyStore(Store store);
	
	/**
	 * @Title: dropStoreByStoreId
	 * @Description:删除门店
	 * @param storeId 实体标识
	 * @return Integer
	 */
	Integer dropStoreByStoreId(String storeId);
	
	/**
	 * @Title: queryStoreByStoreId
	 * @Description:根据实体标识查询门店
	 * @param storeId 实体标识
	 * @return Store
	 */
	Store queryStoreByStoreId(String storeId);
	 
	/**
	 * @Title: queryStoreForPage
	 * @Description: 根据门店属性与分页信息分页查询门店信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param store 实体
	 * @return List<Store>
	 */
	Map<String, Object> queryStoreForPage(Integer pagenum, Integer pagesize, String sort, Store store);
	 
	 /**
	 * @Title: queryStoreByProperty
	 * @Description:根据属性查询门店
	 * @return List<Store>
	 */
	 List<Store> queryStoreByProperty(Map<String, Object> map);	 
	 
}
