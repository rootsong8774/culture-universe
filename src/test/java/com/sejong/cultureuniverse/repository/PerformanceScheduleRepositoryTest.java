package com.sejong.cultureuniverse.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class PerformanceScheduleRepositoryTest {
    
    @Autowired
    private PerformanceDetailsRepository detailsRepository;
    @Autowired
    private PerformanceScheduleRepository scheduleRepository;
    
    @Test
    @Transactional
    public void registerTest() throws Exception {
        List<PerformanceDetails> detailsList = LongStream.rangeClosed(1L, 150L)
            .mapToObj(i -> detailsRepository.findByPerformId(i)).collect(
                Collectors.toList());
        for (PerformanceDetails performanceDetails : detailsList) {
            LocalDateTime startDate = performanceDetails.getStartDate();
            LocalDateTime endDate = performanceDetails.getEndDate();
    
            PerformanceSchedule result = scheduleRepository.findByPerformanceDetails(
                performanceDetails);
            LocalDateTime ldt;
            for (ldt = startDate; ldt.equals(endDate); ldt.plusDays(1)) {
                result.setScheduleDate(ldt.toLocalDate());
                result.setScheduleTime(ldt.toLocalTime().withHour(13));
                scheduleRepository.save(result);
                result.setScheduleDate(ldt.toLocalDate());
                result.setScheduleTime(ldt.toLocalTime().withHour(16));
                scheduleRepository.save(result);
            }
            
        }
    }
    
}