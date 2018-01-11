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


import com.jing.core.model.entity.EmployeeSpecial;
import com.jing.core.model.dao.EmployeeSpecialMapper;
import com.jing.core.service.EmployeeSpecialService;

/**
 * @ClassName: EmployeeSpecial
 * @Description: 员工特殊权限(扩)服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("employeeSpecialService")
@Transactional(readOnly=true)
public class  EmployeeSpecialServiceImpl implements EmployeeSpecialService {	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeSpecialServiceImpl.class);
	
	@Autowired
    private EmployeeSpecialMapper employeeSpecialMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addEmployeeSpecial
	 * @Description:添加员工特殊权限(扩)
	 * @param employeeSpecial 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public EmployeeSpecial addEmployeeSpecial(EmployeeSpecial employeeSpecial){
		employeeSpecial.setEmpId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		int ret = employeeSpecialMapper.addEmployeeSpecial(employeeSpecial);
		if(ret>0){
			return employeeSpecial;
		}
		return null;
	}
	
	/**
	 * @Title modifyEmployeeSpecial
	 * @Description:修改员工特殊权限(扩)
	 * @param employeeSpecial 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyEmployeeSpecial(EmployeeSpecial employeeSpecial){
		return employeeSpecialMapper.modifyEmployeeSpecial(employeeSpecial);
	}
	
	/**
	 * @Title: dropEmployeeSpecialByEmpId
	 * @Description:删除员工特殊权限(扩)
	 * @param empId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropEmployeeSpecialByEmpId(String empId){
		return employeeSpecialMapper.dropEmployeeSpecialByEmpId(empId);
	}
	
	/**
	 * @Title: queryEmployeeSpecialByEmpId
	 * @Description:根据实体标识查询员工特殊权限(扩)
	 * @param empId 实体标识
	 * @return EmployeeSpecial
	 */
	@Override
	public EmployeeSpecial queryEmployeeSpecialByEmpId(String empId){
		return employeeSpecialMapper.queryEmployeeSpecialByEmpId(empId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryEmployeeSpecialForPage
	 * @Description: 根据员工特殊权限(扩)属性与分页信息分页查询员工特殊权限(扩)信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param employeeSpecial 实体
	 * @return List<EmployeeSpecial>
	 */
	@Override
	public Map<String, Object> queryEmployeeSpecialForPage(Integer pagenum, Integer pagesize, String sort, EmployeeSpecial employeeSpecial){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, EmployeeSpecial.class);
		List<EmployeeSpecial> entityList = employeeSpecialMapper.queryEmployeeSpecialForPage(pageBounds, employeeSpecial);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, EmployeeSpecial.class);
		}
		if (!entityList.isEmpty()) {
			PageList<EmployeeSpecial> pagelist = (PageList<EmployeeSpecial>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryEmployeeSpecialByProperty
	 * @Description:根据属性查询员工特殊权限(扩)
	 * @return List<EmployeeSpecial>
	 */
	@Override
	public List<EmployeeSpecial> queryEmployeeSpecialByProperty(Map<String, Object> map){
		return employeeSpecialMapper.queryEmployeeSpecialByProperty(map);
	}


}
