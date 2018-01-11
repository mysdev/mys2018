package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.Store;

/**
 * @ClassName: StoreMapper
 * @Description: 门店映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface StoreMapper {

	/**
	 * @Title: addStore
	 * @Description:添加门店
	 * @param store 实体
	 * @return Integer
	 */
	Integer addStore(Store store);
	
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
	 * @param pageBounds 分页信息
	 * @param store 实体
	 * @return List<Store>
	 */
	List<Store> queryStoreForPage(PageBounds pageBounds, @Param("store") Store store);
	 
	 /**
	  * @Title: queryStoreByProperty
	  * @Description:根据属性查询门店
	  * @return List<Store>
	  */
	 List<Store> queryStoreByProperty(@Param("store") Map<String, Object> map);
	 
	 
	 
}
