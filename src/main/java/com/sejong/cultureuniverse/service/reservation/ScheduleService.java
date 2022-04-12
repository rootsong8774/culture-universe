package com.sejong.cultureuniverse.service.reservation;

import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceListDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceScheduleDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import com.sejong.cultureuniverse.mapper.PerformanceScheduleMapper;
import com.sejong.cultureuniverse.repository.performances.PerformanceScheduleRepository;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {
    
    private final PerformanceScheduleRepository scheduleRepository;
    
    public PageResultDTO<PerformanceScheduleDTO, PerformanceSchedule> getScheduleList(
        String performanceCode, PageRequestDTO pageRequestDTO) {
        
        Page<PerformanceSchedule> scheduleList = scheduleRepository.findByPerformanceDetails_PerformCode(
            performanceCode, pageRequestDTO.getPageable(Sort.by("scheduleCode").ascending()));
        
        Function<PerformanceSchedule, PerformanceScheduleDTO> fn = (PerformanceScheduleMapper.INSTANCE::scheduleToDto);
        
        return new PageResultDTO<>(scheduleList, fn);
    }
}
