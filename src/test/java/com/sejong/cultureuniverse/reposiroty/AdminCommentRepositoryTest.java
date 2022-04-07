package com.sejong.cultureuniverse.reposiroty;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.AdminCommentRepository;
import com.sejong.cultureuniverse.repository.QnaBoardRepository;
import com.sejong.cultureuniverse.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootTest
public class AdminCommentRepositoryTest {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminCommentRepository adminCommentRepository;

    @Test
    public void insertComment (){
        IntStream.rangeClosed(1,15).forEach(i->{
            long questionIdx = (long)(Math.random()*20)+1;
            Admin admin = Admin.builder().adminId("관리자1").build();
            Qna qna = Qna.builder().questionIdx(questionIdx).build();
            AdminComment adminComment = AdminComment.builder()
                .commentContent("문의답변"+i)
                .modDate(LocalDateTime.now())
                .regDate(LocalDateTime.now())
                .qna(qna) //questionidx
                .admin(admin) //관리자id
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
        List<Object[]> commentList = adminCommentRepository.getCommentOrderByquestionIdx(18L);
        commentList.forEach(System.out::println);
    }

}
