package com.jing.settlement.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.settlement.model.entity.PackagesDetail;

/**
 * @ClassName: PackagesDetailMapper
 * @Description: 消费套餐详情映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Mapper
public interface PackagesDetailMapper {

	/**
	 * @Title: addPackagesDetail
	 * @Description:添加消费套餐详情
	 * @param packagesDetail 实体
	 * @return Integer
	 */
	Integer addPackagesDetail(PackagesDetail packagesDetail);
	
	/**
	 * @Title modifyPackagesDetail
	 * @Description:修改消费套餐详情
	 * @param packagesDetail 实体
	 * @return Integer
	 */
	Integer modifyPackagesDetail(PackagesDetail packagesDetail);
	
	/**
	 * @Title: dropPackagesDetailByDetailId
	 * @Description:删除消费套餐详情
	 * @param detailId 实体标识
	 * @return Integer
	 */
	Integer dropPackagesDetailByDetailId(Integer detailId);
	
	/**
	 * @Title: queryPackagesDetailByDetailId
	 * @Description:根据实体标识查询消费套餐详情
	 * @param detailId 实体标识
	 * @return PackagesDetail
	 */
	PackagesDetail queryPackagesDetailByDetailId(Integer detailId);
	 
	/**
	 * @Title: queryPackagesDetailForPage
	 * @Description: 根据消费套餐详情属性与分页信息分页查询消费套餐详情信息
	 * @param pageBounds 分页信息
	 * @param packagesDetail 实体
	 * @return List<PackagesDetail>
	 */
	List<PackagesDetail> queryPackagesDetailForPage(PageBounds pageBounds, @Param("packagesDetail") PackagesDetail packagesDetail);
	 
	 /**
	  * @Title: queryPackagesDetailByProperty
	  * @Description:根据属性查询消费套餐详情
	  * @return List<PackagesDetail>
	  */
	 List<PackagesDetail> queryPackagesDetailByProperty(@Param("packagesDetail") Map<String, Object> map);
	 
	 
	 
}
