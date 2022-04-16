package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.entity.event.EventComment;
import feign.Param;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventCommentRepository extends JpaRepository<EventComment, Long> {
    /*@Modifying
    @Query("delete from EventComment c where EventBoard.eventIdx =:eventIdx")
    void deleteByeventIdx(Long eventIdx);*/

    @Query(
        "select ec from EventComment ec left join fetch EventBoard e on e = ec.eventBoard"
            +
            " where ec.eventBoard.eventIdx =:eventIdx")
    List<EventComment> getCommentOrderByEventIdx(@Param("eventIdx") Long eventIdx);

    EventComment findByCommentIdx(Long id);
    List<EventComment> getEventCommentByOrderByCommentIdx(EventBoard eventBoard);

    /*@EntityGraph(attributePaths = {"member","eventBoard","eventComment"})
    List<EventComment> getEventCommentByMember_UserIdx(Long userIdx);
*/

}
