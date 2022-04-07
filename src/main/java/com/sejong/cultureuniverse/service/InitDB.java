package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.repository.PerformanceScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class InitDB {
    
    
    @Component
    @RequiredArgsConstructor
    static class InitService {
        
        private final PerformanceScheduleRepository performanceScheduleRepository;
    
        public void registerSchedule() {
        
        }
    }
}
