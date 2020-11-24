package com.ssafy.happyhouse.interceptor;

import com.ssafy.happyhouse.service.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS"))
            return true;

        String token = request.getHeader("auth-token");

        if(token != null && token.length() > 0){
            try {
                jwtService.checkValid(token);
            } catch(ExpiredJwtException e){
                return false;
            }
            return true;
        } else {
            throw new RuntimeException("인증 토큰이 없습니다");
        }
    }
}
