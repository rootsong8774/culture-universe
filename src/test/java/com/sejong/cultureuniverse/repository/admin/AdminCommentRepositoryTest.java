package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

@SpringBootTest
@Transactional
public class AdminCommentRepositoryTest {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminCommentRepository adminCommentRepository;
    @Autowired
    QnaBoardRepository qnaBoardRepository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Commit
    public void insertComment (){
        List<Member> result = memberRepository.findAll();
        LongStream.rangeClosed(1,result.size()).forEach(i->{
            long questionIdx = (long)(Math.random()*result.size())+1;
            Optional<Admin> admin =adminRepository.findByAdminIdx(1L);
            Optional<Qna> qna = qnaBoardRepository.findById(questionIdx);
            Optional<Member> member = memberRepository.findById(i);

            AdminComment adminComment = AdminComment.builder()
                .commentContent("문의답변"+i)
                .member(member.get())
                .qna(qna.get()) //questionidx
                .admin(admin.get()) //관리자id
                .regDate(LocalDateTime.now())
                .modDate(LocalDateTime.now())
                .build();
            adminCommentRepository.save(adminComment);
        });
    }
//commentIdx read
    @Test
    public void readComment(){
        Optional<AdminComment> result = adminCommentRepository.findById(6L);
        AdminComment adminComment = result.get();
        System.out.println(adminComment);
        System.out.println(adminComment.getQna());
    }

//questionIdx에 따른 AdminComment
// AdminComment(commentIdx=20, commentContent=문의답변20, regDate=2022-04-11T20:40:30.224110, modDate=2022-04-11T20:40:30.224110)

}
