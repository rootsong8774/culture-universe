package com.sejong.cultureuniverse.repository.reservation;

import com.sejong.cultureuniverse.entity.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
