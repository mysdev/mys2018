package com.jing.settlement.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.dao.PackagesDetailMapper;
import com.jing.settlement.model.entity.PackagesDetail;
import com.jing.settlement.model.entity.PackagesDetailVo;
import com.jing.settlement.service.PackagesDetailService;
import com.jing.settlement.service.PackagesService;

@Service("packagesDetailService")
public class PackagesDetailServiceImpl implements PackagesDetailService{

	@Resource
	private PackagesDetailMapper packagesDetailMapper;
	@Autowired
	private PackagesService packagesService;

	/**
	* 添加 消费套餐详情
	*/
	@Override
	@Transactional
	public void addPackagesDetail(PackagesDetail packagesDetail){
		packagesDetailMapper.addPackagesDetail(packagesDetail);
		packagesService.resetprice(packagesDetail.getPackageId());
	}
	
	/**
	* 修改 消费套餐详情
	*/
	@Override
	@Transactional
	public void updatePackagesDetail(PackagesDetail packagesDetail){
		packagesDetailMapper.updatePackagesDetail(packagesDetail);
		packagesService.resetprice(packagesDetail.getPackageId());
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	@Transactional
	public void deletePackagesDetailById(Integer id){
		PackagesDetail d = this.getPackagesDetailById(id);
		packagesService.resetprice(d.getPackageId());
		packagesDetailMapper.deletePackagesDetailById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public PackagesDetail getPackagesDetailById(Integer id){
		return packagesDetailMapper.getPackagesDetailById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findPackagesDetailListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(packagesDetailMapper.findPackagesDetailListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询消费套餐详情
	 * @param param
	 * @return
	 */
	 @Override
	public List<PackagesDetailVo> findPackagesDetailList(Map<String, Object> param){
		return packagesDetailMapper.findPackagesDetailList(param);
	}
	
}