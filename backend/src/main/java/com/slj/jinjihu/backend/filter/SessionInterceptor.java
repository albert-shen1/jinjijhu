package com.slj.jinjihu.backend.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      /*  String token = request.getHeader("Authorization");
        if(StringUtils.isNotBlank(token)){
            System.out.printf(token);
        }
        return true;*/
        /*String token = request.getHeader("Authorization");
        if(StringUtils.isBlank(token)){
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "登录令牌无效，请重新登录");
            return false;
        }*/
        String token = request.getHeader("Authorization");
        System.out.println(token);
        return true;
    }
}
