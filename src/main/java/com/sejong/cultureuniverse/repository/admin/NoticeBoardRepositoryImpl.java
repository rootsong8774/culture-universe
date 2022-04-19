package com.sejong.cultureuniverse.repository.admin;

import static com.sejong.cultureuniverse.entity.admin.QNoticeBoard.noticeBoard;
import static org.springframework.util.StringUtils.hasText;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sejong.cultureuniverse.dto.NoticeBoardDetailSearchCondition;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

public class NoticeBoardRepositoryImpl implements NoticeBoardDetailsRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public NoticeBoardRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<NoticeBoard> search(NoticeBoardDetailSearchCondition condition, Pageable pageable) {

        List<NoticeBoard> content = queryFactory
            .select(noticeBoard)
            .from()
            .where(
                titleEq(condition.getTitle()),
                contentEq(condition.getContent())

                )
            .limit(pageable.getPageSize())
            .offset(pageable.getOffset())
            .orderBy(noticeBoard.noticeTitle.desc())
            .fetch();

        JPAQuery<Long> countQuery = queryFactory
            .select(noticeBoard.count())
            .from(noticeBoard)
            .where(
                titleEq(condition.getTitle()),
                contentEq(condition.getContent())
            );
        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanExpression titleEq(String title) {
        return hasText(title) ? noticeBoard.noticeTitle.contains(title) : null;

    }
    private BooleanExpression contentEq(String content) {
        return hasText(content) ? noticeBoard.noticeContent.contains(content) : null;

    }


}
