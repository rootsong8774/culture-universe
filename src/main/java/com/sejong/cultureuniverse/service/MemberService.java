package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.MemberDTO;
import com.sejong.cultureuniverse.dto.QnaBoardDTO;

public interface MemberService {
    
    Long register(MemberDTO memberDTO);
}
