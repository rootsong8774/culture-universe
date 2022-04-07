package com.sejong.cultureuniverse.repository;


import com.sejong.cultureuniverse.dto.WinnerBoardDTO;
import com.sejong.cultureuniverse.entity.event.EventWinner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface WinnerBoardRepository extends JpaRepository<EventWinner, Long> {

    @Query(
        "select new com.sejong.cultureuniverse.dto.WinnerBoardDTO(w.winnerIdx, a.adminId, a.adminPw, w.winTitle,"
            + "w.winContent, w.readCount, w.regDate, w.modDate) from EventWinner w join w.adminId a where w.winnerIdx=:winnerIdx")
    WinnerBoardDTO findEventWinnerByWinnerIdx(Long winnerIdx);

    @Query("select w.winnerIdx, w.winTitle, w.winContent, w.readCount, w.regDate, w.modDate, a.adminId, a.adminPw"
    + " from EventWinner w left join Admin a on w.adminId = a")
    Page<Object[]> findAllWithAdminId(Pageable pageable);

    void deleteByWinnerIdx(Long winnerIdx);
}
