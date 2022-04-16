package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.dto.admin.WinnerBoardDTO;
import com.sejong.cultureuniverse.entity.admin.Qna;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QnaBoardRepository extends JpaRepository<Qna, Long> {
    @Query("select q from Qna q left join fetch q.member m where q.questionIdx = :questionIdx")
    Object getQnaBoardWithQuestionIdx(@Param("questionIdx") Long questionIdx);

    @Query(value = "select ac from AdminComment ac left join fetch ac.qna q where q.questionIdx=:questionIdx")
    List<Object[]> getQnaWithComment(@Param("questionIdx") Long questionIdx);

    //질문 + 어드민 번호 +  댓글 갯수 메인 화면 노출 용
    @Query("select q.questionIdx, q.content, q.modDate, q.regDate, q.title, q.type, m.userIdx ,count (ac.commentIdx) " +
        "from Qna q " +
        "left join q.member m left join AdminComment ac on ac.qna = q " +
        "group by q.questionIdx, q.content, q.modDate, q.regDate, q.title, q.type , m.userIdx " +
        "having q.questionIdx = :questionIdx")
    Object getQnaBoardByQuestionIdx(@Param("questionIdx") Long questionIdx);

    @Query(value = "select q.questionIdx, q.content, q.modDate, q.regDate, q.title, q.type, m.userIdx ,count (ac.commentIdx) " +
        "from Qna q " +
        "left join q.member m left join AdminComment ac on ac.qna = q " +
        "group by q.questionIdx, q.content, q.modDate, q.regDate, q.title, q.type , m.userIdx ",
        countQuery = "select count (q) from  Qna q")
    Page<Object[]> getQnaBoardWithCommentCount(Pageable pageable);
}
