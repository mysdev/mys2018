package com.jing.settlement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.settlement.model.dao.PackagesMapper;
import com.jing.settlement.model.entity.Packages;
import com.jing.settlement.service.PackagesService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Packages
 * @Description: 消费套餐服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("packagesService")
@Transactional(readOnly=true)
public class  PackagesServiceImpl implements PackagesService {	
//	private static final Logger logger = LoggerFactory.getLogger(PackagesServiceImpl.class);
	
	@Autowired
    private PackagesMapper packagesMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addPackages
	 * @Description:添加消费套餐
	 * @param packages 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Packages addPackages(Packages packages){
		packages.setPackageId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		int ret = packagesMapper.addPackages(packages);
		if(ret>0){
			return packages;
		}
		return null;
	}
	
	/**
	 * @Title modifyPackages
	 * @Description:修改消费套餐
	 * @param packages 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyPackages(Packages packages){
		return packagesMapper.modifyPackages(packages);
	}
	
	/**
	 * @Title: dropPackagesByPackageId
	 * @Description:删除消费套餐
	 * @param packageId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropPackagesByPackageId(String packageId){
		return packagesMapper.dropPackagesByPackageId(packageId);
	}
	
	/**
	 * @Title: queryPackagesByPackageId
	 * @Description:根据实体标识查询消费套餐
	 * @param packageId 实体标识
	 * @return Packages
	 */
	@Override
	public Packages queryPackagesByPackageId(String packageId){
		return packagesMapper.queryPackagesByPackageId(packageId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryPackagesForPage
	 * @Description: 根据消费套餐属性与分页信息分页查询消费套餐信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param packages 实体
	 * @return List<Packages>
	 */
	@Override
	public Map<String, Object> queryPackagesForPage(Integer pagenum, Integer pagesize, String sort, Packages packages){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Packages.class);
		List<Packages> entityList = packagesMapper.queryPackagesForPage(pageBounds, packages);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Packages.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Packages> pagelist = (PageList<Packages>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryPackagesByProperty
	 * @Description:根据属性查询消费套餐
	 * @return List<Packages>
	 */
	@Override
	public List<Packages> queryPackagesByProperty(Map<String, Object> map){
		return packagesMapper.queryPackagesByProperty(map);
	}


}
