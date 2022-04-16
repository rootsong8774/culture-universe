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
        Object result = qnaBoardRepository.getQnaByMember(10L);
        Object[]arr = (Object[])result;
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testReadWithAdminComment(){
        List<Object[]> qnaWithComment = qnaBoardRepository.getQnaWithComment(18L);
        for (Object[] objects : qnaWithComment) {
            System.out.println("Arrays.toString(objects) = " + Arrays.toString(objects));
        }
    }

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
