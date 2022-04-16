package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.admin.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminTest {
    @Autowired
    AdminRepository adminRepository;
    @Test
    public void insertAdmin(){
            Admin admin = Admin.builder()
                .adminId("관리자1")
                .adminPw("0000")
                .build();
        adminRepository.save(admin);
    }
}
