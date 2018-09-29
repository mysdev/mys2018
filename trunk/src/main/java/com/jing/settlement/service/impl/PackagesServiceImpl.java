package com.jing.settlement.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.settlement.model.dao.PackagesMapper;
import com.jing.settlement.model.entity.Packages;
import com.jing.settlement.model.entity.PackagesDetailVo;
import com.jing.settlement.service.PackagesDetailService;
import com.jing.settlement.service.PackagesService;
import com.jing.utils.ChineseToPinyin;
import com.jing.utils.PrimaryKey;

@Service("packagesService")
public class PackagesServiceImpl implements PackagesService{

	@Resource
	private PackagesMapper packagesMapper;
	@Autowired
	private PackagesDetailService packagesDetailService;
	
	@Override
	public void resetprice(String packageId) {
		Packages packages = this.getPackagesById(packageId);
		if(packages==null) {
			throw new CustomException("套餐记录不存在");
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("packageId", packageId);
		List<PackagesDetailVo> packagesDetails =packagesDetailService.findPackagesDetailList(param);
		if(packagesDetails!=null && packagesDetails.size()>0) {
			BigDecimal originalPrice = new BigDecimal(0);
			for (PackagesDetailVo vo : packagesDetails) {
				originalPrice  = originalPrice.add(vo.getPrice());
			}
			packages.setOriginalPrice(originalPrice);
			BigDecimal preferentialPrice = originalPrice.subtract(packages.getPrice());
			packages.setPreferentialPrice(preferentialPrice);
			this.updatePackages(packages);
		}
	}

	/**
	* 添加 消费套餐
	*/
	@Override
	public void addPackages(Packages packages){
		packages.setPackageId(PrimaryKey.getUUID());
		if(packages.getPinyin()==null || "".equals(packages.getPinyin())) {
			packages.setPinyin(ChineseToPinyin.getPingYin(packages.getPackageName(), "LOWERCASE"));
		}
		packages.setStatus(0);
		packagesMapper.addPackages(packages);
	}
	
	/**
	* 修改 消费套餐
	*/
	@Override
	public void updatePackages(Packages packages){
		packagesMapper.updatePackages(packages);
	}
	
	/**
	*根据ID删除记录
	*/
	@Override
	public void deletePackagesById(String id){
		packagesMapper.deletePackagesById(id);
	}
	
	/**
	*根据ID查询记录
	*/
	@Override
	public Packages getPackagesById(String id){
		return packagesMapper.getPackagesById(id);
	}
	
	/**
	* 分页查询
	*/
	@Override
	public PageInfo findPackagesListPage(PageInfo page, Map<String, Object> param){
		return page.setRows(packagesMapper.findPackagesListPage(page,param));
	}
	
	
	/**
	 * 根据属性查询消费套餐
	 * @param param
	 * @return
	 */
	 @Override
	public List<Packages> findPackagesList(Map<String, Object> param){
		return packagesMapper.findPackagesList(param);
	}
	
}