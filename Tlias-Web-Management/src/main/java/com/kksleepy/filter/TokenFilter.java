package com.kksleepy.filter;

import com.kksleepy.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter("/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        if(requestURI.contains("/login")) {
            log.info("登陆请求，放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String token = request.getHeader("token");
        if(token == null || token.isEmpty()) {
            log.info("token为空，拦截请求");
            response.setStatus(401);
            return;
        }
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("token非法，拦截请求");
            response.setStatus(401);
            return;
        }
        log.info("token合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
