package com.tgcity.example.demo1.common.filter;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * @author: TGCity
 * @create: 2020/5/25
 * @description 日志拦截类
 */
@Component
public class BaseFilter implements Filter {

    private static Log log = LogFactory.getLog(BaseFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Map<String, Object> map = new HashMap<>();
        // Get request URL
        map.put("URL", req.getRequestURL());
        map.put("Method", req.getMethod());
        map.put("Protocol", req.getProtocol());

        // 获取header信息
        List<Map<String, String>> headerList = new ArrayList<>();
        Map<String, String> headerMaps = new HashMap<>();
        for (Enumeration<String> enu = req.getHeaderNames(); enu.hasMoreElements(); ) {
            String name = enu.nextElement();
            headerMaps.put(name, req.getHeader(name));
        }
        headerList.add(headerMaps);
        map.put("headers", headerList);

        //获取parameters信息
        List<Map<String, String>> parameterList = new ArrayList<>();
        Map<String, String> parameterMaps = new HashMap<>();
        for (Enumeration<String> names = req.getParameterNames(); names.hasMoreElements(); ) {
            String name = names.nextElement();
            parameterMaps.put(name, req.getParameter(name));
        }
        if (parameterMaps.size() > 0){
            parameterList.add(parameterMaps);
            if (parameterList.size() > 0){
                map.put("parameters", parameterList);
            }
        }

        // 获取请求体信息
        String line = "";
        int idx = req.getRequestURL().indexOf("?");
        if (idx != -1) {
            line = req.getRequestURL().substring(idx + 1);
        } else {
            line = null;
        }

        if (line != null) {
            map.put("Context", new String[]{line});
        }

        log.info("接收请求报文：" + JSONObject.toJSONString(map));
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("接收response报文：" + servletResponse.getContentType());
    }

    @Override
    public void destroy() {

    }
}
