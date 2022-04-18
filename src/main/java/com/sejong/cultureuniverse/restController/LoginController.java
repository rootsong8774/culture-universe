package com.sejong.cultureuniverse.restController;

import com.sejong.cultureuniverse.dto.MemberDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.repository.MemberRepository;
import com.sejong.cultureuniverse.service.MemberService;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:8080")
@RestController
@Log4j2
@RequestMapping("/api/")
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    private final MemberService memberService;

    @PostMapping("/register")
    public void registerNew(@RequestBody MemberDTO memberDTO) {
       
        memberService.register(memberDTO);
    }
}
