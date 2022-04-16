package com.sejong.cultureuniverse.service.admin;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.AdminCommentRepository;
import com.sejong.cultureuniverse.repository.AdminRepository;
import com.sejong.cultureuniverse.repository.MemberRepository;
import com.sejong.cultureuniverse.repository.QnaBoardRepository;
import com.sejong.cultureuniverse.service.AdminCommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

@SpringBootTest
public class AdminCommentServiceTest {

    @Autowired
    AdminCommentService adminCommentService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminCommentRepository adminCommentRepository;
    @Autowired
    QnaBoardRepository qnaBoardRepository;

    @Test
    @Commit
    public void insertComment() {
        List<Member> result = memberRepository.findAll();
        LongStream.rangeClosed(1, result.size()).forEach(i -> {
            long questionIdx = (long) (Math.random() * result.size()) + 1;
            Optional<Admin> admin = adminRepository.findByAdminIdx(i);
            Optional<Qna> qna = qnaBoardRepository.findById(questionIdx);
            Optional<Member> member = memberRepository.findById(i);

            AdminComment adminComment = AdminComment.builder()
                .commentContent("문의답변" + i)
                .member(member.get())
                .qna(qna.get()) //questionidx
                .admin(admin.get()) //관리자id
                .regDate(LocalDateTime.now())
                .modDate(LocalDateTime.now())
                .build();
            adminCommentRepository.save(adminComment);
        });
    }

    //questionIdx 조회시 나오는 AdminCommentDTO
    @Test
    @Transactional
    public void getListComment() {
        Long questionIdx = 21L;
        List<AdminCommentDTO> result = adminCommentService.getList(questionIdx);
       result.forEach(System.out::println);
    }

//    @Test
//    public void getMemberUserIdx() {
//        Long userIdx = 3L;
//        List<AdminComment> userIdxDTOList = adminCommentService.getList(userIdx);
//        for (AdminComment adminComment : userIdxDTOList) {
//            System.out.println("adminComment.toString() = " + adminComment.toString());
//        }
//    }
}
