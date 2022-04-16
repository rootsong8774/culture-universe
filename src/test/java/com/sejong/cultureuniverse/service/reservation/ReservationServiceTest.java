package com.sejong.cultureuniverse.service.reservation;

import static org.assertj.core.api.Assertions.assertThat;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.reservation.Reservation;
import com.sejong.cultureuniverse.entity.reservation.ReservationStatus;
import com.sejong.cultureuniverse.entity.reservation.Seats;
import com.sejong.cultureuniverse.repository.MemberRepository;
import com.sejong.cultureuniverse.repository.reservation.ReservationRepository;
import com.sejong.cultureuniverse.repository.reservation.SeatsRepository;
import com.sejong.cultureuniverse.service.reservation.ReservationService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ReservationServiceTest {
    
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    SeatsRepository seatsRepository;
    @Autowired
    ReservationService reservationService;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ReservationService reservationServices;
    @Autowired
    EntityManager em;


//    @Test
//    @Transactional
//    public void reservationTest() throws Exception {
//        //given
//        Long reservationId1 = reservationService.reservation(1L, 1L);
//        Long reservationId2 = reservationService.reservation(1L, 2L);
//
//        Seats seats1 = seatsRepository.findById(1L).get();
//        Seats seats2 = seatsRepository.findById(2L).get();
//
//        Optional<Reservation> findReservation1 = reservationRepository.findById(reservationId1);
//        Optional<Reservation> findReservation2 = reservationRepository.findById(reservationId2);
//        Reservation res1 = new Reservation();
//        Reservation res2 = new Reservation();
//
//        if (findReservation1.isPresent() && findReservation2.isPresent()) {
//            res1 = findReservation1.get();
//            res2 = findReservation2.get();
//        }
//
//        assertThat(res1.getReservationStatus()).isEqualTo(ReservationStatus.BOOKED);
//        assertThat(res2.getReservationStatus()).isEqualTo(ReservationStatus.BOOKED);
//        assertThat(seats1.getIsBooked()).isEqualTo(true);
//        assertThat(seats2.getIsBooked()).isEqualTo(true);
//    }
    
//    @Test
//    @Transactional
//    public void cancelTest() throws Exception {
//      //given
//
//        Long reservationId1 = reservationService.reservation(1L, 3L);
//        Long reservationId2 = reservationService.reservation(1L, 4L);
//
//        emClear();
//
//        Seats seat1 = seatsRepository.findById(3L).get();
//        Seats seat2 = seatsRepository.findById(4L).get();
//
//        //when
//        reservationService.cancelReservation(reservationId1);
//        emClear();
//        //then
//        Reservation reservation1 = reservationRepository.findById(reservationId1).get();
//        Reservation reservation2 = reservationRepository.findById(reservationId2).get();
//
//        assertThat(reservation1.getReservationStatus()).isEqualTo(ReservationStatus.CANCEL);
//        assertThat(reservation2.getReservationStatus()).isEqualTo(ReservationStatus.BOOKED);
//        assertThat(seat1.getIsBooked()).isEqualTo(false);
//        assertThat(seat2.getIsBooked()).isEqualTo(true);
//
//
//
//    }
    
//    @Test
//    @Transactional
//    @Commit
//    public void seatsReservationTest() throws Exception {
//        List<Seats> seats = seatsRepository.findSeatsByScheduleScheduleCode(
//            100L);
//        Optional<Member> findMember = memberRepository.findById(1L);
//        if (findMember.isEmpty()) {
//            return;
//        }
//        Member member = findMember.get();
//        for (Seats seat : seats) {
//            System.out.println("seat = " + seat.getSeatNo());
//        }
//        Long[] seatNosArray ={seats.get(0).getSeatNo(), seats.get(1).getSeatNo()};
//        reservationServices.reservation(member.getUsername(),
//            seatNosArray);
//
//    }
    
    private void emClear() {
        em.flush();
        em.clear();
    }
    
    
    
}