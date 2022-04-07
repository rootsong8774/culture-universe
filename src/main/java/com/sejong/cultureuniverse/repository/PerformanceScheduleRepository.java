package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceScheduleRepository extends JpaRepository<PerformanceSchedule, Long> {
    
    PerformanceSchedule findByPerformanceDetails(PerformanceDetails performanceDetails);
}
