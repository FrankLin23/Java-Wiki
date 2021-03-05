package com.bobby.wiki.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class LogFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        LOG.info("---------------LogFilter开始----------------");
        LOG.info("请求地址：{} {}", httpServletRequest.getRequestURL().toString(), httpServletRequest.getMethod());
        LOG.info("远程地址：{}", httpServletRequest.getRemoteAddr());

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        LOG.info("---------------LogFilter结束 耗时：{} ms----------------", System.currentTimeMillis() - startTime);
    }
}
