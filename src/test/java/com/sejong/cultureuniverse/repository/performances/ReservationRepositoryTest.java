package com.sejong.cultureuniverse.repository.performances;

import static com.sejong.cultureuniverse.entity.QMember.member;
import static com.sejong.cultureuniverse.entity.performance.QPerformanceDetails.performanceDetails;
import static com.sejong.cultureuniverse.entity.performance.QPerformanceSchedule.performanceSchedule;
import static com.sejong.cultureuniverse.entity.reservation.QSeats.seats;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.repository.MemberRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class ReservationRepositoryTest {
    
    JPAQueryFactory queryFactory;
    @Autowired
    EntityManager em;
    
    @Test
    @Transactional
    public void reservationTest() throws Exception {
    
            queryFactory = new JPAQueryFactory(em);
    
        Member findMember = queryFactory.selectFrom(member)
            .where(member.userIdx.eq(1L))
            .fetchOne();
        PerformanceDetails findDetails = queryFactory.selectFrom(performanceDetails)
            .where(performanceDetails.performCode.eq("acpm2203141110a01"))
            .fetchOne();
    
        List<LocalDate> scheduleDate = queryFactory.select(performanceSchedule.scheduleDate)
            .from(performanceSchedule)
            .where(performanceSchedule.performanceDetails.eq(findDetails))
            .fetch();
    
        List<LocalTime> scheduleTime = queryFactory.select(performanceSchedule.scheduleTime)
            .from(performanceSchedule)
            .where(performanceSchedule.performanceDetails.eq(findDetails),
                performanceSchedule.scheduleDate.eq(scheduleDate.get(1)))
            .fetch();
    
        Long schedule = queryFactory.select(performanceSchedule.scheduleCode)
            .from(performanceSchedule)
            .where(performanceSchedule.performanceDetails.eq(findDetails),
                performanceSchedule.scheduleDate.eq(scheduleDate.get(1)),
                performanceSchedule.scheduleTime.eq(scheduleTime.get(1)))
            .fetchOne();
    
        List<Long> seatsNos = queryFactory.select(seats.seatNo)
            .from(seats)
            .where(seats.schedule.scheduleCode.eq(schedule))
            .fetch();
        for (Long seatsNo : seatsNos) {
            System.out.println("seatsNo = " + seatsNo);
        }
        
        
    }
}