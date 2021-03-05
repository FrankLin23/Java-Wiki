package com.bobby.wiki.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object Handler)
            throws Exception{
        LOG.info("---------------LogInterceptor开始----------------");
        LOG.info("请求地址：{} {}", httpServletRequest.getRequestURL().toString(), httpServletRequest.getMethod());
        LOG.info("远程地址：{}", httpServletRequest.getRemoteAddr());

        long startTime = System.currentTimeMillis();
        httpServletRequest.setAttribute("requestStartTime", startTime);
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object Handler,
                           ModelAndView modelAndView) throws Exception{
        long startTime = (Long) httpServletRequest.getAttribute("requestStartTime");
        LOG.info("---------------LogInterceptor结束 耗时：{} ms----------------", System.currentTimeMillis() - startTime);
    }
}
