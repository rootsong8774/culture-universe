package com.sejong.cultureuniverse.service.reservation;

import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceScheduleDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import com.sejong.cultureuniverse.mapper.PerformanceScheduleMapper;
import com.sejong.cultureuniverse.repository.performances.PerformanceScheduleRepository;
import com.sejong.cultureuniverse.repository.reservation.SeatsRepository;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {
    
    private final PerformanceScheduleRepository scheduleRepository;
    private final SeatsRepository seatsRepository;
    
    public PageResultDTO<PerformanceScheduleDTO, PerformanceSchedule> getScheduleList(
        String performanceCode, PageRequestDTO pageRequestDTO) {
        
        Page<PerformanceSchedule> scheduleList = scheduleRepository.findByPerformanceDetails_PerformCode(
            performanceCode, pageRequestDTO.getPageable(Sort.by("scheduleCode").ascending()));
        
        
        Function<PerformanceSchedule, PerformanceScheduleDTO> fn = (en ->
            PerformanceScheduleMapper.INSTANCE.scheduleToDto(en, seatsRepository));
        
        return new PageResultDTO<>(scheduleList, fn);
    }
}
