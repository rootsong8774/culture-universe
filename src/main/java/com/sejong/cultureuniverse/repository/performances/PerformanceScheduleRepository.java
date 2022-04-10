package com.sejong.cultureuniverse.repository.performances;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PerformanceScheduleRepository extends JpaRepository<PerformanceSchedule, Long> {
    
    @Query("select distinct s.scheduleDate from PerformanceSchedule s order by s.scheduleDate asc ")
    List<LocalDate> findScheduleDateByPerformanceDetails(PerformanceDetails performanceDetails);
    
   
}
