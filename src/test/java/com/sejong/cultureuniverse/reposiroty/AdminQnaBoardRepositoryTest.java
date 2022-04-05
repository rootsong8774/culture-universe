package com.sejong.cultureuniverse.reposiroty;

import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.AdminQnaBoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootTest
public class AdminQnaBoardRepositoryTest {

    @Autowired
    private AdminQnaBoardRepository adminQnaBoardRepository;

    @Test
    @DisplayName("qna 질문 삽입")
    public void insertDunmmies() {
        IntStream.rangeClosed(1, 50).forEach(i -> {
            Qna qna = Qna.builder()
                .questionIdx((long) i)
                .title("연극문의test" + i)
                .type("문의test" + i)
                .content("질문입니다" + i)
                .regDate(LocalDateTime.now())
                .modDate(LocalDateTime.now())
                .build();
            System.out.println(adminQnaBoardRepository.save(qna));
        });
    }
}
