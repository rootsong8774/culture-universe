package com.sejong.cultureuniverse.repository.event;


import com.sejong.cultureuniverse.dto.admin.WinnerBoardDTO;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.entity.event.EventWinner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;


public interface WinnerBoardRepository extends JpaRepository<EventWinner, Long> ,
    QuerydslPredicateExecutor<EventWinner> {

    @Query(
        "select w from EventWinner w left join fetch w.admin where w.winnerIdx=:winnerIdx")
    EventWinner findEventWinnerByWinnerIdx(@Param("winnerIdx") Long winnerIdx);

    @Query(value = "select w from EventWinner w left join fetch w.admin", countQuery = "select count(w) from EventWinner w left join w.admin")
    Page<EventWinner> findAllWithAdminId(Pageable pageable);

    void deleteByWinnerIdx(Long winnerIdx);
}
