package com.sejong.cultureuniverse.repository.event;


import com.sejong.cultureuniverse.dto.admin.EventBoardDTO;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.entity.event.EventComment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository

public interface EventBoardRepository extends JpaRepository<EventBoard, Long> {
    
    @Query("select e from EventBoard e left join fetch e.admin where e.eventIdx=:eventIdx")
    EventBoard findEventBoardByEventIdx(Long eventIdx);

    @Query(value = "select e from EventBoard e left join fetch e.admin ", countQuery = "select count(e) from EventBoard e left join e.admin ")
    Page<EventBoard> findAllWithAdminId(Pageable pageable);

    void deleteByEventIdx(Long eventIdx);
}
