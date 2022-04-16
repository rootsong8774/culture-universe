package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminCommentRepository extends JpaRepository<AdminComment,Long> {
    //게시물번호로 댓글 가져오기
    @Query("select ac.commentIdx,ac.admin.adminId, ac.commentContent,ac.regDate " +
        " from AdminComment ac " +
        " left join Admin a on ac.admin = a " +
        " left join Qna q on q = ac.qna " +
        " where ac.qna.questionIdx =:questionIdx ")
    List<Object[]> getCommentOrderByQuestionIdx(@Param("questionIdx") Long questionIdx);

}


