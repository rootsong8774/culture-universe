package com.sejong.cultureuniverse.reposiroty;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MeberRepositotyTest{
@Autowired
    MemberRepository memberRepository;
    @Test
    @DisplayName("회원 명단 추가")
    public void insertMembers(){
        IntStream.range(1,20).forEach(i->{
            Member member = Member.builder()
                .username("회원id"+i)
                .pw("1111")
                .name("회원이름"+i)
                .email("email"+i+"email.com")
                .phoneNum("010-"+i+"-1234")
                .build();
            memberRepository.save(member);
        });
    }
}
