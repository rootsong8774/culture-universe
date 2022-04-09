package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.AdminCommentRepository;
import com.sejong.cultureuniverse.repository.AdminRepository;
import com.sejong.cultureuniverse.repository.QnaBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest

public class AdminCommentRepositoryTest {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminCommentRepository adminCommentRepository;
    @Autowired
    QnaBoardRepository qnaBoardRepository;

    @Test
    @Commit
    public void insertComment (){
        IntStream.rangeClosed(1,15).forEach(i->{
            long questionIdx = (long)(Math.random()*15)+1;
            Optional<Admin> admin =adminRepository.findByAdminIdx(1L);
            Optional<Qna> qna = qnaBoardRepository.findById(questionIdx);
            AdminComment adminComment = AdminComment.builder()
                .commentContent("문의답변"+i)
                .qna(qna.get()) //questionidx
                .admin(admin.get()) //관리자id
                .build();
            adminCommentRepository.save(adminComment);
        });
    }

    @Test
    public void readComment(){
        Optional<AdminComment> result = adminCommentRepository.findById(20L);
        AdminComment adminComment = result.get();
        System.out.println(adminComment);
        System.out.println(adminComment.getCommentIdx());
    }

    @Test
    public void testListByQnaBoard(){
        List<AdminComment> commentList = adminCommentRepository.getCommentOrderByQuestionIdx(18L);
        commentList.forEach(System.out::println);
    }

}
