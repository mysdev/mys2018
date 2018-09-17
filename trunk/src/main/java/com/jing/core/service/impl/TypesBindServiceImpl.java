package com.jing.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.core.model.dao.TypesBindMapper;
import com.jing.core.model.entity.TypesBind;
import com.jing.core.service.TypesBindService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: TypesBind
 * @Description: 类型消费绑定服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("typesBindService")
@Transactional(readOnly=true)
public class  TypesBindServiceImpl implements TypesBindService {	
//	private static final Logger logger = LoggerFactory.getLogger(TypesBindServiceImpl.class);
	
	@Autowired
    private TypesBindMapper typesBindMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addTypesBind
	 * @Description:添加类型消费绑定
	 * @param typesBind 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public TypesBind addTypesBind(TypesBind typesBind){
		int ret = typesBindMapper.addTypesBind(typesBind);
		if(ret>0){
			return typesBind;
		}
		return null;
	}
	
	/**
	 * @Title modifyTypesBind
	 * @Description:修改类型消费绑定
	 * @param typesBind 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyTypesBind(TypesBind typesBind){
		return typesBindMapper.modifyTypesBind(typesBind);
	}
	
	/**
	 * @Title: dropTypesBindByBindId
	 * @Description:删除类型消费绑定
	 * @param bindId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropTypesBindByBindId(Integer bindId){
		return typesBindMapper.dropTypesBindByBindId(bindId);
	}
	
	/**
	 * @Title: queryTypesBindByBindId
	 * @Description:根据实体标识查询类型消费绑定
	 * @param bindId 实体标识
	 * @return TypesBind
	 */
	@Override
	public TypesBind queryTypesBindByBindId(Integer bindId){
		return typesBindMapper.queryTypesBindByBindId(bindId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryTypesBindForPage
	 * @Description: 根据类型消费绑定属性与分页信息分页查询类型消费绑定信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param typesBind 实体
	 * @return List<TypesBind>
	 */
	@Override
	public Map<String, Object> queryTypesBindForPage(Integer pagenum, Integer pagesize, String sort, TypesBind typesBind){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, TypesBind.class);
		List<TypesBind> entityList = typesBindMapper.queryTypesBindForPage(pageBounds, typesBind);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, TypesBind.class);
		}
		if (!entityList.isEmpty()) {
			PageList<TypesBind> pagelist = (PageList<TypesBind>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryTypesBindByProperty
	 * @Description:根据属性查询类型消费绑定
	 * @return List<TypesBind>
	 */
	@Override
	public List<TypesBind> queryTypesBindByProperty(Map<String, Object> map){
		return typesBindMapper.queryTypesBindByProperty(map);
	}


}
