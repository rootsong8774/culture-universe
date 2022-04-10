package com.sejong.cultureuniverse.repository.performances;

import com.sejong.cultureuniverse.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
