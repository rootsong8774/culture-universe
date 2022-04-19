package com.sejong.cultureuniverse.repository.reservation;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sejong.cultureuniverse.dto.QReservationRepositoryListDTO;
import com.sejong.cultureuniverse.dto.ReservationRepositoryListDTO;

import javax.persistence.EntityManager;
import java.util.List;

import static com.sejong.cultureuniverse.entity.reservation.QReservation.reservation;
import static com.sejong.cultureuniverse.entity.reservation.QSeatsReservation.seatsReservation;

public class ReservationRepositoryImpl implements ReservationRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ReservationRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ReservationRepositoryListDTO> getReservationList(Long reservationId) {
        return queryFactory
            .select(new QReservationRepositoryListDTO(
                seatsReservation.reservation.reservationId,
                seatsReservation.reservation.reservationDate,
                seatsReservation.sr_no,
                seatsReservation.reservation.reservationStatus
            ))
            .from(seatsReservation)
            .leftJoin(seatsReservation.reservation,reservation )
            .where(seatsReservation.reservation.reservationId.eq(reservationId))
            .fetch();
    }
}
