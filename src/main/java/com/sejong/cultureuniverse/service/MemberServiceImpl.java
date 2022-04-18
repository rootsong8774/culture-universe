package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.MemberDTO;
import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    
    private final MemberRepository memberRepository;
    
    @Override
    public Long register(MemberDTO memberDTO) {
    
        Member member = Member.builder()
            .name(memberDTO.getName())
            .password(memberDTO.getPassword())
            .role("ROLE_USER")
            .username(memberDTO.getUsername())
            .build();
        
        memberRepository.save(member);
        
        return member.getUserIdx();
    
    }
}
