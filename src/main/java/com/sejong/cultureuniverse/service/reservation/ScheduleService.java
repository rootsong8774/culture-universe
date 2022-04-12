package com.sejong.cultureuniverse.service.reservation;

import com.sejong.cultureuniverse.dto.performances.PerformanceScheduleDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import com.sejong.cultureuniverse.mapper.PerformanceScheduleMapper;
import com.sejong.cultureuniverse.repository.performances.PerformanceScheduleRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {
    
    private final PerformanceScheduleRepository scheduleRepository;
    
    public List<PerformanceScheduleDTO> getScheduleList(String performanceCode) {
        List<PerformanceSchedule> scheduleByPerformCode = scheduleRepository.findByPerformanceDetails_PerformCode(
            performanceCode);
    
        return scheduleByPerformCode.stream()
            .map(PerformanceScheduleMapper.INSTANCE::scheduleToDto).collect(
                Collectors.toList());
    }
}
