package com.sejong.cultureuniverse.repository.performances;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import com.sejong.cultureuniverse.entity.reservation.Seats;
import com.sejong.cultureuniverse.repository.reservation.SeatsRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Commit
@SpringBootTest
class SeatsRepositoryTest {
    
    @Autowired
    private PerformanceScheduleRepository scheduleRepository;
    @Autowired
    private PerformanceDetailsRepository detailsRepository;
    @Autowired
    private SeatsRepository seatsRepository;
    
//    postman localhost:9090/feign/performances/200
    @Test
    public void registerSchedule() {
        List<PerformanceDetails> detailsList = detailsRepository.findAll();
        for (PerformanceDetails performanceDetails : detailsList) {
            LocalDate startDate = performanceDetails.getStartDate().toLocalDate();
            LocalDate endDate = performanceDetails.getEndDate().toLocalDate();
            LocalTime[] scheduleTime = {LocalTime.of(13, 0), LocalTime.of(19, 0)};
            
            for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1));
                date = date.plusDays(1)) {
                
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
    public void registerSeats() {
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
    
    @Test
    public void countTest() throws Exception {
        Integer count = seatsRepository.getCountByScheduleCode(360L);
        System.out.println(count);
    }
    
    private Integer priceByRow(int row) {
        if (row < 2) {
            return 100000;
        } else if (row < 5) {
            return 80000;
        } else if (row < 8) {
            return 60000;
        } else {
            return 40000;
        }
        
    }
    
    @Test
    public void findSeatsTest() throws Exception {
        List<Seats> findSeats = seatsRepository.findSeatsByScheduleScheduleCode(
            371L);
        for (Seats findSeat : findSeats) {
            System.out.println("findSeat = " + "("+findSeat.getColNo()+","+findSeat.getRowNo()+"), price = "+ findSeat.getPrice());
        }
    }
    
}