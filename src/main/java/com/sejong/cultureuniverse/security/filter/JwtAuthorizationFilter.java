package com.sejong.cultureuniverse.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.repository.MemberRepository;
import com.sejong.cultureuniverse.security.service.MemberContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

//권한이나 인증이 필요한 특정 주소를 요청했을 때 BasicAuthenticationFilter 를 거치게 되는데 권한이나 인증이 요구되지 않는 주소라면 이 필터를 거치지 않는다
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    
    private final MemberRepository memberRepository;
    
    public JwtAuthorizationFilter(
        AuthenticationManager authenticationManager, MemberRepository memberRepository) {
        super(authenticationManager);
        this.memberRepository = memberRepository;
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        
        String jwtHeader = request.getHeader("Authorization");
        
        //header가 있는지 확인
        if (jwtHeader == null || !jwtHeader.startsWith("Bearer")) {
            chain.doFilter(request, response);
            return;
        }
        
        String jwtToken = request.getHeader("Authorization").replace("Bearer ", "");
        
        String username = JWT.require(Algorithm.HMAC512("culture-universe")).build()
            .verify(jwtToken).getClaim("username").asString();
    
        if (username != null) {
            Optional<Member> findMember = memberRepository.findByUsername(username);
    
            if (findMember.isEmpty()) {
                chain.doFilter(request, response);
                return;
            }
    
            Member member = findMember.get();
    
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(member.getRole()));
            
    
            MemberContext memberContext = new MemberContext(member, roles);
            
            //Jwt 토큰 서명을 통해서 서명이 정상이면 Authentication 객체를 만들어 준다.
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                memberContext, null, memberContext.getAuthorities());
    
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            chain.doFilter(request,response);
    
        }
    }
}
