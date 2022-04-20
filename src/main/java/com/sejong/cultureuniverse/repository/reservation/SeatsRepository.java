package com.sejong.cultureuniverse.repository.reservation;

import com.sejong.cultureuniverse.entity.reservation.Seats;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SeatsRepository extends JpaRepository<Seats, Long> {
    
    @Query(value = "select count(s) from Seats s where s.schedule.scheduleCode= :scheduleCode and s.isBooked = false ")
    Integer getCountByScheduleCode(@Param("scheduleCode") Long scheduleCode);
    
    List<Seats> findSeatsByScheduleScheduleCode(Long scheduleCode);
}
