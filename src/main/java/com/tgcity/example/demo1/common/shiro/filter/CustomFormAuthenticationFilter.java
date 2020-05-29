package com.tgcity.example.demo1.common.shiro.filter;

import com.alibaba.fastjson.JSON;
import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.common.model.response.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义shiro 过滤器， 拦截 authc 权限<br/>
 * 对无权限（相当于没有登录或者会话超时）的返回 401状态码
 */
@Slf4j
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {


    /**
     * @see FormAuthenticationFilter#onAccessDenied(ServletRequest,
     * ServletResponse)
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                return executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                // allow them to see the login page ;)
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the "
                        + "Authentication url [" + getLoginUrl() + "]");
            }
            SecurityUtils.getSubject().logout();
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            response.setContentType("application/json;charset=UTF-8");
            httpServletResponse.setStatus(200);
            BaseResponse success = BaseResponse.buildSuccess(Message.NOT_LOGGED_IN).build();
            httpServletResponse.getWriter().write(JSON.toJSONString(success));


            // saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }

}
