package com.sejong.cultureuniverse.service.performances;

import com.sejong.cultureuniverse.dto.performances.PerformanceScheduleDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;

public interface PerformanceScheduleService {
    
    void createSchedule(PerformanceScheduleDTO dto);
    
    

}
