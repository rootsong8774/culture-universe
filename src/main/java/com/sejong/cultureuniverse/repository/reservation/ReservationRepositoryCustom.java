package com.sejong.cultureuniverse.repository.reservation;

import com.sejong.cultureuniverse.dto.ReservationRepositoryListDTO;

import java.util.List;

public interface ReservationRepositoryCustom {
    List<ReservationRepositoryListDTO> getReservationList(Long reservationId);
}
