package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtService {
    private final String signature = "VUETOKEN";
    private final long expireMin = 30L;

    public String create(MemberDto memberDto) {
        JwtBuilder jwtBuilder = Jwts.builder();

//      Header 설정
        jwtBuilder.setHeaderParam("typ", "JWT");

//      Payload 설정
        jwtBuilder
            .setSubject("loginToken") // 토근 제목
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expireMin)) // 유효기간 30분 설정
            .claim("user", memberDto).claim("greeting", "환영합니다 " + memberDto.getUsername() + "님"); // 담고싶은 내용

//      signature 설정
        jwtBuilder.signWith(SignatureAlgorithm.HS256, signature.getBytes());

//      Serialization
        String jwt = jwtBuilder.compact();

        return jwt;
    }

//  jwt 토큰 분석
    public Map<String, Object> get(String jwt) throws ExpiredJwtException {
        Jws<Claims> claims = null;

        try {
            claims = Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
        } catch (ExpiredJwtException e){
            throw e;
        }

        return claims.getBody();
    }

//  전달받은 토큰 제대로 된 것인가 확인
    public void checkValid(String jwt) throws ExpiredJwtException {
        try {
            Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
        } catch(ExpiredJwtException e){
            throw e;
        }
    }
}
