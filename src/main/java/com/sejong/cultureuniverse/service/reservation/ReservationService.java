package com.sejong.cultureuniverse.service.reservation;

import com.sejong.cultureuniverse.dto.ReservationRepositoryListDTO;
import com.sejong.cultureuniverse.dto.performances.SeatsDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.reservation.Reservation;
import com.sejong.cultureuniverse.entity.reservation.Seats;
import com.sejong.cultureuniverse.entity.reservation.SeatsReservation;
import com.sejong.cultureuniverse.mapper.SeatsMapper;
import com.sejong.cultureuniverse.repository.MemberRepository;
import com.sejong.cultureuniverse.repository.reservation.ReservationRepository;
import com.sejong.cultureuniverse.repository.reservation.SeatsRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    private final SeatsRepository seatsRepository;

    public List<SeatsDTO> getSeatsList(Long scheduleCode) {
        List<Seats> seatsList = seatsRepository.findSeatsByScheduleScheduleCode(
            scheduleCode);
        return seatsList.stream().map(SeatsMapper.INSTANCE::seatsToDto)
            .collect(Collectors.toList());

    }

    //SeatsNo Array 로 입력값을 받아야 함.
    @Transactional
    public Long reservation(String name, Long... seatsNos) {
        Optional<Member> findMember = memberRepository.findByName(name);
        if (findMember.isEmpty() || seatsNos.length == 0) {
            return null;
        }
        Member member = findMember.get();
        SeatsReservation[] seatsReservations = Arrays.stream(seatsNos).map(seatsNo -> {
            Optional<Seats> findSeats = seatsRepository.findById(seatsNo);
            if (findSeats.isEmpty()) {
                return null;
            }

            Seats seat = findSeats.get();
            return SeatsReservation.createSeatsReservation(seat,
                seat.getPrice());

        }).toArray(SeatsReservation[]::new);

        Reservation reservation = Reservation.createReservation(member, seatsReservations);

        reservationRepository.save(reservation);
        return reservation.getReservationId();

    }

    @Transactional
    public void cancelReservation(Long reservationId) {
        Optional<Reservation> findOrder = reservationRepository.findById(reservationId);
        findOrder.ifPresent(Reservation::cancel);
    }

    @Transactional
    public List<ReservationRepositoryListDTO> getReservation(Long reservationId) {
        return reservationRepository.getReservationList(reservationId);
    }
}
