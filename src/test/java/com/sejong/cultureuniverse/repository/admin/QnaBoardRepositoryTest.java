package com.sejong.cultureuniverse.repository.admin;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

@SpringBootTest
@Transactional
public class QnaBoardRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private QnaBoardRepository qnaBoardRepository;

    @Test
    @Commit
    @DisplayName("qna 질문 삽입")
    public void insertQnaBoard() {
        List<Member> result = memberRepository.findAll();
        LongStream.rangeClosed(1, result.size()).forEach(i -> {
            Optional<Member>  member = memberRepository.findById(i);
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

    //qnaboard read
    @Test
    public void testRead(){
        Optional<Qna> result = qnaBoardRepository.findById(11L);
        Qna qna = result.get();
        System.out.println(qna);
        System.out.println(qna.getQuestionIdx());
    }

    //쿼리 1 : member +qna 정보
    @Test
    public void testReadWithQuestionIdx(){
        Object result = qnaBoardRepository.getQnaBoardWithQuestionIdx(10L);
        Object[]arr = (Object[])result;
        System.out.println(Arrays.toString(arr));
    }
//쿼리 2 qna+comment 정보
//[Qna(questionIdx=18, title=연극문의test18, type=문의유형18, content=질문입니다18,
// regDate=2022-04-11T20:38:15.825553, modDate=2022-04-11T20:38:15.825553),
// AdminComment(commentIdx=2, commentContent=문의답변2, regDate=2022-04-11T20:40:29.442273,
// modDate=2022-04-11T20:40:29.442273)]
    @Test
    public void testReadWithAdminComment(){
        List<Object[]> qnaWithComment = qnaBoardRepository.getQnaWithComment(18L);
        for (Object[] objects : qnaWithComment) {
            System.out.println("Arrays.toString(objects) = " + Arrays.toString(objects));
        }
    }
    //4번
    //[Member(userIdx=20, username=회원id20, pw=1111, name=홍길동20, email=email20@email.com,
// profilePic=null, phoneNum=010-20-1234, signDate=null),
// Qna(questionIdx=20, title=연극문의test20, type=문의유형20, content=질문입니다20,
// regDate=2022-04-11T20:38:15.836523, modDate=2022-04-11T20:38:15.836523),
// AdminComment(commentIdx=20, commentContent=문의답변20, regDate=2022-04-11T20:40:30.224110,
// modDate=2022-04-11T20:40:30.224110)]
//member+qna+admincommentList

//5번 메인 화면 노출 용
    //10번에 대한 질문 + 어드민 번호 +  댓글 갯수
    // [10, 질문입니다10, 2022-04-11T20:38:15.758731, 2022-04-11T20:38:15.758731,
    // 연극문의test10, 문의유형10, 10, 1]
    @Test
    public void testWithComment3(){
        Object result = qnaBoardRepository.getQnaBoardByQuestionIdx(10L);
        Object[] arr = (Object[]) result;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    //쿼리 5 페이지
    @Test
    public void testWithCommentCount() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("questionIdx").descending());
        Page<Object[]> result = qnaBoardRepository.getQnaBoardWithCommentCount(pageable);
        result.get().forEach(row->{
            Object[] arr =(Object[])row;
            System.out.println(Arrays.toString(arr));
        });
    }
}
