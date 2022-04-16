package com.sejong.cultureuniverse.repository.admin;

import static com.sejong.cultureuniverse.entity.admin.QAdmin.admin;
import static com.sejong.cultureuniverse.entity.admin.QAdminComment.adminComment;
import static com.sejong.cultureuniverse.entity.admin.QQna.qna;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sejong.cultureuniverse.dto.AdminCommentListDTO;
import com.sejong.cultureuniverse.dto.QAdminCommentListDTO;
import java.util.List;
import javax.persistence.EntityManager;

public class AdminCommentRepositoryImpl implements AdminCommentRepositoryCustom {
    
    private final JPAQueryFactory queryFactory;
    
    public AdminCommentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    
    @Override
    public List<AdminCommentListDTO> getAdminCommentList(Long questionIdx) {
    
        return queryFactory
            .select(new QAdminCommentListDTO(
                adminComment.commentIdx,
                adminComment.commentContent,
                adminComment.regDate,
                adminComment.modDate,
                adminComment.qna.questionIdx,
                adminComment.admin.adminId
            ))
            .from(adminComment)
            .leftJoin(adminComment.admin, admin)
            .leftJoin(adminComment.qna, qna)
            .where(adminComment.qna.questionIdx.eq(questionIdx))
            .fetch();
    }
}
