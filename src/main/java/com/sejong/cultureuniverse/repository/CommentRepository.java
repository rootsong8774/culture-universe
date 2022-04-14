package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.entity.event.EventComment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<EventComment, Long> {
    @Modifying
    @Query("delete from EventComment c where EventBoard.eventIdx =:eventIdx")
    void deleteByeventIdx(Long eventIdx);
    List<EventComment> getRepliesByBoardOrderByCno(EventBoard eventBoard);

}
