package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class AdminCommentServiceTest {

    @Autowired
    AdminCommentService adminCommentService;

    @Test
    public void getListComment() {
        Long questionIdx = 18L;
        List<Object[]> adminCommentDTOList = adminCommentService.getList(questionIdx);
        adminCommentDTOList.forEach(i -> {
            System.out.println(Arrays.toString(i));
        });

    }
}
