package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.MemberDTO;
import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
    
    @Override
    public Long register(MemberDTO memberDTO) {
    
        Member member = Member.builder()
            .name(memberDTO.getName())
            .password(passwordEncoder.encode(memberDTO.getPassword()))
            .role("ROLE_USER")
            .username(memberDTO.getUsername())
            .build();
        
        memberRepository.save(member);
        
        return member.getUserIdx();
    
    }
    
    @Override
    public Member login(MemberDTO memberDTO) {
        Optional<Member> findMember = memberRepository.findByUsername(memberDTO.getUsername());
        if (findMember.isEmpty()) {
            throw new IllegalArgumentException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
        Member member = findMember.get();
        if (!passwordEncoder.matches(memberDTO.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("아이디 혹은 비밀번호가 잘못 되었습니다.");
        }
        
        return member;
    }
}
