package com.sejong.cultureuniverse.repository.performances;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PerformanceScheduleRepository extends JpaRepository<PerformanceSchedule, Long> {
    
    List<PerformanceSchedule> findByPerformanceDetails_PerformCode(String performanceCode);
    
   
}
