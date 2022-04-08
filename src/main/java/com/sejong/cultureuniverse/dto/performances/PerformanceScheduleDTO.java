package com.sejong.cultureuniverse.dto.performances;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerformanceScheduleDTO {
    
    
    private Long performId;
    
    private LocalDateTime scheduleDate;
    private LocalDateTime scheduleTime;
    
    
    
}
