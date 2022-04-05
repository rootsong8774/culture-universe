package com.sejong.cultureuniverse.repository;


import com.sejong.cultureuniverse.entity.event.EventWinner;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WinnerBoardRepository extends JpaRepository<EventWinner, Long> {
    EventWinner findByWinnerIdx(Long winnerIdx);

    void deleteByWinnerIdx(Long winnerIdx);
}
