package com.jing.settlement.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.entity.PackagesDetail;
import com.jing.settlement.model.entity.PackagesDetailVo;

@Mapper
public interface PackagesDetailMapper {

	/**
	* 添加 消费套餐详情
	*/
	void addPackagesDetail(PackagesDetail packagesDetail);
	
	/**
	* 修改 消费套餐详情
	*/
	void updatePackagesDetail(PackagesDetail packagesDetail);
	
	/**
	*根据ID删除记录
	*/
	void deletePackagesDetailById(Integer id);	
	
	/**
	*根据ID查询记录
	*/
	PackagesDetail getPackagesDetailById(Integer id);
	
	/**
	* 分页查询
	*/
	List<PackagesDetailVo> findPackagesDetailListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询消费套餐详情
	 * @param param
	 * @return
	 */
	List<PackagesDetailVo> findPackagesDetailList(@Param("param") Map<String, Object> param);	
}