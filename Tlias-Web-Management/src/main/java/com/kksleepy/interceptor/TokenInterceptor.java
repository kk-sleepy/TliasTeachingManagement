package com.kksleepy.interceptor;

import com.kksleepy.utils.CurrentHolder;
import com.kksleepy.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
           Claims claims = JwtUtils.parseToken(token);
           Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("当前用户id为：{}", empId);
        } catch (Exception e) {
            log.info("token非法，拦截请求");
            response.setStatus(401);
            return true;
        }
        log.info("token合法，放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        CurrentHolder.remove();
        log.info("请求结束，清除当前用户id");
    }
}
