package com.jing.config.web.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class PermissionSecurityFilter extends AbstractSecurityInterceptor implements Filter {
	
	public PermissionSecurityFilter() {
		// TODO Auto-generated constructor stub
	}
    // ~ Static fields/initializers
    // =====================================================================================

    private static final String FILTER_APPLIED = "__spring_security_filterSecurityInterceptor_filterApplied";

    // ~ Instance fields
    // ================================================================================================

    private FilterInvocationSecurityMetadataSource securityMetadataSource;
    private boolean observeOncePerRequest = true;
    private String defaultURL;//无指定访问地址时跳转的地址
    private String errorPage;//错误页面地址
    private String logoutURL;//错误页面地址

    // ~ Methods
    // ========================================================================================================

    /**
     * Not used (we rely on IoC container lifecycle services instead)
     * 
     * @param arg0
     *            ignored
     * 
     * @throws ServletException
     *             never thrown
     */
    public void init(FilterConfig arg0) throws ServletException {
    }

    /**
     * Not used (we rely on IoC container lifecycle services instead)
     */
    public void destroy() {
    }

    /**
     * Method that is actually called by the filter chain. Simply delegates to
     * the {@link #invoke(FilterInvocation)} method.
     * 
     * @param request
     *            the servlet request
     * @param response
     *            the servlet response
     * @param chain
     *            the filter chain
     * 
     * @throws IOException
     *             if the filter chain fails
     * @throws ServletException
     *             if the filter chain fails
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        invoke(new FilterInvocation(request, response, chain));
    }

    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource newSource) {
        this.securityMetadataSource = newSource;
    }

    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    public void invoke(FilterInvocation fi) throws IOException, ServletException {
        if (fi.getRequest().getRequestURI().endsWith("/")) {
            RequestDispatcher rd = fi.getRequest().getRequestDispatcher(defaultURL);
            rd.forward(fi.getRequest(), fi.getResponse());
            return;
        }

        if ((fi.getRequest() != null) && (fi.getRequest().getAttribute(FILTER_APPLIED) != null)
                && observeOncePerRequest) {
            // filter already applied to this request and user wants us to
            // observe
            // once-per-request handling, so don't re-do security checking
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } else {
            // first time this request being called, so perform security
            // checking
            if (fi.getRequest() != null) {
                fi.getRequest().setAttribute(FILTER_APPLIED, Boolean.TRUE);
                if (fi.getRequest().getSession().getAttribute(PermissionConstants.SPRING_SECURITY_CONTEXT) != null) {
                    SecurityContextHolder.getContext().setAuthentication(
                            ((SecurityContext) fi.getRequest().getSession().getAttribute(
                                    PermissionConstants.SPRING_SECURITY_CONTEXT)).getAuthentication());
                }
            }

            InterceptorStatusToken token = null;
            try {
                token = super.beforeInvocation(fi);
            } catch (Exception e) {
                String userName = "";
                if (fi.getRequest() != null
                        && fi.getRequest().getSession() != null
                        && fi.getRequest().getSession().getAttribute(PermissionConstants.SPRING_SECURITY_CONTEXT) != null) {
                    Authentication authentication = ((SecurityContext) fi.getRequest().getSession().getAttribute(
                            PermissionConstants.SPRING_SECURITY_CONTEXT)).getAuthentication();
                    if (authentication.getPrincipal() != null) {
                        UserDetail user = (UserDetail) authentication.getPrincipal();
                        if (user != null) {
                            userName = user.getUsername();
                        }
                    }

                }
                super.logger.error(userName + "权限验证出错!", e);
                fi.getRequest().setAttribute("message", "不具有该操作权限，请联系管理员" + e.getMessage());
                RequestDispatcher rd = null;
                if (fi.getRequest().getRequestURI().toString().equals(fi.getRequest().getContextPath() + defaultURL)) {
                    rd = fi.getRequest().getRequestDispatcher(logoutURL);
                } else {
                    rd = fi.getRequest().getRequestDispatcher(errorPage);
                }
                rd.forward(fi.getRequest(), fi.getResponse());
                return;
            }

            try {
                fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
            } finally {
                super.finallyInvocation(token);
            }

            super.afterInvocation(token, null);
        }
    }

    /**
     * Indicates whether once-per-request handling will be observed. By default
     * this is <code>true</code>, meaning the
     * <code>FilterSecurityInterceptor</code> will only execute
     * once-per-request. Sometimes users may wish it to execute more than once
     * per request, such as when JSP forwards are being used and filter security
     * is desired on each included fragment of the HTTP request.
     * 
     * @return <code>true</code> (the default) if once-per-request is
     *         honoured, otherwise <code>false</code> if
     *         <code>FilterSecurityInterceptor</code> will enforce
     *         authorizations for each and every fragment of the HTTP request.
     */
    public boolean isObserveOncePerRequest() {
        return observeOncePerRequest;
    }

    public String getDefaultURL() {
        return defaultURL;
    }

    public void setDefaultURL(String defaultURL) {
        this.defaultURL = defaultURL;
    }

    public String getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }

    /**
     * @return the logoutURL
     */
    public String getLogoutURL() {
        return logoutURL;
    }

    /**
     * @param logoutURL the logoutURL to set
     */
    public void setLogoutURL(String logoutURL) {
        this.logoutURL = logoutURL;
    }
}