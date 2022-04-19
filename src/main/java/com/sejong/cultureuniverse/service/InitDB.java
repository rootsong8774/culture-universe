package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.admin.AdminDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.entity.event.EventWinner;
import com.sejong.cultureuniverse.repository.admin.AdminCommentRepository;
import com.sejong.cultureuniverse.repository.admin.AdminRepository;
import com.sejong.cultureuniverse.repository.event.EventBoardRepository;
import com.sejong.cultureuniverse.repository.MemberRepository;
import com.sejong.cultureuniverse.repository.admin.NoticeBoardRepository;
import com.sejong.cultureuniverse.repository.admin.QnaBoardRepository;
import com.sejong.cultureuniverse.repository.event.WinnerBoardRepository;
import com.sejong.cultureuniverse.restController.performances.FeignController;
import com.sejong.cultureuniverse.service.admin.AdminService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitDB {
    
    private final InitService initService;
 
    
    
//    @PostConstruct
    public void init() throws IOException {
        initService.insertAdmin();
        initService.insertMembers();
        initService.insertQnaBoard();
        initService.insertComment();
        initService.insertNoticeBoardDummies();
        initService.insertEventBoardDummies();
        initService.insertWinnerDummies();
    }
    
    
    @Component
    @RequiredArgsConstructor
    static class InitService {
        
        private final AdminRepository adminRepository;
        private final MemberRepository memberRepository;
        private final QnaBoardRepository qnaBoardRepository;
        private final AdminCommentRepository adminCommentRepository;
        
        private final NoticeBoardRepository noticeBoardRepository;
        private final WinnerBoardRepository winnerBoardRepository;
        private final EventBoardRepository eventBoardRepository;
        private final AdminService adminService;
        
        
        
        public void insertAdmin() {
            AdminDTO adminDTO = AdminDTO.builder()
                .adminId("admin1234")
                .adminPw("11111111")
                .role("ROLE_ADMIN")
                .build();
            adminService.register(adminDTO);
        }
        
        
        public void insertMembers() {
            IntStream.rangeClosed(1, 30).forEach(i -> {
                Member member = Member.builder()
                    .username("username" + i)
                    .password("11111111")
                    .name("회원이름" + i)
                    .role("ROLE_USER")
                    .build();
                memberRepository.save(member);
            });
        }
        
        
        public void insertQnaBoard() {
            List<Member> result = memberRepository.findAll();
            LongStream.rangeClosed(1, result.size()).forEach(i -> {
                Member member = memberRepository.getById(i);
                Qna qna = Qna.builder()
                    .title("연극문의test" + i)
                    .type("문의유형" + i)
                    .content("질문입니다" + i)
                    .member(member)
                    .build();
               qnaBoardRepository.save(qna);
            });
        }
        
        
        public void insertComment() {
            List<Member> memberResult = memberRepository.findAll();
            List<Qna> qnaResult = qnaBoardRepository.findAll();
    
            LongStream.rangeClosed(1, 3*(qnaResult.size())).forEach(i -> {
                long questionIdx = (long) (Math.random() * qnaResult.size()) + 1;
                long memberIdx = (long) (Math.random() * memberResult.size()) + 1;
                Admin admin = adminRepository.getById(1L);
                Qna qna = qnaBoardRepository.getById(questionIdx);
                Member member = memberRepository.getById(memberIdx);
    
                AdminComment adminComment = AdminComment.builder()
                    .commentContent("문의답변" + i)
                    .member(member)
                    .qna(qna) //questionidx
                    .admin(admin) //관리자id
                    .build();
                adminCommentRepository.save(adminComment);
            });
        }
        
        
        public void insertNoticeBoardDummies() {
            IntStream.rangeClosed(1, 100).forEach(i -> {
                NoticeBoard noticeBoard = NoticeBoard.builder()
                    .noticeContent("test content" + i)
                    .noticeTitle("test title" + i)
                    .readCount(0L)
                    .admin(adminRepository.getById(1L))
                    .build();
                System.out.println(noticeBoardRepository.save(noticeBoard));
            });
        }
        
        
        public void insertEventBoardDummies() {
            IntStream.rangeClosed(1, 100).forEach(i -> {
                EventBoard eventBoard = EventBoard.builder()
                    .eventContent("test content" + i)
                    .eventTitle("test title" + i)
                    .readCount(0L)
                    .admin(adminRepository.getById(1L))
                    .build();
                System.out.println(eventBoardRepository.save(eventBoard));
            });
        }
        
        
        public void insertWinnerDummies() {
            IntStream.rangeClosed(1, 100).forEach(i -> {
                EventWinner eventWinner = EventWinner.builder()
                    .winContent("test content" + i)
                    .winTitle("test title" + i)
                    .readCount(0L)
                    .admin(adminRepository.getById(1L))
                    .build();
                System.out.println(winnerBoardRepository.save(eventWinner));
            });
        }
        
        
    }
}
