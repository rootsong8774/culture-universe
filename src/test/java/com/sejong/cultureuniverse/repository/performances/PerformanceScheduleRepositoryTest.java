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
    private PerformanceScheduleRepository scheduleRepository;
    @Autowired
    EntityManager em;
    
    @Test
    public void registerTest() throws Exception {
        List<PerformanceDetails> detailsList = detailsRepository.findAll();
        for (PerformanceDetails performanceDetails : detailsList) {
            LocalDate startDate = performanceDetails.getStartDate().toLocalDate();
            LocalDate endDate = performanceDetails.getEndDate().toLocalDate();
            LocalTime[] scheduleTime = {LocalTime.of(13, 0), LocalTime.of(19, 0)};

            for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
                
                for (int j = 0; j <= 1; j++) {
                    PerformanceSchedule schedule = PerformanceSchedule.builder()
                        .performanceDetails(performanceDetails)
                        .scheduleDate(date)
                        .scheduleTime(scheduleTime[j])
                        .build();
                    scheduleRepository.save(schedule);
                }
            }
        }
        
    }
    
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