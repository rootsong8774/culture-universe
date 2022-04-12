package com.sejong.cultureuniverse.dto.performances;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerformanceScheduleDTO {
    
    
    private String performCode;
    private Long scheduleCode;
    
    private LocalDate scheduleDate;
    private LocalTime scheduleTime;
    
    
    
    
}
