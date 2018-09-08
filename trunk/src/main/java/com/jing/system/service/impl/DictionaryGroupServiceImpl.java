package com.jing.system.service.impl;

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
import com.jing.system.model.entity.Dictionary;
import com.jing.system.model.entity.DictionaryGroup;
import com.jing.system.model.dao.DictionaryGroupMapper;
import com.jing.system.service.DictionaryGroupService;
import com.jing.system.service.DictionaryService;

/**
 * @ClassName: DictionaryGroup
 * @Description: 字典分组服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("dictionaryGroupService")
@Transactional(readOnly=true)
public class  DictionaryGroupServiceImpl implements DictionaryGroupService {	
	private static final Logger logger = LoggerFactory.getLogger(DictionaryGroupServiceImpl.class);
	
	@Autowired
    private DictionaryGroupMapper dictionaryGroupMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	@Autowired
	private DictionaryService dictionaryService;
	
	
	/**
	 * @Title: addDictionaryGroup
	 * @Description:添加字典分组
	 * @param dictionaryGroup 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public DictionaryGroup addDictionaryGroup(DictionaryGroup dictionaryGroup){
		int ret = dictionaryGroupMapper.addDictionaryGroup(dictionaryGroup);
		if(ret>0){
			return dictionaryGroup;
		}
		return null;
	}
	
	/**
	 * @Title modifyDictionaryGroup
	 * @Description:修改字典分组
	 * @param dictionaryGroup 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyDictionaryGroup(DictionaryGroup dictionaryGroup){
		return dictionaryGroupMapper.modifyDictionaryGroup(dictionaryGroup);
	}
	
	/**
	 * @Title: dropDictionaryGroupByGroupId
	 * @Description:删除字典分组
	 * @param groupId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropDictionaryGroupByGroupId(Integer groupId){
		return dictionaryGroupMapper.dropDictionaryGroupByGroupId(groupId);
	}
	
	/**
	 * @Title: queryDictionaryGroupByGroupId
	 * @Description:根据实体标识查询字典分组
	 * @param groupId 实体标识
	 * @return DictionaryGroup
	 */
	@Override
	public DictionaryGroup queryDictionaryGroupByGroupId(Integer groupId){
		return dictionaryGroupMapper.queryDictionaryGroupByGroupId(groupId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryDictionaryGroupForPage
	 * @Description: 根据字典分组属性与分页信息分页查询字典分组信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param dictionaryGroup 实体
	 * @return List<DictionaryGroup>
	 */
	@Override
	public Map<String, Object> queryDictionaryGroupForPage(Integer pagenum, Integer pagesize, String sort, DictionaryGroup dictionaryGroup){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, DictionaryGroup.class);
		List<DictionaryGroup> entityList = dictionaryGroupMapper.queryDictionaryGroupForPage(pageBounds, dictionaryGroup);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, DictionaryGroup.class);
		}
		if (!entityList.isEmpty()) {
			PageList<DictionaryGroup> pagelist = (PageList<DictionaryGroup>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryDictionaryGroupByProperty
	 * @Description:根据属性查询字典分组
	 * @return List<DictionaryGroup>
	 */
	@Override
	public List<DictionaryGroup> queryDictionaryGroupByProperty(Map<String, Object> map){
		return dictionaryGroupMapper.queryDictionaryGroupByProperty(map);
	}


	@Override
	public List<DictionaryGroup> findAllDictionaryGroup() {
		List<DictionaryGroup> list = this.queryDictionaryGroupByProperty(new HashMap<String, Object>());
		if(list!=null && list.size()>0) {
			for (DictionaryGroup dictionaryGroup : list) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("groupCode", dictionaryGroup.getGroupCode());
				List<Dictionary> ds = dictionaryService.queryDictionaryByProperty(map);
				dictionaryGroup.setDictionaries(ds);
			}
		}
		return list;
	}
}
