package com.sejong.cultureuniverse.repository;


import com.sejong.cultureuniverse.entity.event.EventBoard;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventBoardRepository extends JpaRepository<EventBoard, Long> {
    EventBoard findByEventIdx(Long eventIdx);

    void deleteByEventIdx(Long eventIdx);
}
