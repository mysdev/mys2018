package com.jing.core.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;
import java.util.UUID;


import com.jing.core.model.entity.Store;
import com.jing.core.model.dao.StoreMapper;
import com.jing.core.service.StoreService;

/**
 * @ClassName: Store
 * @Description: 门店服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("storeService")
@Transactional(readOnly=true)
public class  StoreServiceImpl implements StoreService {	
	private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);
	
	@Autowired
    private StoreMapper storeMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addStore
	 * @Description:添加门店
	 * @param store 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Store addStore(Store store){
		store.setStoreId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		int ret = storeMapper.addStore(store);
		if(ret>0){
			return store;
		}
		return null;
	}
	
	/**
	 * @Title modifyStore
	 * @Description:修改门店
	 * @param store 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyStore(Store store){
		return storeMapper.modifyStore(store);
	}
	
	/**
	 * @Title: dropStoreByStoreId
	 * @Description:删除门店
	 * @param storeId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropStoreByStoreId(String storeId){
		return storeMapper.dropStoreByStoreId(storeId);
	}
	
	/**
	 * @Title: queryStoreByStoreId
	 * @Description:根据实体标识查询门店
	 * @param storeId 实体标识
	 * @return Store
	 */
	@Override
	public Store queryStoreByStoreId(String storeId){
		return storeMapper.queryStoreByStoreId(storeId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryStoreForPage
	 * @Description: 根据门店属性与分页信息分页查询门店信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param store 实体
	 * @return List<Store>
	 */
	@Override
	public Map<String, Object> queryStoreForPage(Integer pagenum, Integer pagesize, String sort, Store store){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Store.class);
		List<Store> entityList = storeMapper.queryStoreForPage(pageBounds, store);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Store.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Store> pagelist = (PageList<Store>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryStoreByProperty
	 * @Description:根据属性查询门店
	 * @return List<Store>
	 */
	@Override
	public List<Store> queryStoreByProperty(Map<String, Object> map){
		return storeMapper.queryStoreByProperty(map);
	}


}
