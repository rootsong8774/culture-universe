package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.MemberDTO;
import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.entity.Member;
import java.util.Optional;

public interface MemberService {
    
    
    Optional<Member> findByUsername(String username);
    
    Long register(MemberDTO memberDTO);
}
