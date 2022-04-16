package com.sejong.cultureuniverse.repository.performances;

import static com.sejong.cultureuniverse.entity.performance.QPerformanceDetails.performanceDetails;
import static org.springframework.util.StringUtils.hasText;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsSearchCondition;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.format.datetime.DateFormatter;

public class PerformanceDetailsRepositoryImpl implements PerformanceDetailsRepositoryCustom {
    
    private final JPAQueryFactory queryFactory;
    
    public PerformanceDetailsRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    
    @Override
    public Page<PerformanceDetails> search(PerformanceDetailsSearchCondition condition,
        Pageable pageable) {
        
        List<PerformanceDetails> content = queryFactory
            .select(performanceDetails)
            .from(performanceDetails)
            .where(
                titleEq(condition.getTitle()),
                genreEq(condition.getGenreList()),
                placeEq(condition.getPlaceList()),
                endDateAfterDateRangeStart(condition.getDateRangeStart()),
                startDateBeforeDateRangeEnd(condition.getDateRangeEnd())
            )
            .limit(pageable.getPageSize())
            .offset(pageable.getOffset())
            .orderBy(performanceDetails.startDate.desc())
            .fetch();
        
        JPAQuery<Long> countQuery = queryFactory
            .select(performanceDetails.count())
            .from(performanceDetails)
            .where(
                titleEq(condition.getTitle()),
                genreEq(condition.getGenreList()),
                placeEq(condition.getPlaceList()),
                endDateAfterDateRangeStart(condition.getDateRangeStart()),
                startDateBeforeDateRangeEnd(condition.getDateRangeEnd())
            );
        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }
    
    private BooleanExpression titleEq(String title) {
        return hasText(title) ? performanceDetails.title.contains(title) : null;
    }
    
    private BooleanExpression genreEq(String[] genre) {
        return genre!=null ? performanceDetails.genreName.in(genre) : null;
    }
    
    private BooleanExpression placeEq(String[] place) {
        return place!=null ? performanceDetails.placeName.in(place) : null;
    }
    
    private BooleanExpression endDateAfterDateRangeStart(String dateRangeStart) {
        
        return hasText(dateRangeStart) ? performanceDetails.endDate.after(LocalDate.parse(dateRangeStart,DateTimeFormatter.ISO_DATE).minusDays(1).atStartOfDay()): null;
    }
    
    private BooleanExpression startDateBeforeDateRangeEnd(String dateRangeEnd) {
        return hasText(dateRangeEnd) ? performanceDetails.startDate.before(
            LocalDate.parse(dateRangeEnd,DateTimeFormatter.ISO_DATE).plusDays(1).atStartOfDay()) : null;
    }
}
