package com.sejong.cultureuniverse.security;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberTest {
//    @Autowired
//    private MemberRepository memberRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Test //테스트 성공
//    public void insertDummies(){
//        IntStream.range(1,50).forEach(i->{
//            Member member = Member.builder()
//                .username("홍길동"+i)
//                .name("gildong"+i)
//                .pw(passwordEncoder.encode("1111"))
//                .email("hkd"+i+"@test.co.kr")
//                .phoneNum("010-1111-1111")
//                .build();
//            memberRepository.save(member);
//        });
//    }
//    @Test
//    public void testRead(){
//        Optional<Member> result = memberRepository.findByEmail("hkd45@test.co.kr");
//        Member member = result.get();
//        System.out.println(member);
//    }
}
