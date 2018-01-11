package com.jing.settlement.service.impl;

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


import com.jing.settlement.model.entity.PackagesDetail;
import com.jing.settlement.model.dao.PackagesDetailMapper;
import com.jing.settlement.service.PackagesDetailService;

/**
 * @ClassName: PackagesDetail
 * @Description: 消费套餐详情服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("packagesDetailService")
@Transactional(readOnly=true)
public class  PackagesDetailServiceImpl implements PackagesDetailService {	
	private static final Logger logger = LoggerFactory.getLogger(PackagesDetailServiceImpl.class);
	
	@Autowired
    private PackagesDetailMapper packagesDetailMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addPackagesDetail
	 * @Description:添加消费套餐详情
	 * @param packagesDetail 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public PackagesDetail addPackagesDetail(PackagesDetail packagesDetail){
		int ret = packagesDetailMapper.addPackagesDetail(packagesDetail);
		if(ret>0){
			return packagesDetail;
		}
		return null;
	}
	
	/**
	 * @Title modifyPackagesDetail
	 * @Description:修改消费套餐详情
	 * @param packagesDetail 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyPackagesDetail(PackagesDetail packagesDetail){
		return packagesDetailMapper.modifyPackagesDetail(packagesDetail);
	}
	
	/**
	 * @Title: dropPackagesDetailByDetailId
	 * @Description:删除消费套餐详情
	 * @param detailId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropPackagesDetailByDetailId(Integer detailId){
		return packagesDetailMapper.dropPackagesDetailByDetailId(detailId);
	}
	
	/**
	 * @Title: queryPackagesDetailByDetailId
	 * @Description:根据实体标识查询消费套餐详情
	 * @param detailId 实体标识
	 * @return PackagesDetail
	 */
	@Override
	public PackagesDetail queryPackagesDetailByDetailId(Integer detailId){
		return packagesDetailMapper.queryPackagesDetailByDetailId(detailId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryPackagesDetailForPage
	 * @Description: 根据消费套餐详情属性与分页信息分页查询消费套餐详情信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param packagesDetail 实体
	 * @return List<PackagesDetail>
	 */
	@Override
	public Map<String, Object> queryPackagesDetailForPage(Integer pagenum, Integer pagesize, String sort, PackagesDetail packagesDetail){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, PackagesDetail.class);
		List<PackagesDetail> entityList = packagesDetailMapper.queryPackagesDetailForPage(pageBounds, packagesDetail);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, PackagesDetail.class);
		}
		if (!entityList.isEmpty()) {
			PageList<PackagesDetail> pagelist = (PageList<PackagesDetail>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryPackagesDetailByProperty
	 * @Description:根据属性查询消费套餐详情
	 * @return List<PackagesDetail>
	 */
	@Override
	public List<PackagesDetail> queryPackagesDetailByProperty(Map<String, Object> map){
		return packagesDetailMapper.queryPackagesDetailByProperty(map);
	}


}
