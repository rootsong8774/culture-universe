package com.sejong.cultureuniverse.service;

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
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitDB {
    
    private final InitService initService;
    private final FeignController feignController;
 
    
    
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
        
        
        
        public void insertAdmin() {
            Admin admin = Admin.builder()
                .adminId("관리자1")
                .adminPw("0000")
                .build();
            adminRepository.save(admin);
        }
        
        
        public void insertMembers() {
            IntStream.rangeClosed(21, 30).forEach(i -> {
                Member member = Member.builder()
                    .username("회원id" + i)
                    .pw("1111")
                    .name("회원이름" + i)
                    .email("email" + i + "@email.com")
                    .phoneNum("010-" + i + "-1234")
                    .build();
                memberRepository.save(member);
            });
        }
        
        
        public void insertQnaBoard() {
            List<Member> result = memberRepository.findAll();
            LongStream.rangeClosed(1, result.size()).forEach(i -> {
                Optional<Member> member = memberRepository.findById(i);
                Qna qna = Qna.builder()
                    .title("연극문의test" + i)
                    .type("문의유형" + i)
                    .content("질문입니다" + i)
                    .regDate(LocalDateTime.now())
                    .modDate(LocalDateTime.now())
                    .member(member.get())
                    .build();
                System.out.println(qnaBoardRepository.save(qna));
            });
        }
        
        
        public void insertComment() {
            List<Member> result = memberRepository.findAll();
            LongStream.rangeClosed(1, result.size()).forEach(i -> {
                long questionIdx = (long) (Math.random() * result.size()) + 1;
                Optional<Admin> admin = adminRepository.findByAdminIdx(1L);
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
        
        
        public void insertNoticeBoardDummies() {
            IntStream.rangeClosed(1, 100).forEach(i -> {
                NoticeBoard noticeBoard = NoticeBoard.builder()
                    .noticeContent("test content" + i)
                    .noticeTitle("test title" + i)
                    .readCount(100L)
                    .admin(new Admin("admin" + i, "1234"))
                    .build();
                System.out.println(noticeBoardRepository.save(noticeBoard));
            });
        }
        
        
        public void insertEventBoardDummies() {
            IntStream.rangeClosed(1, 100).forEach(i -> {
                EventBoard eventBoard = EventBoard.builder()
                    .eventContent("test content" + i)
                    .eventTitle("test title" + i)
                    .readCount(100L)
                    .adminId(new Admin("admin" + i, "1234"))
                    .build();
                System.out.println(eventBoardRepository.save(eventBoard));
            });
        }
        
        
        public void insertWinnerDummies() {
            IntStream.rangeClosed(1, 100).forEach(i -> {
                EventWinner eventWinner = EventWinner.builder()
                    .winContent("test content" + i)
                    .winTitle("test title" + i)
                    .readCount(100L)
                    .adminId(new Admin("admin" + i, "1234"))
                    .build();
                System.out.println(winnerBoardRepository.save(eventWinner));
            });
        }
        
        
    }
}
