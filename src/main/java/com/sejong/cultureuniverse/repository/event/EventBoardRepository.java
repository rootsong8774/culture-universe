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

public interface EventBoardRepository extends JpaRepository<EventComment, Long> {
        //쿼리문앞에 축약은 어디서 정하는지 단점은 paging이 안된다
    @Query("select ec.id"
    EventBoardDTO findEventCommentByCommentIdx(Long commentIdx);

    /*@Query("select new com.sejong.cultureuniverse.dto.admin.EventBoardDTO(e.eventIdx, a.adminId, a.adminPw,e.eventTitle,"
         +
        " e.eventContent, e.readCount, e.regDate, e.modDate) from EventComment e join e.adminId a join ec. where e.eventIdx=:eventIdx")
    EventBoardDTO findEventBoardByEventIdx(Long eventIdx);*/

    @Query("select e.eventIdx,e.eventTitle, e.eventContent, e.readCount,e.regDate, e.modDate, a.adminId, a.adminPw"
        + " from EventBoard e left join Admin a on e.adminId = a ")
    Page<Object[]> findAllWithAdminId(Pageable pageable);

    void deleteByEventIdx(Long eventIdx);
}
