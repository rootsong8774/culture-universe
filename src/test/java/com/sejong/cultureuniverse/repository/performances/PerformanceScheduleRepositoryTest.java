package com.sejong.cultureuniverse.repository.performances;

import static org.assertj.core.api.Assertions.assertThat;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import java.time.LocalTime;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class PerformanceScheduleRepositoryTest {
    
    @Autowired
    private PerformanceDetailsRepository detailsRepository;
    
    @Autowired
    private PerformanceScheduleRepository scheduleRepository;
    
    @Autowired
    EntityManager em;
    
    
    @Test
    public void mapperTest() throws Exception {
        PerformanceDetails details = detailsRepository.findByPerformId(1L);
        
        PerformanceSchedule schedule = PerformanceSchedule.builder()
            .performanceDetails(details)
            .scheduleDate(details.getStartDate().toLocalDate())
            .scheduleTime(LocalTime.of(13, 0))
            .build();
        
        
    }
    
    @Test
    public void findScheduleTest() throws Exception {
        //given
        Page<PerformanceSchedule> schedules = scheduleRepository.findByPerformanceDetails_PerformCode(
            "chpi2202151923a01", PageRequest.of(1, 12));
        //when
        for (PerformanceSchedule schedule : schedules) {
            System.out.println("schedule.getScheduleDate() = " + schedule.getScheduleDate());
        }
        //then
    }
   
   
    
}