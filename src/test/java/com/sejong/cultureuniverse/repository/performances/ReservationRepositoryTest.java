package com.sejong.cultureuniverse.repository.performances;

import static org.junit.jupiter.api.Assertions.*;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import com.sejong.cultureuniverse.entity.performance.Seats;
import com.sejong.cultureuniverse.repository.MemberRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class ReservationRepositoryTest {
    
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    SeatsRepository seatsRepository;
    @Autowired
    PerformanceScheduleRepository scheduleRepository;
    @Autowired
    PerformanceDetailsRepository detailsRepository;
    
    @Test
    @Transactional
    public void reservationTest() throws Exception {
        Optional<Member> member = memberRepository.findById(1L);
        Optional<PerformanceDetails> details = detailsRepository.findByPerformCode(
            "acpm2203141110a01");
        if (member.isPresent() & details.isPresent()) {
            Member member1 = member.get();
            PerformanceDetails details1 = details.get();
            List<LocalDate> scheduleDateList = scheduleRepository.findScheduleDateByPerformanceDetails(
                details1);
    
        }
    }
}