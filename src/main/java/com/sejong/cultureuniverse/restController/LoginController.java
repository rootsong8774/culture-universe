package com.sejong.cultureuniverse.restController;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.repository.MemberRepository;
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
    private final MemberRepository memberRepository;

    @PostMapping("/register")
    public void registerNew(@RequestBody HashMap<String, String> map) {
        HashMap<String, String> rtnMap = new HashMap<>();

        rtnMap.put("username", map.get("username"));
        rtnMap.put("name", map.get("name"));
        rtnMap.put("pw", map.get("pw"));
        rtnMap.put("email", map.get("email"));
        rtnMap.put("phoneNum", map.get("phoneNum"));

        Member member = Member.builder()
            .username(rtnMap.get("username"))
            .name(rtnMap.get("name"))
            .pw(rtnMap.get("pw"))
            .email(rtnMap.get("email"))
            .phoneNum(rtnMap.get("phoneNum"))
            .build();
        memberRepository.save(member);
    }
}
