package com.sejong.cultureuniverse.repository.performances;

import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import com.sejong.cultureuniverse.entity.performance.Seats;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SeatsRepositoryTest {
    
    @Autowired
    SeatsRepository seatsRepository;
    
    @Autowired
    PerformanceScheduleRepository scheduleRepository;
    
    @Test
    @Transactional
    @Commit
    public void seatsRegister() throws Exception {
      //given
        List<PerformanceSchedule> result = scheduleRepository.findAll();
        for (PerformanceSchedule performanceSchedule : result) {
    
            for (int i = 0; i < 10; i++) {
    
                for (int j = 0; j < 10; j++) {
                    Seats seats = Seats.builder()
                        .schedule(performanceSchedule)
                        .rowNo(i)
                        .colNo(j)
                        .price(priceByRow(i))
                        .isBooked(false)
                        .build();
                    seatsRepository.save(seats);
                }
            }
            
        }
        
        
       
       
    }
    
    private Integer priceByRow(int row) {
        if (row < 2) {
            return 100000;
        } else if (row < 5) {
            return 80000;
        } else if (row <8) {
            return 60000;
        } else {
            return 40000;
        }
        
    }
    
}