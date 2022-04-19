package com.sejong.cultureuniverse.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.security.service.MemberContext;
import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    
    // /login 요청을 하면 로그인 시도를 위해서 실행된다.
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
        HttpServletResponse response) throws AuthenticationException {
    
        //1. username, password 받기
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Member member = objectMapper.readValue(request.getInputStream(), Member.class);
    
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                member.getUsername(), member.getPassword());
    
            //CustomMemberDetailsService 의 loadUserByUsername()함수가 실행됨.
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
    
            MemberContext memberContext = (MemberContext) authentication.getPrincipal();
            log.info(memberContext.getMember().getUsername());
    
            return authentication;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    
        
        return null;
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
        HttpServletResponse response, FilterChain chain, Authentication authResult) {
        System.out.println("successfulAuthentication 실행됨.");
        MemberContext memberContext = (MemberContext) authResult.getPrincipal();
    
        String jwtToken = JWT.create()
            .withSubject(memberContext.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + (60000*10)))
            .withClaim("idx", memberContext.getMember().getUserIdx())
            .withClaim("username", memberContext.getMember().getUsername())
            .sign(Algorithm.HMAC512("culture-universe"));
        
        response.addHeader("Authorization","Bearer "+jwtToken);
    }
}
