package com.sejong.cultureuniverse.repository.reservation;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sejong.cultureuniverse.dto.QReservationRepositoryListDTO;
import com.sejong.cultureuniverse.dto.ReservationRepositoryListDTO;

import javax.persistence.EntityManager;
import java.util.List;

import static com.sejong.cultureuniverse.entity.QMember.member;
import static com.sejong.cultureuniverse.entity.reservation.QReservation.reservation;
import static com.sejong.cultureuniverse.entity.reservation.QSeats.seats;
import static com.sejong.cultureuniverse.entity.reservation.QSeatsReservation.seatsReservation;

public class ReservationRepositoryImpl implements ReservationRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ReservationRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ReservationRepositoryListDTO> getReservationList(Long reservationId) {
        return  queryFactory
                .select(new QReservationRepositoryListDTO(
                    seatsReservation.reservation.member.userIdx,
                    seatsReservation.reservation.reservationId,
                    seatsReservation.reservation.reservationDate,
                    seatsReservation.seats.seatNo,
                    seatsReservation.reservation.reservationStatus
            ))
            .from(seatsReservation)
            .leftJoin(seatsReservation.reservation, reservation)
            .leftJoin(seatsReservation.reservation.member, member)
            .leftJoin(seatsReservation.seats, seats)
            .where(getEq(reservationId))
            .fetch();
    }

    private BooleanExpression getEq(Long reservationId) {
        return seatsReservation.reservation.reservationId.eq(reservationId);
    }

}
