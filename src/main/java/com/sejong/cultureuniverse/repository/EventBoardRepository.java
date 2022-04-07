package com.sejong.cultureuniverse.repository;


import com.sejong.cultureuniverse.dto.EventBoardDTO;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EventBoardRepository extends JpaRepository<EventBoard, Long> {

    @Query("select new com.sejong.cultureuniverse.dto.EventBoardDTO(e.eventIdx, a.adminId, a.adminPw,e.eventTitle,"
         +
        " e.eventContent, e.readCount, e.regDate, e.modDate) from EventBoard e join e.adminId a where e.eventIdx=:eventIdx")
    EventBoardDTO findEventBoardByEventIdx(Long eventIdx);

    @Query("select e.eventIdx,e.eventTitle, e.eventContent, e.readCount,e.regDate, e.modDate, a.adminId, a.adminPw"
        + " from EventBoard e left join Admin a on e.adminId = a ")
    Page<Object[]> findAllWithAdminId(Pageable pageable);

    void deleteByEventIdx(Long eventIdx);
}
