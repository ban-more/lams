package com.thinkgem.jeesite.common.filter;

import com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;

public class MyLogoutFilter extends AdviceFilter {

    private Cache<String, Deque<Serializable>> cache;
    private SessionManager sessionManager;
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-kickout-session");
    }
    public MyLogoutFilter() {
    } private static final Logger log = LoggerFactory.getLogger(LogoutFilter.class);
    public static final String DEFAULT_REDIRECT_URL = "/";
    private String redirectUrl = "/";

    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = this.getSubject(request, response);
        String redirectUrl = this.getRedirectUrl(request, response, subject);
        Session session = subject.getSession();
        SystemAuthorizingRealm.Principal principal= (SystemAuthorizingRealm.Principal) subject.getPrincipal();
//        String username = (String) subject.getPrincipal();
        String username = principal.getName();
        Deque<Serializable> deque = cache.get(username);
        try {
            subject.logout();
            deque.removeLast();
        } catch (SessionException var6) {
            log.debug("Encountered session exception during logout.  This can generally safely be ignored.", var6);
        }

        this.issueRedirect(request, response, redirectUrl);
        return false;
    }

    protected Subject getSubject(ServletRequest request, ServletResponse response) {
        return SecurityUtils.getSubject();
    }

    protected void issueRedirect(ServletRequest request, ServletResponse response, String redirectUrl) throws Exception {
        WebUtils.issueRedirect(request, response, redirectUrl);
    }

    protected String getRedirectUrl(ServletRequest request, ServletResponse response, Subject subject) {
        return this.getRedirectUrl();
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }


}
