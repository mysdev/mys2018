package com.jing.config.web.page;

import javax.servlet.http.HttpServletRequest;

public class PageBeanFactory {
    public PageBeanFactory() {

    }

    public static PageInfo createPageBean(HttpServletRequest request) {
        PageInfo pageBean = new PageInfo();
        if (request.getParameter(PageUtil.sortName) != null
                && !"".equals(request.getParameter(PageUtil.sortName).trim())) {
            pageBean.setSortName(request.getParameter(PageUtil.sortName));
        }

        if (request.getParameter(PageUtil.orderName) != null
                && !"".equals(request.getParameter(PageUtil.orderName).trim())) {
            pageBean.setOrderName((String) request.getParameter(PageUtil.orderName).trim());
        }

        if (request.getParameter(PageUtil.currentPage) != null) {
            pageBean.setPageNumber(Integer.valueOf((String) request.getParameter(PageUtil.currentPage).trim())
                    .intValue());
        }
        if (request.getParameter(PageUtil.pageSize) != null) {
            pageBean.setPageSize(Integer.valueOf((String) request.getParameter(PageUtil.pageSize).trim()).intValue());
        }
        pageBean.setCurrentResultIndex((pageBean.getCurrentPage() - 1) * pageBean.getPageSize());

        return pageBean;
    }
}
