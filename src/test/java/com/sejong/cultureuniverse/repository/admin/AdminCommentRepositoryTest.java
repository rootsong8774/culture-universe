package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.entity.Member;

import com.sejong.cultureuniverse.repository.AdminCommentRepository;
import com.sejong.cultureuniverse.repository.AdminRepository;
import com.sejong.cultureuniverse.repository.MemberRepository;
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
import java.util.stream.LongStream;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.member;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.userPassword;

@SpringBootTest

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

    @Test
    public void readComment(){
        Optional<AdminComment> result = adminCommentRepository.findById(20L);
        AdminComment adminComment = result.get();
        System.out.println(adminComment);
        System.out.println(adminComment.getCommentIdx());
    }


//    userIdx로 adminComment 찾기
    @Test
    public void testUserIdx(){
        List<AdminComment> userIdxList = adminCommentRepository.getAdminCommentByMember_UserIdx(4L);
        userIdxList.forEach(System.out::println);
    }

}
