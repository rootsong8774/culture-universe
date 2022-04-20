package com.sejong.cultureuniverse.restController;

import com.sejong.cultureuniverse.dto.MemberDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.repository.MemberRepository;
import com.sejong.cultureuniverse.security.provider.JwtTokenProvider;
import com.sejong.cultureuniverse.service.MemberService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String login(@RequestBody MemberDTO memberDTO) {
        Member member = memberRepository.findByUsername(memberDTO.getUsername())
            .orElseThrow(() -> new IllegalArgumentException("아이디나 비밀번호가 잘못 입력되었습니다."));
        if (!passwordEncoder.matches(memberDTO.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("아이디나 비밀번호가 잘못 입력되었습니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRole());
    }
    
    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextHolder.clearContext();
        String accessToken = jwtTokenProvider.resolveToken(request);
        
        
    }
    
}
    

