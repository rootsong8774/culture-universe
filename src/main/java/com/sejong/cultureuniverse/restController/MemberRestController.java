package com.sejong.cultureuniverse.restController;

import com.sejong.cultureuniverse.dto.MemberDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.repository.MemberRepository;
import com.sejong.cultureuniverse.security.provider.JwtTokenProvider;
import com.sejong.cultureuniverse.service.MemberService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@Log4j2
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberRestController {
    
    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    
    
    @PostMapping("/register")
    public void registerNew(@RequestBody MemberDTO memberDTO) {
        
        memberService.register(memberDTO);
    }
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDTO memberDTO, HttpServletResponse res) {
        
        Map<String, Object> resultMap = new ConcurrentHashMap<>();
        HttpStatus status = null;
    
        Member member = null;
        try {
            member = memberService.login(memberDTO);
            String token = jwtTokenProvider.createToken(member.getUsername(), member.getRole());
            res.setHeader("jwt-auth-token", token);
            resultMap.put("status", true);
            resultMap.put("data", member);
            status = HttpStatus.ACCEPTED;
        } catch (RuntimeException e) {
           log.error("로그인 실패", e);
           resultMap.put("message", e.getMessage());
           status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
    
        return new ResponseEntity<>(resultMap, status);
    }
    
    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        
        SecurityContextHolder.clearContext();
        String accessToken = jwtTokenProvider.resolveToken(request);
        
        
    }
    
}
    

