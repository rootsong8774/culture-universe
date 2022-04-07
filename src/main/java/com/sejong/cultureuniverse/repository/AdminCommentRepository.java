package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.admin.AdminComment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminCommentRepository extends JpaRepository<AdminComment,Long> {
//게시물로 댓글 가져오기
    @Query("select ac,a,q from AdminComment ac " +
        " left join fetch Admin a on ac.admin = a left join fetch Qna q on q = ac.qna " +
        " where ac.qna.questionIdx =:questionIdx " )
    List<Object[]> getCommentOrderByQuestionIdx(@Param("questionIdx") Long questionIdx);

}
