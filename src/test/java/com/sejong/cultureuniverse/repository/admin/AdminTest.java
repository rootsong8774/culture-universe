package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.repository.AdminRepository;
import com.sejong.cultureuniverse.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest
public class AdminTest {
    @Autowired
    AdminRepository adminRepository;
    @Test
    @DisplayName("관리자 추가")
    public void insertAdmin(){
            Admin admin = Admin.builder()
                .adminId("관리자1")
                .adminPw("0000")
                .build();
        adminRepository.save(admin);
    }
}
