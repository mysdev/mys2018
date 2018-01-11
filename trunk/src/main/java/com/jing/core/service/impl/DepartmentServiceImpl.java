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


import com.jing.core.model.entity.Department;
import com.jing.core.model.dao.DepartmentMapper;
import com.jing.core.service.DepartmentService;

/**
 * @ClassName: Department
 * @Description: 部门服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("departmentService")
@Transactional(readOnly=true)
public class  DepartmentServiceImpl implements DepartmentService {	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	
	@Autowired
    private DepartmentMapper departmentMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addDepartment
	 * @Description:添加部门
	 * @param department 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Department addDepartment(Department department){
		int ret = departmentMapper.addDepartment(department);
		if(ret>0){
			return department;
		}
		return null;
	}
	
	/**
	 * @Title modifyDepartment
	 * @Description:修改部门
	 * @param department 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyDepartment(Department department){
		return departmentMapper.modifyDepartment(department);
	}
	
	/**
	 * @Title: dropDepartmentByDptId
	 * @Description:删除部门
	 * @param dptId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropDepartmentByDptId(Integer dptId){
		return departmentMapper.dropDepartmentByDptId(dptId);
	}
	
	/**
	 * @Title: queryDepartmentByDptId
	 * @Description:根据实体标识查询部门
	 * @param dptId 实体标识
	 * @return Department
	 */
	@Override
	public Department queryDepartmentByDptId(Integer dptId){
		return departmentMapper.queryDepartmentByDptId(dptId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryDepartmentForPage
	 * @Description: 根据部门属性与分页信息分页查询部门信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param department 实体
	 * @return List<Department>
	 */
	@Override
	public Map<String, Object> queryDepartmentForPage(Integer pagenum, Integer pagesize, String sort, Department department){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Department.class);
		List<Department> entityList = departmentMapper.queryDepartmentForPage(pageBounds, department);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Department.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Department> pagelist = (PageList<Department>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryDepartmentByProperty
	 * @Description:根据属性查询部门
	 * @return List<Department>
	 */
	@Override
	public List<Department> queryDepartmentByProperty(Map<String, Object> map){
		return departmentMapper.queryDepartmentByProperty(map);
	}


}
