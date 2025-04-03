package com.kksleepy.interceptor;

import com.kksleepy.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token == null || token.isEmpty()) {
            log.info("token为空，拦截请求");
            response.setStatus(401);
            return false;
        }
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("token非法，拦截请求");
            response.setStatus(401);
            return true;
        }
        log.info("token合法，放行");
        return true;
    }
}
