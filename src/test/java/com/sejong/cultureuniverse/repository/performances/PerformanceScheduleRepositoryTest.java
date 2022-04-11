package com.sejong.cultureuniverse.repository.performances;

import static org.assertj.core.api.Assertions.assertThat;

import com.sejong.cultureuniverse.dto.performances.PerformanceScheduleDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import com.sejong.cultureuniverse.mapper.PerformanceScheduleMapper;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PerformanceScheduleRepositoryTest {
    
    @Autowired
    private PerformanceDetailsRepository detailsRepository;
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
        
        PerformanceScheduleDTO result = PerformanceScheduleMapper.INSTANCE.scheduleToDto(schedule);
        PerformanceSchedule result2 = PerformanceScheduleMapper.INSTANCE.dtoToSchedule(
            result);
        assertThat(result.getPerformId()).isEqualTo(details.getPerformId());
        assertThat(result.getScheduleCode()).isEqualTo(schedule.getScheduleCode());
        assertThat(result.getScheduleDate()).isEqualTo(details.getStartDate().toLocalDate());
        assertThat(result.getScheduleTime()).isEqualTo(LocalTime.of(13, 0));
        
        assertThat(result2.getScheduleCode()).isEqualTo(schedule.getScheduleCode());
        assertThat(result2.getScheduleDate()).isEqualTo(schedule.getScheduleDate());
        assertThat(result2.getScheduleTime()).isEqualTo(schedule.getScheduleTime());
        
        
    }
    
}